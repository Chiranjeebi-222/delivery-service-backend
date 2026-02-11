# Delivery Service Backend - Gunupur 🚀

A Spring Boot REST API designed to power a localized delivery platform. This backend manages store listings, food menus, user synchronization, and a TikTok-style "Reels" video feature.

## 🛠 Tech Stack
* **Java 17** (Amazon Corretto/OpenJDK)
* **Spring Boot 3.x**
* **Spring Data JPA** (Hibernate)
* **MySQL** Database
* **Git** for Version Control

## 📁 Project Structure
The core logic is located in the `com.deliveryservice.backend` package:

* **Controllers**: Define REST endpoints for Android/Frontend communication.
* **Services**: Handle business logic (e.g., `StoreService`, `OrderService`).
* **Repositories**: Interface with MySQL using Spring Data JPA.
* **Entities**: Java representations of database tables (e.g., `Store`, `Reel`, `User`).

## 📡 API Documentation

### 📹 Reels & Content
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/reels/all` | Fetch all video reels |
| `POST` | `/api/reels/create` | Upload a new reel and auto-init metadata |

### 🏪 Store Management
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/gunupur/stores` | Get all available stores |
| `GET` | `/gunupur/{cityid}` | Get stores filtered by city |
| `GET` | `/gunupur/{cityid}/adminBanner` | Fetch promotional banners |

### 🍔 Menu & Items
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/gunupur/{cityid}/{sid}/phone/items` | Fetch all items for a specific shop |
| `GET` | `/api/reels/{id}/view` | Increment view count for a reel |

### 👤 User & Orders
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/users/sync` | Sync Firebase User UID with local database |
| `POST` | `/api/orders/create` | Submit a new delivery order |

## 🚀 Setup & Installation

1. **Database**: Create a MySQL database named `reeldb`.
2. **Configuration**: Update `src/main/resources/application.properties` with your database credentials.
3. **Run**: Execute `BackendApplication.java` from NetBeans or your terminal.
   ```bash
   mvn spring-boot:run
