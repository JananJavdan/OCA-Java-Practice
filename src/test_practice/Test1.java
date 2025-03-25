package test_practice;

public class Test1 {
/*
    Consider the following class:

class TestClass{
    void probe(int... x) { System.out.println("In ..."); }  //1

    void probe(Integer x) { System.out.println("In Integer"); } //2

    void probe(long x) { System.out.println("In long"); } //3

    void probe(Long x) { System.out.println("In LONG"); } //4

    public static void main(String[] args){
        Integer a = 4; new TestClass().probe(a); //5
        int b = 4; new TestClass().probe(b); //6
    }
}
What will it print when compiled and run?

Select 2 option(s):
1-In Integer and In long
2-In ... and In LONG, if //2 and //3 are commented out.
3-In Integer and In ..., if //4 is commented out.
4-It will not compile, if //1, //2, and //3 are commented out.
5-In LONG and In long, if //1 and //2 are commented out.

correct answer:
1-In Integer and In long
4-It will not compile, if //1, //2, and //3 are commented out.

To answer this type of questions, you need to know the following rules:

1. The compiler always tries to choose the most specific method available with least number of modifications to the arguments.

2. Java designers have decided that old code should work exactly as it used to work before boxing-unboxing functionality became available.

3. Widening is preferred to boxing/unboxing (because of rule 2), which in turn, is preferred over var-args.


Thus,
1.
probe(Integer) will be bound to probe(Integer) (exact match). If that is not available, it will be bound to probe(long), and then with probe(int...) in that order of preference.
probe(long) is preferred over probe(int...) because unboxing an Integer gives an int and in pre 1.5 code probe(long) is compatible with an int (Rule 2).

It is never bound to probe(Long ) because Integer and Long are different object types and there is no IS-A relation between them. (This holds true for any two wrapper classes).
It could, however, be bound to probe(Object ) (if it existed), because Integer IS-A Object.

2.
probe(int) is bound to probe(long) (because of Rule 2) , then to probe(Integer ) because boxing an int qives you an Integer, which matches exactly to probe(Integer), and then to probe(int...).

It is never bound to probe(Long ) because int is not compatible with Long.
--------------------------------------------------------------------------------------------------------
What will the following code print when run?

public class TestClass{
    public static Integer wiggler(Integer x){
       Integer y = x + 10;
       x++;
       System.out.println(x);
       return y;
    }

    public static void main(String[] args){
       Integer dataWrapper = new Integer(5);
       Integer value = wiggler(dataWrapper);
       System.out.println(dataWrapper+value);
    }
}
Select 1 option(s):
5 and 20
6 and 515
6 and 20
6 and 615
It will not compile

answer:
6 and 20

1. Wrapper objects are always immutable. Therefore, when dataWrapper is passed into wiggler() method,
it is never changed even when x++; is executed. However, x, which was pointing to the same object as
dataWrapper, is assigned a new Integer object (different from dataWrapper) containing 6.

2. If both the operands of the + operator are numeric, it adds the two operands. Here,
the two operands are Integer 5 and Integer 15, so it unboxes them, adds them, and prints 20.
-----------------------------------------------------------------------------------------------------
Which of these expressions will return true?

You had to select 4 option(s)

1- "hello world".equals("hello world")

2- "HELLO world".equalsIgnoreCase("hello world")
equalsIgnoreCase() method treats both cases (upper and lower) as same.

3- "hello".concat(" world").trim().equals("hello world")
"hello".concat(" world") will return "hello world" and trim() won't do any change because there is no space at the beginning or end of the string.

4- "hello world".compareTo("Hello world") < 0
Notice that the Strings differ at the first position. The value returned by compareTo is (Unicode value of the left hand side - Unicode value of the right hand side).
Although not required for the exam, it is good to know that for English alphabets, the unicode value of any lower case letter is always 32 more than the unicode value of the same letter in upper case. So, 'a' - 'A' or 'h' - 'H' is 32.
Note that int value of ASCII 'a' is 97, while that of 'A' is 65.

5- "Hello world".toLowerCase( ).equals("hello world")
toLowerCase() converts all uppercase letters to lower case.

Answer: 1,2,3,5
-----------------------------------------------------------------------------------------------------
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
You had to select 2 option(s)
A
B
C
D
F

Answer: C,F
1. Defining i as char doesn't mean that it can only hold characters (a, b, c etc).
 It is an integral data type which can take any +ive integer value from 0 to 2^16 -1.
2. Integer 0 or 1, 2 etc. is not same as char '0', '1' or '2' etc.
so when i is equal to 0, nothing gets printed and i is incremented to 1 (due to i++ in the switch).
i is then incremented again by the for loop for next iteration. so i becomes 2.
when i = 2, "C" is printed and i is incremented to 3 (due to i++ in the switch)
and then i is incremented to 4 by the for loop so i becomes 4.
when i = 4, "E" is printed and since there is no break, it falls through to case 'E'
and "F" is printed.
i is incremented to 5  (due to i++ in the switch) and then it is again incremented to 6 by
the for loop. Since i < 5 is now false, the for loop ends.
-----------------------------------------------------------------------------------------------------
Assuming that the following method will always be called with a phone number in the format
ddd-ddd-dddd (where d stands for a digit), what can be inserted at //1 so that it will return a
 String containing the same number except its last four digits will be masked with xxxx?

public static String hidePhone(String fullPhoneNumber){
  //1 Insert code here
}
Select 3 option(s):

1-return new StringBuilder(fullPhoneNumber).substring(0, 8)+"xxxx";
2-return new StringBuilder(fullPhoneNumber).replace(8, 12, "xxxx").toString();
3-return new StringBuilder(fullPhoneNumber).append("xxxx", 8, 12).toString();
4-return new StringBuilder("xxxx").append(fullPhoneNumber, 0, 8).toString();
5-return new StringBuilder("xxxx").insert(0, fullPhoneNumber, 0, 8).toString();

Answer: 1,2,5

return new StringBuilder(fullPhoneNumber).append("xxxx", 8, 12).toString();
This will actually throw an IndexOutOfBoundsException because the call to append will look for
 characters starting from index 8 to 11 in string "xxxx", which has only 4 characters.

return new StringBuilder("xxxx").append(fullPhoneNumber, 0, 8).toString();
This will return xxxxddd-ddd-.
----------------------------------------------------------------------------------------------------
Identify correct option(s)

You had to select 2 option(s)

1-Multiple inheritance of state includes ability to inherit instance methods from multiple classes.
2-Multiple inheritance of state includes ability to inherit instance fields from multiple classes.
3-Multiple inheritance of type includes ability to inherit instance fields as well as instance methods from multiple classes.
4-Multiple inheritance of type includes ability to implement multiple interfaces and ability to inherit static or instance fields from interfaces and/or classes.
5-Multiple inheritance of type includes ability to implement multiple interfaces and/or ability to extend from multiple classes.

Answer: 2,5

Interfaces, classes, and enums are all "types". Java allows a class to implement multiple interfaces.
 In this way, Java supports multiple inheritance of types.
"State", on the other hand, is represented by instance fields. Only a class can have instance fields
 and therefore, only a class can have a state. (Fields defined in an interface are always implicitly
 static, even if you don't specify the keyword static explicitly. Therefore, an interface does not
 have any state.) Since a class is allowed to extend only from one class at the most, it can inherit
  only one state. Thus, Java does not support multiple inheritance of state.

This is an important concept and is explained in more detail here: https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html
------------------------------------------------------------------------------------------------------
The following class will print 'index = 2' when compiled and run.

class Test{
   public static int[ ] getArray() {  return null;  }
   public static void main(String[] args){
      int index = 1;
      try{
         getArray()[index=2]++;
      }
      catch (Exception e){  }  //empty catch
      System.out.println("index = " + index);
   }
}
You had to select 1 option(s)
True
False

Answer:True

If the array reference expression produces null instead of a reference to an array,
 then a NullPointerException is thrown at runtime, but only after all parts of the array reference
  expression have been evaluated and only if these evaluations completed normally.

This means, first index = 2 will be executed, which assigns 2 to index. After that null[2]
is executed, which throws a NullPointerException. But this exception is caught by the catch block,
 which prints nothing. So it seems like NullPointerException is not thrown but it actually is.

In other words, the embedded assignment of 2 to index occurs before the check for array reference
produced by getArray().

In an array access, the expression to the left of the brackets appears to be fully evaluated before
 any part of the expression within the brackets is evaluated. Note that if evaluation of
 the expression to the left of the brackets completes abruptly, no part of the expression within
 the brackets will appear to have been evaluated.

 اگر عبارت مرجع آرایه به جای ارجاع به یک آرایه، null را تولید کند،
 در زمان اجرا یک NullPointerException پرتاب می‌شود، اما تنها پس از
 ارزیابی تمام قسمت‌های عبارت مرجع آرایه و تنها در صورتی که این ارزیابی‌ها به طور معمول تکمیل شوند.

این بدان معناست که ابتدا index = 2 اجرا می شود که 2 را به ایندکس اختصاص می دهد.
 پس از آن null[2] اجرا می شود که یک NullPointerException می اندازد.
 اما این استثنا توسط بلوک catch گرفته می‌شود که چیزی چاپ نمی‌کند.
  بنابراین به نظر می رسد که NullPointerException پرتاب نشده است اما در واقع همینطور است.

به عبارت دیگر، تخصیص تعبیه شده 2 به ایندکس قبل از بررسی
مرجع آرایه تولید شده توسط getArray() انجام می شود.

در دسترسی به آرایه، به نظر می‌رسد که عبارت سمت چپ براکت‌ها، قبل از ارزیابی هر بخشی
از عبارت درون براکت‌ها، به‌طور کامل ارزیابی می‌شود. توجه داشته باشید که اگر
ارزیابی عبارت سمت چپ براکت ها به طور ناگهانی کامل شود،
 به نظر نمی رسد که هیچ بخشی از عبارت درون براکت ها ارزیابی شده باشد.
-----------------------------------------------------------------------------------------------------
What is the result of executing the following fragment of code:

boolean b1 = false;
boolean b2  = false;
if (b2 = b1 != b2){
   System.out.println("true");
} else{
   System.out.println("false");
}

You had to select 1 option(s)

1-Compile time error.
2-It will print true;
3-It will print false;
4-Runtime error.
5-It will print nothing.

Answer:3

All an if() needs is a boolean. Now, b1 != b2 returns false which is a boolean and so the
expression becomes b2 = false.  It returns false which is again a boolean. So there is no
error and it prints false.
Remember that every expression has a return value (which is actually the Left Hand Side
of the expression). For example, The value of the expressing i = 10 , is 10 (an int).
------------------------------------------------------------------------------------------------------
Consider the following code:

class Super{
  static{ System.out.print("super "); }
}
class One{
  static {  System.out.print("one "); }
}
class Two extends Super{
  static {  System.out.print("two "); }
}
class Test{
  public static void main(String[] args){
     One o = null;
     Two t = new Two();
  }
}
What will be the output when class Test is run ?

You had to select 1 option(s)

1-It will print one super two
2-It will print one two super
3-It will print super two
4-It will print two super
5-None of the above

Answer:3

"one" will not be printed as class One is not actively used.
Super will be instantiated before Two.
--------------------------------------------------------------------------------------------------------
Consider the following class hierarchy

class A{
   public void m1() {   }
}
class B extends A{
   public void m1() {   }
}
class C extends B{
   public void m1(){
       //1
      ... lot of code.
      //
 }
}

You had to select 2 option(s)

1-You cannot access class A's m1() from class C for the same object ( i.e. this).
2-You can access class B's m1() using super.m1() from class C.
3-You can access class A's m1() using ( (A) this ).m1() from class C.
4-You can access class A's m1() using super.super.m1() from class C.

Answer:1,2

Note that selection of method to be executed depends upon the actual object class.
So no matter what you do, in class C you can only access C's m1() even by casting this to B or A.
So, this option will not work.
super.super is an invalid construct. So, there is no way you can access m1() of A from C.
------------------------------------------------------------------------------------------------------
What will the following code print?

  int i = 1;
  int j = i++;
  if( (i==++j) | (i++ == j) ){
    i+=j;
  }
  System.out.println(i);

1-3
2-4
3-5
4-2
5-It will not compile.

Answer: 3

This question is based on 2 concepts:

1. i == ++j is not same as i == j++;
In the case of i == ++j, j is first incremented and then compared with i. While in the case of i == j++;, j is first compared with i and then incremented.

2. The | operator, when applied for boolean operands, ensures that both the sides are evaluated. This is opposed to || which does not evaluate the Right Hand Side if the result can be known by just evaluating the Left Hand Side.

Now, let us see the values of i and j at each step:

int i = 1;
int j = i++; // j is assigned 1 and i is incremented to 2
if( (i==++j) | (i++ == j) )
/* increment j (so, j becomes 2) and compare with i, this means, it returns true.
since we are using the | operator here, we need to evaluate the next condition:
that is, compare i with 2 and increment i. This means i becomes 3.
    {
        i+=j; //i = 3+2 = 5
    }
System.out.println(i); //prints 5
---------------------------------------------------------------------------------------------------------
What should be the return type of the following method?
public RETURNTYPE methodX( byte by){
    double d = 10.0;
    return (long) by/d*3;
}
int
long
double
float
byte

Answer: double

Note that the cast (long) applies to 'by' not to the whole expression.
( (long) by ) / d * 3;
Now, division operation on long gives you a double. So the return type should be double.
-----------------------------------------------------------------------------------------------------
Which of the following code fragments compile without any error?

Assume that Math.random() returns a double between 0.0 and 1.0 (not including 1.0).
You had to select 3 option(s)


A-for(;Math.random()<0.5;){
    System.out.println("true");
}
The second expression in a for loop must return a boolean, which is happening here. So this is valid.


B-for(;;Math.random()<0.5){
    System.out.println("true");
}
Here, the first part (i.e. the init part) and the second part (i.e. the expression/condition part)
part of the for loop are empty. Both are valid. (When the expression/condition part is empty, it is interpreted as true.)


The third part (i.e. the update part) of the for loop does not allow every kind of statement.
It allows only the following statements here:  Assignment, PreIncrementExpression,
PreDecrementExpression, PostIncrementExpression, PostDecrementExpression, MethodInvocation,
 and ClassInstanceCreationExpression. Thus, Math.random()<0.5 is not valid here, and so this will
 not compile.

C-for(;;Math.random()){
    System.out.println("true");
}
This is a valid never ending loop that will keep printing true.
D-for(;;){
    Math.random()<.05? break : continue;
}
This is an invalid use of ? : operator. Both sides of : should return some value. Here, break and
continue do not return anything. However, the following would have been valid:
for(;Math.random()<.05? true : false;){  }

E-for(;;){
    if(Math.random()<.05) break;
}
Corect Answer:A-C-E
-----------------------------------------------------------------------------------------------------
What will the following code print ?

class Test{
   public static void main(String[] args){
      int k = 1;
      int[] a = { 1 };
      k += (k = 4) * (k + 2);
      a[0] += (a[0] = 4) * (a[0] + 2);
      System.out.println( k + " , " + a[0]);
   }
}
You had to select 1 option(s)

A-4 , 4
B-25 , 25
C-13 , 13
D-None of the above.

Corect answer: B
The value 1 of k is saved by the compound assignment operator += before its right-hand operand
(k = 4) * (k + 2) is evaluated. Evaluation of this right-hand operand then assigns 4 to k,
 calculates the value 6 for k + 2, and then multiplies 4 by 6 to get 24. This is added to the saved
  value 1 to get 25, which is then stored into k by the += operator. An identical analysis applies
   to the case that uses a[0].
  k += (k = 4) * (k + 2);
  a[0] += (a[0] = 4) * (a[0] + 2);
  k = k + (k = 4) * (k + 2);
  a[0] = a[0] + (a[0] = 4) * (a[0] + 2);
------------------------------------------------------------------------------------------------------
The following method will compile and run without any problems.

public void switchTest(byte x){
   switch(x){
      case 'b':   // 1
      default :   // 2
      case -2:    // 3
      case 80:    // 4
   }
}

You had to select 1 option(s)
True
False
Corect answer: True
The following types can be used as a switch variable:
byte, char, short, int, String, and enums. Wrapper classes Byte, Character, Short, and Integer
are allowed as well. Note that " long, float, double, and boolean " are not allowed.

All the case constants should be assignable to the switch variable type. i.e.
had there been a case label of 128 ( case 128 : //some code ), it would not have compiled.
Because the range of a byte is from -128 to 127 and so 128 is not assignable to 'x'.

The integral value of 'b' is 98, which is less than 127 so Line //1 is fine.

Note: Although it is not required for the exam to know the integral values of characters,
it is good to know that all English letters (upper case as well as lower case)
as well as 0-9 are below 127 and so are assignable to byte.
-----------------------------------------------------------------------------------------------------
The following code snippet will print 4.

int i1 = 1, i2 = 2, i3 = 3;
int i4 = i1 + (i2=i3 );
System.out.println(i4);

You had to select 1 option(s)
True
False
Corect answer: True
First the value of i1 is evaluated (i.e. 1). Now, i2 is assigned the value of i3 i.e. i2 becomes 3.
Finally i4 gets 1 +3 i.e. 4.
------------------------------------------------------------------------------------------------------
Which statements about the following code contained in BankAccount.java are correct?

interface Account{
  public default String getId(){
     return "0000";
  }
}

interface PremiumAccount extends Account{
  public String getId();
}

public class BankAccount implements PremiumAccount{
  public static void main(String[] args) {
      Account acct = new BankAccount();
      System.out.println(acct.getId());
  }

}
You had to select 1 option(s)
A-It will print 0000 when run.

B-It will compile if class BankAccount provides an implementation for getId method.
Since interface PremiumAccount redeclares getId method as abstract, the BankAccount class must either
provide an implementation for this method or be marked as abstract.
In this case, making the class abstract will not help because of the statement -
Account acct = new BankAccount();

C-It will not compile unless interface PremiumAccount is marked abstract.
Interfaces are always abstract. You can but you don't have to mark them abstract.
Methods of an interface that are not marked default or static are also always abstract. You don't have to mark them as abstract.

D-It will compile if getId method in PremiumAccount is replaced with:
public String getId(){ super.getId(); }
1. You cannot provide a method body in an interface method unless you mark it as default (or static).
2. You cannot use super keyword in an interface's method to invoke a method defined in its super interface.

E-It will compile if getId method in PremiumAccount is replaced with:
public default String getId(){ super.getId(); }
super.methodName is a valid way to invoke a super class's method from anywhere within a subclass's
method. But it works only for classes. To invoke an interface's default method, you need to use
the name of that interface as well. Like this: Account.super.getId();

A class (or an interface) can invoke a default method of an interface that is explicitly mentioned
in the class's implements clause (or the interface's extends clause) by using the
same syntax i.e. <InterfaceName>.super.<methodName>.

However, this technique cannot be used to invoke a default method provided by an interface that is
not directly implemented (or extended) by the caller.

Here is an example:

interface A {
   default void hello() {
   }
}

interface B extends A {
   default void hello() {
       super.hello();    //This is NOT valid.
       A.super.hello();    //This is valid.
   }
}

public class TestClass implements B {
   public void hello() {
      super.hello();//This is NOT valid.
      A.super.hello(); //This is NOT valid
//because TestClass does not implement A directly.
      B.super.hello(); //This is valid.
   }
}
F-It will compile if getId method in PremiumAccount is replaced with:
public default String getId(){ super(); }
super(); is used to invoke the super class's constructor. So, if present, it can only be the first statement of a constructor. Calling super(); does not invoke the super class's method.

Corect answer: B
-----------------------------------------------------------------------------------------------------
What will the following program print?

public class InitTest{
   public InitTest(){
      s1 = sM1("1");
   }
   static String s1 = sM1("a");
   String s3 = sM1("2");{
      s1 = sM1("3");
   }
   static{
      s1 = sM1("b");
   }
   static String s2 = sM1("c");
   String s4 = sM1("4");
    public static void main(String args[]){
        InitTest it = new InitTest();
    }
    private static String sM1(String s){
       System.out.println(s);  return s;
    }
}

You had to select 1 option(s)
A-The program will not compile.
B-It will print : a b c 2 3 4 1
C-It will print : 2 3 4 1 a b c
D-It will print : 1 a 2 3 b c 4
E-It will print : 1 a b c 2 3 4
Corect answer: B
First, static statements/blocks are called IN THE ORDER they are defined.
Next, instance initializer statements/blocks are called IN THE ORDER they are defined.
Finally, the constructor is called. So, it prints a b c 2 3 4 1.
-----------------------------------------------------------------------------------------------------
Consider the following code:

class A{
   A() {  print();   }
   void print() { System.out.print("A "); }
}
class B extends A{
   int i =   4;
   public static void main(String[] args){
      A a = new B();
      a.print();
   }
   void print() { System.out.print(i+" "); }
}
What will be the output when class B is run ?

You had to select 1 option(s)
A-It will print A 4
B-It will print A A
C-It will print 0 4
D-It will print 4 4
E-None of the above.
Corect answer: C
Note that method print() is overridden in class B. Due to polymorphism, the method to be executed is
selected depending on the class of the actual object.
Here, when an object of class B is created, first B's default constructor (which is not visible in
the code but is automatically provided by the compiler because B does not define any constructor
explicitly) is called. The first line of this constructor is a call to super(), which invokes
A's constructor. A's constructor in turn calls print(). Now, print is a non-private instance
method and is therefore polymorphic, which means, the selection of the method to be executed
depends on the class of actual object on which it is invoked. Here, since the class of actual
object is B, B's print is selected instead of A's print. At this point of time, variable i has
not been initialized (because we are still in the middle of initializing A), so its default
value i.e. 0 is printed.
Finally, 4 is printed.
------------------------------------------------------
NOTE: Try this code after declaring i in class B as final and observe the output.
What if i is declared final?
If i is declared as final, like this:

class B extends A {
   final int i = 4;
Final variables are initialized at the time of declaration, meaning i is already set to 4 before
the superclass constructor (A()) runs.
So, when print() is called inside A's constructor, i already has the value 4, and the output would be:
4 4
------------------------------------------------------------
Key Takeaways:
Polymorphism applies even during constructor execution,چند شکلی حتی در هنگام اجرای سازنده نیز اعمال می شود
meaning B's overridden print() is called instead of A's print().

Instance variables in a subclass are not initialized before the superclass constructor runs,
so they hold default values if accessed early.
متغیرهای نمونه در یک کلاس فرعی قبل از اجرای سازنده سوپرکلاس مقداردهی اولیه نمی شوند،
 بنابراین اگر زودتر به آنها دسترسی پیدا شود، مقادیر پیش فرض را نگه می دارند.

Declaring i as final ensures it is initialized immediately, preventing this behavior.
اعلام i به عنوان نهایی تضمین می کند که بلافاصله مقداردهی اولیه می شود و از این رفتار جلوگیری می کند.

--------------------------------------------------------------------------------------------------
Consider the contents of following two files:

//In file A.java
package a;
public class A{
   A(){ }
   public void  print(){ System.out.println("A"); }
}

//In file B.java
package b;
import a.*;
public class B extends A{
   B(){ }
   public void  print(){ System.out.println("B"); }
   public static void main(String[] args){
      new B();
   }
}


What will be printed when you try to compile and run class B?

You had to select 1 option(s)
It will print A.
It will print B.
It will not compile.
Because A() is not accessible in B.
It will compile but will not run.
None of the above.
Corect answer: 	 It will not compile.


Note that there is no modifier for A's constructor. So it has default access.
This means only classes in package a can use it. Also note that class B is in a
different package and is extending from A. In B's constructor the compiler will
automatically add super() as the first line. But since A() is not accessible in B,
this code will not compile.
---------------------------------------------------------------------------------------------------
What will the following program print?

interface Flyer{
}

class AirPlane implements Flyer{
}

public class TestClass {

  static void flyIt(Flyer f){
    System.out.println("Flyer Flying");
  }

  static void flyIt(AirPlane a){
    System.out.println("AirPlane Flying");
  }

  public static void main(String[] args){
     Flyer f = new AirPlane();
     AirPlane a = new AirPlane();
     flyIt(f);  //1
     flyIt(a);  //2
  }
}

You had to select 1 option(s)
Flyer Flying
AirPlane Flying

AirPlane Flying
AirPlane Flying

Flyer Flying
Flyer Flying

Line marked //1 will fail to compile.

Line marked //2 will fail to compile.

Both the lines marked //1 and //2 will fail to compile.

Corect answer: Flyer Flying
               AirPlane Flying
When the compiler looks at a method call, it tries to find the method with a signature that matches

the arguments given in the method call. Since the compiler does not know the exact object type that
will be pointed to by a variable at runtime, it matches the signature based on the declared type
of the variable only. Once found, it binds the call to that method. Note that, at this point,
the compiler is not bothered with overriding as much as overloading.

Now, in the given question, compiler binds the flyIt(f) call to Flyer's flyIt method because
the declared type of f is Flyer, and it binds the flyIt(a) call to AirPlane's flyIt method
because the declared type of a is AirPlane. Therefore, Flyer Flying and AirPlane Flying are printed.
---------------------------------------------------------------------------------------------
What will be the result of attempting to compile and run class B?


class A{
   final int fi = 10;
}
public class B extends A{
   int fi = 15;
   public static void main(String[] args){
       B b = new B();
       b.fi = 20;
       System.out.println(b.fi);
       System.out.println(  (  (A) b  ).fi  );
   }
}

You had to select 1 option(s)
It will not compile.
It will print 10 and then 10
It will print 20 and then 20
It will print 10 and then 20
It will print 20 and then 10
Corect answer:  It will print 20 and then 10
Note that a final variable can be hidden. Here, although fi in A is final, it is hidden by fi of B.
So b.fi = 20; is valid since B's fi is not final.
-------------------------------------------------------------------------------------------------------
What will the following code print when compiled and run?

class Base{
   void methodA(){
      System.out.println("base - MethodA");
   }
}

class Sub extends Base{
   public void methodA(){
      System.out.println("sub - MethodA");
   }
   public void methodB(){
      System.out.println("sub - MethodB");
   }
   public static void main(String args[]){
      Base b=new Sub(); //1
      b.methodA(); //2
      b.methodB(); //3
   }
}

You had to select 1 option(s)
sub - MethodA and sub - MethodB
base - MethodA and sub - MethodB
Compile time error at //1
Compile time error at //2
Compile time error at //3
corect answer: 	 Compile time error at //3
The point to understand here is, b is declared to be a reference of class Base and methodB() is
not defined in Base. So the compiler cannot accept the statement b.methodB() because it only
verifies the validity of a call by looking at the declared class of the reference.

For example, the compiler is able to verify that b.methodA() is a valid call because class Base
has method methodA. But it does not "bind" the call. Call binding is done at runtime
by the jvm and the jvm looks for the actual class of object referenced by the variable before
invoking the method.
----------------------------------------------------------------------------------------------------
What will the following class print ?

class InitTest{
   public static void main(String[] args){
      int a = 10;
      int b = 20;
      a += (a = 4);
      b = b + (b = 5);
      System.out.println(a+ ",  "+b);
   }
}

You had to select 1 option(s)
It will print 8, 25
It will print 4, 5
It will print 14, 5
It will print 4, 25
It will print 14, 25
Coret answer: It will print 14, 25
a += (a =4) is same as a = a + (a=4).
First, a's value of 10 is kept aside and (a=4) is evaluated. The statement (a=4) assigns 4 to a
and the whole statement returns the value 4. Thus, 10 and 4 are added and assigned back to a.

Same logic applies to b = b + (b = 5); as well.
--------------------------------------------------------------------------------------------------------
What will the following program print?

class LoopTest{
    public static void main(String args[]) {
        int counter = 0;
        outer:
        for (int i = 0; i < 3; i++) {
            middle:
            for (int j = 0; j < 3; j++) {
                inner:
                for (int k = 0; k < 3; k++) {
                    if (k - j > 0) {
                        break middle;
                    }
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}

You had to select 1 option(s)
2
3
6
7
9
correct answer: 3
To understand how this loop works let us put some extra print statements in the innermost loop:
System.out.println("i="+i+" j="+j+" k="+k);
if(k-j>0){
     System.out.println("breaking middle "+j);
     break middle;
}
counter++;
This is what it prints:
i=0 j=0 k=0
i=0 j=0 k=1
breaking middle 0
i=1 j=0 k=0
i=1 j=0 k=1
breaking middle 0
i=2 j=0 k=0
i=2 j=0 k=1
breaking middle 0
3
The key is that the middle loop is broken as soon as k-j becomes > 0. This happens on every
 iteration of inner loop when k is 1 and j is 0. Now, when middle is broken inner cannot
continue. So the next iteration of outer starts.
-----------------------------------------------------------------------------------------------------
Consider the following code snippet:

    for(int i=INT1; i<INT2; i++){
        System.out.println(i);
    }

INT1 and INT2 can be any two integers.

Which of the following will produce the same result?

You had to select 1 option(s)


for(int i=INT1; i<INT2; System.out.println(++i));
Prints: 2 and 3

for(int i=INT1; i++<INT2; System.out.println(i));
Prints: 2 and 3

int i=INT1; while(i++<INT2) { System.out.println(i); }
Prints: 2 and 3

int i=INT1; do { System.out.println(i); }while(i++<INT2);
Prints: 1 2 and 3

None of these.

correct answer: None of these.
In such a question it is best to take a sample data such as INT1=1 and INT2=3 and execute
the loops mentally. Eliminate the wrong options. In this case, the original loop will print:

=====ORIGINAL ====
1

2

Outputs of all the options are given above (Ignoring the line breaks).

Thus, none of them is same as the original.
----------------------------------------------------------------------------------------------------
Which of these are valid expressions to create a string of value "hello world" ?

You had to select 3 option(s)
1- " hello world".trim()
trim() removes starting and ending spaces.


2- ("hello" + new String("world"))
It will create helloworld. No space between hello and world.

3- "hello".concat(" world")

4- new StringBuilder("world").insert(0, "hello ").toString();

5- new StringBuilder("world").append(0, "hello ").toString();
1. append adds the argument to the end.
2. It doesn't take an int as its first argument.

6- new StringBuilder("world").append("hello ", 0 , 6).toString();
There is an append method that takes two ints as shown here but the int parameters are
to determine the portion of the String that is to be appended to the target.
That portion will still be appended to the end of the target.

7- new StringBuilder("world").add(0, "hello ").toString();
There is no add method in StringBuilder.

Correct answer: 1,2,3
---------------------------------------------------------------------------------------------------
StringBuilder Methods:
StringBuilder is mutable, meaning you can modify its contents without creating new objects each time.

append(): Adds text to the end of the current StringBuilder object.

java
Copy
Edit
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);  // Output: Hello World
insert(): Inserts text at a specified position.

java
Copy
Edit
StringBuilder sb = new StringBuilder("Hello");
sb.insert(5, " World");
System.out.println(sb);  // Output: Hello World
delete(): Removes a substring from a StringBuilder.

java
Copy
Edit
StringBuilder sb = new StringBuilder("Hello World");
sb.delete(5, 11);
System.out.println(sb);  // Output: Hello
reverse(): Reverses the contents of the StringBuilder.

java
Copy
Edit
StringBuilder sb = new StringBuilder("Hello");
sb.reverse();
System.out.println(sb);  // Output: olleH
toString(): Converts the StringBuilder to a String.

java
Copy
Edit
StringBuilder sb = new StringBuilder("Hello");
String str = sb.toString();
System.out.println(str);  // Output: Hello
String Methods:
String is immutable, meaning once it’s created, it cannot be changed.

concat(): Combines two strings into one.

java
Copy
Edit
String str = "Hello";
str = str.concat(" World");
System.out.println(str);  // Output: Hello World
substring(): Extracts a part of the string.

java
Copy
Edit
String str = "Hello World";
String substr = str.substring(0, 5);
System.out.println(substr);  // Output: Hello
replace(): Replaces a substring with another string.

java
Copy
Edit
String str = "Hello World";
str = str.replace("World", "Java");
System.out.println(str);  // Output: Hello Java
trim(): Removes leading and trailing spaces.

java
Copy
Edit
String str = "  Hello World  ";
str = str.trim();
System.out.println(str);  // Output: Hello World
toLowerCase() / toUpperCase(): Converts the string to lowercase or uppercase.

java
Copy
Edit
String str = "Hello World";
System.out.println(str.toLowerCase());  // Output: hello world
System.out.println(str.toUpperCase());  // Output: HELLO WORLD
split(): Splits the string based on a delimiter.

java
Copy
Edit
String str = "Hello World";
String[] parts = str.split(" ");
System.out.println(parts[0]);  // Output: Hello
System.out.println(parts[1]);  // Output: World
----------------------------------------------------------------------------------------------------
Which of the following comparisons will yield false?

You had to select 3 option(s)

1-Boolean.parseBoolean("true") == true

2-Boolean.parseBoolean("TrUe") == new Boolean(null)
This will yield false because parseBoolean("TrUe") will return true and new Boolean(null)
will return a Boolean wrapper object containing false.

3-new Boolean("TrUe") == new Boolean(true)
Even though both the sides have a Boolean wrapper containing true, the expression will yield
false because they point to two different Boolean wrapper objects.

4-new Boolean() == false
This will not compile because Boolean class does not have a no-args constructor.

5-new Boolean("true") == Boolean.TRUE
Even though both the sides have a Boolean wrapper containing true, the expression will yield false
because they point to two different Boolean wrapper objects.

6-new Boolean("no") == false
Any string other than "true" (ignoring case) will produce a Boolean containing false.
Therefore, this expression will yield true.

 Correct answer:   2,3,5
You need to remember the following points about Boolean:

1. Boolean class has two constructors - Boolean(String) and Boolean(boolean)
The String constructor allocates a Boolean object representing the value true if the string
    argument is not null and is equal, ignoring case, to the string "true". Otherwise, allocate
    a Boolean object representing the value false. Examples: new Boolean("True") produces a Boolean
    object that represents true. new Boolean("yes") produces a Boolean object that represents false.

The boolean constructor is self explanatory.

2. Boolean class has two static helper methods for creating booleans - parseBoolean and valueOf.
Boolean.parseBoolean(String ) method returns a primitive boolean and not a Boolean object
            (Note - Same is with the case with other parseXXX methods such as Integer.parseInt
                    - they return primitives and not objects). The boolean returned represents
    the value true if the string argument is not null and is equal, ignoring case,
    to the string "true".

Boolean.valueOf(String ) and its overloaded Boolean.valueOf(boolean ) version, on the other hand,
    work similarly but return a reference to either Boolean.TRUE or Boolean.FALSE wrapper objects.
    Observe that they dont create a new Boolean object but just return the static constants TRUE or
    FALSE defined in Boolean class.

3. When you use the equality operator ( == ) with booleans, if exactly one of the operands is
    a Boolean wrapper, it is first unboxed into a boolean primitive and then the two are compared
            (JLS 15.21.2). If both are Boolean wrappers, then their references are compared just
    like in the case of other objects. Thus, new Boolean("true") == new Boolean("true") is false,
    but new Boolean("true") == Boolean.parseBoolean("true") is true.
----------------------------------------------------------------------------------------------------
Which of the following statements will evaluate to true?

You had to select 1 option(s)

1-"String".replace('g','G') == "String".replace('g','G')
replace creates a new string object.

2-"String".replace('g','g') == new String("String").replace('g','g')

3-"String".replace('g','G')=="StrinG"
replace creates a new string object.

4-"String".replace('g','g')=="String"
The API desciption of replace(char oldChar, char newChar) does not specify whether this method
returns the same String object if oldChar is the same as newChar.
Although Oracle's JDK does return the same string and this expression returns true,
this behavior cannot be relied upon.

5-None of these.
Correct answer: 5-None of these.


 */

}











