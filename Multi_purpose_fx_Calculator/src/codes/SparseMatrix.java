package codes;

public class SparseMatrix {

	public static int[][] CompactToSparse(int[][] compactSparseMatrix, int originalROWS, int originalCOLUMNS) {

		int[][] Converted = new int[originalROWS][originalCOLUMNS];

		int Size = compactSparseMatrix.length;

		for (int j = 0; j < Size; j++) {

			Converted[compactSparseMatrix[j][0]][compactSparseMatrix[j][1]] = compactSparseMatrix[j][2];
		}

		return Converted;

	}

	public static int[][] SparseToCompact(int[][] Given) {
		int Size = getSparseSize(Given);
		int[][] Converted = new int[Size][3]; // (3) ===> i, j, value
		int Rows = Given.length;
		int Columns = Given[0].length;
		int Counter = 0;
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Columns; j++) {
				if (Given[i][j] != 0) { // if Data isn't zero then add to new matrix
					Converted[Counter][0] = i; // Row
					Converted[Counter][1] = j; // Column
					Converted[Counter][2] = Given[i][j]; // Data itself
					Counter++; // threshold is Size but may change during addition
				}
			}
		}
		return Converted;

	}

	private static int getSparseSize(int[][] Given) {

		int Rows = Given.length;
		int Columns = Given[0].length;
		int Counter = 0;
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Columns; j++) {
				if (Given[i][j] != 0) {
					Counter++;
				}
			}
		}

		return Counter;

	}

	public static int[][] Multiply(int[][] Sparse_F, int[][] Sparse_S) {

		int[][] Res = new int[Sparse_F.length][Sparse_S[0].length];

		for (int i = 0; i < Res.length; i++) {

			for (int k = 0; k < Sparse_F[0].length; k++) {

				if (Sparse_F[i][k] != 0) {

					for (int j = 0; j < Res[0].length; j++) {

						Res[i][j] += Sparse_F[i][k] * Sparse_S[k][j];
					}
				}
			}
		}

		return Res;

	}

}
