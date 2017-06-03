package com.first;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements KeyListener, Runnable {
	private static final long serialVersionUID = 3746394797606220909L;
	
	private Map map;
	private boolean game = false;
	private Image player = new ImageIcon("res\\images\\rightdown.png").getImage();
	private Image space = new ImageIcon("res\\images\\space.png").getImage();
	private Image shift = new ImageIcon("res\\images\\shift.png").getImage();
	private Image textBox = new ImageIcon("res\\images\\speech.png").getImage();
	private Image mapImg = new ImageIcon("res\\images\\map.png").getImage();
	private Image swishImg = new ImageIcon("res\\images\\swiperight.png").getImage();
	private Image gameover = new ImageIcon("res\\images\\gameover.png").getImage();
	private Image swordImg = new ImageIcon("res\\images\\sword.png").getImage();
	private Image controlImg = new ImageIcon("res\\images\\control.png").getImage();
	private Image rodImg = new ImageIcon("res\\images\\rod.png").getImage();
	private Image lightImg = new ImageIcon("res\\images\\lightning.png").getImage();
	private Image creditImg = new ImageIcon("res\\images\\finish.png").getImage();
	private BufferedImage buffer;
	private Graphics g3;
	private byte refresh=0, refreshRate=60;
	private byte moveRef=0, moveRate=30;
	private byte step = 0;
	private boolean right = true;
	private boolean moving = false;
	private boolean[] keys = {false, false, false, false, false, false};
	private byte stage = 2;
	private Article textObject;
	private Mob textMob;
	private byte textDir = 0;
	private boolean textUp = false;
	private AudioInputStream audioInputStream;
    private Clip villageclip;
    private Clip scaryclip;
    private Clip baduzclip;
    private Clip bossclip;
	private boolean playSound = true;
	private String line1 = "";
	private String line2 = "";
	private String line3 = "";
	private String line4 = "";
	private boolean mapTop = false;
	private boolean showStrike = false;
	private boolean mapRight=false;
	private boolean swing = false;
	private boolean hasSword = false;
	private boolean hasRod = false;
	private byte soundId = 0;
	private Clip playing = null;
	private short health = 150;
	private boolean confirmBox = false;
	private boolean storyinit = false;
	private byte cutscenestage = 0 ;
	public static boolean cutscene1 = false;
	private boolean places[] = {true,true,false,false};
	private boolean bossBattle = false;
	private int rodCount = 300;
	private int bossMin = 0;
	
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		setup();
	}
	
	public void setup() {
		JFrame f = new JFrame("A Man from the Docks");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(830, 630);
		f.add(this);
		f.addKeyListener(this);
		//f.setUndecorated(true);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setFocusable(true);
		f.setVisible(true);
		
		buffer = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		g3 = buffer.getGraphics();

	    try {
	    	audioInputStream = AudioSystem.getAudioInputStream(new File("res\\audio\\villagemusic.wav").getAbsoluteFile());
			villageclip = AudioSystem.getClip();
	    	villageclip.open(audioInputStream);	

	    	audioInputStream = AudioSystem.getAudioInputStream(new File("res\\audio\\scarymusic.wav").getAbsoluteFile());
			scaryclip = AudioSystem.getClip();
	    	scaryclip.open(audioInputStream);	

	    	audioInputStream = AudioSystem.getAudioInputStream(new File("res\\audio\\baduzmusic.wav").getAbsoluteFile());
			baduzclip = AudioSystem.getClip();
	    	baduzclip.open(audioInputStream);	

	    	audioInputStream = AudioSystem.getAudioInputStream(new File("res\\audio\\bossmusic.wav").getAbsoluteFile());
			bossclip = AudioSystem.getClip();
	    	bossclip.open(audioInputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map = new Teremona();
		Point p = new Point(-40,-14);
		map.setPos(p);
		
		soundId=1;
		Thread t = new Thread(this);
		t.start();
		Thread d = new Thread(this);
		d.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(buffer, 0, 0, null);
	}
	public void update(Graphics g) {
		paint(g);
	}
	
	public void make() {
		g3.setColor(Color.BLACK);
		g3.fillRect(0,0,800,600);
		if(stage==1) {
			g3.drawImage(mapImg, 0, 0,  null);
			g3.setColor(Color.RED);
			if(mapTop && mapRight) {
				g3.fillRect(700, 100, 30, 30);
			}else if(!mapTop && mapRight) {
				g3.fillRect(700, 500, 30, 30);
			}else if(mapTop && !mapRight) {
				g3.fillRect(180, 100, 30, 30);
			}else if(!mapTop && !mapRight) {
				g3.fillRect(100, 500, 30, 30);
			}
		}
		else if(stage==2 || stage==3) {
			ArrayList<Article> articles = map.getGraph();
			for(int i=0; i<articles.size(); i++) {
				Point p = new Point(articles.get(i).getX(),articles.get(i).getX());
				if(p.x<800 || p.x+256>0 || p.y+256>0 || p.y<500)
				g3.drawImage(articles.get(i).getImage(), articles.get(i).getX(), articles.get(i).getY(), articles.get(i).getImage().getWidth(null)*2, articles.get(i).getImage().getHeight(null)*2, null);
			}
			ArrayList<Mob> mobs = map.getMob();
			for(int i=0; i<mobs.size(); i++) {
				Point p = new Point(mobs.get(i).getX(),mobs.get(i).getX());
				if(p.x<800 || p.x+256>0 || p.y+256>0 || p.y<500)
				g3.drawImage(mobs.get(i).getImage(), mobs.get(i).getX(), mobs.get(i).getY(), mobs.get(i).getImage().getWidth(null)*2, mobs.get(i).getImage().getHeight(null)*2, null);
			}
			
			
			
			
			if(showStrike) {
				g3.drawImage(lightImg, 375, 0, 50, 310, null);
			}
			g3.drawImage(player, 392, 292, 32, 64, null);
			
			if(swing){
				if(right) g3.drawImage(swishImg, 416, 292, 32, 64, null);
				else g3.drawImage(swishImg, 376, 292, 32, 64, null);
			}
			step++;
			g3.drawImage(controlImg, 480, 10, null);
			if(hasRod)g3.drawImage(rodImg, 500, 50, 32, 32, null);
			g3.drawImage(space, 580, 10, null);
			if(hasSword)g3.drawImage(swordImg, 600, 50, 32, 32, null);
			g3.drawImage(shift, 680, 10, null);
			g3.setFont(new Font("TimesRoman", Font.BOLD, 18));
			if(textMob!=null) {
				g3.setColor(Color.MAGENTA);
				g3.fillRoundRect(700, 57, 62, 43, 10, 10);
				g3.setColor(Color.WHITE);
				g3.drawString("Talk", 710, 80);
			}
			if(textObject!=null && textObject!=null) {
				if((textObject.getName().equals("house") && textDir==1) || (textObject.getId()==19) || (textObject.getName().equals("shop") && textDir==1)) {
					g3.setColor(Color.MAGENTA);
					g3.fillRoundRect(700, 57, 62, 43, 10, 10);
					g3.setColor(Color.WHITE);
					g3.drawString("Open", 710, 80);
				}
				if(textObject!=null && textObject.getName().equals("voiddoor")) {
					g3.setColor(Color.MAGENTA);
					g3.fillRoundRect(700, 57, 62, 43, 10, 10);
					g3.setColor(Color.WHITE);
					g3.drawString("Back", 710, 80);
				}
				if(textObject!=null && textObject.getName().equals("mark") && hasSword) {
					g3.setColor(Color.MAGENTA);
					g3.fillRoundRect(700, 57, 62, 43, 10, 10);
					g3.setColor(Color.WHITE);
					g3.drawString("Leave", 710, 80);
				}
				if(textObject!=null && textObject.getName().equals("sign")) {
					g3.setColor(Color.MAGENTA);
					g3.fillRoundRect(700, 57, 62, 43, 10, 10);
					g3.setColor(Color.WHITE);
					g3.drawString("Read", 710, 80);
				}
				if(textObject!=null && textObject.getName().equals("inscription")) {
					g3.setColor(Color.MAGENTA);
					g3.fillRoundRect(700, 57, 62, 43, 10, 10);
					g3.setColor(Color.WHITE);
					g3.drawString("Read", 710, 80);
				}
			}
			if(textUp) {
				g3.drawImage(textBox, 150, 350, null);
				g3.setColor(Color.WHITE);
				g3.drawString(line1, 190, 450);
				g3.drawString(line2, 190, 470);
				g3.drawString(line3, 190, 490);
				g3.drawString(line4, 190, 510);
			}
			
			
			if(health<20) {
				g3.setFont(new Font("TimesRoman", Font.BOLD, 22));
				g3.setColor(Color.RED);
			}else {
				g3.setColor(Color.WHITE);
			}
			g3.drawString("Health: " + health, 10, 20);
			if(stage==3) {
				g3.drawImage(gameover, 0, 0, null);
				game=false;
			}
		}
		if(stage == 4) {
			g3.drawImage(creditImg, 0, 0, null);
		}
		repaint();
	}
	
	
	
	
	
	
	
	
	public void run() {
		if(playSound) {
			playSound=false;
			if(soundId==1) {
				loopSound(villageclip);
			}
			if(soundId==2) {
				loopSound(scaryclip);
			}
			if(soundId==3) {
				loopSound(baduzclip);
			}
			if(soundId==4) {
				loopSound(bossclip);
			}
			if(soundId==5) {
				playSound("ting");
			}
			if(soundId==6) {
				playSound("swing");
			}
			if(soundId==7) {
				playSound("speech");
			}
			if(soundId==8) {
				playSound("lightning");
			}
		}else if(!game) {
			game=true;
			while(game) {
				if(health<=0) {
					stage=3;
				}
				
				if(cutscene1 && cutscenestage==0) {
					shoutOut("Sarah: Declin! Help Me!");
					cutscenestage+=2;
				}
				if(refresh>=refreshRate) {
					make();
					swing=false;
					refresh=0;
					if(hasRod)rodCount++;
					showStrike = false;
				}
				refresh++;
				if(bossBattle) {
					bossMin++;
					if(bossMin>=3000) {
						map.activate(null);
						bossMin = 0;
					}
				}
				if(moveRef>=moveRate) {
					if(!textUp && stage==2)move();
					moveRef=0;
				}
				moveRef++;
				
				try {
					Thread.sleep(1);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(stage==2) {
			if(keyCode==KeyEvent.VK_W) {
				keys[0]=true;
				if(textDir!=1) {
					textMob=null;
					textObject = null;
				}
			}
			if(keyCode==KeyEvent.VK_S) {
				keys[1]=true;
				if(textDir!=2) {
					textMob=null;
					textObject = null;
				}
			}
			if(keyCode==KeyEvent.VK_A) {
				keys[2]=true;
				if(textDir!=3) {
					textMob=null;
					textObject = null;
				}
			}
			if(keyCode==KeyEvent.VK_D) {
				keys[3]=true;
				if(textDir!=4) {
					textMob=null;
					textObject = null;
				}
			}
			if(keyCode==KeyEvent.VK_ENTER) {
			}
			if(keyCode==KeyEvent.VK_SPACE) {
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(confirmBox) {
			if(keyCode==KeyEvent.VK_SPACE) {
				map.activate(textObject);
				confirmBox=false;
				textObject=null;
				textUp=false;
				return;
			}
		}
		if(cutscene1) {
			if(keyCode==KeyEvent.VK_SHIFT) {
				if(cutscenestage==1){
				}else if(cutscenestage==2) {
					shoutOut("Ian: You cannot ever stop me now that I have the key to e-nd all of reality.");
					cutscenestage++;
				}else if(cutscenestage==3) {
					shoutOut("Professor: You lunatic! You will never get way with this!");
					cutscenestage++;
					storyinit=true;
					cutscene1=false;
					map.activate(null);
				}
			}
			return;
		}
		if(stage==1) {
			if(keyCode==KeyEvent.VK_W) {
				mapTop = true;
			}
			if(keyCode==KeyEvent.VK_S) {
				mapTop=false;
			}
			if(keyCode==KeyEvent.VK_A) {
				mapRight = false;
			}
			if(keyCode==KeyEvent.VK_D) {
				mapRight = true;
			}
			if(keyCode==KeyEvent.VK_SHIFT) {
				
				villageclip.stop();
				baduzclip.stop();
				scaryclip.stop();
				bossclip.stop();
				playing.stop();
				if(mapTop && mapRight && places[2]) {
					map = new Cascade();
					map.setPos(new Point(-2,-14));				
					shoutOut("Edward: Oh Bollocks! Those rocks have sunk us. I guess you better take care of these jokers!");
					soundId=2;
				}
				else if(!mapTop && mapRight) {
					map = new Baduz();
					map.setPos(new Point(-28,6));
					soundId=3;
				}
				else if(!mapTop && !mapRight) {
					map = new Teremona();
					map.setPos(new Point(-53,-40));
					soundId=1;
				}
				else if(mapTop && !mapRight && places[3]) {
					map = new Dome();
					map.setPos(new Point(-1,4));
					soundId=4;
				}
				playSound = true;
				Thread t = new Thread(this);
				t.start();
				stage=2;					
				if(soundId == 2) {
				}
				
			}
		}else if(stage==2) {
			if(keyCode==KeyEvent.VK_W) {
				keys[0]=false;
			}
			if(keyCode==KeyEvent.VK_S) {
				keys[1]=false;
			}
			if(keyCode==KeyEvent.VK_A) {
				keys[2]=false;
			}
			if(keyCode==KeyEvent.VK_D) {
				keys[3]=false;
			}
			if(keyCode==KeyEvent.VK_SPACE) {
				if(hasSword) swing();
			}		
			if(keyCode==KeyEvent.VK_CONTROL  && hasRod) {
				if(rodCount>=200) {
					showStrike = true;
					playSound=true;
					soundId=8;
					Thread d = new Thread(this);
					d.start();
					strike();
					rodCount = 0;
				}
			}
			if(keyCode==KeyEvent.VK_SHIFT) {
				if(textUp) {
					confirmBox=false;
					textUp=false;
				}
				else if(textMob!=null || textObject!=null){
					if(!textUp && textObject!=null && ((textObject.getName()=="house" && textDir==1)
							|| (textObject!=null && textObject.getName().equals("shop") && textDir==1))) {
						map = textObject.activate();
						textObject=null;
					}
					if(textObject!=null && textObject.getName().equals("mark") && hasSword)	{
						textObject=null;
						stage=1;
					}
					if((textObject!=null && textObject.getName().equals("voiddoor"))) {
						map = textObject.activate();
						textObject=null;
					}
					if(textObject!=null && textObject.getName().equals("sign"))	{
						shoutOut(textObject.getMessage());
						textObject=null;
					}
					if(textObject!=null && textObject.getName().equals("inscription"))	{
						confirmBox = true;
						shoutOut(textObject.getMessage());
					}
					if(!textUp && textObject!=null && textObject.getId()==19) {
						if(storyinit) {
							map = textObject.activate();
							textObject=null;
						}
						else shoutOut("It's Locked");
					}
					
					if(!textUp && textMob!=null) {
						if(textMob.getName()=="king" && !hasSword) {
							hasSword=true;
						}
						if(textMob.getName()=="edward") {
							places[2] = true;
						}
						if(textMob.getName()=="ian") {
							bossBattle=true;
							map = new Battle();
							map.setPos(new Point(10, 9));
						}
						if(textMob.getName()=="guardian") {
							textMob.hurt = true;
						}
						shoutOut(textMob.getMessage());
					}
				}
			}
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void move() {
		
		moving = false;
		byte dx = 0, dy = 0;
		if(keys[0]==true) {
			dy += (byte) 8;
			moving = true;
		}if(keys[1]==true) {
			dy -= (byte) 8;
			moving = true;
		}if(keys[2]==true) {
			dx += (byte) 8;
			right=false;
			moving = true;
		}if(keys[3]==true) {
			dx -= (byte) 8;
			right=true;
			moving = true;
		}if(keys[4]==true) {
			
		}else if(keys[5]==true) {
			
		}
		if(collide(dx,dy)) { 
			ArrayList<Article> articles = map.getGraph();
			for(int i=0; i<articles.size(); i++) {
				articles.get(i).setPos(new Point(dx,dy));
			}
			
			ArrayList<Mob> mobs = map.getMob();
			for(int i=0; i<mobs.size(); i++) {
				mobs.get(i).setPos(new Point(dx,dy));
			}
			if(!(dx==0 && dy==0)) {
				textObject=null;
				textMob=null;
			}
		}

		ArrayList<Mob> mobs = map.getMob();
		for(int i=0; i<mobs.size(); i++) {
			if(mobs.get(i).hurt) {
				mobs.get(i).activate();
			}
		}
		if(moving) {
			if(right) {
				if(step==0) {
					player = new ImageIcon("res\\images\\rightdown.png").getImage();
				}else if(step==1) {
					player = new ImageIcon("res\\images\\rightlup.png").getImage();
				}else if(step==2) {
					player = new ImageIcon("res\\images\\rightdown.png").getImage();
				}else if(step==3) {
					step = -1;
					player = new ImageIcon("res\\images\\rightrup.png").getImage();
				}
				swishImg = new ImageIcon("res\\images\\swiperight.png").getImage();
			}else {
				if(step==0) {
					player = new ImageIcon("res\\images\\leftdown.png").getImage();
				}else if(step==1) {
					player = new ImageIcon("res\\images\\leftlup.png").getImage();
				}else if(step==2) {
					player = new ImageIcon("res\\images\\leftdown.png").getImage();
				}else if(step==3) {
					step = -1;
					player = new ImageIcon("res\\images\\leftrup.png").getImage();
				}
				swishImg = new ImageIcon("res\\images\\swipeleft.png").getImage();
			}
		}else {
			step=-1;
			if(right) {
				player = new ImageIcon("res\\images\\rightdown.png").getImage();
			}else {
				player = new ImageIcon("res\\images\\leftdown.png").getImage();
			}
		}
	}
	private boolean collide(byte dx, byte dy) {
		ArrayList<Article> arts = map.getGraph();
		for(int i=0; i<arts.size(); i++) {
			Point p = new Point(arts.get(i).getX(),arts.get(i).getX());
			if(p.x<500 || p.x>200 || p.y>200 || p.y<400) {
				if(arts.get(i).getX()==416 && arts.get(i).getY()<296+64 && arts.get(i).getY()+(arts.get(i).getImage().getHeight(null)*2)>(312)+32 && arts.get(i).collide && dx<-1) {
					textObject = arts.get(i);
					textDir=4;
					return false;
				}
				if(arts.get(i).getX()+(arts.get(i).getImage().getWidth(null)*2)==392 && arts.get(i).getY()<296+64 && arts.get(i).getY()+(arts.get(i).getImage().getHeight(null)*2)>(312)+32 && arts.get(i).collide && dx>1) {
					textObject = arts.get(i);
					textDir=2;
					return false;
				}
				if(arts.get(i).getY()==296+64 && arts.get(i).getX()<416 && arts.get(i).getX()+(arts.get(i).getImage().getWidth(null)*2)>392 && arts.get(i).collide && dy<-1) {
					textObject = arts.get(i);
					textDir=3;
					return false;
				}
				if(arts.get(i).getY()+(arts.get(i).getImage().getHeight(null)*2)==312+32 && arts.get(i).getX()<416 && arts.get(i).getX()+(arts.get(i).getImage().getWidth(null)*2)>392 && arts.get(i).collide && dy>1) {
					textObject = arts.get(i);
					textDir=1;
					return false;
				}
			}
		}
		ArrayList<Mob> mobs = map.getMob();
		for(int i=0; i<mobs.size(); i++) {
			Point p = new Point(mobs.get(i).getX(),mobs.get(i).getX());
			if(p.x<800 || p.x+256>0 || p.y+256>0 || p.y<500){
				if(mobs.get(i).getX()==416 && mobs.get(i).getY()<296+64 && mobs.get(i).getY()+(mobs.get(i).getImage().getHeight(null)*2)>(312)+32 && dx<-1) {
					if(!mobs.get(i).hurt) {
						textMob = mobs.get(i);
						textDir = 4;
						return false;
					}else {
						health-=5;
					}
				}
				if(mobs.get(i).getX()+(mobs.get(i).getImage().getWidth(null)*2)==392 && mobs.get(i).getY()<296+64 && mobs.get(i).getY()+(mobs.get(i).getImage().getHeight(null)*2)>(312)+32 && dx>1) {
					if(!mobs.get(i).hurt) {
						textMob = mobs.get(i);
						textDir = 2;
					}else {
						health-=5;
					}
					
					return false;
				}
				if(mobs.get(i).getY()==296+64 && mobs.get(i).getX()<416 && mobs.get(i).getX()+(mobs.get(i).getImage().getWidth(null)*2)>392 && dy<-1) {
					if(!mobs.get(i).hurt) {
						textMob = mobs.get(i);
						textDir = 3;
					}
					return false;
				}
				if(mobs.get(i).getY()+(mobs.get(i).getImage().getHeight(null)*2)==312+32 && mobs.get(i).getX()<416 && mobs.get(i).getX()+(mobs.get(i).getImage().getWidth(null)*2)>392 && dy>1) {
					if(!mobs.get(i).hurt) {
						textMob = mobs.get(i);
						textDir = 1;
					}
					return false;
				}
				if(mobs.get(i).getY()+(mobs.get(i).getImage().getHeight(null)*2)>=290 && mobs.get(i).getY()<=292+64 && mobs.get(i).getX()<=392+40 && mobs.get(i).getX()+(mobs.get(i).getImage().getWidth(null)*2)>=390) {
					if(mobs.get(i).hurt) {
						if(mobs.get(i).getName()=="fireball") {
							health-=10;
							mobs.remove(i);
							return false;
						}
						else health-=2;
						mobs.get(i).reboundHalf();
						return false;
					}
				}
				if(mobs.get(i).getName()=="fireball") {
					if(mobs.get(i).getY()>=600) {
						mobs.remove(i);
					}
				}
			}
		}
		return true;
	}
	
	public void shoutOut(String message) {
		textUp=true;
		playSound=true;
		soundId=7;
		Thread t = new Thread(this);
		t.start(); 
		if(message.length()>(58*3)) {
			line1 = message.substring(0, 58);
			line2 = message.substring(58, (58*2));
			line3 = message.substring(58*2, (58*3));
			line4 = message.substring(58*3);
		}else if(message.length()>(58*2)) {
			line1 = message.substring(0, 58);
			line2 = message.substring(58, (58*2));
			line3 = message.substring(58*2);
			line4="";
		}else if(message.length()>58) {
			line1 = message.substring(0, 58);
			line2 = message.substring(58);
			line3="";
			line4="";
		}else {
			line1 = message;
			line2 = "";
			line3="";
			line4="";
		}
	}
	private void swing() {
		swing=true;
		if(right) {
			ArrayList<Mob> mobs = map.getMob();
			for(int i=0; i<mobs.size(); i++) {
				Point p = new Point(mobs.get(i).getX(),mobs.get(i).getX());
				if(p.x<800 || p.x+256>0 || p.y+256>0 || p.y<500){
					if(mobs.get(i).getX()+(mobs.get(i).getImage().getWidth(null)*2)>=380 && mobs.get(i).getX()<=480 && mobs.get(i).getY()<300+64 && mobs.get(i).getY()+(mobs.get(i).getImage().getHeight(null)*2)>(280)+32) {
						if(mobs.get(i).hurt)  {
							playSound=true;
							soundId=6;
							Thread t = new Thread(this);
							t.start();
							mobs.get(i).damage(); 
						}
						if(mobs.get(i).getHealth()<=0) {
							if(mobs.get(i).getName()=="guardian") {
								hasRod=true;
								shoutOut("You got Falgoric's Rod. Press CTRL to use. Must charge up between uses.");
								map.activate(null);
								places[3] = true;
							}
							mobs.remove(i);
						}
						return;
					}
				}
			}
		}else {
			ArrayList<Mob> mobs = map.getMob();
			for(int i=0; i<mobs.size(); i++) {
				Point p = new Point(mobs.get(i).getX(),mobs.get(i).getX());
				if(p.x<800 || p.x+256>0 || p.y+256>0 || p.y<500){
					if(mobs.get(i).getX()<=460 && mobs.get(i).getX()+(mobs.get(i).getImage().getWidth(null)*2)>=340 && mobs.get(i).getY()<300+64 && mobs.get(i).getY()+(mobs.get(i).getImage().getHeight(null)*2)>(280)+32) {
						if(mobs.get(i).hurt) {
							playSound=true;
							soundId=6;
							Thread t = new Thread(this);
							t.start();
							mobs.get(i).damage(); 
						}
						if(mobs.get(i).getHealth()<=0) {
							if(mobs.get(i).getName()=="guardian") {
								hasRod=true;
								shoutOut("You got Falgoric's Rod. Press CTRL to use. Must charge up between uses. You can use it to fly around the world as well.");
								map.activate(null);
								places[3] = true;
							}
							mobs.remove(i);
						}
						return;
					}
				}
			}
		}

		playSound=true;
		soundId=5;
		Thread d = new Thread(this);
		d.start();
	}
	 public void playSound(String c){
		 Clip temp = playing;
		 playing.stop();
		 
		  try{
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res\\audio\\" + c + ".wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        playing = clip;
		    }catch(Exception ex){
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		  playing.loop(0);
		  loopSound(temp); 
	  }
	 public void loopSound(Clip clip){
		 playing = clip;
		  try{
		        playing.loop(Clip.LOOP_CONTINUOUSLY);
		    }catch(Exception ex){
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	  }
	 public void strike() {
			ArrayList<Mob> mobs = map.getMob();
			for(int i=0; i<mobs.size(); i++) {
				Point p = new Point(mobs.get(i).getX(),mobs.get(i).getY());
				if(p.x<420 && p.x+32>380 && p.y+64>0 && p.y<300) {
					if(mobs.get(i).hurt)  {
						mobs.get(i).strikedamage();
						if(mobs.get(i).getHealth()<=0) {				
							if(mobs.get(i).getName().equals("ian")) {
								stage = 4;
							}
							mobs.remove(i);
						}
					}
				}
			}
	 }
}
