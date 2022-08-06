package model;

import enums.Shape;

public class Apple extends ItemInContainer{
    public Apple(String title, double weight,  String color, int size) {
        super(title, weight, Shape.CIRCLE, color, size);
    }
}
