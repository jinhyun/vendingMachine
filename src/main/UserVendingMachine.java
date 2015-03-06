package main;

import java.util.List;

/**
 * Created by Jinhyun on 2015. 3. 6..
 */
public class UserVendingMachine extends VendingMachine {
    public UserVendingMachine(List <Item> initItemList){
        setItemList(initItemList);
    }

    public static boolean isValidMoney(int money) {
        int[] enableMoneyList = {500, 1000, 5000};

        for (int enableMoney : enableMoneyList){
            if (enableMoney == money){
                return true;
            }
        }
        return false;
    }

    public boolean isEnoughMoney(User user) {
        if (getItemList().size() < 1) throw new IllegalArgumentException();
        Item item = getItemList().get(0);

        int itemPrice = item.getPrice();
        int userMoney = user.getMoney();

        if (itemPrice <= userMoney) {
            return true;
        } else {
            return false;
        }
    }

    public void operation(User user) {
        if (isValidMoney(user.getMoney()) && isEnoughMoney(user)){
            String itemName = chooseItemName();
            System.out.println(itemName+"을(를) 구매해주셔서 감사합니다");

            int remainMoney = remainMoney(user);
            System.out.println("잔돈은 "+remainMoney+"원 입니다");
        }
    }

    public String chooseItemName() {
        if (getItemList().size() < 1) throw new IllegalArgumentException();
        Item item = getItemList().get(0);
        return item.getName();
    }

    public int remainMoney(User user) {
        if (getItemList().size() < 1) throw new IllegalArgumentException();
        Item item = getItemList().get(0);

        int itemPrice = item.getPrice();
        int userMoney = user.getMoney();

        if (itemPrice < userMoney) {
            return userMoney - itemPrice;
        } else {
            return 0;
        }
    }
}
