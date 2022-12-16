package guang.xia.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String avatar;
    private String name;
    private String single;
    private String category;
    private String url;

    public Music(String name, String single, String category, String url) {
        this.name = name;
        this.single = single;
        this.category = category;
        this.url = url;
    }

    public Music(int id, String name, String single, String category, String url) {
        this.id = id;
        this.name = name;
        this.single = single;
        this.category = category;
        this.url = url;
    }

    public Music() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Music(String avatar, String name, String single, String category, String url) {
        this.avatar = avatar;
        this.name = name;
        this.single = single;
        this.category = category;
        this.url = url;
    }

    public Music(int id, String avatar, String name, String single, String category, String url) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.single = single;
        this.category = category;
        this.url = url;
    }
}
