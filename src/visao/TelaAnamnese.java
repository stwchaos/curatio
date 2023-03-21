package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAnamnese extends JFrame {

	private JPanel contentPane;
	private JTextField txtIentificao;
	private JTextField txtAnamneseOriental;
	private JTextField textNomeR;
	private JTextField textNomeS;
	private JComboBox comboPronome;
	private JLabel lblNewLabel_2;
	private JTextField textSexo;
	private JLabel lblNewLabel_4;
	private JDateChooser dtNascimento;
	private JLabel lblNewLabel_5;
	private JTextField textProfissao;
	private JLabel lblNewLabel_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAnamnese frame = new TelaAnamnese();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAnamnese() {
		setTitle("Hospital Esmeralda - Anamnese");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAnamnese.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 81, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][][][103.00][20.00][][][][][][][][][][][][][][grow]", "[grow][][][][][][][][][][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel, "cell 1 0 10 11,growx,aligny top");
		panel.setLayout(new MigLayout("", "[108.00,grow][108,grow]", "[32.00][][][][][][][][][][][][]"));
		
		txtIentificao = new RoundJTextField();
		txtIentificao.setHorizontalAlignment(SwingConstants.CENTER);
		txtIentificao.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtIentificao.setText("Identificação");
		txtIentificao.setEditable(false);
		txtIentificao.setBackground(new Color(64, 128, 128));
		txtIentificao.setForeground(new Color(255, 255, 255));
		panel.add(txtIentificao, "cell 0 0 2 1,grow");
		txtIentificao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome de Registro");
		panel.add(lblNewLabel, "cell 0 2");
		
		textNomeR = new RoundJTextField();
		textNomeR.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textNomeR, "cell 0 3 2 1,growx");
		textNomeR.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Social");
		panel.add(lblNewLabel_1, "cell 0 4");
		
		JLabel lblPronome = new JLabel("Pronome");
		panel.add(lblPronome, "cell 1 4");
		
		textNomeS = new RoundJTextField();
		textNomeS.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textNomeS, "cell 0 5,growx");
		textNomeS.setColumns(10);
		
		comboPronome = new JComboBox();
		comboPronome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(comboPronome, "cell 1 5,growx");
		
		lblNewLabel_2 = new JLabel("Sexo");
		panel.add(lblNewLabel_2, "cell 0 6");
		
		textSexo = new RoundJTextField();
		textSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textSexo, "cell 0 7,growx");
		textSexo.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Data de Nascimento");
		panel.add(lblNewLabel_4, "cell 0 8");
		
		dtNascimento = new JDateChooser();
		dtNascimento.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dtNascimento.getCalendarButton().setBackground(new Color(210, 210, 210));
		dtNascimento.setForeground(new Color(0, 81, 81));
		dtNascimento.setBackground(new Color(229, 229, 229));
		panel.add(dtNascimento, "cell 0 9,growx,aligny center");
		
		lblNewLabel_5 = new JLabel("Profissão");
		panel.add(lblNewLabel_5, "cell 0 10");
		
		textProfissao = new RoundJTextField();
		textProfissao.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textProfissao, "cell 0 11,growx");
		textProfissao.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 12 0 14 11,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[32][][61.00][grow]"));
		
		txtAnamneseOriental = new RoundJTextField();
		txtAnamneseOriental.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnamneseOriental.setText("Anamnese Oriental");
		txtAnamneseOriental.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtAnamneseOriental.setBackground(new Color(64, 128, 128));
		txtAnamneseOriental.setForeground(new Color(255, 255, 255));
		panel_1.add(txtAnamneseOriental, "cell 0 0,grow");
		txtAnamneseOriental.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Queixa Principal");
		panel_1.add(lblNewLabel_3, "cell 0 1");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 0 2,grow");
		textField.setColumns(10);
	}

}
