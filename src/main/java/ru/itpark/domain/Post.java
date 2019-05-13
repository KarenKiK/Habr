package ru.itpark.domain;

public class Post {
    private int id;
    private String name;
    private String[] tags;

    public Post(int id, String name, String[] tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
