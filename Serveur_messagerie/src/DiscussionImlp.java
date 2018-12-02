import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class DiscussionImlp extends UnicastRemoteObject implements IDiscussion {

    User user1, user2;
    private LinkedList<Message> messages;

    DiscussionImlp() throws RemoteException {
        messages = new LinkedList<>();
    }

    @Override
    public void addMsg(Message message) {
        if (isUser(message.getSender()))
            messages.add(message);
    }

    @Override
    public LinkedList<Message> getMessages() {
        return messages;
    }

    @Override
    public boolean isUser(User user) {
        return user == user1 || user == user2;
    }
}
