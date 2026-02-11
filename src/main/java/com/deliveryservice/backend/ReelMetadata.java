package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "reel_metadata")
public class ReelMetadata {
    @Id
    @Column(name = "reel_id")
    private Integer reelId;

    @Column(name = "view_count")
    private Integer viewCount = 0;

    @Column(name = "like_count")
    private Integer likeCount = 0;

    // 1. Mandatory No-Args Constructor for JPA
    public ReelMetadata() {}

    // 2. Setters (Fixes the red lines in Controller)
    public void setReelId(Integer reelId) { this.reelId = reelId; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }
    public void setLikeCount(Integer likeCount) { this.likeCount = likeCount; }

    // 3. Getters
    public Integer getReelId() { return reelId; }
    public Integer getViewCount() { return viewCount; }
    public Integer getLikeCount() { return likeCount; }
}