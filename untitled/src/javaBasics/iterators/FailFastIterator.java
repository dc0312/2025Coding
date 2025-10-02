package javaBasics.iterators;

import java.util.Iterator;
import java.util.List;

public class FailFastIterator {
    public static void main(String[] args) {
        List<String> list = new java.util.ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Iterator<String> iterator = list.iterator();;

        while(iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
            if (value.equals("B")) {
                list.remove(value);
                //list.add("D");// This will cause ConcurrentModificationException
            }
        }
    }
}
