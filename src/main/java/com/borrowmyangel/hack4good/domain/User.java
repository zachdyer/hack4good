package com.borrowmyangel.hack4good.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer uid;

    @Column(columnDefinition="VARCHAR(128)")
    private String email;

    @Column(columnDefinition="VARCHAR(64)")
    private String username;

    @Column(columnDefinition="VARCHAR(128)")
    private String fname;

    @Column(columnDefinition="VARCHAR(128)")
    private String nickname;

    @Column(columnDefinition="INTEGER")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM")
    private Gender gender;

    @Column(columnDefinition="VARCHAR(256)")
    private String city;

    @Column(columnDefinition="CHAR(2)")
    private String state;

    @Column(columnDefinition="VARCHAR(128)")
    private String password_hash;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM")
    private Account_Type account_type;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM")
    private Angel_Status angel_status;

    @Column(columnDefinition="TIMESTAMP")
    private Timestamp date_created;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "session")
    private Session session;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "application")
    private Application application;

    @OneToMany()
    private List<Login> logins = new ArrayList<Login>();

    @OneToMany()
    private List<Session> sessions = new ArrayList<Session>();

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer id) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Account_Type getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Account_Type account_type) {
        this.account_type = account_type;
    }

    public Angel_Status getAngel_status() {
        return angel_status;
    }

    public void setAngel_status(Angel_Status angel_status) {
        this.angel_status = angel_status;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public enum Gender {
        MALE, FEMALE, NONBINARY;
    }

    public enum Account_Type {
        ANGEL, PERSON_IN_NEED, ALLY, ADMIN;
    }

    public enum Angel_Status {
        AVAILABLE, UNAVAILABLE, DND, PENDING;
    }
}
