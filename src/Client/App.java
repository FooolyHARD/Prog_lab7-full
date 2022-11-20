package Client;

import Data.User;
import Utility.AuthorizationHelper;
import Utility.CommandManager;
import Utility.Console;
import Utility.Inquiry;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int port = Inquiry.askPort();
        AuthorizationHelper auth = new AuthorizationHelper(new Scanner(System.in));
        User user = auth.run();
        try {
            Client client = new Client(port, user);
            CommandManager commandManager = new CommandManager(client, user);
            Console.run(commandManager);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
