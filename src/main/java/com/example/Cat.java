package com.example;

import java.util.List;

public class Cat {

    Predator predator;

    public Cat(Predator Predator) {
        this.predator = Predator;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
