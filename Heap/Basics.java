package Heap;

import java.util.Arrays;
import java.util.Scanner;

class Basics {

//    int[] arr;
//    int size;
//    int capacity;
//    MinHeap(int c) {
//        arr = new int[c];
//        size = 0;
//        capacity = c;
//    }
//    static int left(int i) {
//        return 2*i+1;
//    }
//    static int right(int i) {
//        return 2*i+2;
//    }
    static int parent(int i) {
        return (i-1)/2;
    }

//    static void insert(int x, int size, int capacity){
//        if(size==capacity){
//            return;
//        }
//        size++;
//        arr[size-1] = x;
//        for (int i = size-1; i!=0 && arr[parent(i)]>arr[i]; i++) {
//            int temp = arr[i];
//            arr[i] = arr[parent(i)];
//            arr[parent(i)] = temp;
//            i = parent(i);
//        }
//    }
    static void minHeapify(int arr[], int size, int i){
        int lt = 2*i+1;
        int rt = 2*i+2;
        int smallest = i;
        if (lt < size && arr[lt] < arr[i])
            smallest = lt;
        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr,size,smallest);
        }
    }
    static int extractMin(int[] arr){
        int size = arr.length;
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = temp;
        size--;
        minHeapify(arr,size,0);
        return arr[size];
    }
    static void decreaseKey(int arr[],int i, int x){
        arr[i] = x;
        while(i!=0 && arr[parent(i)]>arr[i]){
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    static int deleteKey(int[] arr,int x){
        decreaseKey(arr,x, Integer.MIN_VALUE);
        int size = arr.length;
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = temp;
        size--;
        minHeapify(arr,size,0);
        return arr[size];
    }

    static void maxHeapify(int arr[], int size, int i){
        int lt = 2*i+1;
        int rt = 2*i+2;
        int largest = i;
        if (lt < size && arr[lt] > arr[largest])
            largest = lt;
        if (rt < size && arr[rt] > arr[largest])
            largest = rt;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr,size,largest);
        }
    }
    static void buildHeap(int arr[], int size){
        for (int i = (size-2)/2; i>=0 ; i--) {
            maxHeapify(arr,size,i);
        }
    }
    static void heapSort(int arr[])
    {
        int n = arr.length;

        buildHeap(arr,n);

        for (int i=n-1; i>0; i--)
        {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }
//    static int heapDelete(int arr[], int size){
//        if(size<1){
//            System.out.println("Heap Underflow");
//            return -1;
//        }
//        int max = arr[1];
//        arr[1] = arr[size];
//        maxHeapify(arr,0,size);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of heap");
        int size = in.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter heap elements");
        for (int i = 0; i <size ; i++) {
            arr[i] = in.nextInt();
        }
        buildHeap(arr,size);
        System.out.println("Heap: "+Arrays.toString(arr));
        deleteKey(arr,1);
        heapSort(arr);
        System.out.print("Sorted Heap: ");
        System.out.println(Arrays.toString(arr));
    }
}
