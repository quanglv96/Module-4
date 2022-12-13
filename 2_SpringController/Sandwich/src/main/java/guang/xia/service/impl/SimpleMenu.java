package guang.xia.service.impl;

import guang.xia.model.Menu;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SimpleMenu {
    private static List<Menu> menuList=new ArrayList<>();
    static {
        menuList.add(new Menu(1,"Lettuce",true));
        menuList.add(new Menu(2,"Tomato",true));
        menuList.add(new Menu(3,"Mustard",true));
        menuList.add(new Menu(4,"Sprouts",true));
    }
    public List<Menu> findAll() {
        return menuList;
    }
    public Menu findID(int id){
        return menuList.get(id);
    }
}
