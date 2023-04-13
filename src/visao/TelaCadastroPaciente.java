package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controle.EnderecoDAO;
import controle.PacienteDAO;
import modelo.Endereco;
import modelo.Paciente;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaCadastroPaciente extends JFrame {

	private JPanel c;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtNomeSoc;
	private JTextField txtRua;
	private JTextField txtTelefone;
	private JTextField txtAdicionarInformaes;

	public TelaCadastroPaciente(Usuario u) {

		setTitle("Hospital Esmeralda - Cadastrar Paciente");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 713);

		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		// c = new JPanel();
		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[247.00,grow][278.00px,grow,center][247.00,grow]", "[479.00px,grow]"));

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
				TelaPadrao telaPadrao = new TelaPadrao(u);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new RoundJPanel(150);
		panel.setBackground(new Color(240, 240, 240));
		c.add(panel, "cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[58px,grow][67px,grow][27px][67px,grow][58px,grow]",
				"[36px,grow][][192.00px][][][23.00px][][][][bottom][19.00px][][][][][center][][][][][][21.00px,grow][grow]"));

		JLabel lblNewLabel_1 = new JLabel("Nome *");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_1, "cell 0 4,alignx left,aligny bottom");

		JLabel lblNewLabel_2_1 = new JLabel("Pronome *");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_2_1, "cell 3 4 2 1,alignx left,aligny bottom");

		txtNome = new RoundJTextField();
		txtNome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNome.setColumns(10);
		panel.add(txtNome, "cell 0 5 2 1,growx,aligny bottom");

		RoundComboBox comboPronome = new RoundComboBox();
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(218, 218, 218));
		comboPronome.setSelectedItem("Inserir");
		panel.add(comboPronome, "cell 3 5 2 1,growx,aligny center");

		JLabel lblNewLabel_1_1 = new JLabel("CPF *");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBackground(Color.BLACK);
		panel.add(lblNewLabel_1_1, "cell 0 7");

		JLabel lblNewLabel_4 = new JLabel("Número da Casa *");
		panel.add(lblNewLabel_4, "cell 3 7");

		RoundJTextField txtCPF = new RoundJTextField();
		txtCPF.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCPF.setColumns(10);
		panel.add(txtCPF, "cell 0 8 2 1,growx");

		RoundJTextField txtNumeroCasa = new RoundJTextField();
		txtNumeroCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNumeroCasa.setColumns(10);
		panel.add(txtNumeroCasa, "cell 3 8 2 1,growx");

		JLabel lblNewLabel_2 = new JLabel("Nome social (se houver)");
		lblNewLabel_2.setToolTipText("Nome social");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_2, "cell 0 9 2 1,alignx left,aligny bottom");
		String[] listaPronome = { "Ele/Dele", "Ela/Dela", "Qualquer pronome" };
		for (String string : listaPronome) {
			comboPronome.addItem(string);
		}

		JLabel lblNewLabel_5_2_1 = new JLabel("Bairro *");
		lblNewLabel_5_2_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_5_2_1, "cell 3 9");

		RoundJTextField txtBairro = new RoundJTextField();
		txtBairro.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		panel.add(txtBairro, "cell 3 10 2 1,growx");

		JLabel lblNewLabel_5 = new JLabel("Telefone *");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5, "cell 0 12,alignx left,aligny bottom");

		JLabel lblNewLabel_5_2 = new JLabel("Cidade *");
		lblNewLabel_5_2.setForeground(Color.BLACK);
		panel.add(lblNewLabel_5_2, "cell 3 12 2 1");

		txtTelefone = new RoundJTextField();
		txtTelefone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtTelefone.setColumns(10);
		panel.add(txtTelefone, "cell 0 13 2 1,growx,aligny top");

		RoundJTextField txtCidade = new RoundJTextField();
		txtCidade.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		panel.add(txtCidade, "cell 3 13 2 1,growx");

		JLabel lblNewLabel_7 = new JLabel("E-mail *");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_7, "cell 0 15,alignx left,aligny bottom");

		JLabel lblNewLabel_5_1 = new JLabel("Rua *");
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5_1, "cell 3 15,alignx left,aligny bottom");

		txtEmail = new RoundJTextField();
		txtEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		panel.add(txtEmail, "cell 0 16 2 1,growx,aligny top");

		txtRua = new RoundJTextField();
		txtRua.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtRua.setColumns(10);
		panel.add(txtRua, "cell 3 16 2 1,grow");

		JLabel lblNewLabel_7_1 = new JLabel("Complemento");
		lblNewLabel_7_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_7_1, "cell 0 18");

		JLabel lblNewLabel_5_1_1 = new JLabel("CEP *");
		lblNewLabel_5_1_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_5_1_1, "cell 3 18");

		RoundJTextField txtComplemento = new RoundJTextField();
		txtComplemento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtComplemento.setColumns(10);
		panel.add(txtComplemento, "cell 0 19 2 1,growx");

		RoundJTextField txtCEP = new RoundJTextField();
		txtCEP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCEP.setColumns(10);
		panel.add(txtCEP, "cell 3 19 2 1,growx");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 240, 240));
		panel.add(panel_3, "cell 0 21 5 1,grow");
		panel_3.setLayout(new MigLayout("", "[99px,grow][grow][156px,grow]", "[][22px][][][][]"));

		JLabel lblNewLabel_3 = new JLabel("Sexo *");
		panel_3.add(lblNewLabel_3, "cell 0 0");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("Nascimento *");
		panel_3.add(lblNewLabel_6, "cell 2 0");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));

		JComboBox comboSexo = new RoundComboBox();
		comboSexo.setForeground(new Color(0, 0, 0));
		comboSexo.setBackground(new Color(218, 218, 218));
		comboSexo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_3.add(comboSexo, "cell 0 1,growx,aligny top");
		String[] listaSexo = { "Masculino", "Feminino" };
		comboSexo.setSelectedItem("Inserir");
		for (String pronome : listaSexo) {
			comboSexo.addItem(pronome);

		}

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
		dtNascimento.getDate();

		txtNomeSoc = new RoundJTextField();
		txtNomeSoc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNomeSoc.setColumns(10);
		panel.add(txtNomeSoc, "cell 0 10 2 1,growx,aligny bottom");

		txtAdicionarInformaes = new RoundJTextField();
		txtAdicionarInformaes.setText("Adicionar Informações");
		txtAdicionarInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionarInformaes.setForeground(Color.WHITE);
		txtAdicionarInformaes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtAdicionarInformaes.setEditable(false);
		txtAdicionarInformaes.setColumns(10);
		txtAdicionarInformaes.setBackground(new Color(64, 128, 128));
		panel.add(txtAdicionarInformaes, "cell 0 0 5 1,grow");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = txtNome.getText();
				String numCpf = txtCPF.getText();
				String numCep = txtCEP.getText();
				String nomeSoc = txtNomeSoc.getText();
				String email = txtEmail.getText();
				String bairro = txtBairro.getText();
				String rua = txtRua.getText();
				String numTel = txtTelefone.getText();
				String cidade = txtCidade.getText();
				String complemento = txtComplemento.getText(); // TODO cuidado
				String numCasa = txtNumeroCasa.getText();
				
				Long cpf, cep;
				Integer telefone, casa;

				Endereco end = new Endereco();
				
				// TODO separar um if para cada
				if(nome.trim().isEmpty() &&  numCpf.trim().isEmpty() && numCep.trim().isEmpty() && email.trim().isEmpty() && bairro.trim().isEmpty() && rua.trim().isEmpty() && numTel.trim().isEmpty() && cidade.trim().isEmpty() && numCasa.trim().isEmpty()) {
					new DialogMensagemErro("Todos os campos estão vazios!").setVisible(true);
				} else {
					if(!nome.trim().isEmpty()) {
						 nome = txtNome.getText();
					 }else{
						 new DialogMensagemErro("Nome Vazio").setVisible(true);
					 }
					 
					 if(!numCpf.trim().isEmpty()) {
						 cpf = Long.valueOf(txtCPF.getText());
					 }else {
						 new DialogMensagemErro("CPF Vazio").setVisible(true);
					 }
					 
					 if(!numCep.trim().isEmpty()) {
						 
						 try {
							 cep = Long.valueOf(txtCEP.getText());
							 end.setCep(cep);
							} catch (NumberFormatException e2) {
								new DialogMensagemErro("Informação inválida!").setVisible(true);
								return;
							}
					 }else {
						 new DialogMensagemErro("CEP Vazio").setVisible(true);
					 }
					 
					 if(!email.trim().isEmpty()) {
						 email = txtEmail.getText();
					 }else {
						 new DialogMensagemErro("Email Vazio").setVisible(true);
					 }
					 
					 if(!bairro.trim().isEmpty()) {
						 bairro = txtBairro.getText();
						 end.setBairro(bairro);
					 }else {
						 new DialogMensagemErro("Bairro Vazio").setVisible(true);
					 }
					 
					 if(!rua.trim().isEmpty()) {
						 rua = txtRua.getText();
						 end.setRua(rua);
					 }else {
						 new DialogMensagemErro("Rua Vazio").setVisible(true);
					 }
					 
					 if(!numTel.trim().isEmpty()) {
						 try {
								telefone = Integer.valueOf(txtTelefone.getText());
							} catch (NumberFormatException e2) {
								new DialogMensagemErro("Informação inválida!").setVisible(true);
								return;
							}
						 
					 }else {
						 new DialogMensagemErro("Telefone Vazio").setVisible(true);
					 }
					 
					 if(!cidade.trim().isEmpty()) {
						 cidade = txtCidade.getText();
						 end.setCidade(cidade);
					 }else {
						 new DialogMensagemErro("Cidade Vazio").setVisible(true);
					 }
					 
					 if(!numCasa.trim().isEmpty()) {
						 try {
							casa = Integer.valueOf(txtNumeroCasa.getText());
							end.setNumCasa(casa);
						} catch (NumberFormatException e2) {
							new DialogMensagemErro("Informação inválida!").setVisible(true);
							return;
						}
						 
					 }else {
						 new DialogMensagemErro("Casa Vazio").setVisible(true);
					 }
				}
				
				
				
				 Paciente p = new Paciente();
				 p.setNome(nome);
				 p.setEndereco(end);	 
				 PacienteDAO dao = new PacienteDAO();
				if( dao.inserir(p) == true) {
					JOptionPane.showMessageDialog(c, "amém");
				}else {
					JOptionPane.showMessageDialog(c, "nãooooooooooo");
				}
				 
			}
		});
		panel.add(btnCadastrar, "cell 4 22,growx,aligny bottom");
		btnCadastrar.setForeground(new Color(229, 229, 229));
		btnCadastrar.setBackground(new Color(0, 81, 81));
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setFocusPainted(false);

		JPanel panel_1 = new RoundJPanel(150, Color.white);
		panel_1.setBackground(null);
		panel_1.setBorder(null);
		// panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 1 2 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[73.00px,grow]", "[96px,grow]"));

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconpeople.png")));
	}

	private Color Color(int i, int j, int k) {
		return null;
	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
