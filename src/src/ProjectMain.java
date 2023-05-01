package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class ProjectMain {
    static int floor;
    public static People[] queue = new People[6];

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the prototype of the Securavator. The worlds most intelligent and secure elevator. Click here for instructions how this revolutionary technology operates");
        JOptionPane.showMessageDialog(null, "Welcome to the prototype of the Securavator. The worlds most intelligent and secure elevator. Ready to learn how this revolutionary technology operates?");
        JOptionPane.showMessageDialog(null, "Step 1: Scan your badge by inputting numbers onto the touchpad");
        JOptionPane.showMessageDialog(null, "Step 2: If the system verifies your ID, step forward into the queue");
        JOptionPane.showMessageDialog(null, "Step 3: When prompted by the system, enter the elevator and enjoy your ride!");
        JOptionPane.showMessageDialog(null, "Click here to begin. If at any time there is an emergency, please enter 911 into the keypad to stop the elevator.");

        // create an array and fill it with employee objects
        People[] employees = new People[50];
        // read in all the employees from file
        try {
            File fileObj = new File("C:\\Users\\cbcha\\Downloads\\employees.txt");
            Scanner scanObj = new Scanner(fileObj);
            for (int i = 0; i < 50; i++) {
                if (scanObj.hasNextLine()) {
                    String data = scanObj.nextLine();
                    int idTest;
                    int depTest;
                    String nameTest;

                    String idString = data.substring(0, 3);
                    String depString = data.substring(data.length() - 1, data.length());

                    idTest = Integer.parseInt(idString);
                    depTest = Integer.parseInt(depString);
                    nameTest = data.substring(3, data.length() - 1);

                    People entry = new People(idTest, depTest, nameTest);
                    employees[i] = entry;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file you entered in incorrect, please enter a new file:");
            Scanner keyboard = new Scanner(System.in);
            String newFile = keyboard.nextLine();
            File fileObj = new File(newFile);
            Scanner scanObj = new Scanner(fileObj);
            for (int i = 0; i < 50; i++) {
                if (scanObj.hasNextLine()) {
                    String data = scanObj.nextLine();
                    int idTest;
                    int depTest;
                    String nameTest;

                    String idString = data.substring(0, 3);
                    String depString = data.substring(data.length() - 1, data.length());

                    idTest = Integer.parseInt(idString);
                    depTest = Integer.parseInt(depString);
                    nameTest = data.substring(3, data.length() - 1);

                    People entry = new People(idTest, depTest, nameTest);
                    employees[i] = entry;
                }
            }
        }
        // get which employee is waiting next in the queue and fill up the queue with 6 employees
        Scanner keyboard = new Scanner(System.in);
        int counter = 0;
        while (counter < 6) {
            try {
                System.out.println("Please scan your ID number: ");
                int scan = keyboard.nextInt();
                if(scan == 911){
                    JOptionPane.showMessageDialog(null, "Emergency Button activated and elevator is now stopped. Press okay to continue the ride.");
                }
                for (int i = 0; i < 50; i++) {
                     if (scan == employees[i].getIDnum()) {
                        System.out.println("This VERIFIED employee is going to floor " + employees[i].getFloorNum());
                        floor = employees[i].getFloorNum();
                        // add this employee to the queue
                        queue[counter] = new People(employees[i].getIDnum(), employees[i].getFloorNum(), employees[i].geteName());
                        counter++;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Input error, please input an integer");
                System.out.println("Please scan your ID number: ");
                int scan = keyboard.nextInt();
                for (int i = 0; i < 50; i++) {
                    if (scan == employees[i].getIDnum()) {
                        System.out.println("This VERIFIED employee is going to floor " + employees[i].getFloorNum());
                        floor = employees[i].getFloorNum();
                        // add this employee to the queue
                        queue[counter] = new People(employees[i].getIDnum(), employees[i].getFloorNum(), employees[i].geteName());
                        counter++;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "The queue is now full. ");
        System.out.println("The following employees are authorized to ride the elevator: ");
            System.out.println("One: " + queue[0].geteName());
            System.out.println("Two: " + queue[1].geteName());
            System.out.println("Three: " + queue[2].geteName());
            System.out.println("Four: " + queue[3].geteName());
            System.out.println("Five: " + queue[4].geteName());
            System.out.println("Six: " + queue[5].geteName());
        // now there are 6 employees ready to be brought to their floor
        JOptionPane.showMessageDialog(null, "All approved employees may enter the elevator. ");

        int one = queue[0].getFloorNum();
        int two = queue[1].getFloorNum();
        int three = queue[2].getFloorNum();
        int four = queue[3].getFloorNum();
        int five = queue[4].getFloorNum();
        int six = queue[5].getFloorNum();
        int[] numbers = {one, two, three, four, five, six};
        // sort the floors in ascending order and drop off each employee
        Arrays.sort(numbers);
        for (int i = 0; i < 6; i++) {
            // if two employees are getting off at the same floor, only create one ride dropping off mulitple employees
            if(i<5 && numbers[i] == numbers[i+1]){
                Elevator ride = new Elevator(numbers[i]);
                System.out.println(ride);
                i++;
            }else{
                Elevator ride = new Elevator(numbers[i]);
                System.out.println(ride);
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "The ride has terminated and all employees have been dropped off. Thank you for riding the Securavator ");
            }
        }
    }


}



