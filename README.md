# 🏢 Automated Employee Payroll & Attendance System

A robust Java-based management system designed to handle diverse staff roles including Managers, Admins, Chefs, and Hourly Staff. This project demonstrates advanced Object-Oriented Programming (OOP) principles through a clean, console-based interface.

## 🚀 Key Features
- **Dynamic Onboarding:** A structured registration loop for 5 initial staff members.
- **Role-Based Logic:** Automated salary assignment for specific positions:
  - **Manager:** High-tier fixed salary ($8,000).
  - **Admin:** Mid-tier fixed salary ($5,000).
  - **Chef & Staff:** Base-tier fixed or hourly rates.
- **Real-Time Attendance:** Precision clock-in/out tracking using `System.currentTimeMillis()`.
- **Staff Directory:** A professionally formatted table display of all registered personnel.
- **Secure Sessions:** unique ID-based login system to prevent unauthorized access to payroll data.

## 🛠️ Technical Implementation (OOP)
- **Abstraction:** The base `Employee` class ensures a consistent template for all staff types.
- **Inheritance:** Specialized logic for `HourlyEmployee` and `EMPSalary` classes.
- **Polymorphism:** Unified method calls for `calculatePay()` that behave differently based on the object type.
- **Data Management:** Utilizes `java.util.HashMap` for O(1) efficiency in staff retrieval.

## 💻 Installation & Execution
1. Clone the repository:
   ```bash
   git clone [https://github.com/OtajonG/Employee-Payroll-System.git](https://github.com/OtajonG/Employee-Payroll-System.git)
