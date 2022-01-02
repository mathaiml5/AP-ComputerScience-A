/**
 * Inventoryitem is a class which is used to create inventory items objects and has methods for inventory item objects.
 *
 * @author Vishak Srikanth
 * @version 3/10/2021
 */
import java.util.Arrays;
import java.util.Comparator;
//InventoryItem implements the comparable interface.
public class InventoryItem implements Comparable{
    private String name;
    private int uniqueItemID;
    //We can either use the comparator class or the comparable method for sorting.
    public static final int USE_COMPARATOR_CLASS = 1;
    public static final int USE_COMPARABLE_METHOD = 2;

    /**
     * Constructor for an object of class Inventory Item
     * @param name
     * @param uniqueItemID
     */
    public InventoryItem(String name, int uniqueItemID) {
        this.name = name;
        this.uniqueItemID = uniqueItemID;
    }

    /**
     * getName(): getter method for name
     * @return name, the name of an inventory item
     */
    public String getName() {
        return name;
    }

    /**
     * setName(): getter method for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getUniqueItemID(): getter method for uniqueItemID
     * @return uniqueItemID, the id for inventory items
     */
    public int getUniqueItemID() {
        return uniqueItemID;
    }
    /**
     * setUniqueItemID(): setter method for uniqueItemID
     * @param uniqueItemID
     */
    public void setUniqueItemID(int uniqueItemID) {
        this.uniqueItemID = uniqueItemID;
    }
    /**
     * toString(): to String method for objects of class inventory item
     * @return a string representation of an inventroy item
     */
    @Override
    public String toString() {
        return "InventoryItem{" +
                "name='" + name + '\'' +
                ", uniqueItemID=" + uniqueItemID +
                '}';
    }

    /**
     * compareTo(Object o):
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        //make the other object into an inventory item and compare its id with the calling object's id
        InventoryItem other = (InventoryItem) (o);
        int comp = -20;
        //if the calling objects id is the lesser of the 2ids return -1
        if(this.getUniqueItemID() <  other.getUniqueItemID()){
            comp = -1;
        }
        //if the calling objects id is the greater of the 2ids return 1
        else if(this.getUniqueItemID() >  other.getUniqueItemID()){
            comp = 1;
        }
        //otherwise return 0
        else {
            comp = 0;
        }

        return comp;
    }

    /**
     * sortItems(InventoryItem[] iarr, int sortMethod): a method for sorting items of class InventoryItem
     * @param iarr
     * @param sortMethod
     * @return sArr, the sorted array of Items
     */
    public static InventoryItem[] sortItems(InventoryItem[] iarr, int sortMethod) {

        InventoryItem[] sArr = iarr.clone();
        if(sortMethod == USE_COMPARABLE_METHOD) {
            // 1. sort using Comparable method defined on InventoryItem class
            Arrays.sort(sArr);
            // System.out.println(Arrays.asList(iarr));
        }
        if(sortMethod == USE_COMPARATOR_CLASS) {
            // 2. sort using Comparator class: sort by uniqueItemID
            Arrays.sort(sArr, new Comparator<InventoryItem>() {
                        @Override
                        public int compare(InventoryItem o1, InventoryItem o2) {
                            return o1.compareTo(o2);
                        }
                    }
            );
        }
        return sArr;
    }
}
