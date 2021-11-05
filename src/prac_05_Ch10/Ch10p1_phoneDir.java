package prac_05_Ch10;

/* Question : SRewrite the PhoneDirectory class from Subsection 7.4.2 so that it uses a
TreeMap to store directory entries, instead of an array. (Doing this was suggested in
Subsection 10.3.1.) You should also write a short program to test the class. */

import java.util.TreeMap;

public class Ch10p1_phoneDir {
    static TreeMap<String, PhoneEntry> map = new TreeMap<>();
    private static class PhoneEntry {
        String name;
        String phoneNum;
        public PhoneEntry(String name, String phone) { // Creating a constructor
            this.name = name;
            this.phoneNum = phone;
        }
        public String toString() {
            return "name = " + name + ", phone = " + phoneNum;
        }
    }
    public static void main(String[] args) {
        PhoneEntry i1 = new PhoneEntry("aName", "111111");
        PhoneEntry i2 = new PhoneEntry("bName", "222222");
        PhoneEntry i3 = new PhoneEntry("cName", "133311");
        PhoneEntry i4 = new PhoneEntry("dName", "4444");

        //TreeMap<String, PhoneEntry> map = new TreeMap<>();
        map.put(i1.name,i1);
        map.put(i2.name,i2);
        map.put(i3.name,i3);
        map.put(i4.name,i4);

        PhoneEntry find1 = find("bName");
        System.out.println("found " + find1);

        String num1 = getNumber("bName");
        System.out.println("found " + num1);

        find1 = find("bbName");
        System.out.println("found " + find1);

        putNumber("bbName", "3333333333");
        find1 = find("bbName");
        System.out.println("found" + find1);
    }

    public static void putNumber(String name, String number) {
        PhoneEntry item = new PhoneEntry(name, number);
        map.put(item.name,item);
    }

    public static String getNumber(String name) {
        PhoneEntry item = find(name);
        if (item == null) {
            return null;
        }
        return item.phoneNum;
    }

    public static PhoneEntry find (String name) {
        if (map.containsKey(name)) {
            return map.get(name);
    }
        return null; // The name does not exist in the array.
    }
}
