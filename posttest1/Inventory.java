package posttest1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private static ArrayList<Equipment> equipmentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int choice;
        do {
            displayMenu();
            System.out.print("Masukkan Pilihan: ");
            choice = getIntInput();
            performMenuAction(choice);
        } while (choice != 0);

        scanner.close();
    }


    private static void createEquipmentFromInput() {
        System.out.print("Masukkan Nama Equipment: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan Tipe Equipment: ");
        String type = scanner.nextLine();

        System.out.print("Masukkan Attack Equipment: ");
        int attack = getIntInput();

        System.out.print("Masukkan Defense Equipment: ");
        int defense = getIntInput();

        Equipment newEquipment = new Equipment(name, type, attack, defense);
        equipmentList.add(newEquipment);

        System.out.println("Equipment telah dibuat:");
        System.out.println("Nama: " + newEquipment.getName());
        System.out.println("Tipe: " + newEquipment.getType());
        System.out.println("Attack: " + newEquipment.getAttack());
        System.out.println("Defense: " + newEquipment.getDefense());
    }

    private static void updateEquipmentByName() {
        System.out.print("Masukkan nama equipment yang ingin diupdate: ");
        String name = scanner.nextLine();
        Equipment foundEquipment = findEquipmentByName(name);
        if (foundEquipment != null) {
            System.out.print("Masukkan nama baru: ");
            String newName = scanner.nextLine();
            System.out.print("Masukkan tipe baru: ");
            String newType = scanner.nextLine();
            System.out.print("Masukkan attack baru: ");
            int newAttack = getIntInput();
            System.out.print("Masukkan defense baru: ");
            int newDefense = getIntInput();
            foundEquipment.setName(newName);
            foundEquipment.setType(newType);
            foundEquipment.setAttack(newAttack);
            foundEquipment.setDefense(newDefense);
            System.out.println("Equipment berhasil diupdate!");
        } else {
            System.out.println("Equipment tidak ditemukan!");
        }
    }

    private static void deleteEquipmentByName() {
        System.out.print("Masukkan nama equipment untuk dihapus: ");
        String deleteName = scanner.nextLine();
        Equipment foundEquipment = findEquipmentByName(deleteName);
        if (foundEquipment != null) {
            equipmentList.remove(foundEquipment);
            System.out.println("Equipment berhasil dihapus!");
        } else {
            System.out.println("Equipment tidak ditemukan!");
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Equipment");
        System.out.println("2. Lihat Equipment");
        System.out.println("3. Update Equipment");
        System.out.println("4. Hapus Equipment");
        System.out.println("0. Exit");
    }

    private static void performMenuAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Terima kasih!");
                System.exit(0);
                break;
            case 1:
                createEquipmentFromInput();
                break;
            case 2:
            if (equipmentList.isEmpty()) {
                System.out.println("Tidak ada equipment yang tersedia.");
            } else {
                int counter = 1;
                System.out.println("Equipment:");
                for (Equipment equipment : equipmentList) {
                    System.out.println("----------------------------------");
                    System.out.println("Equipment " + counter++);
                    System.out.println("Nama: " + equipment.getName());
                    System.out.println("Tipe: " + equipment.getType());
                    System.out.println("Attack: " + equipment.getAttack());
                    System.out.println("Defense: " + equipment.getDefense());
                    System.out.println("----------------------------------");
                }
            }
                break;
            case 3:
            if (equipmentList.isEmpty()) {
                System.out.println("Tidak ada equipment untuk diupdate.");
            } else {
                updateEquipmentByName();
            }
            break;
            case 4:
            if (equipmentList.isEmpty()) {
                System.out.println("Tidak ada equipment untuk dihapus.");
            } else {
                deleteEquipmentByName();
            }
            break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }

    private static Equipment findEquipmentByName(String name) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equals(name)) {
                return equipment;
            }
        }
        return null;
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan harus berupa bilangan bulat.");
                System.out.print("Coba lagi: ");
            }
        }
    }
}

class Equipment {
    private String name;
    private String type;
    private int attack;
    private int defense;

    public Equipment(String name, String type, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
