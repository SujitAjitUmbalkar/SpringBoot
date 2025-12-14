package com.marvellous.FirstProject;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class RAM
{
    @GetMapping("/RAM")
    public String GetRAM()
    {
        return "RAM of 8 GB ";
    }
}
