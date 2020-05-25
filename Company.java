import java.util.*;
public class Company {
    // #16 meaningful variable names
    String name;
    Employee owner;
    ArrayList<Employee> employees; // #13 ArrayList in class
    ArrayList<String> storeItems;
    ArrayList<Double> storePrices;
    double balance;
    int yearFounded;
    
    public Company() {
        name = "Google";
        owner = new Employee();
        employees = new ArrayList<Employee>();
        balance = 10000;
        yearFounded = 2019;
        employees.add(new Employee("Steve Jobs", "Developer"));
        employees.add(new Employee("Steve Wozniak", "Marketer"));
    }
    public Company(String name, String ownerName) {
        this.name = name;
        this.owner = new Employee(ownerName, "CEO");
        this.employees = new ArrayList<Employee>();
        this.balance = 10000;
        this.yearFounded = 2019;
    }
    public String toString() {
        String output = name + " | $" + balance;
        output += "\n" + owner;
        for (Employee e: employees) {
            output += "\n" + e;
        }
        return output;
    }
    public Employee getOwner() {
        return owner;
    }
    public int getYearFounded() {
        return yearFounded;
    }
    public double getBalance() {
        return balance;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public ArrayList<Employee> getDevelopers() {
        ArrayList<Employee> devs = new ArrayList<Employee>();
        // #13 ArrayList being traversed/accessed
        // #4 for each loop
        for (Employee e: employees) {
            if (e.occupation.equals("Developer")) {
                devs.add(e);
            }
        }
        return devs;
    }
    public ArrayList<Employee> getMarketers() {
        ArrayList<Employee> marketers = new ArrayList<Employee>();
        for (Employee e: employees) {
            if (e.occupation.equals("Marketer")) {
                marketers.add(e);
            }
        }
        return marketers;
    }
    public int getTotalSkillLevelOfAllEmployees() {
        int totalLevel = owner.skillLevel;
        for (Employee e: employees) {
            totalLevel += e.skillLevel;
        }
        return totalLevel;
    }
    public void increaseBalance(double amount) {
        balance += amount;
    }
    public void decreaseBalance(double amount) {
        balance -= amount;
    }
    
    // #10 3 other methods (to bottom of class)
    public void hireEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }
    // #10 overloaded methods
    public void fireEmployee(Employee firedEmployee) {
        // #4 for loop
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.equals(firedEmployee)) {
                employees.remove(i);
            }
        }
    }
    public void fireEmployee(String firedEmployeeName) {
        // #4 while loop
        int i = 0;
        while (i < employees.size()) {
            Employee e = employees.get(i);
            // #20 - class calls method from another class - e.getName()
            if (e.getName().equals(firedEmployeeName)) {
                employees.remove(i);
            }
            i++;
        }
    }
    // #14 method that returns the minimum value from arraylist
    public Employee leastPaidEmployee() {
        Employee leastPaid = employees.get(0);
        for (Employee e: employees) {
            if (e.hourlyWage < leastPaid.hourlyWage) {
                leastPaid = e;
            }
        }
        return leastPaid;
    }
    
    public void startProject(Project project) {
        // #2 if-then-else statement (no throw error)
        // #1 logical operators (2 or operators used in this if statement)
        if (  ( owner.skillLevel < project.ceoLevelNeeded ) || ( getDevelopers().size() < project.developersNeeded ) || ( getMarketers().size() < project.marketersNeeded ) ) {
            System.out.println("You don't meet the required levels for this project.");
        } else {
            // #15 how successful each department was working on the product launch, directly effects profit
            int developmentRating = (int)(Math.random() * (10 - 1) + 1);
            int marketingRating = (int)(Math.random() * (10 - 1) + 1);
            int ceoRating = (int)(Math.random() * (10 - 1) + 1);
            
            // #15 hours worked for each employee in each department
            int developmentHours = 32;//(int)(Math.random() * (45 - 20) + 20);
            int marketingHours = 32;//(int)(Math.random() * (45 - 20) + 20);
            int ceoHours = 15;//(int)(Math.random() * (20 - 10) + 10);
            
            // #15 amount of money made from product launch
            double launchIncome = developmentRating * marketingRating * ceoRating * getTotalSkillLevelOfAllEmployees() * project.reward * 1.5;
            double launchExpenses = project.startCost;
                   
            // #15 pay ceo for hours worked
            launchExpenses += ceoHours * owner.hourlyWage;
            // #15 level up ceo if they did a good job
            if (ceoRating > 7) {
                owner.levelUp();
            }
            
            for (Employee e: employees) {
                
                if (e.occupation.equals("Developer")) {
                    // pay developers for hours worked
                    launchExpenses += developmentHours * e.hourlyWage;
                   
                    // level up developers if they did a good job
                    // #1 relational operator
                    if (developmentRating > 7) {
                        e.levelUp();
                    }
                }
                
                if (e.occupation.equals("Marketer")) {
                    // pay developers for hours worked
                    launchExpenses += marketingHours * e.hourlyWage;
                    
                    // level up marketers if they did a good job
                    // #2 relational operator
                    if (marketingRating > 7) {
                        e.levelUp();
                    }
                }
    
            }
            balance += launchIncome;
            balance -= launchExpenses;
            
            System.out.println(name + " has launched a new product! Here is the breakdown");
            System.out.println("CEO | " + ceoHours + " hours worked | Quality of work: " + ceoRating + "/10");
            System.out.println("Developers | " + developmentHours + " hours worked each | Quality of work: " + developmentRating + "/10");
            System.out.println("Marketers | " + marketingHours + " hours worked each | Quality of work: " + marketingRating + "/10");
            System.out.println("$" + launchIncome + " in sales | $" + launchExpenses + " in expenses | $" + (launchIncome - launchExpenses) + " in profit");
        }   
    }
}










