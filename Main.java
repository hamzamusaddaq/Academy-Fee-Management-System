package academyFee;

public class Main {
    public static void main(String[] args) {
        AcademyManagementSystem obj = new AcademyManagementSystem();
        obj.loadFromFile(); 
        
        while (true) {
            System.out.println("\n===== ACADEMY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Pay Fee"); 
            System.out.println("6. Exit");           
            System.out.print("Enter your choice (1-6): "); 
            
            try {
                int choice = obj.sc.nextInt();
                
                switch (choice) {
                    case 1:
                        obj.addStudent();
                        break;
                    case 2:
                        obj.viewStudents();
                        break;
                    case 3:
                        obj.searchStudent();
                        break;
                    case 4: 
                    obj.removeStudent(); 
                        break;
                    case 5:
                    	obj.payFee(); 
                        break;
                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        obj.sc.close(); 
                        System.exit(0); 
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please enter a valid number.");
                obj.sc.nextLine(); 
            }
        }
    }
}