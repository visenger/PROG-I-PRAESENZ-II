package de.berlin.beuth.part2;


import java.util.function.Predicate;

/**
 * Created by visenger on 30/09/16.
 */
public class InputValidator {

    private String firstName;
    private String lastName;
    private String zip;
    private String employeeId;

    private String outputMessage;
    private boolean isValide = false;


    private InputValidator() {

    }

    public static InputValidator init() {
        return new InputValidator();
    }

    public InputValidator takeFirstName(String fName) {
        this.setFirstName(fName);
        return this;
    }

    public InputValidator takeLastName(String lName) {
        this.setLastName(lName);
        return this;
    }

    public InputValidator takeZip(String z) {
        this.setZip(z);
        return this;
    }

    public InputValidator takeEmployeeId(String id) {
        this.setEmployeeId(id);
        return this;
    }

    /*
           *
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

    //Behavior parametrisation with Predicate function
    private boolean validate(String input, Predicate<String> p) {
        return p.test(input);
    }

    public String validate() {

        //here is the core logic of validation:

        //validate first;

        //boolean validateFirstName = validate(this.getFirstName(), StrValidator::firstNameIsCorrect);
        boolean validateFirstName
                = validate(this.getFirstName(), (a) -> StrValidator.firstNameIsCorrect(a));

        String out = getOutputForFirstName(validateFirstName);

        boolean validateZip = validate(this.getZip(), ZipValidator::checkDigit);

        String zipOut = getOutputForZip(validateZip);

        out = out +
                zipOut;
        this.setOutputMessage(out);


        //validate second;

        //validate third;

        //validate fourth;

        return this.getOutputMessage();
    }

    private String getOutputForZip(boolean valideZip) {
        return valideZip ? " correct zip" : " zip is brocken";
    }

    private String getOutputForFirstName(boolean valideFirstName) {
        return valideFirstName ? " correct first name" : " the first name is not correct";
    }


    /* Getter and Setter section: */

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZip() {
        return zip;
    }

    private void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    private void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    private void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public boolean isValide() {
        return isValide;
    }

    private void setValide(boolean valide) {
        isValide = valide;
    }
}

class StrValidator {

    public static boolean firstNameIsCorrect(String firstName) {
        /* YOUR CODE HERE */
        return false;
    }

    public static boolean lastNameIsCorrect(String last) {
        /* YOUR CODE HERE */
        return false;
    }


}

class ZipValidator {

    public static boolean checkDigit(String z) {
        /* YOUR CODE HERE */
        return false;
    }
}
