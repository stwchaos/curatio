package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtInserir;
	private JTextField txtInserir_6;
	private JTextField txtInserir_1;
	private JTextField txtInserir_2;
	private JTextField txtInserir_3;
	private JTextField txtInserir_5;
	private JTextField txtInserir_4;
	private JTextField txtAdicionarInformaes;


	public TelaCadastroPaciente() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(531, 11, 306, 508);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(69, 57, 171, 191);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconpeople.png")));
		lblNewLabel.setBounds(52, 44, 72, 96);
		panel_1.add(lblNewLabel);
		
		txtInserir = new JTextField();
		txtInserir.setText("Inserir");
		txtInserir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir.setColumns(10);
		txtInserir.setBounds(10, 274, 217, 20);
		panel.add(txtInserir);
		
		txtInserir_6 = new JTextField();
		txtInserir_6.setText("Inserir");
		txtInserir_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_6.setColumns(10);
		txtInserir_6.setBounds(11, 466, 214, 20);
		panel.add(txtInserir_6);
		
		txtInserir_1 = new JTextField();
		txtInserir_1.setText("Inserir");
		txtInserir_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_1.setColumns(10);
		txtInserir_1.setBounds(10, 313, 217, 20);
		panel.add(txtInserir_1);
		
		txtInserir_2 = new JTextField();
		txtInserir_2.setText("Inserir");
		txtInserir_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_2.setColumns(10);
		txtInserir_2.setBounds(10, 349, 86, 20);
		panel.add(txtInserir_2);
		
		txtInserir_3 = new JTextField();
		txtInserir_3.setText("Inserir");
		txtInserir_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_3.setColumns(10);
		txtInserir_3.setBounds(106, 349, 86, 20);
		panel.add(txtInserir_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 262, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome social");
		lblNewLabel_2.setBounds(10, 300, 86, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(10, 337, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		lblNewLabel_6.setBounds(106, 336, 115, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setBounds(12, 451, 46, 14);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconCheck.png")));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(237, 440, 59, 57);
		panel.add(btnNewButton);
		
		txtInserir_5 = new JTextField();
		txtInserir_5.setText("Inserir");
		txtInserir_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_5.setColumns(10);
		txtInserir_5.setBounds(9, 425, 214, 20);
		panel.add(txtInserir_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		lblNewLabel_5_1.setBounds(11, 410, 90, 14);
		panel.add(lblNewLabel_5_1);
		
		txtInserir_4 = new JTextField();
		txtInserir_4.setText("Inserir");
		txtInserir_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_4.setColumns(10);
		txtInserir_4.setBounds(11, 386, 115, 20);
		panel.add(txtInserir_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setBounds(10, 372, 90, 14);
		panel.add(lblNewLabel_5);
		
		txtAdicionarInformaes = new JTextField();
		txtAdicionarInformaes.setText("Adicionar Informações");
		txtAdicionarInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionarInformaes.setForeground(Color.WHITE);
		txtAdicionarInformaes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		txtAdicionarInformaes.setEditable(false);
		txtAdicionarInformaes.setColumns(10);
		txtAdicionarInformaes.setBackground(new Color(64, 128, 128));
		txtAdicionarInformaes.setBounds(0, 0, 306, 36);
		panel.add(txtAdicionarInformaes);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconmedicina.png")));
		lblNewLabel_8.setBounds(87, -77, 369, 532);
		contentPane.add(lblNewLabel_8);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao();
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setBounds(10, 482, 110, 37);
		contentPane.add(btnVoltar);
	}

}
