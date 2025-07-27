# POC-UNIFIED-EXCHANGE with Exchange-To-Exchange Binding

> Have multiple publishers send messages to a central exchange(unified), when then routes those messages to multiple subscribers(services), using only one routing key.

## 🚀 Features

1. Centralized Message Routing
   - All messages go through one unified exchange for consistent routing coontrol.
2. Exchange-to-Exchange Binding
   - Publishers and subscribers use exchanges, allowing flexible and modular connections.
3. Single Routing Key
   - Simplifies configuration-only one routing key (e.g.,"event") is used throughout.
4. Multi-Publisher Support
   - Multiple services (e.g., Deposit, Withdrawal) can publish without interfering with each other.
5. Multi-Subscriber Distribution
   - Messages are delivered to multiple services (e.g., Notification, Inventory, etc.) simultaneously.
6. Loose Coupling
   - Publishers and subscribers are independent-no direct connections required.
7. Scalability
   - Easy to add new publishers or subscribers by simply binding new exchanges.
8. Fault Isolation
   - Each subscriber can have separate queues, error handling and retry logic.
9. Improved Observability
   - Central logging or monitoring services can be added as subscribers.
10. Easy Maintenance & Testing
    - Clear separation of responsibilities makes debugging and updating simpler.
   
## 📦 Tech Stack 

- Java / Spring Boot
- GraphQL
- Maven
- Docker

## 🛠️ Getting Started 

### Prerequisites

- Java 17
- Maven 4.0
- Spring Boot 3.5.4
- RabbitMQ running locally or via Docker

### Installation
1. Clone the repo:
   ``` bash
   git clone https://github.com/bossvince24/poc-unified-exchange.git
2. Build the project:
   * bash
   mvn clean install
    * eclipse
    pom.xml > right click > Run As > Maven clean > Maven Install
3. Run the application:
   * bash
   mvn spring-boot:run
   * eclipse
   Run As > Java Application

📡 RabbitMQ Setup
If using Docker:
* bash
docker run -d --hostname my-rabbit --name rabbitmq \
  -p 5672:5672 -p 15672:15672 rabbitmq:3-management
  
Access the UI at http://localhost:15672
Default credentials: guest/guest

📬 API Endpoints
| Method | Endpoint        | Description          |
| ------ | --------------- | -------------------- |
| POST   | `/graphql`      | Create a deposit     |
| POST   | `/graphql`      | Process a withdrawal |

🙋‍♂️ Author
Alex John Mataac
(https://github.com/bossvince24/bossvince24)
   
