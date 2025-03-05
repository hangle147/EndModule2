package entity;

public class Student extends Person {
    public String className;

    public Student(int id, String name, String birthday, String gender, String phoneNumber, String className) {
        super(id, name, birthday, gender, phoneNumber);
        this.className = className;
    }

    public Student() {}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
