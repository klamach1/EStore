package com.uciext.springfw.hw.controllers;


import com.uciext.springfw.hw.catalog.model.*;
import com.uciext.springfw.hw.catalog.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {

    String USER_NAME = "me";

    private CatalogService catalogService;

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping("/listOrders")
    public ModelAndView orderList(Model model) {
        System.out.println("======= in orderList");
        List<Order> orders = catalogService.getOrdersByUser(USER_NAME);
        model.addAttribute("userName", USER_NAME);
        model.addAttribute("orderList", orders);

        return new ModelAndView("order/orderList");
    }

    @RequestMapping(value="/{userName}/addOrder", method= RequestMethod.GET)
    public String addOrder(@PathVariable String userName,  Model model) {
        System.out.println("======= in addOrder");
        Order order = new Order();
        order.setUser(userName);
        Catalog catalog = catalogService.getCatalogs().get(0);
        List<Product> productList = catalogService.getProductsInStockByCatalog(catalog);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrder(order);
        for (Product product : productList) {
            ProductOrder productOrder = new ProductOrder(order, product, 0);
            customerOrder.getProductOrderList().add(productOrder);
        }
        model.addAttribute("customerOrder", customerOrder);
        System.out.println("======= before return");


        return "order/addOrder";
    }

    @RequestMapping(value="/{userName}/addOrder", method= RequestMethod.POST)
    public String addOrder(@PathVariable String userName,  CustomerOrder customerOrder, BindingResult bindingResult) {
        System.out.println("======= in addOrderPost");
        if(bindingResult.hasErrors()){
            return "order/addOrder";
        }
        int orderTotal = 0;
        Order order = customerOrder.getOrder();
        order.setUser(userName);
        order.setOrderCreated(Date.from(Instant.now()));
        order = catalogService.addOrder(order);
        for (ProductOrder productOrder : customerOrder.getProductOrderList()) {
            if (productOrder.getOrderAmount() > 0) {
                System.out.println("Adding Product Id: " + productOrder.getProduct().getProductId() + " Quantity: " + productOrder.getOrderAmount());
                productOrder.setOrder(order);
                order.getProductOrderList().add(productOrder);
                orderTotal += productOrder.getOrderAmount();
            }

        }
        order.setTotalAmount(orderTotal);
        if (customerOrder.isCompletedOrder()) {
            order.setConfirmNumber(Math.round(Math.random()*100000));
        }
        order = catalogService.addOrder(order);
        System.out.println("======= after add");


        return "redirect:/user/listOrders.html";
    }
}
