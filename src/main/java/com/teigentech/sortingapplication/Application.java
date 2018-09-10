package com.teigentech.sortingapplication;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern p = Pattern.compile("[^A-Za-z0-9]");

        System.out.print("start typing : ");
        String input = scanner.nextLine();
        SortingOperation sortingOperation = new SortingOperation();

        do {
            sortingOperation.sortInput(input).forEach(System.out::println);
            System.out.println("--------------");
            System.out.print(input);

            input = input + scanner.nextLine();
            System.out.println("--------------");

        }while (!p.matcher(input).find());
    }
}
