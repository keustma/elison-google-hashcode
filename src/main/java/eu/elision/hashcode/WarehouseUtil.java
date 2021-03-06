package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.List;

public class WarehouseUtil {

    public static List<Warehouse> warehouses;

    public static void initWarehouses(int numOfWarehouses) {
        warehouses = new ArrayList<Warehouse>();

        for(int i = 0; i < numOfWarehouses; i++) {
            warehouses.add(i, new Warehouse(i));
        }
    }

    public static Warehouse getWarehouse(int warehouseId) {
        return warehouses.get(warehouseId);
    }

}
