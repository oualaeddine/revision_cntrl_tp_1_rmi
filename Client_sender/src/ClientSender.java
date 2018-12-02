import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientSender {
    public static void main(String[] args) {
        System.out.println("****client sender*****");
        try {
            IMsgService service = (IMsgService) Naming.lookup("rmi://127.0.0.1/stock");
            User user1 = new User(1, "ouala eddine");
            User user2 = new User(2, "fadiabour");

            IDiscussion discussion = service.getDiscussion(user1, user2);

            Message message = new Message(user1, "t9acher roooose");
            discussion.addMsg(message);

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
