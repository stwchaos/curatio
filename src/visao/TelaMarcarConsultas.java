package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;

public class TelaMarcarConsultas extends JFrame {

	private JPanel c;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtInserirAno;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtMarcarConsulta;


	public TelaMarcarConsultas() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMarcarConsultas.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 713);
		BufferedImage bg = null;;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		//c = new JPanel();

		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[grow][434px][grow]", "[664px,grow]"));
		
		
		JButton btnVoltar = new JButton("Voltar");
		c.add(btnVoltar, "cell 0 0,alignx left,aligny bottom");
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		dispose();
		TelaPadrao telaPadrao = new TelaPadrao();
		telaPadrao.setLocationRelativeTo(null);
		telaPadrao.setVisible(true);
		telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}});
		
		JPanel panel = new JPanel();
		c.add(panel, "cell 1 0,alignx left,growy");
		panel.setLayout(new MigLayout("", "[58.00px,grow][10px][59px][10px][108px][10px][138.00px]", "[36px,grow][18.00][24.00px][14px][20px][14px][21px][14px][20px][14px][20px][6px][14px][20px][14.00px,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Paciente");
		panel.add(lblNewLabel_1, "cell 0 1,alignx left,aligny bottom");
		
		textField = new JTextField();
		textField.setText("Inserir");
		textField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField.setColumns(10);
		panel.add(textField, "cell 0 2 5 1,growx,aligny bottom");
		
		textField_1 = new JTextField();
		textField_1.setText("Inserir");
		textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_1.setColumns(10);
		panel.add(textField_1, "cell 0 13 5 1,grow");
		
		txtInserirAno = new JTextField();
		txtInserirAno.setText("Inserir ano");
		txtInserirAno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserirAno.setColumns(10);
		panel.add(txtInserirAno, "cell 4 6,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Profissional");
		panel.add(lblNewLabel_2, "cell 0 3 3 1,growx,aligny top");
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		panel.add(lblNewLabel_3, "cell 0 5 3 1,alignx left,aligny top");
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		panel.add(lblNewLabel_7, "cell 0 12 3 1,alignx left,aligny bottom");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TelaMarcarConsultas.class.getResource("/img/iconCheck.png")));
		btnNewButton.setBackground(SystemColor.menu);
		panel.add(btnNewButton, "cell 6 10 1 4,alignx left,growy");
		
		textField_5 = new JTextField();
		textField_5.setText("Inserir");
		textField_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_5.setColumns(10);
		panel.add(textField_5, "cell 0 10 5 1,grow");
		
		JLabel lblNewLabel_5_1 = new JLabel("Forma de Pagamento");
		panel.add(lblNewLabel_5_1, "cell 0 9 5 1,growx,aligny top");
		
		textField_6 = new JTextField();
		textField_6.setText("Inserir");
		textField_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_6.setColumns(10);
		panel.add(textField_6, "cell 0 8 5 1,alignx left,growy");
		
		JLabel lblNewLabel_5 = new JLabel("Objetivo");
		panel.add(lblNewLabel_5, "cell 0 7 3 1,growx,aligny top");
		
		txtMarcarConsulta = new JTextField();
		txtMarcarConsulta.setText("Marcar Consulta");
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(64, 128, 128));
		panel.add(txtMarcarConsulta, "cell 0 0 7 1,grow");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(210, 210, 210));
		panel.add(comboBox, "cell 0 4 5 1,grow");
		
		JComboBox comboDia = new JComboBox();
		comboDia.setForeground(new Color(0, 81, 81));
		comboDia.setBackground(new Color(255, 255, 255));
		panel.add(comboDia, "cell 0 6,alignx left,growy");
		
		JComboBox comboMes = new JComboBox();
		comboMes.setForeground(new Color(0, 81, 81));
		comboMes.setBackground(new Color(255, 255, 255));
		panel.add(comboMes, "cell 2 6,grow");
	}
}
