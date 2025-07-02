package org.example;

import java.util.*;

public class Main {

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        pizzas.add(pizzaType);
        quantities.add(quantity);
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        quantities.set(index, newQuantity);
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        pizzas.remove(index);
        quantities.remove(index);
    }

    public static void printOrders (ArrayList<String> pizzas, ArrayList<Integer> quantities){

        System.out.println("\n" + "--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++){
            System.out.printf("%d. %s x %d" + "\n", (i + 1), pizzas.get(i), quantities.get(i));
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> pizzas = new ArrayList<String>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        while (true){

            System.out.printf("\n" + "Choose option: ");
            int userOption = scanner.nextInt();

            switch (userOption){
                case 1:

                    System.out.printf("\n" + "Pizza Type: ");
                    String pizzaType = scanner.next();

                    while(true){

                        System.out.printf("Quantity: ");
                        int pizzaQuantity = scanner.nextInt();

                        if (pizzaQuantity <= 0){
                            System.out.println("Quantity must be positive");
                            continue;
                        }

                        addOrder(pizzas, quantities, pizzaType, pizzaQuantity);
                        break;

                    }

                    break;
                case 2:

                    System.out.printf("\n" + "Order number to update: ");
                    int updateOrderNumber = scanner.nextInt();

                    if (updateOrderNumber - 1 < 0 || updateOrderNumber - 1 >= pizzas.size() || pizzas.get(updateOrderNumber - 1) == null){
                        System.out.println("Order number does not exist or is wrong!");
                        break;
                    }

                    while(true){


                        System.out.printf("Quantity: ");
                        int newPizzaQuantity = scanner.nextInt();

                        if (newPizzaQuantity <= 0){
                            System.out.println("Quantity must be positive");
                            continue;
                        }

                        updateOrder(quantities, (updateOrderNumber - 1), newPizzaQuantity);
                        break;

                    }

                    break;
                case 3:

                    System.out.printf("\n" + "Order number to remove: ");
                    int removeOrderNumber = scanner.nextInt();

                    if (removeOrderNumber - 1 < 0 || removeOrderNumber - 1 >= pizzas.size() || pizzas.get(removeOrderNumber - 1) == null){
                        System.out.println("Order number does not exist or is wrong!");
                        break;
                    }

                    removeOrder(pizzas, quantities, removeOrderNumber - 1);
                    break;

                case 4:

                    printOrders(pizzas, quantities);

                    break;
                case 5:

                    System.out.println("--- Thank you! ---");

                    return;
            }

        }
    }
}