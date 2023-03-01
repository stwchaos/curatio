package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaMarcarConsultas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtInserirAno;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtMarcarConsulta;


	public TelaMarcarConsultas() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMarcarConsultas.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 122, 306, 290);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setText("Inserir");
		textField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(11, 59, 217, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Inserir");
		textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(13, 262, 214, 20);
		panel.add(textField_1);
		
		txtInserirAno = new JTextField();
		txtInserirAno.setText("Inserir ano");
		txtInserirAno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserirAno.setColumns(10);
		txtInserirAno.setBounds(120, 139, 59, 20);
		panel.add(txtInserirAno);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente");
		lblNewLabel_1.setBounds(11, 47, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Profissional");
		lblNewLabel_2.setBounds(11, 85, 86, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setBounds(11, 122, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setBounds(14, 247, 46, 14);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaMarcarConsultas.class.getResource("/img/iconCheck.png")));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(238, 225, 59, 57);
		panel.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setText("Inserir");
		textField_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(11, 221, 214, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Forma de Pagamento");
		lblNewLabel_5_1.setBounds(13, 206, 191, 14);
		panel.add(lblNewLabel_5_1);
		
		textField_6 = new JTextField();
		textField_6.setText("Inserir");
		textField_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(13, 182, 115, 20);
		panel.add(textField_6);
		
		JLabel lblNewLabel_5 = new JLabel("Objetivo");
		lblNewLabel_5.setBounds(12, 168, 90, 14);
		panel.add(lblNewLabel_5);
		
		txtMarcarConsulta = new JTextField();
		txtMarcarConsulta.setText("Marcar Consulta");
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(64, 128, 128));
		txtMarcarConsulta.setBounds(0, 0, 306, 36);
		panel.add(txtMarcarConsulta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(64, 128, 128));
		comboBox.setBounds(11, 101, 217, 20);
		panel.add(comboBox);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setForeground(new Color(0, 81, 81));
		comboDia.setBackground(new Color(255, 255, 255));
		comboDia.setBounds(11, 140, 30, 20);
		panel.add(comboDia);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setForeground(new Color(0, 81, 81));
		comboMes.setBackground(new Color(255, 255, 255));
		comboMes.setBounds(51, 140, 59, 20);
		panel.add(comboMes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 81, 81));
		panel_1.setBounds(0, 0, 846, 53);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 81, 81));
		panel_1_1.setBounds(0, 477, 846, 53);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(64, 128, 128));
		panel_1_2.setBounds(0, 52, 846, 28);
		contentPane.add(panel_1_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(64, 128, 128));
		panel_1_2_1.setBounds(0, 451, 846, 28);
		contentPane.add(panel_1_2_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaMarcarConsultas.class.getResource("/img/iconmedicina.png")));
		lblNewLabel_8.setBounds(413, -81, 369, 532);
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
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 11));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setBounds(747, 417, 89, 23);
		contentPane.add(btnVoltar);
	}
}
