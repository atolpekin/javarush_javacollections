package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by locuser on 13.03.2017.
 */

@XmlType(name = "Shop")
@XmlRootElement
public class Shop {
    public Goods goods = new Goods();


    public int count;
    public double profit;


    public String[] secretData;

    Shop()
    {

    }


 public static class Goods
{

    public List<String> names;
}
}