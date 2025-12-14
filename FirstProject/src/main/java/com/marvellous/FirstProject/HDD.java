package com.marvellous.FirstProject;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class HDD
{
    @GetMapping("/HDD")
    public String GetHDD()
    {
        return "Hdd of 512 GB ";
    }
}
