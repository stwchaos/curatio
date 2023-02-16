package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistorico frame = new TelaHistorico();
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
	public TelaHistorico() {
		setBackground(new Color(0, 81, 81));
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaHistorico.class.getResource("/visao/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 81, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 112, 748, 388);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 81, 81));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(746, 388, -745, -390);
		panel.add(table);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(186, -136, 426, 511);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(TelaHistorico.class.getResource("/visao/iconmedicina.png")));
		
		lblNewLabel = new JLabel("Setor");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(78, 80, 106, 32);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Profissional");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(350, 78, 139, 34);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Data");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(696, 79, 87, 35);
		contentPane.add(lblNewLabel_2);
	}

}
