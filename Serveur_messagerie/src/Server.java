import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        System.out.println("*****server*****");
        try {
            LocateRegistry.createRegistry(1099);

            IMsgService msgService = new MsgServiceImpl();

            Naming.rebind("rmi://127.0.0.1/msg_service",msgService);
            System.out.println("server is running ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
