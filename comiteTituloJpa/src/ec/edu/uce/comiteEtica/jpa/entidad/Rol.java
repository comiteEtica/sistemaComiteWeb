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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByRolId", query = "SELECT r FROM Rol r WHERE r.rolId = :rolId")
    , @NamedQuery(name = "Rol.findByRolDescripcion", query = "SELECT r FROM Rol r WHERE r.rolDescripcion = :rolDescripcion")
    , @NamedQuery(name = "Rol.findByRolTipo", query = "SELECT r FROM Rol r WHERE r.rolTipo = :rolTipo")
    , @NamedQuery(name = "Rol.findByRolDetalle", query = "SELECT r FROM Rol r WHERE r.rolDetalle = :rolDetalle")
    , @NamedQuery(name = "Rol.findByRolNivelAcceso", query = "SELECT r FROM Rol r WHERE r.rolNivelAcceso = :rolNivelAcceso")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 100)
    @Column(name = "rol_descripcion")
    private String rolDescripcion;
    @Column(name = "rol_tipo")
    private Integer rolTipo;
    @Size(max = 100)
    @Column(name = "rol_detalle")
    private String rolDetalle;
    @Column(name = "rol_nivel_acceso")
    private Integer rolNivelAcceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<UsuarioRol> usuarioRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<Privilegio> privilegioList;

    public Rol() {
    }

    public Rol(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public Integer getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(Integer rolTipo) {
        this.rolTipo = rolTipo;
    }

    public String getRolDetalle() {
        return rolDetalle;
    }

    public void setRolDetalle(String rolDetalle) {
        this.rolDetalle = rolDetalle;
    }

    public Integer getRolNivelAcceso() {
        return rolNivelAcceso;
    }

    public void setRolNivelAcceso(Integer rolNivelAcceso) {
        this.rolNivelAcceso = rolNivelAcceso;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
    }

    @XmlTransient
    public List<Privilegio> getPrivilegioList() {
        return privilegioList;
    }

    public void setPrivilegioList(List<Privilegio> privilegioList) {
        this.privilegioList = privilegioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Rol[ rolId=" + rolId + " ]";
    }
    
}
