package visao;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private ArrayList<Integer> faltas;

    public CustomTableCellRenderer(ArrayList<Integer> faltas) {
        this.faltas = faltas;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Verifica se a linha atual está na lista de faltas
        if (faltas.contains(row)) {
            cellComponent.setBackground(Color.RED);
            cellComponent.setForeground(Color.WHITE); // Define a cor da fonte como branca
        } else {
            // Define a cor de fundo padrão e a cor da fonte padrão das linhas não faltantes
            cellComponent.setBackground(table.getBackground());
            cellComponent.setForeground(table.getForeground());
        }
        
        return cellComponent;
    }
}

