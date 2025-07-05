# Cloud Native Services

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka)

A comprehensive cloud-native microservices application demonstrating modern enterprise architecture patterns with Spring Boot, Docker, Kubernetes, and observability tools.

## 🏗️ Architecture Overview

![Architecture Diagram](img.png)

This project showcases a complete microservices ecosystem with:
- **API Gateway** with Resilience4J circuit breaker
- **Service Discovery** and registration
- **Event-driven architecture** with Kafka
- **Database per service** pattern
- **Monitoring and observability** with Grafana, Prometheus, and Tempo
- **Containerization** with Docker
- **Orchestration** with Kubernetes

## 🚀 Features

- **🔐 Authentication & Authorization**: Secure service-to-service communication
- **🔄 Circuit Breaker**: Fault tolerance with Resilience4J
- **📊 Monitoring**: Real-time metrics with Prometheus and Grafana
- **🔍 Distributed Tracing**: Request tracing with Tempo
- **📨 Async Communication**: Event-driven messaging with Kafka
- **🐳 Containerized**: Docker and Kubernetes ready
- **📈 Scalable**: Horizontal scaling capabilities
- **🎯 Service Discovery**: Automatic service registration and discovery

## 📋 Table of Contents

- [Services](#services)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Docker Deployment](#docker-deployment)
- [Kubernetes Deployment](#kubernetes-deployment)
- [Monitoring](#monitoring)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## 🔧 Services

| Service | Port | Description | Technology |
|---------|------|-------------|------------|
| **API Gateway** | 8080 | Entry point, routing, load balancing | Spring Cloud Gateway |
| **Product Service** | 8081 | Product catalog management | Spring Boot, MySQL |
| **Order Service** | 8082 | Order processing and management | Spring Boot, PostgreSQL |
| **Inventory Service** | 8083 | Stock and inventory tracking | Spring Boot, MongoDB |
| **Notification Service** | 8084 | Email and SMS notifications | Spring Boot, Kafka |
| **Auth Server** | 8085 | Authentication and authorization | Spring Security, JWT |

## 💻 Tech Stack

### Core Technologies
- **Java 17+** - Programming language
- **Spring Boot 3.x** - Application framework
- **Spring Cloud** - Microservices patterns
- **Spring Security** - Authentication & authorization
- **Maven** - Build automation tool

### Databases
- **MySQL** - Product service database
- **PostgreSQL** - Order service database
- **MongoDB** - Inventory service database

### Message Broker
- **Apache Kafka** - Event streaming platform

### Monitoring & Observability
- **Grafana** - Visualization and dashboards
- **Prometheus** - Metrics collection
- **Tempo** - Distributed tracing
- **Loki** - Log aggregation

### Infrastructure
- **Docker** - Containerization
- **Kubernetes** - Container orchestration
- **Resilience4J** - Circuit breaker implementation

## 🚀 Getting Started

### Prerequisites

- **Java 17+**
- **Maven 3.8+**
- **Docker & Docker Compose**
- **Kubernetes** (optional)

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/khan-sk-dev/cloud-native-services.git
   cd cloud-native-services
   ```

2. **Build all services**
   ```bash
   mvn clean install
   ```

3. **Start with Docker Compose**
   ```bash
   docker-compose up -d
   ```

4. **Verify services are running**
   ```bash
   docker-compose ps
   ```

## 🐳 Docker Deployment

### Build Individual Services
```bash
# Build specific service
cd product-service
mvn clean package
docker build -t product-service:latest .

# Or build all services
./build-all.sh
```

### Docker Compose
```bash
# Start all services
docker-compose up -d

# View logs
docker-compose logs -f [service-name]

# Stop all services
docker-compose down
```

## ☸️ Kubernetes Deployment

### Deploy to Kubernetes
```bash
# Apply all Kubernetes manifests
kubectl apply -f k8s/

# Check deployment status
kubectl get pods -n cloud-native

# Port forward to access services
kubectl port-forward svc/api-gateway 8080:8080
```

### Kubernetes Services
```bash
# Get all services
kubectl get svc

# Get service details
kubectl describe svc api-gateway
```

## 📊 Monitoring

### Grafana Dashboard
- **URL**: `http://localhost:3000`
- **Username**: `admin`
- **Password**: `admin`

### Prometheus Metrics
- **URL**: `http://localhost:9090`
- **Targets**: `http://localhost:9090/targets`

### Application Metrics
Access metrics endpoints:
```bash
# Service health checks
curl http://localhost:8081/actuator/health

# Prometheus metrics
curl http://localhost:8081/actuator/prometheus

# Circuit breaker status
curl http://localhost:8080/actuator/circuitbreakers
```

## 📖 API Documentation

### API Gateway Endpoints
```bash
# Product Service (via Gateway)
GET    /api/products
POST   /api/products
GET    /api/products/{id}
PUT    /api/products/{id}
DELETE /api/products/{id}

# Order Service (via Gateway)
GET    /api/orders
POST   /api/orders
GET    /api/orders/{id}
PUT    /api/orders/{id}

# Inventory Service (via Gateway)
GET    /api/inventory/{productId}
POST   /api/inventory
```

### Sample API Calls
```bash
# Create a product
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99
  }'

# Get all products
curl http://localhost:8080/api/products

# Place an order
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "productId": 1,
    "quantity": 2,
    "customerEmail": "customer@example.com"
  }'
```

## 🔧 Configuration

### Environment Variables
```bash
# Database Configuration
DB_HOST=localhost
DB_PORT=3306
DB_NAME=productdb
DB_USER=root
DB_PASSWORD=password

# Kafka Configuration
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
KAFKA_GROUP_ID=notification-service

# Service Discovery
EUREKA_SERVER_URL=http://localhost:8761/eureka
```

### Application Properties
Each service has its own `application.yml` configuration:
```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/productdb
    username: ${DB_USER:root}
    password: ${DB_PASSWORD:password}
  
  kafka:
    bootstrap-servers: ${KAFKA_BOOTSTRAP_SERVERS:localhost:9092}
    consumer:
      group-id: ${KAFKA_GROUP_ID:product-service}

management:
  endpoints:
    web:
      exposure:
        include: health,info,prometheus,metrics
```

## 🧪 Testing

### Unit Tests
```bash
# Run tests for all services
mvn test

# Run tests for specific service
cd product-service
mvn test
```

### Integration Tests
```bash
# Run integration tests
mvn verify -P integration-tests
```

### Load Testing
```bash
# Using Apache Bench
ab -n 1000 -c 10 http://localhost:8080/api/products

# Using curl for stress testing
for i in {1..100}; do
  curl -X POST http://localhost:8080/api/products \
    -H "Content-Type: application/json" \
    -d '{"name":"Product'$i'","price":99.99}' &
done
```

## 🔍 Troubleshooting

### Common Issues

1. **Port conflicts**
   ```bash
   # Check if ports are in use
   netstat -tulpn | grep :8080
   
   # Kill process using port
   kill -9 $(lsof -ti:8080)
   ```

2. **Database connection issues**
   ```bash
   # Check database connectivity
   docker exec -it mysql-container mysql -u root -p
   ```

3. **Service discovery problems**
   ```bash
   # Check Eureka dashboard
   curl http://localhost:8761/eureka/apps
   ```

### Logs
```bash
# View application logs
docker logs -f product-service

# View all services logs
docker-compose logs -f
```

## 📈 Performance Optimization

### JVM Tuning
```bash
# Optimize JVM parameters
export JAVA_OPTS="-Xms512m -Xmx1024m -XX:+UseG1GC"
```

### Database Optimization
- Connection pooling configuration
- Database indexing strategies
- Query optimization

### Caching
- Redis for distributed caching
- Application-level caching with Spring Cache

## 🤝 Contributing

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**
   ```bash
   git commit -m 'Add some amazing feature'
   ```
4. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Code Style
- Follow Google Java Style Guide
- Use meaningful commit messages
- Add tests for new features
- Update documentation


## 🙏 Acknowledgments

- Spring Boot team for the amazing framework
- Docker for containerization platform
- Kubernetes community for orchestration
- Grafana Labs for monitoring solutions

---

⭐ **Star this repository if you find it helpful!**

**Made with ❤️ by Khan SK Dev**
