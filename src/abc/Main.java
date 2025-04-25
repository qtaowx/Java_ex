package abc;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        // 3.1.10 作用域
        Inner i = new Inner(); // 可以访问嵌套类(内部类)
        i.hi();
        Hello h = new Hello(); // 可以访问同一个包下的类
        h.hi();

        // 3.1.11 Inner Class
        // class Outer {
        //    class Inner {
                // 定义了一个Inner Class
        //    }
        //}
        Outer outer = new Outer("Nested"); // 实例化一个Outer
        Outer.Inner inner = outer.new Inner();  // 实例化一个Inner
        inner.hello();

        // Anonymous Class
        outer.asyncHello();
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>() {}; // 匿名类!
        HashMap<String, String> map3 = new HashMap<>() {
            {
                put("A", "1");
                put("B", "2");
            }
        };
        //map1是一个普通的HashMap实例，但map2是一个匿名类实例，只是该匿名类继承自HashMap。map3也是一个继承自HashMap的匿名类实例，并且添加了static代码块来初始化数据。观察编译输出可发现Main$1.class和Main$2.class两个匿名类文件。

        // 3.2.1 字符串和编码
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
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