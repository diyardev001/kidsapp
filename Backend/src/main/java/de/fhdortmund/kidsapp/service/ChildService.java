package de.fhdortmund.kidsapp.service;

import de.fhdortmund.kidsapp.model.Child;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ChildService {
    private final ConcurrentHashMap<Long, Child> children = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public ChildService() {
        // Füge einige Beispieldaten hinzu
        createChild(new Child(null, "Max Mustermann", 8, "Dinosaurier, Weltraum", "Fußball, Lesen"));
        createChild(new Child(null, "Anna Schmidt", 7, "Tiere, Musik", "Tanzen, Malen"));
        createChild(new Child(null, "Tom Weber", 9, "Wissenschaft, Computer", "Programmieren, Schach"));
    }

    public Child createChild(Child child) {
        child.setId(idCounter.incrementAndGet());
        children.put(child.getId(), child);
        return child;
    }

    public List<Child> getAllChildren() {
        return new ArrayList<>(children.values());
    }

    public Optional<Child> getChildById(Long id) {
        return Optional.ofNullable(children.get(id));
    }

    public Child updateChild(Long id, Child updatedChild) {
        if (children.containsKey(id)) {
            updatedChild.setId(id);
            children.put(id, updatedChild);
            return updatedChild;
        }
        return null;
    }

    public boolean deleteChild(Long id) {
        return children.remove(id) != null;
    }
}