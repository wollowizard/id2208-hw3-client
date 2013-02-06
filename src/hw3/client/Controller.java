/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author alfredo
 */
public class Controller {

    static Client c;
    static WebResource r;

    static {
        c = Client.create();
        r = c.resource("http://localhost:8080/id2208-hw3-server/webresources/entities.myuser");
    }
}
