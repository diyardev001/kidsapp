package de.fhdortmund.kidsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fhdortmund.kidsapp.model.Veranstaltung;
import de.fhdortmund.kidsapp.service.VeranstaltungService;

/**
 * REST Controller für Veranstaltungs-bezogene Endpunkte.
 */
@RestController
@RequestMapping("/api/veranstaltung")
public class VeranstaltungController {

    @Autowired
    private VeranstaltungService veranstaltungService;

    @GetMapping
    public ResponseEntity<List<Veranstaltung>> getAllVeranstaltungen() {
        List<Veranstaltung> veranstaltungen = veranstaltungService.getAllVeranstaltungen();
        return ResponseEntity.ok(veranstaltungen);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veranstaltung> getVeranstaltungById(@PathVariable Long id) {
        try {
            Veranstaltung veranstaltung = veranstaltungService.getVeranstaltungById(id);
            return ResponseEntity.ok(veranstaltung);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teilnehmer/{teilnehmerId}")
    public ResponseEntity<List<Veranstaltung>> getVeranstaltungenByTeilnehmer(@PathVariable Long teilnehmerId) {
        try {
            List<Veranstaltung> veranstaltungen = veranstaltungService.getVeranstaltungenByTeilnehmer(teilnehmerId);
            return ResponseEntity.ok(veranstaltungen);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeranstaltung(@PathVariable Long id) {
        try {
            veranstaltungService.deleteVeranstaltung(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Veranstaltung> createVeranstaltung(@RequestBody Veranstaltung veranstaltung) {
        try {
            Veranstaltung createdVeranstaltung = veranstaltungService.saveVeranstaltung(veranstaltung);
            return ResponseEntity.ok(createdVeranstaltung);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veranstaltung> updateVeranstaltung(
            @PathVariable Long id,
            @RequestBody Veranstaltung veranstaltung) {
        try {
            veranstaltungService.getVeranstaltungById(id); // Check if exists
            veranstaltung.setId(id);
            return ResponseEntity.ok(veranstaltungService.saveVeranstaltung(veranstaltung));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}