public class Project {
    int startCost;
    int ceoLevelNeeded;
    int developersNeeded;
    int marketersNeeded;
    int reward;
    
    public Project() {
        startCost = 1000;
        ceoLevelNeeded = 1;
        developersNeeded = 1;
        marketersNeeded = 1;
        reward = 5;//(int)(Math.random() * (12 - 5) + 5);
    }
    public Project(int startCost, int ceoLevelNeeded, int developersNeeded, int marketersNeeded, int reward) {
        this.startCost = startCost;
        this.ceoLevelNeeded = ceoLevelNeeded;
        this.developersNeeded = developersNeeded;
        this.marketersNeeded = marketersNeeded;
        this.reward = reward;
    }
    public String toString() {
        String output = "Start Cost: $" + startCost + " | CEO Lvl: " + ceoLevelNeeded + " | Developers Needed: " + developersNeeded + " | Marketers Needed: " + marketersNeeded;
        return output;
    }
    public int getStartCost() {
        return startCost;
    }
    public int getCeoLevelNeeded() {
        return ceoLevelNeeded;
    }
    public int getDevelopersNeeded() {
        return developersNeeded;
    }
    public int getMarketersNeeded() {
        return marketersNeeded;
    }
    public double getReward() {
        return reward;
    }
}