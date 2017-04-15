package com.example.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by KingChaos on 2017/4/14.
 */

public class Book extends DataSupport {
    private int id;
    private String name;
    private String author;
    private String press;
    private int pages;
    private double price;


    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }
}
