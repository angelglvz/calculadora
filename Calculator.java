
/***********************
 *
 * Class Name: FinalCalculator
 * Author/s name: Enrique Cepeda Villamayor and Angel Custodio Gamero
 * Release/Creation date: 16/12/2017
 * Class version:
 * Class description: This class contains The main class and the different methods that the program use to work
 *
 ************************
 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WELCOME AGAIN TO THE MENU OF THE CALCULATOR");
        System.out.println("Choose an option show in the screen writing its number");
        boolean b=true;
        //sc.nextLine();
        while (b) {
            System.out.println("1.Simple calculator  2.Complex Calculator 3.Scientific calculator 4.Matrix 0.To turn off the calculator");
            String input=sc.nextLine();
            if (input.length()==1 && input.matches("[0-4]")) {
                switch (input) { //Menu
                    case "1": //Simple calculator
                        simpleCalculator();
                        break;
                    case "2": //Complex calculator
                        complexCalculator();
                        break;
                    case "3"://scientific calculator
                        scientificCalculator();
                        break;
                    case "4"://Matrix calculator
                        matrixCalculator();
                        break;
                    case "0":
                        b=false;
                        break;
                }
            }else {
                System.out.println("Invalid option");
            }
        }
        System.out.println("OFF");
    }
/**
 ***************MAIN END********************
 */

    /***********************
     *
     * Method name: SimpleCalculator
     *
     * Description of the Method: Method to show the menu of the simple calculator
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     ***********************/

    private static void simpleCalculator() {
        boolean b=true;
        double result = 0.0;
        while (b) {
            System.out.println("Choose the operation you want to do");
            System.out.println("1.Addition 2.Subtraction 3.Multiplication 4.Division 0.To menu");
            String input=sc.nextLine();
            if (input.length()==1 && input.matches("[0-4]")) {
                switch (input) {
                    case "1": //Sum
                        result = addition();
                        break;
                    case "2": //Subtraction
                        result = subtraction();
                        break;
                    case "3"://Multiplication
                        result = multiplication();
                        break;
                    case "4"://Division
                        result = division();
                        break;
                    case "0"://
                        b= false;
                        break;
                }
                if (input.matches("[1-4]")) {
                    System.out.println("The result is " + result);
                }
            }else {
                System.out.println("Invalid option");
            }
        }
    }

    /***********************
     *
     * Method name: complexCalculator
     *
     * Description of the Method: Method to show the menu of the complex calculator
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     ***********************/
    private static void complexCalculator() {
        boolean b=true;
        while (b) {
            System.out.println("\nChoose the format of the complex number");
            System.out.println("1.Polar 2.Rectangular 0.Go back");
            String input=sc.nextLine();
            if (input.length()==1 && input.matches("[0-2]")) {
                switch (input) {//Polar o rectangular, or go out
                    case "1": //Polar
                        boolean b1= true;
                        while (b1) {
                            System.out.println("Choose the operation you want to do");
                            System.out.println("1.Addition 2.Subtraction 3.Multiplication 4.Division 5.Transform polar to rectangular 0.Go to the main menu");
                            String input1 = sc.nextLine();
                            if (input1.length()==1 && input1.matches("[0-5]")) {
                                double[] result_array = new double[2];
                                switch (input1) {
                                    case "1": //Sum
                                        result_array = polarAddition();
                                        break;
                                    case "2": //Subtraction
                                        result_array = polarSubtraction();
                                        break;
                                    case "3"://Multiplication
                                        result_array = polarMultiplication();
                                        break;
                                    case "4"://Division
                                        result_array = polarDivision();
                                        break;
                                    case "5"://Polar to rectangular
                                        result_array = polarToRectangular();
                                        break;
                                    case "0"://
                                        b1=false;
                                        break;
                                }
                                if (input1.matches("[1-4]")) {
                                    System.out.println("The result is: " + result_array[0] + " " + result_array[1] + "º\n");
                                } else if (input1.equalsIgnoreCase("5")) {
                                    System.out.println(msgReturn(result_array[0], result_array[1]));
                                }
                            }else {
                                System.out.println("Invalid option");
                            }
                        }
                        break;
                    case "2": //Rectangular
                        boolean b2= true;
                        while (b2) {
                            System.out.println("Choose the operation you want to do");
                            System.out.println("1.Addition 2.Subtraction 3.Multiplication 4.Division 5.Transform rectangular to polar 0.Go to the main menu");
                            String input2 = sc.nextLine();
                            if (input2.length()==1 && input2.matches("[0-5]")) {
                                double[] result2 = new double[2];
                                switch (input2) {
                                    case "1": //Sum
                                        result2 = rectangularAddition();
                                        break;
                                    case "2": //Subtraction
                                        result2 = rectangularSubtraction();
                                        break;
                                    case "3": // Multiplication
                                        result2 = rectangularMultiplication();
                                        break;
                                    case "4":// Division
                                        result2 = rectangularDivision();
                                        break;
                                    case "5"://Rectangular to polar
                                        result2 = convertRectangularToPolar();
                                        break;
                                    case "0"://
                                        b2=false;
                                        break;
                                }
                                if (input2.matches("[1-4]")) {
                                    System.out.println(msgReturn(result2[0], result2[1]));
                                } else if (input2.equalsIgnoreCase("5")) {
                                    System.out.print("The result is: " + result2[0] + " " + result2[1] + "º \n");
                                }
                            }else {
                                System.out.println("Invalid option");
                            }
                        }
                        break;
                    case "0": //Menu
                        b= false;
                        break;
                    default:
                        System.out.println("The number you have written is incorrect");
                }
            }else {
                System.out.println("Invalid option");
            }
        }
    }

    /***********************
     *
     * Method name: scientificCalculator
     *
     * Description of the Method: Method to show the menu of the scientific calculator
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     ***********************/

    private static void scientificCalculator() {
        double result = 0;
        boolean b= true;

        while (b) {
            System.out.println("Choose the operation you want to do");
            System.out.print("1.Factorial 2.Power 3.Power base e 4.Nth root  5.Reciprocal ");
            System.out.println("6.Natural Logarithm 7.Decimal logarithm 8.Cosine 9.Sine 10.Tangent 0.Go to the main menu");
            String input = sc.nextLine();
            if ((input.length() == 1 && input.matches("[0-9]")) || (input.length() == 2 && input.equalsIgnoreCase("10"))) {
                switch (input) {
                    case "1"://Factorial
                        result = factorial();
                        break;
                    case "2"://Power
                        result = power();
                        break;
                    case "3"://Power base e
                        result = powerBaseE();
                        break;
                    case "4"://Nth root
                        result = nthRoot();
                        break;
                    case "5": //Reciprocal
                        result = reciprocal();
                        break;
                    case "6"://Natural logarithm
                        result = naturalLogarithm();
                        break;
                    case "7": //Decimal logarithm
                        result = decimalLogarithm();
                        break;
                    case "8":// Cosine
                        result = cosine();
                        break;
                    case "9": //Sinus
                        result = sinus();
                        break;
                    case "10": //tangent
                        result = tangent();
                        break;
                    case "0"://
                        b=false;
                        break;

                }
                if (input.matches("[1-9]") || input.equalsIgnoreCase("10")) {
                    System.out.println("The result is " + result);
                }

            }else {
                System.out.println("Invalid option");
            }
        }
    }

    /***********************
     *
     * Method name: matrixCalculator
     *
     * Description of the Method: Method to show the menu of the matrix calculator
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     ***********************/

    private static void matrixCalculator() {
        boolean b=true;
        while (b) {
            System.out.println("Choose the operation you want to do");
            System.out.println("1.Addition 2.Transposition 3.Multiplication 4.Row or column with highest summation 0.Go to the main menu");
            String input=sc.nextLine();
            if (input.length()==1 && input.matches("[0-4]")){
                switch (input) {
                    case "1": //Addition
                        array_addition();
                        break;
                    case "2": // Transposition
                        array_transposition();
                        break;
                    case "3": // Multiplication
                        array_multiplication();
                        break;
                    case "4":// Row or column of highest summation
                        array_highestadd();
                        break;
                    case "0":
                        b=false;
                        break;
                    default:
                }
            }else {
                System.out.println("Invalid option");
                b=true;
            }

        }
    }

    /***********************
     *
     * Method name: addition
     *
     * Description of the Method: Method to add two double numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method return the result of the addition of both numbers, the return type is double too.
     *
     ***********************/
    private static double addition() {
        double solution;
        double num1 = readDouble("Give me the first number you want to add\n");
        double num2 = readDouble("Give me the second number you want to add\n");
        solution = num1 + num2;
        return solution;
    }

    /***********************
     *
     * Method name: subtraction
     *
     * Description of the Method: Method to subtract two double numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method return the result of the subtraction of both numbers, the return type is double too.
     *
     ***********************/

    private static double subtraction() {
        double solution;
        double num1 = readDouble("Give me the first number\n");
        double num2 =  readDouble("Give me the number you want to subtract\n");
        solution = num1 - num2;
        return solution;
    }

    /***********************
     *
     * Method name: multiplication
     *
     * Description of the Method: Method to multiply two double numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method return the result of the multiplication of both numbers, the return type is double too.
     *
     ***********************/
    private static double multiplication() {
        double solution;
        double num1 = readDouble("Give me the first number you want to multiply\n");
        double num2 = readDouble("Give me the second number\n");
        solution = num1 * num2;
        return solution;
    }

    /***********************
     *
     * Method name: division
     *
     * Description of the Method: Method to multiply two double numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method return the result of the division of both numbers, the return type is double too.
     *
     ***********************/
    private static double division() {
        double solution=0.0;
        boolean b= true;
        while(b) {
            double num1 = readDouble("Give me the first number\n");
            double num2 = readDouble("Give me the number you want to divide\n");;
            if (num2 == 0) {
                System.out.println("You cannot divide a number by zero");
            }else {
                solution = num1 / num2;
                b=false;
            }
        }

        return solution;
    }

    /***********************
     *
     * Method name: polarAddition
     *
     * Description of the Method: This method add two polar numbers that we ask to the user, execute some
     * methods, it does some operations and then show the result. (it also have more methods inside that
     * we willl explain later)
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     ***********************/
    private static double[] polarAddition() {
        double length1 =readDouble("Give me the length of the first number you want to add\n");
        double angle1 = readDouble("Give me the angle of the first number you want to add\n");
        angle1 = angle1 * Math.PI / 180;
        double[] r = conPolarToRec(length1, angle1);//We transform the first number into rectangular, and we save this data in the matrix r
        double length2 = readDouble("Give me the length of the second number you want to add\n");
        double angle2 = readDouble("Give me the angle of the second number you want to add\n");
        angle2 = angle2 * Math.PI / 180;
        double[] r2 = conPolarToRec(length2, angle2);//We transform the second number into rectangular, and we save this data in the matrix r2
        length1 = r[0] + r2[0];
        angle1 = r[1] + r2[1];
        r = conRecToPolar(length1, angle1);//We transform the result into polar, and we save this data in the matrix r
        r[1] = conAngles(r[1]);//We transform the length into the (-360,360) range
        return r;
    }

    /***********************
     *
     * Method name: polarSubtraction
     *
     * Description of the Method: This method subtract two polar numbers that we ask to the user, execute some numerical
     * methods and then show the result. (it also have more methods inside that we will explain later)
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     ***********************/
    private static double[] polarSubtraction() {
        double length1 = readDouble("Give me the length of the first number you want to add\n");
        double angle1 = readDouble("Give me the angle of the first number you want to add\n");
        angle1 = angle1 * Math.PI / 180;
        //We transform the first number into rectangular, and we save this data in the matrix r
        double[] r = conPolarToRec(length1, angle1);
        double length2 = readDouble("Give me the length of the second number you want to add\n");
        double angle2 = readDouble("Give me the angle of the second number you want to add\n");
        angle2 = angle2 * Math.PI / 180;
        //We transform the second number into rectangular, and we save this data in the matrix r2
        double[] r2 = conPolarToRec(length2, angle2);
        length1 = r[0] - r2[0];
        angle1 = r[1] - r2[1];
        r = conRecToPolar(length1, angle1);//We transform the result into polar, and we save this data in the matrix r
        r[1] = conAngles(r[1]);//We transform the length into the (-360,360) range
        return r;
    }

    /*********************************************************************
     *
     * Method name: polarMultiplication
     *
     * Description of the Method: This method multiply two polar numbers that we ask to the user, execute some numerical
     * methods and then show the result. (it also have more methods inside that we´ll explain later)
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the multiplication in polar form, in a 2x1 array,
     * in the first position is the length, and in the second the angle.
     *
     *********************************************************************/
    private static double[] polarMultiplication() {
        double num1 =  readDouble("Give me the length of the first number you want to multiply\n");
        double imaginary1 =  readDouble("Give me the angle of the first number you want to multiply\n");
        double num2 =  readDouble("Give me the length of the second number you want to multiply\n");
        double imaginary2 =  readDouble("Give me the angle of the second number you want to multiply\n");
        double r = num1 * num2;
        double alpha = imaginary1 + imaginary2;
        alpha = conAngles(alpha);//We transform the angle into the (-360,360) range
        double[] result = {r, alpha};//We save the data in the matrix result
        return result;
    }

    /*********************************************************************
     *
     * Method name: polarDivision
     *
     * Description of the Method: This method divide two polar numbers that we ask to the user, execute some numerical
     * methods and then show the result. (it also have more methods inside that we´ll explain later)
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the division in polar form ,in a 2x1 array,
     * in the first position is the length and in the second the angle
     *********************************************************************/
    private static double[] polarDivision() {
        double num1 =  readDouble("Give me the length of the first number you want to divide\n");
        double imaginary1 =  readDouble("Give me the angle of the first number you want to divide\n");
        double num2 =  readDouble("Give me the length of the second number you want to divide\n");
        double imaginary2 =  readDouble("Give me the angle of the second number you want to divide\n");
        double r = num1 / num2;
        double alpha = imaginary1 - imaginary2;
        alpha = conAngles(alpha);//We transform the angle into the (-360,360) range
        double[] result = {r, alpha};//We save the data in the matrix result
        return result;
    }

    /*********************************************************************
     *
     * Method name: polarToRectangular
     *
     * Description of the Method: This method converts a polar number that we ask to the user, into a rectangular number.
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the rectangular number in a 2x1 array, in the first position is the real part
     * , and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] polarToRectangular() {
        double r = readDouble("Give me the length\n");
        double alpha = readDouble("Give me the angle\n");
        alpha = alpha * Math.PI / 180;
        double[] result = conPolarToRec(r, alpha);//We convert the polar number into rectangular with a method,
        // and then we save the result in a matrix
        return result;
    }

    /*********************************************************************
     *
     * Method name: rectangularAddition
     *
     * Description of the Method: This method add two rectangular numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the rectangular number in a 2x1 array, in the first position is the real part
     * ,and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] rectangularAddition() {
        double num1 = readDouble("Give me the real part of the first number\n");
        double imaginary1 = readDouble("Give me the imaginary part of the first number\n");
        double num2 = readDouble("Give me the real part of the second number\n");
        double imaginary2 = readDouble("Give me the imaginary part of the second number\n");
        double realPart = num1 + num2; //Real Part
        imaginary1 = imaginary1 + imaginary2;//Imaginary Part
        double[] result = {realPart, imaginary1};
        return result;
    }

    /*********************************************************************
     *
     * Method name: rectangularSubtraction
     *
     * Description of the Method: This method subtract two rectangular numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the rectangular number in a 2x1 array, in the first position is the real part
     * ,and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] rectangularSubtraction() {
        double num1 = readDouble("Give me the real part of the first number\n");
        double imaginary1 = readDouble("Give me the imaginary part of the first number\n");
        double num2 = readDouble("Give me the real part of the second number\n");
        double imaginary2 = readDouble("Give me the imaginary part of the second number\n");
        double realPart = num1 - num2; //Real Part
        imaginary1 = imaginary1 - imaginary2;//Imaginary Part
        double[] result = {realPart, imaginary1};
        return result;
    }

    /*********************************************************************
     *
     * Method name: rectangularMultiplication
     *
     * Description of the Method: This method multiply two rectangular numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the rectangular number in a 2x1 array, in the first position is the real part
     * ,and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] rectangularMultiplication() {
        double num1 = readDouble("Give me the real part of the first number\n");
        double imaginary1 = readDouble("Give me the imaginary part of the first number\n");
        double num2 = readDouble("Give me the real part of the second number\n");
        double imaginary2 = readDouble("Give me the imaginary part of the second number\n");
        double realPart = (num1 * num2) - (imaginary1 * imaginary2);
        double imaginary = (num1 * imaginary2) + (num2 * imaginary1);
        double[] result = {realPart, imaginary};
        return result;
    }

    /*********************************************************************
     *
     * Method name: rectangularDivision
     *
     * Description of the Method: This method divide two rectangular numbers
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the rectangular number in a 2x1 array, in the first position is the real part
     * ,and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] rectangularDivision() {
        double num1 = readDouble("Give me the real part of the first number\n");
        double imaginary1 = readDouble("Give me the imaginary part of the first number\n");
        double num2 = readDouble("Give me the real part of the second number\n");
        double imaginary2 = readDouble("Give me the imaginary part of the second number\n");
        double realPart = ((num1 * num2) + (imaginary1 * imaginary2)) / ((num2 * num2) + (imaginary2 * imaginary2));
        double imaginary = ((imaginary1 * num2) - (num1 * imaginary2)) / ((num2 * num2) + (imaginary2 * imaginary2));
        double[] result = {realPart, imaginary};
        return result;
    }

    /*********************************************************************
     *
     * Method name: convertRectangularToPolar
     *
     * Description of the Method: This method ask the user for a rectangular number and then it execute the methods
     * in order to obtain the result in polar
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the rectangular number in a 2x1 array,in the first position is the real part
     * , and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] convertRectangularToPolar() {
        double num1 = readDouble("Give me the real part\n");
        double num2 = readDouble("Give me the imaginary part\n");
        double[] solution = conRecToPolar(num1, num2);
        solution[1] = conAngles(solution[1]);//I transform the angle into the (-360,360) range
        return solution;
    }

    /*********************************************************************
     *
     * Method name: conRectToPolar
     *
     * Description of the Method: This method converts a rectangular number into polar depending of the cartesian
     * coordinates.
     *
     * Calling arguments: This method asks for the real and the imaginary part of the rectangular number
     *
     * Return value: This method returns the polar number in a 2x1 array, in the first position is the length
     * , and in the second angle
     *
     *********************************************************************/
    private static double[] conRecToPolar(double number1, double imaginary) {
        double length;
        length = Math.sqrt(Math.pow(number1, 2) + Math.pow(imaginary, 2));
        double alpha = 0;
        if (number1 >= 0 && imaginary >= 0) {
            alpha = Math.atan(imaginary / number1);
            alpha = (alpha * 180) / Math.PI;
        } else if (number1 >= 0 && imaginary < 0) {
            alpha = Math.atan((-imaginary) / number1);
            alpha = 360 - (alpha * 180) / Math.PI;
        } else if (number1 < 0 && imaginary < 0) {
            alpha = Math.atan(-imaginary / -number1);
            alpha = 180 + (alpha * 180) / Math.PI;

        } else if (number1 < 0 && imaginary >= 0) {
            alpha = Math.atan(-imaginary / number1);
            alpha = 180 - (alpha * 180) / Math.PI;
        }
        double[] array = {length, alpha};
        return array;
    }

    /*********************************************************************
     *
     * Method name: conPolarToRec
     *
     * Description of the Method: This method converts a polar number into a rectangular number
     *
     * Calling arguments: This method asks for the length and the angle of the polar number
     *
     * Return value: This method returns the rectangular number in a 2x1 array, the in the first position is the real part
     * , and in the second the imaginary part
     *
     *********************************************************************/
    private static double[] conPolarToRec(double number, double angle) {
        double realpart = number * Math.cos(angle);
        double imaginary = number * Math.sin(angle);
        double[] array = {realpart, imaginary};
        return array;
    }

    /*********************************************************************
     *
     * Method name: conAngles
     *
     * Description of the Method: This method converts big angles into easier angles to read
     *
     * Calling arguments: This method asks about the angle of the polar number
     *
     * Return value: This method returns the angle simplified
     *
     *********************************************************************/
    private static double conAngles(double angle) {
        while (angle >= 360) {
            angle = angle - 360;
        }
        while (angle <= -360) {
            angle = angle + 360;
        }
        return angle;
    }

    /*********************************************************************
     *
     * Method name: msgReturn
     *
     * Description of the Method: This method shows the user the result of a rectangular number in a proper way
     *
     * Calling arguments: This method asks about the real and the imaginary part of a rectangular number
     *
     * Return value: This method does not have a return value.
     *
     *********************************************************************/
    private static String msgReturn(double real, double imaginary) {
        String msg;
        if (imaginary >= 0) {
            msg = "The solution is: " + real + " + " + imaginary + " i\n";
        } else {
            msg = "The solution is: " + real + " " + imaginary + " i\n";
        }
        return msg;
    }

    /*********************************************************************
     *
     * Method name: factorial
     *
     * Description of the Method: This method does the factorial of an integer, and then it shows the result, or and exception
     * depending on the sign of the number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have a return value
     *
     *********************************************************************/
    private static double factorial() {
        double factorial = 1;

        boolean a = true;
        while (a) {
            int num = readInt("Introduce a number you want to obtain the factorial\n");
            if (num < 0) {
                System.out.println("Invalid option");
            } else {
                for (int i = num; i > 1; i--) {
                    factorial = factorial * i;
                    a = false;
                }

            }
        }
        return factorial;
    }

    /*********************************************************************
     *
     * Method name: power
     *
     * Description of the Method: This method does the power of a number elevated to another.
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double power() {
        double num1 = readDouble("Introduce the base number\n");
        int pow = readInt("Introduce the power number\n");
        double result;
        result = Math.pow(num1, pow);
        return result;
    }

    /*********************************************************************
     *
     * Method name: powerbaseE
     *
     * Description of the Method: This method does the power of the number e elevated to another number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double powerBaseE() {
        int pow = readInt("Introduce a number\n");
        double result = Math.exp(pow);
        return result;
    }

    /*********************************************************************
     *
     * Method name: nthRoot
     *
     * Description of the Method: This method does the nthRoot of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double nthRoot() {
        double num1 = readDouble("Introduce the number\n");
        int power = readInt("Introduce the nth root\n");
        power = 1 / power;
        double result = Math.pow(num1, power);
        return result;
    }

    /*********************************************************************
     *
     * Method name: reciprocal
     *
     * Description of the Method: This method does the nthRoot of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double reciprocal() {
        double num1 = readDouble("Introduce the number\n");
        double result = 0;
        if (num1 == 0) {
            System.out.println("You cannot divide a number by zero");
        } else {
            result = 1 / num1;
        }
        return result;
    }

    /*********************************************************************
     *
     * Method name: naturalLogarithm
     *
     * Description of the Method: This method does the naturalLogarithm of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double naturalLogarithm() {
        double num1 = readDouble("Introduce the number\n");
        double result = Math.log(num1);
        return result;
    }

    /*********************************************************************
     *
     * Method name: decimalLogarithm
     *
     * Description of the Method: This method does the decimal Logarithm of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double decimalLogarithm() {
        double num1 = readDouble("Introduce the number\n");
        double result = Math.log10(num1);
        return result;
    }

    /*********************************************************************
     *
     * Method name: cosine
     *
     * Description of the Method: This method does the cosine of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double cosine() {
        double num1 = readDouble("Give me the angle on degrees\n");
        num1 = num1 * Math.PI / 180;
        double result = Math.cos(num1);
        return result;
    }

    /*********************************************************************
     *
     * Method name: sinus
     *
     * Description of the Method: This method does the sinus of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double sinus() {
        double num1 = readDouble("Give me the angle on degrees\n");
        num1 = num1 * Math.PI / 180;
        double result = Math.sin(num1);
        return result;
    }

    /*********************************************************************
     *
     * Method name: tangent
     *
     * Description of the Method: This method does the tangent of a number
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the result of the operation
     *
     *********************************************************************/
    private static double tangent() {
        double num1 = readDouble("Give me the angle on degrees\n");;
        num1 = num1 * Math.PI / 180;
        double result = Math.tan(num1);
        return result;
    }


    /*********************************************************************
     *
     * Method name: FillArray
     *
     * Description of the Method: This method asks the user for the values of all the positions of an array
     *
     * Calling arguments: This method asks about the number of rows and columns of the array
     *
     * Return value: This method returns the filled array with all the values
     *
     *********************************************************************/
    private static int[][] FillArray(int rows, int columns) {
        int array[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String msg = "Value of the position " + i + " " + j + " is\n";
                int value = readInt(msg);
                array[i][j] = value;
            }
        }
        return array;
    }

    /*********************************************************************
     *
     * Method name: show_array
     *
     * Description of the Method: This method shows an array in a pretty way
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method returns the filled array with all the values
     *
     *********************************************************************/
    private static void show_array(int[][] result_array) {
        System.out.println("The result is: ");
        System.out.println(" ");
        for (int i = 0; i < result_array.length; i++) {
            for (int j = 0; j < result_array[i].length; j++) {
                System.out.print(" " + result_array[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    /*********************************************************************
     *
     * Method name: array_addition
     *
     * Description of the Method: This method add two arrays of the same dimensions and it shows the result with the
     * method show_array
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have return values
     *
     *********************************************************************/
    private static void array_addition() {
        int rows = readInt("Give me the number of rows of both arrays you want to add\n");
        rows=Math.abs(rows);
        int columns = readInt("Give me the number of columns of both arrays you want to add\n");
        columns=Math.abs(columns);
        int[][] array3 = new int[rows][columns];
        int array1[][];
        System.out.println("Choose the values of the first array ");
        array1 = FillArray(rows, columns);
        System.out.println("Now choose the values of the second one ");
        int array2[][];
        array2 = FillArray(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array3[i][j] = array1[i][j] + array2[i][j];
            }
        }
        show_array(array3);
    }

    /*********************************************************************
     *
     * Method name: array_transposition
     *
     * Description of the Method: This method transpose an array and it shows the result with the method show_array
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have return values
     *
     *********************************************************************/
    private static void array_transposition() {
        int rows = readInt("Give me the number of rows of both arrays you want to add\n");
        rows=Math.abs(rows);
        int columns = readInt("Give me the number of columns of both arrays you want to add\n");
        columns=Math.abs(columns);
        int[][] array3 = new int[rows][columns];
        int[][] array1 = FillArray(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array3[j][i] = array1[i][j];
            }
        }
        show_array(array3);
    }

    /*********************************************************************
     *
     * Method name: array_multiplication
     *
     * Description of the Method: This method multiply two arrays depending if the dimensions are correct
     * and it shows the result with the method show_array
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have return values
     *
     *********************************************************************/
    private static void array_multiplication() {
        int rows = readInt("Give me the number of rows of the first array\n");
        rows=Math.abs(rows);
        int columns = readInt("Give me the number of columns of the first\n");
        columns=Math.abs(columns);
        int rows2 = readInt("Give me the number of rows of the second\n");
        rows=Math.abs(rows);
        int columns2 = readInt("Give me the number of columns of the second\n");
        columns=Math.abs(columns);
        int[][] array1;
        int[][] array2;
        if (rows == columns2) {
            int[][] array3 = new int[rows2][columns];

            System.out.println("Introduce the values of the first array");
            array1 = FillArray(rows, columns);

            System.out.println("Now choose the values of array 2");
            array2 = FillArray(rows2, columns2);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns2; j++) {
                    for (int k = 0; k < columns; k++) {
                        array3[i][j] += (array1[i][k] * array2[k][j]);
                    }
                }
            }
            show_array(array3);
        } else System.out.println("Put the same number of rows in the first array as columns in the second one ");
    }

    /*********************************************************************
     *
     * Method name: array_highestadd
     *
     * Description of the Method: This method add all the rows and columns and obtain the values, then compare the highest
     * value of rows addition with the highest value of columns addition, and it shows the highest.
     *
     * Calling arguments: This method does not have calling arguments
     *
     * Return value: This method does not have return values
     *
     *********************************************************************/
    private static void array_highestadd() {
        int rows = readInt("Write the number of rows\n");
        rows=Math.abs(rows);
        int columns = readInt("Write the number of columns\n");
        columns=Math.abs(columns);
        int[][] array1 = FillArray(rows, columns);
        int M = 0;
        int s = 0;
        int column_number = 0;
        int row_number = 0;
        for (int i = 0; i < rows; i++) {
            int n = 0;
            for (int j = 0; j < columns; j++) {
                n = array1[i][j] + n;
            }
            if (M < n) {
                M = n;
                row_number = i;
            }
        }
        for (int j = 0; j < columns; j++) {
            int n = 0;

            for (int i = 0; i < rows; i++) {
                n = array1[i][j] + n;
            }
            if (s < n) {
                s = n;
                column_number = j;
            }
        }
        if (M > s) {
            System.out.println("The highest summation is the row " + row_number + " with value " + M);
        } else if (s > M) {
            System.out.println("The highest summation is the column " + column_number + " with value " + s);
        } else
            System.out.println("The highest summation is in the row " + row_number + " and in the column " + column_number + " With value " + M);
    }
    /*********************************************************************
     *
     * Method name: array_readDouble
     *
     * Description of the Method: This method recognize a double by a pattern and the length of the string that the user´s
     * write.
     * The method allows the user to : write dots, infinite numbers between zero and nine and infinite decimals between zero
     * and nine. (This is the pattern that the method use)
     * If the length of the string is 1, and the string does not contain a dot or a minus, it will pass the string to a double.
     *
     * If the length of the string is 2, and the string does not contain ".-", it will pass the string to a double.
     *
     * If the length is bigger than two it will pass directly the string to a double.
     *
     * If any of this 3 options is true, the method will return the value but:
     *
     * If the string does not have any of these conditions the boolean isOk will be false, and the method will be repeated
     * asking the user another time the value
     *
     *
     * Calling arguments: This method needs the string that we want to show to the user, if we don´t want to show a
     * message to the user, we have to write " "
     *
     * Return value: This method returns the value that the user have written if the number is well written
     *
     *********************************************************************/
    private static double readDouble(String msg) {
        boolean isOk = true;
        double value=0.0;
        String readValue ;
        String decimalPattern = "(-)?([0-9]*)(\\.([0-9]*))?";
        do {
            System.out.print(msg);
            readValue = sc.nextLine();
            boolean match = Pattern.matches(decimalPattern, readValue);
            if (match){
                if(readValue.length()==1 && !readValue.contains(".") && !readValue.contains("-") ){
                    value=Double.parseDouble(readValue);
                    isOk=true;
                }else if(readValue.length()==2 && !readValue.contains("-.")) {
                    value = Double.parseDouble(readValue);
                    isOk = true;
                }else if(readValue.length()>2){
                    value=Double.parseDouble(readValue);
                    isOk=true;
                }else {
                    System.out.println("invalid Input");
                    isOk = false;
                }
            }else{
                System.out.println("invalid Input");
                isOk = false;
            }
        } while (!isOk);
        return value;

    }
    /*********************************************************************
     *
     * Method name: array_readInt
     *
     * Description of the Method: This method recognize if a number is an int
     * The method does not allow the user to : write dots, write letters, write decimals
     *
     * If the string does not have any of these conditions the boolean isOk will be false, and the method will be repeated
     * asking the user another time the value
     *
     *
     * Calling arguments: This method needs the string that we want to show to the user, if we don´t want to show a
     * message to the user, we have to write " "
     *
     * Return value: This method returns the value that the user have written if the number is well written
     *
     *********************************************************************/
    private static int readInt(String msg) {
        boolean b = true;
        int value = 0;
        String readValue;
        String decimalPattern = "(-)?([0-9]*)";
        while (b) {
            System.out.print(msg);
            readValue = sc.nextLine();
            boolean match = Pattern.matches(decimalPattern, readValue);
            if (match) {
                if (readValue.length() >= 2) {
                    value = Integer.parseInt(readValue);
                    b = false;
                } else if (readValue.length() == 1 && !readValue.contains("-")) {
                    value = Integer.parseInt(readValue);
                    b = false;
                } else {
                    System.out.println("invalid Input");
                }
            }else {
                System.out.println("invalid Input");
            }
        }

        return value;
    }
}
