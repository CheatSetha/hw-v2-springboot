package co.istad.thymeleafwebapp.services;

import co.istad.thymeleafwebapp.models.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
