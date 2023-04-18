package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Medico;
import modelo.Usuario;

import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class TelaListaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisarPaciente;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSelecionar;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaListaPaciente(Usuario u) {
		setForeground(new Color(0, 85, 85));
		setBackground(new Color(0, 85, 85));
		setTitle("Hospital Esmeralda - Pacientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 845);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][-12.00px][395.00px,grow][grow][47.00px,grow,left]", "[28.00px,fill][19px][49.00][342.00px,grow][31px]"));
		
		txtPesquisarPaciente = new JTextField();
		txtPesquisarPaciente.setForeground(new Color(128, 128, 128));
		txtPesquisarPaciente.setText("Pesquisar paciente");
		txtPesquisarPaciente.setToolTipText("");
		txtPesquisarPaciente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		contentPane.add(txtPesquisarPaciente, "cell 2 0,growx,aligny bottom");
		txtPesquisarPaciente.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 2 2 2 1,grow");
		panel_1.setBackground(new Color(64, 128, 128));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 2 3 2 1,grow");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{471, 0};
		gbl_panel.rowHeights = new int[]{638, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		int linha = table.getSelectedRow();
		Long id = (Long) table.getValueAt(linha, 0);
		}
		});

		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Telefone" });
		DefaultTableModel pesquisa = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Telefone" });
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Telefone" }));
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dispose();
						TelaPadrao telaPadrao = new TelaPadrao(u);
						telaPadrao.setLocationRelativeTo(null);
						telaPadrao.setVisible(true);
						telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		contentPane.add(btnVoltar, "cell 2 4,alignx left,aligny top");
		
		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaFichaPaciente telaFichaPaciente = new TelaFichaPaciente(u);
				telaFichaPaciente.setLocationRelativeTo(null);
				telaFichaPaciente.setVisible(true);
				telaFichaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnSelecionar.setForeground(new Color(255, 255, 255));
		btnSelecionar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSelecionar.setBackground(new Color(64, 128, 128));
		contentPane.add(btnSelecionar, "cell 3 4,alignx right,aligny top");
		
	}
}
