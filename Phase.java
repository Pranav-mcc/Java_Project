package onlineHotel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    

    @Override
    public String toString() {
        return name + " - Rs. " + price;
    }
}

class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public String toString() {
        return name;
    }
}

class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

public class Phase{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Restaurant restaurant1 = new Restaurant("Yaa Moidheen");
        restaurant1.addMenuItem(new MenuItem("Chicken Biriyani", 150));
        restaurant1.addMenuItem(new MenuItem("Mutton Biriyani", 180));

        Restaurant restaurant2 = new Restaurant("A2B");
        restaurant2.addMenuItem(new MenuItem("Idly", 20));
        restaurant2.addMenuItem(new MenuItem("Dosa", 80));
        
        Order order = new Order();

        while (true) {
            System.out.println("Available Restaurants:");
            System.out.println("1. " + restaurant1);
            System.out.println("2. " + restaurant2);
            System.out.println("3. Bill and Exit");
            System.out.println("4. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                displayMenu(restaurant1);
                int itemChoice = scanner.nextInt();
                order.addItem(restaurant1.getMenu().get(itemChoice - 1));
            } else if (choice == 2) {
                displayMenu(restaurant2);
                int itemChoice = scanner.nextInt();
                order.addItem(restaurant2.getMenu().get(itemChoice - 1));
            } else if (choice == 3) {
                System.out.println("Order Summary:");
                for (MenuItem item : order.getItems()) {
                    System.out.println(item);
                }
                System.out.println("Total: Rs. " + order.calculateTotal());
                break;
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
           
        }
        scanner.close();
    }

    private static void displayMenu(Restaurant restaurant) {
        System.out.println("Menu for " + restaurant + ":");
        List<MenuItem> menu = restaurant.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}
