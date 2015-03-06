package main;

import java.util.*;

/**
 * Created by Jinhyun on 2015. 3. 5..
 */
public class Item {
    private int number;
    private int price;
    private String name;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List <Item> getInitItemList() {
        List <Item> itemList = new ArrayList<>();

        Item xylitol = new Item();
        xylitol.setNumber(1);
        xylitol.setName("자일리톨");
        xylitol.setPrice(500);

        Item iPhone6 = new Item();
        iPhone6.setNumber(2);
        iPhone6.setName("아이폰6");
        iPhone6.setPrice(125800);

        Item schrewBar = new Item();
        schrewBar.setNumber(3);
        schrewBar.setName("스크류바");
        schrewBar.setPrice(1200);

        Item macBook = new Item();
        macBook.setNumber(4);
        macBook.setName("맥북");
        macBook.setPrice(299900);

        itemList.add(xylitol);
        itemList.add(iPhone6);
        itemList.add(schrewBar);
        itemList.add(macBook);

        return itemList;
    }
}
