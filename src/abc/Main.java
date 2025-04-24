package abc;

public class Main {
    public static void main(String[] args){
        Inner i = new Inner(); // 可以访问嵌套类(内部类)
        i.hi();
        Hello h = new Hello(); // 可以访问同一个包下的类
        h.hi();
    }

    // private方法:
    private static void hello(){
        System.out.println("private hello!");
    }

    // Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限
    // 静态内部类:
    static class Inner{
        public void hi(){
            Main.hello();
        }
    }
}

// 一个.java文件只能包含一个public类，但可以包含多个非public类。如果有public类，文件名必须和public类的名字相同。

// public class Other{

// }