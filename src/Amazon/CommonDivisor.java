package Amazon;

public class CommonDivisor {
    public static int res = Integer.MAX_VALUE;
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6};
        int times = 3;
        helper(arr, 0, 3, Integer.MIN_VALUE, 0);
        System.out.println(res);
    }

    public static void helper(int[] arr, int time, int times, int max, int idx){
        if(time == times&&idx==arr.length){
            res = Math.min(max, res);
            return;
        }
        int tmp_num = 0;
        for(int i=idx;i<arr.length;i++){
            tmp_num = arr[i]+tmp_num;
            helper(arr, time+1, times, Math.max(max, tmp_num), i+1);
        }
    }

    public static int commonDivisor(int num1, int num2){
        if(num1==num2) return num1;
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        while(max!=min){
            int tmp1 = max-min;
            int tmp2 = min;
            max = Math.max(tmp1, tmp2);
            min = Math.min(tmp1, tmp2);
        }
        return min;
    }
}
