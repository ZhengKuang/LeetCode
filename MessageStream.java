import java.util.HashMap;

public class MessageStream {
    public static class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class MessageStruct {
        public HashMap<Integer, Node> map1 = new HashMap<>();
        public HashMap<Integer, Node> map2 = new HashMap<>();
        public int waitValue = 1;

        public void consumeMessage(int value) {
            Node node = new Node(value);
            map1.put(value, node);
            map2.put(value, node);
            if (map2.containsKey(value - 1)) {
                map2.get(value - 1).next = node;
                map2.remove(value - 1);
            }
            if (map2.containsKey(value + 1)) {
                node.next = map2.get(value + 1);
                map2.remove(value);
            }
            if (map1.containsKey(value + 1)) {
                node.next = map1.get(value + 1);
                map1.remove(value + 1);
            }
            if (map1.containsKey(value - 1)) {
                map1.get(value - 1).next = node;
                map1.remove(value);
            }
            if (value == waitValue) {
                Node node2 = map1.get(waitValue);
                while (node2 != null) {
                    System.out.print(node2.value + "->");
                    waitValue = node2.next == null ? node2.value + 1 : waitValue;
                    node2 = node2.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        HashMap<Integer, String> map = new HashMap<>();
        MessageStruct ms = new MessageStruct();
        int[] value = new int[]{2, 1, 4, 5, 7, 3, 9, 8, 6};
        for (int i = 0; i < value.length; i++) {
            System.out.println("this is value " + value[i] + ".....");
            ms.consumeMessage(value[i]);
            Thread.sleep(1000);
        }

    }
}
