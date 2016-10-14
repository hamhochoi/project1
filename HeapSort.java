import java.util.Scanner;

/**
 * Created by hamhochoi on 07/10/2016.
 */

public class HeapSort {

    static void maxHeapify(int A[],int i,int n){
        // n la kich thuoc cua dong == kich thuoc mang A[]
        // i la vi tri cua node dang xet, vi pham tinh chat dong



        int childLeft = 2*i;
        int childRight = 2*i+1;

        int max;

        if (childLeft <= n && A[childLeft] > A[i]){
            max = childLeft;
        }
        else{
            max = i;
        }

        if (childRight <= n) {
            if (A[childRight] > A[max]) {
                max = childRight;
            }
        }

        if (max != i){
            int temp = A[max];
            A[max] = A[i];
            A[i] = temp;
        }
        else{
            return;
        }

        maxHeapify(A,max,n);
    }






    static void buildMaxHeap(int A[]){
        int n = A.length - 1;

        for (int i=n/2; i>0; i--){
            maxHeapify(A,i,n);
        }

    }

    static void heapSort(int A[]){
        buildMaxHeap(A);

       /* Sap xep tang dan
        */
        for (int i=A.length-1; i>= 2; i--) {

            int temp = A[i];
            A[i] = A[1];
            A[1] = temp;

            maxHeapify(A, 1, i - 1);
        }
    }



    public static void main(String args[]){

        System.out.println("Thuat toan sap xep Heap Sort");

        Scanner scan = new Scanner(System.in);

        System.out.println("Nhap vao kich thuoc cua day so: ");
        int n = scan.nextInt();
        int A[] = new int[n+1];

        System.out.println("Nhap vao day so:");

        for (int i=1; i<=n; i++){
            A[i] = scan.nextInt();
        }
        scan.close();
        long startTime = System.currentTimeMillis();

        heapSort(A);
        long endTime = System.currentTimeMillis();

        for (int i=1; i<=n; i++){
            System.out.printf("%d ",A[i]);
        }
        System.out.println();

        long totalTime = endTime-startTime;
        System.out.println("Thoi gian chay :");
        System.out.printf("%d miliseconds",totalTime);


    }

}
