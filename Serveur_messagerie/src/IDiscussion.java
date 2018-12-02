import java.rmi.Remote;
import java.util.LinkedList;

public interface IDiscussion extends Remote {

    void addMsg(Message message);

    LinkedList<Message> getMessages();

    boolean isUser(User user);
}
