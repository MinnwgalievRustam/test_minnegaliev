package container;

import enums.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import model.Item;
import model.ItemInContainer;

public class Flat extends Container {

    int countMaxValueItem;

    public Flat(int countMaxValueItem) {
        super("Flat", 50, Shape.FLAT);
        this.countMaxValueItem = countMaxValueItem;
    }

    @Override
    public void addItem(Item item) throws ItemStoreException {

        if (getList().size() >= countMaxValueItem) {
            throw new ItemStoreException("Стопка переполнена");
        } else if (item.getShape().equals(Shape.CIRCLE)) {
            throw new IllegalArgumentException("Можно только плоские предметы");
        } else if (item.isFlag()) {
            throw new ItemAlreadyPlacedException("Контейнер уже лежит в другом контейнере");
        }
        if (item instanceof Container) {
            this.totalWeight += ((Container) item).getTotalWeight();
        } else if (item instanceof ItemInContainer) {
            this.totalWeight += item.getWeight();
        }
        getList().add(item);
    }

    @Override
    public Item takeItem() {
        return getList().get(getList().size() - 1);
    }

}



