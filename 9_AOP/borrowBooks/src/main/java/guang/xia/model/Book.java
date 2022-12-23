package guang.xia.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long book_id;
    @Column(unique = true)
    private String nameBook;
//    @Pattern(regexp = "^[0-9]+",message = "Số lượng sách phải lớn hơn 0")
    @Min(value = 0,message = "Số lượng sách phải lớn hơn 0")
    private int quantity;

    public Book() {

    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book(String nameBook, int quantity) {
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Book(long book_id, String nameBook, int quantity) {
        this.book_id = book_id;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }
}
