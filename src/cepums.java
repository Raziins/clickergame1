import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
public class cepums {  
    static int cepumi=0;
    static int cepumiplus=1;
    static int cena1=20;
public static void main(String[] args) {  


//UZTAISA FRAME
    Frame f=new Frame("clicker game"); 
    f.setSize(400,400);  
    f.setLayout(null);                         
    f.setVisible(true); 

//LABEL PRIEKS CEPUMU(NAUDAS) DAUDZUMA
    JLabel nauda;
    nauda=new JLabel();
    nauda.setBounds(500,20, 300,90);
    nauda.setFont(new Font("cepumuteksts", Font.BOLD, 35));
    f.add(nauda);
    
//GALVENA CEPUMA POGA UN VISAS PAREJAS VEIKALA POGAS
    JButton b = new JButton(new ImageIcon("cepumabilde.png"));    //galvenais cepums
    JButton bplus = new JButton("+1 par klikšķi ("+cena1+"c)");     //klikšķa plusošana
    bplus.setBounds(900,100,200,30);
    b.setBounds(0,0,500,500);  
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){     //action listeners kurs pieskaita cepumus par katru klikšķi
            cepumi = cepumi+cepumiplus;
            nauda.setText("cepumi:"+cepumi);
            if(b.isSelected()){
                cepumi = cepumi+cepumiplus;
                nauda.setText("cepumi:"+cepumi); 
                       }}
});
bplus.addActionListener(new ActionListener(){    // action listeners klikšķa plusošanas pogai
    public void actionPerformed(ActionEvent e){
if (cepumi>=cena1) {
    cepumiplus++;
    cepumi=cepumi-cena1;
    cena1=cena1*3;
    bplus.setText("+1 par klikšķi ("+cena1+"c)");
    nauda.setText("cepumi:"+cepumi); 
    
}
}});
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true); 
    f.add(nauda);
    f.add(b);
    f.add(bplus);
    
    };

}  
