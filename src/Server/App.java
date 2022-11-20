package Server;


import exceptions.PropertiesReadingException;

public class App {
    public static void main(String[] args) {
        try {
            Server server = new Server(2288);
            while(true) {
                server.run();
            }
        } catch (PropertiesReadingException e) {
            System.out.println(e.getMessage());
        }
    }
}
