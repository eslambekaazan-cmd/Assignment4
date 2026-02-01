package service.impl;

import exception.InvalidInputException;
import exception.ResourceNotFoundException;
import model.RoutineType;
import repository.interfaces.RoutineTypeRepository;
import service.interfaces.CrudService;

import java.util.List;

public class RoutineTypeServiceImpl implements CrudService<RoutineType> {

    private final RoutineTypeRepository repo;

    public RoutineTypeServiceImpl(RoutineTypeRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoutineType create(RoutineType entity) {
        if (entity.getName() == null || entity.getName().isBlank()) {
            throw new InvalidInputException("RoutineType name cannot be empty");
        }
        return repo.create(entity);
    }

    @Override
    public RoutineType getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RoutineType not found: " + id));
    }

    @Override
    public List<RoutineType> getAll() {
        return repo.findAll();
    }

    @Override
    public RoutineType update(RoutineType entity) {
        if (entity.getId() <= 0) {
            throw new InvalidInputException("Invalid RoutineType id");
        }
        return repo.update(entity);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }
}
