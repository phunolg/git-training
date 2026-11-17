# Employee Management System - Module 2

Module 2 thực hành Custom Bean và IoC/Dependency Injection:

- `UtilityService` được đăng ký bằng `@Service`.
- `PasswordEncoder` được định nghĩa bằng `@Bean` trong `AppConfig`.
- `EmployeeService` nhận `UtilityService` và `PasswordEncoder` bằng constructor injection.
- `EmployeeController` nhận `EmployeeService` bằng constructor injection.

## Chạy project

Từ thư mục `Mini Project/Module 2`:

```bash
mvn spring-boot:run
```

## Kiểm tra API

API kiểm tra project:

```text
http://localhost:8080/hello
```

API minh họa việc inject service và custom bean:

```text
http://localhost:8080/employees/preview?name=nguyen%20van%20a&password=secret123
```

Kết quả gồm mã nhân viên tự động, tên được chuẩn hóa và mật khẩu đã mã hóa BCrypt.
