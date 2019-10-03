/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;

import Datos.TipoUsuarioJpaController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoseM
 */
@Entity
@Table(name = "TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t")
    , @NamedQuery(name = "TipoUsuario.findByIdTipo", query = "SELECT t FROM TipoUsuario t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TipoUsuario.findByTipo", query = "SELECT t FROM TipoUsuario t WHERE t.tipo = :tipo")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_id_tipo", sequenceName = "seq_id_tipo", allocationSize = 1) 
    @GeneratedValue(strategy= GenerationType.IDENTITY , generator="seq_id_tipo")
    @Column(name = "ID_TIPO")
    private BigDecimal idTipo;
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "idTipo")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(BigDecimal idTipo) {
        this.idTipo = idTipo;
    }

    public BigDecimal getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(BigDecimal idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

     public int extraerIDTipoU(String nameType){
        
        int ID = 0;
        
        TipoUsuario tipos = new TipoUsuario();

        TipoUsuarioJpaController CTipos = new TipoUsuarioJpaController();
        
         List<TipoUsuario> ListTipos  =  CTipos.findTipoUsuarioEntities();
         
         for (int i = 0; i < ListTipos.size(); i++) {
             
             if (nameType.equals(ListTipos.get(i).getTipo())) {
                 
                 ID = Integer.parseInt(ListTipos.get(i).getIdTipo().toString()); 
             }
         }
        
    
       // if (nameType.equals("Administrador")) {
           // ID = 1;
       // }
        //else if(nameType.equals("Profesor"))
        //{
        //    ID = 2;
        //}
        return ID;}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocio.TipoUsuario[ idTipo=" + idTipo + " ]";
    }
    
}
