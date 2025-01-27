package com.example.Budgetmanager;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public static Category fromCategoryType(CategoryType categoryType) {
        return new Category(categoryType.name());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
