package com.oocl.mnlbc.entity;

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

/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERS_ID")
    private Integer usersId;
    @Column(name = "USERS_NAME")
    private User usersName;

    public User() {
    }

    public User(Integer USERS_ID) {
        this.usersId = USERS_ID;
    }

    public User(Integer USERS_ID, User USERS_NAME) {
        this.usersId = USERS_ID;
        this.usersName = USERS_NAME;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer cityId) {
        this.usersId = cityId;
    }

    public User getUsersName() {
        return usersName;
    }
    
    public User loadUserByUsername(String name) {
        return usersName;
    }

    public void setUsersName(User usersName) {
        this.usersName = usersName;
    }
}
