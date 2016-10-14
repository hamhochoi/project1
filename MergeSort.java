import java.util.Scanner;

/**
 * Created by hamhochoi on 04/10/2016.
 */
public class MergeSort {

    static void merge(int A[], int first, int mid, int last){
        int first1 = first, last1 = mid;
        int first2 = mid + 1, last2 = last;

        int index = first1;

        int tempA[] = new int[A.length];

        // Tron 2 mang con

        for (; first1<=last1 && first2<=last2; index++){
            if (A[first1] < A[first2]){
                tempA[index] = A[first1];
                first1++;
            }
            else{
                tempA[index] = A[first2];
                first2++;
            }
        }

        // Them not day 1 vao mang

        for (; first1 <= last1; first1++){
            tempA[index] = A[first1];
            index ++;
        }

        // Them not day 2 vao mang

        for (; first2<=last2; first2++){
            tempA[index] = A[first2];
            index++;
        }

        for (int i=first; i <= last; i++){
            A[i] = tempA[i];
        }

    }

    static void mergeSort(int A[], int first, int last){
        int mid = (first + last)/2;

        if (first < last){
            mergeSort(A,first,mid);
            mergeSort(A,mid+1,last);
            merge(A,first,mid,last);
        }
    }

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        System.out.println("Nhap vao so phan tu cua mang: ");

        int N = scan.nextInt();

        int A[] = new int[N];

        // Them chuc nang nhap vao file ?!

        System.out.println("Nhap vao mang: ");

        for (int i=0; i<N; i++){
            A[i] = scan.nextInt();
        }

        scan.close();

        long startTime = System.currentTimeMillis();

        mergeSort(A,0,N-1);

        long endTime = System.currentTimeMillis();

        for (int i=0; i<N; i++){
            System.out.printf("%d ",A[i]);
        }

        System.out.println();


        long totalTime = endTime-startTime;
        System.out.println("Thoi gian chay :");
        System.out.printf("%d miliseconds",totalTime);

    }
}
