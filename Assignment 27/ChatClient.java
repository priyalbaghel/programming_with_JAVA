
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Client: ");
                String message = sc.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("bye")) {
                    break;
                }

                String reply = in.readLine();

                if (reply == null) {
                    break;
                }

                System.out.println("Server: " + reply);

                if (reply.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            sc.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
