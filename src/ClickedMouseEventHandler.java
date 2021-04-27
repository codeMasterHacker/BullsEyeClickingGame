import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickedMouseEventHandler implements EventHandler<MouseEvent>
{
	public Circle bullsEye;
	public IntegerValue points;
	
	public ClickedMouseEventHandler(Circle circle, IntegerValue score)
	{
		bullsEye = circle;
		points = score;
	}
	
	@Override
	public void handle(MouseEvent mouseEvent) 
	{
		if (bullsEye.containsPoint(mouseEvent.getX(), mouseEvent.getY()))
        {
            double x = 50 + 400 * Math.random(); 
            double y = 50 + 400 * Math.random();
            bullsEye.setCenter(x,y);
            
            points.value++;
        }
        else
            points.value = 0;
	}
}
