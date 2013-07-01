/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.common.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 * The entities use UUID as primary key to avoid extra complexity
 *
 * @author sobranie
 */
@MappedSuperclass
public abstract class UUIDEntity extends BaseEntity {

    @UuidGenerator(name = "UUID_GEN")
    @Id
    @GeneratedValue(generator = "UUID_GEN")
    @Column(name = "ID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
