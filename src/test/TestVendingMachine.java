package test;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/**
 * Created by Jinhyun on 2015. 3. 3..
 */
public class TestVendingMachine {
    private VendingMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = new VendingMachine();
        machine.setTempItemList();
    }

    /*
     * [v] 자판기의 상품이 출력된다 (상품번호와 금액을 출력한다)
     * [v] 사용자가 상품의 번호로 선택한다
     * 사용자가 금액을 자판기에 넣는다(금액은 100, 500, 1000, 5000원권만 가능하다)
     *  금액을 넣을때마다 금액이 출력된다
     * 상품의 가격과 넣은 금액이 같거나 많을때 상품과 거스름돈을 출력한다
     */
    @Test
    public void viewItemList() {
        List<String> itemList = machine.getItemList();
        assertTrue(itemList.size() > 0);

        String resultView = machine.viewItemList();
        assertTrue(resultView.length() > 0);
    }

    @Test
    public void chooseItem() {
        User user = new User();
        VendingMachine choosedMachine = new VendingMachine();
        choosedMachine = user.chooseItem(2);

        assertEquals(machine.getItemList().get(2),
                choosedMachine.getItemList().get(0));
    }

    private class VendingMachine {
        private List<String> itemList;

        public void setItemList(List<String> itemList) {
            this.itemList = itemList;
        }

        public List<String> getItemList() {
            return itemList;
        }

        public String viewItemList() {
            String resultView = "";
            for (String result : itemList){
                System.out.println(result);
                resultView += result;
            }
            return resultView;
        }

        public void setTempItemList() {
            itemList = new ArrayList<>();
            itemList.add("1: 자일리톨 (500원)");
            itemList.add("2: 아이폰6 (125,800원)");
            itemList.add("3: 스크류바 (1,200원)");
            itemList.add("4: 맥북 (299,900원)");
        }
    }

    private class User {
        private int itemNo;

        public int getItemNo() {
            return itemNo;
        }

        public VendingMachine chooseItem(int itemNo) {
            VendingMachine machine = new VendingMachine();
            machine.setTempItemList();
            String choosedItem = machine.getItemList().get(itemNo-0);

            System.out.println("선택한 물품정보");
            System.out.println(choosedItem);

            List <String> choosedItemList = new ArrayList<>();
            choosedItemList.add(choosedItem);

            VendingMachine resultMachine = new VendingMachine();
            resultMachine.setItemList(choosedItemList);
            return resultMachine;
        }
    }
}