package puntoxpress.com.todoservice.controllers;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.ResponseListDto;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.services.TagService;

@Slf4j
@RestController
@RequestMapping("/v1/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService service;

    @PostMapping
    public ResponseEntity<ResponseDto<TagDto>> create(@Valid @RequestBody RequestDto<TagDto> request) throws Exception {
        log.info("request - post: {}", request );
        return null;//new ResponseEntity<>(service.add(request), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TagDto>> get(@Valid @PathVariable String uuid) throws Exception {
        log.info("request - get: {}", uuid );
        return new ResponseEntity<>(service.get(uuid), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseListDto<TagDto>> getAll() throws Exception {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TagDto>> update(@Valid @RequestBody RequestDto<TagDto> request, @PathVariable String uuid) throws Exception {
        log.info("request - update: {}", request );
        return null;//new ResponseEntity<>(service.update(request, uuid), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ResponseDto<TagDto>> delete( @PathVariable String uuid) throws Exception {
         return new ResponseEntity<>(service.remove(uuid), HttpStatus.OK);
    }
}
