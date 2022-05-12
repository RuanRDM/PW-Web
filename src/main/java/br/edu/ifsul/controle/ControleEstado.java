/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 20191pf.cc0202
 */
@Named(value = "controleEstado")
@ViewScoped
public class ControleEstado implements Serializable{
    
    @EJB
    private EstadoDAO<Estado> dao;
    
    public ControleEstado(){
        
    }
    
    public String listar(){
        return "/privado/estado/listar?faces-redirect-true";
    }

    public EstadoDAO<Estado> getDao() {
        return dao;
    }

    public void setDao(EstadoDAO<Estado> dao) {
        this.dao = dao;
    }
    
    
}
