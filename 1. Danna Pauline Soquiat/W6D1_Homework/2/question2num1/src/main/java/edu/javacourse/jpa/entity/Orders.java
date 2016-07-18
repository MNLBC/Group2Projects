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

/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDERITEM_ID")
    private Integer orderItemId;
    @Column(name = "ORDERITEM_NAME")
    private String orderItemName;
    @JoinColumn(name = "ORDERS_USERS", referencedColumnName = "USERS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users usersId;

    public Orders() {
    }

    public Orders(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Orders(Integer orderItemId, String orderItemName) {
        this.orderItemId = orderItemId;
        this.orderItemName = orderItemName;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

}
