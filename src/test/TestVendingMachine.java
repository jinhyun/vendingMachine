package test;

import main.User;
import main.VendingMachine;
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
    }

    /*
     * [v] feature: 자판기의 상품이 출력된다 (상품번호와 금액을 출력한다)
     * [v] feature: 사용자가 상품의 번호로 선택한다
     * [v] feature: 사용자가 금액을 자판기에 넣는다(금액은 500, 1000, 5000원권만 가능하다)
     *  [v] feature: 금액을 넣을때마다 금액이 출력된다
     * feature: 상품의 가격과 넣은 금액이 같거나 많을때 상품과 거스름돈을 출력한다
     * [v] refactor: 클래스 분리
     * refactor: 메세지 출력부 분리
     */

    // 자판기의 상품이 출력된다 (상품번호와 금액을 출력한다)
    @Test
    public void testViewItemList() {
        List<String> itemList = machine.getItemList();
        assertTrue(itemList.size() > 0);

        String resultView = machine.viewItemList();
        assertTrue(resultView.length() > 0);
    }

    // 사용자가 상품의 번호로 선택한다
    @Test
    public void testChooseItem() {
        User user = new User();
        VendingMachine userMachine = user.chooseItem(2);

        assertEquals(machine.getItemList().get(2),
                userMachine.getItemList().get(0));
    }

    // 사용자가 금액을 자판기에 넣는다(금액은 500, 1000, 5000원권만 가능하다)
    //  금액을 넣을때마다 금액이 출력된다
    @Test
    public void testPutMoney() {
        User user = new User();
        assertEquals(0, user.putMoney(50));         // warning
        assertEquals(1000, user.putMoney(1000));    // success
        assertEquals(1500, user.putMoney(500));     // success
        assertEquals(1500, user.putMoney(100));     // warning
    }

    @Test
    public void testIsValidMoney() {
        User user = new User();
        assertFalse(user.isValidMoney(50));
        assertFalse(user.isValidMoney(100));

        assertTrue(user.isValidMoney(500));
        assertTrue(user.isValidMoney(5000));
    }

    @Test
    public void testVendingMachineConstructor_initItemList() {
        String userItem = machine.getItemList().get(2);

        List <String> userItemList = new ArrayList<>();
        userItemList.add(userItem);

        VendingMachine vm1 = new VendingMachine(userItemList);
        assertEquals(userItemList, vm1.getItemList());

        VendingMachine vm2 = new VendingMachine(userItem);
        assertEquals(userItemList, vm2.getItemList());
    }
}