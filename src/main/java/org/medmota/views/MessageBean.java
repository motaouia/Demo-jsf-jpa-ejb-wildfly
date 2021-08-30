package org.medmota.views;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.medmota.models.Message;
import org.medmota.services.MessageService;

@Named
@RequestScoped
public class MessageBean {

	Logger logger = Logger.getLogger(MessageBean.class.getName());

	@Inject
	private MessageService messageService;

	private Message message;
	private String text;
	private List<Message> allMessages;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getAllMessages() {
		return allMessages;
	}

	public void setAllMessages(List<Message> allMessages) {
		this.allMessages = allMessages;
	}

	@PostConstruct
	public void init() {
		logger.log(Level.INFO, "Inside Init Method");
		allMessages = messageService.listAllMsg();
		/*
		 * logger.log(Level.INFO, " allMessages size is : " + allMessages.size());
		 * allMessages.forEach(mesg -> { logger.log(Level.INFO, "The message text is : "
		 * + mesg.getText()); });
		 */

	}

	public void submit() {
		logger.log(Level.INFO, "Inside Submit Method");
		message = new Message(text);
		messageService.createMessage(message);
		allMessages.add(message);
		logger.log(Level.INFO, "List all Messages");
		/*
		 * allMessages.forEach(mesg -> { logger.log(Level.INFO, "The message text is : "
		 * + mesg.getText()); });
		 */
		text = null;
		message = new Message();

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
