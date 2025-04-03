package Client;

import Vehicle.Vehicle;

public class Lease {

        private Client client;
        private Vehicle vehicle;

        // Constructor
        public Lease(Client client, Vehicle vehicle) {
            this.client = client;
            this.vehicle = vehicle;
        }

        // Getters
        public Client getClient() { return client; }
        public Vehicle getVehicle() { return vehicle; }

        //toString
        public String toString() {
            return "Lease: " + client.getName() + " (ID: " + client.getId() + ") -> " + vehicle.getPlateNum();
        }
    }

