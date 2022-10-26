package org.example;
import java.util.function.Function;
import java.util.function.BiFunction;

public class Func {
    protected static class MyMath{
        public static Integer triple(int x){
            //pure function(function is pure when that always returns the same result if the same arguments are passed)
            return x*3;
        }
    }
    public static void main(String[] args) {
        //treating class's function as an object
        Function<Integer,Integer> myTriple = MyMath::triple;
        int result = myTriple.apply(5);
        System.out.println(result);
        //lambda expression
        Function<Integer,Integer>myFunc=(someArg)->someArg*2+1;
        //single line exp
        String str = "HDGDGFDF";
        Function<String,Integer>getStringLength=(myString)->myString.length();
        System.out.println(getStringLength);
        //multiline exp
        Function<Integer,Integer>myFun=(Integer x)->{
            Integer res = x*2;
            return res;
        };
        System.out.println(myFun.apply(6));
        System.out.println(getStringLength.apply(str));

        Function<Integer,Integer>abs=(x)->x<0?-x:x;
        System.out.println(abs.apply(-1));
        //bifunction(functions with different number of arguements)
        BiFunction<Integer,Integer,Integer>add=(x,y)->x+y;
        System.out.println(add.apply(3,4));

        Trifunc<Integer,Integer,Integer,Integer>plus = (x,y,z)->x+y+z;
        System.out.println(plus.apply(1,2,3));

        NoArgFunc<String>hello=()->"Hello";
        System.out.println(hello.apply());
    }

}
