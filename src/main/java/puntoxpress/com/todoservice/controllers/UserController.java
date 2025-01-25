package puntoxpress.com.todoservice.controllers;

//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.ResponseListDto;
import puntoxpress.com.todoservice.model.dto.UserBaseDto;
import puntoxpress.com.todoservice.model.dto.UserDto;
import puntoxpress.com.todoservice.model.services.UserService;

@Slf4j
@RestController
//@Tag(name = "Usuarios", description = "APIs relacionadas usuarios")
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> create(@Valid @RequestBody RequestDto<UserDto> request) throws Exception {
        log.info("request - post: {}", request );
        return new ResponseEntity<>(service.add(request), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseDto<UserDto>> get(@Valid @PathVariable String uuid) throws Exception {
        log.info("request - get: {}", uuid );
        return new ResponseEntity<>(service.get(uuid), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseListDto<UserDto>> getAll() throws Exception {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponseDto<UserDto>> update(@Valid @RequestBody RequestDto<UserDto> request, @PathVariable String uuid) throws Exception {
        log.info("request - update: {}", request );
        return new ResponseEntity<>(service.update(request, uuid), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ResponseDto<UserDto>> delete( @PathVariable String uuid) throws Exception {
        return new ResponseEntity<>(service.remove(uuid), HttpStatus.NO_CONTENT);
    }
}
