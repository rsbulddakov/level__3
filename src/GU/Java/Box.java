package GU.Java;
import GU.Java.Fruits.Fruit;
import java.util.ArrayList;

public class Box<T extends Fruit>{
    private final ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void put(T fruit){
        list.add(fruit);
    }

    public void clear(){
        list.clear();
    }

    public float getWeight(){
        if(list.size() == 0) return 0;
        float weight = 0f;
        for (T item : list){
            weight += item.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?extends Fruit> box){
        final double THRESHOLD = .0001;
        return Math.abs(this.getWeight() - box.getWeight()) < THRESHOLD;
    }

    public void shiftToBox(Box<T> box){
        box.list.addAll(this.list);
        clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}
