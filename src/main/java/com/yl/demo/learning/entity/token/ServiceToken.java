package com.yl.demo.learning.entity.token;

import com.yl.demo.learning.utils.DateUtil;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Data
@Entity
@Table(name = "tbl_service_token")
@NamedQueries({
        @NamedQuery(name = "ServiceToken.getByToken", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.token = :token "),
        @NamedQuery(name = "ServiceToken.getByInfoType", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.info = :info AND t.type = :type ORDER BY t.dateAccomplished DESC "),
        @NamedQuery(name = "ServiceToken.getByInfoTypeLike", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.info LIKE :info AND t.type = :type ORDER BY t.dateAccomplished DESC "),
        @NamedQuery(name = "ServiceToken.getByType", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.type = :type ORDER BY t.dateAccomplished DESC "),
        @NamedQuery(name = "ServiceToken.getByUserType", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.userId = :userId AND t.type = :type "),
        @NamedQuery(name = "ServiceToken.getByUserTypeList", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.userId = :userId AND t.type IN :typeList "),
        @NamedQuery(name = "ServiceToken.getById", query = "SELECT t FROM ServiceToken t "
                + " WHERE t.id = :id ") })
public class ServiceToken implements Serializable{
    private static final long serialVersionUID = -3586828742666409099L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "date_accomplished")
    private String dateAccomplished;

    @Column(name = "user_id")
    private Long userId;

    private String info;

    private Integer type;

    @Transient
    private final String link = "?token=";

    /**
     *
     */
    public ServiceToken() throws Exception {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bSalt = new byte[256];
            random.nextBytes(bSalt);
            this.token = Base64.encodeBase64String(bSalt);
            this.createdDate = DateUtil.now().toString();
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }

    }
}
