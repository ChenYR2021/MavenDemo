package basic;

import basic.bean.Student;

public class BasicMainClass {
    public static void main(String[] args) {
        ExcuteBean();
    }

    // 执行用例，测试bean的基本功能
    public static void ExcuteBean() {
        Student s = new Student();
        s.setId(001);
        s.setName("Li Lei");
        s.setAge(6);
        System.out.println(s);
    }
}