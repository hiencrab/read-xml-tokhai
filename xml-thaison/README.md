# xml-thaison

Đọc file XML tờ khai hải quan (ECUS5VNACCS, định dạng `Root/Header/Body/Declaration/GoodItems`) và lưu vào PostgreSQL.
Import lại cùng số tờ khai thì bản cũ (header, tờ khai, hàng hóa) được đánh dấu `active = false`.

## Yêu cầu
- Java 11+, Maven
- PostgreSQL local, database `thaison` (`CREATE DATABASE thaison ENCODING 'UTF8';`). Bảng được Hibernate tự tạo khi chạy lần đầu.
- Mật khẩu user `postgres` mặc định là `postgres`, đổi bằng biến môi trường `DB_PASSWORD`.

## Chạy
```bash
mvn clean package -DskipTests
```

### Giao diện web
```bash
java -jar target/xml-thaison-1.0.0.jar
```
Mở http://localhost:8080 (chỉ truy cập được từ máy này). Đổi cổng bằng biến môi trường `PORT`.
- **Import:** chọn một hoặc nhiều file `.xml`.
- **Tìm kiếm:** theo số tờ khai, số hóa đơn, khoảng ngày hóa đơn.
- **Xuất Excel:** theo bộ lọc hiện tại; mỗi dòng hàng là một dòng, kèm toàn bộ cột của tờ khai.
- **Chi tiết:** bấm số tờ khai để xem danh sách hàng và toàn bộ trường có dữ liệu.

### Dòng lệnh
```bash
java -jar target/xml-thaison-1.0.0.jar import input                 # cả thư mục
java -jar target/xml-thaison-1.0.0.jar import input/ToKhai_xxxx.xml  # một file
java -jar target/xml-thaison-1.0.0.jar list                          # xem tờ khai đang active
```

## Bảng
| Bảng | Nội dung |
|------|----------|
| `header_report` | Header (App, DBVersion, LastUpdate, Date) |
| `declaration_report` | Tờ khai (~230 cột, `header_id` trỏ tới header) |
| `good_item` | Dòng hàng (`declaration_report_id` trỏ tới tờ khai) |
