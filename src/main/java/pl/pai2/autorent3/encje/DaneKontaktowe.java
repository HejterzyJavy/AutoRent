/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.encje;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "dane_kontaktowe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaneKontaktowe.findAll", query = "SELECT d FROM DaneKontaktowe d"),
    @NamedQuery(name = "DaneKontaktowe.findByIdDaneKontaktowe", query = "SELECT d FROM DaneKontaktowe d WHERE d.idDaneKontaktowe = :idDaneKontaktowe"),
    @NamedQuery(name = "DaneKontaktowe.findByAdres", query = "SELECT d FROM DaneKontaktowe d WHERE d.adres = :adres"),
    @NamedQuery(name = "DaneKontaktowe.findByKodPocztowy", query = "SELECT d FROM DaneKontaktowe d WHERE d.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "DaneKontaktowe.findByTelefon", query = "SELECT d FROM DaneKontaktowe d WHERE d.telefon = :telefon"),
    @NamedQuery(name = "DaneKontaktowe.findByImie", query = "SELECT d FROM DaneKontaktowe d WHERE d.imie = :imie"),
    @NamedQuery(name = "DaneKontaktowe.findByNazwisko", query = "SELECT d FROM DaneKontaktowe d WHERE d.nazwisko = :nazwisko"),
    @NamedQuery(name = "DaneKontaktowe.findByPesel", query = "SELECT d FROM DaneKontaktowe d WHERE d.pesel = :pesel"),
    @NamedQuery(name = "DaneKontaktowe.findByDataRej", query = "SELECT d FROM DaneKontaktowe d WHERE d.dataRej = :dataRej"),
    @NamedQuery(name = "DaneKontaktowe.findByEmail", query = "SELECT d FROM DaneKontaktowe d WHERE d.email = :email")})
public class DaneKontaktowe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dane_kontaktowe")
    private Integer idDaneKontaktowe;
    @Size(max = 45)
    @Column(name = "adres")
    private String adres;
    @Size(max = 8)
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
    @Size(max = 15)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 12)
    @Column(name = "imie")
    private String imie;
    @Size(max = 20)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Size(max = 10)
    @Column(name = "pesel")
    private String pesel;
    @Column(name = "data_rej")
    @Temporal(TemporalType.DATE)
    private Date dataRej;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "daneKontaktowe")
    private Pracownik pracownik;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "daneKontaktowe")
    private Klient klient;

    public DaneKontaktowe() {
    }

    public DaneKontaktowe(Integer idDaneKontaktowe) {
        this.idDaneKontaktowe = idDaneKontaktowe;
    }

    public Integer getIdDaneKontaktowe() {
        return idDaneKontaktowe;
    }

    public void setIdDaneKontaktowe(Integer idDaneKontaktowe) {
        this.idDaneKontaktowe = idDaneKontaktowe;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataRej() {
        return dataRej;
    }

    public void setDataRej(Date dataRej) {
        this.dataRej = dataRej;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDaneKontaktowe != null ? idDaneKontaktowe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaneKontaktowe)) {
            return false;
        }
        DaneKontaktowe other = (DaneKontaktowe) object;
        if ((this.idDaneKontaktowe == null && other.idDaneKontaktowe != null) || (this.idDaneKontaktowe != null && !this.idDaneKontaktowe.equals(other.idDaneKontaktowe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.DaneKontaktowe[ idDaneKontaktowe=" + idDaneKontaktowe + " ]";
    }
    
}
