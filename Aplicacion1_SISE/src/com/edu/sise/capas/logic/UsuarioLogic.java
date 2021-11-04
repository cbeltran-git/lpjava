/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.capas.logic;

import com.edu.sise.capas.dao.UsuarioDao;
import com.edu.sise.capas.entity.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEBASTIAN
 */
public class UsuarioLogic {
    
    UsuarioDao dao  = null;
    
    public Usuario obtenerUsuarioxID(int id){
    
        Usuario objUsuario = null;
        dao = new UsuarioDao();
        
        if(id >=0){
            objUsuario = dao.obtenerUsuarioxID(id);
        }
        
        return objUsuario;
    }
    
    public Usuario validarAcceso(Usuario objUsuario){
        dao = new UsuarioDao();
        return dao.validarAcceso(objUsuario);
    }
    
    public DefaultTableModel obtenerTodos(){
        dao = new UsuarioDao();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CLAVE");
        
        List<Usuario>listaUsuario = dao.obtenerTodos(); 
        Usuario objUsuario  = null ;
        for (int i = 0;i<listaUsuario.size();i++){
            objUsuario = listaUsuario.get(i);
            
            Object data [] ={
              objUsuario.getId_usuario(),
            objUsuario.getNombre(),
            objUsuario.getClave()
            };
            modelo.addRow(data);
        }
        return modelo;
    }
    
    public void imprimirTB(JTable jTable, DefaultTableModel modelo){
     
        jTable.setModel(modelo);
        
    }
    
    public boolean agregarUsuario(Usuario objUsuario){
           dao = new UsuarioDao();
        boolean rpta = false;
        //validar si el usuario existe
        List lista = dao.buscarxNombre(objUsuario.getNombre());
        
        if(lista.size()>0){
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe");
        }else{
            rpta = dao.agregarUsuario(objUsuario);
        }
        
        return rpta;
    }
    
    
    public boolean modificarUsuario(Usuario objUsuario){
        dao = new UsuarioDao();
        return dao.modificarUsuario(objUsuario);
    }
    
    public boolean eliminarUsuario(int id){
        dao = new UsuarioDao();
        return dao.eliminarUsuario(id);
    }
    
    public DefaultTableModel buscarxNombre(String nombre){
        
        dao = new UsuarioDao();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CLAVE");
        
        List<Usuario>listaUsuario = dao.buscarxNombre(nombre); 
        Usuario objUsuario  = null ;
        for (int i = 0;i<listaUsuario.size();i++){
            objUsuario = listaUsuario.get(i);
            
            Object data [] ={
              objUsuario.getId_usuario(),
            objUsuario.getNombre(),
            objUsuario.getClave()
            };
            modelo.addRow(data);
        }
        return modelo;
    }
}
