package com.yl.demo.learning.controller;

import com.yl.demo.learning.constant.staticfinal.ApiEndpoint;
import com.yl.demo.learning.dto.AuditLogQuery;
import com.yl.demo.learning.response.api.ApiResponse;
import com.yl.demo.learning.service.AuditLogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@Api(value = "Log Portal")
@CrossOrigin(origins = "http://localhost:4200")
public class LogController {

    @Autowired
    private AuditLogService auditLogService;

    @RequestMapping(value = ApiEndpoint.GET_AUDITlOGS, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public ApiResponse<?> getAuditLogs(@RequestParam(required = false) String keyword,
                                       @RequestParam(required = false) String type,
                                       @RequestParam(value = "operation_time", required = false) String operationTime,
                                       @RequestParam(value = "sort_by", required = false, defaultValue = "operationTime") String sortBy,
                                       @RequestParam(value = "sort_order", required = false, defaultValue = "desc") String sortOrder,
                                       @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                       @RequestParam(value = "items_per_page", required = false, defaultValue = "10") Integer itemsPerPage) throws Exception{
        Sort.Direction direction = Sort.Direction.DESC;
        if (sortOrder.equals("asc")) {
            direction = Sort.Direction.ASC;
        }
        Pageable pageable = PageRequest.of(page, itemsPerPage, new Sort(direction, sortBy));

        return new ApiResponse<Object>(auditLogService.getAuditLogs(pageable, new AuditLogQuery()), HttpStatus.OK, ApiEndpoint.GET_AUDITlOGS);
    }

}
