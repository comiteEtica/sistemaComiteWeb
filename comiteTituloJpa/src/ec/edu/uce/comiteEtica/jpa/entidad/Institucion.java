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
@Table(name = "institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i")
    , @NamedQuery(name = "Institucion.findByInsId", query = "SELECT i FROM Institucion i WHERE i.insId = :insId")
    , @NamedQuery(name = "Institucion.findByInsNombre", query = "SELECT i FROM Institucion i WHERE i.insNombre = :insNombre")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ins_id")
    private Integer insId;
    @Size(max = 30)
    @Column(name = "ins_nombre")
    private String insNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insId")
    private List<Persona> personaList;

    public Institucion() {
    }

    public Institucion(Integer insId) {
        this.insId = insId;
    }

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    public String getInsNombre() {
        return insNombre;
    }

    public void setInsNombre(String insNombre) {
        this.insNombre = insNombre;
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
        hash += (insId != null ? insId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.insId == null && other.insId != null) || (this.insId != null && !this.insId.equals(other.insId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Institucion[ insId=" + insId + " ]";
    }
    
}
