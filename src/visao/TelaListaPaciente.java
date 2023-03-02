package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarPaciente;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSelecionar;
	private JLabel lblNewLabel_1;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaListaPaciente() {
		setForeground(new Color(0, 85, 85));
		setBackground(new Color(0, 85, 85));
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/iconPesquisa.png")));
		lblNewLabel.setBounds(343, 24, 47, 39);
		contentPane.add(lblNewLabel);
		
		txtPesquisarPaciente = new JTextField();
		txtPesquisarPaciente.setForeground(new Color(128, 128, 128));
		txtPesquisarPaciente.setText("Pesquisar paciente");
		txtPesquisarPaciente.setToolTipText("");
		txtPesquisarPaciente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtPesquisarPaciente.setBounds(51, 22, 331, 39);
		contentPane.add(txtPesquisarPaciente);
		txtPesquisarPaciente.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(51, 82, 489, 388);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(0, 0, 489, 33);
		panel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 489, 354);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaFichaPaciente telaFichaPaciente = new TelaFichaPaciente();
				telaFichaPaciente.setLocationRelativeTo(null);
				telaFichaPaciente.setVisible(true);
				telaFichaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnSelecionar.setForeground(new Color(255, 255, 255));
		btnSelecionar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSelecionar.setBackground(new Color(64, 128, 128));
		btnSelecionar.setBounds(572, 491, 213, 31);
		contentPane.add(btnSelecionar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaListaPaciente.class.getResource("/img/iconmedicina.png")));
		lblNewLabel_1.setBounds(503, -66, 282, 525);
		contentPane.add(lblNewLabel_1);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dispose();
						TelaPadrao telaPadrao = new TelaPadrao();
						telaPadrao.setLocationRelativeTo(null);
						telaPadrao.setVisible(true);
						telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVoltar.setBounds(20, 499, 89, 23);
		contentPane.add(btnVoltar);
		
	}
}
