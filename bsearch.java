/**
 * Created by zhengkuang on 12/3/17.
 */
public class bsearch {
    public static int bs(boolean[] array,int left, int right){
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid>0&&!array[mid]&&array[mid-1]) return mid;
            else if(array[mid]){
                left=mid+1;
            }
            else right=mid-1;
        }
        return -1;
    }

    public static void main(String[] args){
        boolean[] a=new boolean[]{true};
        System.out.println(bs(a,0,a.length-1));
    }
}
