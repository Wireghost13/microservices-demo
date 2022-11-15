package com.openfeignexmpl.learningprogrammingproductservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openfeignexmpl.learningprogrammingproductservice.entities.Product;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("p01", "Name 1", 45));
        products.add(new Product("p02", "Name 2", 56));
        products.add(new Product("p03", "Name 3", 66));
        products.add(new Product("p04", "Name 4", 33));
        products.add(new Product("p05", "Name 5", 13));

        return products;
    }

    public List<Product> search(double min, double max){
        List<Product> products = new ArrayList<Product>();
        for(Product product : findAll()) {
            if(product.getPrice() >= min && product.getPrice() <= max) {
                products.add(product);
            }
        }
        return products;
    }

}
