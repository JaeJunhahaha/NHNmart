package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    // TODO add 메서드 생성
    public void add(Item item) {
        items.add(item);
    }


    public static class Item {
        private final String name;
        private final int amount;


        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }


        public  String getName() {
            return this.name;
        }

        public int getAmount() {
            return this.amount;
        }

    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

}
