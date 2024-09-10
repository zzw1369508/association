package com.zzw.dto;

import com.zzw.entity.Activity;
import com.zzw.entity.File;
import lombok.Data;

import java.util.List;

@Data
public class ActivityFileDto extends Activity{
    private List<File> fileList;
}
