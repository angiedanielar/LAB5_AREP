package edu.escuelaing.arep.logServiceApp.model;

/**
 * Class that represent a Message
 */
public class Message {

    private String message;

    public Message(String message) {
        this.message=message;
    }

    /**
     * Give us the message
     * @return the message to be returned.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message
     * @param message the message to be setted.
     */
    public void setMessage(String message) {
        this.message = message;
    }


}
