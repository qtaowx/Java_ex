// 覆写Object方法
public class PersonV2 {
    protected String name;

    // 显示更有意义的字符串:
    @Override
    public String toString(){
        return "Person:name=" + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o){
        // 当且仅当o为Person类型:
        if(o instanceof PersonV2){
            PersonV2 p = (PersonV2)o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    // 用final修饰的方法不能被Override
    public final String hello() {
        return "Hello, " + name;
    }
}

// 用final修饰的类不能被继承
final class PersonV3 {
    protected String name;
    // 用final修饰的字段在初始化后不能被修改
    public final String address;
    public PersonV3(String address) { //保证实例一旦创建，其final字段就不可修改
        this.address = address;
    }
}