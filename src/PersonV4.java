// 3.1.6 抽象类
//如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法
//因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）
abstract class PersonV4 {
    public abstract void run();
}

class StudentV4 extends PersonV4{
    @Override
    public void run(){
        System.out.println("Student.run");
    }
}

class TeacherV4 extends PersonV4{
    @Override
    public void run(){
        System.out.println("Teacher.run");
    }
}

class EmployeeV4 extends PersonV4{
    @Override
    public void run(){
        System.out.println("Employee.run");
    }
}