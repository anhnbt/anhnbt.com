package com.anhnbt.blog.controller;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.model.ResponseBody;
import com.anhnbt.blog.service.NicknameService;
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

@RestController
@RequestMapping("/nicknames")
public class NicknameController {

    private final NicknameService nicknameService;

    public NicknameController(NicknameService nicknameService) {
        this.nicknameService = nicknameService;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> nicknames(@PageableDefault(size = 20)
                                                      @SortDefault.SortDefaults({
                                                              @SortDefault(sort = "id", direction = Sort.Direction.DESC)
                                                      }) Pageable pageable) {
        Iterable<Nickname> nicknames = nicknameService.findAll(pageable);
        return new ResponseEntity<>(new ResponseBody("00", "success", nicknames), HttpStatus.OK);
    }
}
