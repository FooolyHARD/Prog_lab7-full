package Commands;

import Data.User;
import Server.Module;
import Utility.CollectionManager;

import java.io.IOException;

/**
 * команда очиски коллекции
 */
public class Clear extends AbstractCommand {

    private User user;
    /**
     * поле менеджер коллекции
     */
    private CollectionManager collectionManager;

    /**
     * конструктор
     *
     * @param name        имя команды
     * @param description описание команды
     */
    public Clear(String name, String description, User user) {
        super(name, description);
        this.user=user;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    /**
     * Метод удаляет все элементы коллекции.
     *
     * @return Возвращает True при выполнении.
     * @throws IOException
     * @see CollectionManager#removeAllElements(User)
     */
    @Override
    public boolean exec() {
        Module.addMessage(collectionManager.removeAllElements(user));
        return true;
    }
}
