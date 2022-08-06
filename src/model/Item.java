package model;


import enums.Shape;

public abstract class Item {
    private final String title;

    private final double weight;

    private final Shape shape;
    public boolean flag = false;


    public Item(String title, double weight, Shape shape) {
        this.title = title;
        this.weight = weight;
        this.shape = shape;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isFlag() {
        return flag;
    }
}
