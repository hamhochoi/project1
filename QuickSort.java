    import java.util.*;

    /**
     * Created by hamhochoi on 05/10/2016.
     */
    public class QuickSort {

        static void swap(int A[], int a, int b){
            int temp = A[a];
            A[a] = A[b];
            A[b] = temp;
        }

        static int increasePartition(int A[], int first, int last){
            int privot = (first+last)/2;

            int tempA[] = new int[A.length];
            int index = first;

            // Chia 2 nua theo privot

                // Tim nhung phan tu nho hon A[privot] dua sang ben trai

            for (int i=first; i<=last; i++){
                if (i!=privot && A[i] <= A[privot]){
                    tempA[index] = A[i];
                    index++;
                }
            }

                // Them phan tu A[privot]

            tempA[index] = A[privot];
            int mid = index;    // vi tri cua phan tu privot
            index++;
            
                // Tim nhung phan tu lon hon A[privot] dua sang ben phai cua day

            for (int i=first; i<=last; i++){
                if (i!=privot && A[i] > A[privot]){
                    tempA[index] = A[i];
                    index++;
                }
            }

//            int i=0;
//            while (tempA[i] != A[(first+last)/2]){
//                i++;
//            }

            for (int j=first; j<=last; j++){
                A[j] = tempA[j];
            }


            privot = mid;

            return privot;

        }

        static int decreasePartition(int A[], int first, int last){
            int privot = (first+last)/2;

            int tempA[] = new int[A.length];
            int index = first;

            // Chia 2 nua theo privot

                // Tim nhung phan tu nho hon A[privot] dua sang ben trai

            for (int i=first; i<=last; i++){
                if (i!=privot && A[i] >= A[privot]){
                    tempA[index] = A[i];
                    index++;
                }
            }

                // Them phan tu A[privot]

            tempA[index] = A[privot];
            int mid = index;    // vi tri cua phan tu privot
            index++;
            
                // Tim nhung phan tu lon hon A[privot] dua sang ben phai cua day

            for (int i=first; i<=last; i++){
                if (i!=privot && A[i] < A[privot]){
                    tempA[index] = A[i];
                    index++;
                }
            }

//            int i=0;
//            while (tempA[i] != A[(first+last)/2]){
//                i++;
//            }

            for (int j=first; j<=last; j++){
                A[j] = tempA[j];
            }


            privot = mid;

            return privot;

        }
        
        
        static void increaseQuickSort(int A[],int first,int last) {

            if (first < last) {

                int privot = increasePartition(A, first, last);

                increaseQuickSort(A, first, privot - 1);
                increaseQuickSort(A, privot + 1, last);

            }
        }
        
        static void decreaseQuickSort(int A[],int first,int last) {

            if (first < last) {

                int privot = decreasePartition(A, first, last);

                decreaseQuickSort(A, first, privot - 1);
                decreaseQuickSort(A, privot + 1, last);
            }
        }
        
        


        public static void main(String args[]){

            System.out.println("Thuat toan sap xep QuickSort");

            System.out.println("Nhap vao kich thuoc day");

            int N = 0;
            Scanner scan = null;

            try {

                scan = new Scanner(System.in);
                N = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Loi nhap kich thuoc cua day, xin vui long nhap lai!");
                System.exit(0);
            }

            if (N<=0){
                System.out.println("Gia tri nhap khong hop le, vui long nhap lai!");
                System.exit(0);
            }

            int A[] = new int[N];

            System.out.println("Nhap vao day so: ");

            for (int i=0; i<N; i++){
                A[i] = scan.nextInt();
            }

            System.out.println("Nhap vao chuc nang: ");
            System.out.println("1. Sap xep tang dan.");
            System.out.println("2. Sap xep giam dan.");
            
            int m = scan.nextInt();
            
            scan.close();
            long startTime = System.currentTimeMillis();
            if (m == 1){
                increaseQuickSort(A, 0, N-1);
            }
            else 
                decreaseQuickSort(A,0,N-1);

            long endTime = System.currentTimeMillis();

            System.out.println("Day so sau khi sap xep la: ");
            for (int i=0; i<N; i++){
                System.out.printf("%d ", A[i]);
            }

            System.out.println();

            long totalTime = endTime-startTime;
            System.out.println("Thoi gian chay :");
            System.out.printf("%d miliseconds",totalTime);
        }
    }
