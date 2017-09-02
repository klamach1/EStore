package com.uciext.springfw.hw.catalog.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product_order")
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_order_id")
    @XmlElement
    private int productOrderId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "order_amount")
    private int orderAmount;


    public ProductOrder() {
    }

    public ProductOrder(Order order, Product product, int orderAmount) {

        this.order = order;
        this.product = product;
        this.orderAmount = orderAmount;
    }

    public int getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
