package oop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Collections {

    private static List<Integer> count(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        return arr;
    }

    public static void printList(List<String> arr) {
        System.out.println("Элементов в списке:" + arr.size());
        Stream.of(arr).forEach((System.out::println));
    }

    public static void printListWithIndices(List<String> arr) {
        System.out.println("Элементов в списке:" + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + ": " + arr.get(i));
        }
    }

    public static List<String> concatenateLists(List<String> list1, List<String> list2) {
        ArrayList<String> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }

    public static List<String> reverseList(List<String> arr) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = arr.size() - 1; i >= 0; i--)
            res.add(arr.get(i));
        return res;
    }

    public static void reverseListInPlace(List<String> arr) {
        for (int i = 0; i < arr.size() / 2; i++){
            String tmp = arr.get(i);
            arr.set(i, arr.get(arr.size() - 1 - i));
            arr.set(arr.size() - 1 - i, tmp);
        }
    }



}
