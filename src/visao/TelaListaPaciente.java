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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaListaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarPaciente;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaPaciente frame = new TelaListaPaciente();
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
		txtPesquisarPaciente.setBounds(51, 22, 331, 41);
		contentPane.add(txtPesquisarPaciente);
		txtPesquisarPaciente.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(51, 82, 744, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(0, 0, 744, 33);
		panel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 744, 385);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}
