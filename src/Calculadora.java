
public class Calculadora {
	private double op1 = 0;
	private double op2 = 0;
	private String op = Calculadora.SIN_OP;

	public final static String SUMA = "+";
	public final static String RESTA = "-";
	public final static String MULTIPLICACION = "*";
	public final static String DIVISION = "/";
	public final static String IGUAL = "=";
	public final static String LIMPIAR = "C";
	public final static String SIN_OP = "Nada";

	public double getOp1() {
		return op1;
	}

	public void setOp1(double op1) {
		this.op1 = op1;
	}

	public double getOp2() {
		return op2;
	}

	public void setOp2(double op2) {
		this.op2 = op2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public void operar() {
		if (this.op.equals(Calculadora.SUMA)) {
			this.op1 += this.op2;
		} else if (this.op.equals(Calculadora.RESTA)) {
			this.op1 -= this.op2;
		} else if (this.op.equals(Calculadora.MULTIPLICACION)) {
			this.op1 *= this.op2;
		} else if (this.op.equals(Calculadora.DIVISION)) {
			this.op1 /= this.op2;
		}
		this.op2 = 0;
		this.op = Calculadora.SIN_OP;
	}

	public void actualizarOp1(int n) {
		this.op1 = this.op1 * 10 + n;
	}

	public void actualizarOp2(int n) {
		this.op2 = this.op2 * 10 + n;
	}

}
