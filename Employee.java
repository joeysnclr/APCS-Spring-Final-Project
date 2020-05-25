public class Employee {
    // #9 instance variables
    String name;
    String occupation;
    double hourlyWage; // #3 double primitive data type
    int skillLevel; // #3 int primitive data type
    int hoursWorked;
    boolean isHired; // #3 boolean primitive data type
    
    // #9 zero arg constructor
    public Employee() {
        name = "Sundar Pichai";
        occupation = "CEO";
        hourlyWage = 50;
        // #6 Math.pow() call
        skillLevel = (int)(Math.pow(1.7, 2));
        hoursWorked = 0;
        isHired = true;
    }
    // #9 multi arg constructor
    public Employee(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
        // #2 if-then-else statement with throw error
        if (occupation.equals("Developer")) { // #7 String method equals()
            // #6 Math.random() call
            this.hourlyWage = (int)(Math.random() * (45 - 35) + 35); // #8 casting double to int
        } else if (occupation.equals("Marketer")) {
            this.hourlyWage = (int)(Math.random() * (30 - 22.5) + 22.5);
        } else if (occupation.equals("CEO")) {
            this.hourlyWage = 50;
        } else {
            throw new IllegalArgumentException("Invalid occpuation for employee");
        }
        this.skillLevel = 1;
        this.hoursWorked = 0;
        isHired = true;
    }
    // #9 toString method
    public String toString() {
        String output = name + " | " + occupation + " | " + hourlyWage + "/hr | Lvl: " + skillLevel;
        return output;
    }
    // #9 getter methods
    public String getName() {
        return name;
    }
    // #10 getter method
    public String getFirstName() {
        // #7 String method substing
        // #7 String method indexof
        String firstName = name.substring(0, name.indexOf(" "));
        return firstName;
    }
    public String getLastName() {
        String lastName = name.substring(name.indexOf(" ") + 1);
        return lastName;
    }
    public String getOccupation() {
        return occupation;
    }
    public double getHourlyWage() {
        return hourlyWage;
    }
    public int getSkillLevel() {
        return skillLevel;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    // #9 setter methods
    // #10 setter method
    public void setOccupation(String newOccpuation) {
        occupation = newOccpuation;
    }
    public void increaseHourlyWage(double amount) {
        hourlyWage += amount;
    }
    public void increaseHoursWork(int amount) {
        hoursWorked += amount;
    }
    // #9 processor methods
    public void levelUp() {
        // #1 relational operator
        if (skillLevel < 10) {
            // increase skillLevel
            skillLevel += 1;
            // increase hourlyWage
            hourlyWage += (int)(Math.random() * (3 - 1) + 1);
        }
    }
    
}