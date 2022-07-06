package org.example.core.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.example.controllers.utils.json.LocalDateTimeDeserializer;
import org.example.controllers.utils.json.LocalDateTimeSerializer;
import javax.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name ="currencies", schema = "main")
public class Currency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @Column(name = "date_create")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtCreate;

    //  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @Column(name = "date_update")
    @Version
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dtUpdate;
    private String name;
    private String description;
    private String code;

    public Currency() {
    }

    public Currency(Long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, String description, String code) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.description = description;
        this.code = code;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }




}
