package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class Panel extends Group {
    private Pane pane;
    private Line XAxis;
    private Line YAxis;
    private Label labelX = new Label("X1: ");
    private Label labelY = new Label("Y1: ");
    private Label labelX2 = new Label("X2: ");
    private Label labelY2 = new Label("Y2: ");
    private TextField textAreaX = new TextField("400");
    private TextField textAreaY = new TextField("170");
    private TextField textAreaX2 = new TextField("400");
    private TextField textAreaY2 = new TextField("55");
    private Button button = new Button("Draw");
    private final int CENTER_X = 200;
    private final int CENTER_Y = 200;
    private int x1, y1, x2, y2;

    Panel() {
        pane = new Pane();
        XAxis = new Line(0, 200, 400, 200);
        YAxis = new Line(200, 0, 200, 400);
        pane.getChildren().addAll(XAxis, YAxis);
        getChildren().addAll(labelX, labelY, labelX2, labelY2);
        getChildren().addAll(textAreaX, textAreaY, textAreaX2, textAreaY2);
        getChildren().add(pane);
        getChildren().add(button);
        button.setOnAction(event -> {
            repaint();
            getValues();
            Cone cone = new Cone(x1, y1, x2, y2);
            cone.drawCone(pane);
            cone.fillCone(pane);
        });
        setProperties();
    }

    private void getValues() {
        x1 = Integer.parseInt(textAreaX.getText());
        y1 = Integer.parseInt(textAreaY.getText());
        x2 = Integer.parseInt(textAreaX2.getText());
        y2 = Integer.parseInt(textAreaY2.getText());
    }

    private void repaint() {
        pane.getChildren().clear();
        XAxis = new Line(0, 200, 400, 200);
        YAxis = new Line(200, 0, 200, 400);
        pane.getChildren().addAll(XAxis, YAxis);
    }

    private void setProperties() {
        pane.setTranslateY(100);
        pane.setStyle("-fx-background-color: #828887;");
        pane.setPrefSize(400, 400);

        labelX.setFont(Font.font("Verdana", 24));
        labelX.setTranslateY(10);
        textAreaX.setTranslateX(50);
        textAreaX.setTranslateY(labelX.getTranslateY());
        textAreaX.setPrefSize(70,30);

        labelY.setFont(Font.font("Verdana", 24));
        labelY.setTranslateY(50);
        textAreaY.setTranslateX(50);
        textAreaY.setTranslateY(labelY.getTranslateY());
        textAreaY.setPrefSize(70,30);

        labelX2.setFont(Font.font("Verdana", 24));
        labelX2.setTranslateY(10);
        labelX2.setTranslateX(200);
        textAreaX2.setTranslateX(250);
        textAreaX2.setTranslateY(labelX2.getTranslateY());
        textAreaX2.setPrefSize(70,30);

        labelY2.setFont(Font.font("Verdana", 24));
        labelY2.setTranslateY(50);
        labelY2.setTranslateX(200);
        textAreaY2.setTranslateX(250);
        textAreaY2.setTranslateY(labelY2.getTranslateY());
        textAreaY2.setPrefSize(70,30);

        button.setTranslateX(330);
        button.setTranslateY(10);
    }

}
