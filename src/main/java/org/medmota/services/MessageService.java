package org.medmota.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.medmota.models.Message;

@Stateless
public class MessageService {

	@PersistenceContext
	private EntityManager entityManager;

	public void createMessage(Message msg) {
		entityManager.persist(msg);
	}

	public List<Message> listAllMsg() {
		Query q = entityManager.createQuery("Select m from Message m");
		return q.getResultList();
	}
	
	public List<Message> init() {
		createMessage(new Message("Hello"));
		createMessage(new Message("How Are You ?"));
		createMessage(new Message("Thanks alot!!"));
		createMessage(new Message("Good Morning"));
		createMessage(new Message("I am software developer"));
		return listAllMsg();
	}

}
