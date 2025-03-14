package chapter1_buildingblocks;

public class Packages {
    /*
    Packages:
• Java classes are stored in different packages
• you can think of them as folders in which the classes are stored
• in order to use a class, you must import a package in your program
• name of the package usually looks something like
• com.udemy.javacourse.ocp
• this means that there is a folder "com", in which there is a subfolder
"udemy", with subfolder "javacourse", with subfolder "ocp" containing
classes
• exam creators like to use more generic names like a.b.c
----------------------------------------------------------------------------------------------------
// using wildcards
import java.util.Random      // imports class Random
import java.util.*          // imports all classes in java.util package
                            // but not in subpackages (subfolders) !!
import java.util.*.*.      // DOES NOT COMPILE

// conflicts
import java.util.Date;
import java.sql.Date;    // DOES NOT COMPILE

// solution
import java.util.Date;
import java.sql.*;     // Java will use java.util.Date
--------------------------------------------------------------------------------------------------------
// using custom packages

package com.udemy.oca   // corresponds to a folder (must be in the first line!)
public class Oca { }

package com.udemy.ocp  // another folder
import com.udemy.oca;
public class Ocp {
   Oca myOcaInstance = new Oca();
}

     */
}
