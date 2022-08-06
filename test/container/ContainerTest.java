package container;

import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import model.*;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {


    @Test
    void search() throws ItemStoreException {
        Container box = new Box(5000);
        ItemInContainer apple = new Apple("apple", 200, "green", 3);
        box.addItem(apple);
        assertTrue(box.search("apple"));
    }

    @Test
    void addItem() throws ItemStoreException {
        Container box = new Box(5000);
        Container bag = new Bag(5000);
        Container box2 = new Box(5000);

        assertThrows(ItemAlreadyPlacedException.class, () ->{box.addItem(box2);
            bag.addItem(box2);});
        ItemInContainer brick1 = new Brick("brick1", 500, "orange", 1);
        box.addItem(brick1);
        assertEquals(600, box.getTotalWeight());
        ItemInContainer apple = new Apple("apple", 20000, "green", 3);
        assertThrows(ItemStoreException.class, () ->{
            box.addItem(apple);
        });
    }

    @Test
    void takeItem() throws ItemStoreException {
        Container box = new Box(5000);
        ItemInContainer apple1 = new Apple("apple", 200, "green", 3);
        ItemInContainer apple2 = new Apple("apple", 200, "green", 3);
        ItemInContainer apple3 = new Apple("apple", 200, "green", 3);
        box.addItem(apple1);
        box.addItem(apple2);
        box.addItem(apple3);
        box.takeItem();
        assertEquals(450, box.getTotalWeight());
    }

    @Test
    void getTotalWeight() throws ItemStoreException {
        ItemInContainer apple1 = new Apple("apple", 200, "green", 3);
        ItemInContainer apple2 = new Apple("apple", 200, "green", 3);

        ItemInContainer brick1 = new Brick("brick1", 500, "orange", 1);
        ItemInContainer brick2 = new Brick("brick1", 500, "orange", 1);
        Container box = new Box(5000);
        Container bag = new Bag(10000);

        box.addItem(apple1);
        box.addItem(apple2);

        bag.addItem(brick1);
        bag.addItem(brick2);

        bag.addItem(box);

        assertEquals(1470, bag.getTotalWeight());
    }

    @Test
    void clear() throws ItemStoreException {
        ItemInContainer apple1 = new Apple("apple", 200, "green", 3);
        ItemInContainer apple2 = new Apple("apple", 200, "green", 3);
        ItemInContainer brick1 = new Brick("brick1", 500, "orange", 1);

        Container box = new Box(5000);
        box.addItem(apple1);
        box.addItem(apple2);
        box.addItem(brick1);
        box.clear();
        assertEquals(0,box.getList().size());
    }





}
