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

import controle.PacienteDAO;
import controle.ProfissionalDAO;

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
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class TelaPadrao extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNmeroPadrao;
	private JTextField txtMedDisp;
	private JTextField txtContaLogada;
	private JTextField txtConsultasHj;
	private JTextField txtConsultasPend;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaPadrao() {
		PacienteDAO pacientedao = new PacienteDAO();
		ProfissionalDAO profissionaldao = new ProfissionalDAO();
		setForeground(new Color(0, 51, 51));
		setTitle("Hospital Esmeralda");
		setBackground(new Color(0, 51, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPadrao.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1266, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 81, 81));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[][223.00,grow]",
				"[32.00,grow][][149.00][65px][61.00][][60.00][][58.00][][57.00][]"));

		JButton btnProfissionais = new JButton("Profissionais");
		btnProfissionais.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/Carinha com um carinha atras dele.png")));
		btnProfissionais.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfissionais.setBackground(null);
		btnProfissionais.setOpaque(false);
		btnProfissionais.setBorder(null);
		btnProfissionais.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnProfissionais.setFocusPainted(false);
		btnProfissionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaMedico telaListaMedico = new TelaListaMedico();
				telaListaMedico.setLocationRelativeTo(null);
				telaListaMedico.setVisible(true);
				telaListaMedico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JButton btnSair = new JButton("Log out");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel_4 = new RoundJPanel(150, Color.white);
		panel_4.setBackground(null);
		panel.add(panel_4, "flowx,cell 1 0,alignx center,aligny center");
		panel_4.setLayout(new MigLayout("", "[72px]", "[72px]"));

		JLabel lblNewLabel = new JLabel("");
		panel_4.add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		lblNewLabel.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconpeople.png")));
		btnSair.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSair.setBackground(null);
		btnSair.setOpaque(false);
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setBorder(new RoundBorder(new Color(210, 210, 210), 1, 2));
		btnSair.setFocusPainted(false);
		panel.add(btnSair, "cell 0 1 2 1,growx,aligny bottom");
		btnProfissionais.setForeground(Color.WHITE);
		btnProfissionais.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		panel.add(btnProfissionais, "cell 1 3,growx,aligny center");

		JButton btnMarcarConsulta = new JButton("Marcar consulta");
		btnMarcarConsulta.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/Escrevendo coisa.png")));
		btnMarcarConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		btnMarcarConsulta.setBorder(null);
		btnMarcarConsulta.setBackground(null);
		btnMarcarConsulta.setOpaque(false);
		btnMarcarConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMarcarConsulta.setFocusPainted(false);
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
		panel.add(btnMarcarConsulta, "cell 1 4,growx,aligny center");

		JButton btnCadastrarPaciente = new JButton("Cadastrar paciente");
		btnCadastrarPaciente.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/Carinha com o mais do lado.png")));
		btnCadastrarPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrarPaciente.setBackground(null);
		btnCadastrarPaciente.setOpaque(false);
		btnCadastrarPaciente.setForeground(new Color(255, 255, 255));
		btnCadastrarPaciente.setBorder(null);
		btnCadastrarPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrarPaciente.setFocusPainted(false);
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
		panel.add(btnCadastrarPaciente, "cell 1 6,growx,aligny center");

		JButton btnListaPaciente = new JButton("Pacientes");
		btnListaPaciente.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/Caderno Carinha.png")));
		btnListaPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		btnListaPaciente.setBackground(null);
		btnListaPaciente.setOpaque(false);
		btnListaPaciente.setForeground(new Color(255, 255, 255));
		btnListaPaciente.setBorder(null);
		btnListaPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnListaPaciente.setFocusPainted(false);
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

		panel.add(btnListaPaciente, "cell 1 8,growx,aligny center");

		JButton btnConsultasPendentes = new JButton("Consultas pendentes");
		btnConsultasPendentes.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/Gavetinha.png")));
		btnConsultasPendentes.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultasPendentes.setBackground(null);
		btnConsultasPendentes.setOpaque(false);
		btnConsultasPendentes.setForeground(new Color(255, 255, 255));
		btnConsultasPendentes.setBorder(null);
		btnConsultasPendentes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConsultasPendentes.setFocusPainted(false);
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
		panel.add(btnConsultasPendentes, "cell 1 10,growx,aligny center");

		txtContaLogada = new JTextField();
		txtContaLogada.setEditable(false);
		txtContaLogada.setEnabled(false);
		txtContaLogada.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtContaLogada.setText("Conta logada(nome)");
		txtContaLogada.setForeground(new Color(255, 255, 255));
		txtContaLogada.setBackground(new Color(0, 81, 81));
		txtContaLogada.setBorder(null);
		panel.add(txtContaLogada, "cell 1 0,growx,aligny center");
		txtContaLogada.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Bem-vindo!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		panel_1.add(lblNewLabel_1);

		// JPanel panel_4 = new JPanel();

		JPanel panelMeio = new JPanel();
		panelMeio.setBackground(new Color(218, 218, 218));
		contentPane.add(panelMeio, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 120, 421, 414, 0 };
		gbl_panel_4.rowHeights = new int[] { 137, 0, 84, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panelMeio.setLayout(gbl_panel_4);

		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel_2 = new RoundJPanel(30, new Color(240, 240, 240));
		panel_2.setBackground(null);
		panel_2.setBorder(null);
		panel_2.setLayout(new MigLayout("", "[90px,grow][67.00px][80px,grow]", "[21px,grow][72px]"));
		
		JPanel panel_6 = new RoundJPanel(30, new Color(192, 192, 192));
		panel_6.setBackground(new Color(240, 240, 240));
		panel_6.setBorder(null);
		panel_2.add(panel_6, "cell 2 0 1 2,grow");
		panel_6.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconBatimento.png")));
		panel_6.add(lblNewLabel_3, "cell 1 1");

		JLabel lblNewLabel_2 = new JLabel("Pacientes cadastrados");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_2, "cell 0 1 2 1,alignx left,aligny top");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));

		txtNmeroPadrao = new JTextField();
		txtNmeroPadrao.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtNmeroPadrao.setText(String.valueOf(pacientedao.listarPacientes().size()));
		txtNmeroPadrao.setForeground(new Color(0, 81, 81));
		txtNmeroPadrao.setBackground(new Color(240, 240, 240));
		txtNmeroPadrao.setEditable(false);
		txtNmeroPadrao.setBorder(null);
		panel_2.add(txtNmeroPadrao, "cell 0 0,grow");
		txtNmeroPadrao.setColumns(10);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.SOUTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panelMeio.add(panel_2, gbc_panel_2);

		JPanel panel_3 = new RoundJPanel(30, new Color(240, 240, 240));
		panel_3.setBackground(null);
		panel_3.setBorder(null);
		panel_3.setLayout(new MigLayout("", "[90.00,grow][67.00px,grow][80.00px,grow]", "[22px][72px,grow]"));

		txtMedDisp = new JTextField();
		txtMedDisp.setBackground(new Color(240, 240, 240));
		txtMedDisp.setForeground(new Color(0, 81, 81));
		txtMedDisp.setText(String.valueOf(profissionaldao.listarProfissionais().size()));
		txtMedDisp.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtMedDisp.setEditable(false);
		txtMedDisp.setColumns(10);
		txtMedDisp.setBorder(null);
		panel_3.add(txtMedDisp, "cell 0 0,alignx left,growy");

		JLabel lblNewLabel_2_1 = new JLabel("Médicos disponíveis");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		panel_3.add(lblNewLabel_2_1, "cell 0 1 2 1,growx,aligny top");
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 0;
		panelMeio.add(panel_3, gbc_panel_3);
		
		RoundJPanel panel_6_1_1_1 = new RoundJPanel(30, Color.LIGHT_GRAY);
		panel_6_1_1_1.setBorder(null);
		panel_6_1_1_1.setBackground(SystemColor.menu);
		panel_3.add(panel_6_1_1_1, "cell 2 0 1 2,grow");
		panel_6_1_1_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_6_1_1_1.add(lblNewLabel_4, "cell 1 1");
		lblNewLabel_4.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconCruz.png")));

		JPanel panel_5 = new RoundJPanel(30, new Color(240, 240, 240));
		panel_5.setBackground(null);
		panel_5.setBorder(null);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 1;
		panelMeio.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new MigLayout("", "[90.00,grow][67.00][80.00,grow]", "[21.00][72.00,grow]"));

		txtConsultasHj = new JTextField();
		txtConsultasHj.setText("0");
		txtConsultasHj.setForeground(new Color(0, 81, 81));
		txtConsultasHj.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtConsultasHj.setEditable(false);
		txtConsultasHj.setColumns(10);
		txtConsultasHj.setBorder(null);
		txtConsultasHj.setBackground(SystemColor.menu);
		panel_5.add(txtConsultasHj, "cell 0 0,grow");

		JLabel lblNewLabel_2_2 = new JLabel("Consultas hoje");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_2_2.setBackground(Color.WHITE);
		panel_5.add(lblNewLabel_2_2, "cell 0 1 2 1,alignx left,aligny top");
		
		RoundJPanel panel_6_1 = new RoundJPanel(30, Color.LIGHT_GRAY);
		panel_6_1.setBorder(null);
		panel_6_1.setBackground(SystemColor.menu);
		panel_5.add(panel_6_1, "cell 2 0 1 2,grow");
		panel_6_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconCalendar.png")));
		panel_6_1.add(lblNewLabel_5, "cell 1 1");
		
		JPanel panel_7 = new RoundJPanel(30, new Color(240, 240, 240));
		panel_7.setBackground(null);
		panel_7.setBorder(null);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.WEST;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 1;
		panelMeio.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new MigLayout("", "[90.00,grow][67.00,grow][80.00,grow]", "[22.00][72.00,grow]"));
		
		txtConsultasPend = new JTextField();
		txtConsultasPend.setText("0");
		txtConsultasPend.setForeground(new Color(0, 81, 81));
		txtConsultasPend.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		txtConsultasPend.setEditable(false);
		txtConsultasPend.setColumns(10);
		txtConsultasPend.setBorder(null);
		txtConsultasPend.setBackground(SystemColor.menu);
		panel_7.add(txtConsultasPend, "cell 0 0,growx");
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Consultas pendentes");
		lblNewLabel_2_2_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBackground(Color.WHITE);
		panel_7.add(lblNewLabel_2_2_1, "cell 0 1 2 1,alignx left,aligny top");
		
		RoundJPanel panel_6_1_1 = new RoundJPanel(30, Color.LIGHT_GRAY);
		panel_6_1_1.setBorder(null);
		panel_6_1_1.setBackground(SystemColor.menu);
		panel_7.add(panel_6_1_1, "cell 2 0 1 2,grow");
		panel_6_1_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/iconClipBoard.png")));
		panel_6_1_1.add(lblNewLabel_6, "cell 1 1");
		JPanel c = new PanelComBackgroundImage(bg);
		c.setBackground(new Color(218, 218, 218));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 3;
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panelMeio.add(c, gbc_panel_6);
		

	}
}
