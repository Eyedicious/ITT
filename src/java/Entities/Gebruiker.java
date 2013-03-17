/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bart
 */
@Entity
@Table(name = "gebruiker", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gebruiker.findAll", query = "SELECT g FROM Gebruiker g"),
    @NamedQuery(name = "Gebruiker.findByIdGebruiker", query = "SELECT g FROM Gebruiker g WHERE g.idGebruiker = :idGebruiker"),
    @NamedQuery(name = "Gebruiker.findByVoornaam", query = "SELECT g FROM Gebruiker g WHERE g.voornaam = :voornaam"),
    @NamedQuery(name = "Gebruiker.findByTussenvoegsel", query = "SELECT g FROM Gebruiker g WHERE g.tussenvoegsel = :tussenvoegsel"),
    @NamedQuery(name = "Gebruiker.findByAchternaam", query = "SELECT g FROM Gebruiker g WHERE g.achternaam = :achternaam"),
    @NamedQuery(name = "Gebruiker.findByEmail", query = "SELECT g FROM Gebruiker g WHERE g.email = :email"),
    @NamedQuery(name = "Gebruiker.findByLogin", query = "SELECT g FROM Gebruiker g WHERE g.login = :login"),
    @NamedQuery(name = "Gebruiker.findByWachtwoord", query = "SELECT g FROM Gebruiker g WHERE g.wachtwoord = :wachtwoord")})
public class Gebruiker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGebruiker")
    private Integer idGebruiker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "voornaam")
    private String voornaam;
    @Size(max = 255)
    @Column(name = "tussenvoegsel")
    private String tussenvoegsel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "achternaam")
    private String achternaam;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebruikeridGebruiker")
    private Collection<Winkelwagen> winkelwagenCollection;

    public Gebruiker() {
    }

    public Gebruiker(Integer idGebruiker) {
        this.idGebruiker = idGebruiker;
    }

    public Gebruiker(Integer idGebruiker, String voornaam, String achternaam, String email, String login, String wachtwoord) {
        this.idGebruiker = idGebruiker;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.login = login;
        this.wachtwoord = wachtwoord;
    }

    public Integer getIdGebruiker() {
        return idGebruiker;
    }

    public void setIdGebruiker(Integer idGebruiker) {
        this.idGebruiker = idGebruiker;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    @XmlTransient
    public Collection<Winkelwagen> getWinkelwagenCollection() {
        return winkelwagenCollection;
    }

    public void setWinkelwagenCollection(Collection<Winkelwagen> winkelwagenCollection) {
        this.winkelwagenCollection = winkelwagenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGebruiker != null ? idGebruiker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebruiker)) {
            return false;
        }
        Gebruiker other = (Gebruiker) object;
        if ((this.idGebruiker == null && other.idGebruiker != null) || (this.idGebruiker != null && !this.idGebruiker.equals(other.idGebruiker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Gebruiker[ idGebruiker=" + idGebruiker + " ]";
    }
    
}
