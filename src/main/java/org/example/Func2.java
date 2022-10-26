package org.example;

public class Func2 {
    protected static class Person{
        private String name;
        private Integer age;
        public Person(String name,Integer age){
            this.name = name;
            this.age= age;

        }
    }
    protected static class DataLoader{
        public final NoArgFunc<Person>load;
        public DataLoader(Boolean development){
            this.load=development
                    ?this::loadPersonfake
                    :this::loadPersonReal;
        }
        private Person loadPersonReal(){
            System.out.println("loading person...");
            return new Person("real Joe",56);
        }
        private Person loadPersonfake(){
            System.out.println("Fake person...");
            return new Person("fake Joe",57);
        }
    }
    public static void main(String[] args) {
    final Boolean Is_Development= false;
    DataLoader dl = new DataLoader(Is_Development);
        System.out.println(dl.load.apply());
    }
}
