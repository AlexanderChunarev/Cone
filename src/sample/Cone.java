package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cone {
    private double firstAngle, secondAngle;
    private double coneX1, coneY1;
    private double linkedX1, linkedY1;

    public Cone(double firstAngle, double secondAngle) {
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
    }

    private void drawCone(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.GREEN);
        graphicsContext.setGlobalAlpha(0.5);
        double first, second;
        if (firstAngle < secondAngle) {
            first = firstAngle;
            second = secondAngle;
        }
        else {
            first = secondAngle;
            second = firstAngle;
        }
        for (int i = (int) first; i <= second; i++) {
            coneX1 = 200 + Math.sin(Math.toRadians(i + 90)) * 350;
            coneY1 = 200 + Math.cos(Math.toRadians(i + 90)) * 350;
            graphicsContext.strokeLine(200, 200, coneX1, coneY1);
        }
    }

    private void drawVericals(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.DARKBLUE);
        double first, second;
        if (firstAngle < secondAngle) {
            second = firstAngle + 180;
            first = secondAngle;
        } else {
            first = firstAngle;
            second = secondAngle + 180;
        }
        for (int i = (int) first; i <= second; i++) {
            linkedX1 = 200 + Math.sin(Math.toRadians(i)) * 350;
            linkedY1 = 200 + Math.cos(Math.toRadians(i)) * 350;
            graphicsContext.strokeLine(200, 200, linkedX1, linkedY1);
        }
    }


    public void draw(GraphicsContext graphicsContext) {
        drawCone(graphicsContext);
        drawVericals(graphicsContext);

    }
}
