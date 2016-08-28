package pupkin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by ramzes on 23.08.2016.
 */
public class GUI_Filemanager extends JFrame {

    int fileManagerWidth = 900;
    int fileManagerHeight = 500;

    int screen_width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int screen_height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    final static JButton button_F3 = new JButton("F3_View");//Просмотр содержимого
    final static JButton button_F4 = new JButton("F4_Edit");//Правка содержимого
    final static JButton button_F5 = new JButton("F5_Copy");//Копирование содержимого
    final static JButton button_F6 = new JButton("F6_Remove");//Перенос содержимого
    final static JButton button_F7 = new JButton("F7_NewFolder");//Новая папка содержимого
    final static JButton button_F8 = new JButton("F8_Delete");//удалить
    final static JButton button_ALT_F4 = new JButton("ALT+F4");//выход

    static JLabel label_disk_left = new JLabel("left");
    static JLabel label_disk_right = new JLabel("right");

    ArrayList<JButton> arrayListOfButtons = new ArrayList();

    {
        arrayListOfButtons.add(button_F3);
        arrayListOfButtons.add(button_F4);
        arrayListOfButtons.add(button_F5);
        arrayListOfButtons.add(button_F6);
        arrayListOfButtons.add(button_F7);
        arrayListOfButtons.add(button_F8);
        arrayListOfButtons.add(button_ALT_F4);
    }

    public static JList<File> list1;
    public static JList <File> list2;

    Font font = new Font("Arial", Font.BOLD, 14);

    public GUI_Filemanager() throws HeadlessException, IOException {

        createGUI();

    }


    public void createGUI() throws IOException {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        setDefaultLookAndFeelDecorated(true);
        setTitle("My fileManager");
        setSize(fileManagerWidth, fileManagerHeight);
        setLocation((screen_width - fileManagerWidth) / 2, (screen_height - fileManagerHeight) / 2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setHgap(15);
        flowLayout.setVgap(10);

        FlowLayout flowLayoutForJLables = new FlowLayout(FlowLayout.CENTER);
        flowLayoutForJLables.setHgap(390);
        flowLayoutForJLables.setVgap(10);


        setLayout(new BorderLayout());
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        center.setLayout(flowLayout);
        north.setLayout(flowLayoutForJLables);
        south.setLayout(flowLayout);

        String[] data1 = {"<html><font size = +1 color = yellow>Иван</font>",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four",
                "one", "two", "three", "four"
        };

        list1 = new JList(data1);
        list2 = new JList( );
        JScrollPane jScrollPane1 = new JScrollPane(list1);
        JScrollPane jScrollPane2 = new JScrollPane(list2);
        jScrollPane1.setPreferredSize(new Dimension(fileManagerWidth / 2 - 45, fileManagerHeight - 120));
        jScrollPane2.setPreferredSize(new Dimension(fileManagerWidth / 2 - 45, fileManagerHeight - 120));


        north.add(label_disk_left);
        north.add(label_disk_right);

        center.add(jScrollPane1);
        center.add(jScrollPane2);


        for (int i = 0; i < arrayListOfButtons.size(); i++) {

            south.add(arrayListOfButtons.get(i));
            arrayListOfButtons.get(i).setBackground(Color.LIGHT_GRAY);
            arrayListOfButtons.get(i).setFont(font);
            arrayListOfButtons.get(i).addActionListener(new MyActionListener());
        }


        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        FileMagerOperations.metod();

        setResizable(false);
        setVisible(true);
    }




    public static void main(String[] args) throws IOException {
        new GUI_Filemanager();
    }
}//class
