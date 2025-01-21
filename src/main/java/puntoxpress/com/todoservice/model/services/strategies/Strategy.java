package puntoxpress.com.todoservice.model.services.strategies;


import puntoxpress.com.todoservice.model.dto.Identifiable;
import puntoxpress.com.todoservice.model.entities.AbstractEntity;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@FunctionalInterface
public interface Strategy <T extends AbstractEntity, D extends Identifiable> {
    void perform(Wrapper<T, D> wrapper) throws Exception;
}