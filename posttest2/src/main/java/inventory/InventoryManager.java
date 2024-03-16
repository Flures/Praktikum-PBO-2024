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
        System.out.print("Masukkan Nama Equipment: ");
        String name = getStringInput();

        System.out.print("Masukkan Tipe Equipment: ");
        String type = getStringInput();

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

    public void updateEquipmentByName() {
        System.out.print("Masukkan nama equipment yang ingin diupdate: ");
        String name = getStringInput();
        Equipment foundEquipment = findEquipmentByName(name);
        if (foundEquipment != null) {
            System.out.print("Masukkan nama baru: ");
            String newName = getStringInput();
            System.out.print("Masukkan tipe baru: ");
            String newType = getStringInput();
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

    public void deleteEquipmentByName() {
        System.out.print("Masukkan nama equipment untuk dihapus: ");
        String deleteName = getStringInput();
        Equipment foundEquipment = findEquipmentByName(deleteName);
        if (foundEquipment != null) {
            equipmentList.remove(foundEquipment);
            System.out.println("Equipment berhasil dihapus!");
        } else {
            System.out.println("Equipment tidak ditemukan!");
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Equipment");
        System.out.println("2. Lihat Equipment");
        System.out.println("3. Update Equipment");
        System.out.println("4. Hapus Equipment");
        System.out.println("0. Exit");
    }

    public void performMenuAction(int choice) {
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
                    System.out.println("Tidak ada equipment yang tersedia untuk ditampilkan.");
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
}