package Aimsproject;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id; // Không cần static, mỗi DVD có id riêng
    private static int nbDigitalVideoDiscs = 0;

    // Getter cho số lượng DVD đã tạo
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Getter cho ID của DVD
    public int getId() {
        return id;
    }

    // Getter & Setter cho các thuộc tính
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() { // Sửa tên hàm từ getDirectory() thành getDirector()
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Constructor chỉ có tiêu đề
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; // Mỗi DVD có ID duy nhất
    }

    // Constructor có tiêu đề, thể loại, giá
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title); // Gọi constructor đầu tiên
        this.category = category;
        this.cost = cost;
    }

    // Constructor có tiêu đề, thể loại, đạo diễn, giá
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost); // Gọi constructor trước đó
        this.director = director;
    }

    // Constructor đầy đủ thông tin
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost); // Gọi constructor trước đó
        this.length = length;
    }

    // Ghi đè phương thức toString() để hiển thị thông tin dễ dàng hơn
    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Category: " + category +
                (director != null ? " | Director: " + director : "") +
                (length > 0 ? " | Length: " + length + " mins" : "") +
                " | Cost: $" + cost;
    }
}
