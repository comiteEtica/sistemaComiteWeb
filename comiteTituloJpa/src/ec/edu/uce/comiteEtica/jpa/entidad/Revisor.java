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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "revisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revisor.findAll", query = "SELECT r FROM Revisor r")
    , @NamedQuery(name = "Revisor.findByRvsId", query = "SELECT r FROM Revisor r WHERE r.rvsId = :rvsId")})
public class Revisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rvs_id")
    private Integer rvsId;
    @Lob
    @Column(name = "rvs_informe")
    private byte[] rvsInforme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rvsId")
    private List<Proyecto> proyectoList;

    public Revisor() {
    }

    public Revisor(Integer rvsId) {
        this.rvsId = rvsId;
    }

    public Integer getRvsId() {
        return rvsId;
    }

    public void setRvsId(Integer rvsId) {
        this.rvsId = rvsId;
    }

    public byte[] getRvsInforme() {
        return rvsInforme;
    }

    public void setRvsInforme(byte[] rvsInforme) {
        this.rvsInforme = rvsInforme;
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
        hash += (rvsId != null ? rvsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revisor)) {
            return false;
        }
        Revisor other = (Revisor) object;
        if ((this.rvsId == null && other.rvsId != null) || (this.rvsId != null && !this.rvsId.equals(other.rvsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Revisor[ rvsId=" + rvsId + " ]";
    }
    
}
