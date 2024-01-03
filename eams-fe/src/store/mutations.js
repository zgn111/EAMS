const mutations = {
    //选择相册分类
    setSelectedAlbumCategory(state, category) {
        state.selectedAlbumCategory = category;
    },
    // 某一类别下的所有相册
    setSelectedAllAlbums(state, album) {
        state.selectedAllAlbums = album

    },
    //某一相册下的所有照片
    setSelectedAlbum(state, album) {
        state.selectedAlbum = album
    },
    //设置当前相册分类
    setCategoryId(state, categoryId) {
        state.categoryId = categoryId;
    },
    //设置当前相册
    setAlbumId(state, albumId) {
        state.albumId = albumId;
    },
    //设置当前相册分类
    setAlbumCategory(state, albumCategory) {
        state.albumCategory = albumCategory;
    },
    //设置当前相册名称
    setAlbumName(state, albumName) {
        state.albumName = albumName;
    },
    //设置当前登录的管理员id
    setAdminId(state, adminId) {
        state.adminId = adminId;
    },
    //设置当前登录的用户id
    setUserId(state, userId) {
        state.userId = userId;
    },
    //管理员选择相册分类
    setAdminSelectAlbumCategory(state, category) {
        state.adminSelectAlbumCategory = category;
    },
    //管理员选择相册
    setAdminSelectAlbum(state, album) {
        state.adminSelectAlbum = album;
    },
}

export default mutations;