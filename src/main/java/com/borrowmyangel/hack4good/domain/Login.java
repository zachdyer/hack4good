package com.borrowmyangel.hack4good.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Logins")
public class Login {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer lid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User uid;

    @Column(columnDefinition="DATETIME")
    private Date date_created;

    @Column(columnDefinition="VARCHAR(128)")
    private String token;

    @Column(columnDefinition="BOOLEAN")
    private Boolean valid;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid (Boolean valid) {
        this.valid = valid;
    }
}
