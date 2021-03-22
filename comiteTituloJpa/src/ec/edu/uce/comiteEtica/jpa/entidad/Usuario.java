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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsrId", query = "SELECT u FROM Usuario u WHERE u.usrId = :usrId")
    , @NamedQuery(name = "Usuario.findByUsrIdentifiacion", query = "SELECT u FROM Usuario u WHERE u.usrIdentifiacion = :usrIdentifiacion")
    , @NamedQuery(name = "Usuario.findByUsrNick", query = "SELECT u FROM Usuario u WHERE u.usrNick = :usrNick")
    , @NamedQuery(name = "Usuario.findByUsrPassword", query = "SELECT u FROM Usuario u WHERE u.usrPassword = :usrPassword")
    , @NamedQuery(name = "Usuario.findByUsrEstado", query = "SELECT u FROM Usuario u WHERE u.usrEstado = :usrEstado")
    , @NamedQuery(name = "Usuario.findByUsrActiveDirectory", query = "SELECT u FROM Usuario u WHERE u.usrActiveDirectory = :usrActiveDirectory")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer usrId;
    @Size(max = 20)
    @Column(name = "usr_identifiacion")
    private String usrIdentifiacion;
    @Size(max = 100)
    @Column(name = "usr_nick")
    private String usrNick;
    @Size(max = 100)
    @Column(name = "usr_password")
    private String usrPassword;
    @Column(name = "usr_estado")
    private Integer usrEstado;
    @Column(name = "usr_active_directory")
    private Integer usrActiveDirectory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private List<UsuarioRol> usuarioRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private List<Proyecto> proyectoList;

    public Usuario() {
    }

    public Usuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrIdentifiacion() {
        return usrIdentifiacion;
    }

    public void setUsrIdentifiacion(String usrIdentifiacion) {
        this.usrIdentifiacion = usrIdentifiacion;
    }

    public String getUsrNick() {
        return usrNick;
    }

    public void setUsrNick(String usrNick) {
        this.usrNick = usrNick;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Integer getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(Integer usrEstado) {
        this.usrEstado = usrEstado;
    }

    public Integer getUsrActiveDirectory() {
        return usrActiveDirectory;
    }

    public void setUsrActiveDirectory(Integer usrActiveDirectory) {
        this.usrActiveDirectory = usrActiveDirectory;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
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
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Usuario[ usrId=" + usrId + " ]";
    }
    
}
