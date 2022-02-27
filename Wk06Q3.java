import java.util.LinkedList;
import java.util.Random;

public class Wk06Q3 {
    public static Integer findValue(LinkedList<Integer> list, int searchVal){
        Integer findVal = Integer.valueOf(searchVal);
        for(Integer i = 0; i<list.size(); i++){
            if(list.get(i)==findVal){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final Integer size = 500;
        final Integer minVal = 1000;
        final Integer maxVal = 9999;
        Boolean invalid_value = false;
        int[] primitive_array = new Random().ints(size, minVal, maxVal).toArray();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0 ; !invalid_value && i < size ; i++){
            if(primitive_array[i]<minVal || primitive_array[i]>maxVal){
                System.out.println("Invalid random integer found");
                invalid_value = true;
            }else{
                linkedList.add( Integer.valueOf(primitive_array[i]));
            }     
        }
        System.out.println("LinkedList: " + linkedList);
        int[] searchVal = new Random().ints(1, minVal, maxVal).toArray();
        int index = findValue(linkedList, searchVal[0] );
        if(index > -1){
            System.out.println(searchVal[0] + " has been found within linkedlist at linkedList[" + index + "] = " + linkedList.get(index));
        } else{
            System.out.println(searchVal[0] + " cannot be found within linkedlist." );
        }          
    }        
}
