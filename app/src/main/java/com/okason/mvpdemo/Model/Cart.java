package com.okason.mvpdemo.Model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/*** Created by nikita on 17/8/17.
 */

public class Cart extends SugarRecord {
    @SerializedName("id")
    private Long id;
    @SerializedName("productName")
    private String productName;
    @SerializedName("description")
    private String description;
    @SerializedName("salePrice")
    private double salePrice;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
