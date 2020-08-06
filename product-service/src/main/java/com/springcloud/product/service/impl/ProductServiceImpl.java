package com.springcloud.product.service.impl;

import com.springcloud.entity.Product;
import com.springcloud.product.dao.ProductDao;
import com.springcloud.product.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public Product findById(Integer id) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return productDao.findById(id).get();
    }

    @Override
    public List findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.deleteById(id);
    }

}
