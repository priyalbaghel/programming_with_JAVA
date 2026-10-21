
import java.rmi.*;

public interface Temperature extends Remote {
    double toFahrenheit(double celsius) throws RemoteException;
}
