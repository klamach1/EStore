package com.uciext.springfw.hw.controllers;


import com.uciext.springfw.hw.catalog.model.*;
import com.uciext.springfw.hw.catalog.services.CatalogService;
import com.uciext.springfw.hw.catalog.services.CatalogServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        ProductOrders productOrders = new ProductOrders();
        for (Product product : productList) {
            ProductOrder productOrder = new ProductOrder(order, product, 0);
            productOrders.getProductOrderList().add(productOrder);
        }
        model.addAttribute("productOrders", productOrders);
        System.out.println("======= before return");


        return "order/addOrder";
    }
}
