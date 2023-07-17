package kr.ajousw.myspringweb.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import kr.ajousw.myspringweb.entity.FavoriteMusic;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FavoriteMusicRequestDto {
    private String collectionId;
    private String collectionViewUrl;
     private String collectionType;
     private String artistId;
     private String artistName;
     private String artistViewUrl;
     private String collectionName;
   
     public FavoriteMusic toEntity() {
        FavoriteMusic music = new FavoriteMusic();
        music.setCollectionId(this.collectionId);
        music.setCollectionViewUrl(this.collectionViewUrl);
        music.setCollectionType(this.collectionType);
        music.setArtistId(this.artistId);
        music.setArtistName(this.artistName);
        music.setArtistViewUrl(this.artistViewUrl);
        music.setCollectionName(this.collectionName);
        return music;
    }
}

