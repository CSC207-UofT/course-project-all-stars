# Overview
	A description of any major design decisions your group has made (along with brief explanations of why you made them).



# SOLID
	A brief description of how your project is consistent with the SOLID design principles (if you notice a violation and aren't sure how to fix it, talk about that too!)
>**Single Responsibility Principle (SRP):**

The Single Responsibility Principle states that every class should have a single responsibility over the program’s functionality. We have incorporated this principle in our program by dividing the functionality of Doctor class into their respective subclasses so that each child class is responsible for their respective tasks. For example, the Oncologist class is a subclass of the Doctor class that is specialized in Oncology and can cure Cancer.
**![](https://lh6.googleusercontent.com/KPzNI_OrpIde0LieSGdqXxn74S7JO3xvqFzm7whuG6bjfgJjQjOpeEZOQ-90qzFkUIMwYCqyByDwXhRrsil2DQ6Wo0-GogxL5MaksZToMv2lJt6y-yaIWa2X5aPPMLOP4RPlo1G-)**
>**Open/Closed Principle (OCP):**

The Open/Closed Principle states that classes should be open for extension, but closed for modification. We have incorporated this principle in our program by making instance variables private, as well as creating getter and setter methods where necessary.

>**Liskov Substitution Principle (LSP):**

The Liskov Substitution Principle states that an object of the superclass must be interchangeable with objects of its subclasses without breaking the application. We have incorporated this principle in our codebase by having our entity subclasses be substituted by their parent classes. For example, our Doctor class has no more behaviours than its subclasses specialisations. Hence, we could replace Neurologist with Doctor, and it would not break our program.

>**Interface Segregation Principle (ISP):**

The Interface Segregation Principle states that interfaces should be kept small so that other classes that depend on it are not forced to implement methods that are irrelevant. We have incorporated this principle in our program by creating small and specific interfaces so that classes that implement the interface will not have to override any redundant methods. For example, the DataInterfaceCloud interface contains only a ResultSet method to be overridden.

>**Dependency Inversion Principle (DIP):**

The Dependency Inversion Principle states that the inner layers of the program should not depend on the outer layers of the program. We have incorporated this principle in our program by creating interfaces as an abstraction layer. For example, the PatientArrayList class interacts with the DataInterfaceCloud interface, which is overridden by the PatientDatabaseCloud class.

# **Clean Architecture**
	A brief description of how your project adheres to Clean Architecture (if you notice a violation and aren't sure how to fix it, talk about that too!)

Our program also follows the Clean Architecture, so that the system can be easily developed around and maintained in the future. The program is divided into 4 separate layers (from inner layers to outer layers):

-  Entities (e.g. Doctors and Patients)

-  Use Cases (e.g. Retrieving Patient Information, Curing Patients)

-  Controllers, Gateways, Presenters (e.g. CLI Controller, Hospital Manager)

-  User Interface, Database, External Interface, Web (e.g. Cloud Database, CLI Presenter)

Therefore, our model satisfied the specifications while adhering to a clean design. Our project cards follow Clean Architecture layers with Entities for the different use cases, controllers and the datasets that users can access and load through added phase 2 features.

# Design Patterns
	A summary of any design patterns your group has implemented (or plans to implement).

### Facade Design Pattern:

The Facade Design Pattern was implemented so that a single facade class can be used to call on methods from other classes. This design pattern allows us to hide the complexities of different CLI menus behind their respective CLI concrete classes.


### Factory Design Pattern:
N/A
# Packaging
	A brief description of which packaging strategies you considered, which you decided to use, and why. (see slide 7 from the packages slides)

In the packaging by feature strategy, each package contains the classes related to that particular feature. In our program, we incorporated this strategy by having each package name correspond to a significant high-level aspect of our hospital management app.

We believe that a package should be a logical grouping of classes and functions. For example our program had these packages: priority, affliction, cli, database, diagnosis, and so on.

A typical directory structure of a package in our project looks like this:

	projectname - src - Person - Doctor

In which case, the Person package has many use cases within it and grouping them into a package was most sensible. By allowing us some freedom we could decide which category would perform best with particular usage situations. Another instance would be our package named priority, which contains all the classes and interfaces related to priority queues in our application.

From a version control perspective, the task distribution according to this packaging proved useful when each person was working on a feature in their branch. We believe this use is most effective for our work because within every high-level aspect, there are many use cases.



### Credits
#### (c) Roa, Ernest