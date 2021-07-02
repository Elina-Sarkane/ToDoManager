import tasks.TaskController;
import tasks.TaskMenu;

public class Main {

    public static void main(String[] args) {

        TaskMenu taskMenu = new TaskMenu();
        taskMenu.showMenu();
        TaskController taskController = new TaskController();
    }
}
