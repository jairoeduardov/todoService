package puntoxpress.com.todoservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.services.TaskService;

@Slf4j
@RestController
@Tag(name = "Tareas", description = "API relacionado a las tareas de una lista de tareas")
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService service;

    @PostMapping
    public ResponseEntity<ResponseDto<TaskDto>> create(@Valid @RequestBody RequestDto<TaskDto> request) throws Exception {
        log.info("request - post: {}", request );
        return new ResponseEntity<>(service.add(request), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TaskDto>> get(@Valid @PathVariable String uuid) throws Exception {
        log.info("request - get: {}", uuid );
        return new ResponseEntity<>(service.get(uuid), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseListDto<TaskDto>> getAll() throws Exception {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TaskDto>> update(@Valid @RequestBody RequestDto<TaskDto> request, @PathVariable String uuid) throws Exception {
        log.info("request - update: {}", request );
        return new ResponseEntity<>(service.update(request, uuid), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TaskDto>> delete( @PathVariable String uuid) throws Exception {
        return new ResponseEntity<>(service.remove(uuid), HttpStatus.NO_CONTENT);
    }
}
