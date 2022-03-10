/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LuoZhiHao.GUI.DispatchGUI;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bob50
 * @param <T>
 */
public  class SimpleTableModel<T> extends AbstractTableModel
{
    protected List<String> cols;
    protected List<T> rows;

    public SimpleTableModel(List<String> cols, List<T> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return  cols.size();
    }

    @Override
    public String getColumnName(int column) {
        return cols.get(column);
    }

    @Override
    public  Object getValueAt(int rowIndex, int columnIndex) {
        try {
            List<Method> getMethods= ClassReflect.getAllGetMethod(rows.get(rowIndex));
            return getMethods.get(columnIndex).invoke(rows.get(rowIndex), null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
