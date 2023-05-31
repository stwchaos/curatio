package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controle.AnamneseDAO;
import controle.ConsultaDAO;
import modelo.Consulta;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaConsultaPendente extends JFrame implements InterfaceConfirmacao {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private ConsultaDAO cDao = new ConsultaDAO();
	private Consulta consultaSelecionada = null;
	private int linha;
	private AnamneseDAO aDao = new AnamneseDAO();
	private Consulta consulta;
	private static final long serialVersionUID = 1L;

	public TelaConsultaPendente(final Usuario usuarioAtual) {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaConsultaPendente.class.getResource("/img/logoHospital.png")));
		setTitle("Hospital Esmeralda - Consultas Pendentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("",
				"[118px,grow][73px,grow][70px][86px,grow][70px][106px,grow][88px,grow][166px,grow][230.00,grow]",
				"[39.00][294px,grow][25px][60px]"));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1_1, "cell 0 0 8 1,grow");

		JLabel lblNewLabel_1 = new JLabel("Consultas Pendentes");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		panel_1_1.add(lblNewLabel_1);

		if (usuarioAtual.getTipo() == TipoUsuario.MEDICO || usuarioAtual.getTipo() == TipoUsuario.SECRETARIA) {
			JPanel panel = new RoundJPanel(50, new Color(0, 81, 81));
			panel.setBackground(null);
			contentPane.add(panel, "cell 8 0 1 4,grow");
			panel.setLayout(new MigLayout("", "[grow]", "[][grow][][][][][][][grow]"));

			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(
					TelaConsultaPendente.class.getResource("/img/EngrenagenzinhaBranquinhaUmPoucoMaior.png")));
			panel.add(lblNewLabel_2, "cell 0 0,alignx center,aligny center");

			JLabel lblNewLabel = new JLabel("Controle de Consultas Pendentes");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
			panel.add(lblNewLabel, "cell 0 1,alignx center,aligny top");

			final JButton btnDesmarcar = new JButton("Desmarcar");
			btnDesmarcar.setForeground(new Color(255, 255, 255));
			btnDesmarcar.setBackground(new Color(0, 81, 81));
			btnDesmarcar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnDesmarcar.setFocusPainted(false);
			TelaConsultaPendente tela = this;
			btnDesmarcar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO confirmaçao
					new DialogConfirmacao("Cancelar consulta?", tela).setVisible(true);

				}
			});
			panel.add(btnDesmarcar, "cell 0 3,growx,aligny center");

			JButton btnRemarcar = new JButton("Remarcar");
			btnRemarcar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (consultaSelecionada == null) {
						new DialogMensagemErro("Nenhuma consulta selecionada!").setVisible(true);
						return;
					}
					ConsultaDAO cDAO = new ConsultaDAO();
					dispose();
					TelaRemarcarConsulta tela = new TelaRemarcarConsulta(usuarioAtual, consultaSelecionada);
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			});
			btnRemarcar.setForeground(new Color(255, 255, 255));
			btnRemarcar.setBackground(new Color(0, 81, 81));
			btnRemarcar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnRemarcar.setFocusPainted(false);
			panel.add(btnRemarcar, "cell 0 5,growx,aligny center");

		}

		JPanel panel_1 = new RoundJPanel(10, new Color(0, 81, 81));
		panel_1.setBackground(null);
		contentPane.add(panel_1, "cell 0 3 8 1,grow");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao(usuarioAtual);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		panel_1.setLayout(new MigLayout("", "[112px][grow][138px]", "[37px]"));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(btnVoltar, "cell 0 0,grow");

		if (usuarioAtual.getTipo() == TipoUsuario.MEDICO) {
			JButton btnAnamnese = new JButton("Anamnese");
			btnAnamnese.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (consultaSelecionada == null) {
						new DialogMensagemErro("Nenhuma consulta selecionada!").setVisible(true);
						return;
					}
					dispose();

					TelaAnamnese telaAna = new TelaAnamnese(usuarioAtual,
							aDao.buscarAnamnesePorIdConsulta(consultaSelecionada.getIdConsulta()),
							rootPaneCheckingEnabled);
					telaAna.setLocationRelativeTo(null);
					telaAna.setVisible(true);
					telaAna.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			});
			btnAnamnese.setIcon(
					new ImageIcon(TelaConsultaPendente.class.getResource("/img/Trequinhoaindamaiscleareado.png")));
			btnAnamnese.setOpaque(false);
			btnAnamnese.setHorizontalAlignment(SwingConstants.LEFT);
			btnAnamnese.setForeground(Color.WHITE);
			btnAnamnese.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
			btnAnamnese.setFocusPainted(false);
			btnAnamnese.setBorder(null);
			btnAnamnese.setBackground((Color) null);
			btnAnamnese.setCursor(new Cursor(Cursor.HAND_CURSOR));
			panel_1.add(btnAnamnese, "cell 2 0,growx,aligny top");
		}

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
				linha = table.getSelectedRow();
				Integer id = (Integer) table.getValueAt(linha, 0);
				for (Consulta consulta : cDao.listarConsultas()) {
					if (id.equals(consulta.getIdConsulta())) {
						consultaSelecionada = consulta;
						// consultaSelecionada=null;
					}
				}
			}
		});

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Paciente", "Setor", "Médico", "Data", "Objetivo" });

		scrollPane.setViewportView(table);
		listarConsultas();
	}

	private void listarConsultas() {
		modelo.setRowCount(0);
		ArrayList<Integer> faltas = new ArrayList<>();
		
		for (Consulta con : cDao.listarConsultas()) {
			if (con.getEncerrada() == false) {
				Object[] rowData;

				// TODO
				if (con.getPaciente().getNomeSocial() == null) {
					rowData = new Object[] { con.getIdConsulta(), con.getPaciente().getNome(),
							con.getMedico().getEspecialidade().getEspecialidade(), con.getMedico().getNome(),
							con.getData(), con.getObjetivo() };
				} else {
					rowData = new Object[] { con.getIdConsulta(), con.getPaciente().getNomeSocial(),
							con.getMedico().getEspecialidade().getEspecialidade(), con.getMedico().getNome(),
							con.getData(), con.getObjetivo() };
				}
				modelo.addRow(rowData); 
				if (con.getFalta()) {
					faltas.add(modelo.getRowCount()-1);
				}

			}
		}
		table.setModel(modelo);
		for (Integer index : faltas) {
			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getCellRenderer(index, i).getTableCellRendererComponent(table, null, false, false, index, i).setBackground(Color.RED);
				table.getCellRenderer(index, i).getTableCellRendererComponent(table, faltas, rootPaneCheckingEnabled, rootPaneCheckingEnabled, index, i).setBackground(Color.RED);
				System.out.println(index+" "+i);
			}
		}
	}



	@Override
	public void btnConfirmacao() {
		if (consultaSelecionada == null) {
			new DialogMensagemErro("Nenhuma consulta selecionada!").setVisible(true);
			return;
		}
		aDao.deletar(consultaSelecionada);
		if (cDao.deletar(consultaSelecionada) == true) {
			new DialogMensagemSucesso("Consulta deletada com sucesso!").setVisible(true);
		} else {
			new DialogMensagemErro("Ocorreu um erro ao deletar.").setVisible(true);
		}
		listarConsultas();
		consultaSelecionada = null;
	}

	@Override
	public void bntCancelar() {

	}
}
