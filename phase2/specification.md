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
