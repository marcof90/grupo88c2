package model;

public class User {
    private int status;
    private String name;

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}