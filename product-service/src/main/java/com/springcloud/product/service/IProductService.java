package com.springcloud.product.service;

import com.springcloud.entity.Product;

import java.util.List;

public interface IProductService {
    //根据id查询
    Product findById(Integer id);

    //查询全部
    List findAll();

    //保存
    void save(Product product);

    //更新
    void update(Product product);

    //删除
    void delete(Integer id);
}