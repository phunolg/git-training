# Employee Management System - Module 4

Module 4 thực hành Spring Data JPA với quan hệ `Employee` - `Department`.

## Database

Mặc định project dùng H2 in-memory để có thể chạy lab ngay:

```text
jdbc:h2:mem:employee-management
```

Để chạy PostgreSQL, tạo database `employee_management`, sau đó cấu hình biến môi trường và profile:

```powershell
$env:DB_URL = "jdbc:postgresql://localhost:5432/employee_management"
$env:DB_USERNAME = "postgres"
$env:DB_PASSWORD = "your-password"
mvn spring-boot:run "-Dspring-boot.run.profiles=postgres"
```

## Chạy project

Từ thư mục `Mini Project/Module 4`:

```bash
mvn spring-boot:run
```

## API

- `GET /api/departments`: lấy danh sách phòng ban.
- `GET /api/employees`: lấy toàn bộ nhân viên.
- `GET /api/employees?keyword=IT`: tìm theo tên nhân viên hoặc tên phòng ban.
- `GET /api/employees/{id}`: lấy nhân viên theo ID.
- `POST /api/employees`: thêm nhân viên.
- `PUT /api/employees/{id}`: cập nhật nhân viên.
- `DELETE /api/employees/{id}`: xóa nhân viên.

Ví dụ thêm nhân viên:

```http
POST http://localhost:8080/api/employees
Content-Type: application/json

{
  "name": "Le Van C",
  "email": "le.van.c@example.com",
  "departmentId": 1
}
```
