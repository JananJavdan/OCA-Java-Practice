package chapter1_buildingblocks;

public class GarbageCollector {
    /*
    What is Garbage Collection?

• all Java objects are stored in program's memory heap (a.k.a. free store)
• garbage collection is a process of automatically freeing memory on the heap
• by removing objects which are no longer reachable in the program
• these object are said to be eligible for garbage collection
• once the object is eligible for gc Java can remove it from heap (and free memory)
• this process is out of your control
• you cannot know if and when the memory will be freed
------------------------------------------------------------------------------------------------------
System.gc()
• with this method you can suggest Java to clean the heap

System.gc();

• but it's not guaranteed to do anything !!
----------------------------------------------------------------------------------------------------
Eligibility for Garbage Collection:

• Object is eligible for g.c. once it is no longer reachable by the program

1. the object has no reference pointing to it
2. all references of the object have gone out of scope

• in other words, when object "hangs in the air"
---------------------------------------------------------------------------------------------------
1: public class gcExample {
2: public static void main(String[] args) {
3: String a, b;
4: a = new String("Emperor");
5: b = new String("King");
6: a = b;     >>>>   in line 6, object "Emperor" is eligible for garbage collection
7: String c = a;
8: a = null;
9: }
10: }
---------------------------------------------------------------------------------------------
Reference (STACK)               Object (HEAP)
Remember!
It is objects, not references,
which are collected by the g.c. !!


     */
}
