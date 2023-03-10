package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controle.ConsultaDAO;
import controle.PacienteDAO;
import controle.ProfissionalDAO;
import modelo.Consultas;
import modelo.Paciente;
import modelo.Profissional;
import net.miginfocom.swing.MigLayout;

public class TelaMarcarConsultas extends JFrame {

	private JPanel c;
	private JTextField textEmail;
	private JTextField txtObjetivo;
	private JTextField txtMarcarConsulta;

	PacienteDAO pacienteDao = new PacienteDAO();
	ProfissionalDAO profissionalDao = new ProfissionalDAO();
	
	public TelaMarcarConsultas(Profissional usuario) {
		setTitle("Hospital Esmeralda");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaMarcarConsultas.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 713);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		// c = new JPanel();

		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[247.00,grow][294.00px,grow][247.00,grow]", "[664px,grow]"));

		JButton btnVoltar = new JButton("Voltar");
		c.add(btnVoltar, "cell 0 0,alignx left,aligny bottom");
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPadrao telaPadrao = new TelaPadrao(usuario);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new JPanel();
		c.add(panel, "cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[58.00px,grow][10px][59px][10px][108px][10px][138.00px]", "[36px,grow][18.00][24.00px][14px][20px][14px][21px][14px][20px,grow][14px][20px][6px][14px][20px][][80.00,fill][14.00px,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Paciente *");
		panel.add(lblNewLabel_1, "cell 0 1 2 1,alignx left,aligny bottom");

		JComboBox comboPaciente = new RoundComboBox();
		comboPaciente.setBackground(new Color(210, 210, 210));
		panel.add(comboPaciente, "cell 0 2 5 1,growx");
		for (Paciente p : pacienteDao.listarPacientes()) {
			comboPaciente.addItem(p.getNome()+", cpf: "+p.getCpf());
		}
		

		JDateChooser dtConsulta = new JDateChooser();
		dtConsulta.getCalendarButton().setBackground(new Color(210, 210, 210));
		dtConsulta.setForeground(new Color(0, 81, 81));
		dtConsulta.setBackground(new Color(229, 229, 229));
		dtConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));

		dtConsulta.setDate(new Date());

		dtConsulta.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});
		panel.add(dtConsulta, "cell 0 6 4 1,growx,aligny bottom");
		dtConsulta.getDate();

		txtObjetivo = new RoundJTextField();
		txtObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		txtObjetivo.setText("Inserir");
		txtObjetivo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtObjetivo.setColumns(10);
		panel.add(txtObjetivo, "cell 0 8 7 1,grow");

		JComboBox comboPagamento = new RoundComboBox();
		comboPagamento.setBackground(new Color(218, 218, 218));
		panel.add(comboPagamento, "cell 0 10 5 1,growx");
		String[] listaPagamento = {"D???bito","Cr???dito","Pix","Cheque","Em Esp???cie"};
		comboPagamento.setSelectedItem("Inserir");
		for (String string : listaPagamento) {
			comboPagamento.addItem(string);
			
		}

		textEmail = new RoundJTextField();
		textEmail.setText("Inserir");
		textEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textEmail.setColumns(10);
		panel.add(textEmail, "cell 0 13 5 1,grow");

		JLabel lblNewLabel_2 = new JLabel("Profissional *");
		panel.add(lblNewLabel_2, "cell 0 3 3 1,growx,aligny top");

		JLabel lblNewLabel_3 = new JLabel("Data da consulta *");
		panel.add(lblNewLabel_3, "cell 0 5 3 1,alignx left,aligny top");

		JLabel lblNewLabel_7 = new JLabel("Atualizar e-mail para contato");
		panel.add(lblNewLabel_7, "cell 0 12 3 1,alignx left,aligny bottom");

		JLabel lblNewLabel_5_1 = new JLabel("Forma de Pagamento *");
		panel.add(lblNewLabel_5_1, "cell 0 9 5 1,growx,aligny top");

		JLabel lblNewLabel_5 = new JLabel("Objetivo *");
		panel.add(lblNewLabel_5, "cell 0 7 3 1,growx,aligny top");

		txtMarcarConsulta = new RoundJTextField();
		txtMarcarConsulta.setText("Marcar Consulta");
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(64, 128, 128));
		panel.add(txtMarcarConsulta, "cell 0 0 7 1,grow");

		JComboBox comboProfissional = new RoundComboBox();
		comboProfissional.setForeground(new Color(255, 255, 255));
		comboProfissional.setBackground(new Color(210, 210, 210));
		panel.add(comboProfissional, "cell 0 4 5 1,grow");
		for (Profissional p : profissionalDao.listarProfissionais()) {
			comboProfissional.addItem(p.getNomeProfissionais()+", cpf: "+p.getCpfProfissionais());
		}

		JButton btnMarcar = new JButton("Agendar");
		btnMarcar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String objetivo = txtObjetivo.getText();
				Date data = dtConsulta.getDate();
				String pagamento = String.valueOf(comboPagamento.getSelectedItem());
				Consultas consultas = new Consultas();
				ConsultaDAO consultaDAO = new ConsultaDAO();
				
				for (Paciente p : pacienteDao.listarPacientes()) {
					if (comboPaciente.getSelectedItem().equals(p.getNome()+", cpf: "+p.getCpf())) {
						consultas.setPaciente(p);
					}
				}
				for (Profissional p : profissionalDao.listarProfissionais()) {
					if (comboProfissional.getSelectedItem().equals(p.getNomeProfissionais()+", cpf: "+p.getCpfProfissionais())) {
						consultas.setProfissional(p);
					}
				}
				
				consultas.setPagamento(pagamento);
				consultas.setObjetivo(objetivo);
				consultas.setData(convertToLocalDateViaInstant(data));
				if(consultaDAO.inserir(consultas)) {
					JOptionPane.showMessageDialog(null, "Cadastrado");
				}else {
					JOptionPane.showMessageDialog(null, "N??o cadastrado");
				}
			}
		});
		
		JLabel lblNewLabel_7_1 = new JLabel("Observa????es");
		panel.add(lblNewLabel_7_1, "cell 0 14");
		
		RoundJTextField textObservar = new RoundJTextField();
		textObservar.setText("Inserir");
		textObservar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textObservar.setColumns(10);
		panel.add(textObservar, "cell 0 15 7 1,growx");
		btnMarcar.setForeground(new Color(255, 255, 255));
		btnMarcar.setBackground(new Color(0, 81, 81));
		panel.add(btnMarcar, "cell 6 16,growx,aligny bottom");

	}
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
}
