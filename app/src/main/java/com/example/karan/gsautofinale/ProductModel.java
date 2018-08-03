package com.example.karan.gsautofinale;

public class ProductModel {

    String code,size,model,price;

    public ProductModel(){

    }

    public ProductModel(String code, String size, String model, String price) {
        this.code = code;
        this.size = size;
        this.model = model;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
