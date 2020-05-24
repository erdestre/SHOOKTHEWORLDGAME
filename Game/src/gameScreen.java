import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameScreen extends JFrame implements KeyListener, MouseListener, ActionListener {
	
	int counter = 0;
	boolean permission;
	String Answer;
	
	JFrame jf;
 
	JPanel jpToolbar;
	JPanel jpWhiteBoard;
	JPanel jpMenu;
	JPanel jpParticipant;
	JPanel jpChat;
	JLabel jlAnswer;
	
	BorderLayout blWhiteBoard;
	BorderLayout blMainScreen;
	BorderLayout blMenu;
	BorderLayout blButton;
	GridLayout glToolbar;
	
	JLabel jlCounter; 
	
	JTextField textField;
	
	
	
	
	public void MainScreen() {
		jf = new JFrame("THE GAME THAT SHOOK THE WORLD FROM STMP STUDIOS");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(850,500);
		permission = getNickname.permission();
		ScreenPanels();
		jf.setVisible(true);

		
	}
	
	public void ScreenPanels() {
		blMainScreen = new BorderLayout();
		jf.setLayout(blMainScreen);
		WhiteBoard();
		Menu();
		
	}
	public void WhiteBoard() {
		jpWhiteBoard = new JPanel();
		jpWhiteBoard.setBackground(Color.white);
		if (permission == true) {
			Toolbar();
			jlAnswer = new JLabel("YOUR WORD IS:  ");
			jpWhiteBoard.add(jlAnswer);
			setAnswer();
		}
		CounterLabel();
		jf.add(jpWhiteBoard);
	}
	public void setAnswer () {
		Answer = getAnswer.getAnswer();
		jlAnswer.setText("YOUR WORD IS:  " + Answer);
	}
	public void CounterLabel() {
		jlCounter = new JLabel("COUNTER:  " + counter);
		jpWhiteBoard.add(jlCounter);
	}
	public void setCounter() {
		counter++;
		jlCounter.setText("COUNTER:  " + counter);
	}
	public void Toolbar() {
		jpToolbar = new JPanel();
		glToolbar = new GridLayout(1,5);
		jpToolbar.setLayout(glToolbar);
		jpWhiteBoard.add(jpToolbar);
		JButton Line = new JButton("Line");
		JButton Square = new JButton("Square");
		JButton Circle = new JButton("Circle");
		JButton Pen = new JButton("Pen");
		JButton selectColor = new JButton("Select Color");
		JButton Reset = new JButton("Reset");
		jpToolbar.add(Pen);
		jpToolbar.add(Line);
		jpToolbar.add(Square);
		jpToolbar.add(Circle);
		jpToolbar.add(selectColor);
		jpToolbar.add(Reset);
	}
	public void Menu() {
		jpMenu = new JPanel();
		blMenu= new BorderLayout();
		jpMenu.setLayout(blMenu);
		jf.add(jpMenu,BorderLayout.EAST);
		Participants();
		ChatPanel();
	}
	public void Participants() {
		jpParticipant = new JPanel();
		jpMenu.add(jpParticipant,BorderLayout.NORTH);
		jpParticipant.setBackground(Color.LIGHT_GRAY);
		JButton triv = new JButton("All Players");
		jpParticipant.add(triv);
		 
	}
	public void ChatPanel() {
		jpChat = new JPanel();
		jpMenu.add(jpChat,BorderLayout.CENTER);
		blButton = new BorderLayout();
		jpChat.setLayout(blButton);
		JTextPane chatScreen = new JTextPane();
		chatScreen.setEditable(false);
		jpChat.setBackground(Color.lightGray);
		jpChat.add(chatScreen);
		textField();
		Button();
		
	}
	public void Button() {
		JButton Hand= new JButton("");
		Image handIcon = new ImageIcon(this.getClass().getResource("HandIcon.png")).getImage();
		Hand.setIcon(new ImageIcon(handIcon));
		jpChat.add(Hand,BorderLayout.NORTH);
		
	}
	public void textField() {
		textField = new JTextField();
		jpMenu.add(textField,BorderLayout.SOUTH);
		
	}
	
	public void RESET_GAME () {
		// Set Word
		setAnswer();
		// Reset Counter
		counter = -1;
		setCounter();		
		// Reset Screen
		//
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
