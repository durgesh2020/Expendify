package com.durgesh.expendify;

public class MyBudget {
    int id;
    float amount;

    public MyBudget(int id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public MyBudget(float amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
