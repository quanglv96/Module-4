package guang.xia.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_orderDetail;
    private String codeOrder;
    private String nameUser;
    private String phone;
    private String address;
    @ManyToOne(targetEntity=Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name="id_product")
    private Product product;
    private int quantity;

    public OderDetail(String codeOrder, String nameUser, String phone, String address) {
        this.codeOrder = codeOrder;
        this.nameUser = nameUser;
        this.phone = phone;
        this.address = address;
    }

    public OderDetail(String nameUser, String phone, String address) {
        this.nameUser = nameUser;
        this.phone = phone;
        this.address = address;
    }

    public OderDetail(String codeOrder, String nameUser, String phone, String address, Product product, int quantity) {
        this.codeOrder = codeOrder;
        this.nameUser = nameUser;
        this.phone = phone;
        this.address = address;
        this.product = product;
        this.quantity = quantity;
    }

    public OderDetail() {
    }

    public long getId_orderDetail() {
        return id_orderDetail;
    }

    public void setId_orderDetail(long id_orderDetail) {
        this.id_orderDetail = id_orderDetail;
    }

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
