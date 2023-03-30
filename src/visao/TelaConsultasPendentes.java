package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class TelaConsultasPendentes extends JFrame {

	private JPanel contentPane;
	private JTable table;


	public TelaConsultasPendentes(Usuario u) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultasPendentes.class.getResource("/img/logoHospital.png")));
		setTitle("Hospital Esmeralda - Consultas Pendentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[118px,grow][73px,grow][70px][86px,grow][70px][106px,grow][88px,grow][166px,grow]", "[48px][25px][14px][294px,grow][25px][60px]"));
		
		RoundJTextField txtMarcarConsulta = new RoundJTextField();
		txtMarcarConsulta.setText("Paciente");
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(0, 81, 81));
		contentPane.add(txtMarcarConsulta, "cell 0 0 1 2,grow");
		
		RoundJTextField rndjtxtfldSetor = new RoundJTextField();
		rndjtxtfldSetor.setText("Setor");
		rndjtxtfldSetor.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldSetor.setForeground(Color.WHITE);
		rndjtxtfldSetor.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldSetor.setEditable(false);
		rndjtxtfldSetor.setColumns(10);
		rndjtxtfldSetor.setBackground(new Color(0, 81, 81));
		contentPane.add(rndjtxtfldSetor, "cell 1 0 2 2,grow");
		
		RoundJTextField rndjtxtfldProfissional = new RoundJTextField();
		rndjtxtfldProfissional.setText("Profissional");
		rndjtxtfldProfissional.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldProfissional.setForeground(Color.WHITE);
		rndjtxtfldProfissional.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldProfissional.setEditable(false);
		rndjtxtfldProfissional.setColumns(10);
		rndjtxtfldProfissional.setBackground(new Color(0, 81, 81));
		contentPane.add(rndjtxtfldProfissional, "cell 3 0 2 2,grow");
		
		RoundJTextField rndjtxtfldData = new RoundJTextField();
		rndjtxtfldData.setText("Data");
		rndjtxtfldData.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldData.setForeground(Color.WHITE);
		rndjtxtfldData.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldData.setEditable(false);
		rndjtxtfldData.setColumns(10);
		rndjtxtfldData.setBackground(new Color(0, 81, 81));
		contentPane.add(rndjtxtfldData, "cell 5 0 1 2,grow");
		
		RoundJTextField rndjtxtfldObjetivo = new RoundJTextField();
		rndjtxtfldObjetivo.setText("Objetivo");
		rndjtxtfldObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldObjetivo.setForeground(Color.WHITE);
		rndjtxtfldObjetivo.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldObjetivo.setEditable(false);
		rndjtxtfldObjetivo.setColumns(10);
		rndjtxtfldObjetivo.setBackground(new Color(0, 81, 81));
		contentPane.add(rndjtxtfldObjetivo, "cell 6 0 2 2,grow");
		
		JPanel panel_1 = new RoundJPanel(10, new Color(0, 81, 81));
		panel_1.setBackground(null);
		contentPane.add(panel_1, "cell 0 5 8 1,grow");
		panel_1.setLayout(null);
		
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
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBounds(10, 11, 112, 37);
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		panel_1.add(btnVoltar);
		
		JPanel panel_2_1 = new RoundJPanel(10, new Color(64, 128, 128));
		panel_2_1.setBackground(null);
		contentPane.add(panel_2_1, "cell 0 4 8 1,grow");
		
		JPanel panel_3_4 = new JPanel();
		contentPane.add(panel_3_4, "cell 0 3 8 1,grow");
		panel_3_4.setLayout(new MigLayout("", "[665.00px,grow]", "[402px,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3_4.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
