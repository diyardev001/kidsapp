package de.fhdortmund.kidsapp.controller;

import de.fhdortmund.kidsapp.dto.ChildDTO;
import de.fhdortmund.kidsapp.model.Child;
import de.fhdortmund.kidsapp.service.ChildService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/children")
@Tag(name = "Kind", description = "API zur Verwaltung von Kinderinformationen")
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @Operation(summary = "Erstellt ein neues Kind", description = "Erstellt einen neuen Kinderdatensatz mit den angegebenen Informationen")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Kind erfolgreich erstellt"),
        @ApiResponse(responseCode = "400", description = "Ungültige Eingabedaten")
    })
    @PostMapping
    public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO childDTO) {
        Child child = convertToEntity(childDTO);
        Child createdChild = childService.createChild(child);
        return ResponseEntity.ok(convertToDTO(createdChild));
    }

    @Operation(summary = "Ruft alle Kinder ab", description = "Gibt eine Liste aller gespeicherten Kinderdatensätze zurück")
    @ApiResponse(responseCode = "200", description = "Liste aller Kinder erfolgreich abgerufen")
    @GetMapping
    public ResponseEntity<List<ChildDTO>> getAllChildren() {
        List<Child> children = childService.getAllChildren();
        List<ChildDTO> childDTOs = children.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(childDTOs);
    }

    @Operation(summary = "Ruft ein Kind anhand seiner ID ab", description = "Gibt die Details eines spezifischen Kindes zurück")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Kind erfolgreich gefunden"),
        @ApiResponse(responseCode = "404", description = "Kind nicht gefunden")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ChildDTO> getChildById(@Parameter(description = "ID des Kindes") @PathVariable Long id) {
        return childService.getChildById(id)
                .map(child -> ResponseEntity.ok(convertToDTO(child)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Aktualisiert ein Kind", description = "Aktualisiert die Informationen eines existierenden Kindes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Kind erfolgreich aktualisiert"),
        @ApiResponse(responseCode = "404", description = "Kind nicht gefunden"),
        @ApiResponse(responseCode = "400", description = "Ungültige Eingabedaten")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ChildDTO> updateChild(
        @Parameter(description = "ID des zu aktualisierenden Kindes") @PathVariable Long id,
        @RequestBody ChildDTO childDTO) {
        Child child = convertToEntity(childDTO);
        Child updatedChild = childService.updateChild(id, child);
        if (updatedChild != null) {
            return ResponseEntity.ok(convertToDTO(updatedChild));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Löscht ein Kind", description = "Löscht einen Kinderdatensatz anhand seiner ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Kind erfolgreich gelöscht"),
        @ApiResponse(responseCode = "404", description = "Kind nicht gefunden")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChild(@Parameter(description = "ID des zu löschenden Kindes") @PathVariable Long id) {
        if (childService.deleteChild(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ChildDTO convertToDTO(Child child) {
        return new ChildDTO(
                child.getId(),
                child.getName(),
                child.getAge(),
                child.getInterests(),
                child.getHobbies()
        );
    }

    private Child convertToEntity(ChildDTO childDTO) {
        return new Child(
                childDTO.getId(),
                childDTO.getName(),
                childDTO.getAge(),
                childDTO.getInterests(),
                childDTO.getHobbies()
        );
    }
}