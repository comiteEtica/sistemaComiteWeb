package ec.edu.uce.comiteEtica.jpa.entidad;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "observacion_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionProyecto.findAll", query = "SELECT o FROM ObservacionProyecto o")
    , @NamedQuery(name = "ObservacionProyecto.findByObspryId", query = "SELECT o FROM ObservacionProyecto o WHERE o.obspryId = :obspryId")
    , @NamedQuery(name = "ObservacionProyecto.findByObspryDescripcion", query = "SELECT o FROM ObservacionProyecto o WHERE o.obspryDescripcion = :obspryDescripcion")
    , @NamedQuery(name = "ObservacionProyecto.findByRvsId", query = "SELECT o FROM ObservacionProyecto o WHERE o.rvsId = :rvsId")})
public class ObservacionProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "obspry_id")
    private Integer obspryId;
    @Size(max = 100)
    @Column(name = "obspry_descripcion")
    private String obspryDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvs_id")
    private int rvsId;
    @JoinColumn(name = "pry_id", referencedColumnName = "pry_id")
    @ManyToOne(optional = false)
    private Proyecto pryId;

    public ObservacionProyecto() {
    }

    public ObservacionProyecto(Integer obspryId) {
        this.obspryId = obspryId;
    }

    public ObservacionProyecto(Integer obspryId, int rvsId) {
        this.obspryId = obspryId;
        this.rvsId = rvsId;
    }

    public Integer getObspryId() {
        return obspryId;
    }

    public void setObspryId(Integer obspryId) {
        this.obspryId = obspryId;
    }

    public String getObspryDescripcion() {
        return obspryDescripcion;
    }

    public void setObspryDescripcion(String obspryDescripcion) {
        this.obspryDescripcion = obspryDescripcion;
    }

    public int getRvsId() {
        return rvsId;
    }

    public void setRvsId(int rvsId) {
        this.rvsId = rvsId;
    }

    public Proyecto getPryId() {
        return pryId;
    }

    public void setPryId(Proyecto pryId) {
        this.pryId = pryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obspryId != null ? obspryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionProyecto)) {
            return false;
        }
        ObservacionProyecto other = (ObservacionProyecto) object;
        if ((this.obspryId == null && other.obspryId != null) || (this.obspryId != null && !this.obspryId.equals(other.obspryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.ObservacionProyecto[ obspryId=" + obspryId + " ]";
    }
    
}
