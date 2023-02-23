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
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 81, 81));
		panel.setBounds(242, 0, 339, 530);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login Secretaria");
		lblNewLabel.setBounds(70, 74, 201, 41);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		txtCpf = new JTextField();
		txtCpf.setForeground(new Color(160, 160, 160));
		txtCpf.setToolTipText("");
		txtCpf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCpf.setBounds(70, 222, 201, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
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
		btnEntrar.setBounds(114, 311, 116, 30);
		panel.add(btnEntrar);

		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setBounds(154, 380, 82, 87);
		panel.add(lblNewLabel2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(70, 261, 201, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(70, 202, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(70, 246, 46, 14);
		panel.add(lblNewLabel_2);

		URL resource = TelaPadrao.class.getResource("/img/simbolomed.png");
		ImageIcon icon = null;
		if (resource != null) {
			icon = new ImageIcon(resource);
			lblNewLabel2.setIcon(icon);
		} else {
			JOptionPane.showMessageDialog(null, "Erro no caminho da imagem");
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(145, 0, 97, 530);
		contentPane.add(panel_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(64, 128, 128));
		panel_1_1.setBounds(581, 0, 97, 530);
		contentPane.add(panel_1_1);
	}
}
