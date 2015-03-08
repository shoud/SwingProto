import controller.CounterController;
import model.CounterModel;
import view.GuiView;

/**
 * Classe permettant de lancer le programme
 */
public class GestionImages
{
    public static void main(String[] argv)
    {
        CounterModel m = new CounterModel();
        GuiView v = new GuiView(m);
        new CounterController(m,v);
    }
}