package Amazon;

public class QuickSort {

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] arr = {2,44,546,12,3,5};
        qs.quick(arr, 0, arr.length-1);
        for(int num:arr){
            System.out.println(num);
        }
    }

    public void quick(int[] arr, int begin, int end){
        if(begin >= end) return;
        int pivot = arr[begin];
        int k = begin + 1;
        for(int i=begin+1;i<=end;i++){
            if(arr[i]<pivot){
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                k++;
            }
        }
        k = k-1;
        int tmp = arr[k];
        arr[k] = pivot;
        arr[begin] = tmp;
        quick(arr, begin, k-1);
        quick(arr, k+1, end);
    }
}
