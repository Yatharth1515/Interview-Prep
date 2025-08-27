package org.example;

public class MyHashMap<K,V>{

    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 16;
    public Entry<K, V>[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }
    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    private int tableSizeFor(int capacity) {
        int n = capacity -1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println("size of map is " + n);
        return n;
    }
    public void put(K key, V value){
        isValidKey(key);
        int hashCode = getHashCode(key);
        Entry<K, V> entry = findHashCode(key);
        if (entry == null){
            Entry<K, V> e = new Entry<>(key,value);
            System.out.println("key - hashCode :- " + e.key + " " + hashCode );
            hashTable[hashCode] = e;
        }
        else {
            Entry<K , V> existingKey = entry;
            while (entry != null){
                if(entry.key.equals(key)){
                    System.out.println("matching key is :- " + key);
                    entry.value = value;
                    return;
                }
                existingKey = entry;
                entry = entry.next;

            }
            existingKey.next = new Entry<>(key,value);
        }
    }

    V get(K key) {
        isValidKey(key);
        Entry<K, V> entry = findHashCode(key);
        while (entry != null) {
            if (entry.key.equals(key))
                return entry.value;
            entry = entry.next;
        }
        return null;
    }
     Entry<K, V> findHashCode (K key){
         int hashCode = getHashCode(key);
         return hashTable[hashCode];
    }

    private int getHashCode(K key) {
        int h;
        return  (h = key.hashCode()) ^ (h >>> 16);

    }
    private static <K> void isValidKey(K key) {
        if (key == null) throw new RuntimeException("key is null");
    }

}
