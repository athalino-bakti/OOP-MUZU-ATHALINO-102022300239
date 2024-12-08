//NAUFAL ATHALINO BAKTI
// 102022300239
// SI-47-09

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryController {

    @FXML
    private TextField albumField, artistField, totalField, availableField, rentedField;
    @FXML
    private Button addButton;
    @FXML
    private TableView<Album> tableView;
    @FXML
    private TableColumn<Album, String> columnAlbum, columnArtist;
    @FXML
    private TableColumn<Album, Integer> columnAvailable, columnTotal;

    private ObservableList<Album> albumList;

    public InventoryController() {
        albumList = FXCollections.observableArrayList();
    }

    // menginisialisasi tableView dengan data
    @FXML
    public void initialize() {
        columnAlbum.setCellValueFactory(cellData -> cellData.getValue().albumNameProperty());
        columnArtist.setCellValueFactory(cellData -> cellData.getValue().artistProperty());
        columnAvailable.setCellValueFactory(cellData -> cellData.getValue().availableProperty().asObject());
        columnTotal.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());

        tableView.setItems(albumList); // 
    }

    // menangani tombol Add
    @FXML
    private void addAlbum() {
        try {
            String title = albumField.getText();
            String artist = artistField.getText();

            // validasi input
            if (title.isEmpty() || artist.isEmpty()) {
                throw new IllegalArgumentException("Album name and artist cannot be empty.");
            }

            int total = Integer.parseInt(totalField.getText());
            int rented = Integer.parseInt(rentedField.getText());
            int available = Integer.parseInt(availableField.getText());

            if (total < 0 || rented < 0 || available < 0) {
                throw new IllegalArgumentException("Total, rented, and available albums cannot be negative.");
            }

            // membuat album baru dan menambahkannya ke list
            Album album = new Album(title, artist, total, rented, available);
            albumList.add(album);

            // menampilkan alert sukses
            showAlert(AlertType.INFORMATION, "Success", "Album added successfully!");

        } catch (NumberFormatException e) {
            // menampilkan alert jika input tidak bisa diparsing menjadi angka
            showAlert(AlertType.ERROR, "Input Error", "Please enter valid numbers for total, rented, and available albums.");
        } catch (IllegalArgumentException e) {
            // menampilkan alert untuk kasus input yang tidak valid
            showAlert(AlertType.ERROR, "Input Error", e.getMessage());
        }
    }

    // menghapus album yang dipilih
    @FXML
    private void deleteAlbum() {
        Album selectedAlbum = tableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
            // menampilkan alert sukses
            showAlert(AlertType.INFORMATION, "Success", "Album deleted successfully!");
        } else {
            showAlert(AlertType.WARNING, "Selection Error", "No album selected for deletion.");
        }
    }

    // mengupdate album yang dipilih
    @FXML
    private void updateAlbum() {
        Album selectedAlbum = tableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                selectedAlbum.setAlbumName(albumField.getText());
                selectedAlbum.setArtist(artistField.getText());

                // Validasi input
                int total = Integer.parseInt(totalField.getText());
                int available = Integer.parseInt(availableField.getText());
                int rented = Integer.parseInt(rentedField.getText());

                if (total < 0 || rented < 0 || available < 0) {
                    throw new IllegalArgumentException("Total, rented, and available albums cannot be negative.");
                }

                selectedAlbum.setTotal(total);
                selectedAlbum.setAvailable(available);
                selectedAlbum.setRented(rented);

                // menampilkan alert sukses
                showAlert(AlertType.INFORMATION, "Success", "Album updated successfully!");

            } catch (NumberFormatException e) {
                // menampilkan alert jika input tidak bisa diparsing menjadi angka
                showAlert(AlertType.ERROR, "Input Error", "Please enter valid numbers for total, rented, and available albums.");
            } catch (IllegalArgumentException e) {
                // menampilkan alert untuk kasus input yang tidak valid
                showAlert(AlertType.ERROR, "Input Error", e.getMessage());
            }
        } else {
            showAlert(AlertType.WARNING, "Selection Error", "No album selected for update.");
        }
    }

    // menyewa album yang dipilih
    @FXML
    private void rentAlbum() {
        Album selectedAlbum = tableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null && selectedAlbum.getAvailable() > 0) {
            selectedAlbum.setAvailable(selectedAlbum.getAvailable() - 1);
            selectedAlbum.setRented(selectedAlbum.getRented() + 1);
            showAlert(AlertType.INFORMATION, "Success", "Album rented successfully!");
        } else {
            showAlert(AlertType.WARNING, "Error", "No available albums to rent.");
        }
    }

    // menampilkan alert dengan tipe dan pesan
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
