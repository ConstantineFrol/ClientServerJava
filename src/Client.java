import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        // Create client socket
        Socket clientSocket = new Socket("127.0.0.1", 8000);


        // === Send data to Server === //


        // Send message to server
        OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
        out.write("Hello, I am client\n");
        out.flush();


        // === Read data from server === //


        // Read data from server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();

        // Display result
        System.out.println(message);


        // === Close All Connections === //


        // Close OutputStreamWriter
        out.close();

        // Close BufferedReader
        in.close();

        // Close client socket
        clientSocket.close();
    }
}
