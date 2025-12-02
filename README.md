# 📩 Messages Shop – REST API

Ein vollständig strukturiertes Spring-Boot-Projekt zur Verwaltung von Nachrichten.  
Das Projekt demonstriert eine saubere REST-Architektur mit Entity, DTO, Repository, Service, Controller und Swagger/OpenAPI.

---

## 🚀 Features

- CRUD-Operationen für Nachrichten (`Message`)
- Saubere Layer-Architektur (Controller → Service → Repository)
- DTO-Mapping + Validierung
- Automatische Zeitstempel (`@PrePersist`, `@PreUpdate`)
- API-Dokumentation mit Swagger / Springdoc
- Unterstützung mehrerer Profile (`dev`, `prod`)
- `.env`-Datei für sensible Variablen

---

## 🛠️ Tech Stack

- Java 21  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- Lombok  
- Jakarta Validation  
- Springdoc OpenAPI / Swagger UI  
- H2 oder Microsoft SQL Server  
- Maven  

---

## 📁 Projektstruktur

```
src/main/java/com.demofirma.messages
 ├── controllers
 │    ├── MessageController.java
 │    └── impl/MessageControllerImpl.java
 ├── domain
 │    ├── entity/Message.java
 │    └── dto/MessageDTO.java
 ├── repositories
 │    └── MessageRepository.java
 ├── services
 │    └── MessageService.java
 └── utils
      └── ApiResponsesCustom.java

src/main/resources
 ├── application.yaml
 ├── application-dev.yaml
 └── application-prod.yaml
```

---

## ⚙️ Installation & Setup

### 1️⃣ Projekt klonen

```bash
git clone https://github.com/<DEIN-NAME>/messages-shop.git
cd messages-shop
```

---

### 2️⃣ `.env` Datei erstellen

Im Projektverzeichnis:

```dotenv
SPRING_PROFILES_ACTIVE=dev

DEV_SQL_DB_URL=jdbc:sqlserver://localhost:1433;databaseName=message_shop;encrypt=false;trustServerCertificate=true
DEV_SQL_DB_USERNAME=dev_user
DEV_SQL_DB_PASSWORD=dein_passwort
DEV_SQL_DB_DRIVER=com.microsoft.sqlserver.jdbc.SQLServerDriver
DEV_JPA_DIALECT=org.hibernate.dialect.SQLServerDialect
```

---

### 3️⃣ IntelliJ Run/Debug konfigurieren

**Run → Edit Configurations → Environment Variables**

```
SPRING_PROFILES_ACTIVE=dev
```

oder die `.env`-Datei verbinden.

---

## ▶️ Anwendung starten

### IntelliJ

Projekt starten über:

```
MessagesShopApplication
```

### Maven

```bash
mvn spring-boot:run
```

### JAR

```bash
java -jar target/messages-*.jar --spring.profiles.active=dev
```

---

## 📚 Swagger / OpenAPI

Automatische API-Dokumentation:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 REST Endpunkte (CRUD)

### ➕ POST `/api/messages`

**Request**
```json
{
  "text": "Hallo Welt"
}
```

**Response 201**
```json
{
  "id": 1,
  "text": "Hallo Welt",
  "createDate": "2025-11-27T12:30:15",
  "updateDate": "2025-11-27T12:30:15"
}
```

---

### 📄 GET `/api/messages`

```json
[
  {
    "id": 1,
    "text": "Hallo Welt",
    "createDate": "2025-11-27T12:30:15",
    "updateDate": "2025-11-27T12:30:15"
  }
]
```

---

### 🔍 GET `/api/messages/{id}`

```json
{
  "id": 1,
  "text": "Hallo Welt",
  "createDate": "2025-11-27T12:30:15",
  "updateDate": "2025-11-27T12:30:15"
}
```

---

### ✏️ PUT `/api/messages`

**Request**
```json
{
  "id": 1,
  "text": "Hallo Welt (aktualisiert)"
}
```

**Response**
```json
{
  "id": 1,
  "text": "Hallo Welt (aktualisiert)",
  "createDate": "2025-11-27T12:30:15",
  "updateDate": "2025-11-27T12:45:40"
}
```

---

### ❌ DELETE `/api/messages/{id}`

**Response 200**

```
(no content)
```

---

## 🏗️ Architekturprinzipien

- **Controller** – verarbeitet HTTP-Anfragen, validiert Daten, ruft Service auf  
- **Service** – enthält Business-Logik und steuert Repository-Aufrufe  
- **Repository** – Datenbankzugriff per JPA  
- **Entity (`Message`)** – Datenbankmodell  
- **DTO (`MessageDTO`)** – Modell für Außensicht + Validierung  
- **Swagger** – automatische API-Dokumentation  
- **Profile & .env** – trennen Konfigurationen für dev und prod  

---

## 📌 Maven Befehle

```bash
mvn clean
mvn test
mvn package
mvn spring-boot:run
```

---

## 👤 Autor

**Wladimir Weizen**  
Messages Shop – Demo REST API  
Erstellt: 27.11.2025
