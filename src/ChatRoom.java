import java.util.ArrayList;
import java.util.List;

// 3. Concrete Mediator (Mediador Concreto)
public class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
        System.out.println(user.getName() + " se ha unido a la sala.");
    }

    @Override
    public void sendMessage(String message, User sender) {
        System.out.println("---------------------------------");
        System.out.println(sender.getName() + " envía: '" + message + "'");
        System.out.println("Mediador reenviando mensaje...");
        
        // El mediador reenvía el mensaje a todos, excepto al remitente.
        for (User u : users) {
            if (u != sender) {
                u.receive(message);
            }
        }
        System.out.println("---------------------------------");
    }
}