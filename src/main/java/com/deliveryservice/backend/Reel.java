package com.deliveryservice.backend;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reels")
public class Reel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "video_url", columnDefinition = "TEXT", nullable = false)
    private String videoUrl;

    @Column(name = "thumbnail_url", columnDefinition = "TEXT")
    private String thumbnailUrl; // ADDED

    private String caption;
    private String hashtags;

    @Column(name = "reel_category")
    private String reelCategory; // ADDED

    @Column(name = "product_category")
    private String productCategory; // ADDED

    @Column(name = "associated_item_id")
    private Integer associatedItemId;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "creator_id")
    private Integer creatorId;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // GETTERS & SETTERS
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

    public String getThumbnailUrl() { return thumbnailUrl; } // ADDED
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; } // ADDED

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }

    public String getHashtags() { return hashtags; } // ADDED
    public void setHashtags(String hashtags) { this.hashtags = hashtags; } // ADDED

    public String getReelCategory() { return reelCategory; } // ADDED
    public void setReelCategory(String reelCategory) { this.reelCategory = reelCategory; } // ADDED

    public String getProductCategory() { return productCategory; } // ADDED
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; } // ADDED

    public Integer getStoreId() { return storeId; }
    public void setStoreId(Integer storeId) { this.storeId = storeId; }

    public Integer getCreatorId() { return creatorId; }
    public void setCreatorId(Integer creatorId) { this.creatorId = creatorId; }
    
    public Integer getAssociatedItemId() { return associatedItemId; } // ADDED
    public void setAssociatedItemId(Integer associatedItemId) { this.associatedItemId = associatedItemId; } // ADDED
}