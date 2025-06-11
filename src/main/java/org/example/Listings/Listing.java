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
    private int bidPrice;
    private String condition;
    private String brand;
    private String model;
    private LocalDateTime postedAt;
    private int buyNowPrice;
    private int shippingPrice;
    private boolean returnable;
    private String sellerUsername;
    private double sellerRating;
    private int sellerFeedbackCount;

    public Listing() {

    }

    public Listing(int ebayId, int bidPrice, String condition, String brand, String model, LocalDateTime postedAt, int buyNowPrice, int shippingPrice, boolean returnable
    ) {
        this.ebayId = ebayId;
        this.bidPrice = bidPrice;
        this.condition = condition;
        this.brand = brand;
        this.model = model;
        this.postedAt = postedAt;
        this.buyNowPrice = buyNowPrice;
        this.shippingPrice = shippingPrice;
        this.returnable = returnable;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", ebayId=" + ebayId +
                ", price=" + bidPrice +
                ", buyNowPrice=" + buyNowPrice +
                ", shippingPrice=" + shippingPrice +
                ", condition='" + condition + '\'' +
                ", returnable=" + returnable +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", postedAt=" + postedAt +
                ", sellerUsername='" + sellerUsername + '\'' +
                ", sellerRating=" + sellerRating +
                ", sellerFeedbackCount=" + sellerFeedbackCount +
                '}';
    }

    public double getSellerRating() {
        return sellerRating;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public int getSellerFeedbackCount() {
        return sellerFeedbackCount;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public void setSellerFeedbackCount(int sellerFeedbackCount) {
        this.sellerFeedbackCount = sellerFeedbackCount;
    }

    public void setSellerRating(double sellerRating) {
        this.sellerRating = sellerRating;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public boolean isReturnable() {
        return returnable;
    }

    public int getBuyNowPrice() {
        return buyNowPrice;
    }

    public int getShippingPrice() {
        return shippingPrice;
    }

    public void setBuyNowPrice(int buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public void setReturnable(boolean returnable) {
        this.returnable = returnable;
    }

    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public void setPrice(int bidPrice) {
        this.bidPrice = bidPrice;
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
        return bidPrice;
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
