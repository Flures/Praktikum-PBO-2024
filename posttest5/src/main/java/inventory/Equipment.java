package inventory;

public class Equipment {
    private String name;
    private int attack;
    private int defense;

    public Equipment(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

class Weapon extends Equipment {
    private String weaponType;
    private String weaponSkill;
    private String weaponElement;
    private int criticalRate;
    private int skillDamage;

    public Weapon(String name, int attack, int defense, String weaponType, String weaponSkill, int skillDamage,
            String weaponElement,
            int criticalRate) {
        super(name, attack, defense);
        this.weaponType = weaponType;
        this.weaponSkill = weaponSkill;
        this.skillDamage = skillDamage;
        this.weaponElement = weaponElement;
        this.criticalRate = criticalRate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weapon Type: " + weaponType);
        System.out.println("Weapon Skill: " + weaponSkill);
        System.out.println("Weapon Element: " + weaponElement);
        System.out.println("Critical Rate: " + criticalRate);
        System.out.println("Skill Damage: " + skillDamage);
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(String weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public int getSkillDamage() {
        return skillDamage;
    }

    public void setSkillDamage(int skillDamage) {
        this.skillDamage = skillDamage;
    }

    public String getWeaponElement() {
        return weaponElement;
    }

    public void setWeaponElement(String weaponElement) {
        this.weaponElement = weaponElement;
    }

    public int getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(int criticalRate) {
        this.criticalRate = criticalRate;
    }

}

final class Shield extends Equipment {
    private int damageReduction;
    private int healthBonus;

    public Shield(String name, int attack, int defense, int damageReduction, int healthBonus) {
        super(name, attack, defense);
        this.damageReduction = damageReduction;
        this.healthBonus = healthBonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Damage Reduction: " + damageReduction);
        System.out.println("Health Bonus: " + healthBonus);
    }

    public final int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
}

class Accessory extends Equipment {
    private String accessoryType;
    private int attackBonus;
    private int healingBonus;

    public Accessory(String name, int attack, int defense, String accessoryType, int attackBonus, int healingBonus) {
        super(name, attack, defense);
        this.accessoryType = accessoryType;
        this.attackBonus = attackBonus;
        this.healingBonus = healingBonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Accessory Type: " + accessoryType);
        System.out.println("Attack Bonus: " + attackBonus);
        System.out.println("Healing Bonus: " + healingBonus);
    }

    public String getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getHealingBonus() {
        return healingBonus;
    }

    public void setHealingBonus(int healingBonus) {
        this.healingBonus = healingBonus;
    }
}

abstract class EquipmentEnhancer extends Equipment {
    protected Equipment enhancedEquipment;

    public EquipmentEnhancer(Equipment enhancedEquipment) {
        super(enhancedEquipment.getName(), enhancedEquipment.getAttack(), enhancedEquipment.getDefense());
        this.enhancedEquipment = enhancedEquipment;
    }

    public abstract void enhanceEquipment();
}

class CriticalEnhancer extends EquipmentEnhancer {
    private int criticalRateBonus;

    public CriticalEnhancer(Equipment enhancedEquipment, int criticalRateBonus) {
        super(enhancedEquipment);
        this.criticalRateBonus = criticalRateBonus;
    }

    @Override
    public void enhanceEquipment() {
        if (enhancedEquipment instanceof Weapon) {
            Weapon weapon = (Weapon) enhancedEquipment;
            int newCriticalRate = weapon.getCriticalRate() + criticalRateBonus;
            weapon.setCriticalRate(newCriticalRate);
            System.out.println("Critical rate naik ke: " + newCriticalRate);
        } else {
            System.out.println("Critical enhancement hanya bisa diberikan kepada Weapon.");
        }
    }
}

class DamageEnhancer extends EquipmentEnhancer {
    private int damageBonus;

    public DamageEnhancer(Equipment enhancedEquipment, int damageBonus) {
        super(enhancedEquipment);
        this.damageBonus = damageBonus;
    }

    @Override
    public void enhanceEquipment() {
        if(enhancedEquipment instanceof Weapon || enhancedEquipment instanceof Accessory) {
            int newAttack = enhancedEquipment.getAttack() + damageBonus;
            enhancedEquipment.setAttack(newAttack);
            System.out.println("Attack naik ke: " + newAttack);
        } else {
            System.out.println("Damage enhancement hanya bisa diberikan kepada Weapon dan Accessory.");
        }
    }
}
