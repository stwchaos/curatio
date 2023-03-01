package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;

public class TelaFichaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldNomeSocial;
	private JTextField textFieldSexo;
	private JTextField textFieldNascimento;
	private JTextField textFieldCEP;


	public TelaFichaPaciente() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFichaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 731);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[49px][11px][32px][5px][53.00px][44.00px]", "[][191px][][grow][32px,grow][grow][33px,grow][grow][33px,grow,bottom][14px,grow][20px,grow][14px,grow][20px,grow][6px][14px,grow][1px][31px,grow][]"));
		
		JLabel lblNewLabel_9 = new JLabel("Registros dos pacientes");
		panel.add(lblNewLabel_9, "cell 2 0");
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setForeground(new Color(0, 81, 81));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, "cell 1 1 3 1,grow");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/iconpeople.png")));
		lblNewLabel.setBounds(79, 45, 72, 96);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel.add(lblNewLabel_1, "cell 0 3,alignx left,aligny bottom");
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setText("Inalterável");
		textFieldNome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldNome, "cell 0 4 5 1,growx,aligny center");
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome social");
		panel.add(lblNewLabel_2, "cell 0 5,alignx left,aligny bottom");
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		panel.add(lblNewLabel_3, "cell 0 7,alignx left,aligny bottom");
		
		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		panel.add(lblNewLabel_6, "cell 4 7,alignx left,aligny bottom");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldEmail.setText("Alterável");
		panel.add(textFieldEmail, "cell 0 16 5 1,growx,aligny center");
		textFieldEmail.setColumns(10);
		
		textFieldNomeSocial = new JTextField();
		textFieldNomeSocial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldNomeSocial.setText("Alterável");
		panel.add(textFieldNomeSocial, "cell 0 6 5 1,growx,aligny center");
		textFieldNomeSocial.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setEditable(false);
		textFieldSexo.setText("Inalterável");
		textFieldSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldSexo, "cell 0 8 3 1,growx,aligny center");
		textFieldSexo.setColumns(10);
		
		textFieldNascimento = new JTextField();
		textFieldNascimento.setEditable(false);
		textFieldNascimento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldNascimento.setText("Inalterável");
		panel.add(textFieldNascimento, "cell 4 8 2 1,growx,aligny center");
		textFieldNascimento.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		panel.add(lblNewLabel_7, "cell 0 14,growx,aligny top");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/iconCheck.png")));
		panel.add(btnNewButton, "cell 5 12 1 5,grow");
		
		textFieldCEP = new JTextField();
		textFieldCEP.setText("Alterável");
		textFieldCEP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldCEP.setColumns(10);
		panel.add(textFieldCEP, "cell 0 12 5 1,growx,aligny center");
		
		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		panel.add(lblNewLabel_5_1, "cell 0 11 3 1,growx,aligny top");
		
		textFieldTelefone = new JTextField();
		panel.add(textFieldTelefone, "cell 0 10 5 1,growx,aligny center");
		textFieldTelefone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldTelefone.setText("Alterável");
		textFieldTelefone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		panel.add(lblNewLabel_5, "cell 0 9 3 1,growx,aligny top");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			dispose();
			TelaPadrao telaPadrao = new TelaPadrao();
			telaPadrao.setLocationRelativeTo(null);
			telaPadrao.setVisible(true);
			telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}});
		panel.add(btnVoltar, "cell 0 17,growx,aligny center");
		
		JButton btnHistorico = new JButton("Acessar histórico de consultas");
		btnHistorico.setForeground(new Color(255, 255, 255));
		btnHistorico.setBackground(new Color(0, 81, 81));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaHistorico telaHistorico = new TelaHistorico();
				telaHistorico.setLocationRelativeTo(null);
				telaHistorico.setVisible(true);
				telaHistorico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		panel.add(btnHistorico, "cell 2 17,growx,aligny center");
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 81, 81));
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new MigLayout("", "[438.00]", "[grow][][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/logoHospital.png")));
		panel_2.add(lblNewLabel_4, "cell 0 1,alignx center,aligny center");
		
		
	}
}
