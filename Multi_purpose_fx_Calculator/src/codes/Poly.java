package codes;

//COPYRIGHT MohammadKazemzadeh
public class Poly {
	public static void main(String[] args) {
		Poly Given = new Poly("4x^3+8x");
		Poly Given_2 = new Poly("x-16x");
		String Multiplication = Given.PMultiply(Given_2);
		System.out.println(Multiplication);
	}

	String Polynomial;

	public Poly() {
		Polynomial = "";
	}

	public Poly(String value) {
		Polynomial = value;
	}

	@Override
	public String toString() {
		return this.Polynomial;
	}

	public String PMultiply(String Given_2) {
		// array equivalent of Given strings
		double[] Val_ = new double[100];
		double[] Val_2 = new double[100];
		// arrays to accumulate split parts
		String[] AG = new String[1000];
		String[] AG_2 = new String[1000];
		// fixing Polys
		this.Polynomial = Fix(this.Polynomial);
		Given_2 = Fix(Given_2);
		// length of split arrays
		int cAG = PolySplit(this.Polynomial, AG);
		int cAG_2 = PolySplit(Given_2, AG_2);
		// calculation of ax^n put into A[x] = n
		AnalysePol(AG, cAG, Val_);
		AnalysePol(AG_2, cAG_2, Val_2);
		// result array
		double[] Res = new double[1000];
		for (int i = 0; i < 100; i++) {
			if (Val_[i] != 0) {
				// Multiply the current term of first polynomial
				// with every term of second polynomial.
				for (int j = 0; j < 100; j++) {
					if (Val_2[j] != 0)
						Res[i + j] += Val_[i] * Val_2[j];
				}
			}
		}
		String FinalRes = MaArrdoubleToString(Res);
		return FinalRes;
	}

	public String PMultiply(Poly Given_2) {
		return PMultiply(Given_2.toString());
	}

	public static String MaArrdoubleToString(double[] A) {
		String FRes = "";
		for (int x = A.length - 1; x >= 0; x -= 1) {
			if (A[x] != 0 && x == 0) {
				if (A[x] >= 0) {
					FRes += "+" + A[x];
				} else
					FRes += A[x] + "";
			} else if (A[x] != 0 && x == 1) {
				if (A[x] >= 0) {
					FRes += "+" + A[x] + "" + "x";
				} else
					FRes += A[x] + "x";
			} else if (A[x] != 0) {
				if (A[x] >= 0) {
					FRes += "+" + A[x] + "" + "x^" + x;
				} else
					FRes += A[x] + "x^" + x;

			}

		}
		if (FRes.length() == 0) {
			return "0";
		} else
			return FRes;
	}

	private static String Fix(String Given) {
		if (Given.charAt(0) != '-' && Given.charAt(0) != '+')
			Given = "+" + Given;
		return Given;

	}

	private static int PolySplit(String Given, String AP[]) {

		int cAP = 0;
		int x = 0;
		while (x < Given.length()) {
			String P = "" + Given.charAt(x++);
			while (x < Given.length() && Given.charAt(x) != '+' && Given.charAt(x) != '-' && Given.charAt(x) != ' ') {
				P += Given.charAt(x++);
			}
			AP[cAP++] = P;
		}

		return cAP;
	}

	private static void AnalysePol(String A[], int cA, double Val_[]) {
		for (int x = 0; x < cA; x++) {
			// no x
			if (A[x].indexOf('x') == -1) {
				Val_[0] += Double.parseDouble(A[x]);
				continue;
			}
			// no power
			if (A[x].indexOf('^') == -1) {
				String help = A[x].substring(0, A[x].indexOf('x'));
				if (help.equals("+"))
					help = "+1";
				if (help.equals("-"))
					help = "-1";
				Val_[1] += Double.parseDouble(help);
				continue;
			}
			String help = A[x].substring(0, A[x].indexOf('x'));
			if (help.equals("+") || help.equals("-")) {
				help += "1";
			}
			double a = Double.parseDouble(help);
			int n = Integer.parseInt(A[x].substring(A[x].indexOf('^') + 1, A[x].length()));
			Val_[n] += a;

		}
	}

}
