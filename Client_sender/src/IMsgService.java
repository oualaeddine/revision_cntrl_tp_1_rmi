import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMsgService extends Remote {

    IDiscussion getDiscussion(User user1, User user2) throws RemoteException;

    int findDiscussion(User user1, User user2);

    IDiscussion createDiscussion() throws RemoteException;
}
