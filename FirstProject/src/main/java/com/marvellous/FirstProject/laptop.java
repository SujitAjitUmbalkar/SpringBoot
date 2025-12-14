package com.marvellous.FirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class laptop
{
    public RAM Robj;
    public HDD Hobj;

    public laptop(RAM A , HDD B)
    {
        this.Robj = A;
        this.Hobj = B;
    }

    @GetMapping ("/Laptop")
    public String LaptopInformation()
    {
        String R = Robj.GetRAM();
        String H = Hobj.GetHDD();

        String Data = "Laptop Configuration is "+ R + "& " + H  ;

        return Data;
    }
}
