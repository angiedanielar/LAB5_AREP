package edu.escuelaing.arep.logServiceApp.persistence.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.escuelaing.arep.logServiceApp.model.Message;
import edu.escuelaing.arep.logServiceApp.persistence.MessagePersistence;
import org.bson.Document;
import java.util.ArrayList;


/**
 * Class that takes care of the persistence of the message
 *  using a MongoDB database
 */
public class DBConnection implements MessagePersistence {
    public MongoClientURI uri;
    public MongoClient mongoClient;

    public DBConnection() {
        uri = new MongoClientURI(
                "mongodb://daniela:password@127.0.0.1:27017/Arep?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=Arep&authMechanism=SCRAM-SHA-1&3t.uriVersion=3");
        mongoClient = new MongoClient(uri);
    }

    /**
     * Save a message
     * @param mensaje message to be saved
     */
    @Override
    public void writeMessage(Message mensaje) {
        System.out.println("holabd");
        MongoDatabase database = mongoClient.getDatabase("Arep");
        MongoCollection<Document> collection =database.getCollection("Mensajes");
        System.out.println("holabd1");
        Document document=new Document();
        document.put("mensaje",mensaje.getMessage());
        collection.insertOne(document);
    }


    /**
     * Load all messages
     * @return the list of messages
     */
    @Override
    public ArrayList<Message> loadMessages() {
        ArrayList<Message> mensajes=new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Arep");
        MongoCollection<Document> collection =database.getCollection("Mensajes");
        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<Document>();
        fit.into(docs);

        for (Document document:docs) {
            String mensaje= (String) document.get("mensaje");
            mensajes.add(new Message(mensaje));
        }

        return mensajes;
    }
}
