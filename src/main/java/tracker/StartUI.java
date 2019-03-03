package tracker;

public class StartUI {
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter menu item: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByID();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    private void createItem() {
        System.out.println("---------- Adding a new Item ----------");
        String name = this.input.ask("Enter Item's Name: ");
        String desc = this.input.ask("Enter Item's Description: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("---------- A new Item with ID: " + item.getId());
    }
    private void showItems() {
        System.out.println("---------- Show All Items ----------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + " Item's Name: " + item.getName() + " Item's description : " + item.getDesc());
        }
    }
    private void deleteItem() {
        System.out.println("---------- Deleting Item ----------");
        String id = this.input.ask("Enter Item's ID");
        boolean a = this.tracker.delete(id);
        if (a) {
            System.out.println("Your Item has been successfully deleted");
        } else {
            System.out.println("Your Item is not deleted");
        }
    }
    private void editItem() {
        System.out.println("---------- Editing Item ----------");
        String id = this.input.ask("Enter Item's ID: ");
        String name = this.input.ask("Enter Item's Name: ");
        String desc = this.input.ask("Enter Item's Description: ");
        Item item = new Item(name, desc);
        boolean a = tracker.replace(id, item);
        if (a) {
            System.out.println("Your Item has been successfully edited");
        } else {
            System.out.println("Your Item is not edited");
        }
    }
    private void findByID() {
        System.out.println("---------- Finding Item by ID ----------");
        String id = this.input.ask("Enter Item's ID");
        Item item = this.tracker.findById(id);
        System.out.println("Item's ID: " + item.getId() + " Item's Name: " + item.getName() + " Item's description : " + item.getDesc());
    }
    private void findByName() {
        System.out.println("---------- Finding Item by Name ----------");
        String name = this.input.ask("Enter Item's Name");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println("Item's ID: " + item.getId() + " Item's Name: " + item.getName() + " Item's description : " + item.getDesc());
        }
    }

    private void showMenu() {
        System.out.print("Menu.\n0.Add Item\n1.Show all Items\n2.Edit Item\n3.Delete Item\n4.Find Item by ID\n5.Find Item by Name\n6.Exit\n");
    }
}
