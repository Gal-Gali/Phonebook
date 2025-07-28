import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import java.util.Map;
//represents the graphic part of the phonebook
public class PhonebookController {

    @FXML
    private TextField search;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TableView<Map.Entry<String,String>> book;
    @FXML
    private TableColumn<Map.Entry<String,String>, String> nameColumn;

    @FXML
    private TableColumn<Map.Entry<String,String>, String> phoneColumn;
    private Phonebook phonebook;
    //initialize the phonebook
    public void initialize()
    {
        phonebook = new Phonebook();
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue()));
    }
    // add the contact to the phonebook
    @FXML
    void add(ActionEvent event) {
        name.setStyle("");
        if (!name.getText().isEmpty())
        {
            phonebook.add(name.getText(), phone.getText());
            printBook();
            name.setText("");
            phone.setText("");
        }
        else {
            if (!phone.getText().isEmpty())
            {
                name.setStyle("-fx-text-box-border: red;");
            }
        }
    }
    //delete the contact of the given name
    @FXML
    void delete(ActionEvent event) {
        name.setStyle("");
        phonebook.remove(name.getText());
        printBook();
        name.setText("");
        phone.setText("");
    }
    // present the contact of the given name, if the name is empty show all the contacts
    @FXML
    void search(ActionEvent event) {
        if (!search.getText().isEmpty())
        {
            book.getItems().clear();
            book.getItems().addAll(phonebook.search(search.getText()).entrySet());
        }
        else {
            printBook(); //if the search text is empty show all the contacts
        }
    }
    // allow to type on phone TextField only numbers and '-'
    @FXML
    void checkPhoneInput(KeyEvent event) {
        if (!event.getText().equals("-"))
        {
            if (!(event.getText().compareTo("0") >=0 && event.getText().compareTo("9")<=0))
            {
                int position = phone.getCaretPosition();
                String temp = phone.getText().replace(event.getText(),"");
                if (temp.equals(phone.getText()))
                {
                    phone.setText(temp);
                    phone.positionCaret(position);
                }
                else {
                    phone.setText(temp);
                    phone.positionCaret(position-1);
                }
            }
        }
    }
    // print the phonebook
    private void printBook()
    {
        book.getItems().clear();
        book.getItems().addAll(phonebook.getPhonebook().entrySet());
    }

}
