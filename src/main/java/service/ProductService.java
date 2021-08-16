package service;

import model.Catergory;
import model.Product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

public class ProductService {
    public ArrayList<Product> list = new ArrayList<>();

    public ProductService() {
        list.add(new Product(1, "oto1", "https://image.thanhnien.vn/1024/uploaded/bahung/z-ba-hung-2020/thang-4-2020/thuong-hieu-quyi/thi-truong-oto-thang_thanhnien-3_pdcq.jpg", 50000, new Date(System.currentTimeMillis()), new Catergory(1, "oto")));
        list.add(new Product(2, "oto2", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6Irsb2iE9PY0BPsrolKB_sF9qNupyFeLhToOP902Kq50AZvrUcWc75QKII5sNFiemFYI&usqp=CAUg", 50000, new Date(System.currentTimeMillis()), new Catergory(1, "oto")));
        list.add(new Product(3, "oto3", "https://congthuong.vn/stores/news_dataimages/thuylinh/072020/09/17/in_article/0704_YYu_xe_-_Front_HV_2.jpg?rt=20200709171101", 50000, new Date(System.currentTimeMillis()), new Catergory(1, "oto")));
    }

    public void seve(Product product) {
        list.add(product);
    }

    public void edit(Product product, int index) {
        list.set(index, product);
    }

    public void delete(int index) {
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
