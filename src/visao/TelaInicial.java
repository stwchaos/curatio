package visao;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField passwordField;

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel2 = new JLabel("");
		panel.add(lblNewLabel2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 81, 81));
		panel.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[311.00][]", "[44.00][73.00][][][64.00][][][42.00][315.00]"));
												
														JLabel lblNewLabel = new JLabel("Login Secretaria");
														panel_3.add(lblNewLabel, "cell 1 1,alignx center,aligny center");
														lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
														lblNewLabel.setForeground(new Color(255, 255, 255));
														
														JLabel lblNewLabel_1 = new JLabel("CPF");
														panel_3.add(lblNewLabel_1, "cell 1 3,alignx left,aligny center");
														lblNewLabel_1.setForeground(new Color(255, 255, 255));
												
														txtCpf = new JTextField();
														panel_3.add(txtCpf, "cell 1 4,growx");
														txtCpf.setForeground(new Color(160, 160, 160));
														txtCpf.setToolTipText("");
														txtCpf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
														txtCpf.setColumns(10);
														
														JLabel lblNewLabel_2 = new JLabel("Senha");
														panel_3.add(lblNewLabel_2, "cell 1 6");
														lblNewLabel_2.setForeground(new Color(255, 255, 255));
														
														passwordField = new JPasswordField();
														panel_3.add(passwordField, "cell 1 7,growx");
														
																JButton btnEntrar = new JButton("Entrar");
																panel_3.add(btnEntrar, "cell 1 8,alignx center,aligny bottom");
																btnEntrar.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		dispose();
																		TelaPadrao telaPadrao = new TelaPadrao();
																		telaPadrao.setLocationRelativeTo(null);
																		telaPadrao.setVisible(true);
																		telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
																}});
																btnEntrar.setForeground(new Color(255, 255, 255));
																btnEntrar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
																btnEntrar.setBackground(new Color(0, 81, 81));
														
														JPanel panel_4 = new JPanel();
														panel_4.setBackground(new Color(64, 128, 128));
														panel.add(panel_4, BorderLayout.WEST);
														panel_4.setLayout(new MigLayout("", "[73.00]", "[]"));
														
														JPanel panel_5 = new JPanel();
														panel_5.setBackground(new Color(64, 128, 128));
														panel.add(panel_5, BorderLayout.EAST);
														panel_5.setLayout(new MigLayout("", "[62.00]", "[]"));

		URL resource = TelaPadrao.class.getResource("/img/simbolomed.png");
		ImageIcon icon = null;
		if (resource != null) {
			icon = new ImageIcon(resource);
			lblNewLabel2.setIcon(icon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(212, 212, 212));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new MigLayout("", "[136.00]", "[]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(212, 212, 212));
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new MigLayout("", "[138.00]", "[]"));
	}
}
