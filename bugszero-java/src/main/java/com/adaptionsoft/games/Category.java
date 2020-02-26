package com.adaptionsoft.games;

public enum Category {
    pop("Pop"),science("Science"),sports("Sports"),rock("Rock"),    blues("Blues"),
    history("History");
    private String name;

    Category(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public static Category getCategory(int currentPlace) {
        Category []  categories = Category.values();

        Category category = categories[currentPlace % categories.length];
        System.out.println("The category is " + category.getName());

        return category;
    }
}
