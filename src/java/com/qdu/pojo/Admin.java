package com.qdu.pojo;
// Generated 2019-1-1 18:49:23 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name="admin"
)
public class Admin  implements java.io.Serializable {


     private String adminId;
     private String adminName;
     private String adminPwd;

    public Admin() {
    }

	
    public Admin(String adminId) {
        this.adminId = adminId;
    }
    public Admin(String adminId, String adminName, String adminPwd) {
       this.adminId = adminId;
       this.adminName = adminName;
       this.adminPwd = adminPwd;
    }
   
     @Id 

    
    @Column(name="adminId", nullable=false)
    public String getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    
    @Column(name="adminName")
    public String getAdminName() {
        return this.adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    
    @Column(name="adminPwd")
    public String getAdminPwd() {
        return this.adminPwd;
    }
    
    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }




}


