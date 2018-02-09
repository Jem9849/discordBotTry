package discordBot.controller;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotController extends ListenerAdapter
{
	JDA tryBot;
	
	public BotController()
	{
		tryBot = new JDABuilder(AccountType.BOT).setToken("NDA0MDM0NjYzNzkxODUzNTY4.DV-OPg.1jMa0nLA_QOusa1m392jdE0uuvs").buildBlocking();
	}
	
	void start()
	{
		
	}
}
