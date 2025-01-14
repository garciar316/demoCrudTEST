package com.crud.democrud.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "DESCRIPCION", length = 50, nullable = false)
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rol rol = (Rol) o;
        return idRol != null && Objects.equals(idRol, rol.idRol);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
