package main;

import java.util.ArrayList;
import java.util.List;

/**
* Created by Jinhyun on 2015. 3. 4..
*/
public class VendingMachine {
    public VendingMachine() {
        setItemList(initItemList());
    }

    public VendingMachine(String initItem) {
        List<String> list = new ArrayList<>();
        list.add(initItem);
        setItemList(list);
    }

    public VendingMachine(List<String> initItemList){
        setItemList(initItemList);
    }

    private List<String> itemList;

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public String viewItemList() {
        String resultView = "";
        System.out.println("----------------------");
        for (String result : itemList){
            System.out.println(result);
            resultView += result;
        }
        System.out.println("----------------------");
        return resultView;
    }

    public List<String> initItemList() {
        List <String> initItemList = new ArrayList<>();
        initItemList.add("1: 자일리톨 (500원)");
        initItemList.add("2: 아이폰6 (125,800원)");
        initItemList.add("3: 스크류바 (1,200원)");
        initItemList.add("4: 맥북 (299,900원)");
        return initItemList;
    }

    public void operation(User user) {
        if (isEnoughMoney(user)){
            String itemName = outItem();
            System.out.println(itemName+"을(를) 구매해주셔서 감사합니다");

            int remainMoney = remainMoney(user);
            System.out.println("잔돈은 "+remainMoney+"원 입니다");
        }
    }

    public boolean isEnoughMoney(User user) {
        String itemInfo = getItemList().get(0); // Error 발생률 높음 : 수정필

        int startIdx = itemInfo.indexOf("(")+1;
        int endIdx = itemInfo.lastIndexOf(")")-1;
        String strItemPrice =
                itemInfo.substring(startIdx, endIdx).replaceAll(",", "");

        int itemPrice = Integer.parseInt(strItemPrice);
        int userMoney = user.getMoney();

        if (itemPrice <= userMoney) {
            return true;
        } else {
            return false;
        }
    }

    public String outItem() {
        String itemInfo = getItemList().get(0); // Error 발생률 높음 : 수정필
        int startIdx = itemInfo.indexOf(":")+2;
        int endIdx = itemInfo.indexOf("(")-1;

        return itemInfo.substring(startIdx, endIdx);
    }

    public int remainMoney(User user) {
        String itemInfo = getItemList().get(0); // Error 발생률 높음 : 수정필

        int startIdx = itemInfo.indexOf("(")+1;
        int endIdx = itemInfo.lastIndexOf(")")-1;
        String strItemPrice =
                itemInfo.substring(startIdx, endIdx).replaceAll(",", "");

        int itemPrice = Integer.parseInt(strItemPrice);
        int userMoney = user.getMoney();

        if (itemPrice < userMoney) {
            return userMoney - itemPrice;
        } else {
            return 0;
        }
    }
}
