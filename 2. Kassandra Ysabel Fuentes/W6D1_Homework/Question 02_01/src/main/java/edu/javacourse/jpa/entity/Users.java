package edu.javacourse.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERS_ID")
    private Integer usersId;
    @Column(name = "USERS_NAME")
    private String usersName;

    public Users() {
    }

    public Users(Integer USERS_ID) {
        this.usersId = USERS_ID;
    }

    public Users(Integer USERS_ID, String USERS_NAME) {
        this.usersId = USERS_ID;
        this.usersName = USERS_NAME;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer cityId) {
        this.usersId = cityId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setCityName(String usersName) {
        this.usersName = usersName;
    }
}
