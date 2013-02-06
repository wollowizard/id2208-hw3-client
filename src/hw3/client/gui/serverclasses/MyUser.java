/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.client.gui.serverclasses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gerard
 */

@XmlRootElement
public class MyUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String password;
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyUser)) {
            return false;
        }
        MyUser other = (MyUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MyUser[ id=" + id + " ]";
    }
    
}
