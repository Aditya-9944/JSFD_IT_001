import java.util.Scanner;
class Student{
    String name;
    int age;
    int rollno;
    Student(String name,int age,int rollno){
        this.name=name;
        this.age=age;
        this.rollno=rollno;
    }
}
public class seven {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Student s1=new Student("Rahul",20,1);
        Student s2=new Student("Rohan",21,2);
        System.out.println(s1.name+" "+s1.age+" "+s1.rollno);
        System.out.println(s2.name+" "+s2.age+" "+s2.rollno);
    }
}
