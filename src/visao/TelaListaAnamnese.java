package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.AnamneseDAO;
import controle.MedicoDAO;
import controle.UsuarioDAO;
import modelo.Anamnese;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaListaAnamnese extends JFrame implements InterfaceConfirmacao{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnVoltar;
	private JPanel panel_2;
	private JButton btnAdicionar;
	private JButton btnVisualizar;
	private JButton btnDeletar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private Anamnese anaSelecionda = null;
	private AnamneseDAO aDao = new AnamneseDAO();
	private Boolean visualizar;
	private int linha;
	private DefaultTableModel modelo;
	private DefaultTableModel pesquisa;
	

	//TODO arrumar lista de anamnese - fazer aparecer.
	
	public TelaListaAnamnese(Usuario usuarioAtual) {
		
		setForeground(new Color(0, 85, 85));
		setBackground(new Color(0, 85, 85));
		setTitle("Hospital Esmeralda - histórico anamneses");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaAnamnese.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 845);
		

		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 229, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][-12.00px][395.00px,grow][grow][23.00,center][238.00px,left]", "[][28.00px,fill][19px][49.00][342.00px,grow][31px]"));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 2 3 2 1,grow");
		panel_1.setBackground(new Color(64, 128, 128));
		
		lblNewLabel = new JLabel("Anamneses");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 2 4 2 1,grow");
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
			linha = table.getSelectedRow();
			Long id = (Long) table.getValueAt(linha, 0);
			for (Anamnese anamnese : aDao.listarAnamnese()) {
				if(id.equals(anamnese.getIdAnamnese())) {
					anaSelecionda = anamnese;
				}
			}
		}
		});

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Especialidade", "Paciente", "Objetivo", "Data" });
		pesquisa = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Especialidade", "Paciente", "Objetivo", "Data" });
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Especialidade", "Paciente", "Objetivo", "Data" }));
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dispose();
						TelaPadrao telaPadrao = new TelaPadrao(usuarioAtual);
						telaPadrao.setLocationRelativeTo(null);
						telaPadrao.setVisible(true);
						telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		contentPane.add(btnVoltar, "cell 2 5,alignx left,aligny top");
		
		
		JPanel panel_2 = new RoundJPanel(50, new Color(0, 81, 81));
		panel_2.setBackground(null);
		contentPane.add(panel_2, "cell 5 1 1 5,grow");
		panel_2.setLayout(new MigLayout("", "[grow][89px][grow]", "[184.00,grow][279.00,grow][51.00px][51.00][51.00][grow]"));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaListaAnamnese.class.getResource("/img/EngrenagenzinhaBranquinhaUmPoucoMaior.png")));
		panel_2.add(lblNewLabel_1, "cell 1 0,alignx center,aligny top");
		
		lblNewLabel_2 = new JLabel("Controle de Administrador");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_2, "cell 1 1,growx,aligny top");
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setBackground(new Color(0, 81, 81));
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizar = false;
				anaSelecionda=null;
				dispose();
				TelaAnamnese tela = new TelaAnamnese(usuarioAtual, anaSelecionda, visualizar);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
		});
		panel_2.add(btnAdicionar, "cell 1 2,growx,aligny center");
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(linha==-1) {
					new DialogMensagemErro("Anamnese não selecionado").setVisible(true);
					return;
				}
					visualizar = true;
					dispose();
					TelaAnamnese telaAlterar = new TelaAnamnese(usuarioAtual, anaSelecionda, visualizar);
					telaAlterar.setLocationRelativeTo(null);
					telaAlterar.setVisible(true);
					telaAlterar.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVisualizar.setForeground(new Color(255, 255, 255));
		btnVisualizar.setBackground(new Color(0, 81, 81));
		btnVisualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVisualizar.setFocusPainted(false);
		panel_2.add(btnVisualizar, "cell 1 3,growx,aligny center");
		
		btnDeletar = new JButton("Deletar");
		TelaListaAnamnese tela = this;
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(linha==-1) {
					new DialogMensagemErro("Anamnese não selecionado").setVisible(true);
					return;
				}
				new DialogConfirmacao("A anamnese será deletado.", tela).setVisible(true);
				
			}
		});
		

		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setBackground(new Color(0, 81, 81));
		btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDeletar.setFocusPainted(false);
		panel_2.add(btnDeletar, "cell 1 4,growx,aligny center");

		listarAnamnese();
		}
	
	private void listarAnamnese() {
		modelo.setRowCount(0);
		for (Anamnese anamnese : aDao.listarAnamnese()) {
			if (anamnese.getConsulta().getPaciente().getNomeSocial() == null) {
			modelo.addRow(new Object[] { anamnese.getConsulta().getMedico().getNome(), anamnese.getConsulta().getMedico().getEspecialidade().getEspecialidade(), anamnese.getConsulta().getPaciente().getNome(), anamnese.getConsulta().getObjetivo(), anamnese.getConsulta().getData()});
		}else {
			modelo.addRow(new Object[] { anamnese.getConsulta().getMedico().getNome(), anamnese.getConsulta().getMedico().getEspecialidade().getEspecialidade(), anamnese.getConsulta().getPaciente().getNomeSocial(), anamnese.getConsulta().getObjetivo(), anamnese.getConsulta().getData()});

		}}
		table.setModel(modelo);
	}

	@Override
	public void btnConfirmacao() {
		listarAnamnese();
		
	}

	@Override
	public void bntCancelar() {
		// TODO Auto-generated method stub
		
	}

}
