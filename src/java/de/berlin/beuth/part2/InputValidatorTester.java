package de.berlin.beuth.part2;

import java.util.Scanner;

public class InputValidatorTester {

    /*
    The task is described in the src/resources/Exercises for Programmers-InputValidator.pdf file:
            * Input example:
            *
           Enter the first name: J
           Enter the last name:
           Enter the ZIP code: ABCDE
           Enter an employee ID:  A12-1234
           "J" is not a valid first name. It is too short.
           The last name must be filled in.
           The ZIP code must be numeric.
           A12-1234 is not a valid ID.
    or
           Enter the first name: Jimmy
           Enter the last name: James
           Enter the ZIP code: 55555
           Enter an employee ID:  TK-421
           There were no errors found.
            *
            * **/
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first name:");
        String firstNameInput = scanner.next();
        System.out.println("Enter the last name:");
        String lastNameInput = scanner.next();
        System.out.println("Enter the ZIP code:");
        String zipInput = scanner.next();
        System.out.println("Enter an employee ID:");
        String empIdInput = scanner.next();

        InputValidator validator = InputValidator.init();
        validator.takeFirstName(firstNameInput);
        validator.takeLastName(lastNameInput);
        validator.takeZip(zipInput);
        validator.takeEmployeeId(empIdInput);

        String outputMessage = validator
                .validate();
        System.out.println("output: " + outputMessage);

        scanner.close();
    }
}
