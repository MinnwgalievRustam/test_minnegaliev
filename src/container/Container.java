package container;

import enums.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import model.Item;
import model.ItemInContainer;

import java.util.ArrayList;
import java.util.List;

public abstract class Container extends Item {

    private final List<Item> list;
    protected double totalWeight;



    public Container(String title, double weight, Shape shape) {
        super(title, weight, shape);
        list = new ArrayList<>();
        this.totalWeight = weight;
    }

    public void show() {
        for (Item item : list) {
            System.out.println(item.toString());
        }
    }

    public boolean search(String name) {
        for (Item item : list) {
            if (item.getTitle().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public void calculationMaxWeight(Item item) {
        if (item.isFlag()) {
            throw new ItemAlreadyPlacedException("Контейнер уже лежит в другом контейнере");
        } if (item instanceof Container) {
            this.totalWeight += ((Container) item).getTotalWeight();
            item.flag = true;
        } else if (item instanceof ItemInContainer) {
            this.totalWeight += item.getWeight();
        }
    }

    public Item searchRandomItem() {
        int index = (int) Math.ceil(Math.random() * getList().size() - 1);
        Item item = getList().get(index);
        getList().remove(getList().get(index));
        if (item instanceof Container) {
            this.totalWeight -= ((Container) item).getTotalWeight();
        }
        if (item != null) {
            this.totalWeight -= item.getWeight();
        }
        return item;
    }

    public abstract void addItem(Item item) throws ItemStoreException;

    public abstract Item takeItem();

    public void clear() {
        getList().clear();
    }

    public List<Item> getList() {
        return list;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean isFlag() {
        return flag;
    }
}
