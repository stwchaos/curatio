package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioDAO;
import controle.MedicoDAO;
import controle.UsuarioDAO;
import modelo.Funcionario;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaListaProfissional extends JFrame implements InterfaceConfirmacao {

	private JPanel contentPane;
	private JTextField txtPesquisarProfissional;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnVoltar;
	private JPanel panel_2;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private Medico medicoSelecionado = null;
	private Funcionario funcionarioSelecionado = null;
	private MedicoDAO mDao = new MedicoDAO();
	private FuncionarioDAO fDao = new FuncionarioDAO();
	private Boolean editar;
	private int linha;
	private DefaultTableModel modelo;
	private DefaultTableModel pesquisa;

	public TelaListaProfissional(final Usuario usuarioAtual) {

		setForeground(new Color(0, 85, 85));
		setBackground(new Color(0, 85, 85));
		setTitle("Hospital Esmeralda - Profissionais");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaProfissional.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 845);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 229, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][-12.00px][395.00px,grow][grow][23.00,center][238.00px,left]",
				"[][28.00px,fill][19px][49.00][342.00px,grow][31px]"));

		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 2 3 2 1,grow");
		panel_1.setBackground(new Color(64, 128, 128));

		lblNewLabel = new JLabel("Profissionais");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 2 4 2 1,grow");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 471, 0 };
		gbl_panel.rowHeights = new int[] { 638, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linha = table.getSelectedRow();
				Long id = (Long) table.getValueAt(linha, 0);
				for (Medico medico : mDao.listarProfissionais()) {
					if (id.equals(medico.getCpf())) {
						medicoSelecionado = medico;
						funcionarioSelecionado = null;
					}
				}
				for (Funcionario funcionario : fDao.listarFuncionarios()) {
					if (id.equals(funcionario.getCpf())) {
						funcionarioSelecionado = funcionario;
						medicoSelecionado = null;
					}
				}
			}
		});

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Especialidade" });
		pesquisa = new DefaultTableModel(new Object[][] {}, new String[] { "CPF", "Nome", "Especialidade" });
		table.setModel(modelo);
		scrollPane.setViewportView(table);

		txtPesquisarProfissional = new JTextField();
		txtPesquisarProfissional.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisa.setRowCount(0);
				ArrayList<Medico> medicos = mDao.listarPesquisa(txtPesquisarProfissional.getText());
				ArrayList<Funcionario> funcionarios = fDao.listarPesquisa(txtPesquisarProfissional.getText());
				if (txtPesquisarProfissional.getText().isEmpty()) {
					txtPesquisarProfissional.setForeground(new Color(128, 128, 128));
					table.setModel(modelo);
				} else {
					if (medicos.size() != 0) {
						for (Medico medico : medicos) {
							pesquisa.addRow(new Object[] { medico.getCpf(), medico.getNome(),
									medico.getEspecialidade().getEspecialidade() });
						}
					}
					if (funcionarios.size() != 0) {
						for (Funcionario funcionario : funcionarios) {
							pesquisa.addRow(new Object[] { funcionario.getCpf(), funcionario.getNome(),
									funcionario.getUsuario().getTipo() });
						}
					}
					txtPesquisarProfissional.setForeground(new Color(0, 0, 0));
					table.setModel(pesquisa);
				}
			}
		});
		txtPesquisarProfissional.setForeground(new Color(128, 128, 128));
		txtPesquisarProfissional.setToolTipText("");
		txtPesquisarProfissional.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		contentPane.add(txtPesquisarProfissional, "cell 2 1,growx,aligny bottom");
		txtPesquisarProfissional.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao(usuarioAtual);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		contentPane.add(btnVoltar, "cell 2 5,alignx left,aligny top");

		if (usuarioAtual.getTipo() == TipoUsuario.ADMIN) {

			JPanel panel_2 = new RoundJPanel(50, new Color(0, 81, 81));
			panel_2.setBackground(null);
			contentPane.add(panel_2, "cell 5 1 1 5,grow");
			panel_2.setLayout(
					new MigLayout("", "[grow][89px][grow]", "[184.00,grow][279.00,grow][51.00px][51.00][51.00][grow]"));

			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(
					new ImageIcon(TelaListaProfissional.class.getResource("/img/EngrenagenzinhaBranquinhaUmPoucoMaior.png")));
			panel_2.add(lblNewLabel_1, "cell 1 0,alignx center,aligny top");

			lblNewLabel_2 = new JLabel("Controle de Administrador");
			lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			panel_2.add(lblNewLabel_2, "cell 1 1,growx,aligny top");

			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setForeground(new Color(255, 255, 255));
			btnAdicionar.setBackground(new Color(0, 81, 81));
			btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnAdicionar.setFocusPainted(false);
			btnAdicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editar = false;
					medicoSelecionado = null;
					funcionarioSelecionado = null;
					dispose();
					TelaCadastrarProfisional tela = new TelaCadastrarProfisional(usuarioAtual, medicoSelecionado,
							editar, funcionarioSelecionado);
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					tela.setExtendedState(JFrame.MAXIMIZED_BOTH);

				}
			});
			panel_2.add(btnAdicionar, "cell 1 2,growx,aligny center");

			btnAlterar = new JButton("Alterar");
			btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (medicoSelecionado == null && funcionarioSelecionado == null) {
						new DialogMensagemErro("Médico não selecionado").setVisible(true);
						return;
					}

					editar = true;
					dispose();
					TelaCadastrarProfisional telaAlterar = new TelaCadastrarProfisional(usuarioAtual, medicoSelecionado,
							editar, funcionarioSelecionado);
					telaAlterar.setLocationRelativeTo(null);
					telaAlterar.setVisible(true);
					telaAlterar.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			});
			btnAlterar.setForeground(new Color(255, 255, 255));
			btnAlterar.setBackground(new Color(0, 81, 81));
			btnAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnAlterar.setFocusPainted(false);
			panel_2.add(btnAlterar, "cell 1 3,growx,aligny center");

			btnDeletar = new JButton("Deletar");
			final TelaListaProfissional tela = this;
			btnDeletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (medicoSelecionado == null && funcionarioSelecionado == null) {
						new DialogMensagemErro("Nada selecionado!").setVisible(true);
						return;
					}
					new DialogConfirmacao("O médico será deletado.", tela).setVisible(true);

				}
			});

			btnDeletar.setForeground(new Color(255, 255, 255));
			btnDeletar.setBackground(new Color(0, 81, 81));
			btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnDeletar.setFocusPainted(false);
			panel_2.add(btnDeletar, "cell 1 4,growx,aligny center");
		}
		listarMedicos();
	}

	private void listarMedicos() {
		modelo.setRowCount(0);
		for (Medico medico : mDao.listarProfissionais()) {
			modelo.addRow(
					new Object[] { medico.getCpf(), medico.getNome(), medico.getEspecialidade().getEspecialidade() });
		}
		for (Funcionario funcionario : fDao.listarFuncionarios()) {
			modelo.addRow(
					new Object[] { funcionario.getCpf(), funcionario.getNome(), funcionario.getUsuario().getTipo() });
		}
		table.setModel(modelo);
	}

	// TODO override

	public void btnConfirmacao() {
		MedicoDAO mDao = new MedicoDAO();
		UsuarioDAO uDao = new UsuarioDAO();
		Usuario usuarioAtual = null;

		if (medicoSelecionado != null) {
			usuarioAtual = medicoSelecionado.getUsuario();
			if (mDao.deletar(medicoSelecionado)) {
				if (uDao.deletar(usuarioAtual)) {
					new DialogMensagemSucesso("Médico deletado com sucesso").setVisible(true);

				} else {
					new DialogMensagemErro("Ocorreu um erro no delete").setVisible(true);
				}
			} else {
				new DialogMensagemErro("Impossível deletar, medico já possui registros cadastrados").setVisible(true);
			}
		}

		if (funcionarioSelecionado != null) {
			usuarioAtual = funcionarioSelecionado.getUsuario();
			if (fDao.deletar(funcionarioSelecionado)) {
				if (uDao.deletar(usuarioAtual)) {
					new DialogMensagemSucesso("Funcionário deletado com sucesso").setVisible(true);
				} else {
					new DialogMensagemErro("Ocorreu um erro no delete").setVisible(true);
				}
			} else {
				new DialogMensagemErro("Impossível deletar, profissional já possui registros cadastrados")
						.setVisible(true);
			}
		}

		listarMedicos();

	}

	public void bntCancelar() {

	}

}
