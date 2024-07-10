package view;

import java.util.Scanner;

import calculator.ComplexCalculator;
import logger.ComplexCalcLogger;
import model.ComplexNumber;

public class CompexCalcView {

    private final Scanner iScanner = new Scanner(System.in);
    private final ComplexCalcLogger logger = new ComplexCalcLogger();

    public void run() {

        logger.log("Запуск калькулятора");
        ComplexCalculator calcServ = new ComplexCalculator();
        ComplexNumber result;

        while (true) {
            result = null;
            ComplexNumber complexA = inputComplex("\nПервое комплексное число: ");
            System.out.println("\nПервое число: " + complexA + "\n");
            
            ComplexNumber complexB = inputComplex("Второе комплексное число: ");
            System.out.println("\nВторое число: " + complexB + "\n");

            String command = waitCommand("Введите символ операции (+, *, /, -): ","+","*", "/", "-");

            switch (command) {
                case "+" ->
                    result = calcServ.add(complexA, complexB);
                case "-" ->
                    result = calcServ.sub(complexA, complexB);
                case "*" ->
                    result = calcServ.mul(complexA, complexB);
                case "/" -> {
                    result = calcServ.div(complexA, complexB);
                    if (result == null) {
                        System.out.println("Операция не может быть выполнена из-за деления на ноль!");
                    }
                }
            }

            if (result != null) {
                System.out.println("\nРезультат операции: "  + result + "\n");
            }

            String CmdContinue = waitCommand("Продолжить работу (Да = Y / Нет = N)? ","y", "Y", "n", "N");

            if ((!(CmdContinue.equals("Y"))) && (!(CmdContinue.equals("y")))) {
                
                System.out.println("Окончание работы");
                logger.log("Окончание работы");
                System.exit(0);
            }
        }
    }
    
    private String waitCommand(String message, String cmd1,String cmd2,String cmd3, String cmd4) {
        String symbol = " ";
        while ((!(symbol.equals(cmd1))) && (!(symbol.equals(cmd2))) && (!(symbol.equals(cmd3))) && (!(symbol.equals(cmd4)))) {
            System.out.print(message);
                symbol = iScanner.nextLine();
            }
        return symbol;
        }

    private double inputPartComplex(String message) {
        double res = 0.0d;
        boolean readSuccess = false;
        while (!readSuccess) {
            System.out.print(message);
            try {
                res = Double.parseDouble(iScanner.nextLine());
                readSuccess = true;
            } catch (Exception e) {
                System.out.println("Необходимо ввести число");
                readSuccess = false;
            }
        }
        return res;
    }

    private ComplexNumber inputComplex(String message) {
        System.out.println(message);
        double inputXComplex = inputPartComplex("Введите вещественную часть: ");
        double inputYComplex = inputPartComplex("Введите мнимую часть: ");
        ComplexNumber res = new ComplexNumber(inputXComplex, inputYComplex);
        logger.log("Введено число " + res);
        return res;
    }
}