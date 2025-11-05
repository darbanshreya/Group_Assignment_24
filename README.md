# Group_Assignment_24
# 🎓 Digital University System — INFO 5100 (Application Engineering & Development)

## 📘 Overview
The **Digital University System** is a role-based academic management platform developed in Java Swing for **INFO 5100 – Application Engineering & Development** at **Northeastern University**.  
It models a real-world university ecosystem, providing separate access and functionalities for **Administrators**, **Faculty**, and **Students** through a secure access-control layer.

---

## 👩‍💻 Team Information
**Course:** INFO 5100 — Application Engineering & Development  
Darshan Patgar- 003151701
Shreya Darban- 002536747
Pranav Waghmare- 002513911
  
**Semester:** Fall 2025  

**Team XX**  
| Name | NUID | Role | Responsibilities |
|------|------|------|------------------|
| Shreya Darban | 002536747 | Student Developer | Student Use Case, UI workflow, Tuition & Transcript Module |
| [Member 2 Name] | [NUID] | Admin Developer | Admin Panel, Account Management, Department Preload |
| [Member 3 Name] | [NUID] | Faculty Developer | Course & Grade Module, Enrollment Integration |
| [Member 4 Name (optional)] | [NUID] | Reviewer / Tester | Code Review, Bug Fixing, Documentation |

---

## 🧩 System Architecture

| Layer | Components | Description |
|-------|-------------|-------------|
| **Model Layer** | `Person`, `StudentProfile`, `FacultyProfile`, `Course`, `Enrollment`, `Tuition` | Core business entities representing people, courses, and financial data. |
| **Directory Layer** | `PersonDirectory`, `CourseDirectory`, `EnrollmentDirectory`, `DepartmentDictionary` | Manages collections and CRUD operations for entities. |
| **Access Control Layer** | `UserAccount`, `UserAccountDirectory` | Handles authentication and role-based access. |
| **Business Layer** | `Business`, `ConfigureABusiness` | Initializes the entire ecosystem and preloads sample data. |
| **UI Layer (View)** | `AdminRoleWorkAreaJPanel`, `StudentRoleWorkAreaJPanel`, `FacultyRoleWorkAreaJPanel` | Provides role-specific interfaces using `CardLayout` navigation. |

---

## 🧠 Key Features

### 👑 Administrator
- Manage Persons (Student / Faculty / Admin).  
- Register new accounts with department assignment and contact info.  
- Delete or search users by ID / Name / Email.  
- View system-wide statistics and department summaries.  
- Enforce validation to prevent duplicate accounts.  

### 👩‍🏫 Faculty
- View and manage assigned courses.  
- Record student grades and calculate course averages.  
- View enrolled students and update syllabus information.  
- Generate class performance reports.  

### 🎓 Student
- Secure login and profile management.  
- Register for courses with credit validation (max 8 credits per semester).  
- View and pay tuition invoices.  
- Access transcript with GPA calculation and academic standing.  
- View department information and faculty details.  

---

## ⚙️ Technologies Used
- **Java SE 17+**
- **Java Swing / AWT** (GUI Development)
- **NetBeans IDE**
- **Git & GitHub** (Collaboration)
- **UML Design** — Lucidchart / Draw.io  
- **OOP Principles** — Encapsulation, Inheritance, Polymorphism  

---

## 🧩 GitHub Collaboration Workflow
Each team member worked on a separate feature branch:
feature-Shreya
Feature-Darshan
feature-Pranav
Merged into `main` after code review via Pull Requests (PRs).  
This workflow ensured version control and conflict-free integration.



---

## 🧮 Sample Login Credentials

| Role | Username | Password |
|------|-----------|-----------|
| **Admin** | `admin` | `admin` |
| **Student 1** | `alice` | `1234` |
| **Student 2** | `bob` | `1234` |
| **Student 3** | `carol` | `1234` |
| **Student 4** | `david` | `1234` |
| **Faculty 1** | `robert` | `1234` |
| **Faculty 2** | `emily` | `1234` |
| **Faculty 3** | `michael` | `1234` |
| **Faculty 4** | `sarah` | `1234` |
| **Faculty 5** | `davidm` | `1234` |

---

## 🎥 Demo Flow (for Code Review)
### 🏛️ Administrator
1. Login → Manage Persons → Register New Student/Faculty.  
2. Validate duplicate email check and auto ID generation.  
3. Delete and search users using JTable.  
4. Logout and re-login to verify account persistence.

### 👩‍🏫 Faculty
1. Login → View Assigned Courses.  
2. Open course → View students → Assign grades.  
3. Calculate average performance.  
4. Generate report and logout.

### 🎓 Student
1. Login → Browse available courses.  
2. Register or drop course → View invoice.  
3. Pay tuition → Check updated balance.  
4. View Transcript and GPA.



