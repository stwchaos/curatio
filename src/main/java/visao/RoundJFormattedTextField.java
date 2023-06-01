package visao;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class RoundJFormattedTextField extends JFormattedTextField {

    private static final long serialVersionUID = 1L;
    private Shape shape;
    private int radii = 10;
    private Color color;

    public RoundJFormattedTextField() {
        super();
        this.color = new Color(45, 45, 45);
        setOpaque(false);
    }

    public RoundJFormattedTextField(String format) {
        super();
        this.color = new Color(45, 45, 45);
        setOpaque(false);
        setFormatter(format);
    }

    public RoundJFormattedTextField(Color color, int radii) {
        super();
        this.radii = radii;
        this.color = color;
        setOpaque(false);
    }

    public RoundJFormattedTextField(String format, Color color, int radii) {
        super();
        this.radii = radii;
        this.color = color;
        setOpaque(false);
        setFormatter(format);
    }

    private void setFormatter(String format) {
        try {
            MaskFormatter formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('_');
            setFormatterFactory(new DefaultFormatterFactory(formatter));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radii, radii);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radii, radii);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radii, radii);
        }
        return shape.contains(x, y);
    }
}

