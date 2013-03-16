/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bart
 */
@Entity
@Table(name = "winkelwagen", catalog = "mydb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Winkelwagen.findAll", query = "SELECT w FROM Winkelwagen w"),
    @NamedQuery(name = "Winkelwagen.findByIdWinkelwagen", query = "SELECT w FROM Winkelwagen w WHERE w.idWinkelwagen = :idWinkelwagen")})
public class Winkelwagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWinkelwagen")
    private Integer idWinkelwagen;
    @JoinColumn(name = "Product_idProduct", referencedColumnName = "idProduct")
    @ManyToOne(optional = false)
    private Product productidProduct;
    @JoinColumn(name = "gebruiker_idGebruiker", referencedColumnName = "idGebruiker")
    @ManyToOne(optional = false)
    private Gebruiker gebruikeridGebruiker;

    public Winkelwagen() {
    }

    public Winkelwagen(Integer idWinkelwagen) {
        this.idWinkelwagen = idWinkelwagen;
    }

    public Integer getIdWinkelwagen() {
        return idWinkelwagen;
    }

    public void setIdWinkelwagen(Integer idWinkelwagen) {
        this.idWinkelwagen = idWinkelwagen;
    }

    public Product getProductidProduct() {
        return productidProduct;
    }

    public void setProductidProduct(Product productidProduct) {
        this.productidProduct = productidProduct;
    }

    public Gebruiker getGebruikeridGebruiker() {
        return gebruikeridGebruiker;
    }

    public void setGebruikeridGebruiker(Gebruiker gebruikeridGebruiker) {
        this.gebruikeridGebruiker = gebruikeridGebruiker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWinkelwagen != null ? idWinkelwagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Winkelwagen)) {
            return false;
        }
        Winkelwagen other = (Winkelwagen) object;
        if ((this.idWinkelwagen == null && other.idWinkelwagen != null) || (this.idWinkelwagen != null && !this.idWinkelwagen.equals(other.idWinkelwagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Winkelwagen[ idWinkelwagen=" + idWinkelwagen + " ]";
    }
    
}
