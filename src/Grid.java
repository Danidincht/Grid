import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    private JPanel[][] panels;
    private int rows, columns, hgap, vgap;

    public Grid()
    {
        this(4,4);
    }

    public Grid(int rows, int columns)
    {
        this(rows, columns, 2, 2);
    }

    public Grid(int rows, int columns, int hgap, int vgap)
    {
        this.rows = rows;
        this.columns = columns;
        this.hgap = hgap;
        this.vgap = vgap;

        init();
    }

    private void init()
    {
        GridLayout layout = new GridLayout(rows, columns, hgap, vgap);
        panels = new JPanel[rows][columns];

        for(int i=0;i<rows; i++)
        {
            for(int j=0;j<columns; j++)
            {
                JPanel panel = new JPanel();
                panel.setBackground(Color.WHITE);
                panel.setBorder(BorderFactory.createEmptyBorder());
                panel.setLayout(new BorderLayout());
                panels[i][j] = panel;
                add(panel);
            }
        }

        setLayout(layout);
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        setBackground(Color.black);
    }

    public void addToGrid(JComponent component, int row, int col)
    {
        JPanel panel = panels[row][col];
        panel.add(component);
    }

    public void setPanelColor(Color color, int row, int col)
    {
        JPanel panel = panels[row][col];
        panel.setBackground(color);
    }

    public JPanel getPanel(int row, int col)
    {
        return panels[row][col];
    }

    public void setPanel(JPanel panel, int row, int col)
    {
        panels[row][col] = panel;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
