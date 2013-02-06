/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import hw3.client.gui.serverclasses.Route;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alfredo
 */
public class Controller {

    private Client c;
    private String token = null;
    private static Controller instance = null;
    private Route route = null;

    private Controller() {
        c = Client.create();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void authenticate(String user, String pwd) throws Exception {
        try {
            WebResource r;
            String resString = "http://localhost:8080/id2208-hw3-server/webresources/entities.myuser/authentication/";
            resString += user + "/" + pwd;
            r = c.resource(resString);
            token = r.accept(MediaType.TEXT_PLAIN).get(String.class);
            System.out.println(token);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void findByItinerary(String from, String to, String date) {
        String resString = "http://localhost:8080/id2208-hw3-server/webresources/entities.myflight/find_flight_by_itinerary/";
        resString += from + "/" + to + "/" + date + "/" + token;
        WebResource r = c.resource(resString);



        GenericType<Route> genericType = new GenericType<Route>() {};
        route = r.accept(MediaType.APPLICATION_XML).get(genericType);

    }

    public static void main(String args[]) throws Exception {
        Controller c = Controller.getInstance();
        c.authenticate("alfredo", "1234");
        c.findByItinerary("Barcelona", "Stockholm", "05022013");

    }
}
