import java.util.Random;
import java.util.UUID;

class VirtualPet {

    // Fields
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int stageIndex;
    private boolean isGhost;

    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    static int totalPetsCreated = 0;

    // Main constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = 0; // Start as Egg
        this.isGhost = false;
        totalPetsCreated++;
    }

    // Default constructor - mysterious egg
    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50);
    }

    // Constructor with name only - starts as Baby
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60);
        this.stageIndex = 1; // Baby
    }

    // Constructor with name + species - starts as Child
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70);
        this.stageIndex = 2; // Child
    }

    // Static method to generate unique pet IDs
    private static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    // Random species generator
    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Wolf", "Cat"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    // Methods
    public void evolvePet() {
        if (isGhost) {
            System.out.println(petName + " is a Ghost and cannot evolve.");
            return;
        }
        if (stageIndex < EVOLUTION_STAGES.length - 2) { // Exclude Ghost
            stageIndex++;
            System.out.println(petName + " evolved into " + EVOLUTION_STAGES[stageIndex] + "!");
        } else {
            System.out.println(petName + " is already at the final stage.");
        }
    }

    public void feedPet() {
        if (!isGhost) {
            happiness += 10;
            health += 5;
            System.out.println(petName + " enjoyed the food!");
        } else {
            System.out.println(petName + " is a Ghost and cannot eat.");
        }
    }

    public void playWithPet() {
        if (!isGhost) {
            happiness += 15;
            health -= 5;
            System.out.println(petName + " played happily!");
        } else {
            System.out.println(petName + " is a Ghost and cannot play.");
        }
    }

    public void healPet() {
        if (!isGhost) {
            health += 20;
            System.out.println(petName + " feels better now!");
        } else {
            System.out.println(petName + " is a Ghost and cannot be healed.");
        }
    }

    public void simulateDay() {
        if (isGhost) {
            System.out.println(petName + " haunts other pets today...");
            return;
        }
        age++;
        happiness -= 5;
        health -= 5;

        if (health <= 0) {
            isGhost = true;
            stageIndex = EVOLUTION_STAGES.length - 1; // Ghost
            System.out.println(petName + " has died and become a Ghost!");
        } else {
            System.out.println(petName + " lived another day.");
        }
    }

    public String getPetStatus() {
        return "PetID: " + petId +
               "\nName: " + petName +
               "\nSpecies: " + species +
               "\nAge: " + age +
               "\nHappiness: " + happiness +
               "\nHealth: " + health +
               "\nStage: " + EVOLUTION_STAGES[stageIndex] +
               (isGhost ? " 👻" : "");
    }
}

// Test class
public class VirtualPetSimulator {
    public static void main(String[] args) {
        // Creating pets with different constructors
        VirtualPet pet1 = new VirtualPet(); // mysterious egg
        VirtualPet pet2 = new VirtualPet("Fluffy"); // starts as Baby
        VirtualPet pet3 = new VirtualPet("Draco", "Dragon"); // starts as Child

        // Show initial status
        System.out.println(pet1.getPetStatus());
        System.out.println("-----");
        System.out.println(pet2.getPetStatus());
        System.out.println("-----");
        System.out.println(pet3.getPetStatus());
        System.out.println("=====");

        // Simulate actions
        pet2.feedPet();
        pet2.playWithPet();
        pet2.healPet();
        pet2.simulateDay();
        pet2.evolvePet();

        // Show updated status
        System.out.println("----- Updated Status -----");
        System.out.println(pet2.getPetStatus());
    }
}
