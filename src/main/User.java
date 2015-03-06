package main;

import java.util.*;

/**
* Created by Jinhyun on 2015. 3. 4..
*/
public class User {
    private int money;

    public UserVendingMachine chooseItem(int itemNo) {
        VendingMachine machine = new VendingMachine();

        List <Item> itemList = machine.getItemList();

        if (itemNo > itemList.size()){
            throw new IllegalArgumentException("없는 상품번호");
        }

        Item item = itemList.get(itemNo);

        List <Item> chooseItemList = new ArrayList<>();
        chooseItemList.add(item);

        for (Item result : chooseItemList){
            String msg = "[선택한 물품정보] ";
            msg += result.getNumber()+".";
            msg += result.getName()+": ";
            msg += result.getPrice()+"원";
            System.out.println(msg);
        }
        return new UserVendingMachine(chooseItemList);
    }

    public int putMoney(int money) {
        if (!UserVendingMachine.isValidMoney(money)) {
            System.out.println("[주의] "+money+"원은 사용할 수 없습니다");
            return this.money;
        }
        this.money += money;

        System.out.println("[넣은금액] "+this.money+"원");

        return this.money;
    }

    public int getMoney() {
        return money;
    }
}
