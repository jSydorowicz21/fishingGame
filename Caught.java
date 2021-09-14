
public class Caught 
{
    private double money;
    
    public double convert(double income, int fish)
    {
        money = income;
        
        if(fish >= 1 && fish <= 25)
        {
            System.out.println("You caught a rock worth $1");
            money += 1;
        }
        else if(fish >= 26 && fish <= 45)
        {
            System.out.println("You caught a holey boot worth $2");
            money += 2;
        }
        else if(fish >= 46 && fish <= 65)
        {
            System.out.println("You caught a goldfish worth $3");
            money += 3;
        }
        else if(fish >= 66 && fish <= 75)
        {
            System.out.println("You caught a carp worth $4");
            money += 4;
        }
        else if(fish >= 76 && fish <= 85)
        {
            System.out.println("You caught a trout worth $5");
            money += 5;
        }
        else if(fish >= 86 && fish <= 95)
        {
            System.out.println("You caught a tuna worth $6");
            money += 6;
        }
        else if(fish >= 96 && fish <= 100)
        {
            System.out.println("You caught a golden nugget worth $20!");
            money += 20;
        }
        return money;
    }
}
