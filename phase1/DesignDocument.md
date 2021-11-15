# Welcome to the AllStars Design Document!

## A description of any major design decisions your group has made (along with brief explanations of why you made them).

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
