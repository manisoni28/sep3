package com.anhttvn.customrecyclerview;

public class FruitItem {
    private  int price;
    private String name;
    private int image;
    private int weight;
    String gId,category, gUrl;


    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgId() {
        return gId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getgUrl() {
        return gUrl;
    }

    public void setgUrl(String gUrl) {
        this.gUrl = gUrl;
    }
}
