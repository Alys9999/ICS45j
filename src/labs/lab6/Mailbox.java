package labs.lab6;

import java.util.ArrayList;

/**
 * An email mailbox.
 */
public class Mailbox {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String user;
	private ArrayList<Message> mails;

	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param user the user
	 */
	public Mailbox(String user) {
		this.user=user;
		mails=new ArrayList<Message>();
		}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		return user; // FIX ME
	}
	
	
	
	
	public String getUserMessages(String user) {
		String res = "";
		for (Message m:mails) {
			if (m.getRecipient().equals(user)) {
				res=res+" -----\n"+m;
			}
			
		}
		return res; // FIX ME
	}
	/**
	 * Adds a message to the mailbox.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		mails.add(m);
	}

	/**
	 * Retrieves text of all messages, in the following format:
	 * -----
	 * [MESSAGE1]
	 * -----
	 * [MESSAGE2]
	 * 
	 * etc.
	 */
	public String getAllMessages() {
		String res = "";
		for (Message m:mails) {
			res=res+" -----\n"+m;
		}
		return res; // FIX ME
	}
}
