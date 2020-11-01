/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelPackage;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro Rios
 */
public class GridJPanel extends javax.swing.JPanel {

    ArrayList<ArrayList<JComponent>> cells;
    private int cWidth;
    private int cHeight;

    public GridJPanel() {
        cells = new ArrayList();
        ArrayList<JComponent> c = new ArrayList();

        c.add(new JTextField());
        cells.add(c);
        writeCell(0, 0, "hello");
    }

    public void setcWidth(int width) {
        this.cWidth = width;
        resize();
    }

    public void setcHeight(int height) {
        this.cHeight = height;
        resize();
    }

    public void setAbsoluteLayout() {
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }

    public void addRow() {
        ArrayList<JComponent> newRow = new ArrayList();
        for (int i = 0; i < cells.get(0).size(); i++) {
            JTextField cell = new JTextField();
            newRow.add(cell);
        }
        cells.add(newRow);
        resize();
    }

    public void addColumn() {
        for (int i = 0; i < cells.size(); i++) {
            cells.get(i).add(new JTextField());
        }
        resize();
    }

    public void resize() {
        int cY = 0;
        this.removeAll();
        for (int i = 0; i < cells.size(); i++) {
            ArrayList<JComponent> rowi = cells.get(i);
            int cX = 0;
            for (JComponent j : rowi) {
                this.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(cX, cY, cHeight, -1));
                cX += cWidth;
            }
            cY += cHeight;
        }
    }

    public void writeCell(int row, int column, String data) {

        JComponent cellC = (JComponent) (cells.get(row).get(column));
        JTextField cell=(JTextField)cellC;
        cell.setText(data);
    }

}
