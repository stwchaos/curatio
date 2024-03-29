package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.PacienteDAO;
import modelo.Paciente;

public class DialogConfirmacao extends JFrame implements InterfaceConfirmacao {

	private Paciente pacienteSelecionado = null;
	private PacienteDAO pDao = new PacienteDAO();
	private static final long serialVersionUID = 1L;

	public DialogConfirmacao(String message, final InterfaceConfirmacao tela) {
		setTitle("Aviso");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DialogConfirmacao.class.getResource("/img/sign-warning-icon_34355.png")));

		setBounds(0, 0, 320, 130);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/main/resources/img/background.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);
		// c = new JPanel();
		c.setBackground(new Color(0, 81, 81));
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
		lblNewLabel.setIcon(new ImageIcon(DialogConfirmacao.class.getResource("/img/sign-warning-icon_34355.png")));
		lblNewLabel.setBounds(271, 11, 39, 45);
		c.add(lblNewLabel);

		JButton btnOk = new JButton("Confirmar");
		btnOk.setBounds(221, 96, 89, 23);
		btnOk.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.btnConfirmacao();
				dispose();
			}
		});
		btnOk.setBackground(new Color(191, 0, 0));
		btnOk.setForeground(Color.WHITE);
		btnOk.setBorderPainted(false);
		btnOk.setFocusPainted(false);
		c.add(btnOk);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tela.bntCancelar();
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(64, 128, 128));
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBounds(10, 97, 89, 23);
		c.add(btnCancelar);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DialogConfirmacao.class.getResource("/img/sign-warning-icon_34355.png")));
		lblNewLabel_1.setBounds(10, 12, 39, 45);
		c.add(lblNewLabel_1);

		setLocationRelativeTo(null);
		setUndecorated(true);
	}

	@Override
	public void btnConfirmacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bntCancelar() {
		// TODO Auto-generated method stub

	}
}