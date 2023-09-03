package com.nhnacademy.mart;

import java.util.Scanner;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NhnMartShell {

    private  static final Logger logger = LoggerFactory.getLogger(MyLogback.class);

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer jaejun = new Customer(buyList);

        // 장바구니를 챙긴다.
        jaejun.bring(mart.provideBasket());
//
//        // 식품을 담는다.
        jaejun.pickFoods(mart.getFoodStand());
//
//        // 카운터에서 계산한다.
        jaejun.payTox(mart.getCounter(jaejun.getBasket()));

    }

    static BuyList inputBuyListFromShell() {



        // TODO Scanner 입력을 받아 buyList 만들기
        String line = "";

        Scanner sc = new Scanner(System.in);

        BuyList buyList = new BuyList();

        logger.trace("NHN 마트에 오신 것을 환영합니다. 사고싶은 물건을 골라주세요");
        line = sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            int amount = Integer.valueOf(st.nextToken());
            if(amount < 1) {
                logger.warn("한 개 이상의 상품을 골라주세요.");
                throw new IllegalArgumentException("한 개 이상의 상품을 골라주세요.");
            }
            buyList.add(new BuyList.Item(name,amount));
        }

        return buyList;
    }
}
