# 📏 Quantity Measurement System

A Spring Boot based REST API that performs operations on different quantities such as **Length, Weight, Volume, and Temperature**.

---

## 🚀 Features

* ✅ Compare two quantities
* 🔄 Convert units
* ➕ Add quantities
* ➖ Subtract quantities
* ➗ Divide quantities
* 📜 Operation history tracking
* ❌ Error handling with logging
* 📊 Operation count & filters

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Database:** MySQL
* **ORM:** Spring Data JPA
* **API Docs:** Swagger (OpenAPI)
* **Build Tool:** Maven

---

## 📂 Project Structure

```
src/
 └── main/
     ├── java/com/app/quanitymeasurement/
     │   ├── controller/
     │   ├── service/
     │   ├── repository/
     │   ├── model/
     │   └── unit/
     └── resources/
         ├── application.properties
         └── ...
pom.xml
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```
git clone <repo-url>
cd QuantityMeasurementApp
```

### 2️⃣ Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/quantityMeasurement
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

### 3️⃣ Run Application

```
mvn spring-boot:run
```

---

## 🌐 API Endpoints

### 🔹 Base URL

```
http://localhost:8080/api/quantities
```

---

### ➕ Add Quantities

```
POST /add
```

#### 📦 Request Body

```
{
  "thisQuantityDTO": {
    "value": 5,
    "unit": "FEET",
    "measurementType": "LengthUnit"
  },
  "thatQuantityDTO": {
    "value": 12,
    "unit": "INCHES",
    "measurementType": "LengthUnit"
  }
}
```

---

### 🔄 Convert Quantity

```
POST /convert
```

---

### ⚖️ Compare Quantities

```
POST /compare
```

---

### ➖ Subtract Quantities

```
POST /subtract
```

---

### ➗ Divide Quantities

```
POST /divide
```

---

### 📜 Get Operation History

```
GET /history/operation/{operation}
```

---

### 📊 Get Operation Count

```
GET /count/{operation}
```

---

### ❌ Get Error History

```
GET /history/errored
```

---

## 📘 Swagger UI

Access API documentation:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚠️ Important Notes

* Ensure **same measurement types** are used in operations
* Supported types:

  * `LengthUnit`
  * `WeightUnit`
  * `VolumeUnit`
  * `TemperatureUnit`

---

## 💡 Future Improvements

* 🔐 Add JWT Authentication
* 🌍 Deploy on AWS (EC2 / Elastic Beanstalk)
* 🎨 Angular Frontend Integration
* 📈 Dashboard for analytics

---
