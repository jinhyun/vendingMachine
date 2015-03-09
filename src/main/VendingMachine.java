package main;

import java.util.List;

/**
* Created by Jinhyun on 2015. 3. 4..
*/
public class VendingMachine {
    Item initItem = new Item();
    private List <Item> itemList;

    public VendingMachine() {
        setItemList(initItem.getInitItemList());
    }

    public void setItemList(List <Item> itemList) {
        this.itemList = itemList;
    }

    public List <Item> getItemList() {
        return itemList;
    }

    public void viewItemList() {
        System.out.println("----------------------");
        for (Item result : itemList){
            String msg = "";
            msg += result.getNumber()+".";
            msg += result.getName()+": ";
            msg += result.getPrice()+"원";
            System.out.println(msg);
        }
        System.out.println("----------------------");
        System.out.println("상품을 선택하세요");
    }
}