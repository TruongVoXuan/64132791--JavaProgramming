package truongvx.shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Custom Shape");

        Group root = new Group();
        Canvas canvas = new Canvas(400, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Vẽ tam giác lớn
        gc.strokePolygon(new double[]{200, 50, 350}, new double[]{50, 250, 250}, 3);

        // Vẽ tam giác ngược nhỏ chính giữa tam giác lớn (mũi chĩa xuống dưới)
        gc.setStroke(Color.RED); // Đặt màu viền là màu đỏ
        gc.strokePolygon(
            new double[]{150, 250, 200}, // Tọa độ x của tam giác nhỏ (đáy dài hơn 2 cạnh bên)
            new double[]{170, 170, 220}, // Tọa độ y của tam giác nhỏ (di chuyển lên trên một chút)
            3
        );

        // Vẽ các đoạn cung
        gc.setStroke(Color.BLACK); // Đặt lại màu viền về màu đen
        gc.strokeArc(125, 225, 155, 150, -130, 80, ArcType.OPEN); // Đoạn cung 1
        gc.strokeArc(125, 225, 150, 150, -38, 80, ArcType.OPEN);  // Đoạn cung 2
        gc.strokeArc(125, 225, 155, 150, -222, 80, ArcType.OPEN); // Đoạn cung 3

        // Vẽ hai hình tròn nhỏ bên dưới hình tròn lớn
        gc.strokeOval(125, 345, 30, 30);
        gc.strokeOval(250, 345, 30, 30);

        // Vẽ 2 đoạn cung nhỏ màu đỏ bên trong hình tròn đầu tiên (bên trái) - Thẳng đứng lên trên
        gc.setStroke(Color.RED); // Đặt màu viền là màu đỏ
// Vẽ cung tròn đầu tiên, góc 90 độ (từ dưới lên trên)
        gc.strokeArc(125 + 7, 345 + 11, 16, 16, 140, 90, ArcType.OPEN);
// Vẽ cung tròn thứ hai, góc 90 độ tiếp theo (tạo khoảng trống thẳng đứng)
        gc.strokeArc(125 + 7, 345 + 11, 16, 16, 310, 90, ArcType.OPEN);

// Vẽ 2 đoạn cung nhỏ màu đỏ bên trong hình tròn thứ hai (bên phải) - Thẳng đứng lên trên
        gc.strokeArc(250 + 7, 345 + 11, 16, 16, 140, 90, ArcType.OPEN);
        gc.strokeArc(250 + 7, 345 + 11, 16, 16, 310, 90, ArcType.OPEN);

        // Tam giác trái (tai trái), nằm trên cạnh bên trái của tam giác lớn
        gc.setStroke(Color.BLACK); // Đặt màu viền của các tam giác nhỏ là màu đen
        gc.strokePolygon(
            new double[]{80, 157, 125}, // Tọa độ x của tam giác trái (đã dịch chuyển thêm sang trái nữa)
            new double[]{50, 105, 150}, // Tọa độ y của tam giác trái
            3
        );

        // Tam giác phải (tai phải), nằm trên cạnh bên trái của tam giác lớn (đã lật qua bên trái)
        gc.strokePolygon(
            new double[]{310, 240, 275}, // Tọa độ x của tam giác phải (đã lật qua bên trái)
            new double[]{50, 105, 150},  // Tọa độ y của tam giác phải
            3
        );

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
