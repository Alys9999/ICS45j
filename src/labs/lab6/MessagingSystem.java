package labs.lab6;

import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private Mailbox messages=null;
	

	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		
	}


	/**
	 * Delivers a message to the recipient
	 * 
	 * @param sender		message sender
	 * @param recipient		message recipient
	 * @param text			text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		if (messages==null) {
			messages= new Mailbox(sender);
		}
		
		messages.addMessage(new Message(sender, recipient, text));
		
	}

	
	/**
	 * Retrieves the messages for a user
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		if (messages==null) {
			messages= new Mailbox(user);
		}
		
		return messages.getUserMessages(user);
	}
}
