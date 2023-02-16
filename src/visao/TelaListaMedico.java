package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaListaMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarProfissional;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaMedico frame = new TelaListaMedico();
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
	public TelaListaMedico() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaMedico.class.getResource("/visao/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaListaMedico.class.getResource("/visao/iconPesquisa.png")));
		lblNewLabel.setBounds(354, 25, 39, 33);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 83, 753, 412);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(0, 0, 753, 29);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 28, 753, 384);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtPesquisarProfissional = new JTextField();
		txtPesquisarProfissional.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		txtPesquisarProfissional.setForeground(new Color(128, 128, 128));
		txtPesquisarProfissional.setText("Pesquisar profissional");
		txtPesquisarProfissional.setBounds(50, 22, 344, 39);
		contentPane.add(txtPesquisarProfissional);
		txtPesquisarProfissional.setColumns(10);
	}
}
