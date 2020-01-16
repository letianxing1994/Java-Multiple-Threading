package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Combination {
    public static void main(String[] args){
        String str1 = "34314";
        String str2 = "145";
        int[] arr = {2,31,34};
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for(int i=0;i<o1.length();i++){
                    if(o1.charAt(i)==o2.charAt(i))
                        continue;
                    return (int)o2.charAt(i) - (int)o1.charAt(i);
                }
                return 0;
            }
        });
        Combination c = new Combination();
        c.helper(pq, "", arr, 0);
        System.out.println(pq.poll());
    }

    public void helper(PriorityQueue<String> pq, String str, int[] arr, int len){
        if(len == arr.length){
            pq.add(str);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=Integer.MIN_VALUE){
                int tmp = arr[i];
                String new_str = str+arr[i];
                arr[i] = Integer.MIN_VALUE;
                helper(pq, new_str, arr, len+1);
                arr[i] = tmp;
            }
        }
    }
}
