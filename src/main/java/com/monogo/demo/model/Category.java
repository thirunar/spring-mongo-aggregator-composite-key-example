package com.monogo.demo.model;


import org.springframework.data.annotation.Id;

public class Category {

    @Id
    private CategoryPrimaryKey id;

    private String dummyValue;

    public Category(CategoryPrimaryKey id, String dummyValue) {
        this.id = id;
        this.dummyValue = dummyValue;
    }

    public String getDummyValue() {
        return dummyValue;
    }

    public CategoryPrimaryKey getId() {
        return id;
    }
}
