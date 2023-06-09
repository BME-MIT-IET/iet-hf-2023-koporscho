package graphic;

import koporscho.GameController;
import koporscho.Virologist;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GameContorllerView osztály, amely a teljes játéktér újrarajzolásáért és végeredmény megjelenítéséért felel.
 */
public class GameControllerView extends View implements Serializable {
    @Serial
    private static final long serialVersionUID = 112312350207L;
    private final transient Logger logger = Logger.getLogger(GameControllerView.class.getName());
    /**
     * A teljes játéktér újrarajzolását végző függvény.
     * Ha a játék véget ért, megjelenít valamely végeredményt prezentáló képet, ezzel végeredményt hirdetve.
     * @param obj Egy IViewable példány
     */
    public void Redraw(IViewable obj){
        GameController gc = (GameController) obj;
        /**Végeredmény hirdetése*/
        if(!gc.GameRunning()) {
            try {
                BufferedImage image;
                String title;
                if(GameController.win) {
                    image = ImageIO.read(new File("assets/winner.png"));
                    title = "The winner is " + gc.GetCurrentVirologist().GetName();
                }
                else {
                    title = "Bears win!";
                    image = ImageIO.read(new File("assets/loser.png"));
                }
                JLabel picLabel = new JLabel(new ImageIcon(image));
                JOptionPane.showMessageDialog(null, picLabel, title, JOptionPane.PLAIN_MESSAGE, null);
            }
            catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
            GUI.getInstance().setState(GUI.GUIState.END_GAME);
            System.exit(1);
            return;
        }
        /**Teljes játéktér frissítése*/
        Virologist cur = gc.GetCurrentVirologist();
        GUI gui = GUI.getInstance();
        gui.getAttrPanel().update(cur.GetApCurrent(), cur.GetCurrentMaterials(), cur.GetMaxMaterials(), cur.GetStatusEffects(), cur);
        gui.getBgrPanel().update(cur.GetField());
        gui.getEqPanel().update(cur.GetEquipment());
        gui.getMuPanel().update(cur);
    }
}
