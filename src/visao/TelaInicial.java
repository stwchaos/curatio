package visao;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.MedicoDAO;
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
		setBounds(100, 100, 1031, 800);
		BufferedImage bg = null;
		
		try {
			bg = ImageIO.read(new File("src/img/fundoTelaLogin.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panelPrincipal = new PanelComBackgroundImage(bg);;
		

		panelPrincipal.setBackground(new Color(0, 81, 81));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new MigLayout("", "[grow][499.00px][25.00,grow]", "[grow][553.00px,grow][grow]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panelPrincipal.add(panel, "cell 1 1,grow");
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel2 = new JLabel("");
		panel.add(lblNewLabel2);

		

		
		try {
			bg = ImageIO.read(new File("src/img/fundoLogin.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);;
		c.setForeground(null);
		c.setBackground(new Color(0, 81, 81));
		panel.add(c);
		c.setLayout(new MigLayout("", "[62.00,grow][68.00][249.00][68.00][62.00,grow]", "[][132.00,grow][17.00][grow][27.00][][][28.00][52.00,grow][32.00][56.00]"));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/iconLogin.png")));
				c.add(lblNewLabel, "cell 2 0,alignx center,aligny center");
				
				JLabel lblNewLabel_3 = new JLabel("Login Curatio");
				lblNewLabel_3.setBackground(new Color(0, 47, 47));
				lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 17));
				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				c.add(lblNewLabel_3, "cell 2 1,alignx center,aligny center");
		
				JLabel lblNewLabel_1 = new JLabel("CPF");
				lblNewLabel_1.setBackground(new Color(0, 47, 47));
				lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/Carinha Apenas.png")));
				c.add(lblNewLabel_1, "cell 1 3 2 1,growx,aligny bottom");
				lblNewLabel_1.setForeground(new Color(255, 255, 255));

		txtCpf = new RoundJTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 47, 47));
		txtCpf.setCaretColor(Color.WHITE);
		// txtCpf.setBorder(BorderFactory.createEmptyBorder());
		c.add(txtCpf, "cell 1 4 3 1,grow");

		txtCpf.setToolTipText("");
		txtCpf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCpf.setColumns(10);
				
						JLabel lblNewLabel_2 = new JLabel("Senha");
						lblNewLabel_2.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/Cadeado.png")));
						c.add(lblNewLabel_2, "cell 1 6 2 1,alignx left,aligny center");
						lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
				txtSenha = new RoundPasswordField();
				txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
				txtSenha.setForeground(new Color(0, 47, 47));
				txtSenha.setBackground(new Color(255, 255, 255));
				txtSenha.setCaretColor(Color.WHITE);
				txtSenha.setSelectedTextColor(new Color(0, 0, 0));
				
						c.add(txtSenha, "cell 1 7 3 1,grow");

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(0, 81, 81));
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.setFocusPainted(false);
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));

		c.add(btnEntrar, "cell 2 9,growx,aligny center");
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

				MedicoDAO medicoDAO = new MedicoDAO();
				Medico m = medicoDAO.efetuarLogin(cpf, senha);
                if ( m != null ) {

//					if (p.getCpfProfissionais().equals(cpf) && p.getSenha().equals(senha)) {
					dispose();
					TelaPadrao telaPadrao = new TelaPadrao(m);
					telaPadrao.setLocationRelativeTo(null);
					telaPadrao.setVisible(true);
					telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					}
				} else {
					new DialogMensagemErro("Campo vazio detectado!").setVisible(true);
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
