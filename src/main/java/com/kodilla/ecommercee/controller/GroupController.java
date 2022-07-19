package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.GroupDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/group")
@AllArgsConstructor
public class GroupController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> addGroup (@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupDto);
    }

    @GetMapping(value= "/{groupId}")
    public ResponseEntity<GroupDto> getGroup (@PathVariable Long groupId) {
        GroupDto groupDto= new GroupDto();
        return ResponseEntity.ok(groupDto);
    }

    @PutMapping(value= "/{groupId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> updateGroup (@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupDto);
    }
}
