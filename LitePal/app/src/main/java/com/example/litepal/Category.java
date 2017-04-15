package com.example.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by KingChaos on 2017/4/15.
 */

public class Category extends DataSupport {
    private int id;
    private String categorycode;
    private String categoryname;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getId() {
        return id;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public String getCategoryname() {
        return categoryname;
    }
}
