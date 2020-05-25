import java.util.*;
public class EmployeeDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playing = true;
        // #12 array in student designed class (initialization)
        // #25 meaningful variable name: availableProjects
        Project[] availableProjects = new Project[3];
        availableProjects[0] = new Project(1000, 1, 1, 1, 5);
        availableProjects[1] = new Project(2000, 1, 1, 1, 7);
        availableProjects[2] = new Project(5000, 2, 1, 1, 11);
        
        // #24 insertion sort availableProjects array by start cost
        int n = availableProjects.length; 
        for (int i = 1; i < n; ++i) { 
            int key = availableProjects[i].startCost; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && availableProjects[j].startCost > key) { 
                availableProjects[j + 1] = availableProjects[j]; 
                j = j - 1; 
            } 
            availableProjects[j + 1] = availableProjects[i];
        } 
        
        
        System.out.println("Hello! Welcome to my Company simulator game.");
        System.out.println("Make projects and products, earn money, and hire employees in your journey to success.");
        System.out.println("You (Mr. CEO) and 2 of your buddies have come up with a great idea that could earn you millions.");
        System.out.println("The three of you have put together $10,000 to fund this venture.");
        
        
        // #17 JScanner being used for input
        System.out.print("What is your name? >> ");
        String playerName = in.nextLine();
        System.out.print("What would you like to name your company? >> ");
        String companyName = in.nextLine();
        System.out.print("What is your first friends name? >> ");
        String friend1Name = in.nextLine();
        System.out.print("What is your seconds friends name? >> ");
        String friend2Name = in.nextLine();
        
        // #11 Class Composition in driver class
        Company userCompany = new Company(companyName, playerName);
        userCompany.hireEmployee(new Employee(friend1Name, "Developer"));
        userCompany.hireEmployee(new Employee(friend2Name, "Marketer"));
        System.out.println("\nUse the help command for a list of what you can do.");
        // #4 do while loop
        do {
            System.out.print("What is " + companyName + "'s next move? >> ");
            String command = in.nextLine().toLowerCase();
            System.out.println();
            if (command.equals("help") || command.equals("h")) {
                System.out.println("Available Commands");
                System.out.println("help - shows all commands (h)");
                System.out.println("quit - quits the game (q)");
                System.out.println("view company - gives information about your company (vc)");
                System.out.println("launch project - starts/completes a project that launches a product, hopefully returning profits. (lp)");
                System.out.println("hire employee - hire more employees (he)");
            } else if (command.equals("view company") || command.equals("vc")) { 
                System.out.println(userCompany);
            } else if (command.equals("launch project") || command.equals("lp")) { 
                
                // #12 array in student designed class (traversed by for loop)
                for (int i = 0; i < availableProjects.length; i++) {
                    System.out.println(i + " | " + availableProjects[i]);
                }
                System.out.print("Enter the # of the project you want to start >> ");
                int projectIndex = in.nextInt();
                if ( projectIndex >= 0 && projectIndex < availableProjects.length ) {
                    // start project
                    userCompany.startProject(availableProjects[projectIndex]);
                    
                    // add new project in its place
                    int newProjectStartCost = 0;
                    
                    // #5 switch statement
                    switch (availableProjects[projectIndex].reward) {
                        case 5:
                            newProjectStartCost = (int)(userCompany.balance * .1);
                            break;
                        case 7:
                            newProjectStartCost = (int)(userCompany.balance * .2);
                            break;
                        case 11:
                            newProjectStartCost = (int)(userCompany.balance * .5);
                            break;
                    }
                    int newProjectCeoLevelNeeded = userCompany.owner.skillLevel;
                    int newProjectDevelopersNeeded = userCompany.getDevelopers().size() + (int)(Math.random() * 2);
                    int newProjectMarketersNeeded = userCompany.getMarketers().size() + (int)(Math.random() * 2);
                    
                    availableProjects[projectIndex] = new Project(newProjectStartCost, newProjectCeoLevelNeeded, newProjectDevelopersNeeded, newProjectMarketersNeeded, availableProjects[projectIndex].reward);
                } else {
                    System.out.println("Invalid project #");
                }
                

            }  else if (command.equals("hire employee") || command.equals("he")) { 

                System.out.print("Enter the new employees name >> ");
                String newEmployeeName = in.nextLine();
                
                System.out.println("0 | Developer");
                System.out.println("1 | Marketer");
                System.out.print("Enter the # of the new employees position >> ");
                int newEmployeePositionNum = in.nextInt();
                if (newEmployeePositionNum == 0 || newEmployeePositionNum == 1) {
                    String newEmployeePosition;
                    if (newEmployeePositionNum == 0) {
                        newEmployeePosition = "Developer";
                    } else {
                        newEmployeePosition = "Marketer";
                    }
                    userCompany.hireEmployee(new Employee(newEmployeeName, newEmployeePosition));
                } else {
                    System.out.println("Invalid position");
                }
                

            } else if (command.equals("q") || command.equals("q")) { 
                playing = false;
                System.out.println("Thanks for playing!");
            } else {
                System.out.println("unknown command. try using the help command.");
            }
            
            System.out.println();
        } while (playing);
    }
}