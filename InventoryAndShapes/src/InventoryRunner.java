/**
 * Inventoryrunner is a class which is used to test the inventory item class and show an example of sorting inventory
 * item objects.
 *
 * @author Vishak Srikanth
 * @version 2/23/2021
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class InventoryRunner {
    public static void main(String[] args) {
        int numItems = 10;
        InventoryItem[] arrInventory = new InventoryItem[numItems];
        int idPrefix = 100000;
        String[] names = new String[]{"EarPods2", "iPhone 12", "MacBookPro 2021", "Surface Tablet S3", "Samsung Galaxy S10", "Echo Show", "iPad Pro", "Samsung Galaxy Tab", "Apple iWatch3", "Google Chromecast "};
        for (int i = 0; i < numItems; i++) {
            Random ran = new Random();
            //generate random ids greater than 100000 like in most catalogs
            int id = ran.nextInt(idPrefix) + idPrefix;
            InventoryItem inv = new InventoryItem(names[i], id);
            arrInventory[i] = inv;

        }
        //print unsorted array
        System.out.println("Unsorted Array of " + numItems + " Inventory Items: ");
        for (int i = 0; i < numItems; i++) {
            System.out.println(arrInventory[i].toString());
        }


        // 1. sort using Comparable
        InventoryItem[] sortedArrCompMethod = InventoryItem.sortItems(arrInventory, InventoryItem.USE_COMPARABLE_METHOD);
        System.out.println("Sorted Array of " + numItems + " Inventory Items (by Id field) using Comparable Method: ");
        for (int i = 0; i < numItems; i++) {
            System.out.println(sortedArrCompMethod[i].toString());
        }
//        System.out.println(Arrays.asList(sortedArrCompMethod));

        // 2. sort using Comparator Class: sort by id
        InventoryItem[] sortedArrCompClass = InventoryItem.sortItems(arrInventory, InventoryItem.USE_COMPARATOR_CLASS);
        System.out.println("Sorted Array of " + numItems + " Inventory Items (by Id field) using Comparator Class: ");
        for (int i = 0; i < numItems; i++) {
            System.out.println(sortedArrCompClass[i].toString());
        }
    }
}