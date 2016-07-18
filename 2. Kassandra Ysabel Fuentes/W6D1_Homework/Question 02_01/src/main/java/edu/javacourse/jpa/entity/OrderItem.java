package edu.javacourse.jpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable {

    @Id
//            (strategy = GenerationType.AUTO)
    @Column(name = "ORDERITEM_ID")
    private Integer orderItemId;
    @Column(name = "ORDERITEM_NAME")
    private String orderItemName;
    @JoinColumn(name = "ORDERITEM_ORDER", referencedColumnName = "ORDERS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders ordersId;

    public OrderItem() {
    }

    public OrderItem(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public OrderItem(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public OrderItem(Integer orderItemId, String orderItemName) {
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

    public Orders getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Orders ordersId) {
        this.ordersId = ordersId;
    }

}
