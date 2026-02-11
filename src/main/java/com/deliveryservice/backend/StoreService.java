package com.deliveryservice.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {

    @Autowired private StoreRepository storeRepository;
    @Autowired private BannerRepository bannerRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private TopCategoryRepository topCategoryRepository;
    @Autowired private GalleryRepository galleryRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private AddonRepository addonRepository;

    /**
     * FIX FOR ERROR: This method allows the Controller to fetch all stores 
     * without needing a specific city ID.
     */
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public List<Banner> getBannersByCity(Integer cityId) {
        return bannerRepository.findByCityId(cityId);
    }

    public List<TopCategory> getTopCategoriesByCity(Integer cityId) {
        // Ensure your repository uses findByCityid or findByCityId consistently
        return topCategoryRepository.findByCityid(cityId);
    }

    public List<Store> getStoresByCity(Integer cityId) {
        return storeRepository.findByCityId(cityId);
    }

    public Store getStoreById(Integer sid) {
        return storeRepository.findById(sid).orElse(null);
    }

    public List<Gallery> getGalleryByStore(Integer sid) {
        return galleryRepository.findBySid(sid);
    }

    public List<Item> getItemsByStore(Integer sid) {
        return itemRepository.findBySid(sid);
    }

    public Item getItemById(Integer itemid) {
        return itemRepository.findById(itemid).orElse(null);
    }

    public List<Addon> getAddonsByItemId(Integer itemid) {
        return addonRepository.findByItemid(itemid);
    }
}