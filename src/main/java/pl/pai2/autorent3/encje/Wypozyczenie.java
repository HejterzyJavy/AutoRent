/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pai2.autorent3.encje;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "wypozyczenie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wypozyczenie.findAll", query = "SELECT w FROM Wypozyczenie w"),
    @NamedQuery(name = "Wypozyczenie.findByIdWypozyczenie", query = "SELECT w FROM Wypozyczenie w WHERE w.idWypozyczenie = :idWypozyczenie"),
    @NamedQuery(name = "Wypozyczenie.findByDataWypozyczenia", query = "SELECT w FROM Wypozyczenie w WHERE w.dataWypozyczenia = :dataWypozyczenia"),
    @NamedQuery(name = "Wypozyczenie.findByDataZwrotu", query = "SELECT w FROM Wypozyczenie w WHERE w.dataZwrotu = :dataZwrotu"),
    @NamedQuery(name = "Wypozyczenie.findByKosztCalkowity", query = "SELECT w FROM Wypozyczenie w WHERE w.kosztCalkowity = :kosztCalkowity"),
    @NamedQuery(name = "Wypozyczenie.findByStatus", query = "SELECT w FROM Wypozyczenie w WHERE w.status = :status"),
    @NamedQuery(name = "Wypozyczenie.findByOpis", query = "SELECT w FROM Wypozyczenie w WHERE w.opis = :opis")})
public class Wypozyczenie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wypozyczenie")
    private Integer idWypozyczenie;
    @Column(name = "data_wypozyczenia")
    @Temporal(TemporalType.DATE)
    private Date dataWypozyczenia;
    @Column(name = "data_zwrotu")
    @Temporal(TemporalType.DATE)
    private Date dataZwrotu;
    @Column(name = "koszt_calkowity")
    private Integer kosztCalkowity;
    @Column(name = "status")
    private Integer status;
    @Size(max = 256)
    @Column(name = "opis")
    private String opis;
    @JoinColumn(name = "samochod_id", referencedColumnName = "id_samochod")
    @ManyToOne
    private Samochod samochodId;
    @JoinColumn(name = "pracownik_id", referencedColumnName = "id_pracownik")
    @ManyToOne(optional = false)
    private Pracownik pracownikId;
    @JoinColumn(name = "klient_id", referencedColumnName = "id_klient")
    @ManyToOne(optional = false)
    private Klient klientId;

  

    public Wypozyczenie() {
    }

    public Wypozyczenie(Integer idWypozyczenie) {
        this.idWypozyczenie = idWypozyczenie;
    }

    public Integer getIdWypozyczenie() {
        return idWypozyczenie;
    }

    public void setIdWypozyczenie(Integer idWypozyczenie) {
        this.idWypozyczenie = idWypozyczenie;
    }

    public Date getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(Date dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    public Integer getKosztCalkowity() {
        return kosztCalkowity;
    }

   

    public void setKosztCalkowity(Integer kosztCalkowity) {
        this.kosztCalkowity = kosztCalkowity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Samochod getSamochodId() {
        return samochodId;
    }

    public void setSamochodId(Samochod samochodId) {
        this.samochodId = samochodId;
    }

    public Pracownik getPracownikId() {
        return pracownikId;
    }

    public void setPracownikId(Pracownik pracownikId) {
        this.pracownikId = pracownikId;
    }

    public Klient getKlientId() {
        return klientId;
    }

    public void setKlientId(Klient klientId) {
        this.klientId = klientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWypozyczenie != null ? idWypozyczenie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wypozyczenie)) {
            return false;
        }
        Wypozyczenie other = (Wypozyczenie) object;
        if ((this.idWypozyczenie == null && other.idWypozyczenie != null) || (this.idWypozyczenie != null && !this.idWypozyczenie.equals(other.idWypozyczenie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.Wypozyczenie[ idWypozyczenie=" + idWypozyczenie + " ]";
    }

}
