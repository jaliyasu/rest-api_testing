# About the Framework 
This Maven application which has been developed using Spring boot,Cucumber and Junit. Due to the use of Gherkin language which increases the readability of the test cases and moreover best practices are used in here to improve  the re-usability,maintainability simplicity, etc.



### Pre-Requisite to run the application 
* `Java` 1.8
* `Maven` Installation and configure MVN_HOME 

### How to run the test

* You need to dowload the master branch.
* As of now application expects to provide environment type (VM option) that tester wish to run against.( e.g -DENV=local). 
  Further more bootstrap application has defined what type of test it could run (smoke,regression,BVT(business verification  -check tags = { "@BVT" } in BVT Tests class.
* Then traverse in to folder of `assurity_testcodea` and then you can issue given command in the console. - `mvn clean install -DENV=local -Dtest=BvtTests test` 
* After the execution of all test cases test result report is generated under target\cucumber-html-report folder. 

