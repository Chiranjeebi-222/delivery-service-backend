package com.deliveryservice.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") // 1. ADD THIS to fix CORS errors in your HTML tester
@RestController
@RequestMapping("/gunupur")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 2. ADD THIS: Simple link to see all stores without needing a city ID
    // Browser Link: http://localhost:8081/gunupur/stores
    @GetMapping("/stores")
    public List<Store> getAllStoresNoCity() {
        return storeService.getAllStores(); // Ensure this method exists in StoreService
    }

    @GetMapping("/{cityid}/topcategories")
    public List<TopCategory> getTop(@PathVariable Integer cityid) {
        return storeService.getTopCategoriesByCity(cityid);
    }

    @GetMapping("/{cityid}/adminBanner")
    public List<Banner> getBanners(@PathVariable Integer cityid) {
        return storeService.getBannersByCity(cityid);
    }

    // Browser Link: http://localhost:8081/gunupur/1 (If city ID is 1)
    @GetMapping("/{cityid}")
    public List<Store> getShops(@PathVariable Integer cityid) {
        return storeService.getStoresByCity(cityid);
    }

    @GetMapping("/{cityid}/{sid}/info")
    public Store getInfo(@PathVariable Integer sid) {
        return storeService.getStoreById(sid);
    }

    @GetMapping("/{cityid}/{sid}/phone/items")
    public List<Item> getItems(@PathVariable Integer sid) {
        return storeService.getItemsByStore(sid);
    }

    // --- New Endpoints ---

    @GetMapping("/{cityid}/{sid}/phone/items/{itemid}")
    public Item getItemDetails(@PathVariable Integer itemid) {
        return storeService.getItemById(itemid);
    }

    @GetMapping("/{cityid}/{sid}/phone/items/{itemid}/addons")
    public List<Addon> getAddons(@PathVariable Integer itemid) {
        return storeService.getAddonsByItemId(itemid);
    }
}