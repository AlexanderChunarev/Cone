package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cone {
    private double firstAngle, secondAngle;
    private double coneX1, coneY1, coneX2, coneY2;
    private double linkedX1, linkedY1, linkedX2, linkedY2;

    public Cone(double firstAngle, double secondAngle) {
        this.firstAngle = firstAngle;
        this.secondAngle = secondAngle;
    }

    private void drawCone(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.RED);
        coneX1 = 200 + Math.sin(Math.toRadians(firstAngle + 90)) * 350;
        coneY1 = 200 + Math.cos(Math.toRadians(firstAngle + 90)) * 350;
        coneX2 = 200 + Math.sin(Math.toRadians(secondAngle + 90)) * 350;
        coneY2 = 200 + Math.cos(Math.toRadians(secondAngle + 90)) * 350;
        graphicsContext.strokeLine(200, 200, coneX1, coneY1);
        graphicsContext.strokeLine(200, 200, coneX2, coneY2);

    }

    private void drawVericals(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.GREEN);
        if (firstAngle < secondAngle) {
            firstAngle += 180;
        } else {
            secondAngle += 180;
        }
        linkedX1 = 200 + Math.sin(Math.toRadians(firstAngle)) * 350;
        linkedY1 = 200 + Math.cos(Math.toRadians(firstAngle)) * 350;
        linkedX2 = 200 + Math.sin(Math.toRadians(secondAngle)) * 350;
        linkedY2 = 200 + Math.cos(Math.toRadians(secondAngle)) * 350;
        graphicsContext.strokeLine(200, 200, linkedX1, linkedY1);
        graphicsContext.strokeLine(200, 200, linkedX2, linkedY2);
    }

    private void fillSpace(GraphicsContext graphicsContext) {
        graphicsContext.setGlobalAlpha(0.5);
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillPolygon(new double[]{200, coneX1, coneX2}
                , new double[]{200, coneY1, coneY2}, 3);
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillPolygon(new double[]{200, linkedX1, coneX2, coneX1, linkedX2}
                , new double[]{200, linkedY1, coneY2, coneY1, linkedY2}, 5);
    }

    public void draw(GraphicsContext graphicsContext) {
        drawCone(graphicsContext);
        drawVericals(graphicsContext);
        fillSpace(graphicsContext);
    }
}
