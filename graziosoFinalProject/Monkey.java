/**Monkey class Grazioso Salvare Rescue Animal System.
 * following the format of Dog.java and RescueAnimal.java
 * @author patrickstimac_snhu
 *
 */
public class Monkey extends RescueAnimal {
	
	//instance variables
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;

	//constructor method
	public Monkey(String name, String species, String tailLength, 
	String monkeyHeight,  String bodyLength, String gender, String age, 
	String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setAnimalType("Monkey");
        setSpecies(species);
        setTailLength(tailLength);
        setHeight(monkeyHeight);
        setBodyLength(bodyLength);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
	}
	
	//Mutator methods
	public void setTailLength(String tlength) {
		this.tailLength = tlength;
	}
	public void setHeight(String monkeyHeight) {
		this.height = monkeyHeight;
	}
	public void setBodyLength(String bLength) {
		this.bodyLength = bLength;
	}
	public void setSpecies(String monkeySpecies) {
		this.species = monkeySpecies;
	}
	
	//Accessor methods
	public String getTailLength() {
		return tailLength;
	}
	public String getHeight() {
		return height;
	}
	public String getBodyLength() {
		return bodyLength;
	}
	public String getSpecies() {
		return species;
	}
	
}
