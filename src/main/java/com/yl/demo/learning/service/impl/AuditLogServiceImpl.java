package com.yl.demo.learning.service.impl;

import com.yl.demo.learning.dto.AuditLogQuery;
import com.yl.demo.learning.entity.log.AuditLog;
import com.yl.demo.learning.repository.AuditLogRepository;
import com.yl.demo.learning.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public void insert(AuditLog auditLog) {
        auditLogRepository.save(auditLog);
    }

    @Override
    public Page<AuditLog> getAuditLogs(Pageable pageable, AuditLogQuery auditLogQuery) {
        Specification<AuditLog> specification = (Specification<AuditLog>) (root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (null != auditLogQuery.getKeyword() && !"".equals(auditLogQuery.getKeyword().trim())) {
                list.add(cb.like(root.get("operationInfo"), "%"+auditLogQuery.getKeyword()+"%"));
            }
            if (null != auditLogQuery.getType() && !"".equals(auditLogQuery.getType().trim())) {
                list.add(cb.equal(root.get("operationType"), auditLogQuery.getType()));
            }
            if (null != auditLogQuery.getOperationTime() && !"".equals(auditLogQuery.getOperationTime().trim())) {
                list.add(cb.equal(root.get("operationTime"), new Date(auditLogQuery.getOperationTime())));
            }
            return cq.where(list.toArray(new Predicate[list.size()])).getRestriction();
        };
        return auditLogRepository.findAll(specification, pageable);
    }
}
