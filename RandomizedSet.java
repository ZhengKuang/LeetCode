import java.util.HashMap;

class RandomizedSet {
    HashMap<Integer,Integer> set;
    HashMap<Integer,Integer> reverse;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set=new HashMap<>();
        reverse=new HashMap<>();
        size=0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.get(val)!=null) return false;
        else{
            set.put(val,size);
            reverse.put(size,val);
            size++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.get(val)==null) return false;
        else{
            int index=set.get(val);
            if(index==size-1){
                set.remove(val);
                reverse.remove(index);
                size--;
            }
            else{
                set.remove(val);
                int lastValue=reverse.get(size-1);
                set.put(lastValue,index);
                reverse.remove(size-1);
                reverse.put(index,lastValue);
                size--;
            }
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index=(int)Math.random()*size;
        System.out.println(index);
        return reverse.get(index);
    }

    public int maxRotateFunction(int[] A) {
        int[] rotate=new int[A.length];
        for(int i=0;i<A.length;i++){
            int sum=0;
            int begin=i;
            for(int j=0;j<A.length;j++){
                sum+=A[begin]*j;
                begin++;
                if(begin==A.length) begin=0;
            }
            rotate[i]=sum;
        }
        int max=0;
        for(int i=0;i<rotate.length;i++){
            max=Math.max(max,rotate[i]);
        }
        return max;
    }

    public static void main(String args[]){
        RandomizedSet set=new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        System.out.println(set.getRandom());
        set.remove(1);
        set.insert(2);
        System.out.println(set.getRandom());
        set.maxRotateFunction(new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE});
    }
}