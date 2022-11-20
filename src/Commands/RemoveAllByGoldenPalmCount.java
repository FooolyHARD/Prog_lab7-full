package Commands;

import Data.User;
import Server.Module;
import Utility.CollectionManager;
import Utility.Inquiry;

import java.io.IOException;
import java.util.InputMismatchException;

/** команда удаления элементов с переданным количеством золотых пальм */
public class RemoveAllByGoldenPalmCount extends AbstractCommand {

    /** поле менеджер коллекции */
    private CollectionManager collectionManager;
    private Long argument;
    private User user;
    /**
     * конструктор
     * @param name имя команды
     * @param description описание команды
     */
    public RemoveAllByGoldenPalmCount(String name, String description, User user) {
        super(name, description);
        this.user = user;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setArgument(Long argument) {
        this.argument = argument;
    }

    /**
     * Метод пытается считать из аргумента число goldenpalmcount, если данные введены неверно, запрашивает повторный ввод.
     * После вызывает у менеджера коллекций удаление всех элементов, чей goldenpalmcount равен переданному команде в аргументу.
     * @return Возвращает True при выполнении
     * @throws IOException
     * @see Inquiry#askGoldenPalmCount() 
     * @see CollectionManager#removeAllByGoldenPalmCount(long, User)
     */
    @Override
    public boolean exec() {
        Module.addMessage(collectionManager.removeAllByGoldenPalmCount(argument, user));
        return true;
    }
}
