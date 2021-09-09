package com.durgesh.expendify;

public class Expense {
    int id;
    String name;
    String category;
    String comment;
    float amount;
    public Expense(int id, String name, String category, String comment, float amount)
    {
        this.id = id;
        this.name=name;
        this.category=category;
        this.comment=comment;
        this.amount=amount;
    }

    public Expense(String name, String category, String comment, float amount)
    {
        this.name=name;
        this.category=category;
        this.comment=comment;
        this.amount=amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
