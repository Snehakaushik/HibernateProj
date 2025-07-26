# Hibernate HQL and Native SQL Queries Demo

This Java project showcases various ways of querying a MySQL database using **Hibernate**, including both **HQL (Hibernate Query Language)** and **Native SQL**. It also demonstrates how to fetch data using entity objects or specific columns using object arrays.

## 🔧 Tech Stack
- Java 21  
- Hibernate ORM  
- MySQL  
- Maven  

## 🚀 Features
- Basic CRUD using Hibernate  
- HQL queries using:
  - `from` (entire entity)
  - `select` (specific columns)
  - `where`, `sum`, and parameterized queries
- Use of `uniqueResult()` and `list()`  
- Native SQL with `NativeQuery` (modern replacement for deprecated `SQLQuery`)
- Explanation of `get()` vs `load()` in comments

## 🧪 How to Run
1. Configure DB credentials in `hibernate.cfg.xml`
2. Use Maven to build the project:  
   `mvn clean install`
3. Run `Main.java` to execute a variety of Hibernate queries.

## 📝 Notes
- When querying for specific columns, results are handled using `Object[]`  
- Includes explanation of `get()` vs `load()` behavior in Hibernate

---

Made with ❤️ by Sneha
