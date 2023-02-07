package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Создать словарь HashMap. Обобщение <Integer, String>.
        Map<Integer,String> map1 = new HashMap<>();
// Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
        map1.put(1,"white");
        map1.put(2,"blue");
        map1.put(3,"black");
        map1.putIfAbsent(5,"red");
        map1.forEach((k,v)-> System.out.println(k+","+v));
// Изменить значения дописав восклицательные знаки.
        Set<Integer> keymap1 = map1.keySet();
        for (Integer i: keymap1
        ) {
            map1.compute(i,(k,v)->v+="!");

        }
        map1.forEach((k,v)-> System.out.println("Измененные значение от ключа "+k+" равно "+v));
//   *Создать TreeMap, заполнить аналогично.
        Map<Integer,String> map2 = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<4; i++) {
            System.out.println("Введите значение цвета, соответствующее ключу "+i+" ");
            String color = scanner.nextLine();
            map2.put(i,color);
        }
        //scanner.close();
        Set<Integer> keymap2 = map2.keySet();
        for (Integer i:keymap2
        )
        {map2.compute(i,(k,v)->v+="!");

        }
        map2.forEach((k,v)-> System.out.println("Измененные значение от ключа во втором словаре "+k+" равно "+v));
//*Увеличить количество элементов таблиц до 10000 случайными ключами и общей строкой.
        map1.clear();
        int j = 0;
        Set<Integer> keysset = map1.keySet();
        for(int i=0; i<10000;i++) {
            do {
                j = new Random().nextInt(0, 1000000);
            } while(keysset.contains(j));
            //keysset.add(j);
            map1.put(j,"string");

        }
        int k = 1;
        for (Integer m:keysset
        ) {
            System.out.println(k+". "+m+" , "+map1.get(m));
            k++;
        }
// тоже самое, только для коллекции TreeMap
        map2.clear();
        int d = 0;
        Set<Integer> keysset2 = map2.keySet();
        for(int i=0; i<10000;i++) {
            do {
                j = new Random().nextInt(0, 1000000);
            } while(keysset2.contains(j));
            //keysset2.add(j);
            map2.put(j,"string");

        }
        int z = 1;
        for (Integer m:keysset
        ) {
            System.out.println(z+". "+m+" , "+map1.get(m));
            z++;
        }
//      **Сравнить время прямого и случайного перебора тысячи элементов словарей.
        long time1 = System.currentTimeMillis();
        map1.forEach((l,v)-> System.out.println(l+" , "+v));
        long time2 = System.currentTimeMillis();
        ArrayList<Integer> arrmap1 = new ArrayList<>(keysset);
        int rndkey1 = 0;
        Random random = new Random();
        for(int i=0; i<10000; i++) {
            rndkey1 = arrmap1.get(random.nextInt(0,arrmap1.size()-1));
            System.out.println(map1.get(rndkey1));
        }
        long time3 = System.currentTimeMillis();


        long time4 = System.currentTimeMillis();
        map2.forEach((l,v)-> System.out.println(l+" , "+v));
        long time5 = System.currentTimeMillis();
        ArrayList<Integer> arrmap2 = new ArrayList<>(keysset2);
        int rndkey2 = 0;
        Random random1 = new Random();
        for(int i=0; i<10000; i++) {
            rndkey2 = arrmap2.get(random1.nextInt(0,arrmap2.size()-1));
            System.out.println(map2.get(rndkey2));
        }
        long time6 = System.currentTimeMillis();
        System.out.println("для  перебора словаря типа HashMap из 1000 элементов\n" +
                "прямым способом потребуется " +(time2-time1)+ "\nслучайным выбором потребуется "+(time3-time2));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("для  перебора словаря типа TreeMap из 1000 элементов\n" +
                "прямым способом потребуется " +(time5-time4)+ "\nслучайным выбором потребуется "+(time6-time5));

    }
}