import java.util.Scanner;

class Pizza {
    private String type;
    private int basePrice;
    private boolean extraCheese;
    private boolean extraToppings;

    public Pizza(String type) {
        this.type = type;
        switch (type.toLowerCase()) {
            case "veg":
                this.basePrice = 300;
                break;
            case "nonveg":
                this.basePrice = 400;
                break;
            case "deluxveg":
                this.basePrice = 550;
                break;
            case "deluxnonveg":
                this.basePrice = 650;
                break;
            default:
                System.out.println("Invalid pizza type selected.");
                this.basePrice = 0;
        }
    }

    public void addExtraCheese() {
        extraCheese = true;
    }

    public void addExtraToppings() {
        extraToppings = true;
    }

    public int calculateBill() {
        int total = basePrice;
        if (extraCheese) total += 100;
        if (extraToppings) total += 150;
        return total;
    }

    public void printBill() {
        System.out.println("\n--- PIZZA BILL ---");
        System.out.println("Pizza Type: " + type);
        System.out.println("Base Price: ₹" + basePrice);
        if (extraCheese) System.out.println("Extra Cheese: ₹100");
        if (extraToppings) System.out.println("Extra Toppings: ₹150");
        System.out.println("Total Bill: ₹" + calculateBill());
    }
}

public class PizzaBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Pizza Order App!");
        System.out.println("Available Pizzas:");
        System.out.println("1. Veg Pizza - ₹300");
        System.out.println("2. Non-Veg Pizza - ₹400");
        System.out.println("3. Deluxe Veg Pizza - ₹550");
        System.out.println("4. Deluxe Non-Veg Pizza - ₹650");

        System.out.print("Enter your choice (veg/nonveg/deluxveg/deluxnonveg): ");
        String type = sc.nextLine();

        Pizza pizza = new Pizza(type);

        System.out.print("Do you want extra cheese? (yes/no): ");
        String cheeseChoice = sc.nextLine();
        if (cheeseChoice.equalsIgnoreCase("yes")) {
            pizza.addExtraCheese();
        }

        System.out.print("Do you want extra toppings? (yes/no): ");
        String toppingsChoice = sc.nextLine();
        if (toppingsChoice.equalsIgnoreCase("yes")) {
            pizza.addExtraToppings();
        }

        pizza.printBill();
        sc.close();
    }
}
