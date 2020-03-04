
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Image;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Graphics g;
	String[] ButtonArray = new String[] { "��ʼ��Ϸ", "������Ϸ" };
	// ���ó�������������񡢼�϶����ʼx�����ꡢ��ʼy�����ꡢԲ�Ǿ��εĽǶȴ�С��
	final int COUNT = 4;
	final int SIZE = 100;
	final int GAP = 10;
	final int START_X = 100;
	final int START_Y = 100;
	final int BASE_ANGLE = 20;
	final int FONT_SIZE = 50;
	public int cpunter = 0;
	public int Numbers = 0;
	// String [] imgs = new String [COUNT*COUNT];
	// public int N = imgs.length;
	// �������鱣���������ݣ�
	int[][] gameData = new int[COUNT][COUNT];
//	private Image[] imgs;
	GameListener gl;

	public static void main(String[] args) {
		// �������󲢵��û�������ķ�����
		Game ga = new Game();
		ga.InUI();
	}

	// �������棬��������ķ�����
	public void InUI() {
		// ���ô������ơ���С��λ�þ��У�����ʽ���֣��ص�����Ĳ�����
		this.setTitle("2048");
		this.setSize(START_X * 2 + (GAP + SIZE) * COUNT - GAP, START_Y * 2 + (GAP + SIZE) * COUNT - GAP);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(3);
		// �Ӱ�ť
		JButton jbu1 = new JButton(ButtonArray[0]);
		jbu1.setPreferredSize(new Dimension(200, 25));
		this.add(jbu1);
		JButton jbu2 = new JButton(ButtonArray[1]);
		jbu2.setPreferredSize(new Dimension(200, 25));
		this.add(jbu2);
		// ������������Ķ���
		gl = new GameListener();
		// ��������creatRandom()������������Ϸ��ʼ�������������
		creatRandom();
		creatRandom();
		// ���ô���ɼ���
		this.setVisible(true);

		// ����Game���setG�������������ݣ�
		gl.setG(this);
		this.addKeyListener(gl);

		this.requestFocus();
	}

	// ��дpaint������
	public void paint(Graphics g) {
		// ���ø�������paint������
		super.paint(g);
		// �������飬����4��4��Բ�Ǿ��εĸ���
		for (int i = 0; i < COUNT; i++) {
			for (int j = 0; j < COUNT; j++) {
				g.setColor(new Color(0xBBADA0));
				g.fillRoundRect(START_X + (GAP + SIZE) * i, START_Y + (GAP + SIZE) * j, SIZE, SIZE, BASE_ANGLE,
						BASE_ANGLE);
				// �ػ�����ͼ��
				if (gameData[i][j] != 0) {
					g.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
					g.setColor(Color.RED);
					g.drawString(gameData[i][j] + "", START_X + i * (GAP + SIZE) + (SIZE - FONT_SIZE) / 2,
							START_Y + j * (GAP + SIZE) + (SIZE - FONT_SIZE) / 2 + 40);
				}
			}
		}

	}

	// ������������������ķ�����
	public void creatRandom() {
		// ����Random����
		Random ran = new Random();
		// ����������꣺
		int row = ran.nextInt(COUNT);
		int line = ran.nextInt(COUNT);
		// �жϵ���ά�������Ԫ�ز�Ϊ��ʱ������Ӧ����������ʱ����������������꣺
		while (gameData[row][line] != 0) {
			row = ran.nextInt(COUNT);
			line = ran.nextInt(COUNT);
		}
		// ����Ӧ�����Ԫ�ظ�ֵ��2����4��
		gameData[row][line] = ran.nextInt(2) * 2 + 2;
		// ��������������˾Ͳ��ٽ��д˷���
		gl.checkNumber();
	}
	// public void cresawimg(){
	// //ͼƬ��ŵ�Ŀ¼
	// String dirUrl = "";
	// for(int i=0; i<COUNT ; i++){
	// //ƴ��ͼƬ�ļ���
	// String imgName = dirUrl+(int)Math.pow(2, i+1)+".png";
	// //����ͼƬ���Ҵ�ŵ�������
	// imgs[i] = new ImageIcon(imgName).getImage();
	// }
	// }
}