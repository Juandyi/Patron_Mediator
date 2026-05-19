// 2. Clase abstracta Colaborador
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    // El usuario envía un mensaje a través del mediador
    public abstract void send(String message);

    // El usuario recibe un mensaje del mediador
    public abstract void receive(String message);
}