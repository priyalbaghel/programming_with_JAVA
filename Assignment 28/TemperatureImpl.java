
import java.rmi.*;
import java.rmi.server.*;

public class TemperatureImpl extends UnicastRemoteObject
        implements Temperature {

    public TemperatureImpl() throws RemoteException {
        super();
    }

    public double toFahrenheit(double celsius)
            throws RemoteException {
        return (celsius * 9 / 5) + 32;
    }
}
