# Spring Assignment
Hướng dẫn:
- Chỉnh sửa url và password trong file application.properties (localhost:3307 thành localhost:3306 và password nếu có).
- Chạy Project. DB sẽ tự tạo. Chọn Products hoặc Categories để xem list. Click vào Add Product (Hoặc Add Category nếu chọn Categories) để thêm bản ghi mới.
- Khi tạo nhiều hơn 5 bản ghi ở trong phần Product thì sẽ có phân trang, 5 bản ghi = 1 trang.
- Các source dùng trong project:
+ localhost:8080 - trang index, có thể chọn list product hoặc category ở đây
+ localhost:8080/Admin/Product - trang List Product
+ localhost:8080/Admin/Category - trang List Category
* Lưu ý: Project có Dto nhưng vì gặp lỗi (cả khi dùng mapstruct hoặc map bằng tay) nên không thể sử dụng được. Trong project sử dụng trực tiếp entity thay vì map sang dto.
