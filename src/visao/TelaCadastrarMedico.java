package visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaCadastrarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCrm;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastrarMedico() {
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
		
		JComboBox comboPronome = new RoundComboBox();
		comboPronome.setEditable(true);
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(255, 255, 255));
		comboPronome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
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
		
		txtCpf = new RoundJTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 47, 47));
		txtCpf.setCaretColor(Color.WHITE);
		panel.add(txtCpf, "cell 3 6,growx");
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Especialidade médica");
		panel.add(lblNewLabel_3, "cell 1 8");
		
		JLabel lblNewLabel_6 = new JLabel("Sexo");
		panel.add(lblNewLabel_6, "cell 3 8");
		
		JComboBox comboEspecialidade = new RoundComboBox();
		comboEspecialidade.setEditable(true);
		comboEspecialidade.setForeground(Color.BLACK);
		comboEspecialidade.setBackground(new Color(255, 255, 255));
		comboEspecialidade.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(comboEspecialidade, "cell 1 9,growx");
		
		JComboBox comboSexo =new RoundComboBox();
		comboSexo.setEditable(true);
		comboSexo.setForeground(Color.BLACK);
		comboSexo.setBackground(new Color(255, 255, 255));
		comboSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(comboSexo, "cell 3 9,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		panel.add(lblNewLabel_4, "cell 1 11");
		
		txtSenha = new RoundJTextField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setForeground(new Color(0, 47, 47));
		txtSenha.setCaretColor(Color.WHITE);
		panel.add(txtSenha, "cell 1 12,growx");
		txtSenha.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(64, 128, 128));
		btnAdicionar.setForeground(new Color(255, 255, 255));
		panel.add(btnAdicionar, "cell 1 16,alignx center,aligny bottom");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(new Color(255, 255, 255));
		panel.add(btnCancelar, "cell 3 16,alignx center,aligny bottom");
		
		String[] listaEspecialidade = {"Urologista", "Cardiologista", "Ginecologista", "Alergista", "Geriatra", "Otorrino", "Podologo", "Oncologista", "Neurologista", "Endocrinologista", "Fonodiologo", "Cirurgião"};
		for (String string : listaEspecialidade) {
			comboEspecialidade.addItem(string);
		}
	}
}
