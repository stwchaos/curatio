package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;

public class TelaMarcarConsultas extends JFrame {

	private JPanel c;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField txtMarcarConsulta;

	public TelaMarcarConsultas() {
		setTitle("Hospital Esmeralda");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaMarcarConsultas.class.getResource("/img/logoHospital.png")));
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
		c.setLayout(new MigLayout("", "[247.00,grow][294.00px,grow][247.00,grow]", "[664px,grow]"));

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
				TelaPadrao telaPadrao = new TelaPadrao();
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new JPanel();
		c.add(panel, "cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[58.00px,grow][10px][59px][10px][108px][10px][138.00px]", "[36px,grow][18.00][24.00px][14px][20px][14px][21px][14px][20px,grow][14px][20px][6px][14px][20px][14.00px,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Paciente *");
		panel.add(lblNewLabel_1, "cell 0 1 2 1,alignx left,aligny bottom");

		JComboBox comboPaciente = new RoundComboBox();
		comboPaciente.setBackground(new Color(210, 210, 210));
		panel.add(comboPaciente, "cell 0 2 5 1,growx");
		

		JDateChooser dtConsulta = new JDateChooser();
		dtConsulta.getCalendarButton().setBackground(new Color(210, 210, 210));
		dtConsulta.setForeground(new Color(0, 81, 81));
		dtConsulta.setBackground(new Color(229, 229, 229));
		dtConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));

		dtConsulta.setDate(new Date());

		dtConsulta.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		panel.add(dtConsulta, "cell 0 6 4 1,growx,aligny bottom");
		dtConsulta.getDate();

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText("Inserir");
		textField_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_6.setColumns(10);
		panel.add(textField_6, "cell 0 8 7 1,grow");

		JComboBox comboPagamento = new RoundComboBox();
		comboPagamento.setBackground(new Color(218, 218, 218));
		panel.add(comboPagamento, "cell 0 10 5 1,growx");
		String[] listaPagamento = {"Débito","Crédito","Pix","Cheque","Em Espécie"};
		comboPagamento.setSelectedItem("Inserir");
		for (String string : listaPagamento) {
			comboPagamento.addItem(string);
			
		}

		textField_1 = new JTextField();
		textField_1.setText("Inserir");
		textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textField_1.setColumns(10);
		panel.add(textField_1, "cell 0 13 5 1,grow");

		JLabel lblNewLabel_2 = new JLabel("Profissional *");
		panel.add(lblNewLabel_2, "cell 0 3 3 1,growx,aligny top");

		JLabel lblNewLabel_3 = new JLabel("Data da consulta *");
		panel.add(lblNewLabel_3, "cell 0 5 3 1,alignx left,aligny top");

		JLabel lblNewLabel_7 = new JLabel("Atualizar e-mail para contato");
		panel.add(lblNewLabel_7, "cell 0 12 3 1,alignx left,aligny bottom");

		JLabel lblNewLabel_5_1 = new JLabel("Forma de Pagamento *");
		panel.add(lblNewLabel_5_1, "cell 0 9 5 1,growx,aligny top");

		JLabel lblNewLabel_5 = new JLabel("Objetivo *");
		panel.add(lblNewLabel_5, "cell 0 7 3 1,growx,aligny top");

		txtMarcarConsulta = new JTextField();
		txtMarcarConsulta.setText("Marcar Consulta");
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(64, 128, 128));
		panel.add(txtMarcarConsulta, "cell 0 0 7 1,grow");

		JComboBox comboProfissional = new RoundComboBox();
		comboProfissional.setForeground(new Color(255, 255, 255));
		comboProfissional.setBackground(new Color(210, 210, 210));
		panel.add(comboProfissional, "cell 0 4 5 1,grow");

		JButton btnMarcar = new JButton("Agendar");
		btnMarcar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMarcar.setForeground(new Color(255, 255, 255));
		btnMarcar.setBackground(new Color(0, 81, 81));
		panel.add(btnMarcar, "cell 6 14,growx,aligny bottom");

	}
}
