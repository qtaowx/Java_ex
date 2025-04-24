import java.util.Scanner;
import java.util.Arrays;

public class BasicTests {
    public static void part1() {
        System.out.println("Hello World!");
        int i = 2147483647;
        int i2 = -2147483648;
        int i3 = 2_000_000_000; // 加下划线更容易识别
        int i4 = 0xff0000; // 十六进制表示的16711680
        int i5 = 0b1000000000; // 二进制表示的512

        long n1 = 9000000000000000000L; // long型的结尾需要加L
        long n2 = 900; // 没有加L，此处900为int，但int类型可以赋值给long
        // int i6 = 900L; // 错误：不能把long型赋值给int

        final double PI = 3.14; // PI是一个常量
        // PI = 300; // compile error!

        StringBuilder sb = new StringBuilder(); //有些时候，类型的名字太长，写起来比较麻烦
        var sb2 = new StringBuilder(); //这个时候，如果想省略变量类型，可以使用var关键字：编译器会根据赋值语句自动推断出变量sb的类型是StringBuilder

        // int x = 2147483640;
        // int y = 15;
        // int sum = x + y;
        // System.out.println(sum); // -2147483641 整数由于存在范围限制，如果计算结果超出了范围，就会产生溢出

        // 要解决上面的问题，可以把int换成long类型，由于long可表示的整型范围更大，所以结果就不会溢出
        long x = 2147483640;
        long y = 15;
        long sum = x + y;
        System.out.println(sum); // 2147483655

        // 移位运算 左移实际上就是不断地×2，右移实际上就是不断地÷2
        int n = 7;       // 00000000 00000000 00000000 00000111 = 7
        int a = n << 1;  // 00000000 00000000 00000000 00001110 = 14
        int b = n << 2;  // 00000000 00000000 00000000 00011100 = 28
        int c = n << 28; // 01110000 00000000 00000000 00000000 = 1879048192
        int d = n << 29; // 11100000 00000000 00000000 00000000 = -536870912

        int n3 = 7;       // 00000000 00000000 00000000 00000111 = 7
        int a2 = n3 >> 1;  // 00000000 00000000 00000000 00000011 = 3
        int b2 = n3 >> 2;  // 00000000 00000000 00000000 00000001 = 1
        int c2 = n3 >> 3;  // 00000000 00000000 00000000 00000000 = 0

        // 因为浮点数常常无法精确表示，因此，浮点数运算会产生误差
        double x1 = 1.0 / 10;
        double y1 = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x1); // 0.1
        System.out.println(y1); // 0.09999999999999999

        // 比较x和y是否相等，先计算其差的绝对值:
        double r = Math.abs(x1 - y1);
        // 再判断绝对值是否足够小:
        if (r < 0.00001) {
            // 可以认为相等
            System.out.println("equal.");
        } else {
            // 不相等
        }
    }

    public static void part2() {
        // 类型提升
        // 如果参与运算的两个数其中一个是整型，那么整型可以自动提升到浮点型
        int n = 5;
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);

        // 强制转型
        int n1 = (int) 12.3; // 12
        int n2 = (int) 12.7; // 12
        int n3 = (int) -12.7; // -12
        int n4 = (int) (12.7 + 0.5); // 13
        int n5 = (int) 1.2e20; // 2147483647

        // 字符类型char 
        char c1 = 'A'; // 单引号
        char c2 = '中';
        // 要显示一个字符的Unicode编码，只需将char类型直接赋值给int类型即可
        int n11 = 'A'; // 字母“A”的Unicodde编码是65
        int n22 = '中'; // 汉字“中”的Unicode编码是20013
        char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
        char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013

        // 字符串类型
        String s = ""; // 空字符串，包含0个字符
        String s1 = "A"; // 包含一个字符
        String s2 = "ABC"; // 包含3个字符
        String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格
        // 转义字符\
        String s4 = "abc\"xyz"; // 包含7个字符: a, b, c, ", x, y, z
        // 常见的转义字符包括：
        // \" 表示字符"
        // \' 表示字符'
        // \\ 表示字符\
        // \n 表示换行符
        // \r 表示回车符
        // \t 表示Tab
        
        // 字符串连接
        String s11 = "Hello";
        String s22 = "world";
        String s33 = s11 + " " + s22 + "!";
        System.out.println(s33);

        // 多行字符串
        String s5 = "first line \n"
         + "second line \n"
         + "end";
        // 从Java 13开始，字符串可以用"""..."""表示多行字符串（Text Blocks）了
        String s6 = """
                   SELECT * FROM
                     users
                   WHERE id > 100
                   ORDER BY name DESC"""
                   ;
        System.out.println(s6);

        // 不可变特性
        // 变的不是字符串，而是变量s的“指向”
        String s7 = "hello"; // s7指向"hello"
        String t = s7; // t指向s7("hello")
        s7 = "world"; // s7指向"world"
        System.out.println(t); // t是"hello"还是"world"? "hello"

        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
        int a = 72;
        int b = 105;
        int c = 65281;

        String ss = "" + (char)a + (char)b + (char)c;
        System.out.println(ss); 
    }

    public static void part3() {
        // 数组类型
        // 5位同学的成绩:
        int[] ns = new int[5]; //数组变量初始化必须使用new int[5]表示创建一个可容纳5个int元素的数组。
        ns[0] = 68;
        ns[1] = 79;
        ns[2] = 91;
        ns[3] = 85;
        ns[4] = 62;
        // Java的数组有几个特点：
        // 数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
        // 数组一旦创建后，大小就不可改变。
        System.out.println(ns.length); 
        int[] ns1 = new int[] { 68, 79, 91, 85, 62 }; //可以在定义数组时直接指定初始化的元素，这样就不必写出数组大小
        int[] ns2 = { 68, 79, 91, 85, 62 }; //还可以进一步简写

        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?

        // 格式化输出
        double d = 12900000;
        System.out.println(d); // 1.29E7
        // 格式化输出使用System.out.printf()，通过使用占位符%?，printf()可以把后面的参数格式化成指定格式
        double d2 = 3.1415926;
        System.out.printf("%.2f\n", d2); // 显示两位小数3.14
        System.out.printf("%.4f\n", d2); // 显示4位小数3.1416

        // 占位符	说明
        // %d	格式化输出整数
        // %x	格式化输出十六进制整数
        // %f	格式化输出浮点数
        // %e	格式化输出科学计数法表示的浮点数
        // %s	格式化字符串

        // 下面的例子把一个整数格式化成十六进制，并用0补足8位
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x\n", n, n);

        // 输入
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出

        // 判断引用类型相等
        // 要判断引用类型的变量内容是否相等，必须使用equals()方法(不能用==)
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2); // false
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }


    }

    public static void part4() {
        // Switch & yield
        String fruit = "orange";
        int opt = switch(fruit){
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> {
                int code = fruit.hashCode();
                yield code;// switch语句返回值
            }
        };
        System.out.println("opt="+opt);

        // for each
        int[] ns = { 1, 4, 9, 16, 25 };
        for(int n:ns){
            System.out.println(n);
        }

        // 请利用for循环计算π
       double pi = 0;
        for (int i = 1; i <= 1000000; i++) {
            double temp = 2 * i - 1;
            double item = (i % 2 == 1) ? 4.0 / temp : -4.0 / temp;
            pi += item;
        }
        System.out.println(pi);

        // break
        // 在循环过程中，可以使用break语句跳出当前循环
        int sum = 0;
        for (int i=1; ; i++) {
            sum = sum + i;
            if (i == 100) {
                break;
            }
        }
        System.out.println(sum);

        // continue
        // continue则是提前结束本次循环，直接继续执行下次循环
        int sum2 = 0;
        for (int i=1; i<=10; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue; // continue语句会结束本次循环
            }
            sum2 = sum2 + i;
            System.out.println("end i = " + i);
        }
        System.out.println(sum2); //25

        // 打印数组内容
        int[] ns1 = { 1, 1, 2, 3, 5, 8 };
        for (int n : ns1) {
            System.out.print(n + ", ");
        }
        System.out.println(Arrays.toString(ns1)); //Arrays.toString()可以快速打印数组内容 [1, 1, 2, 3, 5, 8]

        int[] ns2 = { 1, 4, 9, 16, 25 };
        // 倒序打印数组元素:
        for(int i = ns2.length - 1; i >= 0; i--){
            System.out.println(ns2[i]);
        }

        //要打印一个二维数组，可以使用两层嵌套的for循环
        int[][] ns3 = {
            { 1, 2, 3, 4 },
            { 5, 6 },
            { 7, 8, 9 }
        };

        for (int[] arr : ns3) {
            for (int n : arr) {
                System.out.print(n);
                System.out.print(",");
            }
            System.out.println();
        }

        // 或者使用Java标准库的Arrays.deepToString()
        System.out.println(Arrays.deepToString(ns3));

    }   

} //
