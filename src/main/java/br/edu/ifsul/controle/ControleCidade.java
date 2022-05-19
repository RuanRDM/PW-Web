/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.util.Util;
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
public class ControleCidade implements Serializable{
    
    @EJB
    private CidadeDAO<Cidade> dao;
    private Cidade objeto;
    @EJB
    private EstadoDAO<Estado> daoEstado;
    
    public ControleCidade(){
        
    }

     public void novo(){
        setObjeto(new Cidade());
    }
    
    public void alterar(Object id){
        try {
            setObjeto(getDao().getObjectById(id));
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+ Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            setObjeto(getDao().getObjectById(id));
            getDao().remove(getObjeto());
            Util.mensagemInformacao("Objeto removido com sucesso. ");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+ Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
       try {
           if (getObjeto().getId() == null){
                getDao().persist(getObjeto());
           } else {
                getDao().merge(getObjeto());
           }
           Util.mensagemInformacao("Objeto persistido com sucesso!");
       } catch (Exception e){
           Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
       }
    }
    
    
    
    public String listar(){
        return "/privado/estado/listar?faces-redirect-true";
    }



    public EstadoDAO<Estado> getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(EstadoDAO<Estado> daoEstado) {
        this.daoEstado = daoEstado;
    }

    public CidadeDAO<Cidade> getDao() {
        return dao;
    }

    public void setDao(CidadeDAO<Cidade> dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }
    
    
}
