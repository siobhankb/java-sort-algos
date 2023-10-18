import java.util.*;
class SortAlgosBoylan{
}

class BubbleSort{
    public static void bubbleIntSort(int[] list) {
        // loop through list--
        // need to do as many iterations as items in list
        // to make sure all elements are tested
        for (int i = 0; i < list.length; i ++){
            
            // now just look at elements 0 -> second-to-last index
            // because you're going to be looking at the index + 1
            // -->> because the larger item will end up going to the end
            // of the list in each iteration, we know we won't have to 
            // test the ones at the end anymore
            // so if you also subtract 'i' from the length (or max index)
            // you'll eliminate extra work
            // (i is 1 means you've done one iteration, so there will be 
            // 1 item at the end that doesn't need to be tested anymore
            
            for (int n = 0; n < list.length - 1 - i; n ++){
                
                // if the element to the right is SMALLER, 
                if (list[n] > list[n+1]){
                    // swap it!
                    // store temp value
                    int temp = list[n];
                    // set value of list[n] to higher value at n+1
                    list[n] = list[n+1];
                    // set value of list[n + 1] to temp value
                    list[n + 1] = temp;
                } 
            }
            
        
        }
    }
    
    public static void bubbleStrSort(ArrayList<String> list) {
        // loop through list--
        // need to do as many iterations as items in list
        // to make sure all elements are tested
        for (int i = 0; i < list.size(); i ++){
            
            for (int n = 0; n < list.size() - 1 - i; n ++){
                
                // if the element to the right is SMALLER, 
                if (list.get(n).compareTo(list.get(n+1)) > 0){
                    // swap it!
                    // store temp value
                    String temp = list.get(n);
                    // set value of list[n] to higher value at n+1
                    list.set(n, list.get(n + 1));
                    // set value of list[n + 1] to temp value
                    list.set(n + 1, temp);
                } 
            }
            
        
        }
    }
    
    public static void main (String[] args){
        
        // test INTEGER bubble sort
        int[] intList = {3, 9, 1, 30, 42, 89, 12, 305, 17, 34};
        System.out.print("\nBefore Sort: ");
        
        for (int i = 0; i < intList.length; i ++){
            System.out.print(intList[i] + ",");
        }
        
        
        bubbleIntSort(intList);
        System.out.print("\nAfter Sort: ");
        
        for (int i = 0; i < intList.length; i ++){
            System.out.print(intList[i] + ",");
        }
        
        // test STRING bubble sort
        ArrayList<String> strList = new ArrayList<>(
        List.of("aardvark", "zebra", "gorilla", "wombat", "springbok", "budgie"));
        System.out.print("\nBefore Sort: " + strList);
        
        
        bubbleStrSort(strList);
        System.out.print("\nAfter Sort: " + strList);
            
    }
    
}

class SelectionSort{
    
    public static void selectionIntSort(int[] list){
        
        for (int i = 0; i < list.length; i ++) {
            // set min variable to first element
            // use to compare to other elements in list
            int min = list[i];
            int minIndex = i;
            
            // loop through starting at index i + 1
            // to find smallest value
            for (int n = i + 1; n < list.length; n ++){
                // if you find an element that's less than min variable
                if (list[n] < min){
                    // reset min
                    min = list[n];
                    minIndex = n;
                }
            }
            
            // now that you found the smallest element
            // swap it with the element at index i
            // set temp values
            int temp = list[i];
            list[i] = min;
            list[minIndex] = temp;
        }
        
    }
    
    public static void selectionStrSort(ArrayList<String> list){
        
        for (int i = 0; i < list.size(); i ++) {
            // set min variable to first element
            // use to compare to other elements in list
            String min = list.get(i);
            int minIndex = i;
            
            // loop through starting at index i + 1
            // to find smallest value
            for (int n = i + 1; n < list.size(); n ++){
                // if you find an element that's less than min variable
                if (list.get(n).compareTo(min) < 0){
                    // reset min
                    min = list.get(n);
                    minIndex = n;
                }
            }
            
            // now that you found the smallest element
            // swap it with the element at index i
            // set temp values
            String temp = list.get(i);
            list.set(i, min);
            list.set(minIndex, temp);
        }
        
    }
    
    public static void main (String[] args){
        
        // test selection sort for integers
        int[] intList = {3, 9, 1, 30, 42, 89, 12, 305, 17, 34};
        System.out.print("\nBefore Selection Sort: ");
        
        for (int i = 0; i < intList.length; i ++){
            System.out.print(intList[i] + ",");
        }
        
        
        selectionIntSort(intList);
        System.out.print("\nAfter Selection Sort: ");
        
        for (int i = 0; i < intList.length; i ++){
            System.out.print(intList[i] + ",");
        }
        
        
        // test STRING selection sort
        ArrayList<String> strList = new ArrayList<>(
        List.of("zebra", "gorilla", "aardvark", "wombat", "springbok", "budgie"));
        System.out.print("\nBefore Selection Sort: " + strList);
        
        
        selectionStrSort(strList);
        System.out.print("\nAfter Selection Sort: " + strList);
    }
}


class InsertionSort{
    
    public static void insertionIntSort(int[] list){
        
        // assume first element is in the right place
        // look at element to the right
        // if it's smaller, need to shift until
        // the elements to the left are all greater
        
        for (int i = 0; i < list.length - 1; i ++){
            // store element in question in temp variable
            int x = i + 1;
            int temp = list[x];
            
            // find out where the temp value belongs
            // to the left of it's current index, i
            while (x > 0 && temp < list[x-1]){
                list[x] = list[x - 1];
                x --;
            }
            list[x] = temp;
        }
    
    }
    
    public static void insertionStrSort(ArrayList<String> list){
        for (int i = 0; i < list.size() -1; i ++){
            int x = i + 1; 
            String temp = list.get(x);
            
            while(x > 0 && temp.compareTo(list.get(x - 1)) < 0){
                list.set(x, list.get(x - 1));
                x --;
            }
            
            list.set(x, temp);
        }
    }
    
    public static void main (String[] args){
        
        // test INSERTION sort for INTEGERS
        int[] intList = {9, 1, 30, 42, 89, 12, 305, 17, 34};
        System.out.print("\nBefore Insertion Sort: ");
        
        for (int i = 0; i < intList.length; i ++){
            System.out.print(intList[i] + ",");
        }
        
        
        insertionIntSort(intList);
        System.out.print("\nAfter Insertion Sort: ");
        
        for (int i = 0; i < intList.length; i ++){
            System.out.print(intList[i] + ",");
        }
        
        
        // test STRING Insertion sort
        ArrayList<String> strList = new ArrayList<>(
        List.of("zebra", "gorilla", "aardvark", "wombat", "springbok", "budgie"));
        System.out.print("\nBefore Insertion Sort: " + strList);
        
        
        insertionStrSort(strList);
        System.out.print("\nAfter Insertion Sort: " + strList);
    }
    
    
}
    
