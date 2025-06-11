package org.example.Racquets;

import jakarta.persistence.*;
import org.example.Listings.Listing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Racquet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "racquet", cascade = CascadeType.ALL)
    private List<Listing> listings = new ArrayList<>();

    private String brand;
    private String model;
    private int ebayId;
    private String imageUrl;
    private BigDecimal price;
    private String specs;

    public Racquet(){

    }

    public Racquet(String brand, String model, int ebayId, String imageUrl, BigDecimal price, String specs){
        this.brand = brand;
        this.model = model;
        this.ebayId = ebayId;
        this.imageUrl = imageUrl;
        this.price = price;
        this.specs = specs;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSpecs() {
        return specs;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEbayId(int ebayId) {
        this.ebayId = ebayId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public int getEbayId() {
        return ebayId;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Racquet{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", racquetId=" + ebayId +
                ", imageUrl='" + imageUrl + '\'' +
                ", price='" + price + '\'' +
                ", specs='" + specs + '\'' +
                '}';
    }
}
