package ec.edu.uce.comiteEtica.jpa.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "certificado_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CertificadoProyecto.findAll", query = "SELECT c FROM CertificadoProyecto c")
    , @NamedQuery(name = "CertificadoProyecto.findByCrtpryId", query = "SELECT c FROM CertificadoProyecto c WHERE c.crtpryId = :crtpryId")
    , @NamedQuery(name = "CertificadoProyecto.findByCrtpryCodigoUnico", query = "SELECT c FROM CertificadoProyecto c WHERE c.crtpryCodigoUnico = :crtpryCodigoUnico")})
public class CertificadoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "crtpry_id")
    private Integer crtpryId;
    @Lob
    @Column(name = "crtpry_documento")
    private byte[] crtpryDocumento;
    @Size(max = 100)
    @Column(name = "crtpry_codigo_unico")
    private String crtpryCodigoUnico;
    @JoinColumn(name = "pry_id", referencedColumnName = "pry_id")
    @ManyToOne(optional = false)
    private Proyecto pryId;

    public CertificadoProyecto() {
    }

    public CertificadoProyecto(Integer crtpryId) {
        this.crtpryId = crtpryId;
    }

    public Integer getCrtpryId() {
        return crtpryId;
    }

    public void setCrtpryId(Integer crtpryId) {
        this.crtpryId = crtpryId;
    }

    public byte[] getCrtpryDocumento() {
        return crtpryDocumento;
    }

    public void setCrtpryDocumento(byte[] crtpryDocumento) {
        this.crtpryDocumento = crtpryDocumento;
    }

    public String getCrtpryCodigoUnico() {
        return crtpryCodigoUnico;
    }

    public void setCrtpryCodigoUnico(String crtpryCodigoUnico) {
        this.crtpryCodigoUnico = crtpryCodigoUnico;
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
        hash += (crtpryId != null ? crtpryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CertificadoProyecto)) {
            return false;
        }
        CertificadoProyecto other = (CertificadoProyecto) object;
        if ((this.crtpryId == null && other.crtpryId != null) || (this.crtpryId != null && !this.crtpryId.equals(other.crtpryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.CertificadoProyecto[ crtpryId=" + crtpryId + " ]";
    }
    
}
