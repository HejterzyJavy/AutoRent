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
    private boolean naped4x4;
    @Column(name = "centralny_zamek")
    private boolean centralnyZamek;
    @Column(name = "czujnik_deszczu")
    private boolean czujnikDeszczu;
    @Column(name = "czujnik_parkowania")
    private boolean czujnikParkowania;
    @Column(name = "elektr_lusterka")
    private boolean elektrLusterka;
    @Column(name = "eleSzyby")
    private boolean eleSzyby;
    @Column(name = "kilmatyzacja")
    private boolean kilmatyzacja;
    @Column(name = "komputer_pokladowy")
    private boolean komputerPokladowy;
    @Column(name = "podgrz_przed_szyba")
    private boolean podgrzPrzedSzyba;
    @Column(name = "podgrz_fotele")
    private boolean podgrzFotele;
    @Column(name = "radio")
    private boolean radio;
    @Column(name = "nawigacja")
    private boolean nawigacja;
    @Column(name = "skorzana_tapicerka")
    private boolean skorzanaTapicerka;
    @Column(name = "tempomat")
    private boolean tempomat;
    @Column(name = "wsp_kierownicy")
    private boolean wspKierownicy;
    @Column(name = "auto_alarm")
    private boolean autoAlarm;
    @Column(name = "esp")
    private boolean esp;
    @Column(name = "poduszki_powietrzne")
    private boolean poduszkiPowietrzne;
    @Column(name = "aluFelgi")
    private boolean aluFelgi;
    @Column(name = "dodatkowy_bagaznik")
    private boolean dodatkowyBagaznik;
    @Column(name = "hak")
    private boolean hak;
    @Column(name = "ksenony")
    private boolean ksenony;
    @Column(name = "przyc_szyby")
    private boolean przycSzyby;
    @Column(name = "szyber_dach")
    private boolean szyberDach;
    @Column(name = "automatyczna_skrzynia")
    private boolean automatycznaSkrzynia;
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

    public boolean getNaped4x4() {
        return naped4x4;
    }

    public void setNaped4x4(boolean naped4x4) {
        this.naped4x4 = naped4x4;
    }

    public boolean getCentralnyZamek() {
        return centralnyZamek;
    }

    public void setCentralnyZamek(boolean centralnyZamek) {
        this.centralnyZamek = centralnyZamek;
    }

    public boolean getCzujnikDeszczu() {
        return czujnikDeszczu;
    }

    public void setCzujnikDeszczu(boolean czujnikDeszczu) {
        this.czujnikDeszczu = czujnikDeszczu;
    }

    public boolean getCzujnikParkowania() {
        return czujnikParkowania;
    }

    public void setCzujnikParkowania(boolean czujnikParkowania) {
        this.czujnikParkowania = czujnikParkowania;
    }

    public boolean getElektrLusterka() {
        return elektrLusterka;
    }

    public void setElektrLusterka(boolean elektrLusterka) {
        this.elektrLusterka = elektrLusterka;
    }

    public boolean getEleSzyby() {
        return eleSzyby;
    }

    public void setEleSzyby(boolean eleSzyby) {
        this.eleSzyby = eleSzyby;
    }

    public boolean getKilmatyzacja() {
        return kilmatyzacja;
    }

    public void setKilmatyzacja(boolean kilmatyzacja) {
        this.kilmatyzacja = kilmatyzacja;
    }

    public boolean getKomputerPokladowy() {
        return komputerPokladowy;
    }

    public void setKomputerPokladowy(boolean komputerPokladowy) {
        this.komputerPokladowy = komputerPokladowy;
    }

    public boolean getPodgrzPrzedSzyba() {
        return podgrzPrzedSzyba;
    }

    public void setPodgrzPrzedSzyba(boolean podgrzPrzedSzyba) {
        this.podgrzPrzedSzyba = podgrzPrzedSzyba;
    }

    public boolean getPodgrzFotele() {
        return podgrzFotele;
    }

    public void setPodgrzFotele(boolean podgrzFotele) {
        this.podgrzFotele = podgrzFotele;
    }

    public boolean getRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public boolean getNawigacja() {
        return nawigacja;
    }

    public void setNawigacja(boolean nawigacja) {
        this.nawigacja = nawigacja;
    }

    public boolean getSkorzanaTapicerka() {
        return skorzanaTapicerka;
    }

    public void setSkorzanaTapicerka(boolean skorzanaTapicerka) {
        this.skorzanaTapicerka = skorzanaTapicerka;
    }

    public boolean getTempomat() {
        return tempomat;
    }

    public void setTempomat(boolean tempomat) {
        this.tempomat = tempomat;
    }

    public boolean getWspKierownicy() {
        return wspKierownicy;
    }

    public void setWspKierownicy(boolean wspKierownicy) {
        this.wspKierownicy = wspKierownicy;
    }

    public boolean getAutoAlarm() {
        return autoAlarm;
    }

    public void setAutoAlarm(boolean autoAlarm) {
        this.autoAlarm = autoAlarm;
    }

    public boolean getEsp() {
        return esp;
    }

    public void setEsp(boolean esp) {
        this.esp = esp;
    }

    public boolean getPoduszkiPowietrzne() {
        return poduszkiPowietrzne;
    }

    public void setPoduszkiPowietrzne(boolean poduszkiPowietrzne) {
        this.poduszkiPowietrzne = poduszkiPowietrzne;
    }

    public boolean getAluFelgi() {
        return aluFelgi;
    }

    public void setAluFelgi(boolean aluFelgi) {
        this.aluFelgi = aluFelgi;
    }

    public boolean getDodatkowyBagaznik() {
        return dodatkowyBagaznik;
    }

    public void setDodatkowyBagaznik(boolean dodatkowyBagaznik) {
        this.dodatkowyBagaznik = dodatkowyBagaznik;
    }

    public boolean getHak() {
        return hak;
    }

    public void setHak(boolean hak) {
        this.hak = hak;
    }

    public boolean getKsenony() {
        return ksenony;
    }

    public void setKsenony(boolean ksenony) {
        this.ksenony = ksenony;
    }

    public boolean getPrzycSzyby() {
        return przycSzyby;
    }

    public void setPrzycSzyby(boolean przycSzyby) {
        this.przycSzyby = przycSzyby;
    }

    public boolean getSzyberDach() {
        return szyberDach;
    }

    public void setSzyberDach(boolean szyberDach) {
        this.szyberDach = szyberDach;
    }

    public boolean getAutomatycznaSkrzynia() {
        return automatycznaSkrzynia;
    }

    public void setAutomatycznaSkrzynia(boolean automatycznaSkrzynia) {
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
