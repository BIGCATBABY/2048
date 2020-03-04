import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class GameListener implements KeyListener {
	private int [][] gameData;
	Game ga;
	int COUNT ;
	int SIZE ;
	int GAP ;
	int START_X ;
	int START_Y ;
	int BASE_ANGLE ;
	int FONT_SIZE ;
	int counter;
	int Numbers;
	int flag = 0;

	public void setG(Game game){
		this.ga =game;
		gameData = game.gameData;
		COUNT = game.COUNT;
		SIZE = game.SIZE;
		Numbers = game.Numbers;
	}
	public void keyTyped(KeyEvent e) {
	
	}
	public void keyPressed(KeyEvent e) {
		
		
	}

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W ){
			//���������Ƽ����
			keyup();
			stringup();
			checkNumber();
			if (Numbers == 16){
				check();
				if(flag==1){
				showMessage();
				}
			}
			if (Numbers<16){
			ga.creatRandom();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S){
			keydown();
			stringdown();
			checkNumber();
			if (Numbers == 16){
				check();
				if(flag==1){
				showMessage();
				}
			}
			if (Numbers<16){
			ga.creatRandom();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A){
			keyleft();
			stringleft();
			checkNumber();
			if (Numbers == 16){
				check();
				if(flag==1){
				showMessage();
				}
			}
			if (Numbers<16){
			ga.creatRandom();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D){
			keyright();
			stringright();
			checkNumber();
			if (Numbers == 16){
				check();
				if(flag==1){
				showMessage();
				}
			}
			if (Numbers<16){
			ga.creatRandom();
			}
		}
	}
	public void keyup(){
		for (int i = 0; i<COUNT;i++){
			for (int j =0; j<COUNT;j++){
				//��¼��ǰλ�õ�����
				int curNumber = gameData[i][j];
				//���Ϊ�����������ѭ��
				if (curNumber == 0){
					continue;
				}
				for (int k = j+1; k<COUNT;k++){
					//����ǿ�λ������
					if (gameData[i][k]==0){
						continue;
					}
					//�������ͬ���־����
					if (gameData[i][k]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[i][k] = 0;
						break;
					}
					//����ǲ�ͬ���־ͽ���
					else{
						break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void stringup(){
		for (int i=0;i<COUNT;i++){
			for (int j=0;j<COUNT;j++){
				//����ǿյ�����������ѭ��
				if (gameData[i][j]==0){
					continue;
				}
				//������ǿ�λ�����ϲ��ҵ������һ���ǿ�λ
				for (int k=j-1;k>=0;k--){
					//�����ϲ������������Ƿǿ�λ��
					if (gameData[i][k]==0){
						if (k == 0){
							gameData[i][k]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//�������������������k+1��λ��ͣ������������K+1λ�ú�jλ�õ�ֵ������ֱ�����ϣ�
						int temp = gameData[i][j];						
    					gameData[i][j] = 0;
    					gameData[i][k+1] = temp;
    					break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void keydown(){
		for (int i = 0; i<COUNT;i++){
			for (int j =0; j<COUNT;j++){
				//��¼��ǰλ�õ�����
				int curNumber = gameData[i][j];
				//���Ϊ�����������ѭ��
				if (curNumber == 0){
					continue;
				}
				for (int k = j-1; k>=0;k--){
					//����ǿ�λ������
					if (gameData[i][k]==0){
						continue;
					}
					//�������ͬ���־����
					if (gameData[i][k]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[i][k] = 0;
						break;
					}
					//����ǲ�ͬ���־ͽ���
					else{
						break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void stringdown(){
		for (int i=0;i<COUNT;i++){
			for (int j=COUNT-1;j>=0;j--){
				//����ǿյ�����������ѭ��
				if (gameData[i][j]==0){
					continue;
				}
				//������ǿ�λ�����²��ҵ������һ���ǿ�λ
				for (int k=j+1;k<COUNT;k++){
					//�����²������������Ƿǿ�λ��
					if (gameData[i][k]==0){
						if (k == COUNT-1){
							gameData[i][k]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//��������������־���k-1��λ��ͣ������������K-1λ�ú�jλ�õ�ֵ������ֱ�����ϣ�
						int temp = gameData[i][j];						
    					gameData[i][j] = 0;
    					gameData[i][k-1] = temp;
    					break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void keyleft(){
		for (int i = 0; i<COUNT;i++){
			for (int j =0; j<COUNT;j++){
				//��¼��ǰλ�õ�����
				int curNumber = gameData[i][j];
				//���Ϊ�����������ѭ��
				if (curNumber == 0){
					continue;
				}
				for (int k = i+1; k<COUNT;k++){
					//����ǿ�λ������
					if (gameData[k][j]==0){
						continue;
					}
					//�������ͬ���־����
					if (gameData[k][j]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[k][j] = 0;
						break;
					}
					//����ǲ�ͬ���־ͽ���
					else{
						break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void stringleft(){
		for (int i=0;i<COUNT;i++){
			for (int j=0;j<COUNT;j++){
				//����ǿյ�����������ѭ��
				if (gameData[i][j]==0){
					continue;
				}
				//������ǿ�λ��������ҵ������һ���ǿ�λ
				for (int k=i-1;k>=0;k--){
					//������������������Ƿǿ�λ��
					if (gameData[k][j]==0){
						if (k == 0){
							gameData[k][j]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//��������������־���k+1��λ��ͣ������������K+1λ�ú�jλ�õ�ֵ������ֱ�����ϣ�
						int temp = gameData[i][j];						
    					gameData[i][j] = 0;
    					gameData[k+1][j] = temp;
    					break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void keyright(){
		for (int i = COUNT-1; i>=0;i--){
			for (int j =0; j<COUNT;j++){
				//��¼��ǰλ�õ�����
				int curNumber = gameData[i][j];
				//���Ϊ�����������ѭ��
				if (curNumber == 0){
					continue;
				}
				for (int k = i-1; k>=0;k--){
					//����ǿ�λ������
					if (gameData[k][j]==0){
						continue;
					}
					//�������ͬ���־����
					if (gameData[k][j]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[k][j] = 0;
						break;
					}
					//����ǲ�ͬ���־ͽ���
					else{
						break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void stringright(){
		for (int i=COUNT-1;i>=0;i--){
			for (int j=0;j<COUNT;j++){
				//����ǿյ�����������ѭ��
				if (gameData[i][j]==0){
					continue;
				}
				//������ǿ�λ�����Ҳ��ҵ������һ���ǿ�λ
				for (int k=i+1;k<COUNT;k++){
					//�����Ҳ������������Ƿǿ�λ��
					if (gameData[k][j]==0){
						if (k == COUNT-1){
							gameData[k][j]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//��������������־���k-1��λ��ͣ������������K-1λ�ú�jλ�õ�ֵ������ֱ�����ϣ�
						int temp = gameData[i][j];						
    					gameData[i][j] = 0;
    					gameData[k-1][j] = temp;
    					break;
					}
				}
			}
		}
		ga.repaint(0);
	}
	public void check(){
		for (int i =0;i<COUNT-1;i++){
			for (int j =0;j<COUNT-1;j++){
				if(gameData[i][j]!=gameData[i+1][j]&&gameData[i][j+1]!=gameData[i][j]){
					flag = 1;
				}else{
					flag = 0;
				}
			}
		}
	}
	public void checkNumber(){
		Numbers = 0;
		for (int i =0;i<COUNT;i++){
			for (int j =0;j<COUNT;j++){
				if(gameData[i][j]!=0){
					Numbers++;
				}
			}
		}
	}
	public void showMessage(){
		JOptionPane.showMessageDialog(ga, "��Ϸ������!"+"\n������ �ٽ�����Ӵ��");
	}
}
