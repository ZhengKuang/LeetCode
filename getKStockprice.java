import java.util.*;

class getKStockprice {
    class Data implements Comparable{
        int value;
        int timestamp;
        public Data(int value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }

        public int compareTo(Object d1){
            return ((Data)d1).value-this.value;
        }

        public String toString(){
            return "value: "+value+"   "+"timestamp: "+timestamp+"\n";
        }
    }
    public int getMax(int[][] data, int t) throws Exception{
        if(data==null||data.length==0||data[0].length==0) throw new Exception("invalid input");
        int max=Integer.MIN_VALUE;
        boolean flag=true;
        for(int[] tmp:data){
            int time=tmp[1];
            int value=tmp[0];
            if(time<=t){
                max=Math.max(max,value);
                flag=false;
            }
            else continue;
        }
        if(flag) throw new Exception("No data is smaller than or equal to "+t);
        return max;
    }

    public List<Data> getKMax(int[][] data, int t, int k) throws Exception{
        if(data==null||data.length==0||data[0].length==0||k<=0) throw new Exception("invalid input");
        PriorityQueue<Data> pq=new PriorityQueue<>();
        List<Data> ans=new ArrayList<>();
        for(int[] tmp:data){
            if(tmp[1]<=t){
                Data cdata=new Data(tmp[0],tmp[1]);
                pq.add(cdata);
            }
        }
        for(int i=0;i<k;i++){
            if(pq.isEmpty()) break;
            ans.add(pq.poll());
        }
        return ans;
    }




    public static void main(String[] args){
        int[][] data=new int[][]{{101,2},{102,1},{103,4},{104,3},{105,5}};
        getKStockprice s=new getKStockprice();
        try{
            //	System.out.println(s.getMax(data,1));
            //	System.out.println(s.getMax(data,2));
            //	System.out.println(s.getMax(data,3));
            //	System.out.println(s.getMax(data,4));
            //	System.out.println(s.getMax(data,5));
            //	System.out.println(s.getMax(data,-1));
            System.out.println(Arrays.toString(s.getKMax(data,2,3).toArray()));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

