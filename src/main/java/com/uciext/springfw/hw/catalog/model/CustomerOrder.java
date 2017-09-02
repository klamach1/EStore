package com.uciext.springfw.hw.catalog.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomerOrder {

    Order order;

    List<ProductOrder> productOrderList;

    boolean completedOrder;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isCompletedOrder() {
        return completedOrder;
    }

    public void setCompletedOrder(boolean completedOrder) {
        this.completedOrder = completedOrder;
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
