package guiSudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class LevelButton extends JFrame implements ActionListener{
	JButton b1, b2, b3;
	JPanel p;
	private Sudoku board;
	private SudokuFrame frame;
	
	public LevelButton() {
		
		setSize(300,100);
		setTitle("Select Level");
		
		p = new JPanel();
		b1 =  new JButton("Easy");
		b2 =  new JButton("Normal");
		b3 =  new JButton("Hard");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		
		setLocation(400,400);
		add(p);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) 
			new SudokuFrame(new Sudoku(36));
		else if(e.getSource() == b2)
			new SudokuFrame(new Sudoku(45));
		else
			new SudokuFrame(new Sudoku(54));
		setVisible(false);
	}
	
}
