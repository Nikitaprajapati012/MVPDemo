package com.okason.mvpdemo.Model;


import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/*** Created by nikita on 16/08/2017.
 */

public class ProductData extends SugarRecord {

    private String productName;
    private String description;

    public ProductData(String name, String surName) {
        this.productName =  name;
        this.description =  surName;
    }

}

