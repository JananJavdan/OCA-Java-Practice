package test_practice;

public class Test2 {
    /*


You had to select 2 option(s)
A-Multiple inheritance of state includes ability to inherit instance methods from multiple classes.
 Methods do not have state. Ability to inherit instance methods from multiple classes is called multiple
 inheritance of implementation.
 Default methods introduce one form of multiple inheritance of implementation. A class can implement
 more than one interface, which can contain default methods that have the same name. However, such
 a class cannot be compiled. In this case, the implementing class is required to provide its own
 implementation of the common method to avoid ambiguity.

B-Multiple inheritance of state includes ability to inherit instance fields from multiple classes.

C-Multiple inheritance of type includes ability to inherit instance fields as well as instance
methods from multiple classes.

D-Multiple inheritance of type includes ability to implement multiple interfaces and ability to
inherit static or instance fields from interfaces and/or classes.

E-Multiple inheritance of type includes ability to implement multiple interfaces and/or ability to
extend from multiple classes.

Correct answer: B,E

Interfaces, classes, and enums are all "types". Java allows a class to implement multiple interfaces.
 In this way, Java supports multiple inheritance of types.
 "State", on the other hand, is represented by instance fields. Only a class can have instance fields
 and therefore, only a class can have a state. (Fields defined in an interface are always implicitly
 static, even if you don't specify the keyword static explicitly. Therefore, an interface does not
 have any state.) Since a class is allowed to extend only from one class at the most, it can inherit
 only one state. Thus, Java does not support multiple inheritance of state.

This is an important concept and is explained in more detail
here: https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html
----------------------------------------------------------------------------------------------------
What is wrong with the following code?
class MyException extends Exception {}
public class TestClass{
   public static void main(String[] args){
      TestClass tc = new TestClass();
      try{
         tc.m1();
      }
      catch (MyException e){
         tc.m1();
      }
      finally{
         tc.m2();
      }
   }
   public void m1() throws MyException{
      throw new MyException();
   }
   public void m2() throws RuntimeException{
      throw new NullPointerException();
   }
}

You had to select 1 option(s)

It will not compile because you cannot throw an exception in finally block.
You can, but then you have to declare it in the method's throws clause.

It will not compile because you cannot throw an exception in catch block.
You can, but then you have to declare it in the method's throws clause.

It will not compile because NullPointerException cannot be created this way.
It does have a no args constructor.

It will not compile because of unhandled exception.

It will compile but will throw an exception when run.

correct answer: It will not compile because of unhandled exception.

The catch block is throwing a checked exception (i.e. non-RuntimeException) which must be handled by
either a try catch block or declared in the throws clause of the enclosing method.
Note that finally is also throwing an exception here, but it is a RuntimeException so there is no
need to handle it or declare it in the throws clause.

How to Fix the Code?
Option 1: Handle the Exception in catch

catch (MyException e){
    try {
        tc.m1();  // Now handled inside try-catch
    } catch (MyException ex) {
        System.out.println("Exception caught: " + ex);
    }
}
Option 2: Declare throws in main()

public static void main(String[] args) throws MyException {
    TestClass tc = new TestClass();
    try {
        tc.m1();
    } catch (MyException e) {
        tc.m1();  // No error because main() declares throws MyException
    } finally {
        tc.m2();
    }
}
-------------------------------------------------------------------------------------------------------
Which of the given lines can be inserted at //1 of the following program ?

public class TestClass{
   public static void main(String[] args){
     short s = 9;
     //1
   }
}

You had to select 2 option(s)

Short k = new Short(9); System.out.println(k instanceof Short);
9 is considered an int and there is no constructor in Short that takes an int.
Short s = new Short( (short) 9 ); will work.

System.out.println(s instanceof Short);
The left operand of instanceof MUST be a reference variable and not a primitive.

Short k = 9; System.out.println( k instanceof s);
Right operand of instanceof MUST be a reference type name, i.e., a class, an interface, or an enum name.

int i = 9; System.out.println(s == i);
Any two numeric primitives can be compared using == operator.
Even a numeric primitive and a primitive wrapper (for example, an int with a Short or a Double)
can be compared. However, two wrappers of different types (for example, an Integer and a Short)
cannot be compared using ==.

Boolean b = s instanceof Number;
Left operand of instanceof MUST be an object and not a primitive.

Short k = 9; Integer i = 9; System.out.println(k == i);
This will not compile because k and i are referring to objects that have no IS-A relationship among
themselves.

Integer i = 9; System.out.println( s == i );

Corect: int i = 9; System.out.println(s == i); , Integer i = 9; System.out.println( s == i );
--------------------------------------------------------------------------------------------------
The following code snippet will not compile:

int i = 10;
System.out.println( i<20 ? out1() : out2() );

Assume that out1 and out2 methods have the following signatures: public void out1(); and public void out2();

You had to select 1 option(s)
True
False
corect: TRue
why?
Problem 1: Ternary Operator (? :) Requires a Return Type
The ternary operator (? :) must return a value.

Both out1() and out2() must return the same type, but their signatures show they return void:

java
Copy
Edit
public void out1();
public void out2();
Since void is not a value, out1() and out2() cannot be used in the ternary operator.

Why This Causes a Compilation Error
The ternary operator evaluates to a value, but void methods do not return a value.

The expression i < 20 ? out1() : out2() tries to assign a void method's result to System.out.println(), which expects a valid argument.

This results in a compilation error.

Fixing the Issue
Use Methods That Return a Value

public String out1() { return "Hello from out1"; }
public String out2() { return "Hello from out2"; }

public static void main(String[] args) {
    int i = 10;
    System.out.println(i < 20 ? out1() : out2()); // ✅ Works fine
}
Now, the ternary expression returns a String, which System.out.println() can print.

Both the second and third operands in the ?: operator must return a value.

Void methods (void out1() and void out2()) cannot be used.

Since void is not a value, trying to use it in a ternary expression will cause a compilation error
-------------------------------------------------------------------------------------------------
What will be the result of attempting to compile and run the following program?
public class TestClass{
  public static void main(String args[ ] ){
    Object a, b, c ;
    a = new String("A");
    b = new String("B");
    c = a;
    a = b;
    System.out.println(""+c);
  }
}

You had to select 1 option(s)
The program will print java.lang.String@XXX, where XXX is the memory location of the object a.

The program will print A


The program will print B

The program will not compile because the type of a, b, and c  is Object.
String is an Object as well. You can always assign an object of the subclass to a super class
 reference without a cast.

The program will print java.lang.String@XXX, where XXX is the hash code of the object a.

answer:  The program will print A

The variables a, b and c contain references to actual objects. Assigning to a reference only
 changes the reference value, and not the object pointed to by the reference. So, when c = a is
 executed c starts pointing to the string object containing A. and when a = b is executed, a
 starts pointing to the string object containing B but the object containing A still remains
   same and c still points to it. So the program prints A and not B.

The Object class's toString generates a string using:  getClass().getName()
+ '@' + Integer.toHexString(hashCode())
But in this case, String class overrides the toString() method that returns just the actual
string value.
-------------------------------------------------------------------------------------------------
Given:

public class SimpleLoop {
    public static void main(String[] args) {
        int i=0, j=10;
        int count = 0;
        while (i<j) {
            i++;
            j--;
            count++;
        }
        System.out.println(i+" "+j+" "+count);
    }
}
What is the result?

You had to select 1 option(s)
6 4 5
6 5 5
6 5 6
6 4 6
5 5 5

In such type of questions, you will need to work out the values of the loop variables for every
iteration (unless you can recognize the pattern) on your worksheet.

Beginning i=0, j=10, count = 0
Iteration 1: i<j is true, i becomes 1, j becomes 9, count becomes 1
Iteration 2: i<j is true, i becomes 2, j becomes 8, count becomes 2
Iteration 3: i<j is true, i becomes 3, j becomes 7, count becomes 3
Iteration 4: i<j is true, i becomes 4, j becomes 6, count becomes 4
Iteration 5: i<j is true, i becomes 5, j becomes 5, count becomes 5
Iteration 6: i<j is false so the while loop is not entered.
Print 5 5 5.
----------------------------------------------------------------------------------------------------------
Given:
import java.util.*;
class Data{
    int value;
    public Data(int x){ this.value = x; }
    public String toString(){ return ""+value; }
}

class MyFilter {
  public boolean test(Data d){
     return d.value == 0;
  }
}

public class TestClass{

   public static void filterData(ArrayList<Data> dataList, MyFilter f){
      Iterator<Data> i = dataList.iterator();
      while(i.hasNext()){
           if(f.test(i.next())){
                i.remove();
           }
       }
   }

  public static void main(String[] args) {
        ArrayList<Data> al = new ArrayList<Data>();
        Data d = new Data(1); al.add(d);
        d = new Data(2); al.add(d);
        d = new Data(0); al.add(d);

        filterData(al, new MyFilter());  //1

        System.out.println(al);
    }
}

How can you use a lambda expression to achieve the same result?


You had to select 1 option(s)

Replace the line at //1 with:
filterData(al, x -> x.value==0);

Add implements java.util.function.Predicate to MyFilter definition and replace the line at //1 with:
filterData(al, x -> x.value==0);

Add implements java.util.function.Predicate<Data> to MyFilter definition and replace the line at //1 with:
filterData(al, x -> x.value==0);

Remove MyFilter class altogether.
Change type of f from MyFilter to java.util.function.Predicate in filterData method and replace the line at //1 with:
filterData(al, x -> x.value==0);

Remove MyFilter class altogether.
Change type of f from MyFilter to java.util.function.Predicate<Data> in filterData method and replace the line at //1 with:
filterData(al, x -> x.value==0);

answer: Remove MyFilter class altogether.
Change type of f from MyFilter to java.util.function.Predicate<Data> in filterData method and replace the line at //1 with:
filterData(al, x -> x.value==0)
----------------------------------------------------------------------------------------------------
What will the following code print when run without any arguments ...

public class TestClass {

    public static int m1(int i){
        return ++i;
    }

    public static void main(String[] args) {

        int k = m1(args.length);
        k += 3 + ++k;
        System.out.println(k);
    }

}
Select 1 option(s):
It will throw ArrayIndexOutOfBoundsException.
It will throw NullPointerException.
6
5
7
2
None of these.

answer: 6

When the program is run without any arguments, args gets assigned a string array of size 0. So NullPointerException or ArrayIndexOutOfBoundsException are out of question. Thus, the first call becomes :
int k = m1(0);

Follow through the code like this:
1. Method m1() uses pre-increment operation. Therefore, first i is incremented and then the new value of i is returned.
2. Thus, k gets the value of 1.

3. Expand the += operator as:
k = k + 3 + ++k;

This becomes (remember that k = 1 at this point):
k = 1 + 3 + (++k) i.e.
k = 1 + 3 + 2; (at this point value of k is 2 because of ++k). But the value of Right Hand Side has not yet been assigned to k.
k = 6; 6 is assigned to k thereby overwriting the value of 2.

Therefore, the final value of k is 6.
----------------------------------------------------------------------------------------------------
What will the following program print?

class Test{
   public static void main(String args[]){
      int k = 9, s = 5;
      switch(k){
         default :
         if( k == 10) { s = s*2; }
         else{
            s = s+4;
            break;
         }
         case 7 : s = s+3;
      }
      System.out.println(s);
   }
}

You had to select 1 option(s)

5

9
Since 9 does not match any of the case labels, it is accepted by default block. In this block, the
else part is executed, which sets s to the value of s+4, i.e. 9. Since there is a break in
the else block, case 7: is not executed.

12

It will not compile.

answer: 9
----------------------------------------------------------------------------------------------------
Which of the following implementations of a max() method will correctly return the largest value?

Select 1 option(s)

Option 1:
int max(int x, int y){
   return(  if(x > y){ x; } else{ y; }  );
}
🔴 Incorrect

if statements cannot be used inside a return statement like this.

if statements in Java do not return values directly.

Option 2:
int max(int x, int y){
   return( if(x > y){ return x; }  else{ return y; } );
}
🔴 Incorrect

You cannot use if statements inside parentheses.

The return keyword is wrongly placed inside another return statement.

Option 3:
int max(int x, int y){
   switch(x < y){
      case true:
             return y;
      default :
             return x;
   };
}
🔴 Incorrect

switch in Java only works with int, char, String, and enums—not boolean expressions like x < y.

true and false cannot be used as case labels.

Option 4:
int max(int x, int y){
      if (x > y)  return x;
      return y;
}
✅ Correct

This is a valid and clean implementation.

If x > y, it returns x; otherwise, it returns y.
-------------------------------------------------------------------------------------------------------
You have written some Java code in MyFirstClass.java file. Which of the following commands will you use to compile and run it.
(Assume that the code has no package declaration.)

You had to select 1 option(s)
javac MyFirstClass.java
javar MyFirstClass

javap MyFirstClass.java
javar MyFirstClass.java

java MyFirstClass.java
java MyFirstClass.class

javac MyFirstClass.java
javar MyFirstClass.java

javac MyFirstClass.java
java MyFirstClass

answer: javac MyFirstClass.java
java MyFirstClass

Remember that java code must be written in a file with .java extension. If you have a public
type (class, interface, or enum) in the code, the name of the file must be same as the name
of that public type.

Compilation and execution of a Java program is two step process. You first need to compile a java
file using a Java compiler. Oracle's JDK comes with a compiler. It is contained in the executable
 file named javac. You will find it in <jdk installation folder>/bin.

javac compiles the source code and generates bytecode in a new file with the same name as the source
 file but with extension .class. By default, the class file in generated in the same folder but
 javac is capable of placing it in a different folder if you use the -d flag. [This is just FYI
  and not required for the exam. -d is a very important and useful flag and we recommend that
   you read about it even if it is not required for the exam.]

In second step, the Java virtual machine (JVM), aka Java interpreter is invoked to execute the
 .class file. Oracle's JVM is contained in the executable file named java. It is also present
 in the same bin folder of JDK installation. It takes the fully qualified name (i.e. name including
  package) of the class file without extension as a argument.
------------------------------------------------------------------------------------------------------
Given the following code, which method declarations can be inserted at line 1 without any problems?

public class OverloadTest{
    public int sum(int i1, int i2) { return i1 + i2; }
    // 1
}
Select 3 option(s):
public int sum(int a, int b) { return a + b; }
public int sum(long i1, long i2) { return (int) i1; }
public int sum(int i1, long i2) { return (int) i2; }
public long sum(long i1, int i2) { return i1 + i2; }
public long sum(int i1, int i2) { return i1 + i2; }

Final Answer:
✅ The correct options are:

public int sum(long i1, long i2) { return (int) i1; }

public int sum(int i1, long i2) { return (int) i2; }

public long sum(long i1, int i2) { return i1 + i2; }

(Method overloading requires different parameter lists.)
-------------------------------------------------------------------------------------------------------
What will the following code print when compiled and run?

import java.util.*;
public class TestClass {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        list.add("val1"); //1
        list.add(2, "val2"); //2
        list.add(1, "val3"); //3
        System.out.println(list);
     }
}
Select 1 option(s):
It will not compile.
It will throw an exception at run time because of line //1
It will throw an exception at run time because of line //2
It will throw an exception at run time because of line //3
null

Final Answer:
✅ The program will compile but throw a java.lang.IndexOutOfBoundsException at runtime.

This line is trying to put a value in an ArrayList at index 2 (i.e. 3rd position). To be able to
 put a value at index 2, the ArrayList must have atleast 2 values already. Therefore, it will
 throw java.lang.IndexOutOfBoundsException exception.
 --------------------------------------------------------------------------------------------------
Which of the following operators can be used in conjunction with a String object?
Select 3 option(s):
+
++
+=
.
*

Final Answer:
✔ +
✔ +=
✔ .
----------------------------------------------------------------------------------------------------
Given:
public class LoopTest {
    int k = 5;
    public boolean checkIt(int k){
        return k-->0?true:false;
    }
    public void printThem(){
        while(checkIt(k)){
            System.out.print(k);
        }
    }
    public static void main(String[] args) {
        new LoopTest().printThem();
    }
}
What changes should be made so that the program will print 54321?
Select 1 option(s):
No change is necessary.
Replace System.out.print(k); with System.out.print(k--);
Replace System.out.print(k); with System.out.print(--k);
Replace while(checkIt(k)) with while(checkIt(--k)).
Replace return k-->0?true:false; with return this.k-->0?true:false;

Correct Answer:
✅ Replace System.out.print(k); with System.out.print(k--);

Observe that the method parameter k in checkIt shadows the instance variable k. Therefore, any
changes made to k in checkIt will not affect the instance variable k. For checkIt method to access
the instance variable k, you need to do this.k.

k-->0 means, first compare the value of k with 0, and then reduce it by 1. (As opposed to --k>0,
which means, first reduce the value of k by 1 and then compare with 0).

In the printThem method, k refers to the instance variable. You need to reduce it by 1 after
each iteration. Therefore, System.out.print(k--); will do.
--------------------------------------------------------------------------------------------------------------
Consider the following code:

class Super { static String ID = "QBANK"; }

class Sub extends Super{
   static { System.out.print("In Sub"); }
}
public class Test{
   public static void main(String[] args){
      System.out.println(Sub.ID);
   }
}
What will be the output when class Test is run?
Select 1 option(s):
It will print In Sub and QBANK.
It will print QBANK.
Depends on the implementation of JVM.
It will not even compile.
None of the above.

Final Output:
QBANK
The static block in Sub ("In Sub") never executes because Sub is never initialized.
and static field is belongs to a superclass.

Correct Answer:
✅ It will print QBANK.
------------------------------------------------------------------------------------------------------
What should be the return type of the following method?
public RETURNTYPE methodX( byte by){
    double d = 10.0;
    return (long) by/d*3;
}
Select 1 option(s):
int
long
double
float
byte

Correct answer: double

Note that the cast (long) applies to 'by' not to the whole expression.
( (long) by ) / d * 3;
Now, division operation on long gives you a double. So the return type should be double.
-------------------------------------------------------------------------------------------------------
What will be the output when the following program is run?

public class TestClass{
    char c;
    public void m1(){
        char[ ] cA = { 'a' , 'b'};
        m2(c, cA);
        System.out.println( ( (int)c)  + "," + cA[1] );
    }
    public void m2(char c, char[ ] cA){
        c = 'b';
        cA[1] = cA[0] = 'm';
    }
    public static void main(String args[]){
        new TestClass().m1();
    }
}
Select 1 option(s):
Compile time error.
 ,m
0,m
b,b
b,m

Correct answer: 0,m

Note that Arrays are Objects (i.e. cA instanceof Object is true) so are effectively passed by
reference. So in m1() the change in cA[1] done by m2() is reflected everywhere the array is used.
c is a primitive type and is passed by value. In method m2() the passed parameter c is different
from the instance variable 'c' because local variables (and method parameters) shadow instance
variables with same name. So instance member 'c' keeps its default (i.e. 0) value.
-----------------------------------------------------------------------------------------------
What letters will be printed by this program?
public class ForSwitch{
    public static void main(String args[]){
        char i;
        LOOP: for (i=0;i<5;i++){
            switch(i++){
                case '0': System.out.println("A");
                case 1: System.out.println("B"); break LOOP;
                case 2: System.out.println("C"); break;
                case 3: System.out.println("D"); break;
                case 4: System.out.println("E");
                case 'E' : System.out.println("F");
            }
        }
    }
}
Select 2 option(s):
A
B
C
D
F

Correct Options:
C
F
------------------------------------------------------------------------------------------------


     */
}
