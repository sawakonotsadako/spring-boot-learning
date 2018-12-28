package com.yl.demo.learning.dto;

import lombok.Data;

@Data
public class IUserQuery {
    Long id;
    String name;
    String email;
    String sortBy;
    String sortOrder;
    Integer pageNo;
    Integer pageSize;
}
