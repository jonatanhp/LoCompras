import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Autocompleter2
{
    //~ Methods ------------------------------------------------------------------------------------

    public static void main(String[] args)
      throws Exception
    {
        // YES, IT'S EMPTY !!!
        // It'll start anyway because of static initializers
        SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    final JPopupMenu textPopupMenu = new JPopupMenu("MENU")
                    {

                        {
                            add(new JMenuItem("item 1"));
                            add(new JMenuItem("item 2"));
                            setFocusable(false);
                        }
                    };

                    final JTextArea textInput = new JTextArea("type something la")
                    {

                        {
                            setCaretPosition(getText().length());
                        }
                    };

                    KeyListener textInputListener = new KeyAdapter()
                    {
                        @Override
                        public void keyTyped(KeyEvent e)
                        {
                            Point p = textInput.getCaret().getMagicCaretPosition();

                            if (textPopupMenu.isVisible())
                            {
                                SwingUtilities.convertPointToScreen(p, textInput);
                                textPopupMenu.setLocation(p.x, p.y + 20);
                            }
                            else
                            {
                                textPopupMenu.show(textInput, p.x, p.y + 20);
                            }
                        }
                    };

                    textInput.addKeyListener(textInputListener);
                    new JFrame("TEST")
                        {

                            {
                                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                add(textInput);
                                setSize(400, 60);
                                setLocationRelativeTo(null);
                                setVisible(true);
                            }
                        };
                }
                ;
            });
    }
}