package edu.njnu.eamsbe.service.Impl;

import edu.njnu.eamsbe.mapper.AdminMapper;
import edu.njnu.eamsbe.pojo.entity.Album;
import edu.njnu.eamsbe.pojo.entity.Photo;
import edu.njnu.eamsbe.pojo.entity.User;
import edu.njnu.eamsbe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired(required = false)
    private AdminMapper adminMapper;

    @Override
    public List<User> getAllUsers() {
        return adminMapper.findAllUsers();
    }

    @Override
    public List<Album> getAllAlbums(int userId) {
        return adminMapper.findAllAlbums(userId);
    }

    @Override
    public List<Photo> getAllPhotos(int albumId) {
        return adminMapper.findAllPhotos(albumId);
    }

    @Override
    public boolean deleteUserById(int userId) {
        return adminMapper.deleteUserById(userId) > 0;
    }

    @Override
    public boolean disableUserById(int userId) {
        return adminMapper.disableUserById(userId) > 0;
    }
}
