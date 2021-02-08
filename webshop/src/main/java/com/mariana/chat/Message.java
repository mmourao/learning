package com.mariana.chat;

public class Message {
    private final String content;
    private final String author;

    public Message(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
