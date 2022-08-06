package container;

import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import model.Apple;
import model.Brick;
import model.ItemInContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlatTest {

    @Test
    void addItem() throws ItemStoreException {
        Container flat = new Flat(2);
        Container box = new Box(5000);
        Container flat2 = new Flat(5);


        ItemInContainer brick1 = new Brick("brick1", 500, "orange", 1);
        ItemInContainer brick2 = new Brick("brick1", 500, "orange", 1);
        ItemInContainer brick3 = new Brick("brick1", 500, "orange", 1);

        ItemInContainer apple = new Apple("apple", 200, "green", 3);
        flat.addItem(brick1);
        assertEquals(550, flat.getTotalWeight());

        assertThrows(IllegalArgumentException.class, () -> {
            flat.addItem(apple);
        });

        assertThrows(ItemStoreException.class, () -> {
            flat.addItem(brick1);
            flat.addItem(brick2);
            flat.addItem(brick3);
        });

        assertThrows(ItemAlreadyPlacedException.class, () -> {
            box.addItem(flat);
            flat2.addItem(flat);
        });

    }

    @Test
    void takeItem() throws ItemStoreException {
        Container flat = new Flat(2);

        ItemInContainer brick1 = new Brick("brick1", 500, "orange", 1);
        ItemInContainer brick2 = new Brick("brick2", 500, "orange2", 1);

        flat.addItem(brick1);
        flat.addItem(brick2);

        assertEquals(flat.getList().get(flat.getList().size() - 1), flat.takeItem());

    }
}
