package com.mariana.chat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Bot implements Observer{
    private final BotChat botChat;
    private static final Map<String, String> qAndA;
    private static final String BOT_ID = "bot";
    static {
        qAndA = new HashMap<>();
        qAndA.put("shipping", "You can check the shipping information from" +
                " the shipping confirmation e-mail");

        qAndA.put("payment", "You can pay your bill will Paypal or Credit Card");

        qAndA.put("return", "You can find our return Policy in our website");
    }

    public Bot(BotChat botChat)
    {
        this.botChat = botChat;
    }

    @Override
    public void update() {
        onMessageReceived();
    }

    private void onMessageReceived() {
        if (isMessageFromCustomer()) {
            answerCustomer();
        }
    }

    private void answerCustomer() {
        LinkedList<Message> messages = this.botChat.getMessagesHistory();
        if (messages.size() == 1) {
            sayHello();
            return;
        }

        qAndA.forEach((k,v) -> {
            if (messages.getLast().getContent().contains(k)) {
                this.botChat.sendMessage(v, BOT_ID);
            }
        });
    }

    private boolean isMessageFromCustomer() {
        return !botChat.getMessagesHistory().getLast().getAuthor().equals(BOT_ID);
    }

    private void sayHello() {
        this.botChat.sendMessage("Hello, how can I help you?", BOT_ID);
    }
}
