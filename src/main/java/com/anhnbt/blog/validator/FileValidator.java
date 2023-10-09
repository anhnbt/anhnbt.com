package com.anhnbt.blog.validator;

import com.anhnbt.blog.model.PostDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Component
public class FileValidator implements Validator {

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpg", "image/jpeg", "image/gif","audio/mpeg");
    public static final long TEN_MB_IN_BYTES = 10485760; // 10 MB

    @Override
    public boolean supports(Class<?> clazz) {
        return PostDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MultipartFile file = null;
        if (target instanceof PostDTO) {
            PostDTO postDTO = (PostDTO) target;
            file = postDTO.getThumbnail();
        }
        if (file.isEmpty()) {
            errors.rejectValue("thumbnail", "label.upload.file.required");
        } else if (!contentTypes.contains(file.getContentType())) {
            errors.rejectValue("thumbnail", "label.upload.invalid.file.type");
        } else if (file.getSize() > TEN_MB_IN_BYTES) {
            errors.rejectValue("thumbnail", "label.upload.exceeded.file.size");
        }
    }
}