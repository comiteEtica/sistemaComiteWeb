package ec.edu.uce.comiteEtica.jpa.entidad;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "registro_inicial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroInicial.findAll", query = "SELECT r FROM RegistroInicial r")
    , @NamedQuery(name = "RegistroInicial.findByRginId", query = "SELECT r FROM RegistroInicial r WHERE r.rginId = :rginId")
    , @NamedQuery(name = "RegistroInicial.findByRginFechaResigtro", query = "SELECT r FROM RegistroInicial r WHERE r.rginFechaResigtro = :rginFechaResigtro")
    , @NamedQuery(name = "RegistroInicial.findByRginNombre", query = "SELECT r FROM RegistroInicial r WHERE r.rginNombre = :rginNombre")
    , @NamedQuery(name = "RegistroInicial.findByRginApellido", query = "SELECT r FROM RegistroInicial r WHERE r.rginApellido = :rginApellido")
    , @NamedQuery(name = "RegistroInicial.findByRginEdad", query = "SELECT r FROM RegistroInicial r WHERE r.rginEdad = :rginEdad")
    , @NamedQuery(name = "RegistroInicial.findByRginSexo", query = "SELECT r FROM RegistroInicial r WHERE r.rginSexo = :rginSexo")})
public class RegistroInicial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rgin_id")
    private Integer rginId;
    @Column(name = "rgin_fecha_resigtro")
    @Temporal(TemporalType.DATE)
    private Date rginFechaResigtro;
    @Size(max = 50)
    @Column(name = "rgin_nombre")
    private String rginNombre;
    @Size(max = 50)
    @Column(name = "rgin_apellido")
    private String rginApellido;
    @Column(name = "rgin_edad")
    private Integer rginEdad;
    @Size(max = 10)
    @Column(name = "rgin_sexo")
    private String rginSexo;
    @JoinColumn(name = "tipfrm_id", referencedColumnName = "tipfrm_id")
    @ManyToOne(optional = false)
    private TipoFormulario tipfrmId;

    public RegistroInicial() {
    }

    public RegistroInicial(Integer rginId) {
        this.rginId = rginId;
    }

    public Integer getRginId() {
        return rginId;
    }

    public void setRginId(Integer rginId) {
        this.rginId = rginId;
    }

    public Date getRginFechaResigtro() {
        return rginFechaResigtro;
    }

    public void setRginFechaResigtro(Date rginFechaResigtro) {
        this.rginFechaResigtro = rginFechaResigtro;
    }

    public String getRginNombre() {
        return rginNombre;
    }

    public void setRginNombre(String rginNombre) {
        this.rginNombre = rginNombre;
    }

    public String getRginApellido() {
        return rginApellido;
    }

    public void setRginApellido(String rginApellido) {
        this.rginApellido = rginApellido;
    }

    public Integer getRginEdad() {
        return rginEdad;
    }

    public void setRginEdad(Integer rginEdad) {
        this.rginEdad = rginEdad;
    }

    public String getRginSexo() {
        return rginSexo;
    }

    public void setRginSexo(String rginSexo) {
        this.rginSexo = rginSexo;
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
        hash += (rginId != null ? rginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroInicial)) {
            return false;
        }
        RegistroInicial other = (RegistroInicial) object;
        if ((this.rginId == null && other.rginId != null) || (this.rginId != null && !this.rginId.equals(other.rginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.RegistroInicial[ rginId=" + rginId + " ]";
    }
    
}
