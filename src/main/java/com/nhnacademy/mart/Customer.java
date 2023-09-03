package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;
    private int money = 20000;

//    private ArrayList<BuyList.Item> items = new ArrayList<>();

//    public Basket getBasket() {
//        return basket;
//    }

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    private static final Logger logger = LoggerFactory.getLogger(MyLogback.class);


    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodstand) {
        int index;
        Food food = null;
        ArrayList<BuyList.Item> Items = buyList.getItems();
        for (BuyList.Item item : Items) {
            foodstand.FoodStandAmount(item);

            for (int i = 0; i < item.getAmount(); i++) {
                food = foodstand.delete(item.getName());
                basket.add(food);
            }
        }
    }

    public Basket getBasket() {
        return basket;
    }

    // TODO payTox 메서드 구현
    public void payTox(int payMoney) {
        money = money - payMoney;
        if (money < 0) {
            logger.warn("금액이 초과되었습니다.");
            throw new IllegalArgumentException("결제 금액이 부족합니다.");
        }
        logger.trace("고객님 결제 후 잔액 : " + getMoney());

    }

    public int getMoney() {
        return money;
    }

}

