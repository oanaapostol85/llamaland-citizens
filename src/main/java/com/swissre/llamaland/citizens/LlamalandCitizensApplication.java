package com.swissre.llamaland.citizens;

import java.util.Scanner;

public class LlamalandCitizensApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Llamaland Citizens Celebration!");

        Scanner scanner = new Scanner(System.in);
        String monarchistsFilePath = readMonarchistsFilePath(scanner);
        String nonMonarchistsFilePath = readNonMonarchistsFilePath(scanner);

        new LlamalandCitizensToCelebrateFinder()
                .withMonarchistsFilePath(monarchistsFilePath)
                .withNonMonarchistsFilePath(nonMonarchistsFilePath)
                .findLlamalandCitizensToCelebrate()
                .prettyPrint();
    }

    private static String readMonarchistsFilePath(Scanner scanner) {
        System.out.print("Enter the path of the file containing the citizens supporting the monarchy: ");
        return scanner.next();
    }

    private static String readNonMonarchistsFilePath(Scanner scanner) {
        System.out.print("Enter the path of the file containing the citizens who are not supporting the monarchy: ");
        return scanner.next();
    }
}
