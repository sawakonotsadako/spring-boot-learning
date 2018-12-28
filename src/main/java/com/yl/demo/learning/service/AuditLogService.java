package com.yl.demo.learning.service;

import com.yl.demo.learning.dto.AuditLogQuery;
import com.yl.demo.learning.entity.log.AuditLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuditLogService {
    void insert(AuditLog auditLog);

    Page<AuditLog> getAuditLogs(Pageable pageable, AuditLogQuery auditLogQuery);
}
