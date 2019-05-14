package model;

public class EmployeeCUD {
    private int id;
    private String name;
    private float salary;
    private int age;
    private String profile_iamge;

    public EmployeeCUD(String name, float salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfile_iamge() {
        return profile_iamge;
    }

    public void setProfile_iamge(String profile_iamge) {
        this.profile_iamge = profile_iamge;
    }
}
