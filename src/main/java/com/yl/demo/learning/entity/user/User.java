package com.yl.demo.learning.entity.user;


import com.yl.demo.learning.constant.enumeration.AccountStatus;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private AccountStatus accountStatus;

    @OneToMany
    @JoinTable(name="tbl_user_role",
            joinColumns={ @JoinColumn(name="user_id",referencedColumnName="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="role_id")})
    private Set<Role> roleSet;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleSet;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !(AccountStatus.EXPIRED == accountStatus);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !(AccountStatus.LOCKED == accountStatus);
    }

    @Override
    public boolean isCredentialsNonExpired() { return !(AccountStatus.CREDENTIAL_EXPIRED == accountStatus); }

    @Override
    public boolean isEnabled() {
        return AccountStatus.ENABLED == accountStatus;
    }

    public boolean isBeingUsed() { return AccountStatus.LOGINED == accountStatus;}

    public boolean isRegistered() { return AccountStatus.REGISTERED == accountStatus; }

    public boolean isAccountExpired() { return AccountStatus.EXPIRED == accountStatus; }

    public boolean isAccountLocked() { return AccountStatus.LOCKED == accountStatus; }

    public boolean isCredentialsExpired() { return AccountStatus.CREDENTIAL_EXPIRED == accountStatus; }
}
