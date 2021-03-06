package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

import static io.zipcoder.casino.Card.Suit.*;

public class Utilities {
    public static String getUserInput(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public static void printMenuName(String menuName) {
        System.out.printf("\n\n%s%s%s%s\u2685\u2685 %s \u2680\u2680%s%s%s%s\n",
                SPADES.getIcon(), HEARTS.getIcon(), DIAMONDS.getIcon(), CLUBS.getIcon(),
                menuName,
                CLUBS.getIcon(), DIAMONDS.getIcon(), HEARTS.getIcon(), SPADES.getIcon());
    }

    public static void printMenuOptions(ArrayList<String> menuOptions) {
        StringJoiner stringJoiner = new StringJoiner(" ] * [ ", "[ ", " ]\n");
        for(String option : menuOptions) {
            stringJoiner.add(option);
        }
        System.out.println(stringJoiner.toString());
    }

    public static String getMenuInput(String prompt, ArrayList<String> menuOptions) {
        String input = "";
        boolean isValidInput = false;
        while(!isValidInput) {
            input = getUserInput(prompt);
            for(String option : menuOptions) {
                if(option.equalsIgnoreCase(input)) {
                    isValidInput = true;
                    break;
                }
            }
            if(!isValidInput) {
                System.out.println("Invalid selection");
            }
        }
        return input;
    }

    public static Integer getIntegerInput(String prompt) {
        boolean isValidInput = false;
        Integer userIntegerInput = 0;
        while(!isValidInput) {
            Double userDoubleInput = getDoubleInput(prompt);
            userIntegerInput = (int) Math.round(userDoubleInput);
            if(Math.abs(userDoubleInput - userIntegerInput) == 0) {
                isValidInput = true;
            } else {
                System.out.println("Please enter an integer");
            }
        }
        return userIntegerInput;
    }

    public static Double getDoubleInput(String prompt) {
        Double userDoubleInput = 0.0;
        boolean isValidInput = false;
        while(!isValidInput) {
            String userInput = getUserInput(prompt);
            try {
                userDoubleInput = Double.parseDouble(userInput);
                isValidInput = true;
            } catch (IllegalArgumentException iae) {
                System.out.println("Invalid input");
            }
        }

        return userDoubleInput;
    }

    public static Double getMoneyInput(String prompt) {
        Double userAmountInput = 0.0;
        boolean isValidInput = false;
        while(!isValidInput) {
            userAmountInput = getDoubleInput(prompt);
            if(userAmountInput >= 0) {
                if(userAmountInput * 100 - Math.floor(userAmountInput * 100) == 0) {
                    isValidInput = true;
                } else {
                    System.out.println("Must enter an amount with up to two decimal places in accuracy");
                }
            } else {
                System.out.println("Must enter a positive amount");
            }
        }
        return userAmountInput;
    }

    public static boolean getYesOrNoInput(String prompt) {
        boolean input = false;
        boolean isValidInput = false;
        while(!isValidInput) {
            String userInput = getUserInput(prompt);
            if("Y".equalsIgnoreCase(userInput)) {
                input = true;
                isValidInput = true;
            }
            else if("N".equalsIgnoreCase(userInput)) {
                input = false;
                isValidInput = true;
            }
            else {
                System.out.println("Invalid input, must enter Y or N");
            }
        }
        return input;
    }
}
