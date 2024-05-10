
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FPrincipal extends JFrame implements ActionListener {
	private JButton[][] botones = new JButton[4][4];
	private String valores[][] = { { "7", "8", "9", "/" }, { "4", "5", "6", "*" }, { "1", "2", "3", "-" },
			{ "C", "0", "=", "+" } };
	private JPanel pBotones = new JPanel();
	private JLabel lResultado = new JLabel("0", SwingConstants.RIGHT);

	private Calculadora calculadora = new Calculadora();

	public FPrincipal() {
		this.setTitle("Calculadora DPOO");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 600);

		this.lResultado.setFont(new Font("Arial", Font.BOLD, 40));

		this.pBotones.setLayout(new GridLayout(4, 4, 10, 10));
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.botones[i][j] = new JButton(this.valores[i][j]);
				this.pBotones.add(this.botones[i][j]);
				this.botones[i][j].addActionListener(this);
			}
		}
		this.setLayout(new BorderLayout());
		this.add(this.lResultado, BorderLayout.NORTH);
		this.add(this.pBotones, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		char c = boton.getText().charAt(0);
		if (c >= 48 & c <= 57) {
			if (this.calculadora.getOp().equals(Calculadora.SIN_OP)) {
				this.calculadora.actualizarOp1(Integer.parseInt(boton.getText()));
				this.lResultado.setText(String.valueOf(this.calculadora.getOp1()));
			} else {
				this.calculadora.actualizarOp2(Integer.parseInt(boton.getText()));
				this.lResultado.setText(String.valueOf(this.calculadora.getOp2()));
			}
		} else if (c == '=') {
			this.calculadora.operar();
			this.lResultado.setText(String.valueOf(this.calculadora.getOp1()));
		} else if (c == 'C') {
			this.calculadora.setOp1(0);
			this.calculadora.setOp2(0);
			this.calculadora.setOp(Calculadora.SIN_OP);
			this.lResultado.setText(String.valueOf(this.calculadora.getOp1()));
		} else {
			this.calculadora.setOp(boton.getText());
		}
	}
}
