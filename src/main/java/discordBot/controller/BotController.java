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
	FileReader file = new FileReader();
	JDA tryBot; // A JDA called tryBot.
	String token = file.readConfig();
	
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
		JDA jda = event.getJDA();
		long responseNumber = event.getResponseNumber();
		
		Message msg = event.getMessage();
		MessageChannel mailPather = event.getChannel();
		User member = event.getAuthor();
		
		String Smsg = msg.getContentDisplay();
		
		if (Smsg.equals("Hello"))
		{
			mailPather.sendMessage("Hello there, I am Merciz. How may I help you, " + member.getAsMention() + "." ).queue();
		}
		
		if (event.isFromType(ChannelType.TEXT))
		{
			Guild server = event.getGuild();
			TextChannel textPath = event.getTextChannel();
			Member user = event.getMember();
			
			String name;
			
			if (msg.isWebhookMessage())
			{
				name = member.getName();
			}
			
			else
			{
				name = user.getEffectiveName();
			}
			
			 System.out.printf("(%s)[%s]<%s>: %s\n", server.getName(), textPath.getName(), name, Smsg);
		}
	}
	
	void start()
	{
		
	}
}
