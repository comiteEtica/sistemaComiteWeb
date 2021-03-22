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
@Table(name = "tipo_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProyecto.findAll", query = "SELECT t FROM TipoProyecto t")
    , @NamedQuery(name = "TipoProyecto.findByTippryId", query = "SELECT t FROM TipoProyecto t WHERE t.tippryId = :tippryId")
    , @NamedQuery(name = "TipoProyecto.findByTippryNombre", query = "SELECT t FROM TipoProyecto t WHERE t.tippryNombre = :tippryNombre")
    , @NamedQuery(name = "TipoProyecto.findByTippryDescripcion", query = "SELECT t FROM TipoProyecto t WHERE t.tippryDescripcion = :tippryDescripcion")})
public class TipoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tippry_id")
    private Integer tippryId;
    @Size(max = 100)
    @Column(name = "tippry_nombre")
    private String tippryNombre;
    @Size(max = 100)
    @Column(name = "tippry_descripcion")
    private String tippryDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tippryId")
    private List<Proyecto> proyectoList;

    public TipoProyecto() {
    }

    public TipoProyecto(Integer tippryId) {
        this.tippryId = tippryId;
    }

    public Integer getTippryId() {
        return tippryId;
    }

    public void setTippryId(Integer tippryId) {
        this.tippryId = tippryId;
    }

    public String getTippryNombre() {
        return tippryNombre;
    }

    public void setTippryNombre(String tippryNombre) {
        this.tippryNombre = tippryNombre;
    }

    public String getTippryDescripcion() {
        return tippryDescripcion;
    }

    public void setTippryDescripcion(String tippryDescripcion) {
        this.tippryDescripcion = tippryDescripcion;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tippryId != null ? tippryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProyecto)) {
            return false;
        }
        TipoProyecto other = (TipoProyecto) object;
        if ((this.tippryId == null && other.tippryId != null) || (this.tippryId != null && !this.tippryId.equals(other.tippryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.TipoProyecto[ tippryId=" + tippryId + " ]";
    }
    
}
