package kr.inhatc.spring.model.dto;

import lombok.Data;

@Data
public class FileDTO {
    
    private int idx;
    private long boardIdx;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
}