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
@Table(name = "log_wypozyczenia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogWypozyczenia.findAll", query = "SELECT l FROM LogWypozyczenia l"),
    @NamedQuery(name = "LogWypozyczenia.findByIdLog", query = "SELECT l FROM LogWypozyczenia l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "LogWypozyczenia.findByAkcja", query = "SELECT l FROM LogWypozyczenia l WHERE l.akcja = :akcja"),
    @NamedQuery(name = "LogWypozyczenia.findByTs", query = "SELECT l FROM LogWypozyczenia l WHERE l.ts = :ts"),
    @NamedQuery(name = "LogWypozyczenia.findByIdPracownik", query = "SELECT l FROM LogWypozyczenia l WHERE l.idPracownik = :idPracownik"),
    @NamedQuery(name = "LogWypozyczenia.findByIdWypozyczenie", query = "SELECT l FROM LogWypozyczenia l WHERE l.idWypozyczenie = :idWypozyczenie"),
    @NamedQuery(name = "LogWypozyczenia.findByStatus", query = "SELECT l FROM LogWypozyczenia l WHERE l.status = :status")})
public class LogWypozyczenia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Integer idLog;
    @Size(max = 7)
    @Column(name = "akcja")
    private String akcja;
    @Column(name = "ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts;
    @Column(name = "id_pracownik")
    private Integer idPracownik;
    @Column(name = "id_wypozyczenie")
    private Integer idWypozyczenie;
    @Column(name = "status")
    private Short status;

    public LogWypozyczenia() {
    }

    public LogWypozyczenia(Integer idLog) {
        this.idLog = idLog;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getAkcja() {
        return akcja;
    }

    public void setAkcja(String akcja) {
        this.akcja = akcja;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getIdPracownik() {
        return idPracownik;
    }

    public void setIdPracownik(Integer idPracownik) {
        this.idPracownik = idPracownik;
    }

    public Integer getIdWypozyczenie() {
        return idWypozyczenie;
    }

    public void setIdWypozyczenie(Integer idWypozyczenie) {
        this.idWypozyczenie = idWypozyczenie;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogWypozyczenia)) {
            return false;
        }
        LogWypozyczenia other = (LogWypozyczenia) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.pai2.autorent3.encje.LogWypozyczenia[ idLog=" + idLog + " ]";
    }
    
}
