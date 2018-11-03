package com.borrowmyangel.hack4good.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Sessions")
public class Session{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer sid;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User pin;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User angel;

    @Column(columnDefinition="ENUM")
    private Session_Type session_type;

    @Column(columnDefinition="ENUM")
    private Status status;

    @Column(columnDefinition="TIMESTAMP")
    private Timestamp date_created;

    @Column(columnDefinition="TIMESTAMP")
    private Timestamp date_ended;

    @Column(columnDefinition="TIMESTAMP")
    private Timestamp date_started;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public User getPin() {
        return pin;
    }

    public void setPin(User pin) {
        this.pin = pin;
    }

    public User getAngel() {
        return angel;
    }

    public void setAngel(User angel) {
        this.angel = angel;
    }

    public Session_Type getSession_type() {
        return session_type;
    }

    public void setSession_type(Session_Type session_type) {
        this.session_type = session_type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDate_ended() {
        return date_ended;
    }

    public void setDate_ended(Timestamp date_ended) {
        this.date_ended = date_ended;
    }

    public Timestamp getDate_started() {
        return date_started;
    }

    public void setDate_started(Timestamp date_started) {
        this.date_started = date_started;
    }

    public enum Session_Type {
        Talk, Text;
    }

    public enum Status {
        Waiting, Failed, Cancelled, Finished, In_Progress;
    }
}