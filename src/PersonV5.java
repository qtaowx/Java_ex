//接口
//如果一个抽象类没有字段，所有方法全部都是抽象方法, 就可以把该抽象类改写为接口：interface
//接口的所有方法都是抽象方法，接口不能定义实例字段；
interface PersonV5 {
    void run(); //因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来
    String getName();
    // 在接口中，可以定义default方法
    // default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
    default void eat(){
        System.out.println(getName() + " eat");
    }
}

// 当一个具体的class去实现一个interface时，需要使用implements关键字
class StudentV5 implements PersonV5{
    private String name;
    public StudentV5(String name){
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println(this.name + " run");
    }

    @Override
    public String getName(){
        return this.name;
    }
}

// 接口继承
// 一个interface可以继承自另一个interface。interface继承自interface使用extends，它相当于扩展了接口的方法
interface HelloV2{
    void hello();
}

// Person接口现在实际上有3个抽象方法签名，其中一个来自继承的Hello接口
interface PersonV6 extends HelloV2 {
    void run();
    String getName();
}



