package com.example.karan.gsautofinale;

public class ListItem {

    String userid;
    String code,apps,model,price;
    String pic;

    public ListItem(String userid, String code, String apps, String model, String price, String pic) {
        this.userid = userid;
        this.code = code;
        this.apps = apps;
        this.model = model;
        this.price = price;
        this.pic = pic;
    }

    public ListItem(){

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
