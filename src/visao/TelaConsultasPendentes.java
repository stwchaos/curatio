package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ConsultaDAO;
import modelo.Consulta;
import modelo.Medico;
import modelo.Usuario;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaConsultasPendentes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private ConsultaDAO cDao = new ConsultaDAO();


	public TelaConsultasPendentes(Usuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultasPendentes.class.getResource("/img/logoHospital.png")));
		setTitle("Hospital Esmeralda - Consultas Pendentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[118px,grow][73px,grow][70px][86px,grow][70px][106px,grow][88px,grow][166px,grow]", "[39.00][294px,grow][25px][60px]"));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1_1, "cell 0 0 8 1,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Consultas Pendentes");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		panel_1_1.add(lblNewLabel_1);
		
		JPanel panel_1 = new RoundJPanel(10, new Color(0, 81, 81));
		panel_1.setBackground(null);
		contentPane.add(panel_1, "cell 0 3 8 1,grow");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao(u);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		panel_1.setLayout(new MigLayout("", "[112px][grow][138px]", "[37px]"));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		panel_1.add(btnVoltar, "cell 0 0,grow");
		
		/*JButton btnAnamnese = new JButton("Anamnese");
		btnAnamnese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaAnamnese telaListaAna = new TelaListaAnamnese(u);
				telaListaAna.setLocationRelativeTo(null);
				telaListaAna.setVisible(true);
				telaListaAna.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnAnamnese.setIcon(new ImageIcon(TelaConsultasPendentes.class.getResource("/img/Trequinhoaindamaiscleareado.png")));
		btnAnamnese.setOpaque(false);
		btnAnamnese.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnamnese.setForeground(Color.WHITE);
		btnAnamnese.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		btnAnamnese.setFocusPainted(false);
		btnAnamnese.setBorder(null);
		btnAnamnese.setBackground((Color) null);
		btnAnamnese.setCursor(new Cursor (Cursor.HAND_CURSOR));
		panel_1.add(btnAnamnese, "cell 2 0,growx,aligny top");*/
		
		JPanel panel_2_1 = new RoundJPanel(10, new Color(64, 128, 128));
		panel_2_1.setBackground(null);
		contentPane.add(panel_2_1, "cell 0 2 8 1,grow");
		
		JPanel panel_3_4 = new JPanel();
		contentPane.add(panel_3_4, "cell 0 1 8 1,grow");
		panel_3_4.setLayout(new MigLayout("", "[665.00px,grow]", "[402px,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3_4.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		//int linha = table.getSelectedRow();
		//Long id = (Long) table.getValueAt(linha, 0);
		}
		});

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(new Object[][] {}, new String[] {  "Paciente", "Setor", "Médico", "Data", "Objetivo"  });
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Paciente", "Setor", "Médico", "Data", "Objetivo" });
		scrollPane.setViewportView(table);
		listarConsultas();
	}
	
	private void listarConsultas() {
	    modelo.setRowCount(0);
	    for (Consulta consulta : cDao.listarConsultas()) {
	        if (consulta.getEncerrada()==false && consulta.getFalta()==false) {
	            Object[] rowData;
	            if (consulta.getPaciente().getNomeSocial() == null) {
	                rowData = new Object[]{consulta.getPaciente().getNome(), consulta.getMedico().getEspecialidade().getEspecialidade(), consulta.getMedico().getNome(), consulta.getData(), consulta.getObjetivo()};
	            } else {
	                rowData = new Object[]{consulta.getPaciente().getNomeSocial(), consulta.getMedico().getEspecialidade().getEspecialidade(), consulta.getMedico().getNome(), consulta.getData(), consulta.getObjetivo()};
	            }
	            modelo.addRow(rowData);
	        }
	    }
	    table.setModel(modelo);
	}
}
