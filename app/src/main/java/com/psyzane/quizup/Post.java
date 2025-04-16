package com.psyzane.quizup;

public class Post {
    private int id;
    private String content;

    public Post(int id, String content){
        this.id = id;
        this.content = content;
//        this.content = "sdmfkmd";
    }

    public int getId(){
        return id;
    }

    public String getContent() {
        return content;
    }
}
