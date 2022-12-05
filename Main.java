import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        JFrame frame = new JFrame();
        MakeSound makeSound = new MakeSound();

        frame.setLayout(null);
        frame.setSize(300, 300);
        frame.setVisible(true);

        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Are You Sure to Close Application?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    System.exit(0);
                    makeSound.stopSound();
                }
            }
        };

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(exitListener);

        makeSound.loopSound("sounds/mixkit-game-show-suspense-waiting-667.wav");
    }

}