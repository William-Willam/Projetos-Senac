/**
 * 
 */
/**
 * 
 */
module LoginAppJavaFX {
    requires javafx.controls;
    requires javafx.fxml;

    opens aplicacao to javafx.fxml;
    exports aplicacao;
}
