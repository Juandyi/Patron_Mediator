// 4. Concrete Colleague (Colaborador Concreto)
public class ConcreteUser extends User {

    public ConcreteUser(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String message) {
        // Al enviar, el usuario no se comunica directamente con otros,
        // sino que le pasa el mensaje al mediador.
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        // El usuario es notificado por el mediador.
        System.out.println(this.name + " ha recibido el mensaje: '" + message + "'");
    }
}