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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPrsId", query = "SELECT p FROM Persona p WHERE p.prsId = :prsId")
    , @NamedQuery(name = "Persona.findByPrsTipoIdentifiacion", query = "SELECT p FROM Persona p WHERE p.prsTipoIdentifiacion = :prsTipoIdentifiacion")
    , @NamedQuery(name = "Persona.findByPrsIdentifiacion", query = "SELECT p FROM Persona p WHERE p.prsIdentifiacion = :prsIdentifiacion")
    , @NamedQuery(name = "Persona.findByPrsPrimerApellido", query = "SELECT p FROM Persona p WHERE p.prsPrimerApellido = :prsPrimerApellido")
    , @NamedQuery(name = "Persona.findByPrsSegundoApellido", query = "SELECT p FROM Persona p WHERE p.prsSegundoApellido = :prsSegundoApellido")
    , @NamedQuery(name = "Persona.findByPrsNombre", query = "SELECT p FROM Persona p WHERE p.prsNombre = :prsNombre")
    , @NamedQuery(name = "Persona.findByPrsSexo", query = "SELECT p FROM Persona p WHERE p.prsSexo = :prsSexo")
    , @NamedQuery(name = "Persona.findByPrsCorreoPersonal", query = "SELECT p FROM Persona p WHERE p.prsCorreoPersonal = :prsCorreoPersonal")
    , @NamedQuery(name = "Persona.findByPrsCorreoInstitucional", query = "SELECT p FROM Persona p WHERE p.prsCorreoInstitucional = :prsCorreoInstitucional")
    , @NamedQuery(name = "Persona.findByPrsTelefono", query = "SELECT p FROM Persona p WHERE p.prsTelefono = :prsTelefono")
    , @NamedQuery(name = "Persona.findByPrsOrcid", query = "SELECT p FROM Persona p WHERE p.prsOrcid = :prsOrcid")
    , @NamedQuery(name = "Persona.findByPrsFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.prsFechaNacimiento = :prsFechaNacimiento")
    , @NamedQuery(name = "Persona.findByPrsFechaRegistro", query = "SELECT p FROM Persona p WHERE p.prsFechaRegistro = :prsFechaRegistro")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prs_id")
    private Integer prsId;
    @Column(name = "prs_tipo_identifiacion")
    private Integer prsTipoIdentifiacion;
    @Size(max = 20)
    @Column(name = "prs_identifiacion")
    private String prsIdentifiacion;
    @Size(max = 30)
    @Column(name = "prs_primer_apellido")
    private String prsPrimerApellido;
    @Size(max = 30)
    @Column(name = "prs_segundo_apellido")
    private String prsSegundoApellido;
    @Size(max = 30)
    @Column(name = "prs_nombre")
    private String prsNombre;
    @Size(max = 10)
    @Column(name = "prs_sexo")
    private String prsSexo;
    @Size(max = 50)
    @Column(name = "prs_correo_personal")
    private String prsCorreoPersonal;
    @Size(max = 50)
    @Column(name = "prs_correo_institucional")
    private String prsCorreoInstitucional;
    @Size(max = 15)
    @Column(name = "prs_telefono")
    private String prsTelefono;
    @Size(max = 50)
    @Column(name = "prs_orcid")
    private String prsOrcid;
    @Column(name = "prs_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date prsFechaNacimiento;
    @Column(name = "prs_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date prsFechaRegistro;
    @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")
    @ManyToOne(optional = false)
    private Institucion insId;
    @JoinColumn(name = "lclpais_id", referencedColumnName = "lclpais_id")
    @ManyToOne(optional = false)
    private LocalidadPais lclpaisId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Usuario usrId;

    public Persona() {
    }

    public Persona(Integer prsId) {
        this.prsId = prsId;
    }

    public Integer getPrsId() {
        return prsId;
    }

    public void setPrsId(Integer prsId) {
        this.prsId = prsId;
    }

    public Integer getPrsTipoIdentifiacion() {
        return prsTipoIdentifiacion;
    }

    public void setPrsTipoIdentifiacion(Integer prsTipoIdentifiacion) {
        this.prsTipoIdentifiacion = prsTipoIdentifiacion;
    }

    public String getPrsIdentifiacion() {
        return prsIdentifiacion;
    }

    public void setPrsIdentifiacion(String prsIdentifiacion) {
        this.prsIdentifiacion = prsIdentifiacion;
    }

    public String getPrsPrimerApellido() {
        return prsPrimerApellido;
    }

    public void setPrsPrimerApellido(String prsPrimerApellido) {
        this.prsPrimerApellido = prsPrimerApellido;
    }

    public String getPrsSegundoApellido() {
        return prsSegundoApellido;
    }

    public void setPrsSegundoApellido(String prsSegundoApellido) {
        this.prsSegundoApellido = prsSegundoApellido;
    }

    public String getPrsNombre() {
        return prsNombre;
    }

    public void setPrsNombre(String prsNombre) {
        this.prsNombre = prsNombre;
    }

    public String getPrsSexo() {
        return prsSexo;
    }

    public void setPrsSexo(String prsSexo) {
        this.prsSexo = prsSexo;
    }

    public String getPrsCorreoPersonal() {
        return prsCorreoPersonal;
    }

    public void setPrsCorreoPersonal(String prsCorreoPersonal) {
        this.prsCorreoPersonal = prsCorreoPersonal;
    }

    public String getPrsCorreoInstitucional() {
        return prsCorreoInstitucional;
    }

    public void setPrsCorreoInstitucional(String prsCorreoInstitucional) {
        this.prsCorreoInstitucional = prsCorreoInstitucional;
    }

    public String getPrsTelefono() {
        return prsTelefono;
    }

    public void setPrsTelefono(String prsTelefono) {
        this.prsTelefono = prsTelefono;
    }

    public String getPrsOrcid() {
        return prsOrcid;
    }

    public void setPrsOrcid(String prsOrcid) {
        this.prsOrcid = prsOrcid;
    }

    public Date getPrsFechaNacimiento() {
        return prsFechaNacimiento;
    }

    public void setPrsFechaNacimiento(Date prsFechaNacimiento) {
        this.prsFechaNacimiento = prsFechaNacimiento;
    }

    public Date getPrsFechaRegistro() {
        return prsFechaRegistro;
    }

    public void setPrsFechaRegistro(Date prsFechaRegistro) {
        this.prsFechaRegistro = prsFechaRegistro;
    }

    public Institucion getInsId() {
        return insId;
    }

    public void setInsId(Institucion insId) {
        this.insId = insId;
    }

    public LocalidadPais getLclpaisId() {
        return lclpaisId;
    }

    public void setLclpaisId(LocalidadPais lclpaisId) {
        this.lclpaisId = lclpaisId;
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
        hash += (prsId != null ? prsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.prsId == null && other.prsId != null) || (this.prsId != null && !this.prsId.equals(other.prsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Persona[ prsId=" + prsId + " ]";
    }
    
}
