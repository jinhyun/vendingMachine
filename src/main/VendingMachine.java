package main;

import java.util.List;

/**
* Created by Jinhyun on 2015. 3. 4..
*/
public class VendingMachine {
    Item initItem = new Item();

    public VendingMachine() {
        setItemList(initItem.getInitItemList());
    }

    public VendingMachine(List <Item> initItemList){
        setItemList(initItemList);
    }

    private List <Item> itemList;

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
    }

    public void operation(User user) {
        if (isEnoughMoney(user)){
            String itemName = chooseItemName();
            System.out.println(itemName+"을(를) 구매해주셔서 감사합니다");

            int remainMoney = remainMoney(user);
            System.out.println("잔돈은 "+remainMoney+"원 입니다");
        }
    }

    public boolean isEnoughMoney(User user) {
        if (this.getItemList().size() < 1) throw new IllegalArgumentException();
        Item item = this.getItemList().get(0);

        int itemPrice = item.getPrice();
        int userMoney = user.getMoney();

        if (itemPrice <= userMoney) {
            return true;
        } else {
            return false;
        }
    }

    public String chooseItemName() {
        if (this.getItemList().size() < 1) throw new IllegalArgumentException();
        Item item = this.getItemList().get(0);
        return item.getName();
    }

    public int remainMoney(User user) {
        if (this.getItemList().size() < 1) throw new IllegalArgumentException();
        Item item = this.getItemList().get(0);

        int itemPrice = item.getPrice();
        int userMoney = user.getMoney();

        if (itemPrice < userMoney) {
            return userMoney - itemPrice;
        } else {
            return 0;
        }
    }
}