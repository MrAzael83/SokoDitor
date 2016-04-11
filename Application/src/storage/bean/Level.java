package storage.bean;

import org.w3c.dom.Document;

public class Level {
    private long id;
    private String name;
    private String user;
    private Document file;
    private int rank;
    private boolean is_genuine;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Document getFile() {
        return file;
    }

    public void setFile(Document file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean is_genuine() {
        return is_genuine;
    }

    public void setIs_genuine(boolean is_genuine) {
        this.is_genuine = is_genuine;
    }
}