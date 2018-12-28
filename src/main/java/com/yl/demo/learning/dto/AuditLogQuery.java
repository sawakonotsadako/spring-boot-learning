package com.yl.demo.learning.dto;

import lombok.Data;

@Data
public class AuditLogQuery {
    Long id;
    String keyword;
    String type;
    String operationTime;
    String sortBy;
    String sortOrder;
    Integer pageNo;
    Integer pageSize;
}
