package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtInserir;
	private JTextField txtInserir_6;
	private JTextField txtInserir_1;
	private JTextField txtInserir_5;
	private JTextField txtInserir_4;
	private JTextField txtAdicionarInformaes;
	private JTextField txtAno;


	public TelaCadastroPaciente() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new MigLayout("", "[58px,grow][11px][32px][5px][121px,grow][10px][69px]", "[36px][191px][10.00][32px][][33px][][33px,grow][14px][20px][14px][20px][6px][14px][1px][31px]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 2 1 3 1,grow");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconpeople.png")));
		lblNewLabel.setBounds(52, 44, 72, 96);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel.add(lblNewLabel_1, "cell 0 2,growx,aligny bottom");
		
		txtInserir = new JTextField();
		txtInserir.setText("Inserir");
		txtInserir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir.setColumns(10);
		panel.add(txtInserir, "cell 0 3 5 1,growx,aligny bottom");
		
		JLabel lblNewLabel_2 = new JLabel("Nome social");
		panel.add(lblNewLabel_2, "cell 0 4,growx,aligny bottom");
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		panel.add(lblNewLabel_3, "cell 0 6,growx,aligny bottom");
		
		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		panel.add(lblNewLabel_6, "cell 4 6,growx,aligny bottom");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "cell 0 7 7 1,grow");
		panel_3.setLayout(null);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setToolTipText("");
		comboDia.setForeground(new Color(0, 81, 81));
		comboDia.setBackground(new Color(255, 255, 255));
		comboDia.setBounds(121, 0, 52, 22);
		panel_3.add(comboDia);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setToolTipText("");
		comboMes.setBackground(new Color(255, 255, 255));
		comboMes.setForeground(new Color(0, 81, 81));
		comboMes.setBounds(183, 0, 68, 22);
		panel_3.add(comboMes);
		
		txtAno = new JTextField();
		txtAno.setBounds(261, 1, 59, 20);
		panel_3.add(txtAno);
		txtAno.setColumns(10);
		
		JComboBox comboSexo = new JComboBox();
		comboSexo.setForeground(new Color(0, 81, 81));
		comboSexo.setBackground(new Color(255, 255, 255));
		comboSexo.setBounds(0, 0, 99, 22);
		panel_3.add(comboSexo);
		
		txtInserir_6 = new JTextField();
		txtInserir_6.setText("Inserir");
		txtInserir_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_6.setColumns(10);
		panel.add(txtInserir_6, "cell 0 15 5 1,growx,aligny top");
		
		txtInserir_1 = new JTextField();
		txtInserir_1.setText("Inserir");
		txtInserir_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_1.setColumns(10);
		panel.add(txtInserir_1, "cell 0 5 5 1,growx,aligny bottom");
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		panel.add(lblNewLabel_7, "cell 0 13,growx,aligny bottom");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconCheck.png")));
		btnNewButton.setBackground(SystemColor.menu);
		panel.add(btnNewButton, "cell 6 11 1 5,alignx left,growy");
		
		txtInserir_5 = new JTextField();
		txtInserir_5.setText("Inserir");
		txtInserir_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_5.setColumns(10);
		panel.add(txtInserir_5, "cell 0 11 5 1,grow");
		
		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		panel.add(lblNewLabel_5_1, "cell 0 10 3 1,growx,aligny bottom");
		
		txtInserir_4 = new JTextField();
		txtInserir_4.setText("Inserir");
		txtInserir_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_4.setColumns(10);
		panel.add(txtInserir_4, "cell 0 9 5 1,alignx left,growy");
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		panel.add(lblNewLabel_5, "cell 0 8 3 1,growx,aligny center");
		
		txtAdicionarInformaes = new JTextField();
		txtAdicionarInformaes.setText("Adicionar Informações");
		txtAdicionarInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionarInformaes.setForeground(Color.WHITE);
		txtAdicionarInformaes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		txtAdicionarInformaes.setEditable(false);
		txtAdicionarInformaes.setColumns(10);
		txtAdicionarInformaes.setBackground(new Color(64, 128, 128));
		panel.add(txtAdicionarInformaes, "cell 0 0 7 1,grow");
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconmedicina.png")));
		contentPane.add(lblNewLabel_8, BorderLayout.CENTER);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new MigLayout("", "[89px]", "[23px]"));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setForeground(new Color(255, 255, 255));
		panel_2.add(btnVoltar, "cell 0 0,alignx left,aligny top");
		
		btnVoltar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		dispose();
		TelaPadrao telaPadrao = new TelaPadrao();
		telaPadrao.setLocationRelativeTo(null);
		telaPadrao.setVisible(true);
		telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}});
	}
}
