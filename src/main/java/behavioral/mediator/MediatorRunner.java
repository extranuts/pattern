package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorRunner {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Admin Adminov");
        User u1 = new SimpleUser(chat, "Serg");
        User u2 = new SimpleUser(chat, "Vova");
        User u3 = new SimpleUser(chat, "Petr");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);


        u3.sendMessage("HiALL");
        admin.sendMessage("Admin joined to chat.....");

    }
}

abstract class User {
    Chat chat;
    String name;

    public boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);
}

class Admin extends User {


    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Администратор получает сообщение ' " + message + "'");
    }
}

class SimpleUser extends User {

    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь  получает сообщение ' " + message + "'");
    }
}

interface Chat {
    void sendMessage(String message, User user);
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin instanceof Admin) {
            this.admin = admin;
        } else throw new RuntimeException("Access denied!");
    }

    public void addUser(User user) {
        if (admin == null) {
            throw new RuntimeException("Chat doesn't have admin");
        }
        if (user instanceof SimpleUser) {
            users.add(user);
        } else throw new RuntimeException("Admin lol");
    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for (User u : users) {
                if (u != user && u.isEnable()){
                    u.getMessage(user.getName() + ": " + message);
                }
            }
        }if (user instanceof  SimpleUser) {
            for (User u : users) {
                if (u != user && u.isEnable())
                    u.getMessage(user.getName() + ": " + message);
            }
            if (admin.isEnable())
                admin.getMessage(user.getName() + ": " + message);
        }
    }
}