package chapter1_buildingblocks;

public class CompileRunAndArchiveJavaFiles {
   /*
   Compiling code with packages:
• First class:
            • C:\com\ udemy\ocppackage\Ocp.java (windows)
            • /com/udemy/ocppackage/Ocp.java (*nix)

            • Second class:
            • C:\com\ udemy\ocapackage\Oca.java (windows)
            • /com/udemy/ocapackage/Oca.java (*nix)

            • Take the common-ground position:
            • cd C:\com\ udemy (windows)
            • cd /com/udemy (*nix)
-----------------------------------------------------------------------------------------------------
// what if we want classes in another directory?
javac -d classes ocppackage/Ocp.java ocapackage/Oca.java

// three ways to run Ocp application:
java -cp classes ocppackage.Ocp
java -classpath classes ocppackage.Ocp
java --class-path classes ocppackage.Ocp

// our application depends on other files to run
// some of files are in package "deps", and some are in myJar.jar

java -cp ".;C:\com\ udemy\deps;C:\com\ udemy\myJar.jar" myPackage.MyApp
java -cp ".:/com/udemy/deps:/com/udemy/myJar.jar" myPackage.MyApp

// if you have many jars in a folder, you can use wildcards:
java -cp ".;C:\com\ udemy\myjars\*" myPackage.MyApp
java -cp ".:/com/udemy/myjars/*" myPackage.MyApp

// N.B. wildcards doesn't include subfolders !!
--------------------------------------------------------------------------------------------------
// create your own jar file (from files in current folder)
jar -cvf myNewJarFile.jar .
jar --create --verbose --file myNewJarFile.jar .

// create your own jar file (from files in custom folder)
jar -cvf myNewJarFile.jar -C myFolder
jar --create --verbose --file myNewJarFile.jar -C myFolder
----------------------------------------------------------------------------------------------------

    */
}
