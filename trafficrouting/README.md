# 🚦 Traffic Routing System Using Dijkstra Algorithm

## 📌 Project Overview

The Traffic Routing System is a Spring Boot web application that finds the fastest route between two locations using Dijkstra's Algorithm. It also allows users to update traffic conditions dynamically, and the shortest path is recalculated based on the current traffic.

---

## ✨ Features

- Find the shortest path between two locations
- Update traffic levels (Low, Medium, High)
- Dynamic travel time calculation
- Interactive web interface using Thymeleaf
- Responsive UI with Bootstrap

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Thymeleaf
- Bootstrap 5
- Maven
- Dijkstra Algorithm

---

## 📂 Project Structure

```
Traffic-Routing-System
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.trafficrouting
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       ├── service
│   │   │       └── TrafficroutingApplication.java
│   │   └── resources
│   │       ├── templates
│   │       └── application.properties
│
├── pom.xml
└── README.md
```

---

## 🚗 Locations

- Bus Stand
- Benz Circle
- MG Road
- Railway Station
- One Town
- Governorpet

---

## 🚦 Traffic Levels

| Level | Description | Travel Time |
|-------|-------------|------------|
| 1 | Low | Base Time |
| 2 | Medium | 2 × Base Time |
| 3 | High | 3 × Base Time |

---

## 🧠 Algorithm Used

This project uses **Dijkstra's Algorithm** to determine the shortest travel time between two locations while considering the current traffic conditions.

---

## ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/lakshmibhargavikota/Traffic-Routing-System.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Update Maven dependencies.

4. Run:

```
TrafficroutingApplication.java
```

5. Open your browser and visit:

```
http://localhost:8082
```

---

## 📸 Screenshots

_Add screenshots of your application here._

---

## 👩‍💻 Author

**Lakshmi Bhargavi Kota**

GitHub: https://github.com/lakshmibhargavikota
