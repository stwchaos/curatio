package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.PacienteDAO;
import modelo.Paciente;

import java.awt.Toolkit;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	private ArrayList<Paciente> listaPaciente;
	private PacienteDAO pDao = new PacienteDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
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
	public TelaConsulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsulta.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hospital Esmeralda - Informações da consulta");
		setBounds(100, 100, 1030, 713);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 81, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[36px]"));
		
		RoundJTextField txtMarcarConsulta = new RoundJTextField();
		listaPaciente = pDao.listarPacientes();
		for (Paciente p : listaPaciente) {
			if (p.getNomeSocial()==null) {
				txtMarcarConsulta.setText("Consulta de "+(p.getNome()));
			} else {
				txtMarcarConsulta.setText("Consulta de "+(p.getNomeSocial()));
			}
		}	
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(64, 128, 128));
		panel.add(txtMarcarConsulta, "cell 0 0,grow");
	}

}
