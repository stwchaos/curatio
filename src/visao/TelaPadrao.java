package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

public class TelaPadrao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaPadrao() {
		setForeground(new Color(0, 51, 51));
		setTitle("Hospital Esmeralda");
		setBackground(new Color(0, 51, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPadrao.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 81, 81));
		contentPane.add(panel, BorderLayout.WEST);

		JButton btnProfissionais = new JButton("Profissionais");
		btnProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaMedico telaListaMedico = new TelaListaMedico();
				telaListaMedico.setLocationRelativeTo(null);
				telaListaMedico.setVisible(true);
				telaListaMedico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		panel.setLayout(new MigLayout("", "[111px][][33px][][]", "[][][65px][][][][][][][][][]"));
		
				JLabel lblNewLabel = new JLabel("");
				panel.add(lblNewLabel, "cell 0 0,alignx right,aligny center");
				lblNewLabel.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/simbolomed.png")));
		btnProfissionais.setForeground(Color.WHITE);
		btnProfissionais.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		btnProfissionais.setBackground(new Color(0, 81, 81));
		panel.add(btnProfissionais, "cell 0 2,growx,aligny center");
		
				JButton btnMarcarConsulta = new JButton("Marcar consulta");
				btnMarcarConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						TelaMarcarConsultas telaMarcarConsulta = new TelaMarcarConsultas();
						telaMarcarConsulta.setLocationRelativeTo(null);
						telaMarcarConsulta.setVisible(true);
						telaMarcarConsulta.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}
				});
				btnMarcarConsulta.setForeground(Color.WHITE);
				btnMarcarConsulta.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
				btnMarcarConsulta.setBackground(new Color(0, 81, 81));
				panel.add(btnMarcarConsulta, "cell 0 3,growx");
								
										JButton btnCadastrarPaciente = new JButton("Cadastrar paciente");
										btnCadastrarPaciente.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												dispose();
												TelaCadastroPaciente telaCadastroPaciente = new TelaCadastroPaciente();
												telaCadastroPaciente.setLocationRelativeTo(null);
												telaCadastroPaciente.setVisible(true);
												telaCadastroPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
											}
										});
										btnCadastrarPaciente.setForeground(Color.WHITE);
										btnCadastrarPaciente.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
										btnCadastrarPaciente.setBackground(new Color(0, 81, 81));
										panel.add(btnCadastrarPaciente, "cell 0 5,growx");
										
												JButton btnListaPaciente = new JButton("Pacientes");
												btnListaPaciente.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														dispose();
														TelaListaPaciente telaListaPaciente = new TelaListaPaciente();
														telaListaPaciente.setLocationRelativeTo(null);
														telaListaPaciente.setVisible(true);
														telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
													}
												});
												btnListaPaciente.setForeground(Color.WHITE);
												btnListaPaciente.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
												btnListaPaciente.setBackground(new Color(0, 81, 81));
												panel.add(btnListaPaciente, "cell 0 7,growx");
				
						JButton btnConsultasPendentes = new JButton("Consultas pendentes");
						btnConsultasPendentes.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
								TelaConsultasPendentes telaConsultasPendentes = new TelaConsultasPendentes();
								telaConsultasPendentes.setLocationRelativeTo(null);
								telaConsultasPendentes.setVisible(true);
								telaConsultasPendentes.setExtendedState(JFrame.MAXIMIZED_BOTH);
							}
						});
						btnConsultasPendentes.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
						btnConsultasPendentes.setForeground(new Color(255, 255, 255));
						btnConsultasPendentes.setBackground(new Color(0, 81, 81));
						panel.add(btnConsultasPendentes, "cell 0 9,growx");
				
						JButton btnSair = new JButton("Sair");
						btnSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
								TelaInicial frame = new TelaInicial();
								frame.setVisible(true);
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							}
						});
						btnSair.setForeground(new Color(255, 255, 255));
						btnSair.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
						btnSair.setBackground(new Color(64, 128, 128));
						panel.add(btnSair, "cell 0 11,growx");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Bem-vindo!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconPaciente (4).png")));
				panel_2.add(lblNewLabel_3);
				
						JLabel lblNewLabel_2 = new JLabel("Pacientes cadastrados:");
						panel_2.add(lblNewLabel_2);
						lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		
				textField = new JTextField();
				textField.setBackground(new Color(240, 240, 240));
				textField.setEditable(false);
				panel_2.add(textField);
				textField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconMedico.png")));
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_2_1 = new JLabel("Médicos disponíveis:");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.add(panel_2);
		panel_4.add(panel_3);


		textField_1 = new JTextField();
		textField_1.setBounds(216, 34, 86, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel_3.add(textField_1);

	}
}
