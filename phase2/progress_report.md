#  Brief summary of what each group member has been working on and plans to work on next.

## Ernest

Ernest has worked on the Accessibility Report and the Design Document in Phase 2. For the Accessibility Report, since the program uses a CLI instead of GUI, our group cannot do much to ensure that our program adheres to the Universal Design Principles. Instead, we came up with features that we could implement in the future that would adhere to the principles (e.g. Dak Mode Feature, Custom GUI Resize Feature). As for the Design Document, Ernest has rewritten the SOLID Principles, Clean Architecture, and Design Patterns section to better reflect our group’s understanding of different software design principles taught in class. For example, UML diagrams and direct examples were given to show our understanding of various principles.

https://github.com/CSC207-UofT/course-project-all-stars/pull/2
https://github.com/CSC207-UofT/course-project-all-stars/pull/3

The pull requests for the Person branch and the Database branch demonstrates that I have contributed to the team’s codebase. The pull request for the Person branch added extra functionality to the program by allowing the end user to read or write information to a database containing the patient’s information. As for the pull request for the Database branch, it allows the higher-level classes to access the database without violating the Dependency Inversion Principle.

## Euan

Euan has worked on implementing the Multi-Hospital functionality, primarily in the scope of the controller layer with the Hospital-Manager class, which stores hospitals and can facilitate actions taken between hospitals on a meta level. He refactored all code related to the multiple hospitals and cleaned up functionality in the hospital class. Furthermore he reworked patient naming and id scheming to work with a more advanced database implemented by other team members. Guaranteeing all new functionality worked with the updated CLI was another primary focus of his.
Pull request: N/A

## Shysta

N/A

## Ratantej

N/A

## Alessandro

Alessandro fixed some inconsistencies with the can_cure variable stored in each doctor. After that, he modified the patient.txt file and changed it from 100 to 10000 patients. This was done to add more variety to the program. After that, he removed the PatientArrayList class and implemented the PatientsFactory class, this class has as its only public method the "CreatePatients" method which takes an integer as its only parameter and returns that amount of patients stored in an array list. To do this, the class interacts with the Databases and creates hashmaps mapping the number of the line to the line itself.

https://github.com/CSC207-UofT/course-project-all-stars/pull/23

This Pull Request made it possible for the controller to request any number of patients from the PatientsFactory class, and the change in the size of the patients.txt file added a lot of variety to the program.

## Justice

N/A

## Roa

needa add
