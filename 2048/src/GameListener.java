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
			//将数字上移加相加
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
				//记录当前位置的数字
				int curNumber = gameData[i][j];
				//如果为零就跳过继续循环
				if (curNumber == 0){
					continue;
				}
				for (int k = j+1; k<COUNT;k++){
					//如果是空位就跳过
					if (gameData[i][k]==0){
						continue;
					}
					//如果是相同数字就相加
					if (gameData[i][k]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[i][k] = 0;
						break;
					}
					//如果是不同数字就结束
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
				//如果是空的则跳过继续循环
				if (gameData[i][j]==0){
					continue;
				}
				//如果不是空位则向上查找到最近的一个非空位
				for (int k=j-1;k>=0;k--){
					//当向上查找是遇到的是非空位：
					if (gameData[i][k]==0){
						if (k == 0){
							gameData[i][k]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//如果遇到的是数字则在k+1的位置停下来，并交换K+1位置和j位置的值（在竖直方向上）
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
				//记录当前位置的数字
				int curNumber = gameData[i][j];
				//如果为零就跳过继续循环
				if (curNumber == 0){
					continue;
				}
				for (int k = j-1; k>=0;k--){
					//如果是空位就跳过
					if (gameData[i][k]==0){
						continue;
					}
					//如果是相同数字就相加
					if (gameData[i][k]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[i][k] = 0;
						break;
					}
					//如果是不同数字就结束
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
				//如果是空的则跳过继续循环
				if (gameData[i][j]==0){
					continue;
				}
				//如果不是空位则向下查找到最近的一个非空位
				for (int k=j+1;k<COUNT;k++){
					//当向下查找是遇到的是非空位：
					if (gameData[i][k]==0){
						if (k == COUNT-1){
							gameData[i][k]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//如果遇到的是数字就在k-1的位置停下来，并交换K-1位置和j位置的值（在竖直方向上）
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
				//记录当前位置的数字
				int curNumber = gameData[i][j];
				//如果为零就跳过继续循环
				if (curNumber == 0){
					continue;
				}
				for (int k = i+1; k<COUNT;k++){
					//如果是空位就跳过
					if (gameData[k][j]==0){
						continue;
					}
					//如果是相同数字就相加
					if (gameData[k][j]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[k][j] = 0;
						break;
					}
					//如果是不同数字就结束
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
				//如果是空的则跳过继续循环
				if (gameData[i][j]==0){
					continue;
				}
				//如果不是空位则向左查找到最近的一个非空位
				for (int k=i-1;k>=0;k--){
					//当向左查找是遇到的是非空位：
					if (gameData[k][j]==0){
						if (k == 0){
							gameData[k][j]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//如果遇到的是数字就在k+1的位置停下来，并交换K+1位置和j位置的值（在竖直方向上）
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
				//记录当前位置的数字
				int curNumber = gameData[i][j];
				//如果为零就跳过继续循环
				if (curNumber == 0){
					continue;
				}
				for (int k = i-1; k>=0;k--){
					//如果是空位就跳过
					if (gameData[k][j]==0){
						continue;
					}
					//如果是相同数字就相加
					if (gameData[k][j]==gameData[i][j]){
						gameData[i][j] = gameData[i][j]*2;
						gameData[k][j] = 0;
						break;
					}
					//如果是不同数字就结束
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
				//如果是空的则跳过继续循环
				if (gameData[i][j]==0){
					continue;
				}
				//如果不是空位则向右查找到最近的一个非空位
				for (int k=i+1;k<COUNT;k++){
					//当向右查找是遇到的是非空位：
					if (gameData[k][j]==0){
						if (k == COUNT-1){
							gameData[k][j]=gameData[i][j];
							gameData[i][j]=0;
						}
						continue;
					}else{//如果遇到的是数字就在k-1的位置停下来，并交换K-1位置和j位置的值（在竖直方向上）
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
		JOptionPane.showMessageDialog(ga, "游戏结束啦!"+"\n您输了 再接再厉哟！");
	}
}
