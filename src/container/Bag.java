package container;

import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import model.Item;
import enums.Shape;
import model.ItemInContainer;

public class Bag extends Container {

    private final double maxWeight;

    public Bag(double maxWeight) {
        super("bag", 20, Shape.CIRCLE);
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

}
