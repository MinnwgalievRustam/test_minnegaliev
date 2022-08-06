package container;

import enums.Shape;
import exceptions.ItemStoreException;
import model.Item;


public class Box extends Container {

    private final double maxWeight;


    public Box(double maxWeight) {
        super("Box", 50, Shape.SQUARE);
        this.maxWeight = maxWeight;
    }

    @Override
    public void addItem(Item item) throws ItemStoreException {
        if (this.totalWeight + item.getWeight() > maxWeight) {
            throw new ItemStoreException("Переполнение");
        }

        calculationMaxWeight(item);
        getList().add(item);
    }

    @Override
    public Item takeItem() {
      return searchRandomItem();
    }

    public double getMaxWeight() {
        return maxWeight;
    }
}
