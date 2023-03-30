package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medico;
import modelo.Usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	private RoundJPanel panel_4;
	private JButton btnVoltar;
	private RoundJPanel panel_2_1;


	public TelaHistorico(Usuario u) {
		setBackground(new Color(0, 81, 81));
		setTitle("Hospital Esmeralda - Histórico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaHistorico.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150.00px,grow][258.00px,grow][207px,grow]", "[73px][388px,grow][25][60.00px]"));
		
		RoundJTextField txtMarcarConsulta = new RoundJTextField();
		txtMarcarConsulta.setText("Paciente");
		txtMarcarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarcarConsulta.setForeground(Color.WHITE);
		txtMarcarConsulta.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtMarcarConsulta.setEditable(false);
		txtMarcarConsulta.setColumns(10);
		txtMarcarConsulta.setBackground(new Color(0, 81, 81));
		contentPane.add(txtMarcarConsulta, "cell 0 0,grow");
		
		RoundJTextField rndjtxtfldSetor = new RoundJTextField();
		rndjtxtfldSetor.setText("Setor");
		rndjtxtfldSetor.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldSetor.setForeground(Color.WHITE);
		rndjtxtfldSetor.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldSetor.setEditable(false);
		rndjtxtfldSetor.setColumns(10);
		rndjtxtfldSetor.setBackground(new Color(0, 81, 81));
		contentPane.add(rndjtxtfldSetor, "cell 1 0,grow");
		
		RoundJTextField rndjtxtfldData = new RoundJTextField();
		rndjtxtfldData.setText("Data");
		rndjtxtfldData.setHorizontalAlignment(SwingConstants.CENTER);
		rndjtxtfldData.setForeground(Color.WHITE);
		rndjtxtfldData.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		rndjtxtfldData.setEditable(false);
		rndjtxtfldData.setColumns(10);
		rndjtxtfldData.setBackground(new Color(0, 81, 81));
		contentPane.add(rndjtxtfldData, "cell 2 0,grow");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1 3 1,grow");
		panel.setLayout(new MigLayout("", "[2px,grow]", "[2px,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");
		
		panel_2_1 = new RoundJPanel(10, new Color(64, 128, 128));
		panel_2_1.setBackground((Color) null);
		contentPane.add(panel_2_1, "cell 0 2 3 1,grow");
		
		panel_4 = new RoundJPanel(10, new Color(0, 81, 81));
		panel_4.setLayout(null);
		panel_4.setBackground((Color) null);
		contentPane.add(panel_4, "cell 0 3 3 1,grow");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setBounds(10, 11, 112, 37);
		panel_4.add(btnVoltar);
	}
}
