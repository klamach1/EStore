package com.uciext.springfw.hw.controllers;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;
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
@RequestMapping("/admin")
public class AdminController {

        private CatalogService catalogService;

        @Autowired
        public void setCatalogService(CatalogService catalogService) {
            this.catalogService = catalogService;
        }

        @RequestMapping("/listProducts")
        public ModelAndView catalogList(Model model) {
            System.out.println("======= in catalogList");
            Catalog catalog = catalogService.getCatalogs().get(0);
            List<Product> products = catalogService.getProductsByCatalog(catalog);
            model.addAttribute("productList", products);
            model.addAttribute(catalog);
            return new ModelAndView("product/productList");
        }

        @RequestMapping(value="/{catalogId}/addProduct", method= RequestMethod.GET)
        public String addProduct(@PathVariable int catalogId, Model model) {
            System.out.println("======= in addProduct");
            Catalog catalog = catalogService.getCatalogs().get(0);
            Product product = new Product();
            product.setCatalog(catalog);
            model.addAttribute(product);
            return "product/addProduct";
        }

        @RequestMapping(value="/{catalogId}/addProduct", method=RequestMethod.POST)
        public String addProduct(@PathVariable int catalogId, @Valid Product product, BindingResult bindingResult) {
            System.out.println("======= in addProductSave");
            if(bindingResult.hasErrors()){
                return "product/addProduct";
            }
            try {
                product.setCatalog(catalogService.getCatalog(catalogId));
                catalogService.addProduct(product);
            } catch (CatalogServiceException cse) {
                return "product/addProduct";
            }
            return "redirect:/admin/listProducts.html";
        }

    @RequestMapping(value="/{catalogId}/editProduct/{productId}", method= RequestMethod.GET)
    public String editProduct(@PathVariable int catalogId, @PathVariable int productId, Model model) {
        System.out.println("======= in editProduct");
        Catalog catalog = catalogService.getCatalog(catalogId);
        Product product = catalogService.getProduct(productId);
        product.setCatalog(catalog);
        model.addAttribute(product);
        return "product/editProduct";
    }

    @RequestMapping(value="/{catalogId}/editProduct/{productId}", method=RequestMethod.POST)
    public String editProduct(@PathVariable int catalogId, @PathVariable int productId, @Valid Product product, BindingResult bindingResult) {
        System.out.println("======= in editProduct");
        if(bindingResult.hasErrors()){
            return "product/editProduct";
        }
        try {
            product.setCatalog(catalogService.getCatalog(catalogId));
            product.setProductId(productId);
            catalogService.updateProduct(product);
        } catch (CatalogServiceException cse) {
            return "product/editProduct";
        }
        return "redirect:/admin/listProducts.html";
    }

    @RequestMapping(value="/{catalogId}/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int catalogId, @PathVariable int productId) {
        System.out.println("======= in deleteProduct");
        try {
            catalogService.deleteProduct(catalogService.getProduct(productId));
        } catch (CatalogServiceException cse) {

            System.out.println("Error in deleteProduct " + cse.getMessage());
        }
        return "redirect:/admin/listProducts.html";
    }
}
