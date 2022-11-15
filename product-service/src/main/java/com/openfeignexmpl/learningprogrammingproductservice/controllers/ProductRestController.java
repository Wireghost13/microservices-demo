package com.openfeignexmpl.learningprogrammingproductservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.openfeignexmpl.learningprogrammingproductservice.entities.Product;
import com.openfeignexmpl.learningprogrammingproductservice.services.ProductService;

@RestController
@RequestMapping("/product")

public class ProductRestController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="findall", method=RequestMethod.GET, produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAll() {
        try {
            return new ResponseEntity<List<Product>>(productService.findAll() ,HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="search/{min}/{max}", method=RequestMethod.GET, produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> search(@PathVariable("min") double min, @PathVariable("max") double max) {
        try {
            return new ResponseEntity<List<Product>>(productService.search(min,max),HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
        }
    }
}
