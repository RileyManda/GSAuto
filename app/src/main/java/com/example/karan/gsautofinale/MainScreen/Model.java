package com.example.karan.gsautofinale.MainScreen;

public class Model {

    int thumbnial;
    String title;

   public Model(){

   }

    public Model(int thumbnial, String title) {
        this.thumbnial = thumbnial;
        this.title = title;
    }

    public int getThumbnial() {
        return thumbnial;
    }

    public void setThumbnial(int thumbnial) {
        this.thumbnial = thumbnial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
