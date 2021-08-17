package repository;

import model.Product;

import java.util.ArrayList;

public interface IProducRepo {
    public Product save(Product product);
    public ArrayList<Product> findAll();
    public void Delete(Product product);
    public void edit(Product product);
}
