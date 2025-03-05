package entity;

public abstract class Person {
    public int id;
    public String name;
    public String birthday;
    public String Gender;
    public String phoneNumber;

    public Person(int id, String name, String birthday, String gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        Gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Person() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
