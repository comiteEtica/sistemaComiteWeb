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
@Table(name = "usuario_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")
    , @NamedQuery(name = "UsuarioRol.findByUsrolId", query = "SELECT u FROM UsuarioRol u WHERE u.usrolId = :usrolId")
    , @NamedQuery(name = "UsuarioRol.findByUsrolEstado", query = "SELECT u FROM UsuarioRol u WHERE u.usrolEstado = :usrolEstado")
    , @NamedQuery(name = "UsuarioRol.findByUsrObservacion", query = "SELECT u FROM UsuarioRol u WHERE u.usrObservacion = :usrObservacion")
    , @NamedQuery(name = "UsuarioRol.findByUsrolTipoIngreso", query = "SELECT u FROM UsuarioRol u WHERE u.usrolTipoIngreso = :usrolTipoIngreso")
    , @NamedQuery(name = "UsuarioRol.findByUsrolFechaInicio", query = "SELECT u FROM UsuarioRol u WHERE u.usrolFechaInicio = :usrolFechaInicio")
    , @NamedQuery(name = "UsuarioRol.findByUsrolFechaFin", query = "SELECT u FROM UsuarioRol u WHERE u.usrolFechaFin = :usrolFechaFin")
    , @NamedQuery(name = "UsuarioRol.findByUsrolUsuarioRegistra", query = "SELECT u FROM UsuarioRol u WHERE u.usrolUsuarioRegistra = :usrolUsuarioRegistra")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usrol_id")
    private Integer usrolId;
    @Column(name = "usrol_estado")
    private Integer usrolEstado;
    @Size(max = 100)
    @Column(name = "usr_observacion")
    private String usrObservacion;
    @Column(name = "usrol_tipo_ingreso")
    private Integer usrolTipoIngreso;
    @Column(name = "usrol_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date usrolFechaInicio;
    @Column(name = "usrol_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date usrolFechaFin;
    @Size(max = 50)
    @Column(name = "usrol_usuario_registra")
    private String usrolUsuarioRegistra;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private Rol rolId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Usuario usrId;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer usrolId) {
        this.usrolId = usrolId;
    }

    public Integer getUsrolId() {
        return usrolId;
    }

    public void setUsrolId(Integer usrolId) {
        this.usrolId = usrolId;
    }

    public Integer getUsrolEstado() {
        return usrolEstado;
    }

    public void setUsrolEstado(Integer usrolEstado) {
        this.usrolEstado = usrolEstado;
    }

    public String getUsrObservacion() {
        return usrObservacion;
    }

    public void setUsrObservacion(String usrObservacion) {
        this.usrObservacion = usrObservacion;
    }

    public Integer getUsrolTipoIngreso() {
        return usrolTipoIngreso;
    }

    public void setUsrolTipoIngreso(Integer usrolTipoIngreso) {
        this.usrolTipoIngreso = usrolTipoIngreso;
    }

    public Date getUsrolFechaInicio() {
        return usrolFechaInicio;
    }

    public void setUsrolFechaInicio(Date usrolFechaInicio) {
        this.usrolFechaInicio = usrolFechaInicio;
    }

    public Date getUsrolFechaFin() {
        return usrolFechaFin;
    }

    public void setUsrolFechaFin(Date usrolFechaFin) {
        this.usrolFechaFin = usrolFechaFin;
    }

    public String getUsrolUsuarioRegistra() {
        return usrolUsuarioRegistra;
    }

    public void setUsrolUsuarioRegistra(String usrolUsuarioRegistra) {
        this.usrolUsuarioRegistra = usrolUsuarioRegistra;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public Usuario getUsrId() {
        return usrId;
    }

    public void setUsrId(Usuario usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrolId != null ? usrolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.usrolId == null && other.usrolId != null) || (this.usrolId != null && !this.usrolId.equals(other.usrolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.UsuarioRol[ usrolId=" + usrolId + " ]";
    }
    
}
