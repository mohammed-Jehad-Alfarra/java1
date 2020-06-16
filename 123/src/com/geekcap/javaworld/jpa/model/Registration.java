/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekcap.javaworld.jpa.model;

import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "Registration")
public class Registration {
    @id
    @GENAREATEDVALUE
    private String idStd;
    private String idCourse;
    private String smester;
    @hasmanytomany(fetch =fetchtype,student,cascade=cascadetype.past)
    @jointabel(
    name="student",
            joincolmuns={joincolmouns(name'Registration_id')
            inversejoincolmuns={joincolmuns(name'student_id')})

    public Registration() {
    }

    public String getIdStd() {
        return idStd;
    }

    public void setIdStd(String idStd) {
        this.idStd = idStd;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getSmester() {
        return smester;
    }

    public void setSmester(String smester) {
        this.smester = smester;
    }
    
    
}
