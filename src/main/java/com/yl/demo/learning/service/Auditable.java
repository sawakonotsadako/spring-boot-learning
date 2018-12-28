package com.yl.demo.learning.service;

import com.yl.demo.learning.entity.log.AuditLog;

public interface Auditable {

    public void audit(AuditLog auditLog, String message);

}
