package com.borrowmyangel.hack4good.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Applications")
public class Application {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer aid;

    @Column(columnDefinition="VARCHAR(128)")
    private String lname;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @Column(columnDefinition="VARCHAR(256)")
    private String address;

    @Column(columnDefinition="CHAR(11)")
    private String phone;

    @Column(columnDefinition="VARCHAR(1024)")
    private String reason;

    @Column(columnDefinition="VARCHAR(1024)")
    private String experience;

    @Column(columnDefinition="VARCHAR(1024)")
    private String volunteering;

    @Column(columnDefinition="VARCHAR(1024)")
    private String refs;

    @Column(columnDefinition="BOOLEAN")
    private Boolean permit_bgc;

    @Column(columnDefinition="VARCHAR(1024)")
    private String criminal_history;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getVolunteering() {
        return volunteering;
    }

    public void setVolunteering(String volunteering) {
        this.volunteering = volunteering;
    }

    public String getRefs() {
        return refs;
    }

    public void setRefs(String refs) {
        this.refs = refs;
    }

    public Boolean getPermit_bgc() {
        return permit_bgc;
    }

    public void setPermit_bgc(Boolean permit_bgc) {
        this.permit_bgc = permit_bgc;
    }

    public String getCriminal_history() {
        return criminal_history;
    }

    public void setCriminal_history(String criminal_history) {
        this.criminal_history = criminal_history;
    }

}
