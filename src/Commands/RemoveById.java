package Commands;

import Data.User;
import Server.Module;
import Utility.CollectionManager;
import Utility.Inquiry;

import java.io.IOException;
import java.util.InputMismatchException;

/** команда удаления элемента по id */
public class RemoveById extends AbstractCommand {
    /** поле менеджер коллекции */
    private CollectionManager collectionManager;
    private int argument;
    private User user;

    /**
     * конструктор
     * @param name имя команды
     * @param description описание команды
     */
    public RemoveById(String name, String description, User user) {
        super(name, description);
        this.user = user;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setArgument(int argument) {
        this.argument = argument;
    }

    /**
     * Метод пытается считать из аргумента число id, если данные введены неверно, запрашивает повторный ввод.
     * После вызывает у менеджера коллекций удаление элемента, чей idt равен переданному команде в аргументе.
     * @return Возвращает True при выполнении
     * @throws IOException
     * @see Inquiry#askID()
     * @see CollectionManager#removeElementByID(Integer, User)
     */
    @Override
    public boolean exec() {
        Module.addMessage(collectionManager.removeElementByID(argument, user));
        return true;
    }
}
