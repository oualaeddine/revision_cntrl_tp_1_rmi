import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


public class MsgServiceImpl extends UnicastRemoteObject implements IMsgService {
    private LinkedList<DiscussionImlp> discussions;

    MsgServiceImpl() throws RemoteException {
        discussions = new LinkedList<>();
    }

    @Override
    public IDiscussion getDiscussion(User user1, User user2) throws RemoteException {
        int discussion = findDiscussion(user1, user2);
        if (discussion != Integer.MAX_VALUE)
            return discussions.get(discussion);
        else {
            DiscussionImlp obj = createDiscussion();
            discussions.add(obj);
            return discussions.get(discussions.indexOf(obj));
        }
    }

    @Override
    public int findDiscussion(User user1, User user2) {
        for (DiscussionImlp discussion : discussions) {
            if ((discussion.user1 == user1 && discussion.user2 == user2) || (discussion.user1 == user2 && discussion.user2 == user1))
                return discussions.indexOf(discussion);
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public DiscussionImlp createDiscussion() throws RemoteException {
        return new DiscussionImlp();
    }
}
