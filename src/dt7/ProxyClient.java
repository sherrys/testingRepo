package dt7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProxyClient {
    public static void main(String[] args) throws IOException {
        final String targetName = "www-proxy.cse.unsw.edu.au";
        final int targetPort = 1105;

        ClientConnection clientConnection = new ClientConnection (targetName, targetPort);

        BufferedReader stdIn = new BufferedReader (
                new InputStreamReader (System.in));

        // enter HTTP request lines into the console
        // type <EOF> to terminate your request
        String requestLine = stdIn.readLine ();
        while (requestLine != null) {
            System.out.println("sending ->> " + requestLine);
            clientConnection.send (requestLine);
            requestLine = stdIn.readLine ();
        }

        // read the response and echo it to the console
        String responseLine = clientConnection.receive ();
        while (responseLine != null) {
            System.out.println ("response <<- "+responseLine);
            responseLine = clientConnection.receive ();
        }

        clientConnection.close();
        stdIn.close();

        System.out.println ("Done!");
    }

}
