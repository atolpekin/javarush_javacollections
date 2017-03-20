package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by locuser on 15.03.2017.
 */
public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set{

    private static final Object PRESENT = new Object();
  private transient HashMap<E, Object> map;

    public AmigoSet() {

        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        map=new HashMap<>((int)Math.max(16, (int)(collection.size()/0.75f +1)));
        this.addAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean add(Object o) {
        return null == map.put((E) o, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }



    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        }
        catch (Exception e) {
            throw new InternalError();
        }
    }


    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();


    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        int size = (int)s.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)s.readObject());
        }
        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }
}
