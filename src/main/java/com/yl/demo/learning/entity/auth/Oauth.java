package com.yl.demo.learning.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_oauth")
public class Oauth implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oauth_name")
    private String oauthName;

    @Column(name = "oauth_id")
    private String oauthId;

    @Column(name = "oauth_access_token")
    private String oauthAccessToken;

    @Column(name = "oauth_expires")
    private String oauthExpires;

    @Column(name = "user_id")
    private String userId;
}
