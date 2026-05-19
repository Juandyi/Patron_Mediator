import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        // 1. Crear el mediador (la sala de chat)
        ChatMediator chatRoom = new ChatRoom();

        // 2. Crear varios usuarios y añadirlos a la sala
        User user1 = new ConcreteUser(chatRoom, "Ana");
        User user2 = new ConcreteUser(chatRoom, "Carlos");
        User user3 = new ConcreteUser(chatRoom, "Elena");
        
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        
        System.out.println("\n¡Sala de chat lista! Los usuarios pueden empezar a enviar mensajes.\n");
        
        // Simulación interactiva
        Scanner scanner = new Scanner(System.in);
        String input;
        
        do {
            System.out.println("Elige un usuario para enviar un mensaje:");
            System.out.println("1: Ana");
            System.out.println("2: Carlos");
            System.out.println("3: Elena");
            System.out.println("Escribe 'salir' para terminar.");
            System.out.print("Opción: ");
            
            input = scanner.nextLine();
            
            User sender = null;
            switch(input) {
                case "1":
                    sender = user1;
                    break;
                case "2":
                    sender = user2;
                    break;
                case "3":
                    sender = user3;
                    break;
                case "salir":
                    System.out.println("Cerrando el chat. ¡Hasta luego!");
                    continue;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    continue;
            }

            System.out.print("Escribe el mensaje de " + sender.getName() + ": ");
            String message = scanner.nextLine();
            
            // El usuario envía el mensaje. El mediador se encarga del resto.
            sender.send(message);

        } while (!input.equalsIgnoreCase("salir"));
        
        scanner.close();
    }
}