package model;

import enums.Shape;

public class Book extends  ItemInContainer{
    public Book(String title, double weight,  String color, int size) {
        super(title, weight, Shape.FLAT, color, size);
    }
}
