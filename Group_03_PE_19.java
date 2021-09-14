import java.io.IOException;
import java.util.Scanner;
public class Group_03_PE_19 
{

    public static void main(String[] args) throws IOException
    {
     //Declaring game values and variables
        String name;
        Boolean greatRod = false;
        Boolean advancedRod = false;
        Boolean scienceIsAMythRod = false;
        Double money = 0.0;
        Integer dailyFishCaught = 0;
        Integer totalFishCaught = 0;
        Integer bait = 5;
        String generalLoop;
        Integer choice;
        Integer shopChoice;
        Integer day = 1;
        Integer index;
        Integer caught;
        String rank = "Basically a bum";
        Boolean newGame = true;
        Die diceBasic = new Die(65);
        Die dice = new Die(100);
        
        // setting array for saving variables and setting variable names
        String[] variableName = new String[11];
        variableName[0] = "name";
        variableName[1] = "greatRod";
        variableName[2] = "advancedRod";
        variableName[3] = "scienceIsAMythRod";
        variableName[4] = "money";
        variableName[5] = "dailyFishCaught";
        variableName[6] = "totalFishCaught";
        variableName[7] = "bait";
        variableName[8] = "day";
        variableName[9] = "rank";
        variableName[10] = "newGame";
        
        //Setting original variables to save in case of new game
        String[] variableData = new String[11];
        variableData[1] = greatRod.toString();
        variableData[2] = advancedRod.toString();
        variableData[3] = scienceIsAMythRod.toString();
        variableData[4] = money.toString();
        variableData[5] = dailyFishCaught.toString();
        variableData[6] = totalFishCaught.toString();
        variableData[7] = bait.toString();
        variableData[8] = day.toString();
        variableData[9] = rank;
        variableData[10] = newGame.toString();
        
        saveGame save = new saveGame();
        //loading variables
        save.loadVariable(variableData);
        //setting variables from loaded data if available
        name = variableData[0];
        greatRod = Boolean.parseBoolean(variableData[1]);
        advancedRod = Boolean.parseBoolean(variableData[2]);
        scienceIsAMythRod = Boolean.parseBoolean(variableData[3]);
        money = Double.parseDouble(variableData[4]);
        dailyFishCaught = Integer.parseInt(variableData[5]);
        totalFishCaught = Integer.parseInt(variableData[6]);
        bait = Integer.parseInt(variableData[7]);
        day = Integer.parseInt(variableData[8]);
        rank = variableData[9];
        newGame = Boolean.parseBoolean(variableData[10]);
        
        // Creating objects for the catch algorithm and shop menu along with a default scanner
        Caught caughtConversion = new Caught();
        Scanner kb = new Scanner(System.in);
        Shop store = new Shop();
        
        // Checks if this is a new game, if true it runs the intro prompt to get name and saves variables.
        if (newGame != false) {
        	System.out.println("Hey there partner, my names Jonathan. You must be the new fisherman Joe told me about. What's your name?");
            
            do
            {
                System.out.print("My name is: ");
                name = kb.nextLine();
                do
                {
                    System.out.print("Your name is " + name + ", is this correct? (yes or no):");
                    generalLoop = kb.nextLine();
                }
                while(generalLoop.compareToIgnoreCase("yes") != 0 && generalLoop.compareToIgnoreCase("no") != 0);
            }

            while(generalLoop.compareTo("yes") != 0);
            clearScreen();
            System.out.println("\n");
            System.out.println("Nice to meet you " + name + ", this lifestyle is very straight forward. (Everything is menu based for this game). \n");
            System.out.println("You start of with a basic rod, this rod is as simple as it gets, basically a wooden pole with a reel. \nCant expect much from this old guy but it'll get you started. You can catch fish up to three pounds with the basic rod. \nTo catch bigger fish you'll have to purchase a great rod from the store. I'll start you off with 5 bait on the house. \nAlright, thats the basics, I'll set you free to be on your way. Oh and by the way you can only use 7 bait per day before it gets too dark to continue fishing. \n");
            
            //Sets players name after obtaining through prompts
            variableData[0] = name;
            
            
        }
        
        //Start new Day
        do
        {
            do
            {
                //saves game at the beginning of day
                save.saveVariable(variableName, variableData);
                
                System.out.println("Day " + day + " \n");
                dailyFishCaught = 0;
                System.out.printf("You currently have $ %.2f", money);
                
                // sets bait to 100 every day when the rod is attained
                if (scienceIsAMythRod == true)
                {
                    bait = 100;
                    System.out.println("Science is a Myth, you don't need bait, you're basically god.");
                }
                else
                {
                    System.out.println(" and " + bait + " bait.");
                }
                
               // Displays the default menu
                menu();
                choice = Integer.parseInt(kb.nextLine());
                System.out.println();
                
                // basic choice error checking
                if (choice < 1 || choice > 3)
                {
                    System.out.println("Invalid selection, please make a valid selection.");
                }
            }
            while((choice < 1 || choice > 3));
            
            // if player chooses shop, shop opens passing variables
            if (choice == 2) 
            {
            	clearScreen();
                do
                {
                    do
                    {
                        shopMenu(money, bait, greatRod, advancedRod, scienceIsAMythRod);
                        shopChoice = Integer.parseInt(kb.nextLine());
                        System.out.println();
                        if (shopChoice < 1 || shopChoice > 3)
                        {
                            System.out.println("Invalid selection, please make a valid selection.");
                        }
                    }
                    while((shopChoice < 1 || shopChoice > 3));

                    if (shopChoice == 1 && greatRod == false)
                    {
                        greatRod = store.purchaseGreatRod(money);
                        money = store.returnMoney();
                    }
                    else if (shopChoice == 1 && greatRod == true && advancedRod == false)
                    {
                        greatRod = store.purchaseAdvancedRod(money);
                        money = store.returnMoney();
                    }
                    else if (shopChoice == 1 && greatRod == true && advancedRod == true && scienceIsAMythRod == false)
                    {
                        greatRod = store.purchaseScienceIsAMythRod(money);
                        money = store.returnMoney();
                    }
                    
                    if (shopChoice == 2)
                    {
                        bait = store.purchaseFiveBait(money, bait);
                        money = store.returnMoney();
                    }
                }
                while(shopChoice != 3);
            }
            if(choice == 1 && bait <= 0)
            {
                System.out.println("You don't have any bait, go to the store and buy some!");
            }
            if (choice == 1 && bait > 0)
            {
                do
                {
                    System.out.println("How much bait would you like to use today? You may use up to 7.)");
                    index = Integer.parseInt(kb.nextLine());
                    if (index < 1 || index > 7)
                    {
                        System.out.println("Please input a number between and including 1-5")   ;                 
                    }
                    if (bait - index < 0) 
                    {
                        System.out.println("You don't have that much bait, please enter a valid ammount of bait.");
                    }
                        
                }
                while (index < 1 || index > 7 || bait - index < 0);
                
                bait -= index;
                if (greatRod == true)
                {
                    for(int i = 0; i < index; i ++)
                    {
                    	clearScreen();
                        dice.roll();
                        caught = dice.getValue();
                        money = caughtConversion.convert(money, caught);
                        dailyFishCaught += 1;
                        totalFishCaught += 1;
                        System.out.println("You have " + (index - 1 - i) + " bait left today");
                        System.out.println("Press enter to recast line!");
                        kb.nextLine();
                    } 
                    System.out.println("You've caught " + dailyFishCaught + " fish today, however you've run out of bait, better go home and get some rest. \n That was a great nights sleep. Back at the grind today! \n");
                }
                else if (greatRod == false)
                {
                    for(int i = 0; i < index; i ++)
                    {
                    	clearScreen();
                        diceBasic.roll();
                        caught = diceBasic.getValue();
                        money = caughtConversion.convert(money, caught);
                        dailyFishCaught += 1;
                        totalFishCaught += 1;
                        System.out.println("You have " + (index - 1 - i) + " bait left today");
                        System.out.println("Press enter to recast line!");
                        kb.nextLine();
                    } 
                    System.out.println("You've caught " + dailyFishCaught + " fish today, however you've run out of bait, better go home and get some rest. \nThat was a great nights sleep. Back at the grind today! \nPress enter to proceed.");
                    kb.nextLine();
                    clearScreen();
                }

            }
            if(choice == 3) {
            	System.out.println("Are you sure you'd like to leave? If you'd like to keep playing you can chose an option from the menu again\nor you can hit 3 again to quit.");
            	menu();
            	choice = kb.nextInt();
            }
            if (totalFishCaught >= 10 && totalFishCaught < 10 )
            {
                rank = "Pretty Great Fisherman";
            }
            if (totalFishCaught >= 25)
            {
                rank = "Super Expert Fisherman";
            }
            day += 1;
        }
        while (choice != 3);
        clearScreen();
        System.out.println("Here's some stats for you!");
        System.out.println("Rank attained: " + rank);
        System.out.println("Total fish caught:" + totalFishCaught);
        System.out.println("Money left over:" + money);
        System.out.println("Bait left over:" + bait);
        System.out.println("Thanks for playing our beta game!, Come back soon!");
        kb.close();
    }
    public static void clearScreen() {  
    	for(int i = 0; i < 25; i++) {
    		System.out.println();
    	}
    }  
    
    public static void menu()
    {
        System.out.println("What would you like to do? \n 1. Start fishing \n 2. Visit the shop \n 3. Retire and end the game.");
    }
    
    public static void shopMenu(double money, int bait, boolean greatRod, boolean advancedRod, boolean scienceIsAMythRod)
    {
        if (greatRod == false)
        {
            System.out.printf("You currently have $ %.2f", money);
            System.out.println(" and " + bait + " bait.");
            System.out.println("What would you like to purchase? \n 1. Great Rod upgrade  for $30 ( allows for capture of fish valued at $4-$20) \n 2. Five bait for $5 \n 3. Exit store");
            
        }
        if (greatRod == true && advancedRod == false)
        {
            System.out.printf("You currently have $ %.2f", money);
            System.out.println(" and " + bait + " bait.");
            System.out.println("What would you like to purchase? \n 1. Advaned Rod upgrade  for $40 (Disregaurds lower value vish and only captures fish valued at $3-20) \n 2. Five bait for $5 \n 3. Exit store");
        }
        if (greatRod == true && advancedRod == true && scienceIsAMythRod == true)
        {
            System.out.printf("You currently have $ %.2f", money);
            System.out.println(" and " + bait + " bait.");
            System.out.println("What would you like to purchase? \n 1. Science Is a Myth Rod upgrade  for $100 (Whats Science, Probability is just a suggestion, You're basically a god, I bet you can even reel in a whale!) \n 2. Five bait for $5 \n 3. Exit store");
        }
    }
}
