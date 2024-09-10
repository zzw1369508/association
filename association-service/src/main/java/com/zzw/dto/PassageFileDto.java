package com.zzw.dto;

import com.zzw.entity.File;
import com.zzw.entity.Passage;
import lombok.Data;

import java.util.List;

@Data
public class PassageFileDto extends Passage{
    private List<File> fileList;
}
