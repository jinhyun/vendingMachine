package main;

/**
* Created by Jinhyun on 2015. 3. 4..
*/
public class User {
    private int money;

    public VendingMachine chooseItem(int itemNo) {
        VendingMachine machine = new VendingMachine();
        String userItem = machine.getItemList().get(itemNo-0);

        System.out.println("[선택한 물품정보] "+userItem);

        return new VendingMachine(userItem);
    }

    public int putMoney(int money) {
        if (!isValidMoney(money)) {
            System.out.println("[주의] "+money+"원은 사용할 수 없습니다");
            return this.money;
        }
        this.money += money;

        System.out.println("[넣은금액] "+this.money+"원");

        return this.money;
    }

    public boolean isValidMoney(int money) {
        int[] enableMoneyList = {500, 1000, 5000};

        for (int enableMoney : enableMoneyList){
            if (enableMoney == money){
                return true;
            }
        }
        return false;
    }

    public int getMoney() {
        return money;
    }
}
