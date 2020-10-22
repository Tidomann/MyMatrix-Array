package matrixProgram;

/**
* The MyMatrix object will store real numbers in a matrix
* and is able to process operations as outlinded in Assignment 1.

* @author  Jordan Tiedemann
* @version 1.0.0
* created on 2020-10-14
*/

public class MyMatrix {

private double[][] matrixArray;
private int columns;
private int rows;

	/**
	 * Default constructor that creates a 2d double array with 3x3 dimensions
	 */
	public MyMatrix(){
		matrixArray = new double[3][3];
		columns = 3;
		rows = 3;
	}

	/**
	 * Argumented constructor that takes in a two int values to set the length of rows and columns for the 2d array
	 * @param row The length of the matrix rows
	 * @param column the length of the matrix columns
	 */
	public MyMatrix(int row, int column){
		matrixArray = new double[row][column];
		columns = column;
		rows = row;
	}
	
	/**
	 * A get method to return the private variable rows
	 * @return the number of rows of the array
	 */
	public int getRows(){
		return rows;
		}
	/**
	 * A set method to set the private variable rows
	 * @param r the number of rows of the array
	 */
	public void setRows(int r){
		rows = r;
		this.resize();
	}
	
	/**
	 * A get method to return the private variable columns
	 * @return the number of columns of the array
	 */
	public int getColumns(){
		return columns;
	}
	
	/**
	 * A set method to set the private variable rows
	 * @param c the number of rows of the array
	 */
	public void setColumns(int c){
		columns = c;
		this.resize();
	}
	
	/**
	 * A method to return the capacity of the MyMatrix array
	 * @return the number of elements the array can hold
	 */
	public int getCapacity(){
		return this.getRows()*this.getColumns();
	}
	
	/**
	 * A method to enter data at a specified row and column
	 * @param r the row to be accessed
	 * @param c the column to be accessed
	 * @param data the real number to be entered to the matrix
	 */
	public void setData(int r, int c, double data){
			matrixArray[r][c] = data;
	}
	
	/**
	 * A get method to retrieve data at a specified row and column
	 * @param r the row to be accessed
	 * @param c the column to be accessed
	 * @return the real number returned accessed at the specified location
	 */
	public double getData(int r, int c){
			return matrixArray[r][c];
	}
	
	/**
	 * An argumented method to resize the structure of the array with specified
	 * row and column integers specified in the parameter
	 * Will remove the data from the original array
	 * @param r the new number of rows
	 * @param c the new number of columns
	 */
	public void resize(int r, int c) {
		matrixArray = new double[r][c];
		columns = c;
		rows = r;
	}
	
	/**
	 * An unargumented method to resize the structure of the array
	 * uses the row and column variables in the object
	 * values may have been changed via setRows or setColumns
	 * Will remove the data from the original array
	 */
	public void resize() {
		matrixArray = new double[this.getRows()][this.getColumns()];
	}
	
	/**
	 * A method to add the elements of two MyMatrix objects together
	 * creates a new array to store the results from the operations
	 * calls the getData and setData functions to retrieve the values of the
	 * input matrices, and set the resulting values in the new matrix
	 * @param b The MyMatrix object that will be added to this MyMatrix object
	 * @return The results of the operation in a new MyMatrix
	 */
	public MyMatrix add(MyMatrix b){
		if(this.getRows() == b.getRows() && this.getColumns() == b.getColumns()) {
			MyMatrix c = new MyMatrix(this.getRows(), this.getColumns());
			for(int i=0; i<this.getRows(); ++i) {
				for(int j=0; j<this.getColumns(); ++j) {
					c.setData(i,j,(this.getData(i, j) + b.getData(i, j)));
				}
			}
				return c;
			}
		else {
			System.out.println("Matrices do not match size, cannot add.");
			return this;
		}
	}
	
	/**
	 * A method to subtract the elements of two MyMatrix objects together
	 * creates a new array to store the results from the operations
	 * calls the getData and setData functions to retrieve the values of the
	 * input matrices, and set the resulting values in the new matrix
	 * @param b The MyMatrix object that will be subtracted to this MyMatrix object
	 * @return The results of the operation in a new MyMatrix
	 */
	public MyMatrix subtract(MyMatrix b){
		if(this.getRows() == b.getRows() && this.getColumns() == b.getColumns()) {
			MyMatrix c = new MyMatrix(this.getRows(), this.getColumns());
			for(int i=0; i<this.getRows(); ++i) {
				for(int j=0; j<this.getColumns(); ++j) {
					c.setData(i,j,(this.getData(i, j) - b.getData(i, j)));
				}
			}
				return c;
			}
		else {
			System.out.println("Matrices do not match size, cannot subtract.");
			return this;
		}
	}
	
	/**
	 * A method to multiply the elements of a MyMatrix objects by another MyMatrix object
	 * creates a new array to store the results from the operations
	 * calls the getData and setData functions to retrieve the values of the
	 * input matrices, and set the resulting values in the new matrix.
	 * Returns the original matrix if an error occurs.
	 * @param b the other MyMatrix to multiply with
	 * @return returns the result in new matrix, or returns original if unable to multiply
	 */
	public MyMatrix multiply(MyMatrix b) {
		if(this.getColumns() == b.getRows()) {
			MyMatrix c = new MyMatrix(this.getRows(), b.getColumns());
				for(int i = 0; i < this.getRows(); ++i) {
					for (int j = 0; j < b.getColumns(); j++) {
						for (int k = 0; k < this.getColumns(); k++) {
							c.setData(i, j, (c.getData(i, j) + (this.getData(i, k) * b.getData(k, j))));
						}
					}
				}
			return c;
		}
		else {
			System.out.println("The Matrices cannot be multiplied. The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.");
			return this;
		}
	}
	
	/**
	 * A method to multiply the elements of a MyMatrix objects by a scalar
	 * modifies the original array to store the results from the operation
	 * calls the getData and setData functions to retrieve the values of the
	 * input matrices, and set the resulting values in the same matrix
	 * @param s the scalar value to be multiplied
	 */
	public void multiply(double s) {
		for(int i=0; i<this.getRows(); ++i) {
			for(int j=0; j<this.getColumns(); ++j) {
				this.setData(i,j,(this.getData(i, j) * s));
			}
		}
	}
	
	/**
	 * A method to transpose the elements of a MyMatrix object
	 * creates a copy of the original matrix object then
	 * modifies the original array to store the results of the operation
	 * calls the getData and setData functions to retrieve the values of the
	 * input matrices, and set the resulting values in the same matrix
	 */
	public void transpose() {
		MyMatrix temp = new MyMatrix(this.getRows(), this.getColumns());
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				temp.setData(i, j, this.getData(i, j));
			}
		}
		this.resize(temp.getColumns(), temp.getRows());
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				this.setData(i, j, temp.getData(j, i));
			}
		}
	}
	
	/**
	 * A method to search the elements of a MyMatrix and compares the values
	 * the the parameter value. Calls the getData functions to compare
	 * the values to the input value. Returns the number of matches.
	 * @param v The value to be matched
	 * @return the number of matches
	 */
	public int search(double v) {
		int count = 0;
		for(int i=0; i<this.getRows(); ++i) {
			for(int j=0; j<this.getColumns(); ++j) {
				if (this.getData(i,j) == v) {
					++count;
				}
			}
		}
		return count;
	}
	
	/**
	 * A method to remove both a row and a column from MyMatrix
	 * Calls the getData and setData function to replace the values
	 * in their new locations.
	 * @param r the row to be removed
	 * @param c the column to be removed
	 */
	public void remove(int r, int c) {
		if(r < 1 || c <1) {
			System.out.println("Tried to remove a zeroth or negative numbered row or column.");
			return;
		}
		MyMatrix temp = new MyMatrix(this.getRows(), this.getColumns());
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				temp.setData(i, j, this.getData(i, j));
			}
		}
		this.resize(temp.getRows()-1, temp.getColumns()-1);
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				if(i >= r-1 && j >= c-1) {
					this.setData(i, j, temp.getData(i+1, j+1));
				}
				else if (i >= r-1) {
					this.setData(i, j, temp.getData(i+1, j));
				}else if(j >= c-1){
					this.setData(i, j, temp.getData(i, j+1));
				}else {
					this.setData(i, j, temp.getData(i, j));
				}
			}
		}
	}
	
	/**
	 * A method to remove a row from MyMatrix
	 * Calls the getData and setData function to replace the values
	 * in their new locations.
	 * @param r the row to be removed
	 */
	public void removeRow(int r) {
		if(r < 1) {
			System.out.println("Tried to remove a zeroth or negative numbered row.");
			return;
		}
		if(r > this.getRows()) {
			System.out.println("Tried to a row outside of matrix.");
			return;
		}
		MyMatrix temp = new MyMatrix(this.getRows(), this.getColumns());
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				temp.setData(i, j, this.getData(i, j));
			}
		}
		this.resize(temp.getRows() -1, temp.getColumns());
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				if(i >= r-1) {
					this.setData(i, j, temp.getData(i+1, j));
		/*		}
				else if (i > r-1) {
					this.setData(i, j, temp.getData(i+1, j));*/
				}else {
					this.setData(i, j, temp.getData(i, j));
				}
			}
		}
	}
	
	/**
	 * A method to remove a column from MyMatrix
	 * Calls the getData and setData function to replace the values
	 * in their new locations.
	 * @param c the column to be removed
	 */
	public void removeCol(int c) {
		if(c < 1) {
			System.out.println("Tried to remove a zeroth or negative numbered column.");
			return;
		}
		if(c > this.getColumns()) {
			System.out.println("Tried to a row outside of matrix.");
			return;
		}
		MyMatrix temp = new MyMatrix(this.getRows(), this.getColumns());
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				temp.setData(i, j, this.getData(i, j));
			}
		}
		this.resize(temp.getRows(), temp.getColumns()-1);
		for(int i = 0; i<this.getRows(); ++i) {
			for(int j = 0; j<this.getColumns(); ++j) {
				if(j >= c-1) {
					this.setData(i, j, temp.getData(i, j+1));
		/*		}
				else if (i > r-1) {
					this.setData(i, j, temp.getData(i+1, j));*/
				}else {
					this.setData(i, j, temp.getData(i, j));
				}
			}
		}
	}
	
	/**
	* Overrides the default object toString for easy printing
 	* @return Returns the object as a string for easy printing.
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.getRows(); ++i) {
				for(int j = 0; j < this.getColumns(); ++j) {
					sb.append(this.getData(i, j));
			    	if(!(j == this.getColumns() -1)){
			    		sb.append(",\t");
			    	}
			    	else{
			    		if(!((i == this.getRows() - 1) && (j == this.getColumns() -1))){
			    			sb.append('\n');
			    		}
			    	}
				}
			}
		return sb.toString();
	}
	
	/**
	* Overrides the default object toString for easy printing
	* @param b determines whether to print in row or column order
 	* @return Returns the object as a string for easy printing.
	 */
	public String toString(boolean b){
		StringBuilder sb = new StringBuilder();
		if (b) {
			for (int i = 0; i < this.getRows(); ++i) {
				for(int j = 0; j < this.getColumns(); ++j) {
					sb.append(this.getData(i, j));
			    	if(!((i == this.getRows() - 1) && (j == this.getColumns() -1))){
			    		sb.append(", ");
			    	}
				}
			}
		}
		else {
			 for (int j = 0; j < this.getColumns(); ++j) {
			      for(int i = 0; i < this.getRows(); ++i) {
			    	  sb.append(this.getData(i, j));
			    	  if(!((i == this.getRows() - 1) && (j == this.getColumns() -1))){
			    		  sb.append(", ");
				    	}
			      }
			 }
		}

		return sb.toString();
	}
	
	
}
