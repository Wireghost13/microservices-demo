package com.openfeignexmpl.learningprogrammingproductservice.services;

// import java.util.ArrayList;
import java.util.List;

import com.openfeignexmpl.learningprogrammingproductservice.entities.Product;

public interface ProductService {
    public List<Product> findAll();

    public List<Product> search(double min, double max);

}
