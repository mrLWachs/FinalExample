
/** required package class namespace */
package year2018.cs40s.collections;

/** required imports */
import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * Stack.java - a Stack ADT using generics
 *
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Feb 20, 2018 
 * @instructor Mr. Wachs
 */
public class Stack <T extends Comparable<T>> implements Serializable
{

    /** Node reference to the top node in the stack */
    private Node top;
    /** The number of nodes in the stack */
    private int length;
    
    
    /** 
     * Default constructor for the class 
     */
    public Stack() {
        finalize();                                     // wipe any current data
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param list the LinkedList to set the stack to
     */
    public Stack(LinkedList<T> list) {
        finalize();                                     // wipe any current data
        for (int i = list.size()-1; i >= 0; i--) {      // traverse list
            T data = (T)list.get(i);                    // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Stack(T[] array) {
        finalize();                                     // wipe any current data
        for (int i = array.length-1; i >= 0; i--) {     // traverse array
            T data = (T)array[i];                       // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Turns the stack into a ADT LinkedList object
     * 
     * @return the Stack as a ADT LinkedList
     */
    public LinkedList<T> toLinkedList() {
        LinkedList<T> list = new LinkedList<>();        // create new list
        Node current = top;                             // start at top node        
        while (current != null) {                       // traverse stack   
            T data = (T)current.data;                   // retrieve data
            list.add(data);                             // add to list
            current = current.next;                     // move to next node
        }
        return list;                                    // return list
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(Array.newInstance(
                array.getClass().getComponentType(), 
                length));                               // create array 
        Node current = top;                             // start at top node 
        for (int i = 0; i < length; i++) {              // traverse array
            array[i] = (T)current.data;                 // retrieve data
            current = current.next;                     // move to next node
        }
        return array;                                   // return array
    }
        
    /**
     * Frees up all memory used by this object
     */
    @Override
    public final void finalize() {
        length = 0;                                     // length set to zero
        top    = null;                                  // reference set to null
        System.gc();                                    // garbage collector called
    }
    
    /**
     * The number of items in the stack
     * 
     * @return the length of the stack
     */
    public int size() {
        return length;
    }
    
    /**
     * Determines if the stack is empty or not
     * 
     * @return empty stack (true) or not (false)
     */
    public boolean isEmpty() {
        return length == 0;
    }
    
    /**
     * Adds data to the top of the stack
     * 
     * @param data the generic data to add
     * @return operation was successful (true) or not (false)
     */
    public boolean push(T data) {
        if (data == null) return false;                 // empty stack
        Node node = new Node(data);                     // create node
        if (!isEmpty()) node.next = top;                // add first node
        top = node;                                     // set to top of stack
        length++;                                       // increase length
        return true;                                    // operation successful
    }
    
    /**
     * Removes the data from the top of the stack
     * 
     * @return the data from the top of the stack
     */
    public T pop() {
        if (isEmpty()) return null;                     // no nodes in stack
        else {                                          // stack has some nodes
            length--;                                   // reduce length
            T data = (T)top.data;                       // store data
            top = top.next;                             // adjust top reference
            return data;                                // data returned
        }
    }
    
    /**
     * Just "peeks" at top of stack without mutating the structure
     * 
     * @return the data on the top
     */
    public T top() {
        if (isEmpty()) return null;                     // no nodes in stack
        return (T)top.data;                             // return top data
    }
   
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty stack";            // no nodes to display
        else {
            String text = "Stack = [";                  // starting character
            Node current = top;                         // start at top node
            while (current.next != null) {              // traverse stack
                text += current.toString() + ",";       // append data
                current = current.next;                 // move to next node
            }            
            return text + current.toString() + "]";     // append end character
        }
    }

    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Stack)) return false;   // check object type
        try {                                           // error trap
            Stack stack1 = ((Stack)object).clone();     // clone/cast parameter
            Stack stack2 = this.clone();                // clone this stack
            if (stack1.size() != stack2.size())         
                return false;                           // stacks not same size
            while (!stack2.isEmpty()) {                 // traverse stacks
                T data1 = (T)stack1.pop();              // retrieve data
                T data2 = (T)stack2.pop();
                if (!data1.equals(data2)) return false; // compare data
            }
            return true;                                // all tests passed
        }
        catch (ClassCastException | NullPointerException e) {
            return false;                               // cannot cast, or null
        }
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public Stack clone() {
        Stack<T> stack1 = new Stack<>();                // new empty stack
        Node current = top;                             // start at top node
        while (current != null) {                       // traverse stack
            T data = (T)current.data;                   // get data
            stack1.push(data);                          // push onto new stack
            current = current.next;                     // move to next node
        }                
        Stack<T> stack2 = new Stack<>();                // second new stack
        while (!stack1.isEmpty()) {                     // traverse first stack
            T data = (T)stack1.pop();                   // get data
            stack2.push(data);                          // push onto 2nd stack
        }        
        return stack2;                                  // return clone
    }

}
