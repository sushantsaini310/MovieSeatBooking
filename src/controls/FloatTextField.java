/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author sushant saini
 */
public class FloatTextField extends JTextField{
private boolean dot_present;
    public FloatTextField() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt){
                char ch=evt.getKeyChar();
                dot_present=getText().contains(".");
                if(!Character.isDigit(ch))
                {
                    if(ch!='.')
                        evt.consume();
                    else if(dot_present)
                        evt.consume();
                }
            }   
            
});
        
    }
    
    
}
