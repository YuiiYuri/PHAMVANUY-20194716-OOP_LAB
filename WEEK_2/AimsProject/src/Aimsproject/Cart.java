package Aimsproject;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    // Thêm một DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is full! Cannot add more DVDs.");
        }
    }

    // Thêm danh sách DVD (Method Overloading)
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered++] = dvdList[i];
                System.out.println("Added: " + dvdList[i].getTitle());
            } else {
                System.out.println("The cart is full! Cannot add \"" + dvdList[i].getTitle() + "\".");
                break;
            }
        }
    }

    // Thêm 2 DVD cùng lúc (Method Overloading)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered <= MAX_NUMBER_ORDERED - 2) {
            itemsOrdered[qtyOrdered++] = dvd1;
            itemsOrdered[qtyOrdered++] = dvd2;
            System.out.println("Added: " + dvd1.getTitle() + " and " + dvd2.getTitle());
        } else {
            System.out.println("Not enough space to add two DVDs.");
        }
    }

    // Xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty! No DVD to remove.");
            return;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1]; // Dời các DVD còn lại lên trên
                }
                itemsOrdered[--qtyOrdered] = null; // Xóa phần tử cuối cùng
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return; // Dừng vòng lặp ngay sau khi xóa
            }
        }
        System.out.println("The disc \"" + disc.getTitle() + "\" is not found in the cart.");
    }

    // Tính tổng giá tiền của các DVD trong giỏ hàng
    public float totalCost() {
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    // Hiển thị danh sách DVD trong giỏ hàng
    public void display() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty!");
            return;
        }
        System.out.println("\n=== Your Cart ===");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i]);
        }
        System.out.println("Total Cost: $" + totalCost());
        System.out.println("==================\n");
    }
}
