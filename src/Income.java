// 3.1.5多态
// 多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
public class Income {
    protected double income;

    public Income(double income){
        this.income = income;
    }

    public double getTax(){
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(double income){
        super(income);
    }
    // 在继承关系中，子类如果定义了一个与父类方法签名(方法名，参数，返回值)完全相同的方法，被称为覆写（Override）
    @Override
    public double getTax(){
        if(income <= 5000){
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}