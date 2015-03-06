package test;

import main.User;
import main.UserVendingMachine;
import main.VendingMachine;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Jinhyun on 2015. 3. 3..
 */
public class TestVendingMachine {
    private VendingMachine machine;
    private User user;

    @Before
    public void setUp() throws Exception {
        machine = new VendingMachine();
        user = new User();
    }

    /*
    VendingMachine DevelopList
    [v] feature: 자판기의 상품이 출력된다
        [v] detail: 상품번호와 금액을 출력한다
    [v] feature: 사용자가 상품의 번호로 선택한다
    [v] feature: 사용자가 금액을 자판기에 넣는다
        [v] condition: 금액은 500, 1000, 5000원권만 가능하다
        [v] detail: 금액을 넣을때마다 금액이 출력된다
    [v] feature: 구매상품을 출력한다
        [v] condition: 상품가격과 넣은금액이 같거나 많을때
        [v] feature: 잔돈을 출력한다
    [ ] feature: 구매취소
        [ ] detail: 넣은금액 반환

    [v] refactor: 클래스 분리
    [v] refactor(All): initData를 Item Object(Bean)로 변경, 출력부 수정
    [ ] refactor(All): 메세지 출력부 분리
     */

    // 자판기의 상품이 출력된다 (상품번호와 금액을 출력한다)
    @Test
    public void testViewItemList() {
        machine.viewItemList();
    }

    // 사용자가 상품의 번호로 선택한다
    @Test
    public void testChooseItem() {
        UserVendingMachine userMachine = user.chooseItem(2);

        assertEquals(machine.getItemList().get(2).getName(),
                userMachine.getItemList().get(0).getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChooseItem_없는상품번호일경우() {
        UserVendingMachine userMachine = user.chooseItem(6);
    }

    @Test
    public void testIsEnoughMoney() {
        UserVendingMachine userMachine = user.chooseItem(2);

        user.putMoney(1000);
        assertFalse(userMachine.isEnoughMoney(user));

        user.putMoney(500);
        assertTrue(userMachine.isEnoughMoney(user));
    }

    @Test
    public void testChooseItemName() {
        UserVendingMachine userMachine = user.chooseItem(2);
        assertEquals("스크류바", userMachine.chooseItemName());
    }

    @Test
    public void testRemainMoney() {
        UserVendingMachine userMachine = user.chooseItem(2);
        user.putMoney(1000);
        user.putMoney(500);
        assertEquals(300, userMachine.remainMoney(user));
    }

    @Test
    public void testOpertaion() {
        UserVendingMachine userMachine = user.chooseItem(2);
        user.putMoney(1000);
        user.putMoney(500);
        userMachine.operation(user);
    }

    // 사용자가 금액을 자판기에 넣는다(금액은 500, 1000, 5000원권만 가능하다)
    //  금액을 넣을때마다 금액이 출력된다
    @Test
    public void testPutMoney() {
        assertEquals(0, user.putMoney(50));         // warning
        assertEquals(1000, user.putMoney(1000));    // success
        assertEquals(1500, user.putMoney(500));     // success
        assertEquals(1500, user.putMoney(100));     // warning
    }

    @Test
    public void testIsValidMoney() {
        assertFalse(UserVendingMachine.isValidMoney(50));
        assertFalse(UserVendingMachine.isValidMoney(100));

        assertTrue(UserVendingMachine.isValidMoney(500));
        assertTrue(UserVendingMachine.isValidMoney(5000));
    }
}