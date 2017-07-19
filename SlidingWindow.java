import java.util.LinkedList;

public class SlidingWindow {
    LinkedList<Integer> indexList = new LinkedList<>();
    public int[] maxArray(int[] array, int windowSize) {
        int[] max = new int[array.length-windowSize+1];
        for (int i = 0; i <array.length; i++) {
            add(array, indexList, i, windowSize);
            if (i >= windowSize) {
                if(i==windowSize) {
                    int windowMax=indexList.peekFirst();
                    max[0]=array[windowMax];
                }
                int windowMax = shrink(array, indexList, i - windowSize);
                max[i - windowSize+1] = array[windowMax];
            }
        }
        return max;
    }

    public void add(int[] array, LinkedList<Integer> indexList, int index, int windowsize) {
        if (indexList.isEmpty()) {
            indexList.add(index);
        } else {
            while(!indexList.isEmpty()) {
                int i=indexList.peekLast();
                if (array[index] >= array[i]) {
                    indexList.pollLast();
                } else {
                    break;
                }
            }
            indexList.addLast(index);
        }
    }

    public int shrink(int[] array, LinkedList<Integer> indexList, int index) {
        int i = indexList.peekFirst();
        if (index < i) {
            return i;
        } else {
            indexList.pollFirst();
            return indexList.peekFirst();
        }
    }

    public static void main(String args[]) {
        SlidingWindow sw = new SlidingWindow();
        int[] a = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int[] b = sw.maxArray(a, 3);

    }
}
