package discordBot.controller;

/**
 * These are the importations for the JDA and also one for authorizathion.
 */
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * This is a class called BotController. It inherits from ListenerAdapter.
 * @author Jeremy
 *
 */
public class BotController extends ListenerAdapter 
{
	JDA tryBot; // A JDA called tryBot.
	String token = FileReader.readConfig();
	
	public BotController() throws LoginException, InterruptedException 
	{
		try 
		{
		JDABuilder build = new JDABuilder(AccountType.BOT);
		build.setToken(token);
		
		tryBot = build.buildBlocking();
		tryBot.addEventListener(new BotController());
		}
		
		catch (LoginException event)
		{
			event.printStackTrace();
		}
		
		catch (InterruptedException event)
		{
			event.printStackTrace();
		}
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		
		Message msg = event.getMessage();
		MessageChannel mailPather = event.getChannel();
		User member = event.getAuthor();
		
		String Smsg = msg.getContentRaw();
		
		if (Smsg.equals("Hello"))
		{
			mailPather.sendMessage("Hello there, I am Merciz. How may I help you, " + member.getAsMention() + "." ).queue();
		}
	}
	
	void start()
	{
		
	}
}
