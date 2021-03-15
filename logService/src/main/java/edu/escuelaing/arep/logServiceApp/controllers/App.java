package edu.escuelaing.arep.logServiceApp.controllers;

import com.google.gson.Gson;
import edu.escuelaing.arep.logServiceApp.services.MessageService;
import static spark.Spark.*;

/**
 * Web spark app
 */
public class App 
{

    /**
     * Initialize the spark application to publish a GET method to 
     * obtain all messages and a POST method to publish a message.
     * @param args 
     */
    public static void main( String[] args )
    {
        MessageService messageService= new MessageService();
        port(getPort());

        get("/messages",(request, response) -> {
            response.status(200);
            response.type("application/json");
            return new Gson().toJson(messageService.getAllMessages());
        });

        post("/messages",(request, response) -> {
            messageService.addMessage(request.body());
            return "";
        });

    }

    /**
     * Return the port.
     * @return the port to be used
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6001;
    }
}
