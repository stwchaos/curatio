package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import controle.EspecialidadeDAO;
import controle.FuncionarioDAO;
import controle.MedicoDAO;
import controle.UsuarioDAO;
import modelo.Especialidade;
import modelo.Funcionario;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;

public class TelaCadastrarProfisional extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCrm;
	private JTextField txtSenha;
	private ArrayList<Especialidade> listaEspecialidades;
	private JComboBox comboEspecialidade;
	private JComboBox comboSexo;
	private JComboBox comboPronome;
	private JComboBox comboBoxTipoProfissional;
	private TipoUsuario tipo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastrarProfisional(final Usuario usuarioAtual, final Medico medicoSelecionado, final Boolean editar,
			final Funcionario funcionarioSelecionado) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaCadastrarProfisional.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 81, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px,grow][500px][89px,grow]", "[40px,grow][500px][grow]"));

		final JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[grow][180px][grow][180.00,grow][grow]",
				"[40.00][grow][][][grow][][][grow][][][grow][][][][][][grow]"));

		JPanel panel_1 = new RoundJPanel(30, new Color(64, 128, 128));
		panel_1.setBackground(null);
		panel_1.setBorder(null);
		panel.add(panel_1, "cell 0 0 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[176px,grow]", "[28px,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Nome completo*");
		panel.add(lblNewLabel_1, "cell 1 2");

		JLabel lblNewLabel_7 = new JLabel("Pronome*");
		panel.add(lblNewLabel_7, "cell 3 2");

		txtNome = new RoundJTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setForeground(new Color(0, 47, 47));
		txtNome.setCaretColor(Color.WHITE);
		panel.add(txtNome, "cell 1 3,growx");
		txtNome.setColumns(10);

		comboPronome = new RoundComboBox();
		comboPronome.setEditable(true);
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(255, 255, 255));
		comboPronome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		String[] listaPronome = { "Ele/Dele", "Ela/Dela", "Qualquer pronome" };
		for (String string : listaPronome) {
			comboPronome.addItem(string);
			;
		}
		panel.add(comboPronome, "cell 3 3,growx");

		final JLabel lblNewLabel_2 = new JLabel("CRM*");
		panel.add(lblNewLabel_2, "cell 1 5");

		JLabel lblNewLabel_5 = new JLabel("CPF*");
		panel.add(lblNewLabel_5, "cell 3 5");

		txtCrm = new RoundJTextField();
		txtCrm.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrm.setBackground(new Color(255, 255, 255));
		txtCrm.setForeground(new Color(0, 47, 47));
		txtCrm.setCaretColor(Color.WHITE);
		txtCrm.setColumns(10);
		panel.add(txtCrm, "cell 1 6,growx");
		if (editar == true) {
			txtCrm.setEditable(false);
		}

		txtCpf = new RoundJTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 47, 47));
		txtCpf.setCaretColor(Color.WHITE);
		panel.add(txtCpf, "cell 3 6,growx");
		txtCpf.setColumns(10);
		if (editar == true) {
			txtCpf.setEditable(false);
		}

		final JLabel lblNewLabel_3 = new JLabel("Especialidade médica*");
		panel.add(lblNewLabel_3, "cell 1 8");

		JLabel lblNewLabel_6 = new JLabel("Sexo");
		panel.add(lblNewLabel_6, "cell 3 8");

		comboEspecialidade = new RoundComboBox();
		comboEspecialidade.setForeground(Color.BLACK);
		comboEspecialidade.setBackground(new Color(255, 255, 255));
		comboEspecialidade.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(comboEspecialidade, "cell 1 9,growx");
		EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();
		this.listaEspecialidades = especialidadeDao.listarEspecialidade();
		for (Especialidade e : listaEspecialidades) {
			comboEspecialidade.addItem(e.getEspecialidade());
		}

		comboBoxTipoProfissional = new RoundComboBox();
		comboBoxTipoProfissional.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tipo = TipoUsuario.ObterTipo(comboBoxTipoProfissional.getSelectedIndex() + 1);
				if (tipo == TipoUsuario.MEDICO) {
					panel.add(txtCrm, "cell 1 6,growx");
					panel.add(comboEspecialidade, "cell 1 9,growx");
					panel.add(lblNewLabel_3, "cell 1 8");
					panel.add(lblNewLabel_2, "cell 1 5");
				} else {
					System.out.println("teste");
					panel.remove(txtCrm);
					panel.remove(comboEspecialidade);
					panel.remove(lblNewLabel_2);
					panel.remove(lblNewLabel_3);
				}
			}
		});

		JLabel lblNewLabel_4_1 = new JLabel("Função*");
		panel.add(lblNewLabel_4_1, "cell 3 11");
		panel.add(comboBoxTipoProfissional, "cell 3 12,growx");
		String[] tipos = { "Medico", "Secretaria", "Administrador", "Outro" };
		for (String string : tipos) {
			comboBoxTipoProfissional.addItem(string);
		}

		comboSexo = new RoundComboBox();
		comboSexo.setEditable(true);
		comboSexo.setForeground(Color.BLACK);
		comboSexo.setBackground(new Color(255, 255, 255));
		comboSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		String[] listaSexo = { "Masculino", "Feminino", "Intersexo" };
		for (String string : listaSexo) {
			comboSexo.addItem(string);
			;
		}
		panel.add(comboSexo, "cell 3 9,growx");
		if (editar == true) {
			comboSexo.setEditable(false);
		}

		JLabel lblNewLabel_4 = new JLabel("Senha*");
		panel.add(lblNewLabel_4, "cell 1 11");

		txtSenha = new RoundJTextField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setForeground(new Color(0, 47, 47));
		txtSenha.setCaretColor(Color.WHITE);
		panel.add(txtSenha, "cell 1 12,growx");
		txtSenha.setColumns(10);

		JButton btnAdicionar;
		if (editar == true) {
			setTitle("Hospital Esmeralda - Editar Especialista");
			btnAdicionar = new JButton("Alterar");
			btnAdicionar.setBackground(new Color(64, 128, 128));
			btnAdicionar.setForeground(new Color(255, 255, 255));
			JLabel label = new JLabel("Alterar Profissional");
			label.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 17));
			label.setForeground(new Color(255, 255, 255));
			panel_1.add(label, "cell 0 0,alignx center,aligny bottom");
		} else {
			setTitle("Hospital Esmeralda - Cadastrar Especialista");
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBackground(new Color(64, 128, 128));
			btnAdicionar.setForeground(new Color(255, 255, 255));
			JLabel label = new JLabel("Cadastrar Profissional");
			label.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 17));
			label.setForeground(new Color(255, 255, 255));
			panel_1.add(label, "cell 0 0,alignx center,aligny bottom");
		}
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nCpf = txtCpf.getText();
				String nCrm = txtCrm.getText();
				String nome = txtNome.getText();
				String senha = txtSenha.getText();

				Long cpf;
				Long crm = null;

				Usuario u = new Usuario();
				UsuarioDAO uDao = new UsuarioDAO();

				if (nCpf.trim().isEmpty()) {
					new DialogMensagemErro("CPF Vazio").setVisible(true);
					return;
				} else {
					try {
						cpf = Long.valueOf(txtCpf.getText());
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo CPF!").setVisible(true);
						return;
					}
				}
				if (comboBoxTipoProfissional.getSelectedIndex() == 0) {
					if (nCrm.trim().isEmpty()) {
						new DialogMensagemErro("CRM Vazio").setVisible(true);
						return;
					} else {
						try {
							crm = Long.valueOf(txtCrm.getText());
						} catch (NumberFormatException e2) {
							new DialogMensagemErro("Informação inválida no campo CRM!").setVisible(true);
							return;
						}
					}
				}
				if (nome.trim().isEmpty()) {
					new DialogMensagemErro("Nome Vazio").setVisible(true);
					return;
				}
				if (editar == false) {
					if (senha.trim().isEmpty()) {
						new DialogMensagemErro("Senha Vazia").setVisible(true);
						return;
					}
				}

				if (editar == false) {
					u.setLogin(nome);
					if (!senha.trim().isEmpty()) {
						u.setSenha(senha);
					}
					u.setTipo(tipo);
					uDao.inserir(u);
				}

				if (comboBoxTipoProfissional.getSelectedIndex() == 0) {
					Medico m = new Medico();
					MedicoDAO medicoDao = new MedicoDAO();

					if (editar == true) {
						m = medicoSelecionado;
					}

					m.setCpf(cpf);
					m.setCrm(crm);
					Integer posicao = comboEspecialidade.getSelectedIndex();
					Especialidade especialidadeSelecionado = listaEspecialidades.get(posicao);
					m.setEspecialidade(especialidadeSelecionado);
					m.setNome(nome);
					m.setPronome(String.valueOf(comboPronome.getSelectedItem()));
					m.setSexo(String.valueOf(comboSexo.getSelectedItem()));

					if (editar != true) {
						m.setUsuario(u);
					} else {
						u = medicoSelecionado.getUsuario();
						u.setLogin(nome);
						u.setTipo(tipo);
						if (!senha.trim().isEmpty()) {
							u.setSenha(senha);
						}
					}

					if (editar == true) {
						if (medicoDao.alterar(m) == true) {
							new DialogMensagemSucesso("Alterado com sucesso").setVisible(true);
							uDao.alterar(u);
						} else {
							new DialogMensagemErro("Não foi possível alterar").setVisible(true);
						}
					} else {
						if (medicoDao.inserir(m) == true) {
							new DialogMensagemSucesso("Cadastrado com sucesso").setVisible(true);
						} else {
							new DialogMensagemErro("Não foi possível cadastrar").setVisible(true);
						}
					}
				} else {
					Funcionario f = new Funcionario();
					FuncionarioDAO fDao = new FuncionarioDAO();

					if (editar == true) {
						f = funcionarioSelecionado;
					}

					f.setCpf(cpf);
					f.setNome(nome);
					f.setPronome(String.valueOf(comboPronome.getSelectedItem()));
					f.setSexo(String.valueOf(comboSexo.getSelectedItem()));

					if (editar != true) {
						f.setUsuario(u);
					} else {
						u = funcionarioSelecionado.getUsuario();
						u.setLogin(nome);
						u.setTipo(tipo);
						if (!senha.trim().isEmpty()) {
							u.setSenha(senha);
						}
					}

					if (editar == true) {
						if (fDao.alterar(f) == true) {
							new DialogMensagemSucesso("Alterado com sucesso").setVisible(true);
							uDao.alterar(u);
						} else {
							new DialogMensagemErro("Não foi possível alterar").setVisible(true);
						}
					} else {
						if (fDao.inserir(f) == true) {
							new DialogMensagemSucesso("Cadastrado com sucesso").setVisible(true);
						} else {
							new DialogMensagemErro("Não foi possível cadastrar").setVisible(true);
						}
					}
				}

				dispose();
				TelaListaProfissional tela = new TelaListaProfissional(usuarioAtual);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnAdicionar.setBackground(new Color(0, 81, 81));
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setFont(new Font("Yu Gothic Light", Font.PLAIN, 11));
		panel.add(btnAdicionar, "cell 1 16,alignx center,aligny bottom");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaProfissional tela = new TelaListaProfissional(usuarioAtual);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(new Color(255, 255, 255));
		panel.add(btnCancelar, "cell 3 16,alignx center,aligny bottom");

		if (editar == true && medicoSelecionado == null) {
			receberDadosF(funcionarioSelecionado);
		}
		if (editar == true && funcionarioSelecionado == null) {
			receberDadosM(medicoSelecionado);
		}
	}

	private void receberDadosM(Medico medicoSelecioado) {
		txtNome.setText(medicoSelecioado.getNome());
		txtCrm.setText(String.valueOf(medicoSelecioado.getCrm()));
		txtCpf.setText(String.valueOf(medicoSelecioado.getCpf()));
		comboEspecialidade.setSelectedIndex(medicoSelecioado.getEspecialidade().getIdEspecialidade() - 1);
		comboSexo.setSelectedItem(medicoSelecioado.getSexo());
		comboPronome.setSelectedItem(medicoSelecioado.getPronome());
		comboBoxTipoProfissional.setSelectedItem(medicoSelecioado.getUsuario().getTipo());
	}

	private void receberDadosF(Funcionario funcionarioSelecionado) {
		txtNome.setText(funcionarioSelecionado.getNome());
		txtCpf.setText(String.valueOf(funcionarioSelecionado.getCpf()));
		comboSexo.setSelectedItem(funcionarioSelecionado.getSexo());
		comboPronome.setSelectedItem(funcionarioSelecionado.getPronome());
		comboBoxTipoProfissional.setSelectedIndex(funcionarioSelecionado.getUsuario().getTipo().tipo - 1);
	}
}
