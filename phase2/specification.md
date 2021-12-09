## Specification

In a nutshell, All Stars Hospital Management System provides a sophisticated CLI 
for patient triage and preliminary medical diagnosis that can help hospital
administrators with patient intake across a network of hospitals.

The end users have the option to navigate across all different homepages of the program.

###The end users (**administrators**) should be able to do interact with the following options in the homepage:

> - The SelectHospital option allows administrators to pick a hospital from a preexisting
    network in our database.
> - The CreateHospital option provides administrators with the ability to create a new instance 
    of the Hospital class.
> - The ManageHospital option
> - The ViewProgramDetails option presents general information about the program 
> - Integrated Cloud SQL Database

### The administrators should be able to do interact with the following options in the hospital homepage:

> - The Treat Patient option should allow the administrator to diagnose and either admit or send the patient home, 
    then move on to the next patient.
> - The Discharge Patient option should delete the patient that is sent home.
> - The Add Patient option provides administrators with the ability to create a new instance
    of the Patient class.
> - The Add Doctor option provides administrators with the ability to create a new instance
    of the Patient class.
> - The View Patient Details option presents general information about the patient, and as such their name,
    ID, age, sex, address, health, symptoms, diagnosis, admission status and assigned doctor.
> - The View Hospital Details option presents general information about the hospital, and as such its name,
foundation year and patient capacity.

### Core features of our program:
- Multi-Hospital network support
- Diagnosing patients via UMLS single disease to symptoms mapping
- Covid-specific interface as a critical condition
- Matching doctors in different specialisation with diseases they cure
- Integrated cloud SQL Database
- Patient triage using health points and insurance coverage

### Credits
#### (c) Roa
