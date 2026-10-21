
import java.rmi.*;
import java.rmi.registry.*;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            Temperature obj = new TemperatureImpl();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost/TemperatureService", obj);

            System.out.println("Temperature Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
