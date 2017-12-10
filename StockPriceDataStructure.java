import java.util.*;

public class StockPriceDataStructure {
    static public class Data{
        public long timestamp;
        public int value;
        public boolean deleted;
        public Data(long timestamp,int value){
            this.timestamp=timestamp;
            this.value=value;
            this.deleted=false;
        }
        public String toString(){
            return timestamp+"  "+value;
        }
    }
   static public class Api{
        public HashMap<Long,Data> map;
        public PriorityQueue<Data> recent;
        public PriorityQueue<Data> max;
        public Api(){
            map=new HashMap<>();
            recent=new PriorityQueue<>(2,new Comparator<Data>(){
                public int compare(Data d1, Data d2){
                    if(d1.timestamp>d2.timestamp) return -1;
                    else return 1;
                }
            });

            max=new PriorityQueue<>(2, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    if(o1.value>o2.value) return -1;
                    else return 1;
                }
            });
        }

        public void update(long timestamp, int value){
            if(!map.containsKey(timestamp)) {
                Data tmp = new Data(timestamp, value);
                map.put(timestamp, tmp);
                recent.add(tmp);
                max.add(tmp);
            }
        }

        public void change(long timestamp,int value){
            if(map.containsKey(timestamp)&&map.get(timestamp).deleted!=true){
                Data data=map.get(timestamp);
                data.deleted=true;
                Data tmp=new Data(data.timestamp,value);
                max.add(tmp);
                recent.add(tmp);
            }
        }

        public void delete(long timestamp){
            if(map.containsKey(timestamp)){
                map.get(timestamp).deleted=true;
            }
            map.remove(timestamp);

        }

        public int getMaxPrice(){
            if(max.isEmpty()) return -1;
            else{
                while(max.peek().deleted==true){
                    max.poll();
                }
                Data data=max.peek();
                return data.value;
            }
        }

        public long getMostRecent(){
            if(recent.isEmpty()) return -1;
            else{
                while(recent.peek().deleted==true){
                    recent.poll();
                }
                Data data=recent.peek();
                return data.timestamp;
            }
        }

        public String toSting(){
            String s="";
            s+="the recent is: \n";
            while(!recent.isEmpty()){
                s+=recent.poll().toString()+"\n";
            }
            s+="the max is: \n";
            while(!max.isEmpty()){
                s+=max.poll().toString()+"\n";
            }
            return s;
        }

    }

    public static void main(String args[]){
        Api api=new Api();
        api.update(1000,6);
        api.update(1001,1);
        api.update(1002,5);
   //     System.out.println(api.toSting());
   //     api.delete(1000);
   //     api.delete(1002);
        api.change(1000,100);
        System.out.println(api.getMaxPrice());
        System.out.println(api.getMostRecent());
    }
}
