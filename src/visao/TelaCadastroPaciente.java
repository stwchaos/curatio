package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controle.EnderecoDAO;
import controle.PacienteDAO;
import modelo.Endereco;
import modelo.Paciente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;

public class TelaCadastroPaciente extends JFrame {

	private JPanel c;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtNomeSocial;
	private JTextField txtCEP;
	private JTextField txtTelefone;
	private JTextField txtAdicionarInformaes;
	private JTextField txtCPF;

	public TelaCadastroPaciente() {
		setTitle("Hospital Esmeralda");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/logoHospital.png")));
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
		c.setLayout(new MigLayout("", "[247.00,grow][294.00px,grow][247.00,grow]", "[479.00px,grow]"));

		JButton btnVoltar = new JButton("Voltar");
		c.add(btnVoltar, "cell 0 0,alignx left,aligny bottom");
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setFocusPainted(false);

		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao();
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		c.add(panel, "cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("",
				"[grow][58px,grow][11px,grow][32px,grow][5px][56.00px][18.00px,grow][138.00px,grow]",
				"[36px,grow][192.00px][][23.00px][bottom][19.00px][center][][][][18.00][22.00][21.00px,grow][grow]"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 1 1 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[73.00px,grow]", "[96px,grow]"));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconpeople.png")));
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny center");

		JLabel lblNewLabel_1 = new JLabel("Nome *");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_1, "cell 1 2,alignx left,aligny bottom");

		txtNome = new JTextField();
		txtNome.setText("Inserir");
		txtNome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNome.setColumns(10);
		panel.add(txtNome, "cell 1 3 5 1,growx,aligny bottom");

		JLabel lblNewLabel_2 = new JLabel("Nome social (se houver)");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_2, "cell 1 4 3 1,alignx left,aligny bottom");

		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5, "cell 1 6,alignx left,aligny bottom");

		txtTelefone = new JTextField();
		txtTelefone.setText("Inserir");
		txtTelefone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtTelefone.setColumns(10);
		panel.add(txtTelefone, "cell 1 7 4 1,growx,aligny top");

		JLabel lblNewLabel_5_1 = new JLabel("CEP *");
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5_1, "cell 1 8,alignx left,aligny bottom");

		txtCEP = new JTextField();
		txtCEP.setText("Inserir");
		txtCEP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCEP.setColumns(10);
		panel.add(txtCEP, "cell 1 9 4 1,grow");

		JLabel lblNewLabel_7 = new JLabel("E-mail *");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_7, "cell 1 10,alignx left,aligny bottom");

		txtEmail = new JTextField();
		txtEmail.setText("Inserir");
		txtEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		panel.add(txtEmail, "cell 1 11 5 1,growx,aligny top");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 240, 240));
		panel.add(panel_3, "cell 0 12 8 1,grow");
		panel_3.setLayout(new MigLayout("", "[99px,grow][grow][156px,grow]", "[][22px][][][][][]"));

		JLabel lblNewLabel_3 = new JLabel("Sexo *");
		panel_3.add(lblNewLabel_3, "cell 0 0");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("Nascimento *");
		panel_3.add(lblNewLabel_6, "cell 2 0");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));

		JComboBox comboSexo = new RoundComboBox();
		comboSexo.setForeground(new Color(0, 81, 81));
		comboSexo.setBackground(new Color(255, 255, 255));
		comboSexo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_3.add(comboSexo, "cell 0 1,growx,aligny top");
		String[] listaSexo = { "Masculino", "Feminino" };
		comboSexo.setSelectedItem("Inserir");
		for (String string : listaSexo) {
			comboSexo.addItem(string);
		}
		comboSexo.setSelectedItem(null);

		JDateChooser dtNascimento = new JDateChooser();
		dtNascimento.getCalendarButton().setBackground(new Color(210, 210, 210));
		dtNascimento.setForeground(new Color(0, 81, 81));
		dtNascimento.setBackground(new Color(229, 229, 229));
		dtNascimento.setCursor(new Cursor(Cursor.HAND_CURSOR));

		dtNascimento.setDate(new Date());

		dtNascimento.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		panel_3.add(dtNascimento, "cell 2 1,growx,aligny bottom");

		txtCPF = new JTextField();
		panel_3.add(txtCPF, "cell 0 3,growx");
		txtCPF.setColumns(10);
		dtNascimento.getDate();

		txtNomeSocial = new JTextField();
		txtNomeSocial.setText("Inserir");
		txtNomeSocial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNomeSocial.setColumns(10);
		panel.add(txtNomeSocial, "cell 1 5 5 1,growx,aligny bottom");

		txtAdicionarInformaes = new JTextField();
		txtAdicionarInformaes.setText("Adicionar Informações");
		txtAdicionarInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionarInformaes.setForeground(Color.WHITE);
		txtAdicionarInformaes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtAdicionarInformaes.setEditable(false);
		txtAdicionarInformaes.setColumns(10);
		txtAdicionarInformaes.setBackground(new Color(64, 128, 128));
		panel.add(txtAdicionarInformaes, "cell 0 0 8 1,grow");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long cpf = null;
				if (!txtCPF.getText().isBlank()) {
					cpf = Long.valueOf(txtCPF.getText());
				}
				String nome = null;
				if (!txtNome.getText().isBlank()) {
					nome = txtCPF.getText();
				}

				Date nasc = dtNascimento.getDate();

				Integer telefone = null;
				if (!txtTelefone.getText().isBlank()) {
					telefone = Integer.valueOf(txtTelefone.getText());
				}
				String sexo = null;
				if (comboSexo.getSelectedItem() == null) {
					System.exit(ERROR);
					new DialogMensagemErro("Sexo n�o definido").setVisible(true);
				}
				sexo = String.valueOf(comboSexo.getSelectedItem());
				String nomeSocial = null;
				if (!txtNomeSocial.getText().isBlank()) {
					nomeSocial = txtNomeSocial.getText();
				}
				String email = null;
				if (txtEmail.getText().isBlank()) {
					email = txtEmail.getText();
				}
				Endereco endereco = null;
				if(txtCEP.getText().isBlank()) {
					endereco = Endereco.valueOf(txtCEP.getText());
				}
				PacienteDAO p = new PacienteDAO();

				Paciente paciente = new Paciente();
				paciente.setCpf(cpf);
				paciente.setEmail(email);
				EnderecoDAO en = new EnderecoDAO();
				paciente.setEndereco(endereco);
				for (Endereco end : en.listarEndereco()) {
					if (end.getCep() == paciente.getEndereco().getCep()) {
						break;
					}
					en.inserir(paciente.getEndereco().getCep());
				}
				paciente.setEndereco(cep);
				paciente.setCpf(cpf);
				paciente.setNascimento(nasc.toLocalDa);
				boolean validacao = p.inserir(paciente);
				if (validacao == true) {
					// sucesso
				} else {
					// erro
				}

			}
		});
		panel.add(btnCadastrar, "cell 5 13 3 1,growx,aligny bottom");
		btnCadastrar.setForeground(new Color(229, 229, 229));
		btnCadastrar.setBackground(new Color(0, 81, 81));
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setFocusPainted(false);
	}

	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
