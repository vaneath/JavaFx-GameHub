module javafx.gamehub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens javafx.gamehub to javafx.fxml;
    exports javafx.gamehub;

    opens javafx.gamehub.Tictactoe to javafx.fxml;
    exports javafx.gamehub.Tictactoe;

    opens javafx.gamehub.Tetris to  javafx.fxml;
    exports javafx.gamehub.Tetris;

    exports javafx.gamehub.pingpong;

}