# Katterace Project

- **Trello**: [Link to Trello Board](https://trello.com/b/YqLVqxfL/emilskattehjem)
- **Github**: [Link to Github Repository](https://github.com/Emilkroldrup/Springkatte)

## Objectives

The objective of the Katterace project is to develop a simple online platform for the purebred cat enthusiasts' club. The platform aims to streamline membership management, allowing members to register themselves and their pets, update their information, and view their membership status. Additionally, administrators should have tools to manage member profiles, oversee pet registrations, and perform other administrative tasks.

## Requirements

### User Group Analysis

The user group consists of members and administrators of the purebred cat enthusiasts' club. Here are some key points about the user group:

#### Members:

- Individuals interested in purebred cats who have joined the club.
- They may want to register themselves in the system, update their personal information, register their pets, and view their membership status.
- Members may also want to unregister themselves or their pets from the system if they no longer wish to be part of the club.

#### Administrators:

- Individuals responsible for managing the club's operations.
- They have additional privileges compared to regular members, such as managing member profiles, overseeing pet registrations, and possibly handling payments for events or memberships.
- Administrators need the ability to add, edit, and remove members and pets from the system. They may also need to generate reports or monitor the system's overall health.

### Simple Use Cases

#### Register as a Member:

- **Actors:** Potential Member
- **Description:** A person interested in joining the club registers themselves in the system by providing necessary details such as name, email address, and password.
- **Preconditions:** The person has access to the club's online platform.
- **Postconditions:** The person becomes a registered member of the club with a unique profile.

#### Update Member Information:

- **Actors:** Member
- **Description:** A member updates their personal information such as contact details, address, or pet information.
- **Preconditions:** The member is logged into their account.
- **Postconditions:** The member's information is updated in the system.

#### Register a Pet:

- **Actors:** Member
- **Description:** A member registers their pet in the system by providing details such as pet name, breed, age, and any other relevant information.
- **Preconditions:** The member is logged into their account.
- **Postconditions:** The pet is associated with the member's profile and registered in the system.

#### Delete Member Profile:

- **Actors:** Member
- **Description:** A member decides to leave the club and requests to delete their profile from the system.
- **Preconditions:** The member is logged into their account.
- **Postconditions:** The member's profile and associated data (including pets) are permanently removed from the system.

#### Administer User Roles:

- **Actors:** Administrator
- **Description:** An administrator assigns or modifies roles for users within the system, such as granting administrative privileges to other members.
- **Preconditions:** The administrator is logged into their administrative account.
- **Postconditions:** User roles are updated accordingly, allowing for effective management of the system.

### Hard Requirements

- The system must be developed in Java, using Spring MVC as the user interface.
- Data must be stored structured and permanently.
- The system must be built based on a Clean Architecture structure, clearly reflected in the final product.
- Domain model, class diagram, system sequence diagram, and sequence diagrams for selected use cases must be developed. Additionally, an E/R diagram for the database part is required.
- The system must define clear associations between the system's classes.
- Details about the data structures used in the system must be provided.
- Unit tests must be included as part of the product.
- Selected parts of the system must be documented.

### Soft Requirements

- The user interface should be responsive.
- Member data should be secured. Consideration should be given to data protection measures.
- If members are to register one or more pets for a cat show, how should this be modeled and implemented in the system?
- Consider how the system could be integrated with a payment system.
- Could a role distribution be implemented in the system - users, administrators, etc., and how should it be modeled and implemented?

