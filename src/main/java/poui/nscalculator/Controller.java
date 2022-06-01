package poui.nscalculator;

import javafx.beans.binding.BooleanBinding;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.math.BigInteger;
import java.util.Objects;


public class Controller {

    @FXML
    private TextField input;

    @FXML
    private Label output;

    @FXML
    private TextField nsinput;

    @FXML
    private RadioButton other;

    @FXML
    private Label errorLabel;

    private static int ns;

    private static String history = "";

    @FXML
    protected void binaryChoose() { ns = 102; }

    @FXML
    protected void octalChoose() { ns = 108; }

    @FXML
    protected void hexadecimalChoose() { ns = 116; }

    @FXML
    protected void anotherChoose() { ns = 0; }

    @FXML
    protected void cleanButton() {
        history = "";
        output.setText(history);
    }

    @FXML
    protected void convertClick() {
        if (ns != 102 & ns != 108 & ns != 116) {
            if (Objects.equals(nsinput.getText(), "")){
                errorLabel.setText("Система счисления не выбрана");
            }else{
                if (Integer.parseInt(nsinput.getText()) > 36 || Integer.parseInt(nsinput.getText()) < 2) {
                    errorLabel.setText("Выберете число из диапазона от 2 до 36");
                }else {
                    ns = Integer.parseInt(nsinput.getText());

                    BigInteger value = new BigInteger(input.getText());
                    String newValue = value.toString(ns);

                    history = history + input.getText() + "/" + ns + ": " + newValue  + "\n";
                    output.setText(history);
                    ns = 0;
                    nsinput.clear();
                    errorLabel.setText("");
                }
            }
        }else{
            if (Objects.equals(input.getText(), "")){
                errorLabel.setText("Вы не ввели число");
            }else{
                BigInteger value = new BigInteger(input.getText());
                String newValue = value.toString(ns - 100);

                history = history + input.getText() + "/" + (ns - 100) + ": " + newValue  + "\n";
                output.setText(history);
                errorLabel.setText("");
            }
        }
    }

    @FXML
    private void initialize() {
        BooleanBinding disable = other.selectedProperty().not();
        nsinput.disableProperty().bind(disable);

        input.addEventFilter(KeyEvent.KEY_TYPED , textValidation(10));
        nsinput.addEventFilter(KeyEvent.KEY_TYPED , textValidation(2));
    }

    public EventHandler<KeyEvent> textValidation(Integer maxLength) { // валидация
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField text = (TextField) e.getSource();
                if (text.getText().length() >= maxLength) {
                    e.consume();
                }
                if(!e.getCharacter().matches("[0-9]")){
                    e.consume();
                }
            }
        };
    }

}
