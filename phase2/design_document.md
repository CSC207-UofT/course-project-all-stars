# Overview
	A description of any major design decisions your group has made (along with brief explanations of why you made them).

The status of all subsequent important design decisions is **approved**, **finalized**, and **passed** to the repository by **all** group members. In the following paragraphs, we can speak the _problems_ that inspired our _decisions_, the _modifications_ we've proposed and implemented, as well as their _implications_.

As a result of the **package improvements** from Phase 1, we were able to repurpose many aspects of the program's functionality and design. Most of these are extensions of previous use cases, controllers, and interfaces built in the previous phase, which makes packaging much easier.

The **primary end user** is now the **hospital administrator** instead of _doctors_ -as was the case in previous phases. The **overall purpose** of the program now is to **enable hospital administrators** to better _manage medical professionals_ and _their patients_ in order to **diagnose** and **treat** various ailments more _efficiently_ until **discharge**.

The **Early Diagnosis** feature is now used as a **guide** for **administrators** to **designate an** appropriate **specialist,** rather than a **conclusion that** doctors **themselves can use.** This **is because** building a diagnostic tool required an engine based on natural language processing and machine learning libraries that were difficult to plug into Java programs without using Jython (a Python implementation for Java). To _mitigate the impact_ of a diagnosis engine absence while **maintaining** **accuracy** and **precision**, 240 data points(conditions and their three respective symptoms) were added from **UMLS** or Unified Medical Language System and manually **matched with physicians** of various specialties.

After phase 1, the group made the _tough decision_ to opt for a **sophisticated CLI** over a _web application_ due to the **time and know-how constraints** of the Spring framework. This is to allow the team to **add functionality** while having our main concern and **emphasis be on the design** of the overall program rather than _creating exceptional UI_. Despite concerns regarding the application of the **Seven Design Principles**, which will be discussed in detail in the Accessibility report, this has been the **best course of action** at this **stage of development**.

One of the most important adjustments in Phase 2 was the addition of **more** **functionality** **related to** **increasing** **scope** related to expanding **support for multi-hospital networks**. With that in mind, we previously sought to **separate trivial CLI responsibilities**. The CLI package now contains a separate set of controllers and presenters. This was achieved by using the **Facade Design Pattern** described in the latter part of the document.

In this vein, we have worked on separating responsibilities of our previously trivial CLI. Our Simulation package now contain a set of separate controllers and presenters. This was **achievable through** the application of the **Facade Design Pattern**, which will be discussed in the latter part of the document. However, we ended up fending off different design patterns inclusive of **Factory** **Design Pattern** due to having more than one variation of the same object.

**All the above** will be **discussed in depth** throughout the rest of the design document in each of _its respective section_.


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
**![](https://lh6.googleusercontent.com/tsx7-LjkFeZ0PkJ865nkVM-TfMJ9DNNgnZOaKCTy50O6PjwqDkVP5Gc-Zlx6mddf0jfnHtywumX_fLbYfC3xZqyIueTIBW2OYXWA_opPglvKb3pS5fZeVd5cmq0wLaY18A2z8hNz)**
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

The Facade Design Pattern was implemented so that facade classes can be used to call on methods from other child classes. This design pattern allows us to hide the complexities of different CLI menus behind a facade class. For example, the Homepage class calls on CreateHospital class, ManageHospital class, SelectHospital class, and ViewProgramDetails. This makes adding additional CLI menus much easier if we ever plan to introduce new functionalities or menus in the future.

As for the other design patterns, we were unable to apply in other parts of our codebase. For example, we have tried to use the Factory Design Pattern to create a factory class that initializes and creates patients. However, Factory Design Pattern should only be used if there are multiple different objects and not multiple variations of the same object but with different instance attributes. As a result, Factory Design Pattern cannot be applied for the creation of Patient objects.


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