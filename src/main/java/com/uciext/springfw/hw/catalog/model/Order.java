package com.uciext.springfw.hw.catalog.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "order")
@Table(name = "order_data")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @XmlElement
    private int orderId;

    @Column(name = "order_created")
    @XmlElement
    private Date orderCreated;

    @Column(name = "total_amount")
    @XmlElement
    private int totalAmount;

    @Column(name = "confirm_number")
    @XmlElement
    private Integer confirmNumber;

    @Column(name = "user")
    @XmlElement
    private String user;

    @XmlTransient
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "order")
    private List<ProductOrder> productOrderList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Date orderCreated) {
        this.orderCreated = orderCreated;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getConfirmNumber() {
        return confirmNumber;
    }

    public void setConfirmNumber(Integer confirmNumber) {
        this.confirmNumber = confirmNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<ProductOrder> getProductOrderList() {
        if (productOrderList == null) {
            productOrderList = new ArrayList<ProductOrder>();
        }
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }
}
