# 💰 Expense Tracker (Java Console App)

A simple **console-based Expense Tracker** built using Java, JDBC, and PostgreSQL.  
This project helps users manage personal expenses by adding, viewing, updating, deleting, and filtering records.

---

## 🚀 Features

- ✅ Add new expenses
- ✅ View all expenses
- ✅ Delete expenses by ID
- ✅ Update existing expenses
- ✅ Filter expenses by category
- ✅ Filter expenses by date range

---

## 🧰 Tech Stack

- Java (Core)
- PostgreSQL
- JDBC
- Maven
- Eclipse IDE (or any Java IDE)

---

## 🗂️ Project Structure

expense-tracker-java/
├── pom.xml
├── README.md
└── src/
└── main/
└── java/
└── com/
└── expensetracker/
├── App.java
├── Expense.java
├── ExpenseDAO.java
└── DBConnection.java


---

## 📦 Database Setup (PostgreSQL)

1. Open **pgAdmin** or **psql**
2. Run the following:

```sql
CREATE DATABASE expensetracker;

\c expensetracker

CREATE TABLE expenses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    amount DOUBLE PRECISION,
    category VARCHAR(50),
    date DATE
);
```
3.Update your DBConnection.java file with your PostgreSQL credentials.

🧪 How to Run

1.Clone this repo or download ZIP

2.Open the project in Eclipse or IntelliJ

3.Build the project with Maven (or run ExpenseDriver.java directly)

4.Use the console menu to manage your expenses

🙋‍♂️ Author
Made with ❤️ by [B.Venkata Nagireddy]
