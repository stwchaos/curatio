package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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

import controle.AnamneseDAO;
import controle.ConsultaDAO;
import modelo.Anamnese;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaAnamnese extends JFrame {

	private JPanel contentPane;
	private JTextField txtIentificao;
	private JTextField txtAnamneseOriental;
	private JTextField textNomeR;
	private JTextField textNomeS;
	private JComboBox comboPronome;
	private JLabel lblNewLabel_2;
	private JTextField textSexo;
	private JLabel lblNewLabel_4;
	private JDateChooser dtNascimento;
	private JLabel lblNewLabel_3;
	private JTextField textQueixa;
	private JButton btnVoltar;
	private JTextField textHDoenca;
	private JLabel lblNewLabel_6;
	private RoundJTextField textHPato;
	private RoundJTextField textHPatoF;
	private RoundJTextField textHSocial;
	private RoundJTextField textTAnterior;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private RoundJTextField textTAtual;
	private RoundJTextField textAlergia;
	private RoundJTextField textMedicacao;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private RoundJTextField textExames;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private RoundJTextField textDispo;
	private JPanel panel_2;
	private RoundJTextField rndjtxtfldObservaes;
	private JTextField txtObs;
	private JButton btnSalvar;
	int camposPreenchidos = 0;

	public TelaAnamnese(final Usuario usuarioAtual, final Anamnese anaSelecionada, Boolean visualizar) {

		setTitle("Hospital Esmeralda - Anamnese");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAnamnese.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 831);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 81, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("",
				"[80.00][grow][-19.00][grow][][][][][][][][][][][][103.00][20.00,grow][][][][][][][][][][][][][][grow][80]",
				"[grow][][grow][][][][][][][][grow][]"));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel, "cell 2 0 13 2,growx,aligny top");
		panel.setLayout(new MigLayout("", "[108.00,grow][][108,grow]", "[32.00][][][][][][][][][][]"));

		txtIentificao = new RoundJTextField();
		txtIentificao.setHorizontalAlignment(SwingConstants.CENTER);
		txtIentificao.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtIentificao.setText("Identificação");
		txtIentificao.setEditable(false);
		txtIentificao.setBackground(new Color(64, 128, 128));
		txtIentificao.setForeground(new Color(255, 255, 255));
		panel.add(txtIentificao, "cell 0 0 3 1,grow");
		txtIentificao.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome de Registro");
		panel.add(lblNewLabel, "cell 0 2");

		textNomeR = new RoundJTextField();
		textNomeR.setBackground(new Color(163, 163, 163));
		textNomeR.setEditable(false);
		textNomeR.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textNomeR, "cell 0 3,growx");
		textNomeR.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome Social");
		panel.add(lblNewLabel_1, "cell 0 4");

		JLabel lblPronome = new JLabel("Pronome");
		panel.add(lblPronome, "cell 2 4");

		textNomeS = new RoundJTextField();
		textNomeS.setBackground(new Color(163, 163, 163));
		textNomeS.setEditable(false);
		textNomeS.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));

		panel.add(textNomeS, "cell 0 5,growx");
		textNomeS.setColumns(10);

		comboPronome = new RoundComboBox();
		comboPronome.setEditable(true);
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(255, 255, 255));
		comboPronome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		String[] listaPronome = { "Ele/Dele", "Ela/Dela", "Qualquer pronome" };
		for (String string : listaPronome) {
			comboPronome.addItem(string);
		}
		panel.add(comboPronome, "cell 2 5,growx");

		lblNewLabel_2 = new JLabel("Sexo");
		panel.add(lblNewLabel_2, "cell 0 6");

		textSexo = new RoundJTextField();
		textSexo.setBackground(new Color(163, 163, 163));
		textSexo.setEditable(false);
		textSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textSexo, "cell 0 7,growx");
		textSexo.setColumns(10);

		lblNewLabel_4 = new JLabel("Data de Nascimento");
		panel.add(lblNewLabel_4, "cell 0 8");

		dtNascimento = new JDateChooser();
		dtNascimento.setDateFormatString("dd/MM/yyyy");
		dtNascimento.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dtNascimento.getCalendarButton().setBackground(new Color(210, 210, 210));
		dtNascimento.setForeground(new Color(0, 81, 81));
		dtNascimento.setBackground(new Color(229, 229, 229));
		panel.add(dtNascimento, "cell 0 9,growx,aligny center");

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 16 0 14 11,grow");
		panel_1.setLayout(new MigLayout("", "[grow]",
				"[32][][61.00][][61][][61][][61][][61][][61][][61][][61][][61][27.00][61][35][61]"));

		txtAnamneseOriental = new RoundJTextField();
		txtAnamneseOriental.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnamneseOriental.setText("Anamnese Oriental");
		txtAnamneseOriental.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtAnamneseOriental.setBackground(new Color(64, 128, 128));
		txtAnamneseOriental.setForeground(new Color(255, 255, 255));
		panel_1.add(txtAnamneseOriental, "cell 0 0,grow");
		txtAnamneseOriental.setColumns(10);

		lblNewLabel_3 = new JLabel("Queixa Principal");
		panel_1.add(lblNewLabel_3, "cell 0 1");

		textQueixa = new RoundJTextField();
		textQueixa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		panel_1.add(textQueixa, "cell 0 2,grow");
		textQueixa.setColumns(10);

		lblNewLabel_6 = new JLabel("Histórico de Doença Atual");
		panel_1.add(lblNewLabel_6, "cell 0 3");

		textHDoenca = new RoundJTextField();
		textHDoenca.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		panel_1.add(textHDoenca, "cell 0 4,grow");
		textHDoenca.setColumns(10);

		lblNewLabel_7 = new JLabel("Histórico Patológico Progresso");
		panel_1.add(lblNewLabel_7, "cell 0 5,aligny top");

		textHPato = new RoundJTextField();
		textHPato.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textHPato.setColumns(10);
		panel_1.add(textHPato, "cell 0 6,grow");

		lblNewLabel_8 = new JLabel("Histórico Patológico Familiar");
		panel_1.add(lblNewLabel_8, "cell 0 7");

		textHPatoF = new RoundJTextField();
		textHPatoF.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textHPatoF.setColumns(10);
		panel_1.add(textHPatoF, "cell 0 8,grow");

		lblNewLabel_9 = new JLabel("Histórico Social");
		panel_1.add(lblNewLabel_9, "cell 0 9");

		textHSocial = new RoundJTextField();
		textHSocial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textHSocial.setColumns(10);
		panel_1.add(textHSocial, "cell 0 10,grow");

		lblNewLabel_10 = new JLabel("Tratamentos Anteriores");
		panel_1.add(lblNewLabel_10, "cell 0 11,alignx left,aligny center");

		textTAnterior = new RoundJTextField();
		textTAnterior.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textTAnterior.setColumns(10);
		panel_1.add(textTAnterior, "cell 0 12,grow");

		lblNewLabel_11 = new JLabel("Tratamentos Atuais");
		panel_1.add(lblNewLabel_11, "cell 0 13,alignx left,aligny top");

		textTAtual = new RoundJTextField();
		textTAtual.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textTAtual.setColumns(10);
		panel_1.add(textTAtual, "cell 0 14,grow");

		lblNewLabel_12 = new JLabel("Alergias");
		panel_1.add(lblNewLabel_12, "cell 0 15");

		textAlergia = new RoundJTextField();
		textAlergia.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textAlergia.setColumns(10);
		panel_1.add(textAlergia, "cell 0 16,grow");

		lblNewLabel_13 = new JLabel("Medicação em Uso");
		panel_1.add(lblNewLabel_13, "cell 0 17");

		textMedicacao = new RoundJTextField();
		textMedicacao.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textMedicacao.setColumns(10);
		panel_1.add(textMedicacao, "cell 0 18,grow");

		lblNewLabel_14 = new JLabel("Exames Apresentados");
		panel_1.add(lblNewLabel_14, "cell 0 19");

		textExames = new RoundJTextField();
		textExames.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textExames.setColumns(10);
		panel_1.add(textExames, "cell 0 20,grow");

		lblNewLabel_15 = new JLabel("Disposição Geral");
		panel_1.add(lblNewLabel_15, "cell 0 21");

		textDispo = new RoundJTextField();
		textDispo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		textDispo.setColumns(10);
		panel_1.add(textDispo, "cell 0 22,grow");

		panel_2 = new JPanel();
		contentPane.add(panel_2, "cell 3 3 11 8,grow");
		panel_2.setLayout(new MigLayout("", "[139.00px,grow][162.00,grow]", "[][27px,grow]"));

		rndjtxtfldObservaes = new RoundJTextField();
		rndjtxtfldObservaes.setText("Objetivo");
		rndjtxtfldObservaes.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldObservaes.setForeground(Color.WHITE);
		rndjtxtfldObservaes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldObservaes.setEditable(false);
		rndjtxtfldObservaes.setColumns(10);
		rndjtxtfldObservaes.setBackground(new Color(64, 128, 128));
		panel_2.add(rndjtxtfldObservaes, "cell 0 0 2 1,growx,aligny top");

		txtObs = new RoundJTextField();
		txtObs.setEditable(false);
		txtObs.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		panel_2.add(txtObs, "cell 0 1 2 1,grow");
		txtObs.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaConsultaPendente telaAnterior = new TelaConsultaPendente(usuarioAtual);
				telaAnterior.setLocationRelativeTo(null);
				telaAnterior.setVisible(true);
				telaAnterior.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		contentPane.add(btnVoltar, "cell 0 11,growx");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int camposPreenchidos = 0;
				String queixa = textQueixa.getText();
				String historicoDoenca = textHDoenca.getText();
				String historicoPatoProg = textHPato.getText();
				String historicoPatoFam = textHPatoF.getText();
				String historicoSocial = textHSocial.getText();
				String tratamentoAnterior = textTAnterior.getText();
				String tratamentoAtual = textTAtual.getText();
				String alergias = textAlergia.getText();
				String medicacoes = textMedicacao.getText();
				String exames = textExames.getText();
				String disposicao = textDispo.getText();

				if (!queixa.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!historicoDoenca.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!historicoPatoProg.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!historicoPatoFam.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!historicoSocial.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!tratamentoAnterior.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!tratamentoAtual.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!alergias.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!medicacoes.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!exames.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (!disposicao.trim().isEmpty()) {
					camposPreenchidos++;
				}

				if (camposPreenchidos == 0) {
					new DialogMensagemErro("Preencha pelo menos um campo para prosseguir.").setVisible(true);
					return;
				}

				AnamneseDAO aDao = new AnamneseDAO();
				ConsultaDAO cDao = new ConsultaDAO();

				anaSelecionada.setAlergia(alergias);
				anaSelecionada.setDisposicaoGeral(disposicao);
				anaSelecionada.setExamesApresentados(exames);
				anaSelecionada.setHistoricoDoencaAtual(historicoDoenca);
				anaSelecionada.setHistoricoPatologicoFam(historicoPatoFam);
				anaSelecionada.setHistoricoPatologicoProg(historicoPatoProg);
				anaSelecionada.setHistoricoSocial(historicoSocial);
				anaSelecionada.setMedicacoesEmUso(medicacoes);
				anaSelecionada.setQueixaPrincipal(queixa);
				anaSelecionada.setTrataAnteriores(tratamentoAnterior);
				anaSelecionada.setTrataAtuais(tratamentoAtual);

				if (aDao.alterar(anaSelecionada)) {
					new DialogMensagemSucesso("a Anamnese foi realizada!").setVisible(true);
					cDao.consultaRealizada(anaSelecionada.getConsulta());
					dispose();
					TelaConsultaPendente telaAnterior = new TelaConsultaPendente(usuarioAtual);
					telaAnterior.setLocationRelativeTo(null);
					telaAnterior.setVisible(true);
					telaAnterior.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} else {
					new DialogMensagemErro("Ocorreu um erro ao salvar anamnese.").setVisible(true);
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnSalvar.setBackground(new Color(0, 81, 81));
		contentPane.add(btnSalvar, "cell 31 11,growx");

		receberDados(anaSelecionada);

	}

	private void receberDados(Anamnese anaSelecionada) {
		textNomeR.setText(anaSelecionada.getConsulta().getPaciente().getNome());
		textNomeS.setText(anaSelecionada.getConsulta().getPaciente().getNomeSocial());
		comboPronome.setSelectedItem(anaSelecionada.getConsulta().getPaciente().getPronome());
		textSexo.setText(anaSelecionada.getConsulta().getPaciente().getSexo());
		dtNascimento.setDate(Date.valueOf(anaSelecionada.getConsulta().getPaciente().getNascimento()));
		textAlergia.setText(anaSelecionada.getAlergia());
		textDispo.setText(anaSelecionada.getDisposicaoGeral());
		textExames.setText(anaSelecionada.getExamesApresentados());
		textHDoenca.setText(anaSelecionada.getHistoricoDoencaAtual());
		textHPato.setText(anaSelecionada.getHistoricoPatologicoProg());
		textHPatoF.setText(anaSelecionada.getHistoricoPatologicoFam());
		textMedicacao.setText(anaSelecionada.getMedicacoesEmUso());
		textQueixa.setText(anaSelecionada.getQueixaPrincipal());
		textTAtual.setText(anaSelecionada.getTrataAtuais());
		textTAnterior.setText(anaSelecionada.getTrataAnteriores());
		textHSocial.setText(anaSelecionada.getHistoricoSocial());
		txtObs.setText(anaSelecionada.getConsulta().getObjetivo());
	}

}
