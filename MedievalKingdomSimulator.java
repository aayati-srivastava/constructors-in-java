// Abstract base class
abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    // Constructor
    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    // Abstract method
    public abstract void castMagicSpell();

    // Helper method to show status
    public String getStatus() {
        return structureName + " | Power: " + magicPower + " | Location: " + location + " | Active: " + isActive;
    }
}

// ================= Derived Magical Structures =================

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower(String name, int power, String location, boolean isActive,
                       int spellCapacity, String[] knownSpells) {
        super(name, power, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a wizard spell with power " + magicPower);
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String name, int power, String location, boolean isActive,
                           int defenseRating, boolean hasDrawbridge) {
        super(name, power, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " raises magical defenses with power " + magicPower);
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary(String name, int power, String location, boolean isActive,
                         int bookCount, String ancientLanguage) {
        super(name, power, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " channels knowledge from " + bookCount + " books.");
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair(String name, int power, String location, boolean isActive,
                      String dragonType, int treasureValue) {
        super(name, power, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " summons a " + dragonType + " dragon!");
    }
}

// ================== Magical Interactions ==================

class MagicSystem {

    // Can two structures interact? (with special effects)
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {

        // WizardTower + MysticLibrary → Knowledge boost
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            System.out.println("✨ Knowledge Boost! WizardTower gains extra magic.");
            s1.magicPower += 20;
            System.out.println(s1.structureName + " new power: " + s1.magicPower);
            return true;
        }

        // EnchantedCastle + DragonLair → Dragon guard
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
            System.out.println("🐉 Dragon Guard! EnchantedCastle gains stronger defenses.");
            s1.magicPower += 30;
            System.out.println(s1.structureName + " new power: " + s1.magicPower);
            return true;
        }

        // MysticLibrary + DragonLair → Shared knowledge
        if (s1 instanceof MysticLibrary && s2 instanceof DragonLair) {
            System.out.println("📚 Dragon learns ancient knowledge from the Library!");
            s2.magicPower += 25;
            System.out.println(s2.structureName + " new power: " + s2.magicPower);
            return true;
        }

        // Default: only different structures can interact
        return s1.getClass() != s2.getClass();
    }

    // Perform a magical battle
    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins the magical battle!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " defends successfully!";
        } else {
            return "It's a stalemate between " + attacker.structureName + " and " + defender.structureName;
        }
    }

    // Calculate total kingdom power
    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}

// ================== Kingdom Manager ==================

class KingdomManager {
    public static void categorizeStructures(MagicalStructure[] structures) {
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) {
                System.out.println(s.structureName + " → Magic-Focused");
            } else if (s instanceof EnchantedCastle) {
                System.out.println(s.structureName + " → Defense-Focused");
            } else if (s instanceof MysticLibrary) {
                System.out.println(s.structureName + " → Knowledge-Focused");
            } else if (s instanceof DragonLair) {
                System.out.println(s.structureName + " → Dragon/Offense-Focused");
            }
        }
    }
}

// ================== Main Class ==================

public class MedievalKingdomSimulator {
    public static void main(String[] args) {
        WizardTower tower = new WizardTower("Arcane Spire", 80, "North", true,
                                            5, new String[]{"Fireball", "Teleport"});
        EnchantedCastle castle = new EnchantedCastle("Silver Fortress", 60, "West", true,
                                                     90, true);
        MysticLibrary library = new MysticLibrary("Elder Library", 70, "East", true,
                                                  5000, "Ancient Elvish");
        DragonLair lair = new DragonLair("Cave of Flames", 100, "South", true,
                                         "Fire Dragon", 10000);

        MagicalStructure[] structures = {tower, castle, library, lair};

        // Categorize
        System.out.println("--- Kingdom Structure Types ---");
        KingdomManager.categorizeStructures(structures);

        // Interactions with special effects
        System.out.println("\n--- Interactions with Special Effects ---");
        MagicSystem.canStructuresInteract(tower, library);   // Knowledge Boost
        MagicSystem.canStructuresInteract(castle, lair);     // Dragon Guard
        MagicSystem.canStructuresInteract(library, lair);    // Shared Knowledge

        // Magic battle
        System.out.println("\n--- Magic Battle ---");
        System.out.println(MagicSystem.performMagicBattle(lair, tower));

        // Updated Kingdom power
        System.out.println("\nTotal Kingdom Magic Power: " + MagicSystem.calculateKingdomMagicPower(structures));

        // Show status of all structures
        System.out.println("\n--- Final Structure Status ---");
        for (MagicalStructure s : structures) {
            System.out.println(s.getStatus());
        }
    }
}
