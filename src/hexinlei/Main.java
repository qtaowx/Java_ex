package hexinlei;

public class Main {
    public static void main(String[] args) {
        // 为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，
        // 可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s);
        // 链式操作
        // 进行链式操作的关键是，定义的append()方法会返回this，这样，就可以不断调用自身的其他方法
        var sb2 = new StringBuilder(1024);
        sb2.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0,"Hello, ");
        System.out.println(sb2);
        // 仿照StringBuilder，我们也可以设计支持链式操作的类。例如，一个可以不断增加的计数器
        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());


    }
}
