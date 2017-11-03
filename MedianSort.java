import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianSort {
    private static class MedianHolder {
        private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(2,new MaxComparator());
        private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(2,new MinComparator());


        public void addNumber(int number) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(number);
            } else {
                if (number < maxHeap.peek()) {
                    maxHeap.add(number);
                    maxHeap.toString();
                } else {
                    minHeap.add(number);
                }
                if (maxHeap.size() - 2 == minHeap.size()) {
                    int value = maxHeap.poll();
                    minHeap.add(value);
                } else if (maxHeap.size() + 2 == minHeap.size()) {
                    int value = minHeap.poll();
                    maxHeap.add(value);
                }

            }
            if (Math.abs(maxHeap.size() - minHeap.size()) >= 2) {
                System.out.println("Error occur!");
            }
            System.out.print(getMedian());
        }

        public double getMedian() {
            if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        }

    }


    private static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;

            }
        }
    }

    private static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return -1;
            } else {
                return 1;
            }
        }
    }


    public static int[] generateRandomArray(int length, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i != length - 1; i++) {
            array[i] = (int) (Math.random() * maxValue) + 1;
        }
        return array;
    }

    public static void validMedian(int[] array, int index) {
        int[] sortedArray = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            sortedArray[i] = array[i];
        }
        Arrays.sort(sortedArray);
        double value;
        if (index % 2 == 0) {
            value = sortedArray[(index + 1) / 2];
        } else {
            value = (sortedArray[index / 2] + sortedArray[index / 2 + 1]) / 2.0;
        }
        System.out.print(" " + value);
    }

    public static void main(String args[]) {
      //  int[] array = generateRandomArray(100, 10000);
        int[] array={3,2,4,5,1,6,7,8,9};
        MedianHolder mh = new MedianHolder();
        for (int i = 0; i < array.length; i++) {
            mh.addNumber(array[i]);
            validMedian(array, i);
            System.out.println();
        }
    }
}
