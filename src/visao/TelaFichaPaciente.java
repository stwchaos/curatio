package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medico;
import modelo.Usuario;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;

public class TelaFichaPaciente extends JFrame {

	private JPanel c;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldNomeSocial;
	private JTextField textFieldSexo;
	private JTextField textFieldNascimento;
	private JTextField textFieldCEP;
	private JTextField txtRegistrosDosPacientes;

	public TelaFichaPaciente(Usuario u) {
		setTitle("Hospital Esmeralda - Ficha dos Pacientes");
		setTitle("Hospital Esmeralda");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaFichaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 713);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		// c = new JPanel();
		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[247.00,grow][294.00px,grow][247.00,grow]", "[682px,grow]"));

		JButton btnVoltar = new JButton("Voltar");
		c.add(btnVoltar, "cell 0 0,alignx left,aligny bottom");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao(u);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new RoundJPanel(150);
		c.add(panel, "flowx,cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("",
				"[58.00px,grow][-16.00,grow][11px,grow][32px,grow][5px][56.00px][18.00,grow][138.00px,grow]",
				"[69.00,grow][181.00px][][][32px][grow][33px][grow][33px,bottom][14px,grow][20px][14px,grow][20px,grow][1px][][21.00px][21.00,grow]"));

		txtRegistrosDosPacientes = new RoundJTextField();
		txtRegistrosDosPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistrosDosPacientes.setForeground(new Color(255, 255, 255));
		txtRegistrosDosPacientes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtRegistrosDosPacientes.setEditable(false);
		txtRegistrosDosPacientes.setText("Registro do paciente");
		txtRegistrosDosPacientes.setBackground(new Color(64, 128, 128));
		panel.add(txtRegistrosDosPacientes, "cell 0 0 8 1,grow");
		txtRegistrosDosPacientes.setColumns(10);

		JPanel panel_1 = new RoundJPanel(150, Color.white);
		panel_1.setBackground(null);
		panel_1.setBorder(null);
		// panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 0 1 6 1,grow");
		panel_1.setLayout(new MigLayout("", "[73.00px,grow]", "[96px,grow]"));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/iconpeople.png")));
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny center");

		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel.add(lblNewLabel_1, "cell 0 3,alignx left,aligny bottom");

		JLabel lblCPF = new JLabel("CPF");
		panel.add(lblCPF, "cell 7 3");

		textFieldNome = new RoundJTextField();
		textFieldNome.setBackground(new Color(219, 219, 219));
		textFieldNome.setEditable(false);
		textFieldNome.setText("Inalterável");
		textFieldNome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldNome, "cell 0 4 6 1,growx,aligny center");
		textFieldNome.setColumns(10);

		RoundJTextField textFieldCPF = new RoundJTextField();
		textFieldCPF.setBackground(new Color(219, 219, 219));
		textFieldCPF.setText("Inalterável");
		textFieldCPF.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldCPF.setEditable(false);
		textFieldCPF.setColumns(10);
		panel.add(textFieldCPF, "cell 7 4,growx");

		JLabel lblNewLabel_2 = new JLabel("Nome social (se houver)");
		panel.add(lblNewLabel_2, "cell 0 5 4 1,alignx left,aligny bottom");

		JLabel lblNewLabel_2_1 = new JLabel("Pronome *");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_2_1, "cell 7 5,alignx left,aligny bottom");

		RoundComboBox comboPronome = new RoundComboBox();
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(218, 218, 218));

		String[] listaPronome = { "Ele/Dele", "Ela/Dela", "Qualquer pronome" };
		comboPronome.setSelectedItem("Inserir");
		for (String pronome : listaPronome) {
			comboPronome.addItem(pronome);
		}
		panel.add(comboPronome, "cell 7 6,growx");

		JLabel lblNewLabel_3 = new JLabel("Sexo");
		panel.add(lblNewLabel_3, "cell 0 7,alignx left,aligny bottom");

		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		panel.add(lblNewLabel_6, "cell 5 7,alignx left,aligny bottom");

		JLabel lblNewLabel_7 = new JLabel("E-mail");
		panel.add(lblNewLabel_7, "cell 0 14,growx,aligny bottom");

		textFieldEmail = new RoundJTextField();
		textFieldEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldEmail.setText("Alterável");
		panel.add(textFieldEmail, "cell 0 15 6 1,growx,aligny center");
		textFieldEmail.setColumns(10);

		textFieldNomeSocial = new RoundJTextField();
		textFieldNomeSocial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldNomeSocial.setText("Alterável");
		panel.add(textFieldNomeSocial, "cell 0 6 6 1,growx,aligny center");
		textFieldNomeSocial.setColumns(10);

		textFieldSexo = new RoundJTextField();
		textFieldSexo.setBackground(new Color(219, 219, 219));
		textFieldSexo.setEditable(false);
		textFieldSexo.setText("Inalterável");
		textFieldSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldSexo, "cell 0 8 4 1,growx,aligny center");
		textFieldSexo.setColumns(10);

		textFieldNascimento = new RoundJTextField();
		textFieldNascimento.setBackground(new Color(219, 219, 219));
		textFieldNascimento.setEditable(false);
		textFieldNascimento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldNascimento.setText("Inalterável");
		panel.add(textFieldNascimento, "cell 5 8 3 1,growx,aligny center");
		textFieldNascimento.setColumns(10);

		JButton btnConfirmar = new JButton("");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBackground(new Color(240, 240, 240));
		btnConfirmar.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/iconCheck.png")));
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnConfirmar, "cell 7 12 1 4,alignx center,aligny center");

		textFieldCEP = new RoundJTextField();
		textFieldCEP.setText("Alterável");
		textFieldCEP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldCEP.setColumns(10);
		panel.add(textFieldCEP, "cell 0 12 6 1,growx,aligny center");

		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		panel.add(lblNewLabel_5_1, "cell 0 11 4 1,growx,aligny bottom");

		textFieldTelefone = new RoundJTextField();
		panel.add(textFieldTelefone, "cell 0 10 6 1,growx,aligny center");
		textFieldTelefone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldTelefone.setText("Alterável");
		textFieldTelefone.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telefone");
		panel.add(lblNewLabel_5, "cell 0 9 4 1,growx,aligny bottom");

		JButton btnDeletar = new JButton("Deletar Paciente");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogConfirmacao("O paciente será deletado.").setVisible(true);
			}
		});
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnDeletar.setBackground(new Color(191, 0, 0));
		btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDeletar.setBorderPainted(false);
		btnDeletar.setFocusPainted(false);
		panel.add(btnDeletar, "cell 7 16,growx");

		JButton btnHistorico = new JButton("Acessar histórico de consultas");
		c.add(btnHistorico, "cell 2 0,alignx right,aligny bottom");
		btnHistorico.setForeground(new Color(255, 255, 255));
		btnHistorico.setBackground(new Color(0, 81, 81));
		btnHistorico.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaHistorico telaHistorico = new TelaHistorico(u);
				telaHistorico.setLocationRelativeTo(null);
				telaHistorico.setVisible(true);
				telaHistorico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

	}
}