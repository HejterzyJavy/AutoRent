/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.encje;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "typ_samochodu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypSamochodu.findAll", query = "SELECT t FROM TypSamochodu t"),
    @NamedQuery(name = "TypSamochodu.findByIdTypSamochodu", query = "SELECT t FROM TypSamochodu t WHERE t.idTypSamochodu = :idTypSamochodu"),
    @NamedQuery(name = "TypSamochodu.findByMarka", query = "SELECT t FROM TypSamochodu t WHERE t.marka = :marka"),
    @NamedQuery(name = "TypSamochodu.findByModel", query = "SELECT t FROM TypSamochodu t WHERE t.model = :model"),
    @NamedQuery(name = "TypSamochodu.findByRokProd", query = "SELECT t FROM TypSamochodu t WHERE t.rokProd = :rokProd")})
public class TypSamochodu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_typ_samochodu")
    private Integer idTypSamochodu;
    @Size(max = 20)
    @Column(name = "marka")
    private String marka;
    @Size(max = 20)
    @Column(name = "model")
    private String model;
    @Column(name = "rok_prod")
    private Integer rokProd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typSamochoduId")
    private Collection<Samochod> samochodCollection;

    public TypSamochodu() {
    }

    public TypSamochodu(Integer idTypSamochodu) {
        this.idTypSamochodu = idTypSamochodu;
    }

    public Integer getIdTypSamochodu() {
        return idTypSamochodu;
    }

    public void setIdTypSamochodu(Integer idTypSamochodu) {
        this.idTypSamochodu = idTypSamochodu;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRokProd() {
        return rokProd;
    }

    public void setRokProd(Integer rokProd) {
        this.rokProd = rokProd;
    }

    @XmlTransient
    public Collection<Samochod> getSamochodCollection() {
        return samochodCollection;
    }

    public void setSamochodCollection(Collection<Samochod> samochodCollection) {
        this.samochodCollection = samochodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypSamochodu != null ? idTypSamochodu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypSamochodu)) {
            return false;
        }
        TypSamochodu other = (TypSamochodu) object;
        if ((this.idTypSamochodu == null && other.idTypSamochodu != null) || (this.idTypSamochodu != null && !this.idTypSamochodu.equals(other.idTypSamochodu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.TypSamochodu[ idTypSamochodu=" + idTypSamochodu + " ]";
    }
    
}
