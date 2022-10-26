package org.example;

import java.util.function.BiFunction;

public class Func3 {
    protected static class Mymath{
        public static Integer add(int x,int y){
            return x+y;
        }
        public static Integer substract(int x,int y){
            return x-y;
        }
        public static Integer combine2and3(BiFunction<Integer,Integer,Integer> combineFun){
           return combineFun.apply(2,3);
        }
    }
    public static void main(String[] args) {
        System.out.println(Mymath.combine2and3(Mymath::add));
        System.out.println(Mymath.combine2and3(Mymath::substract));
        System.out.println(Mymath.combine2and3((x,y)->2*(x+y)));

    }
}
