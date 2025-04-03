package Driver;
import java.util.Scanner;

import Vehicle.DieselTruck;
import Vehicle.ElectricTruck;
import Vehicle.ElectricCar;
import Vehicle.GasCar;
import Vehicle.Truck;
import Vehicle.Vehicle;
import Client.Client;
import Client.Lease;

public class Driver {
    private static Vehicle[] lot = new Vehicle[10];
    private static Client[] clients = new Client[5];
    private static Lease[] leases = new Lease[10];
    private static int vehicles = 0, clientsNum = 0, leaseNum = 0;;

    private static Scanner s = new Scanner(System.in);


    public static void main(String[] args) {
        Vehicle[] trucks = new Vehicle[3];
        lot[0] = new ElectricTruck("Ford", "F-650", 2021, "ElectricTruck", 15000, 250);
        lot[1] = new DieselTruck("Volvo", "FH16", 2022, "DieselTruck", 20000, 300);
        lot[2] = new DieselTruck("Mack", "Anthem", 2023, "DieselTruck", 18000, 280);


        int choice = 5;
        while (choice != 4){


        System.out.println("Royal Rentals - Main Menus");
        System.out.println("\t1. Manage Vehicles");
        System.out.println("\t2. Manage Clients");
        System.out.println("\t3. Leasing Operations");
        System.out.println("\t4. Exit");
        System.out.print("Enter your choice: ");

        choice = s.nextInt();
        s.nextLine();

        switch (choice) {
            case 1 -> vehicleMenu();
            case 2 -> clientMenu();
            case 3 -> leaseVehicle();
            case 4 -> System.out.println("Thank you for using Royal Rentals");
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }


        //Vehicle mngmt
    }

       private static void vehicleMenu(){
        int quit = 0;
            System.out.println("----------Vehicle Menu----------\n" +
                                "\t1. Add Vehicle\n" +
                    "\t2. Delete Vehicle\n" +
                    "\t3. Update Vehicle Information\n" +
                    "\t4. List Vehicles by Category\n" +
                    "\t5. Quit\n" +
                    "Enter your choice: ");
            quit = s.nextInt();
            s.nextLine();

            switch (quit){
                case 1:
                    addVehicle();
                    break;
                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    updateVehicle();
                    break;
                case 4:
                    listVehicles();
                    break;
            }


        }

        // Client Menu
    private static void clientMenu() {
        int choice = 6;
        while(choice != 5) {
            System.out.println("Client Management");
            System.out.println("\t1. Add a Client");
            System.out.println("\t2. Edit a Client");
            System.out.println("\t3. Delete a Client");
            System.out.println("\t4. View Clients");
            System.out.println("\t5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1 -> addClient();
                case 2 -> editClient();
                case 3 -> deleteClient();
                case 4 -> viewClients();
                case 5 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice");
            }
        }
    }


    //Lease Vehicle
    private static void leaseVehicle() {
        if (clientsNum == 0 || vehicles == 0) {
            System.out.println("No clients or vehicles available for leasing!");
            return;
        }

        System.out.print("Enter Client ID: ");
        String clientId = s.nextLine();
        Client client = findClientById(clientId);
        if (client == null) {
            System.out.println("Client not found");
            return;
        }

        System.out.print("Enter Vehicle Plate Number: ");
        String plateNumber = s.nextLine();
        Vehicle vehicle = findVehicleByPlate(plateNumber);
        if (vehicle == null || isVehicleLeased(vehicle)) {
            System.out.println("Vehicle not available!");
            return;
        }

        if (leaseNum == leases.length) {
            resizeLeaseArray();
        }

        leases[leaseNum++] = new Lease(client, vehicle);
        System.out.println("Vehicle leased successfully!");
    }
    private static void addClient() {
        if (clientsNum == clients.length) {
            resizeClientArray();
        }

        System.out.print("Enter Client Name: ");
        String name = s.nextLine();


        clients[clientsNum++] = new Client(name);
        System.out.println("Client added");
    }

    private static Client findClientById(String id) {
        for (int i = 0; i < clientsNum; i++) {
            if (clients[i].getId().equalsIgnoreCase(id)) {
                return clients[i];
            }
        }
        return null;
    }

    private static Vehicle findVehicleByPlate(String plate) {
        for (int i = 0; i < vehicles; i++) {
            if (lot[i].getPlateNum().equalsIgnoreCase(plate)) {
                return lot[i];
            }
        }
        return null;
    }

    private static boolean isVehicleLeased(Vehicle vehicle) {
        for (int i = 0; i < leaseNum; i++) {
            if (leases[i].getVehicle().equals(vehicle)) {
                return true;
            }
        }
        return false;
    }

    private static void editClient() {
        System.out.print("Enter Client ID to edit: ");
        String id = s.nextLine();

        for (int i = 0; i < clientsNum; i++) {
            if (clients[i].getId().equalsIgnoreCase(id)) {
                System.out.print("Enter new Name: ");
                clients[i].setName(s.nextLine());
                System.out.println("Client updated successfully!");
                return;
            }
        }
        System.out.println("Client not found!");
    }


    private static void deleteClient() {
        System.out.print("Enter Client ID to delete: ");
        String id = s.nextLine();

        for (int i = 0; i < clientsNum; i++) {
            if (clients[i].getId().equalsIgnoreCase(id)) {
                // Shift elements to remove client
                for (int j = i; j < clientsNum - 1; j++) {
                    clients[j] = clients[j + 1];
                }
                clients[--clientsNum] = null; // Reduce count & clear last entry
                System.out.println("Client deleted");
                return;
            }
        }
        System.out.println("Client not found");
    }


    private static void viewClients() {
        if (clientsNum == 0) {
            System.out.println("No clients found");
            return;
        }
        System.out.println("List of Clients:");
        for (int i = 0; i < clientsNum; i++) {
            System.out.println(clients[i]);
        }
    }


    private static void resizeClientArray() {
        Client[] newClients = new Client[clients.length * 2];
        for (int i = 0; i < clients.length; i++) {
            newClients[i] = clients[i];
        }
        clients = newClients;
        System.out.println("Client database expanded to " + clients.length);
    }


    public static Truck getLargestTruck(Vehicle[] trucks) {
        Truck largestTruck = null;

        for (Vehicle v : trucks) {
            if (v instanceof Truck) {
                Truck truck = (Truck) v;
                if (largestTruck == null || truck.getCapacity() > largestTruck.getCapacity()) {
                    largestTruck = truck;
                }
            }
        }
        return largestTruck;
    }

    public static ElectricTruck[] copyVehicles(ElectricTruck[] electricTrucks){
        ElectricTruck[] copyTruck = new ElectricTruck[electricTrucks.length - 1];

        for(int i = 0; i <= electricTrucks.length - 1; i++){
            copyTruck[i] = electricTrucks[i];
        }
        return copyTruck;
    }

    public static void addVehicle(){
        if (vehicles == lot.length){
            biggerArray();
        }
        System.out.println("Select Vehicle to Add:\n" +
                "\t1. Electric Truck\n" +
                "\t2. Diesel Truck\n" +
                "\t3. Electric Car\n" +
                "\t4. Gas Car\n" +
                "\tEnter choice: ");
        int type = s.nextInt();
        s.nextLine();

        System.out.print("Enter Make: ");
        String make = s.nextLine();
        System.out.print("Enter Model: ");
        String model = s.nextLine();
        System.out.print("Enter Year: ");
        int year = s.nextInt();

        switch (type){
            case 1:
                System.out.print("Enter Max Capacity: ");
                double eCapacity = s.nextDouble();
                System.out.print("Enter Max Autonomy: ");
                double autonomy = s.nextDouble();
                lot[vehicles++] = new ElectricTruck(make, model, year, "ElectricTruck", eCapacity, autonomy);
                break;
            case 2:
                System.out.print("Enter Max Capacity: ");
                double capacity = s.nextDouble();
                System.out.print("Enter Fuel Tank Capacity: ");
                double fuel = s.nextDouble();
                lot[vehicles++] = new DieselTruck(make, model, year, "DieselTruck", capacity, fuel);
                break;
            case 3:
                System.out.print("Enter Max Passengers: ");
                int ePass = s.nextInt();
                System.out.print("Enter Max Autonomy: ");
                double eAutonomy = s.nextDouble();
                lot[vehicles++] = new ElectricCar(make, model, year, "ElectricCar", ePass, eAutonomy);
                break;
            case 4:
                System.out.print("Enter Max Passengers: ");
                int pass = s.nextInt();
                lot[vehicles++] = new GasCar(make, model, year, "GasCar", pass);
                break;
            default:
                System.out.println("Invalid Option");
        }
        System.out.println("Vehicle Added");
    }

    private static void deleteVehicle(){
        System.out.print("Enter Plate Number to Delete: ");
        String plate = s.nextLine();

        for (int i = 0; i <= vehicles - 1; i++){
            if(lot[i].getPlateNum().equalsIgnoreCase(plate)){
                for (int j = i; j < vehicles - 1; j++){
                    lot[j] = lot[j + 1];
                }
                lot[--vehicles] = null;
                System.out.println("Vehicle Deleted");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    private static void updateVehicle(){
        System.out.println("Enter Plate Number to update");
        String plate = s.nextLine();

        for (int i = 0; i <= vehicles - 1; i++){
            if(lot[i].getPlateNum().equalsIgnoreCase(plate)){
                System.out.print("Enter new Make: ");
                lot[i].setMake(s.nextLine());
                System.out.print("Enter new Model: ");
                lot[i].setModel(s.nextLine());
                System.out.print("Enter new Year: ");
                lot[i].setYear(s.nextInt());
                System.out.println("Vehicle Updated");
                return;
            }
        }
        System.out.println("Vehicle Not Found");
    }

    private static void listVehicles(){
        System.out.print("Select Category:\n" +
                "\t1. Electric Trucks\n" +
                "\t2. Diesel Trucks\n" +
                "\t3. Electric Cars\n" +
                "\t4. Gas Cars\n" +
                "Enter Choice: ");

        int choice = s.nextInt();
        s.nextLine();

        System.out.println("Vehicles in this category:");
        for (int i = 0; i < lot.length; i++){
            switch (choice){
                case 1:
                    if (lot[i] instanceof ElectricTruck) {
                        System.out.println(lot[i] + "\n");
                    }
                    break;
                case 2:
                    if (lot[i] instanceof DieselTruck) {
                        System.out.println(lot[i] + "\n");
                    }
                    break;
                case 3:
                    if (lot[i] instanceof ElectricCar) {
                        System.out.println(lot[i] + "\n");
                    }
                    break;
                case 4:
                    if (lot[i] instanceof GasCar) {
                        System.out.println(lot[i] + "\n");
                    }
                    break;
                default:
                    System.out.println("Not a Category");
                    break;
            }
        }
    }
    private static void resizeLeaseArray() {
        Lease[] newLeases = new Lease[leases.length * 2];
        for (int i = 0; i < leases.length; i++) {
            newLeases[i] = leases[i];
        }
        leases = newLeases;
        System.out.println("Lease database expanded to " + leases.length);
    }

    private static void biggerArray(){
        Vehicle[] newLot = new Vehicle[lot.length * 2];

        for(int i = 0; i <= lot.length - 1; i++){
            newLot[i] = lot[i];
        }

        lot = newLot;
    }
}