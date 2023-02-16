package repository;

import model.PlayList;

import java.util.List;

public interface IPlayListRepository {
    List<PlayList> findAllPlayList();
}
