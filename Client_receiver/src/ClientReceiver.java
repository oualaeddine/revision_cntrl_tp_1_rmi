import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;

public class ClientReceiver {
    public static void main(String[] args) {
        System.out.println("****client receiver****");

        try {
            IMsgService service =
                    (IMsgService) Naming.lookup("rmi://127.0.0.1/stock");

            User user1 = new User(1, "ouala eddine");
            User user2 = new User(2, "fadiabour");

            IDiscussion discussion = service.getDiscussion(user1, user2);
            LinkedList<Message> messages = discussion.getMessages();

            for (Message msg : messages) {
                System.out.println(msg);
            }

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }

    }
}
