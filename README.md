# Group_Assignment_24
Perfect 👍 — here’s a **complete, submission-ready README file** for your **Digital University System (Group Assignment 1)**, customized for your team (**Shreya Darban – Student Use Case**, **Darshan Patgar – Faculty Use Case**, **Pranav Waghmare – Admin Use Case**).

You can copy-paste this directly into a file named **`README.md`** for your GitHub submission.

---

# 🏫 Digital University System — Group Assignment 1

**Course:** INFO 5100 — Application Engineering and Development
**Assignment:** Implementing Access-Controlled Use Cases in a Digital University System
**Due Date:** October 26, 2025

---

## 🧠 1. Project Title

**Digital University System with Role-Based Access Control**

---

## 👥 2. Team Information

| Name                         | Role                   | NUID         | Responsibilities                                                                                      |
| ---------------------------- | ---------------------- | ------------ | ----------------------------------------------------------------------------------------------------- |
| **Shreya Kirankumar Darban** | Student Use Case       | *0025367474* | Implemented Student panels: course registration, transcript, graduation audit, and tuition management |
| **Darshan Patgar**           | Faculty Use Case       | *003151701*  | Implemented Faculty panel: course management, grade entry, and performance reporting                  |
| **Pranav Waghmare**          | Administrator Use Case | *002513911*  | Implemented Admin panel: user management, person registration, analytics, and system integration      |

---

## 🎯 3. Project Overview

This project simulates a **Digital University System** with **role-based authentication and authorization**. It allows different users (Admin, Faculty, Student) to access specific features based on their assigned roles.

The system integrates:

* A **Business Layer** for core models (Person, Profile, Course, Enrollment, Tuition)
* An **Access Control Layer** for authentication
* A **UI Layer** built using Swing (`CardLayout`-based navigation)

---

## ⚙️ 4. Installation & Setup Instructions

### Prerequisites

* **Java JDK 17 or above**
* **NetBeans IDE / IntelliJ IDEA**
* **Swing UI libraries (default in JDK)**

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/<your-team-repo>.git
   ```
2. Open the project in NetBeans or IntelliJ.
3. Run the main class:

   ```java
   ProfileWorkAreaMainFrame.java
   ```
4. Default login credentials:

   * **Admin:** `admin / ****`
   * **Student:** `adam / ****`

---

## 🔐 5. Authentication & Access Control

### Login Logic

The system authenticates users via the `UserAccountDirectory` and loads the correct work area based on their `Profile` type.

| Role          | Profile Class     | Access Panel              |
| ------------- | ----------------- | ------------------------- |
| Administrator | `EmployeeProfile` | `AdminRoleWorkAreaJPanel` |
| Faculty       | `FacultyProfile`  | `FacultyWorkAreaJPanel`   |
| Student       | `StudentProfile`  | `StudentWorkAreaJPanel`   |

### Authorization

* Each user can only access features corresponding to their role.
* Access control is validated upon login; unauthorized panels are not loaded.

---

## 🧩 6. Features Implemented

### 👨‍💼 Administrator (Pranav Waghmare)

* User Account & Person Management (Create/Edit/Delete)
* Student & Faculty Record Management
* Search by name, ID, or department
* Analytics Dashboard (Total Users, Courses, Enrollment, Tuition Summary)

### 👨‍🏫 Faculty (Darshan Patgar)

* View & update assigned course details (title, capacity, schedule)
* Manage enrolled students and grades
* Calculate & display course GPA and grade distribution
* Export course performance reports

### 👩‍🎓 Student (Shreya Darban)

* View, search, and enroll/drop courses
* Limit course load to 8 credit hours per semester
* Graduation audit tracking (requires 32 credit hours to graduate)
* Transcript view sorted by term with GPA calculation and standing status
* Tuition payment management and payment history view

---

## 🖥️ 7. Usage Instructions

1. Launch the app and log in as one of the roles.
2. Navigate between panels using the sidebar or buttons.
3. For Students:

   * Use “Course Registration” to enroll or drop.
   * Use “Transcript” to view grades & progress.
   * Use “Finance” panel to pay tuition.
4. For Faculty:

   * Manage grades and generate reports.
5. For Admin:

   * Register persons, manage accounts, and view analytics.

---

## 🧪 8. Testing Guide

* Validate each login role (Admin, Faculty, Student).
* Check CRUD operations for all entity directories (StudentDirectory, CourseDirectory, TuitionDirectory).
* Test invalid input scenarios (nulls, blanks).
* Verify GPA and tuition calculations using sample data.
* Ensure `CardLayout` navigation works across all panels.

---

## 🧱 9. Challenges & Solutions

| Challenge                                  | Solution                                                                  |
| ------------------------------------------ | ------------------------------------------------------------------------- |
| Handling multiple roles with shared panels | Implemented dynamic `CardLayout` switching and modular UI structure       |
| GPA & credit validation logic              | Used cumulative and term-wise GPA calculation with credit sum checks      |
| Data persistence simulation                | Used static configuration via `ConfigureABusiness`                        |
| UI integration                             | Coordinated consistent table models and event listeners across all panels |

---

## 🚀 10. Future Enhancements

* Connect with a real database (MySQL / Firebase)
* Add Registrar role (for 4-member teams)
* Implement file upload for assignments and reports
* Add chart-based analytics for Admin dashboards

---

## 👏 11. Contribution Breakdown

| Name                | Use Case | Code Commits | Pull Requests | Reviews | Summary                                                                                                |
| ------------------- | -------- | ------------ | ------------- | ------- | ------------------------------------------------------------------------------------------------------ |
| **Shreya Darban**   | Student  | 12+          | 5             | 6       | Built Student UI (CourseRegistration, Transcript, Finance); implemented GPA, tuition, graduation logic |
| **Darshan Patgar**  | Faculty  | 11+          | 5             | 7       | Built Faculty UI; integrated gradebook, reports, and assignments                                       |
| **Pranav Waghmare** | Admin    | 10+          | 5             | 6       | Implemented Admin panel, analytics, and account management                                             |

---

✅ **All panels tested with no terminal errors.**
✅ **Code validated and ready for submission.**

