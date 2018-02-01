package com.monogo.demo.model;

import java.io.Serializable;

public class CategoryPrimaryKey implements Serializable {

    private String name;

    private String variant;

    public CategoryPrimaryKey(String name, String variant) {
        this.name = name;
        this.variant = variant;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }


}
