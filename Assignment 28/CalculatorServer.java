
import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Calculator obj = new CalculatorImpl();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost/CalculatorService", obj);

            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
