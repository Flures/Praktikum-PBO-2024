package inventory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryManager {
    private static ArrayList<Equipment> equipmentList = new ArrayList<>();
    private BufferedReader reader;

    public InventoryManager(BufferedReader reader) {
        this.reader = reader;
    }

    public void start() throws IOException {
        int choice;
        do {
            displayMenu();
            System.out.print("Masukkan Pilihan: ");
            choice = getIntInput();
            performMenuAction(choice);
        } while (choice != 0);
    }

    public void createEquipmentFromInput() {
        createEquipmentFromInput(null);
    }

    public void createEquipmentFromInput(String defaultType) {
        int typeChoice;
        if (defaultType == null) {
            System.out.println("Pilih Jenis Equipment:");
            System.out.println("1. Weapon");
            System.out.println("2. Shield");
            System.out.println("3. Accessory");
            System.out.print("Masukkan Pilihan: ");
            typeChoice = getIntInput();
        } else {
            switch (defaultType.toLowerCase()) {
                case "weapon":
                    typeChoice = 1;
                    break;
                case "shield":
                    typeChoice = 2;
                    break;
                case "accessory":
                    typeChoice = 3;
                    break;
                default:
                    System.out.println("Pilihan Invalid!");
                    return;
            }
        }

        Equipment newEquipment;
        switch (typeChoice) {
            case 1:
                System.out.print("Masukkan Nama Equipment: ");
                String weaponName = getStringInput();
                System.out.print("Masukkan Attack Equipment: ");
                int weaponAttack = getIntInput();
                System.out.print("Masukkan Defense Equipment: ");
                int weaponDefense = getIntInput();
                System.out.print("Masukkan Tipe Weapon: ");
                String weaponType = getStringInput();
                System.out.print("Masukkan Weapon Skill: ");
                String weaponSkill = getStringInput();
                System.out.print("Masukkan Skill Damage: ");
                int skillDamage = getIntInput();
                System.out.print("Masukkan Elemen Weapon: ");
                String weaponElement = getStringInput();
                System.out.print("Masukkan Critical Rate: ");
                int criticalRate = getIntInput();
                newEquipment = new Weapon(weaponName, weaponAttack, weaponDefense, weaponType, weaponSkill, skillDamage,
                        weaponElement,
                        criticalRate);
                break;
            case 2:
                System.out.print("Masukkan Nama Equipment: ");
                String shieldName = getStringInput();
                System.out.print("Masukkan Attack Equipment: ");
                int shieldAttack = getIntInput();
                System.out.print("Masukkan Defense Equipment: ");
                int shieldDefense = getIntInput();
                System.out.print("Masukkan Damage Reduction: ");
                int damageReduction = getIntInput();
                System.out.print("Masukkan Health Bonus: ");
                int healthBonus = getIntInput();
                newEquipment = new Shield(shieldName, shieldAttack, shieldDefense, damageReduction, healthBonus);
                break;
            case 3:
                System.out.print("Masukkan Nama Equipment: ");
                String accessoryName = getStringInput();
                System.out.print("Masukkan Attack Equipment: ");
                int accessoryAttack = getIntInput();
                System.out.print("Masukkan Defense Equipment: ");
                int accessoryDefense = getIntInput();
                System.out.print("Masukkan Tipe Accessory: ");
                String accessoryType = getStringInput();
                System.out.print("Masukkan Attack Bonus: ");
                int attackBonus = getIntInput();
                System.out.print("Masukkan Healing Bonus: ");
                int healingBonus = getIntInput();
                newEquipment = new Accessory(accessoryName, accessoryAttack, accessoryDefense, accessoryType,
                        attackBonus, healingBonus);
                break;
            default:
                System.out.println("Pilihan Invalid!");
                return;
        }

        equipmentList.add(newEquipment);
        System.out.println("Equipment Berhasil Dibuat:");
    }

    public void updateEquipmentByName() {
        System.out.print("Masukkan Nama Equipment Yang Ingin Diupdate: ");
        String name = getStringInput();
        Equipment foundEquipment = findEquipmentByName(name);
        if (foundEquipment != null) {
            System.out.print("Masukkan Nama Baru: ");
            String newName = getStringInput();
            System.out.print("Masukkan Attack Baru: ");
            int newAttack = getIntInput();
            System.out.print("Masukkan Defense Baru: ");
            int newDefense = getIntInput();
            foundEquipment.setName(newName);
            foundEquipment.setAttack(newAttack);
            foundEquipment.setDefense(newDefense);

            if (foundEquipment instanceof Weapon) {
                Weapon weapon = (Weapon) foundEquipment;
                System.out.print("Masukkan Tipe Weapon Baru: ");
                String newWeaponType = getStringInput();
                System.out.print("Masukkan Skill Weapon Baru: ");
                String newWeaponSkill = getStringInput();
                System.out.print("Masukkan Skill Damage Baru: ");
                int newSkillDamage = getIntInput();
                System.out.print("Masukkan Elemen Weapon Baru: ");
                String newWeaponElement = getStringInput();
                System.out.print("Masukkan Critical Rate Baru: ");
                int newCriticalRate = getIntInput();

                weapon.setWeaponType(newWeaponType);
                weapon.setWeaponSkill(newWeaponSkill);
                weapon.setSkillDamage(newSkillDamage);
                weapon.setWeaponElement(newWeaponElement);
                weapon.setCriticalRate(newCriticalRate);

            } else if (foundEquipment instanceof Shield) {
                Shield shield = (Shield) foundEquipment;
                System.out.print("Masukkan Damage Reduction Baru: ");
                int newDamageReduction = getIntInput();
                System.out.print("Masukkan Health Bonus Baru: ");
                int newHealthBonus = getIntInput();
                shield.setDamageReduction(newDamageReduction);
                shield.setHealthBonus(newHealthBonus);

            } else if (foundEquipment instanceof Accessory) {
                Accessory accessory = (Accessory) foundEquipment;
                System.out.print("Masukkan Tipe Accessory baru: ");
                String newAccessoryType = getStringInput();
                System.out.print("Masukkan Attack Bonus Baru: ");
                int newAttackBonus = getIntInput();
                System.out.print("Masukkan Healing Bonus Baru: ");
                int newHealingBonus = getIntInput();
                accessory.setAccessoryType(newAccessoryType);
                accessory.setAttackBonus(newAttackBonus);
                accessory.setHealingBonus(newHealingBonus);
            }

            System.out.println("Equipment Berhasil Diupdate!");
        } else {
            System.out.println("Equipment tidak ditemukan!");
        }
    }

    public void deleteEquipmentByName() {
        System.out.print("Masukkan Nama Equipment Yang Ingin Dihapus: ");
        String deleteName = getStringInput();
        Equipment foundEquipment = findEquipmentByName(deleteName);
        if (foundEquipment != null) {
            equipmentList.remove(foundEquipment);
            System.out.println("Equipment Berhasil Dihapus!");
        } else {
            System.out.println("Equipment Tidak Ditemukan!");
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Equipment");
        System.out.println("2. Lihat Equipment");
        System.out.println("3. Update Equipment");
        System.out.println("4. Hapus Equipment");
        System.out.println("5. Enhance Equipment");
        System.out.println("0. Exit");
    }

    public void performMenuAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Terima Kasih!");
                System.exit(0);
                break;
            case 1:
                createEquipmentFromInput();
                break;
            case 2:
                if (equipmentList.isEmpty()) {
                    System.out.println("Tidak Ada Equipment Yang Tersedia Untuk Ditampilkan.");
                } else {
                    int counter = 1;
                    System.out.println("Equipment:");
                    for (EquipmentInfoDisplayer equipment : equipmentList) {
                        System.out.println("----------------------------------");
                        System.out.println("Equipment " + counter++ +  " (" + equipment.getEquipmentType() + ")");
                        if (equipment instanceof Weapon) {
                            Weapon weapon = (Weapon) equipment;
                            weapon.displayInfo();
                        } else if (equipment instanceof Shield) {
                            Shield shield = (Shield) equipment;
                            shield.displayInfo();
                        } else if (equipment instanceof Accessory) {
                            Accessory accessory = (Accessory) equipment;
                            accessory.displayInfo();
                        }
                        System.out.println("----------------------------------");
                    }
                }
                break;
            case 3:
                if (equipmentList.isEmpty()) {
                    System.out.println("Tidak Ada Equipment Untuk Diupdate.");
                } else {
                    updateEquipmentByName();
                }
                break;
            case 4:
                if (equipmentList.isEmpty()) {
                    System.out.println("Tidak Ada Equipment Untuk Dihapus.");
                } else {
                    deleteEquipmentByName();
                }
                break;
            case 5:
                if (equipmentList.isEmpty()) {
                    System.out.println("Tidak Ada Equipment Untuk Diupdate.");
                } else {
                    enhanceEquipment();
                }
                break;
            default:
                System.out.println("Pilihan Invalid!");
                break;
        }
    }

    private Equipment findEquipmentByName(String name) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equals(name)) {
                return equipment;
            }
        }
        return null;
    }

    public int getIntInput() {
        while (true) {
            try {
                String input = reader.readLine();
                return Integer.parseInt(input);
            } catch (IOException e) {
                System.out.println("An error occurred while reading input: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa bilangan bulat.");
                System.out.print("Coba lagi: ");
            }
        }
    }

    public String getStringInput() {
        try {
            String input = reader.readLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                System.out.print("Coba lagi: ");
                return getStringInput();
            }
            return input;
        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
            return "";
        }
    }

    public void enhanceEquipment() {
        System.out.print("Masukkan nama equipment yang ingin di enhance: ");
        String name = getStringInput();
        Equipment foundEquipment = findEquipmentByName(name);
        if (foundEquipment != null) {
            System.out.println("Pilih jenis enhancement yang ingin diberikan:");
            System.out.println("1. Critical Enhancement");
            System.out.println("2. Damage Enhancement");
            System.out.print("Masukkan Pilihan: ");
            int choice = getIntInput();
            EquipmentEnhancer enhancer = null;
            switch (choice) {
                case 1:
                    if (foundEquipment instanceof Weapon) {
                        System.out.print("Masukkan Bonus Critical Rate: ");
                        int criticalRateBonus = getIntInput();
                        enhancer = new CriticalEnhancer(foundEquipment, criticalRateBonus);
                    } else {
                        System.out.println("Critical enhancement hanya bisa diberikan kepada Weapon.");
                    }
                    break;
                case 2:
                    if ((foundEquipment instanceof Weapon) || (foundEquipment instanceof Accessory)) {
                        System.out.print("Masukkan Bonus Damage: ");
                        int damageBonus = getIntInput();
                        enhancer = new DamageEnhancer(foundEquipment, damageBonus);
                    } else {
                        System.out.println("Damage enhancement hanya bisa diberikan kepada Weapon dan Accessory.");
                    }
                    break;
                default:
                    System.out.println("Pilihan Invalid!");
                    return;
            }
            if (enhancer != null) {
                enhancer.enhanceEquipment();
            }
        } else {
            System.out.println("Equipment tidak ditemukan!");
        }
    }

}
