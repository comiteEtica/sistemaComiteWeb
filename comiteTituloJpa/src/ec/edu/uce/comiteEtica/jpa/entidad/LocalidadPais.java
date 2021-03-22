package ec.edu.uce.comiteEtica.jpa.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "localidad_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocalidadPais.findAll", query = "SELECT l FROM LocalidadPais l")
    , @NamedQuery(name = "LocalidadPais.findByLclpaisId", query = "SELECT l FROM LocalidadPais l WHERE l.lclpaisId = :lclpaisId")
    , @NamedQuery(name = "LocalidadPais.findByLclpaisNombre", query = "SELECT l FROM LocalidadPais l WHERE l.lclpaisNombre = :lclpaisNombre")})
public class LocalidadPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lclpais_id")
    private Integer lclpaisId;
    @Size(max = 30)
    @Column(name = "lclpais_nombre")
    private String lclpaisNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lclpaisId")
    private List<Persona> personaList;

    public LocalidadPais() {
    }

    public LocalidadPais(Integer lclpaisId) {
        this.lclpaisId = lclpaisId;
    }

    public Integer getLclpaisId() {
        return lclpaisId;
    }

    public void setLclpaisId(Integer lclpaisId) {
        this.lclpaisId = lclpaisId;
    }

    public String getLclpaisNombre() {
        return lclpaisNombre;
    }

    public void setLclpaisNombre(String lclpaisNombre) {
        this.lclpaisNombre = lclpaisNombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lclpaisId != null ? lclpaisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadPais)) {
            return false;
        }
        LocalidadPais other = (LocalidadPais) object;
        if ((this.lclpaisId == null && other.lclpaisId != null) || (this.lclpaisId != null && !this.lclpaisId.equals(other.lclpaisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.LocalidadPais[ lclpaisId=" + lclpaisId + " ]";
    }
    
}
