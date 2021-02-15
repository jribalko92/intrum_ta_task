# Test automation solution for website testing

## Overall information
This framework is written in Java. It implements particular website acceptance tests, written using [Gherkin] syntax, that can be executed in different ways: 
* in different browsers; _(currently have support for Chrome and Firefox only)_
* on different operating systems; _(initial configuration done, should be completed based on project needs)_
* both remotely and locally; _(initial configuration done, should be completed based on remote tool configuration)_

PageObject design patterns is used to enhance test maintenance and reduce code duplication. It is used together with PageFactory concept for page objects initialization.

## Dependencies

* [Selenium] - Test automation framework
* [Cucumber] - Tool for specification implementation
* [Courgette] - extension of Cucumber-JVM with added capabilities (parallel execution, failed tests rerun)
* [JUnit5] - Unit testing framework, also used for assertions
* [Lombok] - Java library that provides additional features to make code writing easier
* [WebDriverManager] - automated Selenium WebDriver management tool
* [Google Guice] - DI framework
* [Awaitility] - DSL for expressing expectations  operations of an asynchronous system
* [Gradle] - build automation system

## Structure

* properties - application, different accesses and url properties
* src/main/java
    * src/main/java/config - driver configuration and properties configuration
    * src/main/java/constants - properties constants
    * src/main/java/dataObjects - data objects to manage test data during tests execution
    * src/main/java/enums - browsers constants
    * src/main/java/exceptions - custom exception classes
    * src/main/java/helpers - helper functions
    * src/main/java/hooks - before/after scenario or step actions
    * src/main/java/utils - special utilities
* src/main/resources - different resources directory, at the moment contains csv data for tests
* src/test/java
    * src/test/java/pageObjects - object-oriented classes, that describe webpages/forms
    * src/test/java/steps - steps classes, that describe user behaviour on webpages/forms
    * src/test/java/TestRunner.java - class for tests execution
* src/test/resources/features - feature files with scenarios

## Configuration
In order to use framework you need to:
* Install Lombok Plugin
```
Preferences ->  
Plugins-> 
Type "Lombok Plugin" in search -> 
Choose "Lombok Plugin" -> 
Install -> 
Restart IntelliJ
```

* Enable annotation processing
```
Preferences ->  
Build, Execution, Deployment -> 
Compiler -> 
Annotation Processors -> 
Check "Enable annotation processing"
```

## Execution
There are few options for test execution. Please find more detailed info foe each option below.

### Commandline

To run tests from commandline, execute command from projects root directory:

`./gradlew runTests`

There is also possibility to change different parameters for test execution: 

* -DdefaultTimeout, -Dbrowser, -Dremote, -Dos (e.g. `./gradlew runTests -DdefaultTimeout=5 -Dbrowser=firefox`) _NOTE: there is no point in changing remote and os properties at the moment, as they are not properly configured in this project yet._

* Courgette parameters (e.g. we can increase rerun attempts count, as it is 1 per default: `./gradlew runTests -DdefaultTimeout=5 -Dcourgette.rerunAttempts=2`

* Cucumber tags (e.g. `./gradlew runTests -DdefaultTimeout=5 -Dcucumber.tags="@ContactForm" -Dcourgette.rerunAttempts=2`)

### Test Runner

You can also execute tests using Test Runner that is located at `src/test/java/TestRunner.java`.
_NOTE: Courgette runs each test in a separate JVM so debugging is not possible. You will need to use the Cucumber IDE plugin and execute scenario directly from feature file to enable debug._ 

## Reporting

After tests execution report is created in repo: `build/courgette-report`.

[Selenium]: <https://www.selenium.dev/>
[JUnit5]: <https://junit.org/junit5/>
[Google Guice]: <https://github.com/google/guice/>
[Awaitility]: <https://github.com/awaitility/awaitility/>
[Allure]: <http://allure.qatools.ru/>
[Gradle]: <https://gradle.org/>
[Gherkin]: <https://cucumber.io/docs/gherkin/>
[Cucumber]: <https://cucumber.io/>
[Courgette]: <https://github.com/prashant-ramcharan/courgette-jvm>
[Lombok]: <https://projectlombok.org/>
[WebDriverManager]: <https://github.com/bonigarcia/webdrivermanager>
