package com.example;

import java.util.List;

public class LionAlex extends Lion {

    private LionAlex(Predator predator) throws Exception {
        super("Самец", predator);
    }

    public static LionAlex create(Predator predator) throws Exception {
        return new LionAlex(predator);
    }


    List<String> getFriends(){
        return List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    }

    String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return super.getKittens(0);
    }

}
