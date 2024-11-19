package truongvx.shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Custom Shape with Centered Button");

        // Tạo canvas để vẽ
        Canvas canvas = new Canvas(400, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Tạo nút để vẽ hình
        Button drawButton = new Button("Vẽ Hình");
        drawButton.setOnAction(e -> drawShape(gc)); // Lắng nghe sự kiện nhấn nút

        // Đặt canvas và nút vào VBox
        VBox root = new VBox(10); // Khoảng cách giữa các phần tử là 10px
        root.setAlignment(Pos.CENTER); // Căn giữa tất cả phần tử trong VBox
        root.getChildren().addAll(canvas, drawButton);

        // Thiết lập scene và hiển thị
        primaryStage.setScene(new Scene(root, 400, 550));
        primaryStage.show();
    }

    private void drawShape(GraphicsContext gc) {
        // Xóa canvas trước khi vẽ lại
        gc.clearRect(0, 0, 400, 500);

        // Vẽ tam giác lớn
        gc.strokePolygon(new double[]{200, 50, 350}, new double[]{50, 250, 250}, 3);

        // Vẽ tam giác ngược nhỏ chính giữa tam giác lớn (mũi chĩa xuống dưới)
        gc.setStroke(Color.RED); // Đặt màu viền là màu đỏ
        gc.strokePolygon(
            new double[]{150, 250, 200}, // Tọa độ x của tam giác nhỏ
            new double[]{170, 170, 220}, // Tọa độ y của tam giác nhỏ
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

        // Vẽ 2 đoạn cung nhỏ màu đỏ bên trong hình tròn đầu tiên
        gc.setStroke(Color.RED); // Đặt màu viền là màu đỏ
        gc.strokeArc(125 + 7, 345 + 11, 16, 16, 140, 90, ArcType.OPEN);
        gc.strokeArc(125 + 7, 345 + 11, 16, 16, 310, 90, ArcType.OPEN);

        // Vẽ 2 đoạn cung nhỏ màu đỏ bên trong hình tròn thứ hai
        gc.strokeArc(250 + 7, 345 + 11, 16, 16, 140, 90, ArcType.OPEN);
        gc.strokeArc(250 + 7, 345 + 11, 16, 16, 310, 90, ArcType.OPEN);

        // Tam giác trái (tai trái)
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(
            new double[]{80, 157, 125},
            new double[]{50, 105, 150},
            3
        );

        // Tam giác phải (tai phải)
        gc.strokePolygon(
            new double[]{310, 240, 275},
            new double[]{50, 105, 150},
            3
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
