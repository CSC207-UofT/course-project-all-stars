#  Scenario Walkthrough

End user: **Doctor in a hospital**

The end user is greeted by the main menu, which contains a set of commands that allows them to do the following:

||        
|-|
|Treat patients|
|Discharge patients|
|View patient details|
|View hospital details|
|Quit the app|

### Treatment Scenario Walkthrough

The end user inputs a command like  `Treat`. The program presents the patient at the top of the priority queue. A patient profile is then generated. The chart contains the patient's name, address, sex, age, as well as health and insurance status. 

The end user is then presented with 3 options: `Diagnose`, `Next Patient`, `Back`. The second option evidently proceeds to the next patient on the priority queue. The last option returns to the main menu. The first option proceeds to the diagnosis of the high priority patient.

`Diagnose` generates the two following commands: `Admit`, `Discharge`. These commands are trivial and mark the end of the program scope in phase 0.

> The rest of the main menu commands are also trivial with limited scope

Discharge Patients & View Patient Details: 
- Both generate the two following commands: `Back`, `Next Patient`

View Hospital Details:
- The end user is presented with details regarding the hospital, containing the name, year of foundation, and the number of patients being treated.

Quit the app evidently terminates the program.
