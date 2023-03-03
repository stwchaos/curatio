package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
		setBounds(100, 100, 1226, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 81, 81));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[96.00]", "[][][][65px][61.00][][60.00][][58.00][][57.00][][145.00]"));

		JButton btnProfissionais = new JButton("Profissionais");
		btnProfissionais.setBackground(null);
		btnProfissionais.setOpaque(false);
		btnProfissionais.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 3));
		btnProfissionais.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaMedico telaListaMedico = new TelaListaMedico();
				telaListaMedico.setLocationRelativeTo(null);
				telaListaMedico.setVisible(true);
				telaListaMedico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel, "cell 0 1,alignx center,aligny center");
		lblNewLabel.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/simbolomed.png")));
		btnProfissionais.setForeground(Color.WHITE);
		btnProfissionais.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		panel.add(btnProfissionais, "cell 0 3,growx,aligny center");

		JButton btnMarcarConsulta = new JButton("Marcar consulta");
		btnMarcarConsulta.setBackground(null);
		btnMarcarConsulta.setOpaque(false);
		btnMarcarConsulta.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 3));
		btnMarcarConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		panel.add(btnMarcarConsulta, "cell 0 4,growx,aligny center");

		JButton btnCadastrarPaciente = new JButton("Cadastrar paciente");
		btnCadastrarPaciente.setBackground(null);
		btnCadastrarPaciente.setOpaque(false);
		btnCadastrarPaciente.setForeground(new Color(255, 255, 255));
		btnCadastrarPaciente.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 3));
		btnCadastrarPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		panel.add(btnCadastrarPaciente, "cell 0 6,growx,aligny center");

		JButton btnListaPaciente = new JButton("Pacientes");
		btnListaPaciente.setBackground(null);
		btnListaPaciente.setOpaque(false);
		btnListaPaciente.setForeground(new Color(255, 255, 255));
		btnListaPaciente.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 3));
		btnListaPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

		panel.add(btnListaPaciente, "cell 0 8,growx,aligny center");

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JButton btnConsultasPendentes = new JButton("Consultas pendentes");
		btnConsultasPendentes.setBackground(null);
		btnConsultasPendentes.setOpaque(false);
		btnConsultasPendentes.setForeground(new Color(255, 255, 255));
		btnConsultasPendentes.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 3));
		btnConsultasPendentes.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		panel.add(btnConsultasPendentes, "cell 0 10,growx,aligny center");
		btnSair.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSair.setBackground(null);
		btnSair.setOpaque(false);
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 2));
		panel.add(btnSair, "cell 0 12,growx,aligny bottom");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Bem-vindo!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		panel_1.add(lblNewLabel_1);

		// JPanel panel_4 = new JPanel();
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);
		contentPane.add(c, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 120, 421, 414, 0 };
		gbl_panel_4.rowHeights = new int[] { 84, 137, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		c.setLayout(gbl_panel_4);

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
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		c.add(panel_2, gbc_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconMedico.png")));
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_2_1 = new JLabel("Médicos disponíveis:");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 1;
		c.add(panel_3, gbc_panel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(216, 34, 86, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel_3.add(textField_1);

	}
}
