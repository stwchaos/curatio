package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultasPendentes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultasPendentes frame = new TelaConsultasPendentes();
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
	public TelaConsultasPendentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 81, 81));
		panel.setBounds(0, 0, 847, 48);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 81, 81));
		panel_1.setBounds(0, 482, 847, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao();
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(10, 7, 112, 37);
		panel_1.add(btnVoltar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 128, 128));
		panel_2.setBounds(0, 48, 847, 25);
		contentPane.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(64, 128, 128));
		panel_2_1.setBounds(0, 457, 847, 25);
		contentPane.add(panel_2_1);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBounds(10, 136, 827, 294);
		contentPane.add(panel_3_4);
		panel_3_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 827, 294);
		panel_3_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente");
		lblNewLabel_1.setBackground(new Color(219, 219, 219));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(48, 111, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Setor");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(new Color(219, 219, 219));
		lblNewLabel_1_1.setBounds(191, 111, 70, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Profissioal");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_1_2.setBackground(new Color(219, 219, 219));
		lblNewLabel_1_2.setBounds(347, 111, 70, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_1_3.setBackground(new Color(219, 219, 219));
		lblNewLabel_1_3.setBounds(523, 111, 70, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Objetivo");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNewLabel_1_4.setBackground(new Color(219, 219, 219));
		lblNewLabel_1_4.setBounds(681, 111, 70, 14);
		contentPane.add(lblNewLabel_1_4);
	}
}
