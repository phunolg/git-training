# Employee Management System - Module 3

Module 3 thực hành REST API cơ bản với dữ liệu nhân viên lưu trong bộ nhớ:

- `GET /api/employees`: lấy toàn bộ nhân viên.
- `GET /api/employees?department=IT`: lọc theo `@RequestParam`.
- `GET /api/employees/{id}`: lấy một nhân viên theo `@PathVariable`.
- `POST /api/employees`: thêm nhân viên mới bằng `@RequestBody`.
- Các API trả về `ResponseEntity` với HTTP status phù hợp.

## Chạy project

Từ thư mục `Mini Project/Module 3`:

```bash
mvn spring-boot:run
```

## Ví dụ gọi API

Lấy danh sách:

```text
GET http://localhost:8080/api/employees
```

Thêm nhân viên:

```http
POST http://localhost:8080/api/employees
Content-Type: application/json

{
  "name": "Le Van C",
  "department": "Finance",
  "position": "Accountant"
}
```
