package dt7;
/**
 * A very simple tcp client, opens socket to www.cse.unsw.edu.au
 * port 80 and then reads user input from command line till eof
 * echoing this to the console and also sending it thru the socket.
 * reads server response from socket and echos that to the console
 * too.  then halts.  ie Only issues one request, then halts.
 *
 * @author richardb April 2010
 * simple class to demonstrate networking for comp2911
 *
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//changes are not tested, so unsure if works, same with MindlessServer
public class MindlessClient {
    
    private static MindlessServer server;
    
    private static List<String> responses;

    public static void main(String[] args) throws IOException {
        final String targetName = "www.cse.unsw.edu.au";
        final int    targetPort = 80;

        ClientConnection clientConnection = new ClientConnection (targetName, targetPort);

        BufferedReader stdIn = new BufferedReader (
                new InputStreamReader (System.in));

        // enter HTTP request lines into the console
        // type <EOF> to terminate your request
        //String requestLine = stdIn.readLine ();
        
        //create a mindless server and store the requests received from server
        server = new MindlessServer();
        List<String> requests = server.getRequest();
        for(String requestLine : requests){
            System.out.println("sending ->> " + requestLine);
            clientConnection.send (requestLine);
        }
        /*while (requestLine != null) {
            System.out.println("sending ->> " + requestLine);
            clientConnection.send (requestLine);
            requestLine = stdIn.readLine ();
        }*/

        // read the response and echo it to the console
        //String responseLine = clientConnection.receive ();
        
        responses = new ArrayList<String>();
        while(!clientConnection.finishedRecieving ()){
            System.out.println ("response <<- "+clientConnection.receive());
            responses.add(clientConnection.receive());
        }
        /*while (responseLine != null) {
            System.out.println ("response <<- "+responseLine);
            responseLine = clientConnection.receive ();
        }*/
        
        

        clientConnection.close();
        stdIn.close();

        System.out.println ("Done!");
    }

    public static List<String> getResponses() {
        return responses;
    }

}