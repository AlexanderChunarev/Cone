package sample;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

class Panel extends Group {
    private Line XAxis, YAxis;
    private Pane pane = new Pane();
    private Label label1 = new Label("Angle 1: ");
    private Label label2 = new Label("Angle 2: ");
    private Button draw = new Button("Draw");
    private TextField firstAngle = new TextField();
    private TextField secondAngle = new TextField();
    private Canvas canvas = new Canvas(400, 400);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    private Cone cone;

    Panel() {
        pane.setTranslateY(100);
        XAxis = new Line(0, 200, 400, 200);
        YAxis = new Line(200, 0, 200, 400);
        pane.setStyle("-fx-background-color: gray");
        pane.setStyle(" -fx-background-color: #D3D3D333,\n" +
                "        linear-gradient(from 0.5px 0px to 10.5px 0px, repeat, lightgray 5%, transparent 5%),\n" +
                "        linear-gradient(from 0px 0.5px to 0px 10.5px, repeat, lightgray 5%, transparent 5%);");
        pane.setPrefSize(400, 400);
        pane.getChildren().addAll(XAxis, YAxis, canvas);
        getChildren().addAll(pane);
        draw.setOnAction(event -> {
            if (!firstAngle.getText().equals("") && !secondAngle.getText().equals("")) {
                graphicsContext.clearRect(0, 0, 400, 400);
                cone = new Cone(Double.parseDouble(firstAngle.getText())
                        , Double.parseDouble(secondAngle.getText()));
                cone.draw(graphicsContext);
            }
        });
        setProperties();
    }


    private void setProperties() {
        label1.setFont(Font.font("Verdana", 18));
        label1.setTranslateY(10);
        firstAngle.setTranslateX(80);
        firstAngle.setTranslateY(label1.getTranslateY());
        firstAngle.setPrefSize(50, 20);
        label2.setFont(Font.font("Verdana", 18));
        label2.setTranslateY(50);
        secondAngle.setTranslateX(80);
        secondAngle.setTranslateY(label2.getTranslateY());
        secondAngle.setPrefSize(50, 20);
        draw.setTranslateX(200);
        draw.setTranslateY(10);
        getChildren().addAll(label1, label2, firstAngle, secondAngle, draw);
    }
}
