package truongvx.shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Custom Shape");

        Group root = new Group();
        Canvas canvas = new Canvas(400, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Vẽ tam giác
        gc.strokePolygon(new double[]{200, 50, 350}, new double[]{50, 250, 250}, 3);

        // Làm đoạn cung 1 dài ra từ trái qua
        gc.strokeArc(125, 210, 150, 150, 0, 50, ArcType.OPEN);   // Đoạn cung 1 (dài ra)
        gc.strokeArc(125, 225, 150, 150, 120, 80, ArcType.OPEN); // Đoạn cung 2
        gc.strokeArc(125, 175, 150, 150, 240, 80, ArcType.OPEN); // Đoạn cung 3

        // Vẽ hai hình tròn nhỏ bên dưới hình tròn lớn
        gc.strokeOval(140, 300, 30, 30);
        gc.strokeOval(230, 300, 30, 30);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
