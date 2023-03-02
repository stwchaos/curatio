package visao;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class PanelComBackgroundImage extends JPanel {

    Image bg;

    PanelComBackgroundImage(Image bg) {
        this.bg = bg;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

