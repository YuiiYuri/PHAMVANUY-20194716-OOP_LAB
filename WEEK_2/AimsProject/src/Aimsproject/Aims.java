package Aimsproject;

public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart anOrder = new Cart();

        // Tạo DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.85f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Thêm DVD vào giỏ hàng
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd1);

        // Hiển thị giỏ hàng
        anOrder.display();

        // Kiểm tra thêm danh sách DVD và xóa DVD
        System.out.println("\n=== TESTING ADDING & REMOVING DVD ===");
        DigitalVideoDisc[] dvdList = {
            new DigitalVideoDisc("Movie A", "Action", "Director A", 120, 15.0f),
            new DigitalVideoDisc("Movie B", "Comedy", 10.0f),
            new DigitalVideoDisc("Movie C", "Drama", "Director C", 150, 20.0f)
        };

        anOrder.addDigitalVideoDisc(dvdList); // Thêm nhiều DVD
        anOrder.display(); // Hiển thị giỏ hàng sau khi thêm

        // Xóa một DVD
        anOrder.removeDigitalVideoDisc(dvdList[2]);
        anOrder.display(); // Hiển thị lại giỏ hàng
    }
}
