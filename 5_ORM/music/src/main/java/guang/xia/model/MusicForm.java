package guang.xia.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private int id;
    private String name;
    private String single;
    private String category;
    private MultipartFile avatar;
    private MultipartFile url;

    public int getId() {
        return id;
    }

    public MusicForm() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
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

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }

    public MusicForm(int id,  String name, String single, String category,MultipartFile avatar, MultipartFile url) {
        this.id = id;
        this.name = name;
        this.single = single;
        this.category = category;
        this.avatar = avatar;
        this.url = url;
    }
}
