import java.util.*;

class MedianoftwoSortedArray{
    public static double findMedian(int[] A, int [] B){
        int m=A.length,n=B.length;
        int r=(1+m+n)/2;
        int l=(1+1+m+n)/2;

        return (findKth(A,0,B,0,r)+findKth(A,0,B,0,l))/2.0;

    }

    public static int findKth(int[] A, int astart, int[] B, int bstart, int k){
        if(astart>=A.length) return B[bstart+k-1];
        if(bstart>=B.length) return A[astart+k-1];

        int amid=Integer.MAX_VALUE;
        int bmid=Integer.MAX_VALUE;
        if(astart+k/2-1<A.length) amid=A[astart+k/2-1];
        if(bstart+k/2-1<B.length) bmid=B[bstart+k/2-1];

        if(amid<bmid){
            return findKth(A,astart+k/2,B,bstart,k-k/2);
        }
        else{
            return findKth(A,astart,B,bstart+k/2,k-k/2);
        }

    }





    public static void main(String args[]){
        int[] A=new int[]{1,9,10,11,12,16,17};
        int[] B=new int[]{2,3,15,17};
        System.out.println(findMedian(A,B));
    }
}