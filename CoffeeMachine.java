public class CoffeeMachine {

    static int waterCupEspresso = 250;
    static int coffeeBeansCupEspresso = 16;
    static int espressoCost = 4;

    static int waterCupLatte = 350;
    static int milkCupLatte = 75;
    static int coffeeBeansCupLatte = 20;
    static int latteCost = 7;

    static int waterCupCappuccino = 200;
    static int milkCupCappuccino = 100;
    static int coffeeBeansCupCappuccino = 12;
    static int cappuccinoCost = 6;

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;

    public static int verifyNumberOfServings(int coffeeType, int waterHas, int milkHas, int coffeeBeansHas, int disposableCupsHas, int moneyHas) {
        int[] ingredients = {waterHas, milkHas, coffeeBeansHas, disposableCupsHas, moneyHas};
        int cupsOfCoffee = 1;
        int numberOfServings = calculateNumberOfServings(ingredients, coffeeType);
        if (numberOfServings > cupsOfCoffee) {
            return 1;
        } else if (numberOfServings == cupsOfCoffee) {
            return 0;
        } else {
            return -1;
        }
    }

    public static int calculateNumberOfServings(int[] ingredients, int coffeeType) {
        int water = ingredients[0];
        int milk = ingredients[1];
        int coffeeBeans = ingredients[2];
        int disposableCups = ingredients[3];

        if (disposableCups <= 0) {
            return -1;
        }

        switch (coffeeType) {
            case 1:
                if (water / waterCupEspresso <= coffeeBeans / coffeeBeansCupEspresso) {
                    return water / waterCupEspresso;
                } else if (coffeeBeans / coffeeBeansCupEspresso <= water / waterCupEspresso) {
                    return coffeeBeans / coffeeBeansCupEspresso;
                } else {
                    return 0;
                }
            case 2:
                if (water / waterCupLatte <= milk / milkCupLatte && water / waterCupLatte <= coffeeBeans / coffeeBeansCupLatte) {
                    return water / waterCupLatte;
                } else if (milk / milkCupLatte <= water / waterCupLatte && milk / milkCupLatte <= coffeeBeans / coffeeBeansCupLatte) {
                    return milk / milkCupLatte;
                } else if (coffeeBeans / coffeeBeansCupLatte <= water / waterCupLatte && coffeeBeans / coffeeBeansCupLatte <= milk / milkCupLatte) {
                    return coffeeBeans / coffeeBeansCupLatte;
                } else {
                    return 0;
                }
            case 3:
                if (water / waterCupCappuccino <= milk / milkCupCappuccino && water / waterCupCappuccino <= coffeeBeans / coffeeBeansCupCappuccino) {
                    return water / waterCupCappuccino;
                } else if (milk / milkCupCappuccino <= water / waterCupCappuccino && milk / milkCupCappuccino <= coffeeBeans / coffeeBeansCupCappuccino) {
                    return milk / milkCupCappuccino;
                } else if (coffeeBeans / coffeeBeansCupCappuccino <= water / waterCupCappuccino && coffeeBeans / coffeeBeansCupCappuccino <= milk / milkCupCappuccino) {
                    return coffeeBeans / coffeeBeansCupCappuccino;
                } else {
                    return 0;
                }

        }
        return 0;
    }

    public static void buyCoffee(String coffeeType) {
        if (!coffeeType.equals("back")) {
            switch (Integer.valueOf(coffeeType)) {
                case 1:
                    if (verifyNumberOfServings(1, water, milk, coffeeBeans, disposableCups, money) >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= waterCupEspresso;
                        coffeeBeans -= coffeeBeansCupEspresso;
                        disposableCups--;
                        money += espressoCost;
                    } else if (water < waterCupEspresso) {
                        System.out.println("Sorry, not enough water!");
                    } else if (coffeeBeans < coffeeBeansCupEspresso) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    break;
                case 2:
                    if (verifyNumberOfServings(2, water, milk, coffeeBeans, disposableCups, money) >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= waterCupLatte;
                        milk -= milkCupLatte;
                        coffeeBeans -= coffeeBeansCupLatte;
                        disposableCups--;
                        money += latteCost;
                    } else if (water < waterCupLatte) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < milkCupLatte) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeeBeans < coffeeBeansCupLatte) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    break;
                case 3:
                    if (verifyNumberOfServings(3, water, milk, coffeeBeans, disposableCups, money) >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water -= waterCupCappuccino;
                        milk -= milkCupCappuccino;
                        coffeeBeans -= coffeeBeansCupCappuccino;
                        disposableCups--;
                        money += cappuccinoCost;
                    } else if (water < waterCupCappuccino) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < milkCupCappuccino) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeeBeans < coffeeBeansCupCappuccino) {
                        System.out.println("Sorry, nopt enough coffee beans!");
                    } else if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    break;
                default:
                    System.out.println("Invalid number");
                    break;
            }
        }
    }

    public static void fillCoffeeMachine(int waterToAdd, int milkToAdd, int coffeeBeansToAdd, int disposableCupsToAdd) {
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += disposableCupsToAdd;
    }

    public static void takeMoney(int money) {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    public static void checkRemainingIngredients() {
        System.out.print("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                disposableCups + " of disposable cups\n" +
                "$" + money + " of money\n");
    }

}
