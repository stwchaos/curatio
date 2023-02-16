package visao;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/visao/logoHospital.png")));
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
		txtCpf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		txtCpf.setText("CPF");
		txtCpf.setBounds(96, 212, 150, 30);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(160, 160, 160));
		txtSenha.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		txtSenha.setText("Senha");
		txtSenha.setColumns(10);
		txtSenha.setBounds(96, 251, 150, 30);
		panel.add(txtSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(0, 81, 81));
		btnNewButton.setBounds(114, 311, 116, 30);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setBounds(154, 380, 82, 87);
		panel.add(lblNewLabel2);
		lblNewLabel2.setIcon(new ImageIcon(TelaPadrao.class.getResource("/visao/simbolomed.png")));
		
		
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
