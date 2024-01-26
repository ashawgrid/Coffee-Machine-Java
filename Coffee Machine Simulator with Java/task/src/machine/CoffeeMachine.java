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
    public static void printCoffeeMachine(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " grams of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
    public static void buyExpresso(){
        removeWater(250);
        removeCoffeeBeans(16);
        removeCups(1);
        addMoney(4);
    }
    public static void buyLatte(){
        removeWater(350);
        removeMilk(75);
        removeCoffeeBeans(20);
        removeCups(1);
        addMoney(7);
    }
    public static void buyCappuccino(){
        removeWater(200);
        removeMilk(100);
        removeCoffeeBeans(12);
        removeCups(1);
        addMoney(6);
    }
    public static boolean enoughWater(int x){
        if(water>=x)
        return true;
        System.out.println("Sorry, not enough water!");
        return false;
    }
    public static boolean enoughMilk(int x){
        if(milk>=x)
        return true;
        System.out.println("Sorry, not enough milk!");
        return false;
    }
    public static boolean enoughCoffeeBeans(int x){
        if(coffeeBeans>=x)
        return true;
        System.out.println("Sorry, not enough coffee beans!");
        return false;
    }
    public static boolean makeExpresso(){
        if(!enoughWater(250))
        return false;
        if(!enoughCoffeeBeans(16))
        return false;
        return true;
    }
    public static boolean makeLatte(){
        if(!enoughWater(350))
        return false;
        if(!enoughMilk(75))
        return false;
        if(!enoughCoffeeBeans(20))
        return false;
        return true;
    }
    public static boolean makeCappuccino(){
        if(!enoughWater(200))
        return false;
        if(!enoughMilk(100))
        return false;
        if(!enoughCoffeeBeans(12))
        return false;
        return true;
    }
    public static void buy(){
        Scanner sc=new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice=sc.nextLine();
        switch(choice){
            case "1": if(makeExpresso())
                      {
                          System.out.println("I have enough resources, making you a coffee!");
                          buyExpresso();
                      }
                      break;
            case "2": if(makeLatte())
                      {
                          System.out.println("I have enough resources, making you a coffee!");
                          buyLatte();
                      }
                      break;
            case "3": if(makeCappuccino())
                      {
                          System.out.println("I have enough resources, making you a coffee!");
                          buyCappuccino();
                      }
                      break;
            case "back": break;
            default: 
        }
    }
    public static void fill(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int x=sc.nextInt();
        addWater(x);
        System.out.println("Write how many ml of milk you want to add: ");
        x=sc.nextInt();
        addMilk(x);
        System.out.println("Write how many grams of coffee beans you want to add: ");
        x=sc.nextInt();
        addCoffeeBeans(x);
        System.out.println("Write how many disposable cups you want to add: ");
        x=sc.nextInt();
        addCups(x);
    }
    public static void take(){
        int x=getMoney();
        System.out.println("I gave you $" + x);
        setMoney(0);
    }
    public static void chooseActions(){
        Scanner sc=new Scanner(System.in);
        while(true){
          System.out.println("Write action (buy, fill, take, remaining, exit): ");
          String choice=sc.nextLine();
          switch(choice){
            case "buy":     //printCoffeeMachine();
                            buy();
                            //printCoffeeMachine();
                            break;
            case "fill":    //printCoffeeMachine();
                            fill();
                            //printCoffeeMachine();
                            break;
            case "take":    //printCoffeeMachine();
                            take();
                            //printCoffeeMachine();
                            break;
            case "remaining": printCoffeeMachine();
                              break;
            case "exit": return;
            default: 
          }
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
         return c<(a<b?a:b)?c:(a<b?a:b);
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
    public static void setCoffeeMachine(){
        setWater(400);
        setMilk(540);
        setCoffeeBeans(120);
        setCups(9);
        setMoney(550);
    }
    public static void main(String[] args) {
        //coffeeMake();
        //calculateIngredients();
        //estimateServings();
        setCoffeeMachine();
        chooseActions();
    }
}
