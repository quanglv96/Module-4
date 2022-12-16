package guang.xia.model;

public class Email {
    private int id;
    private String languages;
    private int pageSize;
    private boolean spamFiller;
    private String signature;

    public Email() {
    }

    public Email(int id, String languages, int pageSize, boolean spamFiller, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFiller = spamFiller;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFiller() {
        return spamFiller;
    }

    public void setSpamFiller(boolean spamFiller) {
        this.spamFiller = spamFiller;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
