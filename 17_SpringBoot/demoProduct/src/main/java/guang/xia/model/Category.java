package guang.xia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_category;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(long id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    public Category() {
    }
}
