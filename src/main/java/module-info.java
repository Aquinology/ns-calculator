module poui.nscalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens poui.nscalculator to javafx.fxml;
    exports poui.nscalculator;
}