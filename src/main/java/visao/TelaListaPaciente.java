package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.MedicoDAO;
import controle.PacienteDAO;
import modelo.Medico;
import modelo.Paciente;
import modelo.TipoUsuario;
import modelo.Usuario;

import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
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
	private int linha;
	private DefaultTableModel pesquisa;
	private DefaultTableModel modelo;
	private PacienteDAO pDao = new PacienteDAO();
	private Paciente pacienteSelecionado = null;
	private JLabel lblNewLabel;


	public TelaListaPaciente(final Usuario usuarioAtual) {
		setForeground(new Color(0, 85, 85));
		setBackground(new Color(0, 85, 85));
		setTitle("Hospital Esmeralda - Pacientes");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaListaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 845);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[-12.00px][395.00px,grow][grow]",
				"[28.00px,fill][19px][49.00][342.00px,grow][31px]"));

		txtPesquisarPaciente = new JTextField();
		txtPesquisarPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisa.setRowCount(0);
				ArrayList<Paciente> pacientes = pDao.listarPesquisa(txtPesquisarPaciente.getText());

				listarPacientes(pacientes);
			}
		});
		txtPesquisarPaciente.setForeground(new Color(0, 0, 0));
		txtPesquisarPaciente.setToolTipText("");
		txtPesquisarPaciente.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		contentPane.add(txtPesquisarPaciente, "cell 1 0,growx,aligny bottom");
		txtPesquisarPaciente.setColumns(10);

		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 2 2 1,grow");
		panel_1.setBackground(new Color(64, 128, 128));

		lblNewLabel = new JLabel("Pacientes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		panel_1.add(lblNewLabel);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 1 3 2 1,grow");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 471, 0 };
		gbl_panel.rowHeights = new int[] { 638, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				linha = table.getSelectedRow();
				Long id = (Long) table.getValueAt(linha, 1);
				for (Paciente paciente : pDao.listarPacientes()) {
					if (id.equals(paciente.getCpf())) {
						pacienteSelecionado = paciente;
					}
				}
			}
		});

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Telefone" });
		pesquisa = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Telefone" });
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Telefone" }));
		scrollPane.setViewportView(table);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(64, 128, 128));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao(usuarioAtual);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		contentPane.add(btnVoltar, "cell 1 4,alignx left,aligny top");

		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pacienteSelecionado != null) {
					dispose();
					TelaFichaPaciente telaFichaPaciente = new TelaFichaPaciente(usuarioAtual, pacienteSelecionado);
					telaFichaPaciente.setLocationRelativeTo(null);
					telaFichaPaciente.setVisible(true);
					telaFichaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} else {
					new DialogMensagemErro("Paciente não selecionado!").setVisible(true);
				}
				// dispose();
			}
		});
		btnSelecionar.setForeground(new Color(255, 255, 255));
		btnSelecionar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSelecionar.setBackground(new Color(64, 128, 128));
		contentPane.add(btnSelecionar, "cell 2 4,alignx right,aligny top");
		listarPacientes(pDao.listarPacientes());
	}

	private void listarPacientes(ArrayList<Paciente> pacientes) {
		modelo.setRowCount(0);
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getNomeSocial());
			if (paciente.getNomeSocial() == null) {
				modelo.addRow(new Object[] { paciente.getNome(), paciente.getCpf(), paciente.getTelefone() });
			} else {
				modelo.addRow(new Object[] { paciente.getNomeSocial(), paciente.getCpf(), paciente.getTelefone() });
			}
		}
		table.setModel(modelo);
	}

}
