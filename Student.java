package academyFee;

public class Student {

    private int id;
    private String name;
    private String course;
    private int totalFee;
    private int paidFee;

    Student(int id, String name, String course, int totalFee) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalFee = totalFee;
        this.paidFee = 0;
    }

    public void payFee(int amount) {
    	    if (amount <= 0) {
    	        System.out.println("Error: Amount must be positive!");
    	        return;
    	    }
    	    if (paidFee + amount > totalFee) {
    	        System.out.println("Error: You cannot pay more than the total fee! Remaining fee: " + getRemainingFee());
    	        return;
    	    }
    	    paidFee += amount;
    	    System.out.println("Success: Rs. " + amount + " has been successfully deposited.");
    	}
   

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public int getPaidFee() {
        return paidFee;
    }

    public int getRemainingFee() {
        return totalFee - paidFee;
    }

    public void display() {

        System.out.println("  Student Details ");
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Course       : " + course);
        System.out.println("Total Fee    : " + totalFee);
        System.out.println("Paid Fee     : " + paidFee);
        System.out.println("Remaining Fee: " + getRemainingFee());
    }
    
   
}