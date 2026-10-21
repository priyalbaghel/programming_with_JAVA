
import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

            String message = in.readLine();

            System.out.println("Message received: " + message);

            out.println("Echo: " + message);

            socket.close();
            server.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
