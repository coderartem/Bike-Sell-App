import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.Box;
import java.awt.Dimension;


public class BikesApp implements ActionListener {

	JButton b = new JButton("СДЕЛАТЬ ЗАКАЗ");
	JPanel p []=new JPanel[3];
	JLabel []l = new JLabel[p.length];
	String []lm={"Выберите Марку Велосипеда","Выберите количество",""};
	JFrame fr = new JFrame();
	JFormattedTextField [] tx =new JFormattedTextField[p.length];
	int i = 0;
	String gde;
	
	BikesApp (){
		
		for (i=0;i<p.length;i++){
			p[i]=new JPanel();
			l[i]=new JLabel(lm[i]);
			p[i].setLayout(new BorderLayout());
			tx[i]=new JFormattedTextField();
		}
		b.addActionListener(this);
	
		 p[0].add("North",l[0]);
		 p[0].add(Box.createRigidArea(new Dimension(20,100)));
		 p[0].add("Center",tx[0]);
		 p[1].add("North",l[1]);
		 p[1].add(Box.createRigidArea(new Dimension(0,5)));
		 p[1].add("Center",tx[1]);
		 p[2].add("Center",p[1]);
		 p[2].add("South", b);
		  p[2].add("North", p[0]);

		
		 		
		fr.setContentPane(p[2]);
		fr.pack();
		fr.setVisible(true);
	}
	
	public void actionPerformed (ActionEvent evt){
		JButton nz = (JButton) evt.getSource();
		
		if (nz==b){
			int x = Integer.parseInt(tx[1].getText());
		try{
			checkOrder(x);
			JOptionPane.showConfirmDialog(null,"Важ заказ принят! Ваш(и) велосипед(ы) в машине "+ gde,"Подтверждение",JOptionPane.PLAIN_MESSAGE);
		} catch (TooMuch tm){
			JOptionPane.showConfirmDialog(null,tm.getMessage(),"Ошибка",JOptionPane.PLAIN_MESSAGE);
		}}
	}
	
	void checkOrder(int x1) throws TooMuch{
		String [] ccc = {"Справа","По центру","Слева"};
		gde="";
		try{
		
		for (i=0;i<x1;i++){
			gde=gde+" / "+ccc[i];
		}
		} catch (Exception e){
		/*if (x1<4){
			System.out.println("Продали "+x1+"великов");
		}else {
			System.out.println("Слишком большой заказ");*/
			throw new TooMuch ("Мы не можем доставить за один раз велосипеды в количестве "+x1+"! Максимум 3");
		//}
	}
	}
	
	public static void main (String[]args){
		new BikesApp();
	}
}

 class TooMuch extends Exception{
	TooMuch(String m){
		super(m);
	}
}
