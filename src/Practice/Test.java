package Practice;

/**
 * @program: leetcode_fh
 * @description: static
 * @author: fanghao
 * @create: 2022-08-01 09:43
 **/
class Person{
    protected String name;

    public Person(String name) {
        this.name = name;
    }
    private void getInfo(){
        System.out.println(this.name);      //Child
    }
}

class Student extends Person{
    private String name;

    public Student(String name, String name1) {
        super(name);
        this.name = name1;
    }

    public void getInfo(){

    }

}

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Father","Child");
        s1.getInfo();
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) {
                    break ok;
                }
            }
            System.out.println(i);
        }
        System.out.println(Math.ceil(0.2));     //1.0
        System.out.println(Math.floor(0.2));    //0.0
        System.out.println(Math.round(-11.5));   //-11
//        float a2 = 3.4; //错误，将双精度型（double）赋值给浮点型（float）属于下转型（down-casting，也称为窄化）会造成精度损失
        float a = 3.4f; //单精度
        float a1 = (float) 3.4; //同上
        double b = 3.6; //双精度
        System.out.println(b);
        System.out.println(a);
        System.out.println(a1);

        short s = 1;
        s += 1; // s = (short(s + 1))
//        s = s + 1;//报错，1是int , s + 1也是int,需要强制转换赋值给short,
        s = (short) (s + 1);
        System.out.println(s);
        char e = '2';
        char e2 = '2';
        System.out.println(e + e2 - '0');
    }
}
