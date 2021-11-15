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
