import container.Box;
import container.Bag;
import container.Container;
import container.Flat;
import exceptions.ItemStoreException;
import model.*;

public class Main {
    public static void main(String[] args) throws ItemStoreException {
        ItemInContainer apple = new Apple("AppleOne",200,"red",2);
        ItemInContainer book = new Book("BookOne",200,"black",3);
        ItemInContainer brick = new Brick("BrickOne",400,"orange",4);

        ItemInContainer apple2 = new Apple("AppleTwo",200,"redTwo",2);
        ItemInContainer book2 = new Book("BookTwo",200,"blackTwo",3);
        ItemInContainer brick2 = new Brick("BrickTwo",400,"orangeTwo",4);

        Container box = new Box(5000);
        Container box2 = new Box(5000);
        Container bug =  new Bag(3000);
        Container flat = new Flat(4);

        bug.addItem(apple);
        bug.addItem(book);
        bug.addItem(brick);
        box.addItem(apple2);
        box.addItem(book2);
        box.addItem(brick2);

        System.out.println(box.getTotalWeight());
        System.out.println(box2.getTotalWeight());

        bug.addItem(box);
        System.out.println(bug.getTotalWeight());
        bug.getList().clear();
        System.out.println(bug.getList().size());


    }
}
