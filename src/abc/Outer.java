package abc;

import java.util.Arrays;

public class Outer {
    private String name;

    Outer(String name){
        this.name = name;
    }

    class Inner{
        void hello(){
            System.out.println("Hello, " + Outer.this.name);
        }
    }

    void asyncHello(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }
    // 定义匿名类的写法如下:
    // Runnable r = new Runnable() {
        // 实现必要的抽象方法...
    //};
    // 观察Java编译器编译后的.class文件可以发现，Outer类被编译为Outer.class，而匿名类被编译为Outer$1.class。
}

// 请修复Score的构造方法，使得外部代码对数组的修改不影响Score实例的int[]字段
class Score {
    private int[] scores;

    public Score(int[] scores) {
//        this.scores = scores;
        // 从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用
        this.scores = Arrays.copyOf(scores, scores.length);
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}