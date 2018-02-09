package discordBot.controller;

import javax.security.auth.login.LoginException;

public class BotRunner 
{
    public static void main( String[] args ) throws LoginException, InterruptedException
    {
        BotController app = new BotController();
        app.start();
    }
}
