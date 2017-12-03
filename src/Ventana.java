import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame{

    private JPanel panel = new JPanel();
    public static void main(String[] args)
    {
        Ventana ventana = new Ventana();
        ventana.setLayout(new GridLayout(2,1));
        ventana.setSize(250,250);
        ventana.setMinimumSize(new Dimension(200,200));

        Grid grid = new Grid(50,50, 2, 2);
        grid.setPanelColor(Color.BLACK, 0, 0);

        JButton next = new JButton("Next");
        next.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int rows = grid.getRows();
                int columns = grid.getColumns();
                boolean[][] states = new boolean[rows][columns];

                for(int i=0;i<rows; i++)
                {
                    for(int j=0; j<columns; j++)
                    {
                        if(grid.getPanel(i,j).getBackground().equals(Color.BLACK))
                            states[i][j] = true;
                        else
                            states[i][j] = false;
                    }
                }

                try
                {
                    for (int i = 0; i < rows; i++)
                    {
                        for (int j = 0; j < columns; j++)
                        {
//                            System.out.println(i + " " + j + "  Cell: " + grid.getPanel(i,j));
                            if (states[i][j] == true)
                            {
                                System.out.println("Changing cell: " + i + "," + j);

                                //Apagar celda
                                grid.setPanelColor(Color.WHITE, i, j);

                                //Cambiar filas adyacentes
                                if (i == 0)
                                    grid.setPanelColor(Color.BLACK, i + 1, j);
                                else if (i == rows-1)
                                    grid.setPanelColor(Color.BLACK, i - 1, j);
                                else
                                {
                                    grid.setPanelColor(Color.BLACK, i + 1, j);
                                    grid.setPanelColor(Color.BLACK, i - 1, j);
                                }

                                //Cambiar columnas adyacentes
                                if (j == 0)
                                    grid.setPanelColor(Color.BLACK, i, j + 1);
                                else if (j == columns-1)
                                    grid.setPanelColor(Color.BLACK, i, j - 1);
                                else
                                {
                                    grid.setPanelColor(Color.BLACK, i, j + 1);
                                    grid.setPanelColor(Color.BLACK, i, j - 1);
                                }
                            }
                        }
                    }
                }
                catch (Exception e){e.printStackTrace(); return; }

            }
        });


        ventana.add(grid);
        ventana.add(next);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        ventana.pack();
        ventana.setVisible(true);
    }
}
