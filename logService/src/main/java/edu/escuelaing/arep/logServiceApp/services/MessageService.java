package edu.escuelaing.arep.logServiceApp.services;

import edu.escuelaing.arep.logServiceApp.model.Message;
import edu.escuelaing.arep.logServiceApp.persistence.MessagePersistence;
import edu.escuelaing.arep.logServiceApp.persistence.impl.DBConnection;



import java.util.ArrayList;

/**
 * Class that offer the two Services
 */
public class MessageService {

    MessagePersistence messagePersistence= new DBConnection();

    /**
     * Add the message to the database
     * @param message message to be saved
     */
    public void addMessage(String message) {
        System.out.println("holaaaa");
        messagePersistence.writeMessage(new Message(message));
    }

    /**
     * Return the list of the all messages in the database.
     * @return list of the messages
     */
    public ArrayList<Message> getAllMessages() {
        return messagePersistence.loadMessages();
    }
}
