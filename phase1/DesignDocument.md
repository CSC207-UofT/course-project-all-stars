# Welcome to the AllStars Design Document!

## Specification

This is a  *Hospital Management System* that essentially helps the end users (**doctors**) track their patients and monitor their diagnosis as well as treatment. The current version is based on an earlier text-based application with a command line interface. The app should be designed in such a way that it can run as a web application. The end-user should be able to do the following: 

	Manage patient data
	Record history of patients
	Keep track of and display hospital staff information
	Diagnose and Treat patients
	View patient details and demographics
	View hospital details
	View doctor details
	Quit the app

Features:
-   `Patient triage`
-   `Diagnosis based on likelihood`
-   `Critical condition isolation`
-   `Specialist qualification match to disease`

Diagnosis is performed using symptoms from the set of matches between what the patient is presenting as and the symptoms of each disease in the datasets. The dataset is made up of about 25 diseases, each with 3 symptoms. It is made up of data from the UMLS (Unified Medical Language System) and the National Library of Medicine's symptoms ranker. Patients can be transferred to other hospitals, and there is a patient admission, treatment and discharge system. Patients and diseases are generally uploaded by text file. The user can open some specific Patient information from within the main Home screen of the App, which may include Personal Information like name, birthdate, insurance status and symptoms. At least one user interface for diagnosing diseases will need code or configuration changes aside on specific uses like matching symptoms as well as specialists who treat same condition which requires monitoring several sets of data.

### Phase 1 scope-appropriate extensions
> - Diversify patient triage strategies
> - Covid-specific interface as a critical condition
> - Matching doctors in different specialisation with diseases they cure
> - Integrated cloud SQL Database

### Phase 2 scope-appropriate extensions

> - Treating patients via likelihood of diseases instead of a single disease
> - Randomly searching for patients to treat
> - Quarantine system for patients with infectious diseases
> - Authentication process: We will also need to provide a way for the user to sign up for the Patient's portal and to be able to login. We will need to ensure that all the data is secured, including the doctor/patient's email address and password.
> - Send patients to the lab for tests and scans
> - Elimination process based on test and scan results
> - Treat patients with the appropriate medication
> - Track patient progress and appointment booking
> - Engine for treatment plans and resources
> - Patient data may include medical history, medication, allergies and laboratory results. This data will be available to users with an appropriate permission-based architecture.

## Major design decisions / Design patterns.

	The majority of decision-making for the application occurred in Phase 1 while determining a realistic scope. 

Our goal in Phase 0 was to make as few decisions as possible. *Less upfront implementation* means *less code refactoring* on components no longer relevant to the actual scope of the application & *more flexibility and focus spent on design* elements that may be necessary. 

* We've been shifting towards a more SOLID architecture and following cleaner practices in order to work with an easy-to-maintain codebase.

In this phase, we've tried to follow best practices with a bit more depth than before. We found that our decisions had less to do with the UI and more to do with the backend functionality. 

	The design decisions were quick and easy due to the support of Phase 0.

Phase 1 of the project is now completed and we’ve been able to add a lot of new features and improve the functionality of some phase 0 others. 

*The new features we’ve added in this phase will be rolled out in phases 2.* 

Phase 1 had a focus on implementing more new features and packaging improvements before we finalise refactoring and restructuring the architecture for phase 2. 

	We decided to migrate the project to a web application for phase 1. 
We were able to repurpose some of the functionality built in phase 0 to meet the needs of doctors from various different specialties -with the expectation of adding more in the final product. We then focused on implementing new features and adding functionality in the meantime. Most of which were extensions on previous use cases, controllers and interfaces built in phase 0, which the packaging makes fairly straightforward. 

We modelled our code around the phase 0 text UI, which was a basic command line interface, based on how we plan to implement the UI in the web application. This way, when we work on the front end of our web application, we re-use most of the code in phase 1 for the backend. 

Although we were having issues setting up the cloud SQL Database as there were time constraints, **the cloud database is now complete and completely integrated into the code.**

## SOLID/Clean Architecture (if you notice a violation and aren't sure how to fix it, talk about that too!)

	It was important in phase 0 to have CRC cards that outline each class and were implemented such that each has a single duty. 

Therefore, our model satisfied the specifications while adhering to a clean design. Our project cards follow Clean Architecture layers with Entities for the different use cases, controllers and the datasets that users can access and load through added phase 1 features.

By following the clean architecture approach to building our packages, we were able to structure our code in a way that promotes reuse. By dividing our packages by the purpose of each package rather than the functionality, we created packages that are more reusable and do not cause violations.

Within each package we adhered to clean architecture. Rather than having our packages divided by use case we divided them by relevance to each other, and within the packages we enlisted clean architecture to divide use cases. We chose to create our packages by relevance because it's easier to ensure that each package has the code needed for its purpose. This made it easier to determine what methods belong in a package and what should be moved elsewhere.
To make changes, our architecture was designed so that the effects of most changes aren't affecting other phase 1 packages. This means that there are at least as many "uses" of a specific method in a phase 1 package now – if not more – as we had used in phase 0. 

	These observations show us reusability is key when we expand functionality in a clean manner.

For example in the Person package we have abstract entities divided from connections with databases. Patient and PatientArrayList are separated because they engage a different use case. Not every package has every level of use case because not every function engages every use case.

By breaking down the functionalities within the Patient object into their respective classes, it made it easier for me to add new features to the patient objects. This is because each class contained only one responsibility, which made sense given that this is a Single Responsibility Principle.

## Packaging strategies

In the beginning, we were unsure of how to organize our packages. We had no guidelines or standards to follow in phase 0 but it was straightforward to come up with a solution that worked for us in phase 1. Our first attempt was organizing our packages by category, but this proved unsustainable where task management is based off of features.

We believe that a package should be a logical grouping of classes and functions. This thought process made it easier for all members to find the code they are looking for and to reduce the amount of clutter in our codebase. 

We chose ***packaging by feature*** and organized our packages along their respective features, however they may relate to end users (doctors), or hospitals, or the databases for our project. 

As mentioned above the Person package has many use cases within it and grouping them into a package was most sensible. By allowing us some freedom we could decide which category would perform best with particular usage situations. Our packages are also named after the features they contain. For example, our package named “Priority” contains all of the code related to priority queues in our application. This packaging structure allows us to be more flexible in the future.

A typical directory structure of a package in our project looks like this: 
	
	projectname - src - Priority - PriorityAdmission

From a version control perspective, the task distribution according to this packaging proved useful when each person was working on a feature in their branch. We believe this use is most effective for our work because within every abstract “idea” there are many use cases. 


##  Progress Report

### Open questions your group is struggling with,

- How to organize ourselves to effectively complete tasks on time and motivate open and active communication in our group?
- We're not sure when to merge the branches that we're working on back to the Main branch.

- How would an interface appropriate extend a class while following the SOLID principles?


### What has worked well so far with your design?


Breaking down the functionalities within the _**Patient class**_ into their respective classes (Single Responsibility Principle) made the process of adding new features to Patient objects a lot easier. Creating a new _**Database interface**_ also made it easier in the future to change the type of database we plan to use without interrupting the classes from other packages (Dependency Inversion Principle)
The way we used packages is very clear and allows for easy delegation of tasks and development. We can easily see what needs to be done where and git operations are also ameliorated by this process.


###  Brief summary of what each group member has been working on and plans to work on next.

Teammate 1: Ernest

PatientAdd class, and DatabaseInterface, and PatientDatabaseText. 
Person class is an abstract class responsible for outlining the characteristics of a Person object (e.g. Patient and Doctor). PatientArrayList class is responsible for reading patient information from a database and return an ArrayList containing all the Patient objects. PatientAdd class is responsible for writing patient information into the database. DatabaseInterface is an interface responsible for outlining the implementation of database so that the type of database used (e.g. LinkedList, .csv) does not matter. DatabasePatientText is a concrete class that overrides the methods outlined in DatabaseInterface that reads and writes data off a text based database.

Person 2: Euan

Euan has been working primarily with affliction and database packages since both are interrelated. I plan on expanding on affliction to include contagions and affliction container classes and controllers for contagions. In pursuit of this I will work more closely with the simulation code and integrate the contagions into this.


Person 3: Shysta

Shysta worked on the Priority package with Justice. She implemented the template method design pattern for the algorithm used for adding patients in the priority queues. Earlier, patients were being added to the lists in the subclasses PriorityAdmission and PriorityTreatment. Now, most of the skeleton for the algorithm is in the abstract class priority with priority functions specific to admission and treatment being called in the subclasses. Along with that, she also extended the functionality of the package by adding an interface COVID and an admission class which implements this interface. This helps to prioritise patient admission triage according to COVID symptoms. She also refactored and reformatted the code. She also added tests which check if the patients are being added to the priority queues in the different subclasses correctly or not. Finally, she worked on helping other members of the group with diagnosis and other tests, along with checking for errors in different parts of the code. Future plans: Shysta wants to extend the functionality of the program to multiple hospitals instead of a single work, help with the UI, extend the functionality of priority queues to infectious diseases, and include more tests..

Person 4: Ratantej

-

Person 5: Alessandro

For Phase 1 I worked on the "person" branch, and specifically I worked on the Doctor class, the DoctorTest class and its subclasses.
In fact I modified Doctor by removing the specialization variable and by adding the "can_cure" variable and by modifying the method "treatPatient" and adding the method "LearnHowToCure".
After having done this, I created the subclasses of Doctor: Cardiologist, Neurologist, Psychiatrist and Oncologist and the correspondent testing classes (OncologistTest, CardiologistTest, PsychiatristTest, NeurologistTest).
In phase 2 in plan on working on Doctor and its subclasses by adding new diseases and new types of doctors and especially by varying more the "treatPatient" feature by distinguishing different kind of treatments for different diseases and by adding more complex cases.

Person 6: Justice

-   I continued my work on priority queues with Shysta. We expanded our functionality to allow for a new way of prioritizing that checks for covid symptoms, then health, then insurance. We also implemented the template design pattern, keeping the main Priority class as the template and feeding in different ways of prioritizing through higherPriority.
    
-   I documented all of the classes and methods within those classes, elucidating what each major piece does, what parameters associated with each do, and what any applicable method returns.


Person 7: Roa

Roa mainly worked on the diagnosis package, design document and doctor specialisations. She also helped with design decisions and compiled the progress report of all the active members. She plans on further expanding the functionality of diagnosis after the cloud database has been set up with a wider scope given larger sets of data. The data should ideally have many more symptoms and other parameters such as geolocation, medical history, medication, allergies and laboratory results. In this vein, a natural succession would be an engine for treatment plans and resources. The main next step Roa wants to take is to work on an authentication process for both end users doctors and patients in order to create links such as booking appointments and follow-up tests and scans. Roa also plans to contribute to the front end of the web application, which will provide the doctors and patients with a more user-friendly option to interact with our program.

