package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Profissional;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;


	public TelaHistorico(Profissional usuario) {
		setBackground(new Color(0, 81, 81));
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaHistorico.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[174px,grow][166px,grow][139px,grow][207px,grow][100px,grow]", "[34px][388px,grow][][54.00px]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1, "cell 0 0 5 1,grow");
		
		lblNewLabel_1 = new JLabel("Profissional");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(0, 81, 81));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		lblNewLabel = new JLabel("Setor");
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 81, 81));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_2 = new JLabel("Data");
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1 5 1,grow");
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(746, 388, -745, -390);
		panel.add(table);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(186, -136, 426, 511);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(TelaHistorico.class.getResource("/img/iconmedicina.png")));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaFichaPaciente telaficha = new TelaFichaPaciente(usuario);
				telaficha.setLocationRelativeTo(null);
				telaficha.setVisible(true);
				telaficha.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 81, 81));
		contentPane.add(btnVoltar, "cell 0 3,alignx left,growy");
	}
}
