package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * Load balancer app
 */
public class App 
{

    public static void main( String[] args )
    {
        port(getPort());
        staticFileLocation("/static");
        ClientHttp client=new ClientHttp();
        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/messages",(req, res) -> {
            res.status(200);
            res.type("application/json");
            String response=client.getMessages("/messages");
            client.roundRobin();
            return response;
        });

        post("/messages",(request, response) -> {
            client.postMessage(request.body(),"/messages");
            client.roundRobin();
            return "";
        });


    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6001;
    }
}
