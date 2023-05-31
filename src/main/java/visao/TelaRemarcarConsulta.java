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
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import controle.AnamneseDAO;
import controle.ConsultaDAO;
import controle.MedicoDAO;
import controle.PacienteDAO;
import controle.PagamentoDAO;
import modelo.Anamnese;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import modelo.Pagamento;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaRemarcarConsulta extends JFrame {

	private JPanel c;
	private JTextField txtObjetivo;
	private JTextField label;
	private ArrayList<Paciente> listaPaciente;
	private ArrayList<Medico> listaMedicos;
	private PacienteDAO pDao = new PacienteDAO();
	private MedicoDAO mDao = new MedicoDAO();
	private JTextField txtHora;
	private JTextField txtPaciente;
	private JTextField txtPagamento;
	private JDateChooser dtConsulta;
	private JComboBox comboMedico;

	public TelaRemarcarConsulta(final Usuario usuarioAtual, final Consulta consultaSelecionada) {
		setTitle("Hospital Esmeralda - Remarcar Consulta");
		if (usuarioAtual.getTipo() == TipoUsuario.MEDICO || usuarioAtual.getTipo() == TipoUsuario.SECRETARIA) {
			setTitle("Hospital Esmeralda - Remarcar Consulta");
		} else {
			setTitle("Hospital Esmeralda - Marcar Consultas");
		}
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaRemarcarConsulta.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 713);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/main/resources/img/Background2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

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
				TelaConsultaPendente tela = new TelaConsultaPendente(usuarioAtual);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new JPanel();
		c.add(panel, "cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[58.00px,grow][10px][59px][10px][108px,grow][10px][138.00px]",
				"[36px,grow][18.00][24.00px][14px][20px][14px][21px][14px][20px,grow][14px][20px][6px][14px][20px][][80.00,fill][14.00px,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Paciente *");
		panel.add(lblNewLabel_1, "cell 0 1 2 1,alignx left,aligny bottom");

		dtConsulta = new JDateChooser();
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

		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		panel.add(txtPaciente, "cell 0 2 5 1,growx");
		txtPaciente.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Horário da consulta *");
		panel.add(lblNewLabel_3_1, "cell 4 5");
		panel.add(dtConsulta, "cell 0 6 4 1,growx,aligny bottom");
		dtConsulta.getDate();

		txtHora = new JFormattedTextField();
		panel.add(txtHora, "cell 4 6,alignx left");
		txtHora.setColumns(10);
		try {
			MaskFormatter mascaraHora = new MaskFormatter("##:##");
			mascaraHora.setPlaceholderCharacter('_');
			mascaraHora.install((JFormattedTextField) txtHora);
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtObjetivo = new RoundJTextField();
		txtObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		txtObjetivo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtObjetivo.setColumns(10);
		panel.add(txtObjetivo, "cell 0 8 7 1,grow");
		String[] listaPagamento = { "Debito", "Credito", "Pix", "Cheque", "Em Especie" };

		JLabel lblNewLabel_2 = new JLabel("Profissional *");
		panel.add(lblNewLabel_2, "cell 0 3 3 1,growx,aligny top");

		JLabel lblNewLabel_3 = new JLabel("Data da consulta *");
		panel.add(lblNewLabel_3, "cell 0 5 3 1,alignx left,aligny top");

		JLabel lblNewLabel_5_1 = new JLabel("Forma de Pagamento *");
		panel.add(lblNewLabel_5_1, "cell 0 9 5 1,growx,aligny top");

		JLabel lblNewLabel_5 = new JLabel("Objetivo *");
		panel.add(lblNewLabel_5, "cell 0 7 3 1,growx,aligny top");

		label = new RoundJTextField();
		label.setText("Remarcar Consulta");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		label.setEditable(false);
		label.setColumns(10);
		label.setBackground(new Color(64, 128, 128));
		panel.add(label, "cell 0 0 7 1,grow");

		comboMedico = new RoundComboBox();
		comboMedico.setForeground(new Color(0, 0, 0));
		comboMedico.setBackground(new Color(210, 210, 210));
		panel.add(comboMedico, "cell 0 4 5 1,grow");
		listaMedicos = mDao.listarProfissionais();
		for (Medico m : listaMedicos) {
			comboMedico.addItem(m.getNome() + " - " + m.getCrm());
		}

		JButton btnMarcar = new JButton("Remarcar");
		btnMarcar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String objetivo = txtObjetivo.getText();
				String hora = txtHora.getText();

				if (objetivo.trim().isEmpty()) {
					new DialogMensagemErro("Objetivo Vazio").setVisible(true);
					return;
				}

				try {
					Integer.valueOf(firstNChars(hora, 2));
					Integer.valueOf(getLastN(hora, 2));
				} catch (Exception e2) {
					new DialogMensagemErro("Horário Invalido").setVisible(true);
					return;
				}
				if (Integer.valueOf(firstNChars(hora, 2)) > 23) {
					new DialogMensagemErro("Horário Invalido").setVisible(true);
					return;
				}
				if (Integer.valueOf(getLastN(hora, 2)) > 59) {
					new DialogMensagemErro("Horário Invalido").setVisible(true);
					return;
				}

				Consulta c = consultaSelecionada;
				ConsultaDAO cDao = new ConsultaDAO();

				c.setData(convertToLocalDateViaInstant(dtConsulta.getDate()));
				c.setEncerrada(false);
				c.setMedico(listaMedicos.get(comboMedico.getSelectedIndex()));
				c.setObjetivo(objetivo);
				c.setFalta(false);
				c.setHorario(LocalTime.parse(txtHora.getText()));

				if (cDao.alterar(c) == true) {
					new DialogMensagemSucesso("Consulta alterada!").setVisible(true);
				} else {
					new DialogMensagemErro("Tente novamente").setVisible(true);
				}
				TelaPadrao telaPadrao = new TelaPadrao(usuarioAtual);
				telaPadrao.setLocationRelativeTo(null);
				telaPadrao.setVisible(true);
				telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});

		txtPagamento = new JTextField();
		txtPagamento.setEditable(false);
		panel.add(txtPagamento, "cell 0 10 5 1,growx");
		txtPagamento.setColumns(10);
		btnMarcar.setForeground(new Color(255, 255, 255));
		btnMarcar.setBackground(new Color(0, 81, 81));
		panel.add(btnMarcar, "cell 6 16,growx,aligny bottom");
		receberDados(consultaSelecionada);
	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static String firstNChars(String str, int n) {
		if (str == null) {
			return null;
		}

		return str.length() < n ? str : str.substring(0, n);
	}

	public static String getLastN(String s, int n) {
		if (s == null) {
			return null;
		}
		return s.substring(Math.max(0, s.length() - n));
	}

	private void receberDados(Consulta c) {
		if (c.getPaciente().getNomeSocial() == null) {
			txtPaciente.setText(c.getPaciente().getNome());
		} else {
			txtPaciente.setText(c.getPaciente().getNomeSocial());
		}
		txtHora.setText(c.getHorario().toString());
		txtObjetivo.setText(c.getObjetivo());
		txtPagamento.setText(c.getPagamento().getFormaPagamento());
		dtConsulta.setDate(Date.from(c.getData().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		ArrayList<Medico> listaMed = mDao.listarProfissionais();
		for (int i = 0; i < listaMed.size(); i++) {
			if (c.getMedico().getCrm() == listaMed.get(i).getCrm()) {
				comboMedico.setSelectedIndex(i);
			}
		}
	}
}
