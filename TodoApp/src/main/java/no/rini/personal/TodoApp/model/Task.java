package no.rini.personal.TodoApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

    @NotNull
    @Id

    private Integer id;
    private String Studentname;
    private String Remarks;

    public Task() {
    }

    public Task(@NotNull Integer id,String studentname,String remarks){
        this.id = id;
        this.Studentname = studentname;
        this.Remarks = remarks;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getStudentname() {return Studentname;}

    public void setStudentname(String studentname) {Studentname = studentname;}

    public String getRemarks() {return Remarks;}

    public void setRemarks(String remarks) {Remarks = remarks;}
}
