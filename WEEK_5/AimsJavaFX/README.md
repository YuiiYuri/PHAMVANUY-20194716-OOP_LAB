# 💻 OOP Lab 05 – JavaFX & Exception Handling

- **Branch:** `release/lab05`

---

## 📌 Mô tả chức năng chính

- Hiển thị danh sách sản phẩm (DVD/CD/Book) bằng giao diện JavaFX.
- Cho phép thêm sản phẩm vào giỏ hàng.
- Xem giỏ hàng với tổng tiền và các thao tác: play, remove.
- Xử lý ngoại lệ khi phát media có lỗi (dài ≤ 0).
- Áp dụng Exception Handling với lớp `PlayerException`.
- Tách giao diện bằng FXML & SceneBuilder.

---

## 🗂️ Cấu trúc thư mục

AimsJavaFX/
├── src/
│ └── hust/soict/dsai/aims/...
├── fxml/
│ ├── Store.fxml
│ ├── Cart.fxml
│ └── Item.fxml
├── controller/
│ ├── ViewStoreController.java
│ ├── CartController.java
│ └── ItemController.java
├── design/
│ ├── UseCase.png
│ ├── ClassDiagram.png
│ └── ExceptionTree.png
├── answers.txt
└── README.md


---

## ▶️ Hướng dẫn chạy chương trình

### 1. Cấu hình VM arguments (bắt buộc nếu dùng JavaFX SDK ngoài)

```bash

--module-path "path\to\javafx\lib" --add-modules javafx.controls,javafx.fxml

⚠️ Thay "path\to\javafx\lib" bằng đường dẫn thật đến thư mục lib trong JavaFX SDK của bạn.

2. Chạy file Aims.java hoặc Main.java
File khởi động sẽ mở Store.fxml thông qua ViewStoreController.

🔧 Công cụ sử dụng
Java 17

JavaFX SDK 17+

SceneBuilder 22

Astah Community

GitHub