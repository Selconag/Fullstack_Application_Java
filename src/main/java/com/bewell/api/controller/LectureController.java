package com.bewell.api.controller;

import com.bewell.api.entity.Lecture;
import com.bewell.api.entity.User;
import com.bewell.api.service.ILectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture")
public class LectureController {
    private final ILectureService lectureService;

    public LectureController(ILectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLecture(@RequestParam int id) {
        return ResponseEntity.ok(lectureService.getById(id));
    }

    @GetMapping
    ResponseEntity<Page<Lecture>> getLectures(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(lectureService.getAll(PageRequest.of(page, pageSize, Sort.by("id"))));
    }

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture) {
        return ResponseEntity.ok(lectureService.save(lecture));
    }

    @DeleteMapping("/{id}")
    public void deleteLecture(@RequestParam int id) {
        lectureService.delete(id);
        ResponseEntity.ok().build();
    }



}
