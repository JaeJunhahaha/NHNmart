package com.nhnacademy.mart;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodStand {

    private  static final Logger logger = LoggerFactory.getLogger(MyLogback.class);
    private final ArrayList<Food> foods = new ArrayList<>();
    private int foodStandAmount = 0;

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구현
    public Food delete(String foodName) {
        Food food1 = null;
        for (Food food : foods) {
            if (foodName.equals(food.getName())) {
                food1 = food;
                foods.remove(food);
                break;
            }
        }
        return food1;
    }

    public void FoodStandAmount(BuyList.Item item) {
        foodStandAmount = 0;
        for (Food food : foods) {
            if (item.getName().equals(food.getName())) {
                foodStandAmount = foodStandAmount + 1;
            }
        }

        if (foodStandAmount == 0) {
            logger.warn("마트에 존재하는 상품을 골라주세요.");
            throw new IllegalArgumentException("마트에 없는 상품입니다.");
        } else if (foodStandAmount < item.getAmount()) {
            logger.warn("마트에 있는 상품 개수보다 많습니다.");
            throw new IllegalArgumentException(item.getName() + "(이)가 부족합니다.");
        }
    }
}

