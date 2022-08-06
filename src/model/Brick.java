package model;

import enums.Shape;

public class Brick extends ItemInContainer{
    public Brick(String title, double weight,  String color, int size) {
        super(title, weight, Shape.SQUARE, color, size);
    }
}
