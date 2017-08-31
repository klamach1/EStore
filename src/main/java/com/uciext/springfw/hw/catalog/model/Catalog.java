package com.uciext.springfw.hw.catalog.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by clawrence on 7/15/17.
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "catalog")
@Table(name = "catalog")
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    @XmlElement
    private int catalogId;

    @Column(name = "catalog_name")
    @XmlElement
    private String catalogName;

    @XmlTransient
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "catalog")
    private List<Product> products;

    public Catalog(int catalogId, String catalogName) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.products = new ArrayList<Product>();
    }

    public Catalog() {
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public List<Product> getProducts() {

        if (products == null) {
            setProducts(new ArrayList<Product>());
        }

        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder("[Catalog: ")
                .append("catalogId=").append(catalogId)
                .append(", catalogName=").append(catalogName)
                .append("]");

        return buff.toString();
    }
}
