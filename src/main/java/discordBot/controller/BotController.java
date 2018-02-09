package discordBot.controller;



/**
 * These are the importations for the JDA and also one for authorizathion.
 */
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * This is a class called BotController. It inherits from ListenerAdapter.
 * @author Jeremy
 *
 */
public class BotController extends ListenerAdapter 
{
	JDA tryBot; // A JDA called tryBot.
	
	public BotController() throws LoginException, InterruptedException 
	{
		tryBot = new JDABuilder(AccountType.BOT).setToken("NDA0MDM0NjYzNzkxODUzNTY4.DV-OPg.1jMa0nLA_QOusa1m392jdE0uuvs").buildBlocking();
		// Adding tryBot has a JDABuilder.
		
		tryBot.addEventListener(new BotController()); // Adds an EventListener.
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		Message mail = event.getMessage();
		MessageChannel mailPather = event.getChannel();
		User member = event.getAuthor();
		
		if (mail.getContentRaw().equalsIgnoreCase("Hello"))
		{
			mailPather.sendMessage("Hello there, I am Merciz. How may I help you, " + member.getAsMention() + "." ).queue();
		}
	}
	
	void start()
	{
		
	}
}
