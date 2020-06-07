package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private Integer water = 400;
    private Integer milk = 540;
    private Integer coffeeBeans = 120;
    private Integer cups = 9;
    private Integer money = 550;

    public static void main(String[] args) {
        new CoffeeMachine().run();
    }

    private void run() {
        chooseAction();
    }

    private void chooseAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                showCurrentState();
                break;
            case "exit":
                return;
        }
    }

    private void showCurrentState() {
        System.out.println();
        System.out.println("The coffe machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();

        chooseAction();
    }

    private void buy() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if ("back".equals(option)) {
            System.out.println();
        } else {
            switch (Integer.parseInt(option)) {
                case 1:
                    makeEspresso();
                    break;
                case 2:
                    makeLatte();
                    break;
                case 3:
                    makeCappuccino();
                    break;
            }
            System.out.println();
        }

        chooseAction();
    }

    private void makeEspresso() {
        int waterPortion = 250;
        int milkPortion = 0;
        int coffeeBeansPortion = 16;
        int moneyPerCup = 4;
        if (checResources(waterPortion, milkPortion, coffeeBeansPortion)) {
            water -= waterPortion;
            coffeeBeans -= coffeeBeansPortion;
            money += moneyPerCup;
            cups--;
        }
    }

    private void makeLatte() {
        int waterPortion = 350;
        int milkPortion = 75;
        int coffeeBeansPortion = 20;
        int moneyPerCup = 7;
        if (checResources(waterPortion, milkPortion, coffeeBeansPortion)) {
            water -= waterPortion;
            milk -= milkPortion;
            coffeeBeans -= coffeeBeansPortion;
            money += moneyPerCup;
            cups--;
        }
    }

    private void makeCappuccino() {
        int waterPortion = 200;
        int milkPortion = 100;
        int coffeeBeansPortion = 12;
        int moneyPerCup = 6;
        if (checResources(waterPortion, milkPortion, coffeeBeansPortion)) {
            water -= waterPortion;
            milk -= milkPortion;
            coffeeBeans -= coffeeBeansPortion;
            money += moneyPerCup;
            cups--;
        }
    }

    private boolean checResources(int waterQt, int milkQt, int beansQt) {
        if (waterQt > water) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milkQt > milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beansQt > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    private void fill() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int waterAmount = scanner.nextInt();
        water += waterAmount;
        System.out.println("Write how many ml of milk do you want to add:");
        int milkAmount = scanner.nextInt();
        milk += milkAmount;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeansAmount = scanner.nextInt();
        coffeeBeans += coffeeBeansAmount;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsAmount = scanner.nextInt();
        cups += cupsAmount;
        System.out.println();

        chooseAction();
    }

    private void take() {
        System.out.println();
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();

        chooseAction();
    }      
}
