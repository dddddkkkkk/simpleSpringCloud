package com.springcloud.product.controller;

import com.springcloud.entity.Product;
import com.springcloud.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    IProductService productService;

    @Value("${server.port}")
    Integer port;

    @Autowired
    ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) {
        log.info("----------->product {}<---------", port);
        return productService.findById(id);
    }

    @PostMapping
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "保存成功";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Product product) {
        productService.update(product);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(Integer id) {
        productService.delete(id);
        return "删除成功";
    }
}
