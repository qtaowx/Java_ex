public class PersonV7 {
    public String name;
    public int age;
    // 定义静态字段number:
    // 静态字段只有一个共享“空间”，所有实例都会共享该字段
    public static int number;

    //接口的静态字段
    //interface是可以有静态字段的，并且静态字段必须为final类型
    //public static final int MALE = 1;
    //public static final int FEMALE = 2;
    // 因为interface的字段只能是public static final类型，所以我们可以把这些修饰符都去掉，上述代码可以简写为：
    // 编译器会自动加上public static final:
    int MALE = 1;
    int FEMALE = 2;

    public PersonV7(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 静态方法
    // 调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。
    // 调用静态方法不需要实例，无法访问this，但可以访问静态字段和其他静态方法；
    // 静态方法经常用于工具类。例如：
    // Arrays.sort()
    // Math.random()
    public static void setNumber(int value) {
        number = value;
    }
}
