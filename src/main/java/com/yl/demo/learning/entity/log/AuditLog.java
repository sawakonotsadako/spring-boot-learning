package com.yl.demo.learning.entity.log;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_audit_log")
public class AuditLog implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "operator_ip")
    private String operatorIp;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "operation_status")
    private String operationStatus;

    @Column(name = "operation_desc")
    private String operationDescription;

    @Column(name = "operation_info")
    private String operationInfo;

    @Column(name = "operation_exception_msg")
    private String operationExMsg;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "operation_exception", columnDefinition = "BLOB")
    private String operationException;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "operation_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
    private Date operationTime;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
    private Date createdDate;

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "update_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
    private Date updatedDate;

}
