package guang.xia.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_product;
    private String name;
    private double price;
    private String img;

    public Product(String name, double price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Product() {
    }

    public Product(long id_product, String name, double price, String img) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.img = img;
    }
    public Product(long id_product,String name, double price,MultipartFile image){
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.image=image;
    }

    public String getImg() {
        return img;
    }

    public long getId_product() {
        return id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @Transient
    private MultipartFile image;
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
