# Java Library Management System

A robust, object-oriented console application built in Java designed to simulate a fully functional library circulation and inventory tracking system.

---

## 📂 Core Classes & Architecture

The system is engineered following core Object-Oriented Programming (OOP) principles, structured across three primary classes:

1. **`Book`**: Manages individual book attributes (Title, Author, Book ID, and issuance state) along with check-in and check-out methods.
2. **`Member`**: Handles user profiles (Name, Member ID) and maintains an internal `ArrayList` tracking currently borrowed books.
3. **`Library`**: Acts as the central system controller, handling inventory preloading, member verification, and conditional search functions.

---

## ⚙️ Key Features
* **Preloaded Inventory:** Instantly initializes with 20 classic literature and fiction titles for immediate testing.
* **Dynamic Member Registration:** Captures user details at runtime to initialize active library sessions.
* **Circulation Control:** Securely handles book issuance and returns with built-in validation checks (e.g., verifying availability, preventing double-issuances, and checking record existence).
* **Interactive CLI Menu:** Powered by Java `Scanner` and `do-while` control structures for continuous navigation.

---

## 🚀 Tech Stack
* **Language:** Java (JDK 8+)
* **Data Structures:** Java Collections Framework (`ArrayList`)
* **Control Flow:** Interactive Command-Line Interface (CLI)

---

## 📦 Getting Started & Execution

1. Make sure you have the Java Development Kit (JDK) installed on your system.
2. Save the source code into a file named **`LibraryManagementSystem.java`**.
3. Compile the program from your terminal:
   ```bash
   javac LibraryManagementSystem.java
