import java.util.Arrays;
import java.util.LinkedList;

public class Wk06Q1{
    public static void addAndSort(LinkedList<Integer> list, int value){
        Integer newValue = Integer.valueOf(value);
        boolean inserted = false;

        for(int i = 0; !inserted && i<list.size(); i++){
            if(newValue<=list.get(i)){
                list.add(i, newValue);
                inserted = true;
            }
        }
        if(!inserted)list.add(newValue);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(1,3,5,7,9,11));
        System.out.println("Before: " + linkedList);
        addAndSort(linkedList, 6);
        System.out.println("After: " + linkedList);
    }
}