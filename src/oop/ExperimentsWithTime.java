package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {

    public static void main(String[] args) {
        time t1 = new time(9, 10);
        System.out.println(t1.show());
        System.out.println(t1.isMorning());
        t1.add(20);
        System.out.println(t1.show());
        t1.add(120);
        System.out.println(t1.show());

        time t2 = new time(17, 3);
        System.out.println(t2.show());
        System.out.println(t2.isMorning());
        System.out.println(t2.sayHello());
        t2.add(50);
        System.out.println(t2.show());
        t2.add(1300);
        System.out.println(t2.show());
    }
}