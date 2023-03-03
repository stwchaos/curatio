package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Dialog extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog frame = new Dialog("qualquercoisa msm");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dialog(String message) {
		setTitle("Aviso");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Dialog.class.getResource("/img/sign-warning-icon_34355.png")));

		setBounds(0, 0, 320, 130);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);
		// c = new JPanel();
		c.setBackground(new Color(80, 160, 160));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(null);

		JLabel lblTexto = new JLabel(message);
		lblTexto.setBackground(new Color(0, 81, 81));
		lblTexto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(64, 11, 185, 14);
		lblTexto.setForeground(new Color(255, 255, 255));

		c.add(lblTexto);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dialog.class.getResource("/img/sign-warning-icon_34355.png")));
		lblNewLabel.setBounds(141, 31, 39, 45);
		c.add(lblNewLabel);

		JLabel borda = new JLabel("");
		borda.setBorder(new RoundBorder());
		borda.setBounds(getBounds());
		c.add(borda);

		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(114, 87, 89, 23);
		btnOk.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBackground(new Color(0, 81, 81));
		btnOk.setForeground(Color.WHITE);
		btnOk.setBorderPainted(false);
		btnOk.setFocusPainted(false);
		c.add(btnOk);

		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}