package com.bewell.api.service.impl;

import com.bewell.api.common.GeneralException;
import com.bewell.api.entity.Lecture;
import com.bewell.api.repository.ILectureRepository;
import com.bewell.api.service.ILectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LectureServiceImpl implements ILectureService {

    private final ILectureRepository lectureRepository;


    public LectureServiceImpl(ILectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture save(Lecture lecture) {
        if (StringUtils.isEmpty(lecture.getName())) {
            throw new GeneralException("Name cannot be empty");
        }
        if (lecture.getTeacher() == null) {
            throw new GeneralException("Teacher cannot be empty");
        }
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture getById(int id) {
        return lectureRepository.findById(id).orElseThrow(() -> new GeneralException("Lecture not found"));
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }

    @Override
    public Page<Lecture> getAll(Pageable pageable) {
        return lectureRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!lectureRepository.existsById(id)) {
            throw new GeneralException("Lecture does not exists");
        }
        lectureRepository.deleteById(id);

    }
}
