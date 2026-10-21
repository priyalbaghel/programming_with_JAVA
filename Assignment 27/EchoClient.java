
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            out.println(message);

            String reply = in.readLine();
            System.out.println("Reply from server: " + reply);

            socket.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
