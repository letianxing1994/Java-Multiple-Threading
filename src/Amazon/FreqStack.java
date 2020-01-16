package Amazon;
import java.util.*;

class FreqStack {
    //store the frequency of each num
    HashMap<Integer,Integer> freq;
    //store the num list of certain frequency
    TreeMap<Integer, List<Integer>> counter;
    //store the value
    ArrayList<Integer> arr;
    public FreqStack() {
        freq = new HashMap<>();
        counter = new TreeMap<>();
        arr = new ArrayList<>();
    }

    public void push(int x) {
        arr.add(x);
        int times = freq.getOrDefault(x, 0);
        freq.put(x, times+1);
        if(counter.containsKey(times)){
            counter.get(times).remove((Integer)x);
        }
        counter.putIfAbsent(times+1, new ArrayList<Integer>());
        if(!counter.get(times+1).contains((Integer)x))
            counter.get(times+1).add(x);
    }

    public int pop() {
        if(arr==null||arr.size()==0) return -1;
        List<Integer> list = counter.lastEntry().getValue();
        int val = -1;
        for(int i=arr.size()-1;i>=0;i--){
            if(list.contains(arr.get(i))){
                val = arr.get(i);
                arr.remove(i);
                break;
            }
        }
        int times = freq.get(val);
        if(times-1==0) freq.remove(val);
        else freq.put(val, times-1);
        counter.get(times).remove((Integer)val);
        if(counter.get(times).size()==0) counter.remove(times);
        counter.getOrDefault(times-1, new ArrayList<>()).add((Integer)val);
        return val;
    }


    public static void main(String[] args){
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}
