package visao;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;

public class Teste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Teste() {
		setBounds(new Rectangle(0, 0, 600, 600));
        BufferedImage bg = null;;
		try {
			bg = ImageIO.read(new File("src/img/IfscBack2023-1600.png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelWithBackgroundImage(bg);
        c.setLayout(new GridLayout(0,5,16,16));
        c.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (int ii = 1; ii < 26; ii++) {
            c.add(new JButton("Button " + ii));
        }
        getContentPane().add(c);
       // pack();
		
	}

}
