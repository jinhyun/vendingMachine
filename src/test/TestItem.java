package test;

import main.Item;
import java.util.*;
import org.junit.*;

/**
 * Created by Jinhyun on 2015. 3. 5..
 */
public class TestItem {
    @Test
    public void testInitItem(){
        Item item = new Item();

        List <Item> itemList = item.getInitItemList();

        for(Item i : itemList){
            System.out.println("--------------");
            System.out.println(i.getNumber());
            System.out.println(i.getName());
            System.out.println(i.getPrice());
        }
    }
}
