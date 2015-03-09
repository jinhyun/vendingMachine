package main;

import java.util.*;

/**
* Created by Jinhyun on 2015. 3. 4..
*/
public class User {
    private int money;
    private int totMoney;

    public UserVendingMachine chooseItem(int itemNo) {
        itemNo = itemNo - 1;
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
            this.money = money;
            return this.totMoney;
        }
        this.money = money;
        this.totMoney += money;

        System.out.println("[넣은금액] "+this.totMoney+"원");

        return this.totMoney;
    }

    public int getTotMoney() {
        return totMoney;
    }

    public int getMoney(){
        return money;
    }
}
