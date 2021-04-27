import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;

public class BullsEyeClickingGame extends Application
{
	public static void main(String[] args) 
    {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception 
	{
		String imageLocation = "file:///Users/Enrique/Desktop/codeFolders/Java/BullsEyeClickingGame/images/bullseye.png";
		
		stage.setTitle("Click the Target!");
        
        IntegerValue points = new IntegerValue(0);
        Circle bullsEye = new Circle(100, 100, 32);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setOnMouseClicked(new ClickedMouseEventHandler(bullsEye, points));
        stage.setScene(scene);

        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFont(Font.font("Andale Mono", FontWeight.BOLD, 24));
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(1);
        
        GameLoop gameLoop = new GameLoop(graphicsContext, new Image(imageLocation), bullsEye, points);
        gameLoop.start();

        stage.show();
	}
}
