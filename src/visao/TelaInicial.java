package visao;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ProfissionalDAO;
import modelo.Medico;

import java.awt.Toolkit;
import java.net.URL;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	private JPanel c;
	private JTextField txtCpf;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaInicial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/img/logoHospital.png")));
		setTitle("Hospital Esmeralda");

		URL resourceIcon = TelaInicial.class.getResource("/img/logoHospital.png");
		if (resourceIcon != null) {
			Image imgIcon = Toolkit.getDefaultToolkit().getImage(resourceIcon);
			setIconImage(imgIcon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[grow][446.00px][25.00,grow]", "[grow][290.00px][grow]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		c.add(panel, "cell 1 1,grow");
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel2 = new JLabel("");
		panel.add(lblNewLabel2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 64, 64), 2, true));
		panel_3.setBackground(new Color(0, 98, 98));
		panel.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[109.00,grow][][grow][][113.00,grow]",
				"[44.00][][73.00][17.00][][64.00][][][42.00][][315.00]"));

		JLabel lblNewLabel = new JLabel("Login Secretaria");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel, "cell 2 1");

		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/Carinha Apenas.png")));
		panel_3.add(lblNewLabel_1, "cell 2 4,alignx left,aligny center");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		txtCpf = new RoundJTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setBackground(new Color(0, 81, 81));
		txtCpf.setForeground(new Color(255, 255, 255));
		txtCpf.setCaretColor(Color.WHITE);
		// txtCpf.setBorder(BorderFactory.createEmptyBorder());
		panel_3.add(txtCpf, "cell 2 5,growx");

		txtCpf.setToolTipText("");
		txtCpf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCpf.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/Cadeado.png")));
		panel_3.add(lblNewLabel_2, "cell 2 7");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));

		txtSenha = new RoundPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setForeground(new Color(255, 255, 255));
		txtSenha.setBackground(new Color(0, 81, 81));
		txtSenha.setCaretColor(Color.WHITE);
		txtSenha.setSelectedTextColor(new Color(0, 0, 0));

		panel_3.add(txtSenha, "cell 2 8,growx");

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(null);
		btnEntrar.setOpaque(false);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 3));
		btnEntrar.setFocusPainted(false);

		panel_3.add(btnEntrar, "cell 1 10 3 1,growx,aligny center");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Long cpf = null;
				if (!txtCpf.getText().isEmpty()) {
					cpf = Long.valueOf(txtCpf.getText());
				}
				String senha = null;
				if (!txtSenha.getText().isEmpty()) {
					senha = txtSenha.getText();
				}
				ProfissionalDAO profissionalDAO = new ProfissionalDAO();
				Medico p = profissionalDAO.efetuarLogin(cpf, senha);
				if (p != null ) {

//					if (p.getCpfProfissionais().equals(cpf) && p.getSenha().equals(senha)) {
					dispose();
					TelaPadrao telaPadrao = new TelaPadrao(p);
					telaPadrao.setLocationRelativeTo(null);
					telaPadrao.setVisible(true);
					telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					}
				} else {
					new DialogMensagemErro("Autentificao invalida").setVisible(true);
					return;
				}
			}
		});
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		btnEntrar.setBackground(new Color(0, 81, 81));

		URL resource = TelaPadrao.class.getResource("/img/simbolomed.png");
		ImageIcon icon = null;
		if (resource != null) {
			icon = new ImageIcon(resource);
			lblNewLabel2.setIcon(icon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}
	}
}
