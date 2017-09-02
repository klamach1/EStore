package com.uciext.springfw.hw.catalog.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ProductOrders {

    List<ProductOrder> productOrderList = new ArrayList<ProductOrder>();

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
