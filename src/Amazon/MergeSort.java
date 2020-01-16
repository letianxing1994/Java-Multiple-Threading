package Amazon;

public class MergeSort {

    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        int[] arr = {2,44,546,12,3,5};
        int[] res = ms.mergesort(arr,0,5);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public int[] mergesort(int[] a, int begin, int end){
        if(begin == end) return new int[]{a[begin]};
        int middle = (end+begin)/2;
        int[] left = mergesort(a, begin, middle);
        int[] right = mergesort(a, middle+1, end);
        int[] res = new int[end-begin+1];
        merge(left, right, res);
        return res;
    }

    public void merge(int[] l, int[] r, int[] a){
        int i;
        int j;
        int k;
        for(i=0,j=0,k=0;i<l.length&&j<r.length;){
            if(l[i]<r[j]){
                a[k] = l[i];
                i++;
            }else{
                a[k] = r[j];
                j++;
            }
            k++;
        }
        if(i<l.length){
            for(;i<l.length;i++){
                a[k] = l[i];
                k++;
            }
        }else{
            for(;j<r.length;j++){
                a[k] = r[j];
                k++;
            }
        }
    }
}
