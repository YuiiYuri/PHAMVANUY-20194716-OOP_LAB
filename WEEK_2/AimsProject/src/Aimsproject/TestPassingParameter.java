package Aimsproject;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        swapTitles(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("\nAfter changeTitle:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
    }

    // Đổi tiêu đề của hai DVD thay vì hoán đổi đối tượng
    public static void swapTitles(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        String tmp = d1.getTitle();
        d1.setTitle(d2.getTitle());
        d2.setTitle(tmp);
    }

    // Thay đổi tiêu đề mà không tạo đối tượng mới
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
    }
}

