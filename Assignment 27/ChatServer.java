
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            while (true) {
                String message = in.readLine();

                if (message == null || message.equalsIgnoreCase("bye")) {
                    System.out.println("Client left the chat.");
                    break;
                }

                System.out.println("Client: " + message);

                System.out.print("Server: ");
                String reply = sc.nextLine();
                out.println(reply);

                if (reply.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            server.close();
            sc.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
