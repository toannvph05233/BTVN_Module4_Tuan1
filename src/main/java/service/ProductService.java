package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IProducRepo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

public class ProductService {
    @Autowired
    IProducRepo iProducRepo;


    public ArrayList<Product> list = new ArrayList<>();

    public void seve(Product product) {
        iProducRepo.save(product);
    }

    public void findAll() {
        list = iProducRepo.findAll();
    }

    public void edit(Product product) {
        iProducRepo.edit(product);
    }

    public void delete(int index) {
        iProducRepo.Delete(list.get(index));
        list.remove(index);
    }

    public Product findByName(String name) {
        for (Product p : list) {
            if (p.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                return p;
            }
        }
        return null;
    }
}
