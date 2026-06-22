package academyFee;

import java.io.*; 
import java.util.ArrayList;
import java.util.Scanner;

public class AcademyManagementSystem {

    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "students.txt"; 
    
    
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String course = data[2];
                    int totalFee = Integer.parseInt(data[3]);
                    int paidFee = Integer.parseInt(data[4]);

                    Student st = new Student(id, name, course, totalFee);
                    st.payFee(paidFee); 
                    students.add(st);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.getID() + "," + s.getName() + "," + s.getCourse() + "," + s.getTotalFee() + "," + s.getPaidFee());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

   
    void addStudent() {
        System.out.println("\n--- Enter Student Details ---");
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            for (Student s : students) {
                if (s.getID() == id) {
                    System.out.println("Error: A student with this ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Total Fee: ");
            int totalFee = sc.nextInt();

            Student st = new Student(id, name, course, totalFee);
            students.add(st);

            
            saveToFile();
            System.out.println("Student Added Successfully and Saved to File!");
        } catch (Exception e) {
            System.out.println("Error: Invalid Input! Please try again.");
            sc.nextLine(); 
        }
    }

    
    void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found in the system.");
            return;
        }
        System.out.println("\n--- All Registered Students ---");
        for (Student s : students) {
            s.display();
            System.out.println("--------------------------------");
        }
    }

    
    void searchStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found in the system.");
            return;
        }
        
        System.out.print("\nEnter Student ID to Search: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getID() == id) {
                System.out.println("\nStudent Found:");
                s.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

   
    void payFee() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found in the system.");
            return;
        }

        System.out.print("\nEnter Student ID to Pay Fee: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getID() == id) {
                found = true;
                System.out.print("Enter Amount to Pay: ");
                int amount = sc.nextInt();
                
                s.payFee(amount); 
                
               
                saveToFile();
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }
    void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found in the system.");
            return;
        }

        System.out.print("\nEnter Student ID to Remove: ");
        int id = sc.nextInt();
        boolean removed = false;

       
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == id) {
               
                System.out.println("Success: Student '" + students.get(i).getName() + "' has been removed.");
                students.remove(i);
                removed = true;
                
                
                saveToFile();
                break;
            }
        }

        if (!removed) {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }
}