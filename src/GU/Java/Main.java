package GU.Java;

import GU.Java.Fruits.Apple;
import GU.Java.Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        doTask1();
        doTask2();
        doTask3();
    }

    /**
     * Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
     * */
    public static void doTask1(){

        String[] array = new String[]{
                "A", "B", "C", "D", "E", "F"
        };
        arrayElementsReplace(array, "A", "D");
        arrayElementsReplace(array, "V", "E");
        arrayElementsReplace(array, "A", "X");

        printArray(array);
    }

    /**
     * Написать метод, который преобразует массив в ArrayList
     * */
    public static void doTask2(){
        Object[] array = new Object[]{
                "A", "B", "C", "D", "E", "F"
        };
        var list = castArrayToArrayList(array);
        System.out.println(list);
    }

    /**
     *
     * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
     * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
     * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
     * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
     * g. Не забываем про метод добавления фрукта в коробку.
     *
     * */
    public static void doTask3(){

        Box<Orange> orangeBox = new Box<>();
        for(int i = 0; i < 4; i++){
            orangeBox.put(new Orange());
            System.out.println(orangeBox.getWeight());
        }

        Box<Apple> appleBox = new Box<>();
        for(int i = 0; i < 6; i++){
            appleBox.put(new Apple());
        }

        Box<Apple> halfAppleBox = new Box<>();
        for(int i = 0; i < 3; i++){
            halfAppleBox.put(new Apple());
        }

        System.out.println(orangeBox.compare(appleBox));

        System.out.println(appleBox.toString());
        appleBox.shiftToBox(halfAppleBox);
        System.out.println(halfAppleBox.toString());
    }

    public static <T> void arrayElementsReplace(T[] array, T element1, T element2){
        int e1Index = Arrays.asList(array).indexOf(element1),
            e2Index = Arrays.asList(array).indexOf(element2);

        if(e1Index == -1){
            System.out.println("Array doesn't exist: " + element1);
        } else if (e2Index == -1){
            System.out.println("Array doesn't exist: " + element2);
        } else {
            T tmp = array[e1Index];
            array[e1Index] = element2;
            array[e2Index] = tmp;
        }
    }

    public static<T> ArrayList<T> castArrayToArrayList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    public static<T> void printArray(T[] array){
        for (T element : array) {
            System.out.print(element + "; ");
        }
        System.out.println();
    }
}
