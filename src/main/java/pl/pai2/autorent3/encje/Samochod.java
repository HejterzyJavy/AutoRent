/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.encje;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "samochod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Samochod.findAll", query = "SELECT s FROM Samochod s"),
    @NamedQuery(name = "Samochod.findByIdSamochod", query = "SELECT s FROM Samochod s WHERE s.idSamochod = :idSamochod"),
    @NamedQuery(name = "Samochod.findByNrRejestracji", query = "SELECT s FROM Samochod s WHERE s.nrRejestracji = :nrRejestracji"),
    @NamedQuery(name = "Samochod.findByPrzebieg", query = "SELECT s FROM Samochod s WHERE s.przebieg = :przebieg"),
    @NamedQuery(name = "Samochod.findByDataNastPrzegladu", query = "SELECT s FROM Samochod s WHERE s.dataNastPrzegladu = :dataNastPrzegladu"),
    @NamedQuery(name = "Samochod.findByCenaDoba", query = "SELECT s FROM Samochod s WHERE s.cenaDoba = :cenaDoba"),
    @NamedQuery(name = "Samochod.findByStatus", query = "SELECT s FROM Samochod s WHERE s.status = :status"),
    @NamedQuery(name = "Samochod.findByLokalizacja", query = "SELECT s FROM Samochod s WHERE s.lokalizacja = :lokalizacja"),
    @NamedQuery(name = "Samochod.findByKolor", query = "SELECT s FROM Samochod s WHERE s.kolor = :kolor"),
    @NamedQuery(name = "Samochod.findByPredkoscMax", query = "SELECT s FROM Samochod s WHERE s.predkoscMax = :predkoscMax"),
    @NamedQuery(name = "Samochod.findByTypNadwozia", query = "SELECT s FROM Samochod s WHERE s.typNadwozia = :typNadwozia"),
    @NamedQuery(name = "Samochod.findByRodzajPaliwa", query = "SELECT s FROM Samochod s WHERE s.rodzajPaliwa = :rodzajPaliwa"),
    @NamedQuery(name = "Samochod.findByMocSilnika", query = "SELECT s FROM Samochod s WHERE s.mocSilnika = :mocSilnika")})  

public class Samochod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_samochod")
    private Integer idSamochod;
    @Size(max = 12)
    @Column(name = "nr_rejestracji")
    private String nrRejestracji;
    @Column(name = "przebieg")
    private Integer przebieg;
    @Column(name = "data_nast_przegladu")
    @Temporal(TemporalType.DATE)
    private Date dataNastPrzegladu;
    @Column(name = "cena_doba")
    private Integer cenaDoba;
    @Column(name = "status")
    private Short status;
    @Size(max = 45)
    @Column(name = "lokalizacja")
    private String lokalizacja;
    @Lob
    @Column(name = "zdjecie")
    private byte[] zdjecie;
    @Size(max = 12)
    @Column(name = "kolor")
    private String kolor;
    @Column(name = "predkosc_max")
    private Integer predkoscMax;
    @Column(name = "typ_nadwozia")
    private Integer typNadwozia;
    @Size(max = 20)
    @Column(name = "rodzaj_paliwa")
    private String rodzajPaliwa;
    @Column(name = "moc_silnika")
    private Integer mocSilnika;
    @JoinColumn(name = "id_samochod", referencedColumnName = "id_wyposazenie", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Wyposazenie wyposazenie;
    @JoinColumn(name = "typ_samochodu_id", referencedColumnName = "id_typ_samochodu")
    @ManyToOne(optional = false)
    private TypSamochodu typSamochoduId;
    @JoinColumn(name = "oddzial_id", referencedColumnName = "id_oddzial")
    @ManyToOne(optional = false)
    private Oddzial oddzialId;
    @OneToMany(mappedBy = "samochodId")
    private Collection<Wypozyczenie> wypozyczenieCollection;

    public Samochod() {
    }

    public Samochod(Integer idSamochod) {
        this.idSamochod = idSamochod;
    }

    public Integer getIdSamochod() {
        return idSamochod;
    }

    public void setIdSamochod(Integer idSamochod) {
        this.idSamochod = idSamochod;
    }

    public String getNrRejestracji() {
        return nrRejestracji;
    }

    public void setNrRejestracji(String nrRejestracji) {
        this.nrRejestracji = nrRejestracji;
    }

    public Integer getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(Integer przebieg) {
        this.przebieg = przebieg;
    }

    public Date getDataNastPrzegladu() {
        return dataNastPrzegladu;
    }

    public void setDataNastPrzegladu(Date dataNastPrzegladu) {
        this.dataNastPrzegladu = dataNastPrzegladu;
    }

    public Integer getCenaDoba() {
        return cenaDoba;
    }

    public void setCenaDoba(Integer cenaDoba) {
        this.cenaDoba = cenaDoba;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public byte[] getZdjecie() {
        return zdjecie;
    }
    


    public void setZdjecie(byte[] zdjecie) {
        this.zdjecie = zdjecie;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public Integer getPredkoscMax() {
        return predkoscMax;
    }

    public void setPredkoscMax(Integer predkoscMax) {
        this.predkoscMax = predkoscMax;
    }

    public Integer getTypNadwozia() {
        return typNadwozia;
    }

    public void setTypNadwozia(Integer typNadwozia) {
        this.typNadwozia = typNadwozia;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public Integer getMocSilnika() {
        return mocSilnika;
    }

    public void setMocSilnika(Integer mocSilnika) {
        this.mocSilnika = mocSilnika;
    }

    public Wyposazenie getWyposazenie() {
        return wyposazenie;
    }

    public void setWyposazenie(Wyposazenie wyposazenie) {
        this.wyposazenie = wyposazenie;
    }

    public TypSamochodu getTypSamochoduId() {
        return typSamochoduId;
    }

    public void setTypSamochoduId(TypSamochodu typSamochoduId) {
        this.typSamochoduId = typSamochoduId;
    }

    public Oddzial getOddzialId() {
        return oddzialId;
    }

    public void setOddzialId(Oddzial oddzialId) {
        this.oddzialId = oddzialId;
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
        hash += (idSamochod != null ? idSamochod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Samochod)) {
            return false;
        }
        Samochod other = (Samochod) object;
        if ((this.idSamochod == null && other.idSamochod != null) || (this.idSamochod != null && !this.idSamochod.equals(other.idSamochod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.Samochod[ idSamochod=" + idSamochod + " ]";
    }
    
    
    
}
