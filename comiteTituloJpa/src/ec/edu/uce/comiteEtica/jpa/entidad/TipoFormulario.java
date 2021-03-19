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
@Table(name = "tipo_formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFormulario.findAll", query = "SELECT t FROM TipoFormulario t")
    , @NamedQuery(name = "TipoFormulario.findByTipfrmId", query = "SELECT t FROM TipoFormulario t WHERE t.tipfrmId = :tipfrmId")
    , @NamedQuery(name = "TipoFormulario.findByTipfrmNombre", query = "SELECT t FROM TipoFormulario t WHERE t.tipfrmNombre = :tipfrmNombre")
    , @NamedQuery(name = "TipoFormulario.findByTipfrmDescripcion", query = "SELECT t FROM TipoFormulario t WHERE t.tipfrmDescripcion = :tipfrmDescripcion")})
public class TipoFormulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipfrm_id")
    private Integer tipfrmId;
    @Size(max = 100)
    @Column(name = "tipfrm_nombre")
    private String tipfrmNombre;
    @Size(max = 200)
    @Column(name = "tipfrm_descripcion")
    private String tipfrmDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipfrmId")
    private List<Formulario> formularioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipfrmId")
    private List<RegistroInicial> registroInicialList;

    public TipoFormulario() {
    }

    public TipoFormulario(Integer tipfrmId) {
        this.tipfrmId = tipfrmId;
    }

    public Integer getTipfrmId() {
        return tipfrmId;
    }

    public void setTipfrmId(Integer tipfrmId) {
        this.tipfrmId = tipfrmId;
    }

    public String getTipfrmNombre() {
        return tipfrmNombre;
    }

    public void setTipfrmNombre(String tipfrmNombre) {
        this.tipfrmNombre = tipfrmNombre;
    }

    public String getTipfrmDescripcion() {
        return tipfrmDescripcion;
    }

    public void setTipfrmDescripcion(String tipfrmDescripcion) {
        this.tipfrmDescripcion = tipfrmDescripcion;
    }

    @XmlTransient
    public List<Formulario> getFormularioList() {
        return formularioList;
    }

    public void setFormularioList(List<Formulario> formularioList) {
        this.formularioList = formularioList;
    }

    @XmlTransient
    public List<RegistroInicial> getRegistroInicialList() {
        return registroInicialList;
    }

    public void setRegistroInicialList(List<RegistroInicial> registroInicialList) {
        this.registroInicialList = registroInicialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipfrmId != null ? tipfrmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFormulario)) {
            return false;
        }
        TipoFormulario other = (TipoFormulario) object;
        if ((this.tipfrmId == null && other.tipfrmId != null) || (this.tipfrmId != null && !this.tipfrmId.equals(other.tipfrmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.TipoFormulario[ tipfrmId=" + tipfrmId + " ]";
    }
    
}
