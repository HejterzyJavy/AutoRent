/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.encje;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "pracownik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pracownik.findAll", query = "SELECT p FROM Pracownik p"),
    @NamedQuery(name = "Pracownik.findByIdPracownik", query = "SELECT p FROM Pracownik p WHERE p.idPracownik = :idPracownik"),
    @NamedQuery(name = "Pracownik.findByLogin", query = "SELECT p FROM Pracownik p WHERE p.login = :login"),
    @NamedQuery(name = "Pracownik.findByHaslo", query = "SELECT p FROM Pracownik p WHERE p.haslo = :haslo"),
    @NamedQuery(name = "Pracownik.findByPensja", query = "SELECT p FROM Pracownik p WHERE p.pensja = :pensja"),
    @NamedQuery(name = "Pracownik.findByDataZatrudnienia", query = "SELECT p FROM Pracownik p WHERE p.dataZatrudnienia = :dataZatrudnienia"),
    @NamedQuery(name = "Pracownik.findByDataWygUmowy", query = "SELECT p FROM Pracownik p WHERE p.dataWygUmowy = :dataWygUmowy"),
    @NamedQuery(name = "Pracownik.findByStanowisko", query = "SELECT p FROM Pracownik p WHERE p.stanowisko = :stanowisko")})
public class Pracownik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pracownik")
    private Integer idPracownik;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "pensja")
    private int pensja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_zatrudnienia")
    @Temporal(TemporalType.DATE)
    private Date dataZatrudnienia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_wyg_umowy")
    @Temporal(TemporalType.DATE)
    private Date dataWygUmowy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "stanowisko")
    private String stanowisko;
    @JoinColumn(name = "oddzial_id", referencedColumnName = "id_oddzial")
    @ManyToOne(optional = false)
    private Oddzial oddzialId;
    @JoinColumn(name = "id_pracownik", referencedColumnName = "id_dane_kontaktowe", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DaneKontaktowe daneKontaktowe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracownikId")
    private Collection<Wypozyczenie> wypozyczenieCollection;

    public Pracownik() {
    }

    public Pracownik(Integer idPracownik) {
        this.idPracownik = idPracownik;
    }

    public Pracownik(Integer idPracownik, String login, String haslo, int pensja, Date dataZatrudnienia, Date dataWygUmowy, String stanowisko) {
        this.idPracownik = idPracownik;
        this.login = login;
        this.haslo = haslo;
        this.pensja = pensja;
        this.dataZatrudnienia = dataZatrudnienia;
        this.dataWygUmowy = dataWygUmowy;
        this.stanowisko = stanowisko;
    }

    public Integer getIdPracownik() {
        return idPracownik;
    }

    public void setIdPracownik(Integer idPracownik) {
        this.idPracownik = idPracownik;
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

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public Date getDataWygUmowy() {
        return dataWygUmowy;
    }

    public void setDataWygUmowy(Date dataWygUmowy) {
        this.dataWygUmowy = dataWygUmowy;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Oddzial getOddzialId() {
        return oddzialId;
    }

    public void setOddzialId(Oddzial oddzialId) {
        this.oddzialId = oddzialId;
    }

    public DaneKontaktowe getDaneKontaktowe() {
        return daneKontaktowe;
    }

    public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
        this.daneKontaktowe = daneKontaktowe;
    }

    @XmlTransient
    public Collection<Wypozyczenie> getWypozyczenieCollection() {
        return wypozyczenieCollection;
    }

    public void setWypozyczenieCollection(Collection<Wypozyczenie> wypozyczenieCollection) {
        this.wypozyczenieCollection = wypozyczenieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPracownik != null ? idPracownik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pracownik)) {
            return false;
        }
        Pracownik other = (Pracownik) object;
        if ((this.idPracownik == null && other.idPracownik != null) || (this.idPracownik != null && !this.idPracownik.equals(other.idPracownik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.Pracownik[ idPracownik=" + idPracownik + " ]";
    }
    
}
