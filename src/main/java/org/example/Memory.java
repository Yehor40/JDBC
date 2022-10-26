package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class Memory {
    public static void main(String[] args) {
        memory();
    }

    public static void memory() {
        long m = System.currentTimeMillis();
        Runtime runtime=Runtime.getRuntime();
        System.out.println(" Total memory before: "+runtime.totalMemory());
        System.out.println(" Free memory before: "+runtime.freeMemory());
        List<Date>dateList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            Date date = new Date();
            dateList.add(date);

        }
        System.out.println(" Total memory after: "+runtime.totalMemory());
        System.out.println(" Free memory after: "+runtime.freeMemory());
        System.gc();
        System.out.println(" Total memory after gc: "+runtime.totalMemory());
        System.out.println(" Free memory after gc: "+runtime.freeMemory());
        final long used = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(used);
        System.out.println(System.currentTimeMillis() - m+"ms");

    }
}
