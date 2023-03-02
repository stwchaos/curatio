package visao;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.border.*;

public class RoundBorder extends AbstractBorder {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Color color;
	    private int thickness = 4;
	    private int radii = 8;
	    private Insets insets = null;
	    private BasicStroke stroke = null;
	    private int strokePad;
	    private boolean left = true;
	    RenderingHints hints;
	    
	    RoundBorder() {
	    	this(Color.WHITE, 1, 10);
	    }
	    
	    RoundBorder(Color color) {
	        this(color, 1, 10);
	    }

	    RoundBorder(Color color, int thickness, int radii) {
	        this.thickness = thickness;
	        this.radii = radii;
	        this.color = color;

	        stroke = new BasicStroke(thickness);
	        strokePad = thickness / 2;

	        hints = new RenderingHints(
	                RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);

	        int pad = radii + strokePad;
	        int bottomPad = pad + strokePad;
	        insets = new Insets(pad, pad, bottomPad, pad);
	    }

	    RoundBorder(Color color, int thickness, int radii, boolean left) {
	        this(color, thickness, radii);
	        this.left = left;
	    }

	    @Override
	    public Insets getBorderInsets(Component c) {
	        return insets;
	    }

	    @Override
	    public Insets getBorderInsets(Component c, Insets insets) {
	        return getBorderInsets(c);
	    }

	    @Override
	    public void paintBorder(
	            Component c,
	            Graphics g,
	            int x, int y,
	            int width, int height) {

	        Graphics2D g2 = (Graphics2D) g;

	        int bottomLineY = height - thickness;

	        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
	                0 + strokePad,
	                0 + strokePad,
	                width - thickness,
	                bottomLineY,
	                radii,
	                radii);

	        Polygon pointer = new Polygon();

	        if (left) {
	            // left point
	            pointer.addPoint(strokePad + radii, bottomLineY);
	            // right point
	            pointer.addPoint(strokePad + radii, bottomLineY);
	            // bottom point
	            pointer.addPoint(strokePad + radii, height - strokePad);
	        } else {
	            // left point
	            pointer.addPoint(width - (strokePad + radii), bottomLineY);
	            // right point
	            pointer.addPoint(width - (strokePad + radii), bottomLineY);
	            // bottom point
	            pointer.addPoint(width - (strokePad + radii), height - strokePad);
	        }

	        Area area = new Area(bubble);
	        area.add(new Area(pointer));

	        g2.setRenderingHints(hints);

	        // Paint the BG color of the parent, everywhere outside the clip
	        // of the text bubble.
	        Component parent  = c.getParent();
	        if (parent!=null) {
	            Color bg = parent.getBackground();
	            Rectangle rect = new Rectangle(0,0,width, height);
	            Area borderRegion = new Area(rect);
	            borderRegion.subtract(area);
	            g2.setClip(borderRegion);
	            g2.setColor(bg);
	            g2.fillRect(0, 0, width, height);
	            g2.setClip(null);
	        }

	        g2.setColor(color);
	        g2.setStroke(stroke);
	        g2.draw(area);
	    }
	}
