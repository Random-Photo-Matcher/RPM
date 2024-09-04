package com.rpm.rpm;

import org.springframework.web.multipart.MultipartFile;

public interface ImgStorage {
    public String save(MultipartFile image);
}
