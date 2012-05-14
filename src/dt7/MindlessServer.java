package dt7;
/**
 * A very simple http server, listens for connection,
 * saves the request lines (& echoes them to console)
 * then returns a dummy web page (which includes the
 * request lines - uesful for http debugging).
 * Only responds to one request, then halts.
 *
 * @author richardb April 2010
 * simple class to demonstrate networking for comp2911
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MindlessServer {
    
    private static Censoring c;

    public static final int port = 2911;
    
    public static List<String> requests;
    
    public static List<String> responses;
    
    public static void main (String[] args) throws IOException {

        System.out.println ("server starting...");
        System.out.println ("listening on "+port);
        //create a new object which deals with censoring info
        c = new Censoring();
        
        dt7.ServerConnection connection = new dt7.ServerConnection(port);
        //store requests in an array list of strings
        requests = new ArrayList<String>();

        String requestLine;
        int requestCount = 0;
        while (!connection.finishedRecieving()) {
            requestLine = connection.receive ();
            requests.add (requestLine);
            System.out.println ("request line "+(requestCount++)+": "+requestLine);
        }

        System.out.println ("Server responding...");

        /*connection.send ("HTTP/1.1 200 OK");
        connection.send ("Date: Wed, 14 Apr 2010 06:33:01 GMT");
        connection.send ("Server: Apache-Coyote/1.1");
        connection.send ("Last-Modified: Wed, 14 Apr 2010 06:33:03 GMT");
        connection.send ("Content-Type: text/html;charset=UTF-8");
        connection.send ("Content-Length: 29127");
        connection.send ("X-Cache: MISS from www.cse.unsw.edu.au");
        connection.send ("Connection: close");
        connection.send ("");
        connection.send ("<html>");
        connection.send ("<head>");
        connection.send ("</head>");
        connection.send ("<body>");
        connection.send ("<PRE>");
        //connection.send ("eh??? Did you say:");*/
        //responses received from mindless client
        responses = MindlessClient.getResponses();
        if(responses!=null){
            for(String response: responses){
                String line = c.ChangeString(response);
                connection.send(line);
            }
        }
        String s = c.ChangeString("conroy censors the information about refugees");
        connection.send(s);

        /*for (String line : requests) {
            connection.send (line);
        }*/

        connection.send ("</pre>");
        connection.send ("</body>");
        connection.send ("</html>");

        System.out.println ("Server done!");
    }
    
    public List<String> getRequest(){
        return requests;
    }
}