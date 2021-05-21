import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String state = "";

        while (!state.equals("exit")) {

            System.out.println("Write action (buy, fill, take, remaining, exit)");
            Scanner scanner = new Scanner(System.in);
            state = scanner.nextLine().toUpperCase();
            States stateAsEnum = States.valueOf(state);

            switch (stateAsEnum) {
                case BUY: {
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: \n" +
                            "Type 'back' if you want to go back\n");
                    String coffeeType = scanner.nextLine();
                    CoffeeMachine.buyCoffee(coffeeType);
                    break;
                }

                case FILL:
                    System.out.println("Write how many ml of water do you want to add: ");
                    int waterToAdd = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milkToAdd = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int coffeeBeansToAdd = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int disposableCupsToAdd = scanner.nextInt();
                    CoffeeMachine.fillCoffeeMachine(waterToAdd, milkToAdd, coffeeBeansToAdd, disposableCupsToAdd);
                    break;

                case TAKE:
                    CoffeeMachine.takeMoney(CoffeeMachine.money);
                    break;
                case REMAINING:
                    CoffeeMachine.checkRemainingIngredients();
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Invalid command");

            }
        }
    }

}
