package model;

import org.springframework.lang.NonNull;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private String img;
    private double price;
    private Date date;
    private Catergory catergory;

    public Product() {
    }

    public Product(int id, String name, String img, double price, Date date, Catergory catergory) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.date = date;
        this.catergory = catergory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Catergory getCatergory() {
        return catergory;
    }

    public void setCatergory(Catergory catergory) {
        this.catergory = catergory;
    }
}
