package com.zq.play.note.note.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="username")
    private  String username;
    @Column(name="password")
    private  String password;
    @Column(name="sendmail")
    private  String sendMail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }
}
