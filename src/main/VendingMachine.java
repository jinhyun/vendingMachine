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
}
