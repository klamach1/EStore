package com.uciext.springfw.hw.catalog.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by clawrence on 7/23/17.
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    @Column (name = "product_id")
    private int productId;

    @XmlElement
    @Column (name = "sku")
    private String sku;

    @XmlElement
    @Column(name = "product_name")
    private String productName;

    @XmlElement
    @Column(name = "uom")
    private String unitOfMeasure;

    @XmlElement
    @Column(name = "available_quantity")
    private int availableQuantity;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Product() {
    }



    public Product(int productId, Catalog catalog, String sku, String productName, String unitOfMeasure, int availableQuantity) {

        this.productId = productId;
        this.catalog = catalog;

        this.sku = sku;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
        this.availableQuantity = availableQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


    public String getSku() {

        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", productName='" + productName + '\'' +
                ", unitOfMeasure='" + unitOfMeasure + '\'' +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
