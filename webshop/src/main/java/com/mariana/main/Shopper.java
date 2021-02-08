package com.mariana.main;

import com.mariana.chat.Bot;
import com.mariana.chat.BotChat;
import org.junit.Assert;


public class Shopper {
    public static void main(String[] args)
    {
        BotChat botChat = new BotChat();
        Bot bot = new Bot(botChat);
        botChat.addObserver(bot);
        botChat.sendMessage("Hello, how are you?");
        Assert.assertEquals("Hello, how can I help you?",
                botChat.getMessagesHistory().getLast().getContent());
        botChat.sendMessage("What are the different ways of payment?");
        Assert.assertEquals("You can pay your bill will Paypal or Credit Card",
                botChat.getMessagesHistory().getLast().getContent());
    }

}
