package pupkin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ramzes on 25.08.2016.
 */
public class MyActionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked the button  : "+e.getActionCommand());
    }
}//class
