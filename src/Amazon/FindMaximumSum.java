package Amazon;

public class FindMaximumSum {
    public static void main(String[] args){
        FindMaximumSum fms = new FindMaximumSum();
        int[] arr = new int[]{2,0,3,-2};
        int[] res = fms.find(arr, 0, arr.length-1);
        System.out.println(res[0]+","+res[1]);
        System.out.println(res[2]);
    }

    public int[] find(int[] arr, int begin, int end){
        int[] res = new int[3];
        if(begin == end){
            res[0] = begin;
            res[1] = end;
            res[2] = arr[begin];
            return res;
        }
        int middle = (end+begin)/2;
        int[] left = find(arr, begin, middle);
        int[] right = find(arr, middle+1, end);
        int sum_left = arr[middle], s=0, left_limit = middle;
        for(int i=left_limit;i>=0;i--){
            s = s+arr[i];
            if(s>sum_left) {
                sum_left = s;
                left_limit = i;
            }
        }
        int sum_right = arr[middle+1], s1=0, right_limit = middle+1;
        for(int i=middle+1;i<=end;i++) {
            s1 = s1 + arr[i];
            if (s1 > sum_right) {
                sum_right = s1;
                right_limit = i;
            }
        }
        if(left[2]>=right[2]){
            res[2] = left[2];
            res[0] = left[0];
            res[1] = left[1];
        }else{
            res[2] = right[2];
            res[0] = right[0];
            res[1] = right[1];
        }
        if(sum_left+sum_right>res[2]){
            res[2] = sum_left+sum_right;
            res[0] = left_limit;
            res[1] = right_limit;
        }
        return res;
    }
}
