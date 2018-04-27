package com.company;

import java.util.ArrayList;
import java.util.Arrays;


class Box <T extends Fruit> {
    private ArrayList<T> boxPlace;
    private static int numerator = 0;
    private int number;

    int getNumber() {
        return number;
    }

    @SafeVarargs
    Box(T... args) {
        numerator++;
        this.boxPlace = new ArrayList<>();
        this.number = numerator;
        if(args != null){
            boxPlace.addAll(Arrays.asList(args));
        }
    }

    private void addFruit(T ... arg){
        boxPlace.addAll(Arrays.asList(arg));
    }

    void getCount(){
        System.out.println("Box"+number+" contains " + boxPlace.size() + " PCs" );
    }

//не нашел способа брать вес объекта из его класса, хотя геттер напасал. интересно было бы узнать как реализовать.
    float getWeight(){
        if(boxPlace.get(0).getClass().getName().equals(Orange.class.getName())) { //с учетом того, что фруктов всего 2 вида
            return boxPlace.size() * 1.5f;
        }else{
            return boxPlace.size();
        }
    }

    //сравниваем вес коробок
    boolean compare(Box<?> otherBox){
        return this.getWeight() == otherBox.getWeight();
    }

    //пересыпать в другую коробку
    //возможно, есть метод без использования итератора. хотелось бы увидеть.
    void intersperse(Box<T> otherBox){
        for (T arg : boxPlace) {
            otherBox.addFruit(arg);
        }
        boxPlace.clear();
    }
}
