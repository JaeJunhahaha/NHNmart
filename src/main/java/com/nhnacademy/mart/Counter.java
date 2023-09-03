package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {


    private static int counterMoney = 0;
    private Basket basket = new Basket();

    private  static final Logger logger = LoggerFactory.getLogger(MyLogback.class);

    private static ArrayList<Food> foods = new ArrayList<>();

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public static void pay(Basket basket) {
        foods = basket.getFoods();
        for (Food food:foods) {
            counterMoney = counterMoney + food.getPrice();
        }
    }

    public static int getCounterMoney() {
        logger.trace("총 가격은 " + counterMoney + "원 입니다.");

        return counterMoney;
    }
}
