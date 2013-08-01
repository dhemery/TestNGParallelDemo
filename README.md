TestNGParallelDemo
==================

Demonstrate that TestNG 6.8.5 may run different methods in a single class on different threads

This test consists of seven test classes.
Each class has two methods,
one of which depends on the other.
Each method records and prints the name of its thread.
After each class runs,
an @AfterClass method prints the list of threads
used to run the class's methods.

The testng.xml file specifies that the tests are to be run in parallel by class,
using three threads.
According to the TestNG documentation,
every method in a given class
should run on the same thread.

As the printout demonstrates,
for some classes,
the two test methods run on different threads.

Here is a sample printout:

````
   [testng] TestClass03.freeMethod() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass02.freeMethod() running on thread Thread[pool-1-thread-2,5,main]
   [testng] TestClass01.freeMethod() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass04.freeMethod() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass05.freeMethod() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass06.freeMethod() running on thread Thread[pool-1-thread-2,5,main]
   [testng] TestClass07.freeMethod() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass03.dependentMethod() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass01.dependentMethod() running on thread Thread[pool-1-thread-2,5,main]
   [testng] TestClass02.dependentMethod() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass03.afterClass() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass01.afterClass() running on thread Thread[pool-1-thread-2,5,main]
   [testng] TestClass03 ran on threads: [Thread[pool-1-thread-3,5,main], Thread[pool-1-thread-1,5,main]]
   [testng] TestClass01 ran on threads: [Thread[pool-1-thread-2,5,main], Thread[pool-1-thread-1,5,main]]
   [testng] TestClass02.afterClass() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass02 ran on threads: [Thread[pool-1-thread-2,5,main], Thread[pool-1-thread-3,5,main]]
   [testng] TestClass04.dependentMethod() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass05.dependentMethod() running on thread Thread[pool-1-thread-2,5,main]
   [testng] TestClass04.afterClass() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass04 ran on threads: [Thread[pool-1-thread-3,5,main], Thread[pool-1-thread-1,5,main]]
   [testng] TestClass05.afterClass() running on thread Thread[pool-1-thread-2,5,main]
   [testng] TestClass05 ran on threads: [Thread[pool-1-thread-2,5,main], Thread[pool-1-thread-1,5,main]]
   [testng] TestClass06.dependentMethod() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass07.dependentMethod() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass06.afterClass() running on thread Thread[pool-1-thread-3,5,main]
   [testng] TestClass06 ran on threads: [Thread[pool-1-thread-2,5,main], Thread[pool-1-thread-3,5,main]]
   [testng] TestClass07.afterClass() running on thread Thread[pool-1-thread-1,5,main]
   [testng] TestClass07 ran on threads: [Thread[pool-1-thread-3,5,main], Thread[pool-1-thread-1,5,main]]
````
