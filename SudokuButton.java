package guiSudoku;

import java.awt.event.*;
import javax.swing.*;

public class SudokuButton extends JButton implements ActionListener{
	
	private Sudoku board;
	private int row;
	private int col;
	
	public SudokuButton(Sudoku b, int r, int c) {
		board = b;
		row = r; 
		col = c;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		board.clicked(row, col);
	}
}
