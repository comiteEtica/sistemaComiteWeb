package ec.edu.uce.comiteEtica.jpa.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByPryId", query = "SELECT p FROM Proyecto p WHERE p.pryId = :pryId")
    , @NamedQuery(name = "Proyecto.findByPryFechaIngreso", query = "SELECT p FROM Proyecto p WHERE p.pryFechaIngreso = :pryFechaIngreso")
    , @NamedQuery(name = "Proyecto.findByPryNombre", query = "SELECT p FROM Proyecto p WHERE p.pryNombre = :pryNombre")
    , @NamedQuery(name = "Proyecto.findByPryCodigo", query = "SELECT p FROM Proyecto p WHERE p.pryCodigo = :pryCodigo")
    , @NamedQuery(name = "Proyecto.findByPryEstado", query = "SELECT p FROM Proyecto p WHERE p.pryEstado = :pryEstado")
    , @NamedQuery(name = "Proyecto.findByPryPatrocinador", query = "SELECT p FROM Proyecto p WHERE p.pryPatrocinador = :pryPatrocinador")
    , @NamedQuery(name = "Proyecto.findByPryFechaProyecto", query = "SELECT p FROM Proyecto p WHERE p.pryFechaProyecto = :pryFechaProyecto")
    , @NamedQuery(name = "Proyecto.findByPryEstadoRecibido", query = "SELECT p FROM Proyecto p WHERE p.pryEstadoRecibido = :pryEstadoRecibido")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pry_id")
    private Integer pryId;
    @Column(name = "pry_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date pryFechaIngreso;
    @Lob
    @Column(name = "pry_formulario")
    private byte[] pryFormulario;
    @Size(max = 100)
    @Column(name = "pry_nombre")
    private String pryNombre;
    @Column(name = "pry_codigo")
    private Integer pryCodigo;
    @Column(name = "pry_estado")
    private Integer pryEstado;
    @Size(max = 100)
    @Column(name = "pry_patrocinador")
    private String pryPatrocinador;
    @Column(name = "pry_fecha_proyecto")
    @Temporal(TemporalType.DATE)
    private Date pryFechaProyecto;
    @Column(name = "pry_estado_recibido")
    private Integer pryEstadoRecibido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pryId")
    private List<ObservacionProyecto> observacionProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pryId")
    private List<CertificadoProyecto> certificadoProyectoList;
    @JoinColumn(name = "rvs_id", referencedColumnName = "rvs_id")
    @ManyToOne(optional = false)
    private Revisor rvsId;
    @JoinColumn(name = "tipapr_id", referencedColumnName = "tipapr_id")
    @ManyToOne(optional = false)
    private TipoAprobacion tipaprId;
    @JoinColumn(name = "tippry_id", referencedColumnName = "tippry_id")
    @ManyToOne(optional = false)
    private TipoProyecto tippryId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Usuario usrId;

    public Proyecto() {
    }

    public Proyecto(Integer pryId) {
        this.pryId = pryId;
    }

    public Integer getPryId() {
        return pryId;
    }

    public void setPryId(Integer pryId) {
        this.pryId = pryId;
    }

    public Date getPryFechaIngreso() {
        return pryFechaIngreso;
    }

    public void setPryFechaIngreso(Date pryFechaIngreso) {
        this.pryFechaIngreso = pryFechaIngreso;
    }

    public byte[] getPryFormulario() {
        return pryFormulario;
    }

    public void setPryFormulario(byte[] pryFormulario) {
        this.pryFormulario = pryFormulario;
    }

    public String getPryNombre() {
        return pryNombre;
    }

    public void setPryNombre(String pryNombre) {
        this.pryNombre = pryNombre;
    }

    public Integer getPryCodigo() {
        return pryCodigo;
    }

    public void setPryCodigo(Integer pryCodigo) {
        this.pryCodigo = pryCodigo;
    }

    public Integer getPryEstado() {
        return pryEstado;
    }

    public void setPryEstado(Integer pryEstado) {
        this.pryEstado = pryEstado;
    }

    public String getPryPatrocinador() {
        return pryPatrocinador;
    }

    public void setPryPatrocinador(String pryPatrocinador) {
        this.pryPatrocinador = pryPatrocinador;
    }

    public Date getPryFechaProyecto() {
        return pryFechaProyecto;
    }

    public void setPryFechaProyecto(Date pryFechaProyecto) {
        this.pryFechaProyecto = pryFechaProyecto;
    }

    public Integer getPryEstadoRecibido() {
        return pryEstadoRecibido;
    }

    public void setPryEstadoRecibido(Integer pryEstadoRecibido) {
        this.pryEstadoRecibido = pryEstadoRecibido;
    }

    @XmlTransient
    public List<ObservacionProyecto> getObservacionProyectoList() {
        return observacionProyectoList;
    }

    public void setObservacionProyectoList(List<ObservacionProyecto> observacionProyectoList) {
        this.observacionProyectoList = observacionProyectoList;
    }

    @XmlTransient
    public List<CertificadoProyecto> getCertificadoProyectoList() {
        return certificadoProyectoList;
    }

    public void setCertificadoProyectoList(List<CertificadoProyecto> certificadoProyectoList) {
        this.certificadoProyectoList = certificadoProyectoList;
    }

    public Revisor getRvsId() {
        return rvsId;
    }

    public void setRvsId(Revisor rvsId) {
        this.rvsId = rvsId;
    }

    public TipoAprobacion getTipaprId() {
        return tipaprId;
    }

    public void setTipaprId(TipoAprobacion tipaprId) {
        this.tipaprId = tipaprId;
    }

    public TipoProyecto getTippryId() {
        return tippryId;
    }

    public void setTippryId(TipoProyecto tippryId) {
        this.tippryId = tippryId;
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
        hash += (pryId != null ? pryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.pryId == null && other.pryId != null) || (this.pryId != null && !this.pryId.equals(other.pryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Proyecto[ pryId=" + pryId + " ]";
    }
    
}
