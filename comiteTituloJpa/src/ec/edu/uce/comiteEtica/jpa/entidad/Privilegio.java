package ec.edu.uce.comiteEtica.jpa.entidad;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ebchalcan
 */
@Entity
@Table(name = "privilegio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p")
    , @NamedQuery(name = "Privilegio.findByPrvId", query = "SELECT p FROM Privilegio p WHERE p.prvId = :prvId")})
public class Privilegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prv_id")
    private Integer prvId;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false)
    private Menu menuId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private Rol rolId;

    public Privilegio() {
    }

    public Privilegio(Integer prvId) {
        this.prvId = prvId;
    }

    public Integer getPrvId() {
        return prvId;
    }

    public void setPrvId(Integer prvId) {
        this.prvId = prvId;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prvId != null ? prvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.prvId == null && other.prvId != null) || (this.prvId != null && !this.prvId.equals(other.prvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comiteTituloEjb.Privilegio[ prvId=" + prvId + " ]";
    }
    
}
