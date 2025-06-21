package DesignPatterns.Exercise_1;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("System started");

        Logger logger2 = Logger.getInstance();
        logger2.log("User login");

        System.out.println("Are both logger instances same? " + (logger1 == logger2));
    }
}
