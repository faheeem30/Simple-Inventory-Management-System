# 🧾 Simple Inventory Management System (Java + MySQL)

## 🚀 Overview

A lightweight **Inventory Management System** built using **Core Java and MySQL**, demonstrating complete **CRUD operations** — Add, View, Update, Delete — with database connectivity using **JDBC**.

This project is ideal for beginners in **Java Database Connectivity (JDBC)** and showcases backend logic for **product management**.

---

## 🧩 Features

✅ Add new products to the database
✅ View all products in a clean list format
✅ Update product **quantity** and **price**
✅ Delete products by ID
✅ MySQL database integration with **prepared statements**

---

## 🧱 Tech Stack

| Component       | Technology                   |
| --------------- | ---------------------------- |
| **Language**    | Java (Core Java, JDBC)       |
| **Database**    | MySQL                        |
| **IDE**         | Eclipse                      |
| **JDBC Driver** | Connector/J 9.4.0            |

---

## 📂 Project Structure

```
InventorySystem/
│
├── src/
│   ├── DBConnection.java
│   ├── Product.java
│   ├── ProductDAO.java
│   └── Main.java
│
├── inventorydb.sql      # SQL script to create tables
└── README.md
```

---

## 🧠 Database Schema

```sql
CREATE DATABASE inventorydb;
USE inventorydb;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);

CREATE TABLE bills (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DOUBLE
);

CREATE TABLE bill_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    bill_id INT,
    product_id INT,
    quantity INT,
    subtotal DOUBLE,
    FOREIGN KEY (bill_id) REFERENCES bills(bill_id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);


```
<img width="1718" height="681" alt="image" src="https://github.com/user-attachments/assets/1c3cddd3-4c8b-4f85-b6d0-fd2be11755fa" />

## To download JDBC file 

* https://dev.mysql.com/downloads/connector/j/
* (Connector/J 9.4.0
* Select Operating System:Platform Independent


* Platform Independent (Architecture Independent), Compressed TAR Archive	9.4.0	4.3M	
* Download (from the website select platform independent and download the file name as the above one )

---

## ⚙️ How to Run

1. **Set up MySQL Database**

   * Create database using the script above.
   * Update your MySQL username/password in `DBConnection.java`.

2. **Compile and Run**

   * Open terminal / IDE and run:

     ```
    * click run all in the main file
     ```

3. **Choose Menu Options**

<img width="520" height="352" alt="image" src="https://github.com/user-attachments/assets/2c7703cd-12c3-459e-ab0b-d1a34c98df7c" />


## 📸 Sample Output
<img width="418" height="663" alt="image" src="https://github.com/user-attachments/assets/8319dc4d-9f05-42e9-8f8b-a5e357ee4e37" />




---

## ⭐ Future Enhancements

* Add a **billing module** and generate receipts.
* Integrate **login authentication** for admin users.

---

