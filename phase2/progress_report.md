#  Brief summary of what each group member has been working on and plans to work on next.

## Ernest

Ernest has worked on the Accessibility Report and the Design Document in Phase 2. For the Accessibility Report, since the program uses a CLI instead of GUI, our group cannot do much to ensure that our program adheres to the Universal Design Principles. Instead, we came up with features that we could implement in the future that would adhere to the principles (e.g. Dak Mode Feature, Custom GUI Resize Feature). As for the Design Document, Ernest has rewritten the SOLID Principles, Clean Architecture, and Design Patterns section to better reflect our group’s understanding of different software design principles taught in class. For example, UML diagrams and direct examples were given to show our understanding of various principles.

https://github.com/CSC207-UofT/course-project-all-stars/pull/2
https://github.com/CSC207-UofT/course-project-all-stars/pull/3

The pull requests for the Person branch and the Database branch demonstrates that I have contributed to the team’s codebase. The pull request for the Person branch added extra functionality to the program by allowing the end user to read or write information to a database containing the patient’s information. As for the pull request for the Database branch, it allows the higher-level classes to access the database without violating the Dependency Inversion Principle.

## Euan

Euan has worked on implementing the Multi-Hospital functionality,primarily in the scope of the controller layer with the Hospital-Manager class, which stores hospitals and can facilitate actions taken between hospitals on a meta level. He refactored all code related to the multiple hospitals and cleaned up functionality in the hospital class. Furthermore he reworked patient naming and id scheming to work with a more advanced database implemented by other team members. Guaranteeing all new functionality worked with the updated CLI was another primary focus of his.

https://github.com/CSC207-UofT/course-project-all-stars/pull/24
https://github.com/CSC207-UofT/course-project-all-stars/pull/25

These pull requests represent the work done to introduce multi-hospital functionality. Euan wrote the classes for Multi Hospital and made the changes elsewhere to implement it properly, He also spoke with other teammates particularly the CLI members to guarantee the CLI worked with the new functionality.


## Shysta

I worked on enhancing the Diagnose method in the Diagnose package because the previous version of it was not fully functioning. Along with that, I also reformatted the code and fixed errors in various classes and packages. Further, I worked on improving the CLI, adding documentation and Java docs to the various methods in the CLI, and implementing the Facade Design Pattern for the CLI with Justice.

https://github.com/CSC207-UofT/course-project-all-stars/pull/18/files

I believe this is one of the major pull requests I worked on this semester. In this pull request, I implemented the Template Method Design Pattern in the priority package. I also created a new priority triage method by adding a new class ‘AdmissionCOVID’ which implements a priority protocol for admitting patients during COVID. Along with that, I reformatted and refactored the code across various packages in this pull request.

## Ratantej

Ratantej coded up the CLI and improved cloud functionality using Google Cloud SQL. He also implemented the database interfaces following various deisgn documents. He also tested and cleaned up the old code. 

Pull Requests: 

https://github.com/CSC207-UofT/course-project-all-stars/pull/27

https://github.com/CSC207-UofT/course-project-all-stars/pull/22

The pull request merging two cli branches was merging justices work on the CLI with mine. While he cleaned up the code from the previous CLI that I had coded to follow respective solid principles and design patterns, I was working on the main layer of the CLI since it is divind into esstinally 2 layers. Top layer is selcting and initlizing a hospital from the google cloud. And the second layer is the avaible functions that can be performed to that hospital. 

The second pull request merging CLI to main, addressed multiple issues across the board. It allowed us to connect the entire CLI to the various classes everyone else was working on. After that pull request, I made my commits directly to the main branch and addressed various inconsistencies while also improving the functionality of our 2 layred CLI



## Alessandro

Alessandro fixed some inconsistencies with the can_cure variable stored in each doctor, added documentation to the whole person package and modified some variables and added getters and setters methods. After that, he modified the patient.txt file and changed it from 100 to 10000 patients. This was done to add more variety to the program.
After that, he removed the PatientArrayList class and implemented the PatientsFactory and the DoctorsFactory classes, these class, respectively, have as their only public methods the "CreatePatients" method and the "CreateDoctors" which take an integer as the only parameter and return that amount of patients/doctors stored in an array list.
To do this, the classes interact with the Databases and create hashmaps mapping the number of the line to the line itself.

https://github.com/CSC207-UofT/course-project-all-stars/pull/23

This pull request added to the program the PatientsFactory class and changed the number of patients in the txt file from 100  to 10000.

## Justice

Justice began by working on tightening the documentation and functionality for priority queues. Justice worked on the CLI with Ratan, implementing the facade design pattern and creating documentation for all subclasses, methods, and the facade class. He also added documentation, new getter functions to the hospital class, and updated its ability to accommodate both treatment and admission priority queues.

Pull Request:

https://github.com/CSC207-UofT/course-project-all-stars/pull/22

This pull request (performed by both me and Ratantej) is significant because it demonstrates my ability to make code more efficient, decreasing the Simulation class by 100 lines of code while maintaining functionality. It also demonstrates my ability to implement design patterns as this is the first instance of the facade design pattern coming together between the CLI and cli_main branch. These pull requests added both the structure of the facade design pattern and the functionality of our existing code to one code base


## Roa

Roa has worked on the Design Document and expanding the database in Phase 2.
The latter was done by adding over 240 data points, including diseases and 
symptoms, from the UMLS, or Unified Medical Language System. As for the Design Document, 
Roa has reviewed and rewritten the SOLID Principles, Packaging, Clean Architecture and 
Overview of major design decisions section. 
The purpose is to build consensus and summarise the breadth of our project while referring
to software design concepts and how we incorporated them in our code. 


https://github.com/CSC207-UofT/course-project-all-stars/pull/28

The pull request for the Design branch demonstrates that Roa has contributed to the team’s 
codebase. This pull request added extra concepts, diseases and symptoms, to the database 
as well extra functionality to the program by matching specialisations to the new diseases. 
Thus, it allows the higher-level class Doctor to cure diseases without redundancy that would 
be violating the Liskov Substitution Principle. In addition, the pull request contains the 
aforementioned design document contributions.
