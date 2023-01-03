package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> fidAll();

    Product findById(int id);

    boolean save(Product product);
}
