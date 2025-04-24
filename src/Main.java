// https://liaoxuefeng.com/books/java/quick-start/basic/array/index.html
import java.util.*;
import ming.Personm;

public class Main {
    public static void main(String[] args) {
        //BasicTests tests = new BasicTests();
        //tests.part1(); // 2.3.1 ~ 2.3.3
        //tests.part2(); // 2.3.4 ~ 2.3.6
        //tests.part3(); // 2.3.7 ~ 2.4.1
        //tests.part4(); //2.4.2 ~ 2.4.7

        Person p = new Person("xiao ming",12);
        System.out.println(p.getName());
        System.out.println(p.getAge());
        Person p2 = new Person(); 

        //String类提供了多个重载方法indexOf()，可以查找子串：
        // int indexOf(int ch)：根据字符的Unicode码查找；
        // int indexOf(String str)：根据字符串查找；
        // int indexOf(int ch, int fromIndex)：根据字符查找，但指定起始位置；
        // int indexOf(String str, int fromIndex)根据字符串查找，但指定起始位置。
        String s = "Test string";
        int n1 = s.indexOf('t');
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        Student stu = new Student("tom",15);
        stu.setScore(88);
        System.out.println(stu.getScore());
        System.out.println(stu.hello());

        Student stu2 = new Student("Xiao Ming", 12, 89);
        System.out.println(stu2.getScore());
        System.out.println(stu2.hello());

        // 向上转型
        // 把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）
        Person p3 = new Teacher("Lao Wang",38,"Math");
        System.out.println(p3.name);
        if(p3 instanceof Teacher tea){
            System.out.println(tea.hello());
        }

        Student s2 = new Student();
        Person p4 = s2; // upcasting, ok
        Object o1 = p4; // upcasting, ok
        Object o2 = s2; // upcasting, ok
        // 继承树是Student > Person > Object, 所以，可以把Student类型转型为Person，或者更高层次的Object

        // 向下转型
        // 如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）
        Person p5 = new Student(); // upcasting, ok
        Person p6 = new Person();
        Student stu3 = (Student) p5; // ok
        // Student stu4 = (Student) p6; // runtime error! ClassCastException!
        // Person类型p5实际指向Student实例，Person类型变量p6实际指向Person实例。在向下转型的时候，把p5转型为Student会成功，因为p5确实指向Student实例，把p6转型为Student会失败，因为p6的实际类型是Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。  

        // 为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型
        Person pp = new Person();
        System.out.println(pp instanceof Person); // true
        System.out.println(pp instanceof Student); // false

        Student ss = new Student();
        System.out.println(ss instanceof Person); // true
        System.out.println(ss instanceof Student); // true

        Student n = null;
        System.out.println(n instanceof Student); // false
        // 利用instanceof，在向下转型前可以先判断
        if (pp instanceof Student) {
            // 只有判断成功才会向下转型:
            Student stu4 = (Student) pp; // 一定会成功
        }

        // 从Java 14开始,判断instanceof后,可以直接转型为指定变量,避免再次强制转型
        Object obj = "hello";
        if (obj instanceof String str) {
            // String str = (String) obj; // 这一步不必写了
            // 可以直接使用变量s:
            System.out.println(str.toUpperCase());
        }

        // 多态
        Income[] incomes = new Income[]{
            new Income(3000),
            new Salary(7500),
            new StateCouncilSpecialAllowance(15000)
        };

        System.out.println(totalTax(incomes)); // 800
        
        // 覆写Object方法
        PersonV2 pv2 = new PersonV2();
        PersonV2 pv3 = new PersonV2();
        pv2.name = "Jimmy";
        pv3.name = "Jimmy";
        System.out.println(pv2.toString());
        System.out.println(pv2.equals(pv3));
        System.out.println(pv2.hashCode());

        // 抽象类
        // PersonV4 pv4 = new PersonV4(); // 编译错误, 错误: PersonV4是抽象的; 无法实例化
        // 面向抽象编程
        // 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程
        // 这种引用抽象类的好处在于，我们对其进行方法调用，并不关心Person类型变量的具体子类型
        PersonV4 stu1 = new StudentV4();
        PersonV4 tea1 = new TeacherV4();
        PersonV4 emp1 = new EmployeeV4();
        stu1.run(); //Student.run
        tea1.run(); //Teacher.run
        emp1.run(); //Employee.run

        // 接口
        PersonV5 mia = new StudentV5("Mia");
        System.out.println(mia.getName());
        mia.run();
        mia.eat();

        // 继承关系
        // 合理设计interface和abstract class的继承关系，可以充分复用代码。一般来说，公共逻辑适合放在abstract class中，具体逻辑放到各个子类，而接口层次代表抽象程度。
        // 可以参考Java的集合类定义的一组接口、抽象类以及具体子类的继承关系：
        List list = new ArrayList(); // 用List接口引用具体子类的实例
        Collection coll = list; // 向上转型为Collection接口
        Iterable it = coll; // 向上转型为Iterable接口

        // 3.1.8 静态字段和静态方法
        PersonV7 hong = new PersonV7("Xiao Hong", 15);
        // hong.number = 99; 
        // System.out.println(hong.number); //不推荐用实例变量.静态字段去访问静态字段
        PersonV7.number = 99; //推荐用类名来访问静态字段
        PersonV7.setNumber(88); // 调用静态方法
        System.out.println(PersonV7.number);
        // 包
        Personm mp = new Personm();
        mp.run();
        // 编译src目录下的所有Java文件
        // $ javac -d ./bin src/**/*.java

    }

    public static double totalTax(Income... incomes){
        double total = 0;
        for(Income income : incomes){
            total += income.getTax();
        }
        return total;
    }
}


