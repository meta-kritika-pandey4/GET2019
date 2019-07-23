package com.metacube.get2019;

/**
 * It is class for performing operations on sparse matrix.
 * @author Kritika
 *
 */
public final class SparseMatrix {

	private final int MAX = 100;

	private int row, col;
	private int len = 0;
	private int sparseMat[][] = new int[MAX][3];

	/**
	 * It is a constructor which is used to intialize Sparse Matrix.
	 * @param row row of Matrix
	 * @param col column of Matrix
	 * @param matrixInput Matrix from user
	 */
	public SparseMatrix(int row, int col, int[][] matrix) {

		this.row = row;
		this.col = col;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 0) {
					insert(i, j, matrix[i][j]);
				}
			}
		}
	}

	/**
	 * It is an constructor used to intialize row and column of sparse matrix
	 * for method results..
	 * @param row  row of Matrix
	 * @param col  column of Matrix
	 */
	SparseMatrix(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * It is a method used to insert elements into sparse matrix.
	 * @param row row number of sparse
	 * @param col column number of sparse
	 * @param val value at particular row and column.
	 */
	private void insert(int row, int col, int val) {
		if (row > this.row || col > this.col) {
			throw new AssertionError("Wrong Entry");
		} else {
			sparseMat[len][0] = row;
			sparseMat[len][1] = col;
			sparseMat[len][2] = val;
			len++;
		}
	}

	/**
	 * It is used to add 2 Sparse Matrix.
	 * @param b2nd Sparse Matrix.
	 * @return addition of sparse matrices.
	 */
	public SparseMatrix add(SparseMatrix b) {
		if (this.len == 0 || b.len == 0) {
			throw new AssertionError("Empty matrices");
		}

		if (this.row != b.row || this.col != b.col) {
			throw new AssertionError("Matrices can't be added");

		} else {
			int i = 0, j = 0, k = 0;
			SparseMatrix addition = new SparseMatrix(row, col);

			while (i < len && j < b.len) {
				if (sparseMat[i][0] > b.sparseMat[j][0]
						|| sparseMat[i][0] == b.sparseMat[j][0]
						&& sparseMat[i][1] > b.sparseMat[j][1]) {

					addition.insert(b.sparseMat[j][0], b.sparseMat[j][1],
							b.sparseMat[j][2]);
					j++;
					k++;
				} else if (sparseMat[i][0] < b.sparseMat[j][0]
						|| sparseMat[i][0] == b.sparseMat[j][0]
						&& sparseMat[i][1] < b.sparseMat[j][1]) {

					addition.insert(sparseMat[i][0], sparseMat[i][1],
							sparseMat[i][2]);
					i++;
					k++;
				} else {
					int addval = sparseMat[i][2] + b.sparseMat[j][2];
					if (addval != 0) {
						addition.insert(sparseMat[i][0], sparseMat[i][1],
								addval);
					}
					i++;
					j++;
					k++;
				}
			}
			while (i < len) {
				addition.insert(sparseMat[i][0], sparseMat[i][1],
						sparseMat[i++][2]);
				k++;
			}
			while (j < b.len) {
				addition.insert(b.sparseMat[j][0], b.sparseMat[j][1],
						b.sparseMat[j++][2]);
				k++;
			}
			addition.len = k;
			return addition;
		}
	}

	/**
	 * It is used to find transpose of sparse matrices.
	 * @return transpose of sparse matrix.
	 */
	public SparseMatrix transpose() {
		if (this.len == 0) {
			throw new AssertionError("Empty matrices");
		}

		SparseMatrix transpose = new SparseMatrix(col, row);
		transpose.len = len;

		int[] count = new int[col + 1];

		for (int i = 0; i <= col; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < len; i++) {
			count[sparseMat[i][1]]++;
		}
		int[] index = new int[col + 1];

		index[0] = 0;

		for (int i = 1; i < col; i++) {
			index[i] = index[i - 1] + count[i - 1];
		}
		for (int i = 0; i < len; i++) {
			int rpos = index[sparseMat[i][1]]++;
			transpose.sparseMat[rpos][0] = sparseMat[i][1];
			transpose.sparseMat[rpos][1] = sparseMat[i][0];
			transpose.sparseMat[rpos][2] = sparseMat[i][2];
		}
		return transpose;

	}

	/**
	 * It is used to multiply 2 Sparse Matrix.
	 * @param b  2nd Sparse Matrix.       
	 * @return Multiplication of sparse matrices
	 */
	public SparseMatrix multiply(SparseMatrix b) {
		if (this.len == 0 || b.len == 0) {
			throw new AssertionError("Empty matrices");
		}
		if (col != b.row) {
			throw new AssertionError("Can't multiply, Invalid dimensions");
		}
		b = b.transpose();
		int i, j;
		SparseMatrix multiply = new SparseMatrix(row, b.row);
		for (i = 0; i < len;) {
			int row = sparseMat[i][0];
			for (j = 0; j < b.len;) {
				int col = b.sparseMat[j][0];
				int sum = 0;
				while (i < len && sparseMat[i][0] == row && j < b.len
						&& b.sparseMat[j][0] == col) {
					if (sparseMat[i][1] < b.sparseMat[j][1]) {
						i++;
					} else if (sparseMat[i][1] > b.sparseMat[j][1]) {
						j++;
					} else {
						sum += sparseMat[i++][2] * b.sparseMat[j++][2];
					}
				}
				if (sum != 0) {
					multiply.insert(row, col, sum);
				}
			}
		}
		return multiply;
	}

	/**
	 * It is used to check symmetricity of a matrix
	 * @return boolean value
	 */
	public boolean symmetric() {
		if (this.len == 0) {
			throw new AssertionError("Empty matrices");
		}
		SparseMatrix symmetric = new SparseMatrix(col, row);

		symmetric = this.transpose();
		for (int i = 0; i < len; i++) {
			if (sparseMat[i][0] != symmetric.sparseMat[i][0]
					|| sparseMat[i][2] != symmetric.sparseMat[i][2]
					|| sparseMat[i][1] != symmetric.sparseMat[i][1]) {
				return false;
			}
		}
		return true;

	}

	/**
	 * It is used to print sparse matrix.
	 */
	public void printSparse() {
		System.out.println("Row Column Value");
		for (int i = 0; i < len; i++) {
			System.out.println(sparseMat[i][0] + " " + sparseMat[i][1] + " "
					+ sparseMat[i][2]);
		}
	}

	/**
	 * It is a getter method used to return sparse matrix.
	 * @return arr sparse matrix
	 */
	public int[][] getResult() {
		int[][] arr = new int[this.len][3];
		for (int i = 0; i < this.len; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sparseMat[i][j];
			}
		}
		return arr;
	}

}
