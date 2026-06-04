package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    private Store store;
    private Cart cart;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button btnViewCart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        int column = 0;
        int row = 0;
        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Item.fxml"));
                Parent itemPane = loader.load();
                ItemController controller = loader.getController();
                controller.setData(media, cart);

                gridPane.add(itemPane, column, row);
                column++;
                if (column == 3) {
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnViewCartPressed() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Cart.fxml"));
            CartController controller = new CartController(cart);
            loader.setController(controller);
            Parent cartRoot = loader.load();

            Stage stage = (Stage) btnViewCart.getScene().getWindow();
            stage.setScene(new Scene(cartRoot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
