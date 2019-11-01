import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        // === Establish server === //

        // Create Server Socket
        ServerSocket serverSocket = new ServerSocket(8000);

        // Create Client Socket
        Socket clientSocket = serverSocket.accept();

        // === Create feedback === //

        // Version 1
        clientSocket.getOutputStream().write("<H2>Hello</H2>".getBytes());

        // Version 2
        OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
        out.write("<H2>From</H2>");
        out.write("<H2>Server</H2>");
        out.flush();

        // === Close All Connections === //

        // Close OutputStreamWriter
        out.close();

        // Close Client socket
        clientSocket.close();

        // Close Server
        serverSocket.close();

    }
}
