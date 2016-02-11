package eu.elision.hashcode;

import java.io.File;
import java.util.Scanner;

public class DatasetUtil {

    private static int maximumDroneWeight;
    private static int totalAmountProducts;

    public static void readFile() {
        File file = new File("busy_day.in");

        try {

            Scanner scanner = new Scanner(file);

            String[] simulationConfiguration = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(simulationConfiguration[0]);
            int columns = Integer.parseInt(simulationConfiguration[1]);
            int drones = Integer.parseInt(simulationConfiguration[2]);
            int deadline = Integer.parseInt(simulationConfiguration[3]);
            int maxWeightDrone = Integer.parseInt(simulationConfiguration[4]);
            int differentProductsInWarehouses = Integer.parseInt(scanner.nextLine());

            DroneCommander.initDrones(drones, deadline, maxWeightDrone);

            String[] items = scanner.nextLine().split(" ");
            int[] productWeights = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                    productWeights[i] = Integer.parseInt(items[i]);
            }
            int wareHouses = Integer.parseInt(scanner.nextLine());

            WarehouseUtil.initWarehouses(wareHouses);

            int[][] wareHouseCoordinates = new int[wareHouses][];
            int[][] productsInWareHouses = new int[wareHouses][];
            for(int i = 0; i < wareHouses; i++) {
                String[] coords = scanner.nextLine().split(" ");
                int[] coordinates = new int[] {Integer.parseInt(coords[0]), Integer.parseInt(coords[1])};

                WarehouseUtil.getWarehouse(i).setLocation(coordinates[0], coordinates[1]);

                wareHouseCoordinates[i] = coordinates;
                String[] amntOfProducts = scanner.nextLine().split(" ");
                int[] amountOfProductsPerType = new int[amntOfProducts.length];
                for(int product = 0; product < amntOfProducts.length; product++) {
                    amountOfProductsPerType[product] = Integer.parseInt(amntOfProducts[product]);

                    WarehouseUtil.getWarehouse(i).addProducts(product, Integer.parseInt(amntOfProducts[product]));
                }
                productsInWareHouses[i] = amountOfProductsPerType;

            }


            int orders = Integer.parseInt(scanner.nextLine());
            int [][] deliveryCoordinates = new int[orders][];
            int [] amountOfProductsForDelivery = new int[orders];
            int [][] productTypesForDelivery = new int[orders][];
            for(int i = 0; i < orders; i++) {
                String[] coords = scanner.nextLine().split(" ");
                int[] deliveryCoords = new int[] {Integer.parseInt(coords[0]), Integer.parseInt(coords[1])};
                deliveryCoordinates[i] = deliveryCoords;
                amountOfProductsForDelivery[i] = Integer.parseInt(scanner.nextLine());
                String[] prodTypes = scanner.nextLine().split(" ");
                int[] productTypes = new int[prodTypes.length];
                for(int differentProdTypes = 0; differentProdTypes < prodTypes.length; differentProdTypes++) {
                    productTypes[differentProdTypes] = Integer.parseInt(prodTypes[differentProdTypes]);
                }
                productTypesForDelivery[i] = productTypes;

            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getTotalAmountProducts() {
        return totalAmountProducts;
    }

    public static int getMaximumDroneWeight() {
        return maximumDroneWeight;
    }
}
