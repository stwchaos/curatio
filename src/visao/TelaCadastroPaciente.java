package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import modelo.Medico;
import modelo.Usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;

public class TelaCadastroPaciente extends JFrame {

	private JPanel c;
	private JTextField txtInserir;
	private JTextField txtInserir_6;
	private JTextField txtInserir_1;
	private JTextField txtInserir_5;
	private JTextField txtInserir_4;
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
			// TODO Auto-generated catch block
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
		panel.setLayout(new MigLayout("", "[58px,grow][67px,grow][27px][67px,grow][58px,grow]", "[36px,grow][][192.00px][][][23.00px][][bottom][19.00px][][][][][center][][][][][][21.00px,grow][grow]"));

		JLabel lblNewLabel_1 = new JLabel("Nome *");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_1, "cell 0 4,alignx left,aligny bottom");
		
				JLabel lblNewLabel_2_1 = new JLabel("Pronome *");
				lblNewLabel_2_1.setForeground(Color.BLACK);
				panel.add(lblNewLabel_2_1, "cell 3 4 2 1,alignx left,aligny bottom");

		txtInserir = new RoundJTextField();
		txtInserir.setText("Inserir");
		txtInserir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir.setColumns(10);
		panel.add(txtInserir, "cell 0 5 2 1,growx,aligny bottom");
		
				RoundComboBox comboPronome = new RoundComboBox();
				comboPronome.setForeground(Color.BLACK);
				comboPronome.setBackground(new Color(218, 218, 218));
				comboPronome.setSelectedItem("Inserir");
				panel.add(comboPronome, "cell 3 5 2 1,growx,aligny center");

		JLabel lblNewLabel_2 = new JLabel("Nome social");
		lblNewLabel_2.setToolTipText("Nome social");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_2, "cell 0 7,alignx left,aligny bottom");
				String[] listaPronome = { "Ele/Dele", "Ela/Dela", "Qualquer pronome" };
				for (String string : listaPronome) {
					comboPronome.addItem(string);
				}
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Bairro *");
		lblNewLabel_5_2_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_5_2_1, "cell 3 7");
		
		RoundJTextField txtInserir_4_1_1 = new RoundJTextField();
		txtInserir_4_1_1.setText("Inserir");
		txtInserir_4_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_4_1_1.setColumns(10);
		panel.add(txtInserir_4_1_1, "cell 3 8 2 1,growx");
		

		JLabel lblNewLabel_5 = new JLabel("Telefone *");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5, "cell 0 10,alignx left,aligny bottom");
				
				JLabel lblNewLabel_5_2 = new JLabel("Cidade *");
				lblNewLabel_5_2.setForeground(Color.BLACK);
				panel.add(lblNewLabel_5_2, "cell 3 10 2 1");
		
				txtInserir_4 = new RoundJTextField();
				txtInserir_4.setText("Inserir");
				txtInserir_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
				txtInserir_4.setColumns(10);
				panel.add(txtInserir_4, "cell 0 11 2 1,growx,aligny top");
				
				RoundJTextField txtInserir_4_1 = new RoundJTextField();
				txtInserir_4_1.setText("Inserir");
				txtInserir_4_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
				txtInserir_4_1.setColumns(10);
				panel.add(txtInserir_4_1, "cell 3 11 2 1,growx");
						
								JLabel lblNewLabel_7 = new JLabel("E-mail *");
								lblNewLabel_7.setForeground(new Color(0, 0, 0));
								panel.add(lblNewLabel_7, "cell 0 13,alignx left,aligny bottom");
				
						JLabel lblNewLabel_5_1 = new JLabel("Rua *");
						lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
						panel.add(lblNewLabel_5_1, "cell 3 13,alignx left,aligny bottom");
						
								txtInserir_6 = new RoundJTextField();
								txtInserir_6.setText("Inserir");
								txtInserir_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
								txtInserir_6.setColumns(10);
								panel.add(txtInserir_6, "cell 0 14 2 1,growx,aligny top");
				
						txtInserir_5 = new RoundJTextField();
						txtInserir_5.setText("Inserir");
						txtInserir_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
						txtInserir_5.setColumns(10);
						panel.add(txtInserir_5, "cell 3 14 2 1,grow");
				
				JLabel lblNewLabel_7_1 = new JLabel("Complemento *");
				lblNewLabel_7_1.setForeground(Color.BLACK);
				panel.add(lblNewLabel_7_1, "cell 0 16");
				
				JLabel lblNewLabel_5_1_1 = new JLabel("CEP *");
				lblNewLabel_5_1_1.setForeground(Color.BLACK);
				panel.add(lblNewLabel_5_1_1, "cell 3 16");
		
		RoundJTextField txtInserir_6_1 = new RoundJTextField();
		txtInserir_6_1.setText("Inserir");
		txtInserir_6_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_6_1.setColumns(10);
		panel.add(txtInserir_6_1, "cell 0 17 2 1,growx");
		
		RoundJTextField txtInserir_5_1 = new RoundJTextField();
		txtInserir_5_1.setText("Inserir");
		txtInserir_5_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_5_1.setColumns(10);
		panel.add(txtInserir_5_1, "cell 3 17 2 1,growx");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 240, 240));
		panel.add(panel_3, "cell 0 19 5 1,grow");
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

		txtInserir_1 = new RoundJTextField();
		txtInserir_1.setText("Inserir");
		txtInserir_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_1.setColumns(10);
		panel.add(txtInserir_1, "cell 0 8 2 1,growx,aligny bottom");

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

			}
		});
		panel.add(btnCadastrar, "cell 4 20,growx,aligny bottom");
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
		// TODO Auto-generated method stub
		return null;
	}
}
