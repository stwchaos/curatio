package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setText("nome");
		txtNome.setBounds(96, 133, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setText("cpf");
		txtCpf.setBounds(96, 175, 86, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JComboBox comboSexo = new JComboBox();
		comboSexo.setBounds(96, 221, 86, 22);
		contentPane.add(comboSexo);
		
		JComboBox comboPronome = new JComboBox();
		comboPronome.setBounds(96, 271, 86, 22);
		contentPane.add(comboPronome);
		
		JComboBox comboEspecialidade = new JComboBox();
		comboEspecialidade.setBounds(96, 92, 86, 22);
		contentPane.add(comboEspecialidade);
		
		txtCrm = new JTextField();
		txtCrm.setText("crm");
		txtCrm.setBounds(246, 93, 86, 20);
		contentPane.add(txtCrm);
		txtCrm.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setText("senha");
		txtSenha.setBounds(246, 133, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		String[] listaEspecialidade = {"Urologista", "Cardiologista", "Ginecologista", "Alergista", "Geriatra", "Otorrino", "Podologo", "Oncologista", "Neurologista", "Endocrinologista", "Fonodiologo", "Cirurgião"};
		for (String string : listaEspecialidade) {
			comboEspecialidade.addItem(string);
		}
	}
}
