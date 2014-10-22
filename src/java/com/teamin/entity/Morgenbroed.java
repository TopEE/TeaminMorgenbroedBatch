/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henrik
 */
@Entity
@Table(name = "MORGENBROED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Morgenbroed.findAll", query = "SELECT m FROM Morgenbroed m"),
    @NamedQuery(name = "Morgenbroed.findByUserId", query = "SELECT m FROM Morgenbroed m WHERE m.userId = :userId"),
    @NamedQuery(name = "Morgenbroed.findByBestilt", query = "SELECT m FROM Morgenbroed m WHERE m.bestilt = :bestilt"),
    @NamedQuery(name = "Morgenbroed.findByBetalt", query = "SELECT m FROM Morgenbroed m WHERE m.betalt = :betalt")})
public class Morgenbroed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BESTILT")
    private int bestilt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETALT")
    private int betalt;

    public Morgenbroed() {
    }

    public Morgenbroed(String userId) {
        this.userId = userId;
    }

    public Morgenbroed(String userId, int bestilt, int betalt) {
        this.userId = userId;
        this.bestilt = bestilt;
        this.betalt = betalt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBestilt() {
        return bestilt;
    }

    public void setBestilt(int bestilt) {
        this.bestilt = bestilt;
    }

    public int getBetalt() {
        return betalt;
    }

    public void setBetalt(int betalt) {
        this.betalt = betalt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Morgenbroed)) {
            return false;
        }
        Morgenbroed other = (Morgenbroed) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teamin.entity.Morgenbroed[ userId=" + userId + " ]";
    }
    
}
