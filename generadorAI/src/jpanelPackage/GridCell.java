/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelPackage;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro Rios
 */
public class GridCell extends JComponent{

  
    private GridJPanel grid;

    public GridCell(GridJPanel grid) {
        this.grid=grid;
    }

    public GridJPanel getGrid() {
        return grid;
    }

    public void setGrid(GridJPanel grid) {
        this.grid = grid;
    }

  

    
    
}
