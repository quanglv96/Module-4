package guang.xia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp ="^[a-zA-Z]{1,45}$",message = "Độ dài từ 1-45 kí tự")
    private String fistName;
    @Pattern(regexp ="^[a-zA-Z]{2,45}$",message = "Độ dài từ 2-45 kí tự")
    private String lastName;
    @Pattern(regexp ="^(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "số điện thoại sai")
    private String phone;
    @Pattern(regexp ="^(?:[1-9][0-9]?|1[01][0-9]|120)$",message = "Tuổi sai")
    private String age;
    @Email
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String fistName, String lastName, String phone, String age, String email) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public User(long id, String fistName, String lastName, String phone, String age, String email) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }
}
