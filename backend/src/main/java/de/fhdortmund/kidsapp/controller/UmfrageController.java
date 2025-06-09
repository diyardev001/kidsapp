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

import de.fhdortmund.kidsapp.model.Umfrage;
import de.fhdortmund.kidsapp.service.UmfrageService;

/**
 * REST Controller für Umfrage-bezogene Endpunkte.
 */
@RestController
@RequestMapping("/api/umfragen")
public class UmfrageController {
    
    @Autowired
    private UmfrageService umfrageService;
    
    @GetMapping
    public ResponseEntity<List<Umfrage>> getAllUmfragen() {
        try {
            List<Umfrage> umfragen = umfrageService.getAllUmfragen();
            return ResponseEntity.ok(umfragen);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Umfrage> getUmfrageById(@PathVariable Long id) {
        try {
            Umfrage umfrage = umfrageService.getUmfrageById(id);
            return ResponseEntity.ok(umfrage);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/ersteller/{erstellerId}")
    public ResponseEntity<List<Umfrage>> getUmfragenByErsteller(@PathVariable Long erstellerId) {
        try {
            List<Umfrage> umfragen = umfrageService.getUmfragenByErsteller(erstellerId);
            return ResponseEntity.ok(umfragen);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Umfrage> createUmfrage(@RequestBody Umfrage umfrage) {
        try {
            Umfrage createdUmfrage = umfrageService.saveUmfrage(umfrage);
            return ResponseEntity.ok(createdUmfrage);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Umfrage> updateUmfrage(
            @PathVariable Long id, 
            @RequestBody Umfrage umfrage) {
        try {
            umfrageService.getUmfrageById(id); // Check if exists
            umfrage.setId(id);
            return ResponseEntity.ok(umfrageService.saveUmfrage(umfrage));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUmfrage(@PathVariable Long id) {
        try {
            umfrageService.deleteUmfrage(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}