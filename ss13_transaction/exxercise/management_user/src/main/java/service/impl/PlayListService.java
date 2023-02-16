package service.impl;

import model.PlayList;
import repository.IPlayListRepository;
import repository.impl.PlayListRepository;
import service.IPlayListService;

import java.util.List;

public class PlayListService implements IPlayListService {
    private IPlayListRepository playListRepository = new PlayListRepository();
    @Override
    public List<PlayList> findAllPlayList() {
        return playListRepository.findAllPlayList();
    }
}
