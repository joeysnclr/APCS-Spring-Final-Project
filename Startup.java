public abstract class Startup extends Company implements Organization {
    // #21 - is-a relationship - exends Company
    // #22 - interface - implements Organization
    boolean hasIPOed;
    
    // #23 - polymorphism
    public String toString() {
        String output = hasIPOed + " | " + name + " | $" + balance;
        output += "\n" + owner;
        for (Employee e: employees) {
            output += "\n" + e;
        }
        return output;
    }
    
    public void donateMoney(double amount) {
        balance -= amount;
    }
    
}