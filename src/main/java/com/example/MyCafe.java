package com.example;

import org.springframework.stereotype.Controller;

public class MyCafe {
    private Coffee coffee;
    MyCafe(){}
    MyCafe(Coffee coffee){
        this.coffee= coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
    public void result(){
        coffee.order();
        System.out.println("주문하신 음료 나왔습니다1");
    }
}
