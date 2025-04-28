package abc;

import java.util.Arrays;
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
        "  \tHello\r\n ".trim(); // "Hello"
        // strip()方法也可以移除字符串首尾空白字符
        "\u3000Hello\u3000".strip(); // "Hello"
        " Hello ".stripLeading(); // "Hello "
        " Hello ".stripTrailing(); // " Hello"
        // isEmpty()和isBlank()来判断字符串是否为空和空白字符串
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符
        // 分割字符串
        String s2 = "A,B,C,D";
        String[] ss = s2.split("\\,"); // {"A", "B", "C", "D"}
        System.out.println(Arrays.toString(ss));
        // 拼接字符串
        String[] arr = {"A", "B", "C"};
        String s3 = String.join("***", arr); // "A***B***C"
        System.out.println(s3);
        // 格式化字符串
        String s4 = "Hi %s, your score is %d!";
        System.out.println(s4.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        // 类型转换
        System.out.println(String.valueOf(123)); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
        // 把字符串转换为boolean类型
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
        // String和char[]类型可以互相转换
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s5 = new String(cs); // char[] -> String
        // 如果传入的对象有可能改变，我们需要复制而不是直接引用
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