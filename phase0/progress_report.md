#  Progress Report

### A brief summary of your specification, CRC model, scenario walkthrough, and skeleton program,

> Specification

Our hospital management application allows the end user to view, treat, diagnose, and/or discharge patients that are admitted to the hospital.

> CRC Model

-   at least three entity classes,
-   at least two use case classes,
-   at least one controller,
-   and at least a basic command line interface.

Our CRC model has five  **Entities**  (Hospital, Patient, Person, Doctor, Affliction), three  **Use Cases**  (PriorityTreatment, PriorityAdmission, Container), one  **Controller**(Diagnosis), and one  **Drivers**  (CommandLineInterface).


> Scenario Walkthrough

Our treatment scenario walkthrough has the end user pick the patient at the top of the priority queue, in order to then proceed with the diagnosis. If the user wants to either admit or discharge the patient, they can proceed as they are subcommands of diagnosis. The user can then move on to the next patient on the priority queue. However, if they want to check another patient's chart, they need to go back to the main menu and bypass the priority ranks. If the user wants to view their hospital details, the program will display a statement regarding the hospital. The user can then choose to either go back to the main menu or quit the app entirely.

>Skeleton Program

Our Skeleton Program will be able to do the following

-   Create and store new patients charts based on priority
-   Diagnose based on symptom/disease matching
-   View hospital/patient details
-   More on the responsibilities on each CRC text cards

### Open questions your group is struggling with,

-   How to prioritise the patients while sorting for treatment and admission?

- Should there be different priority queues for different purposes or make one queue based on different parameters?

- Should the priority functions be in a different class or as there are now (i.e. private methods in the respective subclasses)

- Should Container be an abstract class or parent class?

- How to extend classes or implement interfaces appropriately while following the SOLID principles?


### What has worked well so far with your design?

We have created very extendable classes; this allows us to create subclasses later when we want to enhance our product. For example, we have a person class, which we can then create a nurse out of later. Similarly, we can create subclasses of hospitals, like children’s hospitals. We have also taken care to examine realism in our project which allows us to make more interesting less nebulous classes. We can deal with priority admission and treatments.

So far with Affliction.java and Patient.java, we've been able to read their corresponding data off of a .txt file which serves as a database for all information related to their corresponding object. A method would be responsible for reading the appropriate .txt file, constructing an ArrayList for its specified object, and returning the ArrayList. This allows the end user to quickly input information onto a .txt file and for the program to quickly create multiple objects all at once.

So far, we have been able to create priority queues for adding and removing patients (both for admission and treatment). We have been able to follow the SOLID principles, particularly the Liskov Substitution Principle, for the Container class and its subclasses. This allows us to have common code in the Container class and properties that are specific to the subclasses within those subclasses. The queues also fit in well with the overall healthcare management system because as the system becomes more complex and the hospital capacity decreases with the admittance of more patients, we need queues for prioritising patients.


###  Brief summary of what each group member has been working on and plans to work on next.

Teammate 1: Ernest

Ernest is currently working on Affliction.java and Patient.java so that the program is capable of reading different .txt files and creating their corresponding object. He plans to fix other classes that others are working on at the moment if it breaks the SOLID principles (e.g. extending parent class as to prevent breaking Single-Responsibility Principle)

Person 2: Euan

Created a list of disease with important traits. Discussed and planned implementations for classes. Discussed an idea for a virality factor and the possibility of a quarantine feature.


Person 3: Shysta

Shysta has been working on the Container class and its subclasses along with Justice. She has also helped the other group members with brainstorming aspects of their code. She plans to work on making the code fit well for multiple hospitals; for example, how to sort patients into different hospitals depending on the doctor availability and specialisation, nearest hospital etc.

Person 4: Ratantej

Ratan's been working on Diagnosis.Java, Affliction.Java, and helped here and there on other files . Up next for them would be expanding functionality of the program. 

Person 5: Alessandro

Alessandro created a dataset containing 25 disease distinct disease, each having a distinct set of 3 symptoms and each having a gravity level on a scale from 1 to 5. He also coded a program that is able to create datasets of patients with different and specific names, ages, addresses and symptoms  corresponding to one of the 25 diseases in the other file.

Person 6: Justice

I (Justice) have been working primarily on creating the priority Queues for admitting and treating patients with Shysta. We designed the initial protocol for admitting and treating patients (in both cases, patients with lower HP are prioritized and admitted/treated first). We have plans to include more instantiations of higherPriority so that we can sort patients by more relevant factors such as insurance factor, type of disease, and age and break ties in the event that two patients have the same HP. I also set up all of the initial classes and laid the groundwork for development performed by my other teammates by outlining methods that needed to be coded and parent classes that needed to be extended.


Person 7: Roa

Roa has managed the communications with the TA in charge. She mainly worked on the write-ups of the specification, CRC model and walkthrough. She also coded the command line interface and compiled the progress report of all the members. She plans on expanding the functionality of diagnosis and treatment. The current diagnosis methods are too trivial to apply in a real world application. The next step Roa wants to take is to mimic the thought process of a doctor in a real life diagnosis situation. The diagnosis functionality will then be expanded from matching diseases to a set of 3 given symptoms to a smarter strategy that outputs the likelihood of a given disease no matter how many symptoms are input. Instead of a text dataset, a diseases directory API could then be used. The treatment process will then output possible scans for an elimination process of the top most likely diseases. Roa also plans to migrate to an android app, which will provide the doctors with a more user-friendly option to interact with our program.

