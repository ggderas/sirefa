/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validaciones;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Luis Manuel
 */
public class validadorVentana 
{

    public static boolean hayCamposVacios(JPanel panel)
    {
        /*
         * Método que determina si en una ventana se han llenado todos los
         * campos necesarios. Si no se han llenado retorna verdadero,
         * de lo contrario retorna falso.
         * Los campos de texto deben estar dentro de un JPanel
         * Valida controles de tipo JTextField
         */    
        for(Component component: panel.getComponents())
        {
            
            if(component instanceof JTextComponent)
            {
                JTextComponent textField = (JTextComponent)component;
                if(textField.isEnabled())
                {
                    if(textField.getText().trim().isEmpty()) //Significa que está vacío
                    {
                        return true;
                    }
                }
            }
            
        }
        
        return false;
    }
}
