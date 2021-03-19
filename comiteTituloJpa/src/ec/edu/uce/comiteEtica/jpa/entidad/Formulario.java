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
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f")
    , @NamedQuery(name = "Formulario.findByFrmId", query = "SELECT f FROM Formulario f WHERE f.frmId = :frmId")
    , @NamedQuery(name = "Formulario.findByFrmNombre", query = "SELECT f FROM Formulario f WHERE f.frmNombre = :frmNombre")})
public class Formulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "frm_id")
    private Integer frmId;
    @Size(max = 100)
    @Column(name = "frm_nombre")
    private String frmNombre;
    @Lob
    @Column(name = "frm_documento")
    private byte[] frmDocumento;
    @JoinColumn(name = "tipfrm_id", referencedColumnName = "tipfrm_id")
    @ManyToOne(optional = false)
    private TipoFormulario tipfrmId;

    public Formulario() {
    }

    public Formulario(Integer frmId) {
        this.frmId = frmId;
    }

    public Integer getFrmId() {
        return frmId;
    }

    public void setFrmId(Integer frmId) {
        this.frmId = frmId;
    }

    public String getFrmNombre() {
        return frmNombre;
    }

    public void setFrmNombre(String frmNombre) {
        this.frmNombre = frmNombre;
    }

    public byte[] getFrmDocumento() {
        return frmDocumento;
    }

    public void setFrmDocumento(byte[] frmDocumento) {
        this.frmDocumento = frmDocumento;
    }

    public TipoFormulario getTipfrmId() {
        return tipfrmId;
    }

    public void setTipfrmId(TipoFormulario tipfrmId) {
        this.tipfrmId = tipfrmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frmId != null ? frmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.frmId == null && other.frmId != null) || (this.frmId != null && !this.frmId.equals(other.frmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Formulario[ frmId=" + frmId + " ]";
    }
    
}
