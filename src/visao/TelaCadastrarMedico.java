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

import controle.EspecialidadeDAO;
import controle.MedicoDAO;
import controle.UsuarioDAO;
import modelo.Especialidade;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;

public class TelaCadastrarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCrm;
	private JTextField txtSenha;
	private ArrayList<Especialidade> listaEspecialidades;
	private JComboBox comboEspecialidade;
	private JComboBox comboSexo;
	private JComboBox comboPronome;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastrarMedico(Usuario usuarioAtual, Medico medicoSelecionado, Boolean editar) {
		setTitle("Hospital Esmeralda - Cadastrar Especialista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 81, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px,grow][500px][89px,grow]", "[40px,grow][500px][grow]"));
		
		JPanel panel =  new JPanel();
		contentPane.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[grow][180px][grow][180.00][grow]", "[40.00][grow][][][grow][][][grow][][][grow][][][][][][grow]"));
		
		JPanel panel_1 =  new RoundJPanel(30, new Color(64, 128, 128));
		panel_1.setBackground(null);
		panel_1.setBorder(null);
		panel.add(panel_1, "cell 0 0 5 1,grow");
		panel_1.setLayout(new MigLayout("", "[176px,grow]", "[28px,grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Profissional");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny bottom");
		
		JLabel lblNewLabel_1 = new JLabel("Nome completo");
		panel.add(lblNewLabel_1, "cell 1 2");
		
		JLabel lblNewLabel_7 = new JLabel("Pronome");
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
		String[] listaPronome = {"Ele/Dele", "Ela/Dela", "Qualquer pronome"};
		for (String string : listaPronome) {
			comboPronome.addItem(string);;
		}
		panel.add(comboPronome, "cell 3 3,growx");
		
		JLabel lblNewLabel_2 = new JLabel("CRM");
		panel.add(lblNewLabel_2, "cell 1 5");
		
		JLabel lblNewLabel_5 = new JLabel("CPF");
		panel.add(lblNewLabel_5, "cell 3 5");
		
		txtCrm = new RoundJTextField();
		txtCrm.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrm.setBackground(new Color(255, 255, 255));
		txtCrm.setForeground(new Color(0, 47, 47));
		txtCrm.setCaretColor(Color.WHITE);
		panel.add(txtCrm, "cell 1 6,growx");
		txtCrm.setColumns(10);
		if(editar==true) {
			txtCrm.setEditable(false);
		}
		
		txtCpf = new RoundJTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 47, 47));
		txtCpf.setCaretColor(Color.WHITE);
		panel.add(txtCpf, "cell 3 6,growx");
		txtCpf.setColumns(10);
		if(editar==true) {
			txtCpf.setEditable(false);
		}
		
		JLabel lblNewLabel_3 = new JLabel("Especialidade médica");
		panel.add(lblNewLabel_3, "cell 1 8");
		
		JLabel lblNewLabel_6 = new JLabel("Sexo");
		panel.add(lblNewLabel_6, "cell 3 8");
		
		comboEspecialidade = new RoundComboBox();
		comboEspecialidade.setEditable(true);
		comboEspecialidade.setForeground(Color.BLACK);
		comboEspecialidade.setBackground(new Color(255, 255, 255));
		comboEspecialidade.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();
		this.listaEspecialidades=especialidadeDao.listarEspecialidade();
		for (Especialidade e : listaEspecialidades) {
			comboEspecialidade.addItem(e.getEspecialidade());
		}
		
		
		panel.add(comboEspecialidade, "cell 1 9,growx");
		
		comboSexo =new RoundComboBox();
		comboSexo.setEditable(true);
		comboSexo.setForeground(Color.BLACK);
		comboSexo.setBackground(new Color(255, 255, 255));
		comboSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		String[] listaSexo = {"Masculino", "Feminino", "Intersexo" };
		for (String string : listaSexo) {
			comboSexo.addItem(string);;
		}
		panel.add(comboSexo, "cell 3 9,growx");
		if(editar==true) {
			comboSexo.setEditable(false);
		}
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		panel.add(lblNewLabel_4, "cell 1 11");
		
		txtSenha = new RoundJTextField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setForeground(new Color(0, 47, 47));
		txtSenha.setCaretColor(Color.WHITE);
		panel.add(txtSenha, "cell 1 12,growx");
		txtSenha.setColumns(10);
		
		JButton btnAdicionar;
		if(editar==true) {
			btnAdicionar = new JButton("Alterar");
		}else {
			btnAdicionar = new JButton("Adicionar");
		}
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nCpf = txtCpf.getText();
				String nCrm = txtCrm.getText();
				String nome = txtNome.getText();
				String senha = txtSenha.getText();
				
				Long cpf = Long.valueOf(nCpf);
				Long crm = Long.valueOf(nCrm);
				
				Medico m = new Medico();
				Usuario u = new Usuario();
				Especialidade es = new Especialidade();
				MedicoDAO medicoDao = new MedicoDAO();
				UsuarioDAO usuarioDao = new UsuarioDAO();
				EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();
				
				m.setCpf(cpf);
				m.setCrm(crm);
				
				Integer posicao = comboEspecialidade.getSelectedIndex();
				Especialidade especialidadeSelecionado = listaEspecialidades.get(posicao);
				m.setEspecialidade(especialidadeSelecionado);
				m.setNome(nome);
				m.setPronome(String.valueOf(comboPronome.getSelectedItem()));
				m.setSexo(String.valueOf(comboSexo.getSelectedItem()));
				
				u.setLogin(nome);
				u.setSenha(senha);
				u.setTipo(TipoUsuario.MEDICO);
				usuarioDao.inserir(u);
				m.setUsuario(u);
				
				
				if(editar==true) {
					if(medicoDao.alterar(m)==true) {
						new DialogConfirmacao("Alterado com sucesso").setVisible(true);
					}else {
						new DialogMensagemErro("Não foi possível alterar").setVisible(true);
					}
				}else {
					if(medicoDao.inserir(m)==true) {
						new DialogConfirmacao("Cadastrado com sucesso").setVisible(true);
					}else {
						new DialogMensagemErro("Não foi possível cadastrar").setVisible(true);
					}
				}
				
				dispose();
				TelaListaMedico tela = new TelaListaMedico(usuarioAtual);
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
				TelaListaMedico tela = new TelaListaMedico(usuarioAtual);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(new Color(255, 255, 255));
		panel.add(btnCancelar, "cell 3 16,alignx center,aligny bottom");
		
		if(editar==true) {
			receberDados(medicoSelecionado);
		}
	}
	private void receberDados(Medico medicoSelecioado) {
		txtNome.setText(medicoSelecioado.getNome());
		txtCrm.setText(String.valueOf(medicoSelecioado.getCrm()));
		txtCpf.setText(String.valueOf(medicoSelecioado.getCpf()));
		comboEspecialidade.setSelectedItem(medicoSelecioado.getEspecialidade().getEspecialidade());
		comboSexo.setSelectedItem(medicoSelecioado.getSexo());
		comboPronome.setSelectedItem(medicoSelecioado.getPronome());
	}
}
