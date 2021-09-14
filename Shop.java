public class Shop 
{
    private int bait;
    private Boolean greatRod = false;
    private Boolean advancedRod;
    private Boolean scienceIsAMythRod;
    private Double money;
    
    public boolean purchaseGreatRod(double funds)
    {
       money = funds;
       if(money >= 30)
       {
           money -= 30;
           greatRod = true;
           System.out.println("Congradulations, you now own a Great Rod!\n");
       }
       else
       {
           System.out.println("Sorry you have insufficient funds\n");
           greatRod = false;
       }
       return greatRod;
    }
    
    public boolean purchaseAdvancedRod(double funds)
    {
       money = funds;
       if(money >= 50)
       {
           money -= 50;
           advancedRod = true;
           System.out.println("Congradulations, you now own a Great Rod!\n");
       }
       else
       {
           System.out.println("Sorry you have insufficient funds\n");
           advancedRod = false;
       }
       return advancedRod;
    }
    
    public boolean purchaseScienceIsAMythRod(double funds)
    {
       money = funds;
       if(money >= 100)
       {
           money -= 100;
           scienceIsAMythRod = true;
           System.out.println("Congradulations, you now own the Science Is a Myth Rod!\n You're basically god, you don't need bait anymore, just catch all the crazy stuff! \n *This is basically the end of the progressable game, the rest of the game is just for fun!* \n");
       }
       else
       {
           System.out.println("Sorry you have insufficient funds\n");
           scienceIsAMythRod = false;
       }
       return scienceIsAMythRod;
    }
    
    public Integer purchaseFiveBait(double funds, int currentBait)
    {
        money = funds;
        bait = currentBait;
        if (money >= 5.00)
        {
            money -= 5;
            bait += 5;
        }
        else
        {
            System.out.println("Sorry you have insufficient funds\n");
        }
        return bait;
    }
    
    public double returnMoney()
    {
        return money;
    }
}
