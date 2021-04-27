import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameLoop extends AnimationTimer
{
	public GraphicsContext graphicsContext;
	public Image bullsEyeImage;
	public Circle bullsEyeCircle;
	public IntegerValue points;
	
	public GameLoop(GraphicsContext gc, Image image, Circle circle, IntegerValue score)
	{
		graphicsContext = gc;
		bullsEyeImage = image;
		bullsEyeCircle = circle;
		points = score;
	}
	
	@Override
	public void handle(long currentNanoTime) 
	{
		String pointsText = "Points: " + points.value;
		
		graphicsContext.setFill(new Color(0.85, 0.85, 1.0, 1.0));
		graphicsContext.fillRect(0, 0, 512, 512);
		graphicsContext.drawImage(bullsEyeImage, bullsEyeCircle.getX() - bullsEyeCircle.getRadius(), bullsEyeCircle.getY() - bullsEyeCircle.getRadius());
		graphicsContext.setFill(Color.BLUE);
		graphicsContext.fillText(pointsText, 360, 36);
		graphicsContext.strokeText(pointsText, 360, 36);
	}
}
