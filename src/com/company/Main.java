package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //если вы просматриваете глазами метод main можно пролистать :)

    public static void main(String[] args) {
	// write your code here
        String [] strings = {"a", "B", "C"};
        Integer[] ints = {1,2,3,4};

        System.out.println("start mass");
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(ints));
        System.out.println("-----------------");

     //1
        System.out.println("1");
        System.out.println(Arrays.toString(changeElements(ints, 0, 1)));
        System.out.println("-----------------");
     //end 1

     //2
        System.out.println("2");
        ArrayList<String> str = toArrayList(strings);
        System.out.println(str.toString());
        ArrayList<Integer> integers = toArrayList(ints);
        System.out.println(integers.toString());
        System.out.println("-----------------");
     //end 2

     // 3
        // получаем 6 апельсинов
        Orange [] oranges = new Orange[6];
        for (int i = 0; i < oranges.length ; i++) {
            oranges[i] = new Orange();
        }
        //получаем 3 яблока
        Apple [] apples = new Apple[3];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }

        //еще 9 яблок
        Apple [] apples2 = new Apple[9];
        for (int i = 0; i < apples.length; i++) {
            apples2[i] = new Apple();
        }

        //кладем апельсины в коробку 1 (яблоки сюда не лезут)
        Box<Orange> orangeBox1 = new Box<>(oranges);
        orangeBox1.getCount();//выводим количество апельсин в коробке
        System.out.println("Box" + orangeBox1.getNumber() + " weight is " + orangeBox1.getWeight());
        System.out.println("----------");

        //кладем яблоки в коробку 2
        Box<Apple> appleBox1 = new Box<>(apples);
        appleBox1.getCount();
        System.out.println("Box" + appleBox1.getNumber() + " weight is " +appleBox1.getWeight());
        System.out.println("----------");

        //кладем яблоки в коробку 3
        Box<Apple> appleBox2 = new Box<>(apples2);
        appleBox2.getCount();
        System.out.println("Box" + appleBox2.getNumber() + " weight is " +appleBox2.getWeight());
        System.out.println("----------");

        //сравниваем вес коробок
        System.out.println("Box1 vs Box2:" + orangeBox1.compare(appleBox1));
        System.out.println("Box1 vs Box3:" + orangeBox1.compare(appleBox2));
        System.out.println("Box2 vs Box3:" + appleBox1.compare(appleBox2));
        System.out.println("----------");

        //пересыпаем с 1 коробки яблоки во 2
        System.out.println("Box2 pour into a Box3");
        appleBox1.intersperse(appleBox2);
        appleBox1.getCount();
        appleBox2.getCount();
    }

//end main

    //1. Написать метод, который меняет два элемента массива местами (массив может быть любого
    //ссылочного типа);

    //не нашел способа сделать метод без возращения массива (void)
    private static  <T> T[] changeElements(T[] arr, int firsEl, int secondEl){
        T k = arr[firsEl];
        arr[firsEl] = arr[secondEl];
        arr[secondEl] = k;
        return arr;
    }


    //2. Написать метод, который преобразует массив в ArrayList

    private static <T> ArrayList<T> toArrayList(T[] arr){
        if(arr == null) return null;

    // способ 1
        // return new ArrayList<>(Arrays.asList(args));
    // способ 2
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(arr[i]);
        }
    // способ 3
        // list.addAll(Arrays.asList(arr));

        return list;
    }


}
