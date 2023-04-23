package com.jomkie.spring.namespacehandler;

/**
 * 用于存储标签的值
 */
public class JoLabel {

    private String id;
    private String username;
    private Integer age;

    public JoLabel() {}

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
