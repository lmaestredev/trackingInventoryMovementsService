package com.stockapp.trackinginventorymovementsservice.core.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("SaleData")
public class SaleData {

    @Id
    private String id;
    private Object data;


    public SaleData() {
    }

    public SaleData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
