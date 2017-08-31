package com.uciext.springfw.hw.catalog.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "productList")
public class ProductList {
    ArrayList<Product> products = new ArrayList<Product>();

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
