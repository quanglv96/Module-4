package guang.xia.model;


import javax.validation.constraints.*;

public class User {

    @NotEmpty(message = "not empty")
    @Size(min = 2, max = 30, message = "size 2-30")
    private String name;
    @Min(value = 18,message = "not validate")
//    @Pattern(regexp = "^[1-9]*", message = "not validate")
    private int age;

    public User() {
    }

    public User(@NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}