package com.mariana.chat;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BotChat implements Observable {
    List<Observer> observers = new ArrayList<>();
    LinkedList<Message> messagesHistory = new LinkedList<>();


    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public void sendMessage(String msg) {
        sendMessage(msg, "randomId");
    }
    public void sendMessage(String msg, String senderId) {
        Message newMessage = new Message(msg, senderId);
        messagesHistory.add(newMessage);
        notifyObservers();
    }

    public LinkedList<Message> getMessagesHistory() {
        return this.messagesHistory;
    }
}
