/**
 * Created by hamhochoi on 08/10/2016.
 */

import java.util.*;

public class BinarySearch {

    static int binarySearch(int A[], int key, int start, int end){
        int index=0;

        if (start <= end) {

            int mid = (start + end) / 2;

            if (A[mid] == key) {
                index = mid;
            } else if (A[mid] < key) {
                index = binarySearch(A, key, mid + 1, end);
            } else {
                index = binarySearch(A, key, start, mid - 1);
            }
        }
        else {
            return -1;
        }

        return index;
    }

    public static void main(String args[]){

        System.out.println("Thuat toan tim kiem nhi phan");
        System.out.println("Nhap vao so phan tu cua mang: ");

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int A[] = new int[N];

        System.out.println("Nhap vao mang: ");

        for (int i=0; i<N; i++){
            A[i] = scan.nextInt();
        }

        System.out.println("Nhap vao gia tri can tim kiem: ");
        int key = scan.nextInt();
        scan.close();

        long startTime = System.currentTimeMillis();

        int index = binarySearch(A,key,0,N-1);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime-startTime;

        if (index != -1) {
            System.out.printf("Gia tri can tim kiem o vi tri thu: %d \n", index);
        }
        else {
            System.out.println("Khong co phan tu trong mang!");
        }

        System.out.println("Thoi gian chay :");
        System.out.printf("%d miliseconds",totalTime);
    }


}
