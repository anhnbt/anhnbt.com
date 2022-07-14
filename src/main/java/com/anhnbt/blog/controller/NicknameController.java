package com.anhnbt.blog.controller;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.model.NicknameDto;
import com.anhnbt.blog.model.ResponseBody;
import com.anhnbt.blog.service.NicknameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nicknames")
public class NicknameController {

    private final NicknameService nicknameService;

    @Autowired
    private ModelMapper modelMapper;

    public NicknameController(NicknameService nicknameService) {
        this.nicknameService = nicknameService;
    }

    @GetMapping
    public ResponseEntity<?> nicknames(@PageableDefault(size = 20) @SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)}) Pageable pageable) {
        Iterable<Nickname> nicknames = nicknameService.findAll(pageable);
        List<NicknameDto> nicknameDtoList = new ArrayList<>();
        nicknames.forEach(nickname -> {
            NicknameDto nicknameDto = modelMapper.map(nickname, NicknameDto.class);
            nicknameDtoList.add(nicknameDto);
        });
        if (nicknameDtoList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(nicknameDtoList, HttpStatus.OK);
        }
    }
}
