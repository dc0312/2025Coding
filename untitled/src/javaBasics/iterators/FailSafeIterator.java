package javaBasics.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String val = iterator.next();
            System.out.println(val);
            if(val.equals("B")){
                list.remove(val);
                list.add("D");
            }
        }
        System.out.println(list);

    }
}
