package puntoxpress.com.todoservice.model.services.chains;

@FunctionalInterface
public interface Factory <T, U>{
    T get(U u);
}

