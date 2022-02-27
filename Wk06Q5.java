import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.UUID;

public class Wk06Q5 {
    public static void swapValues(LinkedList<String>linkedListKeys, LinkedHashMap<String,Integer>   linkedHashMap, Integer indexOne, Integer indexTwo){
        if(linkedListKeys.size() != linkedHashMap.size()){return;}
        LinkedHashMap<String,Integer>newHashMap = new LinkedHashMap<String,Integer>(); 
        String  firstKey = linkedListKeys.get(indexOne);
        Integer firstValue = linkedHashMap.get(firstKey);
        String  secondKey = linkedListKeys.get(indexTwo);
        Integer secondValue = linkedHashMap.get(secondKey);

        for(int i=0; i<linkedListKeys.size(); i++){
            if(i == indexOne){
                newHashMap.put(secondKey, secondValue);
            }else if(i == indexTwo){
                newHashMap.put(firstKey, firstValue);
            }else{
                String  oldKey = linkedListKeys.get(i);
                Integer oldValue = linkedHashMap.get(oldKey);
                newHashMap.put(oldKey,oldValue);
            }
        }
        linkedListKeys.remove(indexOne);
        linkedListKeys.add(indexOne,secondKey);
        linkedListKeys.remove(indexTwo);
        linkedListKeys.add(indexTwo,firstKey);

        for(int i=0; i<linkedListKeys.size(); i++){
            String  newKey = linkedListKeys.get(i);
            Integer newValue = newHashMap.get(newKey); 
            linkedHashMap.remove(newKey);
            linkedHashMap.put(newKey,newValue);
        }
    }

    public static void main(String[] args) {
        LinkedList<String>linkedListKeys = new LinkedList<String>();
        LinkedList<Integer>linkedListValues = new LinkedList<Integer>(Arrays.asList(1,3,5,7,9,11));
        LinkedHashMap<String,Integer>linkedHashMap = new LinkedHashMap<String,Integer>();

        for(int i=0; i<linkedListValues.size(); i++){
                linkedListKeys.add(UUID.randomUUID().toString());
                linkedHashMap.put(linkedListKeys.get(i), Integer.valueOf(linkedListValues.get(i)));
        }

        System.out.println("Before swap: " + linkedHashMap);
        swapValues(linkedListKeys,linkedHashMap, 5, 1);
        System.out.println("After swap: " + linkedHashMap);
    }
}
