import axios from 'axios';

const baseURL = 'http://localhost:8080/api';
axios.create(
    {
        baseURL: baseURL,
        timeout: 1000
    }
)
/**
 * 登录
 * @param user
 * @returns {Promise<any>}
 */
const login = async (user) => {

    try {
        const response = await axios.post(baseURL + '/auth/login', user);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

/**
 * 注册
 * @param user
 * @returns {Promise<any>}
 */
const register = async (user) => {
    try {
        const response = await axios.post(baseURL + '/auth/register', user);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

/**
 *  添加照片
 * @param photo 照片信息
 * @returns {Promise<any>}
 */
const addPhoto = async (photo) => {
    try {
        const response = await axios.post(baseURL + '/photo/addPhoto', photo, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}
/**
 * 获取所有相册分类
 * @returns {Promise<any>} 相册分类列表
 */
const getAllAlbumCategory = async () => {
    try {
        const response = await axios.get(baseURL + '/albumCategory/getAllAlbumCategories');
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

/**
 * 获取所有用户
 * @param adminId 管理员id
 * @returns {Promise<any>} 用户列表
 */
const getAllUsers = async (adminId) => {
    try {
        const response = await axios.post(baseURL + '/admin/findAllUsers', {adminId: adminId}, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

/**
 * 设置用户状态
 * @param userId 用户id
 * @param status 用户状态
 * @returns {Promise<any>}
 */
const setUserStatus = async (userId, status) => {
    try {
        const response = await axios.post(baseURL + '/admin/setUserStatusById', {userId: userId, status: status}, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        return response.data;
    } catch (error) {
        console.log(error);
    }

}

/**
 * 删除用户
 * @param userId 用户id
 * @returns {Promise<any>}
 */
const deleteUser = async (userId) => {
    try {
        const response = await axios.post(baseURL + '/admin/deleteUserById', {userId: userId}, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}
/**
 * 获取某类别下所有相册
 * @param categoryId
 * @returns {Promise<any>}
 */

const getAlbumsByCategoryId = async (categoryId) => {
    try {
        const response = await axios.post(baseURL + '/album/getAllAlbums', {categoryId: categoryId}, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const deleteAlbumCategory = async (categoryId) => {
    try {
        const response = await axios.post(baseURL + '/albumCategory/deleteAlbumCategoryById',
            {categoryId: categoryId}, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const deleteAlbum = async (albumId) => {
    try {
        const response = await axios.post(baseURL + '/album/deleteAlbumById',
            {albumId: albumId}, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const getPhotoByAlbumId = async (albumId) => {
    try {
        const response = await axios.post(baseURL + '/photo/getPhotoByAlbumId',
            {albumId: albumId}, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}


const deletePhoto = async (photoId) => {
    try {
        const response = await axios.post(baseURL + '/photo/deletePhotoById',
            {photoId: photoId}, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const addNewAlbumCategory = async (albumCategoryName) => {
    try {
        const response = await axios.post(baseURL + '/albumCategory/addAlbumCategory', {albumCategoryName: albumCategoryName}, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const addNewAlbum = async (album) => {
    try {
        const response = await axios.post(baseURL + '/album/addAlbum', album, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}


const updateAlbumName = async (albumId, albumName) => {
    try {
        const response = await axios.post(baseURL + '/album/updateAlbumName', {
            albumId: albumId,
            albumName: albumName
        }, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const updatePhotoDescription = async (photoId, photoDescription) => {
    try {
        const response = await axios.post(baseURL + '/photo/updatePhotoDescription', {
            photoId: photoId,
            photoDescription: photoDescription
        }, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

const addComment = async (photoId, comment) => {
    try {
        const response = await axios.post(baseURL + '/comment/addComment', {
                    photoId: photoId,
                    commentContent: comment
                },
                {
                    headers: {
                        'Content-Type':
                            'multipart/form-data'
                    }
                }
            )
        ;
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log(error);
    }
}

export default {
    login,
    register,
    addPhoto,
    getAllAlbumCategory,
    getAllUsers,
    setUserStatus,
    deleteUser,
    getAlbumsByCategoryId,
    deleteAlbumCategory,
    deleteAlbum,
    getPhotoByAlbumId,
    deletePhoto,
    addNewAlbumCategory,
    addNewAlbum,
    updateAlbumName,
    updatePhotoDescription,
    addComment
}

