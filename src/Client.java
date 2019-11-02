import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // Create client socket
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        // === Read data from server === //

        // Version 1 read one byte(1 symbol)
        System.out.println(clientSocket.getInputStream().read());

        // Version 2 read byte by byte and store each byte in array
        byte[] bytes = new byte[14];
        clientSocket.getInputStream().read(bytes);

        // Display result using string class
        System.out.println(new String(bytes));

        // Version 3 read data as a string
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();

        // Display result
        System.out.println(message);

        // Close client socket
        clientSocket.close();
    }
}
