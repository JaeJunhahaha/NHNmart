package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasketTest {

    @Test
    @DisplayName("Basket 객체 생성 테스트")
    void basketConstructorTest() {
        Basket basket = new Basket();
        ArrayList<Food> foods = new ArrayList<>();
        basket.add(new Food("양파",4000));


    }

}