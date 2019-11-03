import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        // === initialize variables === //

        // Counter
        int count = 0;


        // === Establish server === //


        // Create Server Socket
        ServerSocket serverSocket = new ServerSocket(8000);

        // 5 connections
        while (count < 5) {

            // Create Client Socket
            Socket clientSocket = serverSocket.accept();

            // Counting how many clients reached the server
            System.out.println("Client no.:\t" + ++count);

            // Read data as a string from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = in.readLine();
            System.out.println(request);


            // === Create feedback === //


            // Write message to client
            String response = "#" + count + ", your message length is\t" + request.length() + "\n";
            OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
            out.write(response);
            out.flush();


            // === Close All Connections === //

            // Close BufferedReader
            in.close();

            // Close OutputStreamWriter
            out.close();

            // Close ServerSocket
            clientSocket.close();
        }

        // Close server socket
        if (!serverSocket.isClosed()) {
            serverSocket.close();
        }


    }
}
