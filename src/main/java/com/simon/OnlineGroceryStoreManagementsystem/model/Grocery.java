package com.simon.OnlineGroceryStoreManagementsystem.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "grocery")
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String name;

    private String description;

    private Long price;

    private Long quantityInStock;

    private String category;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private String manufactureDate;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private String expiryDate;

    private String image;

    private String groceryIngredients;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private User user;


    //no para constructor
    public Grocery(){

    }

    public Grocery(String name, String description, Long price, Long quantityInStock, String category,
                   String manufactureDate, String expiryDate, String image,
                   String groceryIngredients) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.category = category;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.image = image;
        this.groceryIngredients = groceryIngredients;
    }

    public Grocery(String name, String description, Long price,
                   Long quantityInStock, String category, String manufactureDate, String expiryDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.category = category;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGroceryIngredients() {
        return groceryIngredients;
    }

    public void setGroceryIngredients(String groceryIngredients) {
        this.groceryIngredients = groceryIngredients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", category='" + category + '\'' +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
