package repository.impl;

import model.PlayList;
import model.Singer;
import model.TypeSong;
import repository.BaseRepository;
import repository.IPlayListRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlayListRepository implements IPlayListRepository {
    public static final String FINDALL = "select pll.playlist_id,pll.name_song, ts.name_type, s.name_singer from playlist pll join type_song ts on pll.type_id = ts.type_id join singer s on pll.singer_id = s.singer_id";
    @Override
    public List<PlayList> findAllPlayList() {
        List<PlayList> playLists = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int playListId = resultSet.getInt("playlist_id");
                String nameSong = resultSet.getString("name_song");
                String singerName = resultSet.getString("name_singer");
                String typeName = resultSet.getString("name_type");
                Singer singer = new Singer(singerName);
                TypeSong typeSong = new TypeSong(typeName);
                PlayList playList = new PlayList(playListId, nameSong, singer, typeSong);
                playLists.add(playList);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playLists;
    }
}
