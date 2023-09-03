package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartShellTest {
    @Test
    @DisplayName("Basic Test")
    public void basicTest() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("양파",2));
        buyList.add(new BuyList.Item("계란",2));
        buyList.add(new BuyList.Item("파",4));

        Customer jaejun = new Customer(buyList);

        jaejun.bring(mart.provideBasket());
//
//        // 식품을 담는다.
        jaejun.pickFoods(mart.getFoodStand());
//
//        // 카운터에서 계산한다.
        jaejun.payTox(mart.getCounter(jaejun.getBasket()));

        Assertions.assertEquals(6000,jaejun.getMoney());

    }

    @Test
    @DisplayName("판매하지 않는 물품을 구매할 때")
    public void noItemBuyTest() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        FoodStand foodStand = new FoodStand();

        BuyList buyList = new BuyList();

        buyList.add(new BuyList.Item("고추",2));

        Customer jaejun = new Customer(buyList);

        jaejun.bring(mart.provideBasket());

        Assertions.assertThrows(IllegalArgumentException.class,() -> jaejun.pickFoods(mart.getFoodStand()));


    }

    @Test
    @DisplayName("구매하는 양이 재고보다 많은 양일때")
    public void overBuyTest() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        FoodStand foodStand = new FoodStand();

        BuyList buyList = new BuyList();

        buyList.add(new BuyList.Item("양파",3));

        Customer jaejun = new Customer(buyList);

        jaejun.bring(mart.provideBasket());

        Assertions.assertThrows(IllegalArgumentException.class,() -> jaejun.pickFoods(mart.getFoodStand()));


    }

    @Test
    @DisplayName("가지고 있는 돈보다 더 많이 나왔을 떄")
    public void noMoneyTest() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        FoodStand foodStand = new FoodStand();

        BuyList buyList = new BuyList();

        buyList.add(new BuyList.Item("사과",20));

        Customer jaejun = new Customer(buyList);

        jaejun.bring(mart.provideBasket());

        jaejun.pickFoods(mart.getFoodStand());

        Assertions.assertThrows(IllegalArgumentException.class,() -> jaejun.payTox(mart.getCounter(jaejun.getBasket())));


    }

}