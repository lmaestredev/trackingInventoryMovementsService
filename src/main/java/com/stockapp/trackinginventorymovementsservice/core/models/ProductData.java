package com.stockapp.trackinginventorymovementsservice.core.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ProductData")
public class ProductData {

    @Id
    private String id;
    private Object data;

    public ProductData() {
    }

    public ProductData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
