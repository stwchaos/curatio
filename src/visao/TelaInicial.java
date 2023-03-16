package visao;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ProfissionalDAO;
import modelo.Profissional;

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
		setBounds(100, 100, 1008, 658);
		
		JPanel panelPrincipal = new JPanel();

		panelPrincipal.setBackground(new Color(0, 81, 81));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new MigLayout("", "[grow][389.00px][25.00,grow]", "[grow][362.00px][grow]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panelPrincipal.add(panel, "cell 1 1,grow");
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel2 = new JLabel("");
		panel.add(lblNewLabel2);

		
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/fundoLogin-removebg-preview (2).png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);;
		c.setForeground(null);
		c.setBackground(new Color (0,81,81));
		panel.add(c);
		c.setLayout(new MigLayout("", "[62.00,grow][38.00][184.00][113.00,grow]", "[][73.00,grow][17.00][][64.00][][][82.00,grow][56.00]"));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/users_icon (3).png")));
				c.add(lblNewLabel, "cell 2 0");
		
				JLabel lblNewLabel_1 = new JLabel("CPF");
				lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/Carinha Apenas.png")));
				c.add(lblNewLabel_1, "cell 1 4,growx,aligny center");
				lblNewLabel_1.setForeground(new Color(0, 0, 0));

		txtCpf = new RoundJTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setBackground(new Color(64, 128, 128));
		txtCpf.setForeground(new Color(255, 255, 255));
		txtCpf.setCaretColor(Color.WHITE);
		// txtCpf.setBorder(BorderFactory.createEmptyBorder());
		c.add(txtCpf, "cell 2 4,growx");

		txtCpf.setToolTipText("");
		txtCpf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCpf.setColumns(10);
		
				JLabel lblNewLabel_2 = new JLabel("Senha");
				lblNewLabel_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/Cadeado.png")));
				c.add(lblNewLabel_2, "cell 1 6,alignx left,aligny center");
				lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
				txtSenha = new RoundPasswordField();
				txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
				txtSenha.setForeground(new Color(255, 255, 255));
				txtSenha.setBackground(new Color(64, 128, 128));
				txtSenha.setCaretColor(Color.WHITE);
				txtSenha.setSelectedTextColor(new Color(0, 0, 0));
				
						c.add(txtSenha, "cell 2 6,growx");

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color (0,81,81));
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.setFocusPainted(false);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));

		c.add(btnEntrar, "cell 2 7,growx,aligny bottom");
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
				Profissional p = profissionalDAO.efetuarLogin(cpf, senha);
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
