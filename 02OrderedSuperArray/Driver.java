public class Driver {
    // This is purely for test case usage only.
    public static void addLoop(SuperArray arr, String[] itemsAdded) {
        for (int x = 0; x < itemsAdded.length; x++) {
            arr.add(itemsAdded[x]);
            System.out.println("" + arr.size() + ": " + arr);
        }
    }
    public static void main(String[] args) {
        System.out.println("cat".compareTo("rabbit"));
        String[] strSetA  = {"cat", "rat", "Dog", "cats", "Eels", "lion", "dog" };
        OrderedSuperArray A = new OrderedSuperArray();
        OrderedSuperArray B = new OrderedSuperArray(strSetA);
        System.out.println(B); // [Dog, Eels, cat, cats, dog, lion, rat]
        System.out.println(A); // empty
        A.add("rabbit"); 
        System.out.println(A); // [rabbit]
        addLoop(A, strSetA); 
        System.out.println(A); // [Dog, Eels, cat, cats, dog, lion, rabbit, rat]
        for (int x = 0; x < 6; x++) {
            A.add("panda");
        }

        System.out.println(A); // [Dog, Eels, cat, cats, dog, lion, panda, panda, panda, panda, panda, panda, rabbit, rat] (6 panda)
        
        System.out.println(A.indexOf("panda")); // 6
        System.out.println(A.indexOf("lion")); // 5
        System.out.println(A.indexOf("cats")); // 3
        System.out.println(A.indexOf("dog")); // 4
        System.out.println(A.indexOf("Dog")); // 0
        
        for (int x = 0; x < 3; x++) {
            A.add(strSetA[x]);
        }
        System.out.println(A); //[Dog, Dog, Eels, cat, cats, cats, dog, lion, panda, panda, panda, panda, panda, panda, rabbit, rat, rat] (6 panda)
        System.out.println(A.lastIndexOf("panda")); // 13
        System.out.println(A.lastIndexOf("lion")); // 7
        System.out.println(A.lastIndexOf("cats")); // 5
        System.out.println(A.lastIndexOf("dog")); // 6
        System.out.println(A.lastIndexOf("Dog")); // 1
        System.out.println(A.lastIndexOf("rat")); // 16
      
    }
}
