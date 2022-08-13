import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Diver class for Grazioso Salvare Rescue Animal System.
 * Calls menu loop to intake rescue animals. Uses inputStringStream
 * to more accurately maintain input flow.
 * @author patrickstimac_snhu
 * @version 0.3
 * 
 */
public class Driver {
	// arrays for storage of dog/monkey information::DO NOT clear()
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // general array used in intakeNewDog() and intakeNewMonkey().
    // cleared when method ends.
    private static ArrayList<String> intakeArray = new ArrayList<String>();
    // Instance variables (if needed)
    
    public static void main(String[] args) throws InputMismatchException {
    	
    	
    	Scanner inSS = null;
    	Scanner scnr = new Scanner(System.in);
    	int userInput = 0;    	
    	String lineInput = "";
    	
        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
    	boolean quitApplication = false;
        do {
	        try {
			displayMenu();
	        	lineInput = scnr.nextLine();
    			inSS = new Scanner(lineInput);
        		userInput = inSS.nextInt();
        		inSS.close();
        		lineInput = "";
	        	switch(userInput) {
	        	    case 0:
	        	        System.out.println("\tThank you for using Grazioso Salvare's Rescue Animal System!");
	        		    System.out.println("\t\t\t   -APPLICATION ENDING-");
	        		    quitApplication = true;
	        		    break;
	        	    case 1:
	        	        intakeNewDog(scnr);
	        	        break;
	        	    case 2:
	        	        intakeNewMonkey(scnr);
	        	        break;
	        	    case 3:
	        	        reserveAnimal(scnr);
	        	        break;
	        	    case 4:
	        	        printAnimals(userInput);
	        	        break;
	        	    case 5:
	        	        printAnimals(userInput);
	        	        break;
	        	    case 6:
	        	        printAnimals(userInput);
	        	        break;
	        	    default:
	        	        System.out.println("Please enter a valid Command.");
	            }
	        }
	        catch (InputMismatchException except) {
	        	System.out.println("Error: please enter a number.");
	        	scnr.next();
	        }
        } while (!quitApplication); //once set to true, leaves do-while loop
        
        scnr.close(); //inSS closed after each use, scnr closed at end of main()
    }
    
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[0] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {// name, species, tail length, monkey height, body length, gender, age, weight, date acquisition, country acquisition, training status, reserved, country Service
    	Monkey monkey1 = new Monkey("Jane", "Squirrel Monkey", "1.56", "2.01", "1.75", "female", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("George", "Tamarin", "2", "1.8", "2", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", true, "United States");
        Monkey monkey3 = new Monkey("Arla", "Marmoset", "0.78", "0.87", "2", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    // Creates new Dog class object with information
    // prompted from user as strings.
    public static void intakeNewDog(Scanner scanner) {

    	String name = "Unnamed";
    	//information to be acquired
    	intakeArray.add("breed");
    	intakeArray.add("gender");
    	intakeArray.add("age");
    	intakeArray.add("weight");
    	intakeArray.add("acquisition date");
    	intakeArray.add("acquisition country");
    	intakeArray.add("training status");
    	boolean reserved;
    	String inServiceCountry;
    	System.out.println("\t\t\tWelcome to Dog Intake\n");

        System.out.println("What is the dog's name?");
 	System.out.println("Enter [q] at anytime to return the menu.\n");
        name = scanner.nextLine();
        String leaveMethodInput = name;
        while (!leaveMethodInput.equalsIgnoreCase("q")) {
	        if (!name.equalsIgnoreCase("unnamed")) {
	        	for(Dog dog: dogList) {
	            	if(dog.getName().equalsIgnoreCase(name)) {
	            	
	                	System.out.println("\n\nThis dog is already in our system\n\n");
	                	return; //returns to menu
	            	} // should exit method but doesn't
	        	}//end of for loop
	    	}
		System.out.println("\n- Great, let's get intake started for " + name + "-");
	        
		for (int i = 0; i < intakeArray.size(); ++i) {
	        	System.out.println("\tEnter the dog's " + intakeArray.get(i));
	        	leaveMethodInput = scanner.nextLine();
	        	intakeArray.set(i, leaveMethodInput);
	        }
	        
	    	System.out.println("\n\tenter [t] if the dog is reserved; enter [f] otherwise:");
	    	String reservedString = scanner.nextLine();
	    	leaveMethodInput = reservedString;
	    	reserved = (reservedString.charAt(0) == 't') ? true : false;
	    	
	    	System.out.print("\n\tenter the dog's service country ");
	    	System.out.println("(enter \"no country\" if the dog is not reserved):");
	    	inServiceCountry = scanner.nextLine();
	    	leaveMethodInput = inServiceCountry;
	    	
	    	Dog dog = new Dog(name, intakeArray.get(0), intakeArray.get(1), 
	    					  intakeArray.get(2), intakeArray.get(3), intakeArray.get(4), 
	    					  intakeArray.get(5), intakeArray.get(6), reserved, 
	    					  inServiceCountry);
	    	dogList.add(dog);
	    	
	    	leaveMethodInput = "q";
        }
        intakeArray.clear();//clears array for next method call
    }
    


    // Creates Monkey Class object with information
    // prompted from user as strings.
    
    //uses an array to check monkey species that are accepted
    //easy to update acceptedSpeciees array by .add("New Species") 	
    public static void intakeNewMonkey(Scanner scanner) {
     	String name = "unnamed";
     	//information to be acquired
     	intakeArray.add("tail length");
     	intakeArray.add("height");
     	intakeArray.add("body length");
     	intakeArray.add("gender");
    	intakeArray.add("age");
    	intakeArray.add("weight");
    	intakeArray.add("acquisition date");
    	intakeArray.add("acquisition country");
    	intakeArray.add("training status");
    	boolean reserved;
    	String inServiceCountry;
        String species = "none";
  
    	ArrayList<String> acceptedSpecies = new ArrayList<String>();
    	acceptedSpecies.add("Capuchin");
    	acceptedSpecies.add("Guenon");
    	acceptedSpecies.add("Macaque");
    	acceptedSpecies.add("Marmoset");
    	acceptedSpecies.add("Squirrel monkey");
    	acceptedSpecies.add("Tamarin");
    	
    	System.out.println("\t\t\tWelcome to Monkey Intake\n");
        System.out.println("What is the monkey's name?");
	System.out.println("Enter [q] at any time to return to the menu");
        name = scanner.nextLine();
        String leaveMethodInput = name;
        while (!leaveMethodInput.equalsIgnoreCase("q")) {
	        System.out.println("Please enter the monkey's species:");
	        System.out.print("Accepted species are: ");
	        for (String thisSpecies : acceptedSpecies) {
	        	System.out.print(thisSpecies + ", ");
	        }
	        
	        species = scanner.nextLine();
	        leaveMethodInput = species;
	        for (String thisSpecies : acceptedSpecies) {
	        	int acceptedSpeciesComparisonFalse = 0;
	        	if(!species.equalsIgnoreCase(thisSpecies)) {
	        		++acceptedSpeciesComparisonFalse; // counts how many times species entered is not part of acceptedSpecies arrayList
	        		if(acceptedSpeciesComparisonFalse >= acceptedSpecies.size()) { // returns to menu if species entered is not in accepted arrayList
	        			
	        			System.out.println("This species is not accepted currently");
	        			return; //returns to menu
	        		}
	        	}
	        }
	        
	        if (!name.equalsIgnoreCase("unnamed")) {
	        	for(Monkey monkey: monkeyList) {
	        		if(monkey.getName().equalsIgnoreCase(name)) {
	        			
	        			System.out.println("\n\nThis monkey is already in our system\n\n");
	        			return; //returns to menu
	        		} 
	            
	        	}//end of for loop
	    	}
	        
	        System.out.println("\n- Great, let's get intake started for " + name + "-");
	    	System.out.println("Enter [q] at anytime to return the menu.\n");
	    	for (int i = 0; i < intakeArray.size(); ++i) {
	        	System.out.println("\tEnter the monkey's " + intakeArray.get(i));
	        	leaveMethodInput = scanner.nextLine();
	        	intakeArray.set(i, leaveMethodInput);
	        }
	    
	    	System.out.println("\nenter [t] if the monkey is reserved; enter any other character otherwise:");
	    	String reservedString = scanner.nextLine();
	    	reserved = (reservedString.charAt(0) == 't') ? true : false;
	    	leaveMethodInput = reservedString;
	    	
	    	System.out.print("\nenter the monkey's service country ");
	    	System.out.println("(enter \"no country\" if the monkey is not reserved):");
	    	inServiceCountry = scanner.nextLine();
	    	leaveMethodInput = inServiceCountry;
	    	
	    	Monkey monkey = new Monkey(name, species, intakeArray.get(0), intakeArray.get(1), 
	    							   intakeArray.get(2), intakeArray.get(3), intakeArray.get(4),
	    							   intakeArray.get(5), intakeArray.get(6), intakeArray.get(7),
	    							   intakeArray.get(8), reserved, inServiceCountry);
	    	monkeyList.add(monkey);
	    	leaveMethodInput = "q";
	    	
        }
    	//clears arrays for next use of method.
    	acceptedSpecies.clear();
    	intakeArray.clear();
    }
    
    
    // finds the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
    	String animalType = "none";
    	String animalName = "unnamed";
    	String inServiceCountry = "no country";
    	
    	System.out.println("To reserve an animal please enter the animal type:");
    	System.out.println("\taccepted animal types are [Monkey] and [Dog]");
    	animalType = scanner.nextLine();
    	String leaveMethodInput = animalType;
    	while (leaveMethodInput != "q") {
	    	if (animalType.equalsIgnoreCase("monkey")) {
	    		System.out.println("\nPlease enter the monkey's name:");
	    		animalName = scanner.nextLine();
	    		leaveMethodInput = animalName;
	    		
	    		for (int i = 0; i < monkeyList.size(); ++i) {
	    			if (animalName.equalsIgnoreCase(monkeyList.get(i).getName())) {
	    				System.out.println("We found " + animalName + " in our system.");
	    				System.out.println("Please enter the Service Location " + animalName + " will be reserved for:");
	    				
	    				inServiceCountry = scanner.nextLine();
	    				
	    				monkeyList.get(i).setReserved(true);
	    				monkeyList.get(i).setAcquisitionLocation(inServiceCountry);
	
	    				System.out.println("" + animalName + " has been reserved."); 
	    				leaveMethodInput = "q";
	    			}
				else if (monkeyList.get(i).getReserved()) {
					System.out.println("Sorry, " + animalName + " is already reserved");
					leaveMethodInput = "q";				
				}
				else {
					System.out.println("Sorry, we can't find " + animalName);
				}
	    		}
	    	}
	    	else if (animalType.equalsIgnoreCase("dog")) {
	    		System.out.println("\nPlease enter the dog's name:");
	    		animalName = scanner.nextLine();
	    		leaveMethodInput = animalName;
	    		
			for (int i = 0; i < dogList.size(); ++i) {
				if (animalName.equalsIgnoreCase(dogList.get(i).getName()) && !dogList.get(i).getReserved()) {
    					System.out.println("We found " + animalName + " in our system.");
    					System.out.println("Please enter the Service Location " + animalName + " will be reserved for:");
	    				
   					inServiceCountry = scanner.nextLine();
    				
    					dogList.get(i).setReserved(true);
   					dogList.get(i).setAcquisitionLocation(inServiceCountry);
    				
    					System.out.println("" + animalName + " has been reserved."); 
    					leaveMethodInput = "q";
				}
				else if (dogList.get(i).getReserved()) {
					System.out.println("Sorry, " + animalName + " is already reserved");
					leaveMethodInput = "q";				
				}
				else {
					System.out.println("Sorry, we can't find " + animalName);
				}
			}
	    	}
	    	else {
	    		System.out.println("This animal type is not currently a part of our system.");
	    		leaveMethodInput = "q";
	    	}
    	}
    }

    // prints Dogs, Monkeys, or all Available animals
    // uses userInput to set Style, if-else branches 
    // are keyed to menu options.
    public static void printAnimals(int style) {
	   if (style == 4) {
		   System.out.println("Searching system for antimalType: Dog");
		   for(Dog dog : dogList) {
			   System.out.println("\tName: " + dog.getName());
			   System.out.println("\t\t" + "Status: " + dog.getTrainingStatus() + 
					   			  "\n\t\t" + "Acquisition Country: " + dog.getAcquisitionLocation() + 
					   			  "\n\t\t" + "Reserved Status: " + ((dog.getReserved()) ? "Reserved" : "Unreserved"));

		   }
		   System.out.println("\tend of list.");
	   }
	   else if (style == 5) {
		   System.out.println("Searching system for animalType: Monkey");
		   for(Monkey monkey : monkeyList) {
			   System.out.println("\tName: " + monkey.getName());
			   System.out.println("\t\t" + "Status: " + monkey.getTrainingStatus() + 
					   			  "\n\t\t" + "Acquisition Country: " + monkey.getAcquisitionLocation() + 
					   			  "\n\t\t" + "Reserved Status: " + ((monkey.getReserved()) ? "Reserved" : "Unreserved"));
		   }
		   System.out.println("\tend of list.");
	   }
       else if (style == 6) {
    	   ArrayList<RescueAnimal> available = new ArrayList<RescueAnimal>();
           for(Dog dog: dogList) {
           	boolean isReserved = dog.getReserved();
           	if(!isReserved) {
          		available.add(dog);
       		}
	   }
           for(Monkey monkey: monkeyList) {
       		boolean isReserved = monkey.getReserved();
       		if(!isReserved) {
        		available.add(monkey);
           	}
       	}
           	
       	System.out.println("All available animals: ");
      	for(RescueAnimal animal: available) {
           	System.out.println("\tAvailable " + animal.getAnimalType());
           	System.out.println("\t\tName: " + animal.getName());
    		System.out.println("\t\t\t" + "Status: " + animal.getTrainingStatus() + 
    				   		   "\n\t\t\t" + "Acquisition Country: " + animal.getAcquisitionLocation() +
    				   		   "\n\t\t\t" + "Reserved Status: " + ((animal.getReserved()) ? "Reserved" : "Unreserved")); 
	 }
      }
   }
}

