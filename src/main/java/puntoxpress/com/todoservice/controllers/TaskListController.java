package puntoxpress.com.todoservice.controllers;

//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.services.TaskListService;

@Slf4j
@RestController
//@Tag(name = "Lista de Tareas", description = "API relacionadas a Lista de Tareas")
@RequestMapping("/v1/task-list")
@RequiredArgsConstructor
public class TaskListController {
    private final TaskListService service;

    @PostMapping
    public ResponseEntity<ResponseDto<TaskListDto>> create(Authentication authentication, @Valid @RequestBody RequestDto<TaskListDto> request) throws Exception {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String email = oauth2User.getAttribute("email");
        log.info("user email: {}", email);
        log.info("request - post: {}", request );

        return new ResponseEntity<>(service.add(request), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TaskListDto>> get(@PathVariable String uuid) throws Exception {
        return new ResponseEntity<>(service.get(uuid), HttpStatus.OK);
    }

    @GetMapping("/{uuid}/tasks")
    public ResponseEntity<ResponseListDto<TaskDto>> getByTaskList(@Valid @PathVariable String uuid) throws Exception {
        log.info("request - get: {}", uuid );
        return new ResponseEntity<>(service.getTaskByTaskListUuid(uuid), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseListDto<TaskListDto>> getAll() throws Exception {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TaskListDto>> update(@Valid @RequestBody RequestDto<TaskListDto> request, @PathVariable String uuid) throws Exception {
        log.info("request - update: {}", request );
        return new ResponseEntity<>(service.update(request, uuid), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TaskListDto>> delete( @PathVariable String uuid) throws Exception {
        return new ResponseEntity<>(service.remove(uuid), HttpStatus.NO_CONTENT);
    }
}
