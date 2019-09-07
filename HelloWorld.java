public class HelloWorld{
    public static void main(String[] args){
        Student student = new Student();
        student.name = "Мария";
        student.age = 19;
        student.isAlive = true;
        System.out.print("Hello, Java!");
    }
}

class Student {
    public String name;
    public int age;
    public boolean isAlive;
}