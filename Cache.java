import java.util.HashMap;

public class Cache<K, V> {

    public static class DoubleLinkedList<V> {
        public DoubleLinkedList<V> pre;
        public DoubleLinkedList<V> next;
        public V value;

        public DoubleLinkedList(V value) {
            this.value = value;
        }
    }

    public static class CacheStruct<K, V> {
        private HashMap<K, DoubleLinkedList<V>> map = new HashMap<>();
        private HashMap<DoubleLinkedList<V>, K> backmap = new HashMap<>();
        private int k;
        private int number = 0;
        private DoubleLinkedList head;

        public CacheStruct(int k) {
            if (k < 0) throw new RuntimeException("Not valid k");
            this.k = k;
        }

        public void set(K key, V value) {
            if (map.containsKey(key)) {
                DoubleLinkedList<V> node = map.get(key);
                node.value = value;
                moveNode(node);
                printOutCome();
            } else {
                DoubleLinkedList<V> node = new DoubleLinkedList<V>(value);
                map.put(key, node);
                backmap.put(node, key);
                if (head == null) {
                    head = node;
                    number++;
                } else {
                    DoubleLinkedList cur = head;
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = node;
                    node.pre = cur;
                    number++;
                    if (number > k) {
                        K mykey = backmap.get(head);
                        backmap.remove(head);
                        map.remove(mykey);
                        head = head.next;
                        head.pre = null;
                        number = k;
                    }
                }
                printOutCome();
            }
        }

        public DoubleLinkedList<V> moveNode(DoubleLinkedList<V> node) {
            if (node.next == null) return head;
            else if (node == head) {
                DoubleLinkedList<V> newhead = head.next;
                newhead.pre = null;
                DoubleLinkedList<V> cur = newhead;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = node;
                node.pre = cur;
                return newhead;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                DoubleLinkedList<V> cur = node;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = node;
                node.pre = cur;
                return head;
            }

        }

        public V get(K key) {
            if (map.containsKey(key)) {
                moveNode(map.get(key));
                printOutCome();
                return map.get(key).value;
            } else return null;
        }

        public void printOutCome() {
            DoubleLinkedList<V> cur = head;
            DoubleLinkedList<V> pre = null;
            while (cur != null) {
                pre = cur;
                System.out.print(cur.value + "->");
                cur = cur.next;
            }
            System.out.println();
            while (pre!= null) {
                System.out.print(pre.value + "->");
                pre = pre.pre;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        CacheStruct<String, Integer> cache = new CacheStruct<>(3);
        cache.set("A", 1);
        cache.set("B", 2);
        cache.set("C", 3);
        cache.set("D", 4);
        cache.set("E", 5);
        cache.set("F", 6);
    }

}
