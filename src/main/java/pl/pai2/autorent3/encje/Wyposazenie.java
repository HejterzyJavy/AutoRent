/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.encje;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karol
 */
@Entity
@Table(name = "wyposazenie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wyposazenie.findAll", query = "SELECT w FROM Wyposazenie w"),
    @NamedQuery(name = "Wyposazenie.findByIdWyposazenie", query = "SELECT w FROM Wyposazenie w WHERE w.idWyposazenie = :idWyposazenie"),
    @NamedQuery(name = "Wyposazenie.findByNaped4x4", query = "SELECT w FROM Wyposazenie w WHERE w.naped4x4 = :naped4x4"),
    @NamedQuery(name = "Wyposazenie.findByCentralnyZamek", query = "SELECT w FROM Wyposazenie w WHERE w.centralnyZamek = :centralnyZamek"),
    @NamedQuery(name = "Wyposazenie.findByCzujnikDeszczu", query = "SELECT w FROM Wyposazenie w WHERE w.czujnikDeszczu = :czujnikDeszczu"),
    @NamedQuery(name = "Wyposazenie.findByCzujnikParkowania", query = "SELECT w FROM Wyposazenie w WHERE w.czujnikParkowania = :czujnikParkowania"),
    @NamedQuery(name = "Wyposazenie.findByElektrLusterka", query = "SELECT w FROM Wyposazenie w WHERE w.elektrLusterka = :elektrLusterka"),
    @NamedQuery(name = "Wyposazenie.findByEleSzyby", query = "SELECT w FROM Wyposazenie w WHERE w.eleSzyby = :eleSzyby"),
    @NamedQuery(name = "Wyposazenie.findByKilmatyzacja", query = "SELECT w FROM Wyposazenie w WHERE w.kilmatyzacja = :kilmatyzacja"),
    @NamedQuery(name = "Wyposazenie.findByKomputerPokladowy", query = "SELECT w FROM Wyposazenie w WHERE w.komputerPokladowy = :komputerPokladowy"),
    @NamedQuery(name = "Wyposazenie.findByPodgrzPrzedSzyba", query = "SELECT w FROM Wyposazenie w WHERE w.podgrzPrzedSzyba = :podgrzPrzedSzyba"),
    @NamedQuery(name = "Wyposazenie.findByPodgrzFotele", query = "SELECT w FROM Wyposazenie w WHERE w.podgrzFotele = :podgrzFotele"),
    @NamedQuery(name = "Wyposazenie.findByRadio", query = "SELECT w FROM Wyposazenie w WHERE w.radio = :radio"),
    @NamedQuery(name = "Wyposazenie.findByNawigacja", query = "SELECT w FROM Wyposazenie w WHERE w.nawigacja = :nawigacja"),
    @NamedQuery(name = "Wyposazenie.findBySkorzanaTapicerka", query = "SELECT w FROM Wyposazenie w WHERE w.skorzanaTapicerka = :skorzanaTapicerka"),
    @NamedQuery(name = "Wyposazenie.findByTempomat", query = "SELECT w FROM Wyposazenie w WHERE w.tempomat = :tempomat"),
    @NamedQuery(name = "Wyposazenie.findByWspKierownicy", query = "SELECT w FROM Wyposazenie w WHERE w.wspKierownicy = :wspKierownicy"),
    @NamedQuery(name = "Wyposazenie.findByAutoAlarm", query = "SELECT w FROM Wyposazenie w WHERE w.autoAlarm = :autoAlarm"),
    @NamedQuery(name = "Wyposazenie.findByEsp", query = "SELECT w FROM Wyposazenie w WHERE w.esp = :esp"),
    @NamedQuery(name = "Wyposazenie.findByPoduszkiPowietrzne", query = "SELECT w FROM Wyposazenie w WHERE w.poduszkiPowietrzne = :poduszkiPowietrzne"),
    @NamedQuery(name = "Wyposazenie.findByAluFelgi", query = "SELECT w FROM Wyposazenie w WHERE w.aluFelgi = :aluFelgi"),
    @NamedQuery(name = "Wyposazenie.findByDodatkowyBagaznik", query = "SELECT w FROM Wyposazenie w WHERE w.dodatkowyBagaznik = :dodatkowyBagaznik"),
    @NamedQuery(name = "Wyposazenie.findByHak", query = "SELECT w FROM Wyposazenie w WHERE w.hak = :hak"),
    @NamedQuery(name = "Wyposazenie.findByKsenony", query = "SELECT w FROM Wyposazenie w WHERE w.ksenony = :ksenony"),
    @NamedQuery(name = "Wyposazenie.findByPrzycSzyby", query = "SELECT w FROM Wyposazenie w WHERE w.przycSzyby = :przycSzyby"),
    @NamedQuery(name = "Wyposazenie.findBySzyberDach", query = "SELECT w FROM Wyposazenie w WHERE w.szyberDach = :szyberDach"),
    @NamedQuery(name = "Wyposazenie.findByAutomatycznaSkrzynia", query = "SELECT w FROM Wyposazenie w WHERE w.automatycznaSkrzynia = :automatycznaSkrzynia"),
    @NamedQuery(name = "Wyposazenie.findByIloscMiejsc", query = "SELECT w FROM Wyposazenie w WHERE w.iloscMiejsc = :iloscMiejsc"),
    @NamedQuery(name = "Wyposazenie.findByIloscPoduszek", query = "SELECT w FROM Wyposazenie w WHERE w.iloscPoduszek = :iloscPoduszek")})
public class Wyposazenie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wyposazenie")
    private Integer idWyposazenie;
    @Column(name = "naped_4x4")
    private Integer naped4x4;
    @Column(name = "centralny_zamek")
    private Integer centralnyZamek;
    @Column(name = "czujnik_deszczu")
    private Integer czujnikDeszczu;
    @Column(name = "czujnik_parkowania")
    private Integer czujnikParkowania;
    @Column(name = "elektr_lusterka")
    private Integer elektrLusterka;
    @Column(name = "eleSzyby")
    private Integer eleSzyby;
    @Column(name = "kilmatyzacja")
    private Integer kilmatyzacja;
    @Column(name = "komputer_pokladowy")
    private Integer komputerPokladowy;
    @Column(name = "podgrz_przed_szyba")
    private Integer podgrzPrzedSzyba;
    @Column(name = "podgrz_fotele")
    private Integer podgrzFotele;
    @Column(name = "radio")
    private Integer radio;
    @Column(name = "nawigacja")
    private Integer nawigacja;
    @Column(name = "skorzana_tapicerka")
    private Integer skorzanaTapicerka;
    @Column(name = "tempomat")
    private Integer tempomat;
    @Column(name = "wsp_kierownicy")
    private Integer wspKierownicy;
    @Column(name = "auto_alarm")
    private Integer autoAlarm;
    @Column(name = "esp")
    private Integer esp;
    @Column(name = "poduszki_powietrzne")
    private Integer poduszkiPowietrzne;
    @Column(name = "aluFelgi")
    private Integer aluFelgi;
    @Column(name = "dodatkowy_bagaznik")
    private Integer dodatkowyBagaznik;
    @Column(name = "hak")
    private Integer hak;
    @Column(name = "ksenony")
    private Integer ksenony;
    @Column(name = "przyc_szyby")
    private Integer przycSzyby;
    @Column(name = "szyber_dach")
    private Integer szyberDach;
    @Column(name = "automatyczna_skrzynia")
    private Integer automatycznaSkrzynia;
    @Column(name = "ilosc_miejsc")
    private Integer iloscMiejsc;
    @Column(name = "ilosc_poduszek")
    private Integer iloscPoduszek;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "wyposazenie")
    private Samochod samochod;

    public Wyposazenie() {
    }

    public Wyposazenie(Integer idWyposazenie) {
        this.idWyposazenie = idWyposazenie;
    }

    public Integer getIdWyposazenie() {
        return idWyposazenie;
    }

    public void setIdWyposazenie(Integer idWyposazenie) {
        this.idWyposazenie = idWyposazenie;
    }

    public Integer getNaped4x4() {
        return naped4x4;
    }

    public void setNaped4x4(Integer naped4x4) {
        this.naped4x4 = naped4x4;
    }

    public Integer getCentralnyZamek() {
        return centralnyZamek;
    }

    public void setCentralnyZamek(Integer centralnyZamek) {
        this.centralnyZamek = centralnyZamek;
    }

    public Integer getCzujnikDeszczu() {
        return czujnikDeszczu;
    }

    public void setCzujnikDeszczu(Integer czujnikDeszczu) {
        this.czujnikDeszczu = czujnikDeszczu;
    }

    public Integer getCzujnikParkowania() {
        return czujnikParkowania;
    }

    public void setCzujnikParkowania(Integer czujnikParkowania) {
        this.czujnikParkowania = czujnikParkowania;
    }

    public Integer getElektrLusterka() {
        return elektrLusterka;
    }

    public void setElektrLusterka(Integer elektrLusterka) {
        this.elektrLusterka = elektrLusterka;
    }

    public Integer getEleSzyby() {
        return eleSzyby;
    }

    public void setEleSzyby(Integer eleSzyby) {
        this.eleSzyby = eleSzyby;
    }

    public Integer getKilmatyzacja() {
        return kilmatyzacja;
    }

    public void setKilmatyzacja(Integer kilmatyzacja) {
        this.kilmatyzacja = kilmatyzacja;
    }

    public Integer getKomputerPokladowy() {
        return komputerPokladowy;
    }

    public void setKomputerPokladowy(Integer komputerPokladowy) {
        this.komputerPokladowy = komputerPokladowy;
    }

    public Integer getPodgrzPrzedSzyba() {
        return podgrzPrzedSzyba;
    }

    public void setPodgrzPrzedSzyba(Integer podgrzPrzedSzyba) {
        this.podgrzPrzedSzyba = podgrzPrzedSzyba;
    }

    public Integer getPodgrzFotele() {
        return podgrzFotele;
    }

    public void setPodgrzFotele(Integer podgrzFotele) {
        this.podgrzFotele = podgrzFotele;
    }

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    public Integer getNawigacja() {
        return nawigacja;
    }

    public void setNawigacja(Integer nawigacja) {
        this.nawigacja = nawigacja;
    }

    public Integer getSkorzanaTapicerka() {
        return skorzanaTapicerka;
    }

    public void setSkorzanaTapicerka(Integer skorzanaTapicerka) {
        this.skorzanaTapicerka = skorzanaTapicerka;
    }

    public Integer getTempomat() {
        return tempomat;
    }

    public void setTempomat(Integer tempomat) {
        this.tempomat = tempomat;
    }

    public Integer getWspKierownicy() {
        return wspKierownicy;
    }

    public void setWspKierownicy(Integer wspKierownicy) {
        this.wspKierownicy = wspKierownicy;
    }

    public Integer getAutoAlarm() {
        return autoAlarm;
    }

    public void setAutoAlarm(Integer autoAlarm) {
        this.autoAlarm = autoAlarm;
    }

    public Integer getEsp() {
        return esp;
    }

    public void setEsp(Integer esp) {
        this.esp = esp;
    }

    public Integer getPoduszkiPowietrzne() {
        return poduszkiPowietrzne;
    }

    public void setPoduszkiPowietrzne(Integer poduszkiPowietrzne) {
        this.poduszkiPowietrzne = poduszkiPowietrzne;
    }

    public Integer getAluFelgi() {
        return aluFelgi;
    }

    public void setAluFelgi(Integer aluFelgi) {
        this.aluFelgi = aluFelgi;
    }

    public Integer getDodatkowyBagaznik() {
        return dodatkowyBagaznik;
    }

    public void setDodatkowyBagaznik(Integer dodatkowyBagaznik) {
        this.dodatkowyBagaznik = dodatkowyBagaznik;
    }

    public Integer getHak() {
        return hak;
    }

    public void setHak(Integer hak) {
        this.hak = hak;
    }

    public Integer getKsenony() {
        return ksenony;
    }

    public void setKsenony(Integer ksenony) {
        this.ksenony = ksenony;
    }

    public Integer getPrzycSzyby() {
        return przycSzyby;
    }

    public void setPrzycSzyby(Integer przycSzyby) {
        this.przycSzyby = przycSzyby;
    }

    public Integer getSzyberDach() {
        return szyberDach;
    }

    public void setSzyberDach(Integer szyberDach) {
        this.szyberDach = szyberDach;
    }

    public Integer getAutomatycznaSkrzynia() {
        return automatycznaSkrzynia;
    }

    public void setAutomatycznaSkrzynia(Integer automatycznaSkrzynia) {
        this.automatycznaSkrzynia = automatycznaSkrzynia;
    }

    public Integer getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(Integer iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public Integer getIloscPoduszek() {
        return iloscPoduszek;
    }

    public void setIloscPoduszek(Integer iloscPoduszek) {
        this.iloscPoduszek = iloscPoduszek;
    }

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWyposazenie != null ? idWyposazenie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wyposazenie)) {
            return false;
        }
        Wyposazenie other = (Wyposazenie) object;
        if ((this.idWyposazenie == null && other.idWyposazenie != null) || (this.idWyposazenie != null && !this.idWyposazenie.equals(other.idWyposazenie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.Wyposazenie[ idWyposazenie=" + idWyposazenie + " ]";
    }
    
}
