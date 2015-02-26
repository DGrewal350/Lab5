package elevator;

/**
 *
 * @author daniel.grewal090
 */
import java.awt.event.*;

public class ElevController {
    
    private static ElevView view = new ElevView();
    private static ElevModel model = new ElevModel();
    private ActionListener actionListener;
    
    public ElevController() {
        view.updatePane(model.updateFloor(), model.updatePass(), model.updateDir());
    }
    public void control() {
        refresh();
        /*
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
            }
        }; */
    }
    
    private void refresh() {
        model.moveElev();
        view.updatePane(model.updateFloor(), model.updatePass(), model.updateDir());
    }
    
    public static void main(String[] args) {
        ElevController test = new ElevController();
        for (int i = 0; i < 10; i++)
        {
            test.control();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.printf("Error: %s\n", ex);
            }
        }
    }
}
