# Employee Management System - Module 5

Module 5 bổ sung validation và xử lý exception toàn cục:

- `@NotBlank`, `@Size`, `@Email`, `@NotNull` trên `EmployeeRequest`.
- `@Valid` và `BindingResult` kiểm tra request body.
- `@RestControllerAdvice` trả lỗi JSON thống nhất.
- Employee không tồn tại trả HTTP 404.
- JSON sai định dạng, dữ liệu validation sai hoặc department không tồn tại trả HTTP 400.

## Chạy project

Từ thư mục `Mini Project/Module 5`:

```bash
mvn spring-boot:run
```

## Ví dụ request hợp lệ

```http
POST http://localhost:8080/api/employees
Content-Type: application/json

{
  "name": "Le Van C",
  "email": "le.van.c@example.com",
  "departmentId": 1
}
```

Request sai sẽ có dạng:

```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "Request validation failed.",
  "fieldErrors": {
    "email": "Email must be valid."
  }
}
```
