
package year2019.cs40s.iterators;


public class IteratorsInLists 
{
    
    public static void main(String[] args) {
        new IteratorsInLists();
    }
    
    public IteratorsInLists() {
                
        System.out.println("\njava.util.LinkedList imported...\n");
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Integer(i));
        }
        System.out.println(list.toString());
        
        System.out.println("\nIterator loop...\n");
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer integer = (Integer) it.next();
            System.out.println(integer);
        }
        
        System.out.println("\nEnhanced for loop...\n");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        
        
        System.out.println("\nCreated LinkedList...\n");
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(new Integer(i));
        }
        System.out.println(list2.toString());
        
//        System.out.println("\nIterator loop...\n");
//        java.util.Iterator it2 = list2.iterator();
//        while (it2.hasNext()) {
//            Integer integer = (Integer) it2.next();
//            System.out.println(integer);
//        }
        
        System.out.println("\nEnhanced for loop...\n");
//        for (Integer integer : list2) {
//            System.out.println(integer);
//        }
        
    }
    
}
