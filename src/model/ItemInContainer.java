package model;

import enums.Shape;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemInContainer extends Item {

    private final String color;
    private final int size;

    public ItemInContainer(String title, double weight, Shape shape, String color, int size) {
        super(title, weight, shape);
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ItemInContainer{" +
                "title='" + getTitle() + '\'' +
                ", weight='" + getWeight() + '\'' +
                ", color='" + color + '\'' +
                ", shape='" + getShape() + '\'' +
                ", size=" + size +
                '}';
    }

}
