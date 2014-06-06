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
@Table(name = "oddzial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oddzial.findAll", query = "SELECT o FROM Oddzial o"),
    @NamedQuery(name = "Oddzial.findByIdOddzial", query = "SELECT o FROM Oddzial o WHERE o.idOddzial = :idOddzial"),
    @NamedQuery(name = "Oddzial.findByLokalizacja", query = "SELECT o FROM Oddzial o WHERE o.lokalizacja = :lokalizacja"),
    @NamedQuery(name = "Oddzial.findByNazwa", query = "SELECT o FROM Oddzial o WHERE o.nazwa = :nazwa")})
public class Oddzial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oddzial")
    private Integer idOddzial;
    @Size(max = 45)
    @Column(name = "lokalizacja")
    private String lokalizacja;
    @Size(max = 45)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oddzialId")
    private Collection<Pracownik> pracownikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oddzialId")
    private Collection<Samochod> samochodCollection;

    public Oddzial() {
    }

    public Oddzial(Integer idOddzial) {
        this.idOddzial = idOddzial;
    }

    public Integer getIdOddzial() {
        return idOddzial;
    }

    public void setIdOddzial(Integer idOddzial) {
        this.idOddzial = idOddzial;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Pracownik> getPracownikCollection() {
        return pracownikCollection;
    }

    public void setPracownikCollection(Collection<Pracownik> pracownikCollection) {
        this.pracownikCollection = pracownikCollection;
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
        hash += (idOddzial != null ? idOddzial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oddzial)) {
            return false;
        }
        Oddzial other = (Oddzial) object;
        if ((this.idOddzial == null && other.idOddzial != null) || (this.idOddzial != null && !this.idOddzial.equals(other.idOddzial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.Oddzial[ idOddzial=" + idOddzial + " ]";
    }
    
}
