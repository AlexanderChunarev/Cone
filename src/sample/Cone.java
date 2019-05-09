package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;


public class Cone extends Pane {
    private int x1, y1, x2, y2;
    private Line line1;
    private Line line2;
    private Line verLine1;
    private Line verLine2;


    Cone(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    void drawCone(Pane pane) {
        line1 = new Line(200, 200, x1, y1);
        line2 = new Line(200, 200, x2, y2);
        line1.setStroke(Color.RED);
        line2.setStroke(Color.RED);
        drawVerticals(line1, line2, pane);
        pane.getChildren().addAll(line1, line2);
    }

    private void drawVerticals(Line firstLine, Line secondLine, Pane pane) {
        if (firstLine.getEndY() > secondLine.getEndY()) {
            verLine1 = new Line(200, 200
                    , firstLine.getEndY()
                    , Math.abs(firstLine.getStartX() - firstLine.getEndX() + firstLine.getStartY()));
            verLine2 = new Line(200, 200
                    , secondLine.getStartX() - secondLine.getEndY() + secondLine.getStartX()
                    , secondLine.getEndX());
        } else {
            verLine1 = new Line(200, 200
                    , secondLine.getStartX() - firstLine.getEndY() + firstLine.getStartX()
                    , firstLine.getEndX());
            verLine2 = new Line(200, 200
                    , secondLine.getEndY(),
                    Math.abs(secondLine.getStartX() - secondLine.getEndX() + secondLine.getStartY()));

        }

        verLine1.setStroke(Color.BLUE);
        verLine2.setStroke(Color.BLUE);
        pane.getChildren().addAll(verLine1, verLine2);
    }

    void fillCone(Pane pane) {
        Polygon polygon = new Polygon();
        if (line1.getEndX() > 0)
        polygon.getPoints().addAll(200.0, 200.0,
                verLine1.getEndX(), verLine1.getEndY(),
                line2.getEndX(), line2.getEndY(),
                line1.getEndX(), line1.getEndY(),
                verLine2.getEndX(), verLine2.getEndY());
        polygon.setFill(Color.GREEN);
        polygon.setOpacity(0.5);
        pane.getChildren().add(polygon);
    }
}
