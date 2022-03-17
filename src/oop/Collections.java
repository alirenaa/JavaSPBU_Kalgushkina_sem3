package oop;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Collections {

    public static void main(String[] args) throws Exception {
        System.out.println( count(3));
        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);
        List<String> list2 = List.of("ab", "xyz", "oooo");
        printListWithIndices(list2);

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);
        System.out.println(list3);
        System.out.println(list4);

        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        List<String> list5rev = reverseList(list5);
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);

        List<Integer> ints = new ArrayList<>(List.of(11, 22, 33, 55, 66, 88, 100, 3, 4));
        System.out.println(filterEvenIndices(ints));
        System.out.println(filterEven(ints));

        System.out.println(" ============= mutable lists =================== ");

        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts);

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts);
    }

    private static List<Integer> count(int n) {
        List<Integer> arr = new ArrayList<>();
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
        List<String> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }

    public static List<String> reverseList(List<String> arr) {
        List<String> res = new ArrayList<>();
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

    private static List<Integer> filterEvenIndices(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++)
            if (i % 2 != 0)
                res.add(arr.get(i));
        return res;
    }

    private static List<Integer> filterEven(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        for (int i: arr)
            if (i % 2 != 0)
                res.add(i);
        return res;
    }

    private static void mutableFilterEvenIndices(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++)
            arr.remove(i);
    }

    private static void mutableFilterEven(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++)
            if (arr.get(i) % 2 == 0){
                arr.remove(i);
                i--;
            }
    }

//    private static void doReadWordsInFile(String fileForReading, Set<String> res) throws Exception {
//        Path txt = Path.of(fileForReading);
//        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
//            while (in.hasNext()) {
//                res.add(in.next().toLowerCase());
//            }
//        }
//    }

}
