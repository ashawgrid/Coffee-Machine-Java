package machine;

import java.util.Scanner;
public class CoffeeMachine {
    public static int water=0,milk=0,coffeeBeans=0,cups=0,money=0;
    public static void setWater(int x){
        water=x;
    }
    public static int getWater(){
        return water;
    }
    public static void addWater(int x){
        water+=x;
    }
    public static void removeWater(int x){
        water-=x;
    }
    public static void setMilk(int x){
        milk=x;
    }
    public static int getMilk(){
        return milk;
    }
    public static void addMilk(int x){
        milk+=x;
    }
    public static void removeMilk(int x){
        milk-=x;
    }
    public static void setCoffeeBeans(int x){
        coffeeBeans=x;
    }
    public static int getCoffeeBeans(){
        return coffeeBeans;
    }
    public static void addCoffeeBeans(int x){
        coffeeBeans+=x;
    }
    public static void removeCoffeeBeans(int x){
        coffeeBeans-=x;
    }
    public static void setCups(int x){
        cups=x;
    }
    public static int getCups(){
        return cups;
    }
    public static void addCups(int x){
        cups+=x;
    }
    public static void removeCups(int x){
        cups-=x;
    }
    public static void setMoney(int x){
        money=x;
    }
    public static int getMoney(){
        return money;
    }
    public static void addMoney(int x){
        money+=x;
    }
    public static void removeMoney(int x){
        money-=x;
    }
    CoffeeMachine(int water,int milk,int coffeeBeans,int cups,int money){
        setWater(water);
        setMilk(milk);
        setCoffeeBeans(coffeeBeans);
        setCups(cups);
        setMoney(money);
    }
    private static void printOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();

        switch (Actions.findByValue(action)) {
            case BUY:
                 buyAction();
                 break;
            case FILL:
                 fillAction();
                 break;
            case TAKE:
                 takeAction();
                 break;
            case REMAINING:
                 printMachineStatus();
                 break;
            case EXIT:
                 exit();
                 break;
            default: break;
        }

    }
    private static void exit() {
        System.exit(0);
    }

    private static void takeAction() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private static void fillAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        addWater(scanner.nextInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        addMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        addCoffeeBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        addCups(scanner.nextInt());
    }

    private static void buyAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? "
                + CoffeeType.ESPRESSO.option + " - espresso, "
                + CoffeeType.LATTE.option + " - latte, "
                + CoffeeType.CAPPUCCINO.option + " - cappuccino, "
                + CoffeeType.NO_COFFEE.option + " - to main menu: ");
        String option = scanner.nextLine();
        switch (CoffeeType.findByOptions(option)) {

            case ESPRESSO:
                 buyingCoffee(CoffeeType.ESPRESSO);
                 break;
            case LATTE:
                 buyingCoffee(CoffeeType.LATTE);
                 break;
            case CAPPUCCINO:
                 buyingCoffee(CoffeeType.CAPPUCCINO);
                 break;
            case NO_COFFEE:
                 printOptions();
                 break;
            default: break;
        }
    }

    private static void buyingCoffee(CoffeeType coffeeType) {
        if (water < coffeeType.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < coffeeType.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < coffeeType.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            removeWater(coffeeType.getWater());
            removeMilk(coffeeType.getMilk());
            removeCoffeeBeans(coffeeType.getCoffeeBeans());
            removeCups(1);
            addMoney(coffeeType.getMoney());
        }

    }

    public static void coffeeMake(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.print("Coffee is ready!");
    }
    //calculate Ingredients function
    public static void calculateIngredients(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cup=sc.nextInt();
        int water=cup*200;
        int milk=cup*50;
        int coffeeBeans=cup*15;
        System.out.println("For 125 cups of coffee you will need:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffeeBeans+" g of coffee beans");
    }
    public static int minThree(int a,int b,int c){
         return Math.min(c, (Math.min(a, b)));
    }
    public static void estimateServings(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water=sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk=sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans=sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cup=sc.nextInt();
        int sufficientWater=water/200;
        int sufficientMilk=milk/50;
        int sufficientCoffeeBeans=coffeeBeans/15;
        int cupPossible=minThree(sufficientWater,sufficientMilk,sufficientCoffeeBeans);
        int extraCups=cupPossible-cup;
        if(extraCups<0){
            System.out.println("No, I can make only " + cupPossible + " cup(s) of coffee");      
        } else if(extraCups==0){
            System.out.println("Yes, I can make that amount of coffee"); 
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)"); 
        }
    }
    private static void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(getWater() + " of water");
        System.out.println(getMilk() + " of milk");
        System.out.println(getCoffeeBeans() + " of coffee beans");
        System.out.println(getCups() + " of disposable cups");
        System.out.println(getMoney() + " money");
    }
    private static void mainLoop() {
        do {
            printOptions();
        } while (true);
    }
    public static void main(String[] args) {
        //coffeeMake();
        //calculateIngredients();
        //estimateServings();
        CoffeeMachine coffeeMachine=new CoffeeMachine(400,540,120,9,550);
        mainLoop();
    }
}
