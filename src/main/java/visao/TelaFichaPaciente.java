package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

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

import controle.EnderecoDAO;
import controle.PacienteDAO;
import modelo.Endereco;
import modelo.Paciente;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaFichaPaciente extends JFrame implements InterfaceConfirmacao {

	private JPanel c;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtNomeSocial;
	private JTextField txtSexo;
	private JTextField txtNascimento;
	private JTextField txtCEP;
	private JTextField txtNumCasa;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JComboBox comboPronome;
	private JTextField txtRegistrosDosPacientes;
	private Paciente pacienteSelecionado;
	private Usuario usuarioAtual;
	private RoundJTextField txtComplemento;

	public TelaFichaPaciente(final Usuario usuarioAtual, final Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
		this.usuarioAtual = usuarioAtual;
		setTitle("Hospital Esmeralda - Ficha dos Paciente");
		setTitle("Hospital Esmeralda");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaFichaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 713);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/main/resources/img/Background2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		// c = new JPanel();
		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[247.00,grow][294.00px,grow][107.00,grow][273.00]",
				"[46,grow][611.00px,grow][46.00,grow]"));

		JPanel panel = new RoundJPanel(150);
		c.add(panel, "flowx,cell 1 0 1 3,alignx center,growy");

		panel.setLayout(new MigLayout("", "[58.00px,grow][grow][174.00px,grow][-1.00][138.00px,grow]", "[69.00,grow][][116.00px,grow][][][32px][][33px][][33px][14px][20px][14px][20px][][][1px][][21.00px][21.00,grow]"));

		txtRegistrosDosPacientes = new RoundJTextField();
		txtRegistrosDosPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistrosDosPacientes.setForeground(new Color(255, 255, 255));
		txtRegistrosDosPacientes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtRegistrosDosPacientes.setEditable(false);
		txtRegistrosDosPacientes.setText("Registro do paciente");
		txtRegistrosDosPacientes.setBackground(new Color(64, 128, 128));
		panel.add(txtRegistrosDosPacientes, "cell 0 0 5 1,grow");
		txtRegistrosDosPacientes.setColumns(10);

		JPanel panel_1 = new RoundJPanel(150, Color.white);
		panel_1.setBackground(null);
		panel_1.setBorder(null);
		// panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 2 2 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[73.00px,grow]", "[96px,grow]"));

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		lblNewLabel.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/iconpeople.png")));

		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel.add(lblNewLabel_1, "cell 0 4,alignx left,aligny bottom");

		JLabel lblCPF = new JLabel("CPF");
		panel.add(lblCPF, "cell 4 4");

		txtNome = new RoundJTextField();
		txtNome.setBackground(new Color(163, 163, 163));
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(txtNome, "cell 0 5 3 1,growx,aligny center");
		txtNome.setColumns(10);

		RoundJTextField txtCPF = new RoundJTextField();
		txtCPF.setBackground(new Color(163, 163, 163));
		txtCPF.setText(pacienteSelecionado.getCpf().toString());
		txtCPF.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCPF.setEditable(false);
		txtCPF.setColumns(10);
		panel.add(txtCPF, "cell 4 5,growx");

		JLabel lblNewLabel_2 = new JLabel("Nome social (se houver)");
		panel.add(lblNewLabel_2, "cell 0 6,alignx left,aligny bottom");

		JLabel lblNewLabel_2_1 = new JLabel("Pronome");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_2_1, "cell 4 6,alignx left,aligny bottom");

		comboPronome = new RoundComboBox();
		comboPronome.setEditable(true);
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(255, 255, 255));
		comboPronome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		String[] listaPronome = { "Ele/Dele", "Ela/Dela", "Qualquer pronome" };
		for (String string : listaPronome) {
			comboPronome.addItem(string);
		}
		panel.add(comboPronome, "cell 4 7,growx");

		JLabel lblNewLabel_3 = new JLabel("Sexo");
		panel.add(lblNewLabel_3, "cell 0 8,alignx left,aligny bottom");

		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		panel.add(lblNewLabel_6, "cell 2 8,alignx left,aligny bottom");

		JLabel lblNewLabel_5_1_1 = new JLabel("N\u00FAmero da casa");
		panel.add(lblNewLabel_5_1_1, "cell 2 12");

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Bairro");
		panel.add(lblNewLabel_5_1_1_1, "cell 4 12");

		txtNumCasa = new RoundJTextField();
		txtNumCasa.setText((String) null);
		txtNumCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNumCasa.setColumns(10);
		panel.add(txtNumCasa, "cell 2 13,growx");

		txtBairro = new RoundJTextField();
		txtBairro.setText((String) null);
		txtBairro.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		panel.add(txtBairro, "cell 4 13,growx");

		JLabel lblNewLabel_5_1_2 = new JLabel("Cidade");
		panel.add(lblNewLabel_5_1_2, "cell 0 14");

		JLabel Rua = new JLabel("Rua");
		panel.add(Rua, "cell 2 14");

		JLabel complemento = new JLabel("Complemento");
		panel.add(complemento, "cell 4 14");

		txtCidade = new RoundJTextField();
		txtCidade.setText((String) null);
		txtCidade.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		panel.add(txtCidade, "cell 0 15,growx");

		txtRua = new RoundJTextField();
		txtRua.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtRua.setColumns(10);
		panel.add(txtRua, "cell 2 15,growx,aligny center");

		txtComplemento = new RoundJTextField();
		txtComplemento.setText((String) null);
		txtComplemento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtComplemento.setColumns(10);
		panel.add(txtComplemento, "cell 4 15,growx");

		JLabel lblNewLabel_7 = new JLabel("E-mail");
		panel.add(lblNewLabel_7, "cell 0 17,growx,aligny bottom");

		txtEmail = new RoundJTextField();
		txtEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(txtEmail, "cell 0 18 3 1,growx,aligny center");
		txtEmail.setColumns(10);

		txtNomeSocial = new RoundJTextField();
		txtNomeSocial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(txtNomeSocial, "cell 0 7 3 1,growx,aligny center");
		txtNomeSocial.setColumns(10);

		txtSexo = new RoundJTextField();
		txtSexo.setBackground(new Color(163, 163, 163));
		txtSexo.setEditable(false);
		txtSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(txtSexo, "cell 0 9,growx,aligny center");
		txtSexo.setColumns(10);

		txtNascimento = new RoundJTextField();
		txtNascimento.setBackground(new Color(163, 163, 163));
		txtNascimento.setEditable(false);
		txtNascimento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(txtNascimento, "cell 2 9 3 1,growx,aligny center");
		txtNascimento.setColumns(10);

		txtCEP = new RoundJTextField();
		txtCEP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCEP.setColumns(10);
		panel.add(txtCEP, "cell 0 13 2 1,growx,aligny center");

		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		panel.add(lblNewLabel_5_1, "cell 0 12,growx,aligny bottom");

		txtTelefone = new RoundJTextField();
		panel.add(txtTelefone, "cell 0 11 3 1,growx,aligny center");
		txtTelefone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtTelefone.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telefone");
		panel.add(lblNewLabel_5, "cell 0 10,growx,aligny bottom");

		JButton btnConfirmar = new JButton("Confirmar alterações");
		panel.add(btnConfirmar, "cell 3 19 2 1,growx,aligny bottom");
		btnConfirmar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(0, 81, 81));
//		btnConfirmar.setBorder(null);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numCep = txtCEP.getText();
				String email = txtEmail.getText();
				String numTel = txtTelefone.getText();
				String nomeSoc = txtNomeSocial.getText();
				String numCasa = txtNumCasa.getText();
				String bairro = txtBairro.getText();
				String cidade = txtCidade.getText();
				String rua = txtRua.getText();
				String complemento = txtComplemento.getText();

				Long cep, telefone;
				Integer casa;

				Paciente p = pacienteSelecionado;
				PacienteDAO pDao = new PacienteDAO();
				Endereco en = pacienteSelecionado.getEndereco();
				EnderecoDAO eDao = new EnderecoDAO();

				if (numCep.trim().isEmpty()) {
					new DialogMensagemErro("CEP Vazio").setVisible(true);
					return;
				} else {
					try {
						cep = Long.valueOf(txtCEP.getText());
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo CEP!").setVisible(true);
						return;
					}
				}
				if (numTel.trim().isEmpty()) {
					new DialogMensagemErro("Telefone Vazio").setVisible(true);
					return;
				} else {
					try {
						telefone = Long.valueOf(txtTelefone.getText());
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo telefone!").setVisible(true);
						return;
					}
				}
				if (email.trim().isEmpty()) {
					new DialogMensagemErro("Email Vazio").setVisible(true);
					return;
				}

				if (nomeSoc.trim().isEmpty()) {
					nomeSoc = null;
				}

				if (complemento.trim().isEmpty()) {
					complemento = null;
				}

				if (numCasa.trim().isEmpty()) {
					new DialogMensagemErro("Numero d/ Casa Vazio").setVisible(true);
					return;
				} else {
					try {
						casa = Integer.valueOf(numCasa);
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo numero d/ casa!").setVisible(true);
						return;
					}
				}

				if (bairro.trim().isEmpty()) {
					new DialogMensagemErro("Bairro Vazio").setVisible(true);
					return;
				}

				if (cidade.trim().isEmpty()) {
					new DialogMensagemErro("Cidade Vazio").setVisible(true);
					return;
				}

				if (rua.trim().isEmpty()) {
					new DialogMensagemErro("Rua Vazio").setVisible(true);
					return;
				}

				p.setPronome(comboPronome.getSelectedItem().toString());
				p.setCep(cep);
				p.setEmail(email);
				p.setNomeSocial(nomeSoc);
				p.setNumCasa(casa);
				p.setTelefone(telefone);

				en.setBairro(bairro);
				en.setCidade(cidade);
				en.setComplemento(rua);
				en.setComplemento(complemento);
				en.setRua(rua);
				eDao.alterar(en);
				p.setEndereco(en);

				if (pDao.alterar(p)) {
					new DialogMensagemSucesso("Alterado com sucesso!").setVisible(true);
					dispose();
					TelaListaPaciente telaListaPaciente = new TelaListaPaciente(usuarioAtual);
					telaListaPaciente.setLocationRelativeTo(null);
					telaListaPaciente.setVisible(true);
					telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} else {
					new DialogMensagemErro("Erro ao alterar.").setVisible(true);

				}
			}
		});
		btnConfirmar.setBackground(new Color(0, 81, 81));
		btnConfirmar.setIcon(null);
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		final TelaFichaPaciente tela = this;

		JPanel panel_2 = new RoundJPanel(30, new Color(0, 64, 64));
		panel_2.setBackground(null);
		panel_2.setBorder(null);
		if(usuarioAtual.getTipo() == TipoUsuario.MEDICO || usuarioAtual.getTipo() == TipoUsuario.SECRETARIA) {
			c.add(panel_2, "flowx,cell 3 1,grow");
		}
		panel_2.setLayout(
				new MigLayout("", "[36.00,grow][177px][36.00px,grow]", "[grow][23px][][][][][grow]"));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4
				.setIcon(new ImageIcon(TelaPadrao.class.getResource("/img/EngrenagenzinhaBranquinhaUmPoucoMaior.png")));
		panel_2.add(lblNewLabel_4, "cell 1 0,alignx center,aligny top");
		// }

		JButton btnHistorico = new JButton("Acessar histórico de consultas");
		btnHistorico.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		panel_2.add(btnHistorico, "cell 1 1,growx,aligny top");
		btnHistorico.setForeground(new Color(255, 255, 255));
		btnHistorico.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHistorico.setBackground(null);
		btnHistorico.setOpaque(false);
//		btnHistorico.setBorder(null);

		JButton btnMarcarConsulta = new JButton("Marcar Consulta");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMarcarConsulta telaMarcarConsulta = new TelaMarcarConsulta(usuarioAtual, pacienteSelecionado);
				telaMarcarConsulta.setLocationRelativeTo(null);
				telaMarcarConsulta.setVisible(true);
				telaMarcarConsulta.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnMarcarConsulta.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		btnMarcarConsulta.setForeground(new Color(255, 255, 255));
		btnMarcarConsulta.setBackground(null);
		btnMarcarConsulta.setOpaque(false);
//		btnMarcarConsulta.setBorder(null);
		btnMarcarConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_2.add(btnMarcarConsulta, "cell 1 3,growx,aligny top");

		JButton btnDeletar = new JButton("Deletar Paciente");
		panel_2.add(btnDeletar, "cell 1 5,growx,aligny center");
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setBackground(new Color(240, 240, 240));
		btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogConfirmacao("O paciente será deletado.", tela).setVisible(true);
			}
		});
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDeletar.setFocusPainted(false);
		btnDeletar.setBackground(null);
		btnDeletar.setOpaque(false);
		
				JButton btnVoltar = new JButton("Voltar");
				c.add(btnVoltar, "flowx,cell 0 2,alignx left,aligny bottom");
				btnVoltar.setForeground(new Color(255, 255, 255));
				btnVoltar.setBackground(new Color(0, 81, 81));
				btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnVoltar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						dispose();
						TelaListaPaciente telaListaPaciente = new TelaListaPaciente(usuarioAtual);
						telaListaPaciente.setLocationRelativeTo(null);
						telaListaPaciente.setVisible(true);
						telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}
				});
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaHistorico telaHistorico = new TelaHistorico(usuarioAtual, pacienteSelecionado);
				telaHistorico.setLocationRelativeTo(null);
				telaHistorico.setVisible(true);
				telaHistorico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		receberDados(pacienteSelecionado);
	}

	private void receberDados(Paciente pacienteSelecionado) {
		txtNome.setText(pacienteSelecionado.getNome());
		txtNomeSocial.setText(pacienteSelecionado.getNomeSocial());
		comboPronome.setSelectedItem(pacienteSelecionado.getPronome());
		txtSexo.setText(pacienteSelecionado.getSexo());
		txtNascimento.setText(Date.valueOf(pacienteSelecionado.getNascimento()).toString());
		txtTelefone.setText(String.valueOf(pacienteSelecionado.getTelefone()));
		txtCEP.setText(String.valueOf(pacienteSelecionado.getCep()));
		txtNumCasa.setText(String.valueOf(pacienteSelecionado.getNumCasa()));
		txtBairro.setText(pacienteSelecionado.getEndereco().getBairro());
		txtCidade.setText(pacienteSelecionado.getEndereco().getCidade());
		txtRua.setText(pacienteSelecionado.getEndereco().getRua());
		txtEmail.setText(pacienteSelecionado.getEmail());
		txtComplemento.setText(pacienteSelecionado.getEndereco().getComplemento());
	}

	public void btnConfirmacao() {
		PacienteDAO pDao = new PacienteDAO();
		if (pDao.deletar(pacienteSelecionado)) {
			new DialogMensagemSucesso("Paciente deletado!").setVisible(true);
		} else {
			new DialogMensagemErro("Paciente já possui registros cadastrados!").setVisible(true);
		}
		dispose();
		TelaListaPaciente telaListaPaciente = new TelaListaPaciente(usuarioAtual);
		telaListaPaciente.setLocationRelativeTo(null);
		telaListaPaciente.setVisible(true);
		telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	public void bntCancelar() {
		// TODO Auto-generated method stub

	}
}