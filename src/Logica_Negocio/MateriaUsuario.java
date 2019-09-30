/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoseM
 */
@Entity
@Table(name = "MATERIA_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaUsuario.findAll", query = "SELECT m FROM MateriaUsuario m")
    , @NamedQuery(name = "MateriaUsuario.findByIdMatusu", query = "SELECT m FROM MateriaUsuario m WHERE m.idMatusu = :idMatusu")})
public class MateriaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
        @SequenceGenerator(name = "seq_id_Matusu", sequenceName = "seq_id_Matusu", allocationSize = 1) 
    @GeneratedValue(strategy= GenerationType.IDENTITY , generator="seq_id_Matusu")
    @Column(name = "ID_MATUSU")
    private BigDecimal idMatusu;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne(optional = false)
    private Materia idMateria;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public MateriaUsuario() {
    }

    public MateriaUsuario(BigDecimal idMatusu) {
        this.idMatusu = idMatusu;
    }

    public BigDecimal getIdMatusu() {
        return idMatusu;
    }

    public void setIdMatusu(BigDecimal idMatusu) {
        this.idMatusu = idMatusu;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatusu != null ? idMatusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaUsuario)) {
            return false;
        }
        MateriaUsuario other = (MateriaUsuario) object;
        if ((this.idMatusu == null && other.idMatusu != null) || (this.idMatusu != null && !this.idMatusu.equals(other.idMatusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idMatusu.toString();
    }
    
}
