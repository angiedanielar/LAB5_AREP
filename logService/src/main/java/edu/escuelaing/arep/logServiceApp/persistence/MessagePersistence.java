package edu.escuelaing.arep.logServiceApp.persistence;

import edu.escuelaing.arep.logServiceApp.model.Message;

import java.util.ArrayList;


public interface MessagePersistence {

    void writeMessage(Message mensaje);

    ArrayList<Message> loadMessages();
}
