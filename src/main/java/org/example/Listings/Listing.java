package org.example.Listings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or any other strategy
    private Long id;

    private int ebayId;
    private int price;
    private String condition;
    private String brand;
    private String model;
    private LocalDateTime postedAt;

    public Listing() {

    }

    public Listing(int ebayId, int price, String condition, String brand, String model, LocalDateTime postedAt) {
        this.ebayId = ebayId;
        this.price = price;
        this.condition = condition;
        this.brand = brand;
        this.model = model;
        this.postedAt = postedAt;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", ebayId=" + ebayId +
                ", price=" + price +
                ", condition='" + condition + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", postedAt=" + postedAt +
                '}';
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getEbayId() {
        return ebayId;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setEbayId(int ebayId) {
        this.ebayId = ebayId;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }
}
