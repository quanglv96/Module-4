package guang.xia.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String code;
    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name="book_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public User(long user_id, String code, Book book) {
        this.user_id = user_id;
        this.code = code;
        this.book = book;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setId(long user_id) {
        this.user_id = user_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public User() {
    }


}
