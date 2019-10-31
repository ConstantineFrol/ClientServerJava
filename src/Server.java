import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {

        // Create Server
        ServerSocket serverSocket = new ServerSocket(8000);

        // Start Listening
        serverSocket.accept();

        // Close Server
        serverSocket.close();

    }
}
