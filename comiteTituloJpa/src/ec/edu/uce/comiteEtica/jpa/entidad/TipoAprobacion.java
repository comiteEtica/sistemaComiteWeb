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
@Table(name = "tipo_aprobacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAprobacion.findAll", query = "SELECT t FROM TipoAprobacion t")
    , @NamedQuery(name = "TipoAprobacion.findByTipaprId", query = "SELECT t FROM TipoAprobacion t WHERE t.tipaprId = :tipaprId")
    , @NamedQuery(name = "TipoAprobacion.findByTipaprNombre", query = "SELECT t FROM TipoAprobacion t WHERE t.tipaprNombre = :tipaprNombre")
    , @NamedQuery(name = "TipoAprobacion.findByTipaprDescripcion", query = "SELECT t FROM TipoAprobacion t WHERE t.tipaprDescripcion = :tipaprDescripcion")})
public class TipoAprobacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipapr_id")
    private Integer tipaprId;
    @Size(max = 100)
    @Column(name = "tipapr_nombre")
    private String tipaprNombre;
    @Size(max = 100)
    @Column(name = "tipapr_descripcion")
    private String tipaprDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipaprId")
    private List<Proyecto> proyectoList;

    public TipoAprobacion() {
    }

    public TipoAprobacion(Integer tipaprId) {
        this.tipaprId = tipaprId;
    }

    public Integer getTipaprId() {
        return tipaprId;
    }

    public void setTipaprId(Integer tipaprId) {
        this.tipaprId = tipaprId;
    }

    public String getTipaprNombre() {
        return tipaprNombre;
    }

    public void setTipaprNombre(String tipaprNombre) {
        this.tipaprNombre = tipaprNombre;
    }

    public String getTipaprDescripcion() {
        return tipaprDescripcion;
    }

    public void setTipaprDescripcion(String tipaprDescripcion) {
        this.tipaprDescripcion = tipaprDescripcion;
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
        hash += (tipaprId != null ? tipaprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAprobacion)) {
            return false;
        }
        TipoAprobacion other = (TipoAprobacion) object;
        if ((this.tipaprId == null && other.tipaprId != null) || (this.tipaprId != null && !this.tipaprId.equals(other.tipaprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.TipoAprobacion[ tipaprId=" + tipaprId + " ]";
    }
    
}
