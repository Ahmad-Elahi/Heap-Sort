
import java.util.Random;

public class Sort {
  
  private int LEFT(int i){
    return (2 * i + 1);
  }
  
  private int RIGHT(int i){
    return (2 * i + 2);
  }
  
 // swap the ith element with the jth elements.
 private void  swap(int[] a, int i, int j){
  int temp; 
  temp = a[i]; a[i] = a[j]; a[j] = temp;
 }
 
 // initialize the array a with elements from 0 to size-1. 
 public void  initializeArray(int[] a, int size){
  for (int i=0; i<size; i++){
   a[i]=i;
  }
 }
 
 // display the elements in the array a, rowSize elements per row. 
 public void  displayArray(int[] a, int size){
  int rowSize=100;
  for (int i=0; i<size; i++){
   if(i%rowSize==0){
    System.out.println();
   }
   System.out.print(a[i]+ " ");
  }
  System.out.println();
 }
 
  // randomly swap two elements in a for SWAPTIMES times. 
  public void randomizeArray(int[] a, int size){
  final int SWAPTIMES = 10000;
  Random r = new Random();
        int j, k;
        for(int i=0; i< SWAPTIMES; i++){
         j = r.nextInt(size);
         k = r.nextInt(size);
         this.swap(a,  j, k);
        }
 }
 
 
 // selectionSort
 public void selectionSort(int a[], int size){
  int i, j, min, minIndex;
  for (j=0; j<size-1; j++){// select jth element.
   minIndex=j; min = a[j]; 
   for (i=j+1; i<size; i++){
    if(a[i] < min ){minIndex=i; min = a[i];}
   }
   this.swap(a, j, minIndex);
  }
 }
 
 // insertion sort
 public void insertionSort(int[] a, int size){
   int key;
   int i;
   // 1: for j <- 2 to length[A]
   for (int j=1; j<size; j++){ 
     // 2: key <- A[j]
     key = a[j]; 
     // 3: i <- j-1
     i = j-1;
     // 4: while i>0 and A[i] > key
     while (i>0 && a[i]>key){ 
       // 5: A[i+1] <- A[i]
       a[i+1] = a[i];
       // 6: i <- i-1
       i = i-1;
     }
     // 7: A[i+1] <- key
     a[i+1] = key;
   }
 }
 
 // max heapify
 public void maxHeapify(int a[], int i, int HSize){
   // 1: l <- LEFT(i)
   int l = LEFT(i);
   // 2: r <- RIGHT(i)
   int r = RIGHT(i); 
   int largest;
   // 3: if l <= heapSize[A] and A[l] > A[i]
   if(l < HSize && a[l] > a[i]){ 
     // 4: then largest <- l
     largest = l;
   }
   else{
     // 5: else largest <- i
     largest = i;
   }
   // 6: if r <= heapSize[A] and A[r] > A[largest]
   if(r < HSize && a[r] > a[largest]){ 
     // 7: then largest <- r
     largest = r;
   }
   // 8: if largest != i 
   if(largest != i){
     // 9: then exchange A[i] <-> A[largest]
     swap(a, i, largest);
     // 10: MaxHeapify(A, largest) 
     maxHeapify(a, largest, HSize);
   }
 }
 
 // build max-heap
 public void buildMaxHeap(int a[]){
   // 1: heapSize[A] <- length[A]
   int HSize = a.length; 
   // 2: for i <- floorOf(length[A]/2) downto 1
   for(int i= (HSize/2)-1; i>=0; i--){ 
     // 3: do MaxHeapify(A, i)
     maxHeapify(a, i, HSize); 
   }
 }
 
 // heap sort
 public void heapSort(int a[], int size){
   // 1: BuildMaxHeap(A)
   buildMaxHeap(a);
   // 2: for i <- length[A] downto 2
   for(int i= size -1; i>=0; i--){
     // 3: do exchange A[1] <-> A[i]
     swap(a, 0, i); 
     // 4: heapSize[A] <- heapSize[A] - 1 
     size = size - 1; 
     // 5: MaxHeapify(A, 1)
     maxHeapify(a, 0, size); 
   }
 }
}   
