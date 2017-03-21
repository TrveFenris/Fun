package window;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2072929603035892143L;
	private JPanel contentPane;
	private static Random rX = new Random();
	private static Random rY = new Random();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				new MainWindow().setVisible(true);
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		int wWidth = 200, wHeight = 72;
		setBounds(rX.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width - wWidth), rY.nextInt(Toolkit.getDefaultToolkit().getScreenSize().height - wHeight), wWidth, wHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainWindow().setVisible(true);
			}
		});
		btnClose.setBounds(52, 10, 89, 23);
		contentPane.add(btnClose);
	}
}