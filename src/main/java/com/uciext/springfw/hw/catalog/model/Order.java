package com.uciext.springfw.hw.catalog.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "order")
@Table(name = "order")
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
    private int confirmNumber;

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

    public int getConfirmNumber() {
        return confirmNumber;
    }

    public void setConfirmNumber(int confirmNumber) {
        this.confirmNumber = confirmNumber;
    }
}
