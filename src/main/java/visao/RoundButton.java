/*package visao;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class RoundButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Shape shape;
	private int radii = 10;
	private Color color;
	private String texto;

	public RoundButton() {
		super();
		this.color = new Color(45, 45, 45);
		setOpaque(false);
	}
	
	public RoundButton(String message) {
		super();
		this.color = new Color(45, 45, 45);
		setOpaque(false);
	}


	public RoundButton(Color color, int radii) {
		super();
		this.radii = radii;
		this.color = color;
		setOpaque(false);
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
}*/