package de.fhdortmund.kidsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity representing the deleted status.
 */
@Entity
@Data
public class Geloesecht {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}