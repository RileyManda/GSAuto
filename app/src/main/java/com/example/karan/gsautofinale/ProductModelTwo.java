package com.example.karan.gsautofinale;

import com.google.firebase.database.Exclude;

public class ProductModelTwo {
    @Exclude
    private String itemId;

    private String code,size,model,price,inch,apps,pic;

    public ProductModelTwo(){

    }

    public ProductModelTwo(String code, String size, String model, String price, String inch,String apps,String pic) {
        this.code = code;
        this.size = size;
        this.model = model;
        this.price = price;
        this.inch = inch;
        this.apps = apps;
        this.pic = pic;

    }

    public String getItemId() {
        return itemId;
    }
    public void setItemId(String id) {
        this.itemId = id;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String  pic) {
        this.pic = pic;
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

    public String getApps() {
        return inch;
    }

    public void setApps(String inch) {
        this.inch = inch;
    }
}
