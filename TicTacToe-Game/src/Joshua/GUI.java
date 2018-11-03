package Joshua;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame implements MouseListener {
	private JPanel panel;
	private JLabel turns;
	private boolean turn = true;
	private boolean helper;
	private int x;
	private int y;
	private boolean helper2 = true;
	public String who;
	public boolean trueorfalse = true;
	private boolean ZeroAndZero = false;
	private boolean ZeroAndOne = false;
	private boolean endofgame = false;
	private boolean ZeroAndTwo = false;
	private boolean OneAndZero = false;
	private boolean OneAndOne = false;
	private boolean OneAndTwo = false;
	private boolean TwoAndZero = false;
	private boolean TwoAndOne = false;
	private boolean TwoAndTwo = false;
	private boolean true1 = true;
	private boolean false1 = false;
	private int game[][] = new int[3][3];
	private boolean turn1 = true;
	private boolean turn2 = turn1;
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	int num1;

	// constructor
	public GUI() {
		super("Tic-Tac-Toe Game");
		num1 = 1;
		panels();
		setupgame();
		// add mouselistener to panelss
	}

	private void panels() {
		// panels.add(new JPanel)
		panel = new JPanel();
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.addMouseListener(this);
	}

	private void setupgame() {

		for (int x = 0; x <= 2; x++) {
			for (int y = 0; y <= 2; y++) {
				game[x][y] = 0;
			}
		}
		ZeroAndZero = false;
		ZeroAndOne = false;
		endofgame = false;
		ZeroAndTwo = false;
		OneAndZero = false;
		OneAndOne = false;
		OneAndTwo = false;
		TwoAndZero = false;
		TwoAndOne = false;
		TwoAndTwo = false;
		turn = true;
		turn1 = true;
		turn2 = turn1;

	}

	// paint method
	@Override
	public void paint(Graphics g) {
		if (trueorfalse) {
			if (endofgame == false) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 200, 300);
				g.setColor(Color.BLACK);
				g.drawLine(50, 50, 50, 200);// left side verticle
				g.drawLine(150, 50, 150, 200); // right side verticle
				g.drawLine(15, 90, 190, 90);// top horizontal
				g.drawLine(15, 150, 190, 150);// botton horizontal
			} else {
				/*
				 * g.setColor(getBackground()); g.drawLine(50, 50, 50, 200);//
				 * left side verticle g.drawLine(150,50, 150, 200); //right side
				 * verticle g.drawLine(15, 90, 190, 90);//top horizontal
				 * g.drawLine(15, 150, 190, 150);//botton horizontal
				 * g.drawLine(15, 90, 50, 50); g.drawLine(50,90,15, 50);
				 * g.drawOval(20, 60, 30, 30); g.drawLine(50, 50, 150, 90);
				 * g.drawLine(150,50, 50, 90); g.drawOval(80, 50, 40, 40);
				 * g.drawLine(15, 150, 50, 90); g.drawLine(15, 90, 50, 150);
				 * g.drawOval(15, 110, 30,30); g.drawLine(150,150,190,90);
				 * g.drawLine(190, 150, 150, 90); g.drawOval(160, 105, 30, 30);
				 * g.drawLine(50, 200, 15, 150); g.drawLine(50, 150, 15, 200);
				 * g.drawOval(15, 160, 30, 30); g.drawLine(50,200,150, 150);
				 * g.drawLine(150, 200, 50, 150); g.drawOval(80, 160, 40,40);
				 * g.drawLine(150, 200, 190, 150); g.drawLine(150, 150, 190,
				 * 200); g.drawOval(160,160, 30, 30); g.setColor(Color.BLACK);
				 * setBackground(Color.WHITE); g.drawLine(50, 50, 50, 200);//
				 * left side verticle g.drawLine(150,50, 150, 200); //right side
				 * verticle g.drawLine(15, 90, 190, 90);//top horizontal
				 * g.drawLine(15, 150, 190, 150);//botton horizontal
				 */
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 200, 300);
				g.setColor(Color.BLACK);
				g.drawLine(50, 50, 50, 200);// left side verticle
				g.drawLine(150, 50, 150, 200); // right side verticle
				g.drawLine(15, 90, 190, 90);// top horizontal
				g.drawLine(15, 150, 190, 150);// botton horizontal
				setupgame();
			}
			trueorfalse = false;
		} else {
			try {

				if (who.equals("0-0") && (!ZeroAndZero)) {
					if (turn) {
						g.drawLine(15, 90, 50, 50);
						g.drawLine(50, 90, 15, 50);
						game[0][0] = 1;
						ZeroAndZero = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(20, 60, 30, 30);
						game[0][0] = 2;
						ZeroAndZero = true;
						turn1 = true;
					}

					// ZeroAndZero(g);
				}
				if (who.equals("1-0") && (!OneAndZero)) {
					if (turn) {
						g.drawLine(50, 50, 150, 90);
						g.drawLine(150, 50, 50, 90);
						game[1][0] = 1;
						OneAndZero = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(80, 50, 40, 40);
						game[1][0] = 2;
						OneAndZero = true;
						turn1 = true;
						// drawoval
					}
					// ZeroAndOne(g);

				}
				if (who.equals("2-0") && (!TwoAndZero)) {
					if (turn) {
						g.drawLine(190, 90, 150, 50);
						g.drawLine(150, 90, 190, 50);
						game[2][0] = 1;
						TwoAndZero = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(160, 60, 30, 30);
						game[2][0] = 2;
						TwoAndZero = true;
						turn1 = true;
					}

					// ZeroAndTwo(g);
				}
				if (who.equals("0-1") && (!ZeroAndOne)) {
					if (turn) {
						g.drawLine(15, 150, 50, 90);
						g.drawLine(15, 90, 50, 150);
						game[0][1] = 1;
						ZeroAndOne = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(15, 110, 30, 30);
						game[0][1] = 2;
						ZeroAndOne = true;
						turn1 = true;
					}

					// OneAndZero(g);
				}
				if (who.equals("1-1") && (!OneAndOne)) {
					if (turn) {
						g.drawLine(50, 150, 150, 90);
						g.drawLine(150, 150, 50, 90);
						game[1][1] = 1;
						OneAndOne = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(80, 100, 40, 40);
						game[1][1] = 2;
						OneAndOne = true;
						turn1 = true;
					}

					// OneAndOne(g);
				}

				if (who.equals("2-1") && (!TwoAndOne)) {
					if (turn) {
						g.drawLine(150, 150, 190, 90);
						g.drawLine(190, 150, 150, 90);
						game[2][1] = 1;
						TwoAndOne = true;
						turn1 = false;
					}
					if (!turn) {

						g.drawOval(160, 105, 30, 30);
						game[2][1] = 2;
						TwoAndOne = true;
						turn1 = true;
					}

					// OneAndTwo(g);
				}
				if (who.equals("0-2") && (!ZeroAndTwo)) {
					if (turn) {
						g.drawLine(50, 200, 15, 150);
						g.drawLine(50, 150, 15, 200);
						game[0][2] = 1;
						ZeroAndTwo = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(15, 160, 30, 30);
						game[0][2] = 2;
						ZeroAndTwo = true;
						turn1 = true;
					}

					// TwoAndZero(g);
				}
				if (who.equals("1-2") && (!OneAndTwo)) {
					if (turn) {
						g.drawLine(50, 200, 150, 150);
						g.drawLine(150, 200, 50, 150);
						game[1][2] = 1;
						OneAndTwo = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(80, 160, 40, 40);
						game[1][2] = 2;
						OneAndTwo = true;
						turn1 = true;
					}

					// TwoAndOne(g);
				}
				if (who.equals("2-2") && (!TwoAndTwo)) {
					if (turn) {
						g.drawLine(150, 200, 190, 150);
						g.drawLine(150, 150, 190, 200);
						game[2][2] = 1;
						TwoAndTwo = true;
						turn1 = false;
					}
					if (!turn) {
						g.drawOval(160, 160, 30, 30);
						game[2][2] = 2;
						TwoAndTwo = true;
						turn1 = true;
					}
					// TwoAndTwo(g);
				}

			} catch (Exception e) {

			}
			gameLogic();

		}

	}

	private void gameLogic() {
		if (turn2 != turn1) {
			boolean switcher = turn;
			if (switcher) {
				turn = false;
			}
			if (!switcher) {
				turn = true;
			}
			turn2 = turn1;
		}
		if (game[0][0] != 0 && game[1][0] != 0 && game[2][0] != 0
				&& game[0][1] != 0 && game[0][2] != 0 && game[1][1] != 0
				&& game[2][1] != 0 && game[1][2] != 0 && game[2][2] != 0) {
			JOptionPane.showMessageDialog(this, "Tie game");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][0] == 1 && game[1][0] == 1 && game[2][0] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][1] == 1 && game[1][1] == 1 && game[2][1] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();

		}
		if (game[0][2] == 1 && game[1][2] == 1 && game[2][2] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][0] == 1 && game[0][1] == 1 && game[0][2] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[1][0] == 1 && game[1][1] == 1 && game[1][2] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[2][0] == 1 && game[2][1] == 1 && game[2][2] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][0] == 1 && game[1][1] == 1 && game[2][2] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[2][0] == 1 && game[1][1] == 1 && game[0][2] == 1) {
			JOptionPane.showMessageDialog(this, "X Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		// start O's
		if (game[0][0] == 2 && game[1][0] == 2 && game[2][0] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][1] == 2 && game[1][1] == 2 && game[2][1] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][2] == 2 && game[1][2] == 2 && game[2][2] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][0] == 2 && game[0][1] == 2 && game[0][2] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[1][0] == 2 && game[1][1] == 2 && game[1][2] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[2][0] == 2 && game[2][1] == 2 && game[2][2] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[0][0] == 2 && game[1][1] == 2 && game[2][2] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
		if (game[2][0] == 2 && game[1][1] == 2 && game[0][2] == 2) {
			JOptionPane.showMessageDialog(this, "O Wins");
			trueorfalse = true;
			endofgame = true;
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// true = x false = o's turn
		x = e.getX();
		y = e.getY();

		if (x >= 18 && y >= 30 && x <= 51 && y <= 70) {
			who = "0-0";
			repaint();
			// do click 0-0

		}
		if (x >= 52 && y >= 30 && x <= 150 && y <= 70) {
			who = "1-0";
			repaint();
			// do click 1-0
		}
		if (x >= 152 && y >= 30 && x <= 192 && y <= 70) {
			who = "2-0";
			repaint();
			// do click 2-0
		}
		if (x >= 16 && y >= 73 && x <= 49 && y <= 129) {
			who = "0-1";
			repaint();
			// do click 0-1
		}
		if (x >= 52 && y >= 71 && x <= 150 && y <= 129) {
			who = "1-1";
			repaint();
			// do click 1-1
		}
		if (x >= 152 && y >= 71 && x <= 192 && y <= 129) {
			who = "2-1";
			repaint();
			// do click 2-1
		}
		if (x >= 15 && y >= 132 && x <= 48 && y <= 181) {
			who = "0-2";
			repaint();
			// do click 0-2
		}
		if (x >= 52 && y >= 132 && x <= 150 && y <= 180) {
			who = "1-2";
			repaint();
			// do click 1-2
		}
		if (x >= 153 && y >= 132 && x <= 190 && y <= 176) {
			who = "2-2";
			repaint();
			// do click 2-2
		}

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
}
