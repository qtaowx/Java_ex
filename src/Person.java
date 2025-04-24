public class Person { // Person extends Object
    // 继承有个特点，就是子类无法访问父类的private字段或者private方法
    // 为了让子类可以访问父类的字段，我们需要把private改为protected。用protected修饰的字段可以被子类访问
    // private String name;
    // private int age;
    protected String name;
    protected int age;

    public Person(){
        // 默认构造方法
    }

    public Person(String name, int age){ // 自定义构造方法
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}

// Java使用extends关键字来实现继承
// Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类
class Student extends Person {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    protected int score;

    public Student(){
        super();
    }

    public Student(String name,int age){
        super(name,age);
    }

    // 如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法
    public Student(String name,int age,int score){
        super(name,age);
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String hello(){
        return "Hello," + name;
    }
}

class Teacher extends Person{
    protected String course;
    
    public Teacher(){
        super();
    }

    public Teacher(String name, int age){ // 自定义构造方法
        super(name,age);
    }

    public Teacher(String name, int age, String course){ 
        super(name,age);
        this.course = course;
    }

    public String hello(){
        return "Hello," + name + ", course:" + course;
    }

}

// 区分继承和组合
class Book{
    protected String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

// 我们能不能让Student继承自Book呢？
// 从逻辑上讲，这是不合理的，Student不应该从Book继承，而应该从Person继承。
// 究其原因，是因为Student是Person的一种，它们是is关系，而Student并不是Book。实际上Student和Book的关系是has关系。

// class Student extends Book {
//     protected int score;
// }

// 具有has关系不应该使用继承，而是使用组合，即Student可以持有一个Book实例
class Student2 extends Person {
    protected Book book;
    protected int score;
}

