package main;

import java.util.Scanner;

/**
 * Created by Jinhyun on 2015. 3. 9..
 */
public class App {
    public static void main (String[] args) {
        VendingMachine machine = new VendingMachine();
        User user = new User();

        machine.viewItemList();

        Scanner scanner = new Scanner(System.in);
        int itemNo = scanner.nextInt();

        UserVendingMachine userMachine = user.chooseItem(itemNo);

        while(true){
            System.out.println("금액 투입하세요");
            int money = scanner.nextInt();
            user.putMoney(money);

            if (userMachine.operation(user)){
                break;
            }
        }
    }
}