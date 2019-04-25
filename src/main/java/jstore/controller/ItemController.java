package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController

public class ItemController {
    @RequestMapping("/items")
    public ArrayList<Item> itemList() {
        return DatabaseItem.getItemDatabase();
    }

    @RequestMapping("/items/{id_item}")
    public Item getCust(@PathVariable int id_item) {
        Item item = DatabaseItem.getItemFromId(id_item);
        return item;
    }
}
