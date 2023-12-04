const mutations = {
    //选择相册分类
    setSelectedAlbumCategory(state, category) {
        state.selectedAlbumCategory = category;

    },
    // 选中相册
    setSelectedAlbum(state, album) {
        state.selectedAlbum.pid = album.pid;
        state.selectedAlbum.category = album.category;
        state.selectedAlbum.title = album.title;
        state.selectedAlbum.description = album.description;
        state.selectedAlbum.photos = album.photos;
        state.selectedAlbum.cover = album.cover;

    },
    //删除相册
    deleteAlbum(state, album) {
        let index = state.albums.indexOf(album);
        state.albums.splice(index, 1);
    },
    //添加相册
    addAlbum(state, newAlbum) {
        state.albums.push(newAlbum);
    },

    //删除照片
    deletePhoto(state, photo) {
        let index = state.selectedAlbum.photos.indexOf(photo);
        state.selectedAlbum.photos.splice(index, 1);

    },
}

export default mutations;