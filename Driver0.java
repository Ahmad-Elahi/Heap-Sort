import java.util.*;
public class Driver0{
  public static Sort sort = new Sort();
  public static void main(String[]args){
    Random rand = new Random();
    int size = 10;
    int[] a = new int [size];
    int l = size / 2 - 1;
    
    // generates random ints to fill array
    for(int i=0; i<size; i++){
      a[i] = rand.nextInt(10);
    }
    
    // displays original contents of array
    System.out.println("Initially, the array is: ");
    sort.displayArray(a, size);
    System.out.println("");
    
    System.out.println("BUILDING A HEAP...");
    
    // performs max heapify
    for(int i = size/2-1; i>=0; i--){ 
    sort.maxHeapify(a, i, size);
    System.out.println("max heapify on element with array index: " + l);
    sort.displayArray(a, size);
    l--;
    }
    
    System.out.println("Program written by Ahmad Elahi, about to sort the array!");
    System.out.println("");
    System.out.println("HEAP-SORT...");
    
    //performs heap sort
    sort.heapSort(a, size); 
    sort.displayArray(a, size);
  }
}
    