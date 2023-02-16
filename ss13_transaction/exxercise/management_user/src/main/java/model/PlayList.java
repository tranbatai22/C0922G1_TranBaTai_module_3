package model;

public class PlayList {
    private int playListId;
    private String nameSong;
    private Singer singer;
    private TypeSong typeSong;

    public PlayList(int playListId, String nameSong, Singer singer, TypeSong typeSong) {
        this.playListId = playListId;
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeSong = typeSong;
    }

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public TypeSong getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(TypeSong typeSong) {
        this.typeSong = typeSong;
    }
}
