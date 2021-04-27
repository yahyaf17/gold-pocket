package com.enigma.pocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "m_products")
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String productImage;
    private String productName;
    private BigDecimal productPriceBuy;
    private BigDecimal productPriceSell;
    private Integer productStatus;

    @Column (name = "created_at")
    private Date createdDate;
    @Column (name = "updated_at")
    private Date updatedDate;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductHistoryPrice> productHistoryPrices = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(BigDecimal productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<ProductHistoryPrice> getProductHistoryPrices() {
        return productHistoryPrices;
    }

    public void setProductHistoryPrices(List<ProductHistoryPrice> productHistoryPrices) {
        this.productHistoryPrices = productHistoryPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productName='" + productName + '\'' +
                ", productPriceBuy=" + productPriceBuy +
                ", productPriceSell=" + productPriceSell +
                ", productStatus=" + productStatus +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
