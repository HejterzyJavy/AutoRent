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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "klient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klient.findAll", query = "SELECT k FROM Klient k"),
    @NamedQuery(name = "Klient.findByIdKlient", query = "SELECT k FROM Klient k WHERE k.idKlient = :idKlient"),
    @NamedQuery(name = "Klient.findByLogin", query = "SELECT k FROM Klient k WHERE k.login = :login"),
    @NamedQuery(name = "Klient.findByHaslo", query = "SELECT k FROM Klient k WHERE k.haslo = :haslo"),
    @NamedQuery(name = "Klient.findByDoZaplaty", query = "SELECT k FROM Klient k WHERE k.doZaplaty = :doZaplaty")})
public class Klient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_klient")
    private Integer idKlient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "haslo")
    private String haslo;
    @Column(name = "do_zaplaty")
    private Integer doZaplaty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klientId")
    private Collection<Wypozyczenie> wypozyczenieCollection;
    @JoinColumn(name = "id_klient", referencedColumnName = "id_dane_kontaktowe", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DaneKontaktowe daneKontaktowe;

    public Klient() {
    }

    public Klient(Integer idKlient) {
        this.idKlient = idKlient;
    }

    public Klient(Integer idKlient, String login, String haslo) {
        this.idKlient = idKlient;
        this.login = login;
        this.haslo = haslo;
    }

    public Integer getIdKlient() {
        return idKlient;
    }

    public void setIdKlient(Integer idKlient) {
        this.idKlient = idKlient;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Integer getDoZaplaty() {
        return doZaplaty;
    }

    public void setDoZaplaty(Integer doZaplaty) {
        this.doZaplaty = doZaplaty;
    }

    @XmlTransient
    public Collection<Wypozyczenie> getWypozyczenieCollection() {
        return wypozyczenieCollection;
    }

    public void setWypozyczenieCollection(Collection<Wypozyczenie> wypozyczenieCollection) {
        this.wypozyczenieCollection = wypozyczenieCollection;
    }

    public DaneKontaktowe getDaneKontaktowe() {
        return daneKontaktowe;
    }

    public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
        this.daneKontaktowe = daneKontaktowe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlient != null ? idKlient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        if ((this.idKlient == null && other.idKlient != null) || (this.idKlient != null && !this.idKlient.equals(other.idKlient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.Klient[ idKlient=" + idKlient + " ]";
    }
    
}
