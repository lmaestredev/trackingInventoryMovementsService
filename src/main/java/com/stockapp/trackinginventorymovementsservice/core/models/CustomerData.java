package com.stockapp.trackinginventorymovementsservice.core.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("CustomerData")
public class CustomerData {

    @Id
    private String id;
    private Object data;

    public CustomerData() {
    }

    public CustomerData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
