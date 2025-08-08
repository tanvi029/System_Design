package HashMapImplementation;

import java.security.KeyStore;

public class MyHashmap <K,V>{
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;


    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next; // for chaining

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    Entry<K, V>[] hashTable;
    private int size = 0;
    private final float loadFactor;


    MyHashmap(float loadFactor){
        this.hashTable=(Entry<K, V>[])new Entry[16];
        this.loadFactor=loadFactor;
    }



    MyHashmap(int capacity, float loadFactor) {
        int tableSize = tableSizeFor(capacity);
        this.hashTable = (Entry<K, V>[])new Entry[tableSize];
        this.loadFactor= loadFactor;
    }


    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : (n >= 1073741824 ? 1073741824 : n + 1);
    }

    public void put(K key, V value) {
        if (size >= hashTable.length * loadFactor) {
            resize();
        }
     int hashCode = Math.abs(key.hashCode())%hashTable.length;
     Entry<K, V> node = hashTable[hashCode];
     Entry<K, V> previousNode = null;
    if (node == null) {
      hashTable[hashCode] = new Entry(key, value);
      size++;
      return;
    }
    while(node!=null)
    {
        if(node.key.equals(key)) {
            node.value=value;
            return;
        }
        previousNode = node;
        node=node.next;
    }
    previousNode.next = new Entry(key, value);
    size++;

    }

    private void resize() {
        System.out.println("resizing..");
        Entry<K, V>[] oldTable = hashTable;
        hashTable = (Entry<K, V>[]) new Entry[oldTable.length*2];
        size=0;

        for(Entry<K, V> head: oldTable) {
            while (head!=null) {
                putWithoutResize(head.key, head.value);
                head = head.next;
            }
        }
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode())%hashTable.length;
        Entry<K, V> node = hashTable[index];
        while (node!=null)
        {
            if(node.key.equals(key))
            {
                return  node.value;
            }
            node = node.next;
        }
        return null;

    }

    public V remove(K key) {
        int index = Math.abs(key.hashCode())%hashTable.length;
        Entry<K, V> node = hashTable[index];
        if(node == null)
        {
            return null;
        }
        Entry<K, V> previousNode = null;
        while (node!=null) {
            if (node.key.equals(key)) {
                if(previousNode == null)
                {
                   hashTable[index] = node.next;
                } else {
                    previousNode.next = node.next;
                }
                size--;
                return node.value;
            }
            previousNode = node;
            node=node.next;
        }
        return null;
    }

    private void putWithoutResize(K key, V value) {
        int index = Math.abs(key.hashCode()) % hashTable.length;
        Entry<K, V> node = hashTable[index];
        if (node == null) {
            hashTable[index] = new Entry<>(key, value);
            size++;
            return;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Entry<>(key, value);
        size++;
    }

    public static void main (String[] args) {
        MyHashmap<Integer, String> map = new MyHashmap<>(7, 0.75f);
        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "ghi");
        map.put(4, "jkl");
        map.put(5, "mno");
        map.put(6, "pqr");
        map.put(7, "stu");     // triggers resize (8 → 16)
        map.put(8, "vwx");
        map.put(9, "yz");
        map.put(10, "123");
        map.put(11, "456");
        map.put(12, "789");
        String value = map.get(8);
        System.out.println(value);
        String removedValue = map.remove(7);
        if(removedValue==null)
        {
            System.out.println("Value doesn't exist");
        } else System.out.println("Value of the key deleted is "+removedValue);
        String removedValue1 = map.remove(7);
        if(removedValue1==null)
        {
            System.out.println("Value doesn't exist");
        } else System.out.println("Value of the key deleted is "+removedValue1);

    }
}
