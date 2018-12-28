package com.yl.demo.learning.config.websecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private String authorization = "Authorization"; // TODO should set into properties file

    private String head = "Bearer "; //TODO should set into properties file

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            String auth = httpServletRequest.getHeader(authorization);

            if (null == auth || !auth.startsWith(head)) {
                log.info(String.format("Request don't have bearer token or not starts with '%s'", head));
            } else {
                String token = auth.replace(head, "");
                log.info("Token received:"+token);
                String username = jwtHelper.getUsername(token);
                log.info("Username"+username);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                if (jwtHelper.validate(token, userDetails)) {
                    log.info("Token and user details validation pass, setting authentication into security context");
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        } catch (Exception e) {
            log.info("Authentication exception occurs:" + e.getMessage());
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpServletResponse.getWriter().write(e.getMessage());
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
