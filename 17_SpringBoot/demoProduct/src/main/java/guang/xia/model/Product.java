package guang.xia.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_product;
    private String name;
    private double price;
    private String image;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="id_category")
    private Category category;

    public Product() {
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(long id_product, String name, double price, String image, Category category) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Product(String name, double price, String image, long id_category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.id_category = id_category;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, String image, Category category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    @Transient
    private MultipartFile img;
    public MultipartFile getImg() {
        return img;
    }

    public void setImage(MultipartFile img) {
        this.img = img;
    }
    @Transient
    private long id_category;

    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }
}
