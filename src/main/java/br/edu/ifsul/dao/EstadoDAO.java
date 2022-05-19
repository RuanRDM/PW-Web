package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author 20191pf.cc0202
 */
@Stateful
public class EstadoDAO<TIPO> extends DAOGenerico<Estado> implements Serializable{
    
    public EstadoDAO(){
        super();
        classePersistente = Estado.class;
    }

    
}
