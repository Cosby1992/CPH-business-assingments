package hashmap_java;

import java.util.ArrayList;

public class MyHashMap<K, V> implements SimpleMap<K, V> {

    private ArrayList<KeyValue<K, V>>[] array;

    public MyHashMap(int size){
        array = (ArrayList<KeyValue<K, V>>[]) new ArrayList[size];
    }

    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub
        int hash = key.hashCode();
        int index = mod(hash, array.length);

        ArrayList<KeyValue<K, V>> list = array[index];
        
        if(list == null){
            list = new ArrayList<>();
            array[index] = list;
        }

        for(KeyValue<K, V> kv : list){
            if(kv.key.equals(key)){
                kv.value = value;
                return;
            }
        }

        list.add(new KeyValue<>(key, value));
        
    }

    @Override
    public V get(K key) {
        
        int hash = key.hashCode();
        int index = mod(hash, array.length);
        
        ArrayList<KeyValue<K, V>> list = array[index];

        if(list == null){
            return null;
        }

        for(KeyValue<K, V> kv : list){
            if(kv.key.equals(key)){
                return kv.value;
            }
        }

        return null;
    }

    public static int mod(int a, int b){
        int c = a % b;
        return c < 0 ? c + b : c;
    }

    private static class KeyValue<K, V> {
        public final K key;
        public V value;

        public KeyValue(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

}