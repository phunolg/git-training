# Employee Management System - Module 1

Module 1 giới thiệu Spring Boot và kiểm tra project bằng REST API `/hello`.

## Yêu cầu

- Java 17 trở lên
- Maven 3.9 trở lên

## Chạy project

Từ thư mục `Mini Project/Module 1`:

```bash
mvn spring-boot:run
```

Hoặc build file JAR:

```bash
mvn clean package
java -jar target/employee-management-0.0.1-SNAPSHOT.jar
```

## Kiểm tra API

Mở trình duyệt hoặc gọi:

```text
http://localhost:8080/hello
```

Kết quả:

```text
Hello, Employee Management System!
```
